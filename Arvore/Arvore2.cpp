#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

typedef struct elementos{
	char nome[100];
}t_elemento;

typedef struct no{
	struct no * esquerda;
	t_elemento dado;
	struct no * direita;
}t_no;

typedef t_no * t_arvore;

void exibirPreOrdem(t_arvore tree)
{
	if(tree != NULL){
		printf("%s ", tree->dado.nome);
		exibirPreOrdem(tree->esquerda);
		exibirPreOrdem(tree->direita);
	}
}

void exibirInOrdem(t_arvore tree)
{
	if(tree != NULL){
		exibirPreOrdem(tree->esquerda);
		printf("%s ", tree->dado.nome);
		exibirPreOrdem(tree->direita);
	}
}

void exibirPosOrdem(t_arvore tree)
{
	if(tree != NULL){
		exibirPreOrdem(tree->esquerda);
		exibirPreOrdem(tree->direita);
		printf("%s ", tree->dado.nome);
	}
}

t_no * criar()
{
	t_no * no = (t_no*) malloc(sizeof(t_no));

	if(no)
		no->esquerda = no->direita = NULL;

	return no;
}

int compara(t_elemento pai, t_elemento filho)
{
	return(strcmp(pai.nome, filho.nome));
}

t_no * busca(t_arvore tree, t_elemento dado)
{
	t_no * achou;
	if(tree == NULL)
		return NULL;
	if(compara(tree->dado, dado) == 0)
		return tree;

	achou = busca(tree->esquerda, dado);
	
	if(achou == NULL)
		achou = busca(tree->direita, dado);

	return achou;
}

int insereRaiz(t_arvore * tree, t_elemento dado)
{
	t_no * novo;
	if(*tree != NULL)
		return 0;
	novo = criar();
	if(novo == NULL)
		return 0;
	novo->dado = dado;
	*tree= novo;
	return 1;
}

int insereDireita(t_arvore tree, t_elemento pai, t_elemento filho)
{
	t_no * f, *p, *novo;
	f = busca(tree,filho);
	if(f != NULL)
		return 0;
		
	p = busca(tree, pai);
	if(p == NULL)
		return 0;
	if(p->direita != NULL) 
		return 0;
	
	novo = criar();
	if(novo == NULL)
		return 0;
	
	novo->dado = filho;
	p->direita = novo;
	return 1;	
}


int insereEsquerda(t_arvore tree, t_elemento pai, t_elemento filho)
{
	t_no * f, *p, *novo;
	f = busca(tree,filho);
	if(f != NULL)
		return 0;
		
	p = busca(tree, pai);
	if(p == NULL)
		return 0;
	if(p->esquerda != NULL) 
		return 0;
	
	novo = criar();
	if(novo == NULL)
		return 0;
	
	novo->dado = filho;
	p->esquerda = novo;
	return 1;	
}

void gotoxy(int x, int y)
{
	COORD coord;
	coord.X = x;
	coord.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
} 

void exibirGraficamente(t_arvore tree, int col, int lin, int desloc)
{
	if(tree == NULL)
		return;
	gotoxy(col, lin);
	printf("%s", tree->dado.nome);
	if(tree->esquerda != NULL)
		exibirGraficamente(tree->esquerda, col-desloc, lin+2, desloc/2+1);
	if(tree->direita!= NULL)
		exibirGraficamente(tree->direita, col+desloc, lin+2, desloc/2+1);
	
}

int inserir (t_arvore * tree, t_elemento dado)
{
	int ok;
	
	if(*tree == NULL)
	{
		*tree = criar();
		if(*tree == NULL)
			return 0;
		(*tree)->dado = dado;
		return 1;
	}
	
	if(compara((*tree)->dado, dado)<0)
		ok = inserir(&((*tree)->direita), dado);
	else
		if(compara((*tree)->dado, dado)>0)
			ok = inserir ((&(*tree)->esquerda), dado);
		else
			ok = 0;
	return ok;
}

void Menu(t_arvore arvore)
{	
	t_elemento dado;	
	int opcao, sim;
		
	system("cls");
	printf("\t---Menu---\n\nInserirRaiz(1)\nInserirDireita(2)\nInserirEsquerda(3)\nExibir Graficamente(4)\n");
	scanf("%d", &opcao);
	switch(opcao)
	{
		case 1:
			system("cls");
			printf("\nRaiz: ");
			scanf("%s", &dado);
			inserir(&arvore, dado);
			printf("\nVoltar Menu(1)");
			scanf("%d", &sim);
			if(sim == 1)
				Menu(arvore);
		case 2:
			exibirInOrdem(arvore);
			printf("\nVoltar Menu(1)");
			scanf("%d", &sim);
			if(sim == 1)
				Menu(arvore);
		case 3:
			exibirPreOrdem(arvore);	
			printf("\nVoltar Menu(1)");
			scanf("%d", &sim);
			if(sim == 1)
				Menu(arvore);
		case 4:
			system("cls");
			exibirGraficamente(arvore, 10, 10, 5);
			printf("\nVoltar Menu(1)");
			scanf("%d", &sim);
			if(sim == 1)
				Menu(arvore);
	}
}

int main(){
	/*t_arvore arvore = NULL;
	t_elemento dado1, dado2, dado3;	
	
	strcpy(dado1.nome, "Luiz");
	
	insereRaiz(&arvore, dado1);
	
	strcpy(dado2.nome, "Ana");
	
	strcpy(dado3.nome, "Kaio");

	if(insereDireita(arvore, dado1, dado2) == 0)
		printf("ERRO");	
	if(insereEsquerda(arvore, dado1, dado3) == 0)
		printf("ERRO");
	
	exibirGraficamente(arvore, 10, 10, 5);*/
	
	//exibirPreOrdem(arvore);
	
	//exibirInOrdem(arvore);
	
	//exibirPosOrdem(arvore);
	
	
	t_arvore arvore = NULL;
	
	Menu(arvore);
	
}
 











