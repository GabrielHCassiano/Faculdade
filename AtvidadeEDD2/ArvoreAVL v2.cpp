#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

typedef struct no {
	int chave;
	int nivel;
	struct no *esquerda;
	struct no *direita;
}t_no;

typedef t_no * t_arvore;

void inserir(t_arvore &arvore, int valor)
{
    if (!arvore) {
        arvore = new t_no;
        arvore->chave = valor;
        arvore->esquerda = NULL;
        arvore->direita = NULL;
    } else {
        if (valor < arvore->chave)
            inserir(arvore->esquerda, valor);
        else
            inserir(arvore->direita, valor);
    }
}


t_no *busca (int valor, t_arvore arvore){

	while(arvore && arvore->chave != valor){
		arvore = (arvore->chave > valor)?(arvore->esquerda):(arvore->direita);
	}
	
	return arvore;
}

int altura (t_arvore arvore)
{
	if (!arvore)
		return -1;
	
	int esquerda, direita;
		
	esquerda = altura(arvore->esquerda);
	direita = altura(arvore->direita);
	
	if (esquerda > direita)
		return 1 + esquerda;
	else
		return 1 + direita;
}

int nivelBalancemento(t_arvore arvore)
{
	return altura(arvore->esquerda) - altura(arvore->direita);
}

void atualizaNivel(t_arvore arvore)
{
    if (arvore) {
        arvore->nivel = nivelBalancemento(arvore);
        atualizaNivel(arvore->esquerda);
        atualizaNivel(arvore->direita);
    }
}

int removerFolha(t_arvore &arvore, int valor)
{
    if (valor < arvore->chave)
        removerFolha(arvore->esquerda, valor);
    else if (valor > arvore->chave)
        removerFolha(arvore->direita, valor);
    else
    {
        t_arvore no = arvore;
        arvore = NULL;
        free(no);
    }
    return 1;
}

int remover(t_arvore * arvore, int valor)
{
	t_no *no, *pai, *paiAux;
	
	no = new t_no;

	pai = busca(valor, *arvore);

	*no = *pai;
	
	if(!arvore)
		return 0;

	if (!pai->esquerda && !pai->direita){
		removerFolha(*arvore, valor);
	}
	else if (!pai->esquerda || !pai->direita){
		if(pai->esquerda)
			*pai = *pai->esquerda;
		else
			*pai = *pai->direita;
		
		free(no);
	}
	else{
		paiAux = pai;
		no = paiAux->direita;
		
		while (no->esquerda){
			paiAux = no;
			no = no->esquerda;
		}
		
		if (paiAux->chave == valor)
            paiAux->direita = no->direita;
        else
            paiAux->esquerda = no->direita;

        pai->chave = no->chave;

        free(no);
	}
	return 1;
}

t_arvore rotacionarEsquerda(t_arvore arvore)
{
    t_arvore temp = arvore;
    t_arvore esquerda = temp->esquerda;

    temp->esquerda = esquerda->direita;
    esquerda->direita = temp;

    return esquerda;
}

t_arvore rotacionarEsquerdaDireita(t_arvore arvore)
{
    t_arvore no = arvore;
    t_arvore esquerda = no->esquerda;
    t_arvore direita = esquerda->direita;

    no->esquerda = direita->direita;
    esquerda->direita = direita->esquerda;
    direita->esquerda = esquerda;
    direita->direita = no;

    return direita;
}

t_arvore rotacionarDireitaEsquerda(t_arvore arvore)
{
    t_arvore no = arvore;
    t_arvore direita = no->direita;
    t_arvore esquerda = direita->esquerda;

    no->direita = esquerda->esquerda;
    direita->esquerda = esquerda->direita;
    esquerda->direita = direita;
    esquerda->esquerda = no;

    return esquerda;
}

t_arvore rotacionarDireita(t_arvore arvore)
{
    t_arvore no = arvore;
    t_arvore direita = no->direita;

    no->direita = direita->esquerda;
    direita->esquerda = no;

    return direita;
}

t_no * balancear(t_no * arvore)
{
	t_no * balanceado = NULL;	
	int nivel = arvore->nivel;
	
	if(!arvore)
		return NULL;
	
	if (arvore->esquerda)
		arvore->esquerda = balancear(arvore->esquerda);
		
	if (arvore->direita)
		arvore->direita = balancear(arvore->direita);
	
	if (nivel >= 2){
		if (arvore->esquerda->nivel <= -1)
			balanceado = rotacionarEsquerdaDireita(arvore);
		else
			balanceado = rotacionarEsquerda(arvore);
	} else if (nivel <= -2) {
		if (arvore->direita->nivel >= 1)
			balanceado = rotacionarDireitaEsquerda(arvore);
		else
			balanceado = rotacionarDireita(arvore);
	} else {
		balanceado = arvore;
	}
			
	return balanceado;
}

void gotoxy(int x, int y)
{
	COORD coord;
	coord.X = x;
	coord.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
} 

void exibirGraficamente(t_arvore arvore, int col, int lin, int desloc)
{
    if (arvore == NULL)
        return;

    gotoxy(col,lin);

    printf("%d",arvore->chave);

    if (arvore->esquerda != NULL)
        exibirGraficamente(arvore->esquerda,col-desloc,lin+2,desloc/2+1);

    if (arvore->direita != NULL)
        exibirGraficamente(arvore->direita,col+desloc,lin+2,desloc/2+1);
}

void inserirDados(t_arvore &arvore, int valor)
{
	inserir(arvore, valor);
	atualizaNivel(arvore);
	arvore = balancear(arvore);
	atualizaNivel(arvore);
}

void removerDados(t_arvore &arvore, int valor)
{
	remover(&arvore, valor);
	atualizaNivel(arvore);
	arvore = balancear(arvore);
	atualizaNivel(arvore);
}

int main()
{
	t_no * arvore = NULL;
		
	inserirDados(arvore, 5);
	inserirDados(arvore, 1);
	inserirDados(arvore, 10);
	inserirDados(arvore, 7);
	inserirDados(arvore, 8);
	inserirDados(arvore, 77);
	
	exibirGraficamente(arvore, 20, 2, 10);

	removerDados(arvore, 10);
	
	exibirGraficamente(arvore, 20, 10, 10);
	
}
