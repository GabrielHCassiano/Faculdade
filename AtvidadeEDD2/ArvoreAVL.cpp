#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Creditos: willianrschuck || https://gist.github.com/willianrschuck/db43f89dbbbe9f887f805e3def11207f

typedef struct no {
	int chave;
	int nivel;
	struct no *esquerda;
	struct no *direita;
}t_no;

typedef t_no * t_arvore;

t_no * criar()
{
	t_no * no = (t_no*) malloc(sizeof(t_no));

	if(no)
		no->esquerda = no->direita = NULL;
		no->chave = -1;
		
	return no;
}

int inserir (t_arvore * arvore, int chave)
{
	int ok;
	
	if(*arvore == NULL)
	{
		*arvore = criar();
		if(*arvore == NULL)
			return 0;
		(*arvore)->chave = chave;
		return 1;
	}
	
	if(chave > (*arvore)->chave)
		ok = inserir(&((*arvore)->direita), chave);
	else
		if(chave < (*arvore)->chave)
			ok = inserir ((&(*arvore)->esquerda), chave);
		else
			ok = 0;
	return ok;
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
	
	no = criar();

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

t_no * rotacionarEsquerda(t_arvore arvore)
{
	t_no * p_no = arvore;
	t_no * esquerda = p_no->esquerda;
		
	p_no->esquerda = esquerda->direita;
	esquerda->direita = p_no;
	
	return esquerda;
}

t_no * rotacionarEsquerdaDireita(t_arvore arvore)
{
	t_no * p_no = arvore;
	t_no * esquerda = p_no->esquerda;
	t_no * direita = esquerda->direita;	
		
	*p_no->esquerda = *direita->direita;
	esquerda->direita = direita->esquerda;
	direita->esquerda = esquerda;
	direita->direita = p_no;
	return direita;
}

t_no * rotacionarDireita(t_arvore arvore)
{
	t_no * p_no = arvore;
	t_no * direita = p_no->direita;
		
	p_no->direita = direita->esquerda;
	direita->esquerda = p_no;
	
	return direita;
}

t_no * rotacionarDireitaEsquerda(t_arvore arvore)
{
	t_no * p_no = arvore;
	t_no * direita = p_no->direita;
	t_no * esquerda = direita->esquerda;
		
	p_no->direita = esquerda->esquerda;
	direita->esquerda = direita->esquerda;
	esquerda->direita = direita;
	esquerda->esquerda = p_no;
	
	return esquerda;
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

int main()
{
	t_no * arvore = NULL;

	inserir(&arvore, 3);
	atualizaNivel(arvore);
	arvore = balancear(arvore);
	atualizaNivel(arvore);
	inserir(&arvore, 1);
	atualizaNivel(arvore);
	arvore = balancear(arvore);
	atualizaNivel(arvore);
	inserir(&arvore, 5);
	atualizaNivel(arvore);
	arvore = balancear(arvore);
	atualizaNivel(arvore);
	inserir(&arvore, 8);
	atualizaNivel(arvore);
	arvore = balancear(arvore);
	atualizaNivel(arvore);
	inserir(&arvore, 10);
	atualizaNivel(arvore);
	arvore = balancear(arvore);
	atualizaNivel(arvore);
	
	if(remover(&arvore, 10)) {
		printf("Valor removido");
		atualizaNivel(arvore);
		arvore = balancear(arvore);
		atualizaNivel(arvore);
	}
	
	if(arvore)
		printf("\nRaiz: %d", arvore->chave);
	if(arvore->esquerda)
		printf("\nEsquerda: %d", arvore->esquerda->chave);
	if(arvore->esquerda->esquerda)
		printf("\nEsquerdaEsquerda: %d", arvore->esquerda->esquerda->chave);
	if(arvore->esquerda->direita)
		printf("\nEsquerdaDireita: %d", arvore->esquerda->direita->chave);
	if(arvore->direita)
		printf("\nDireita: %d", arvore->direita->chave);
	if(arvore->direita->direita)
		printf("\nDireitaDireita: %d", arvore->direita->direita->chave);
	if(arvore->direita->esquerda)
		printf("\nDireitaEsquerda: %d", arvore->direita->esquerda->chave);
	if(arvore->direita->direita->direita)
		printf("\nDireitaDireitaDireita: %d", arvore->direita->direita->direita->chave);
	
}
