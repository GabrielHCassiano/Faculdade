#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct no {
	int chave;
	struct no *esquerda;
	struct no *direita;
}t_no;

t_no * criar()
{
	t_no * no = (t_no*) malloc(sizeof(t_no));

	if(no)
		no->esquerda = no->direita = NULL;
		no->chave = -1;
		
	return no;
}

t_no *busca (int valor, t_no *arvore){

	while(arvore && arvore->chave != valor){
		arvore = (arvore->chave > valor)?(arvore->esquerda):(arvore->direita);
	}
	
	printf("\n%d", arvore->chave);
	return arvore;
}

int remover(t_no * arvore, int valor)
{
	t_no *no, *pai, *paiAux;
	
	no = criar();
	
	pai = busca(valor, arvore);

	*no = *pai;
	
	if (!pai->esquerda && !pai->direita){
		no = NULL;
		free(pai);
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
}

int main()
{
	t_no * arvore = NULL;
	
	arvore = criar();
	arvore->chave = 3;
	arvore->esquerda = criar();
	arvore->esquerda->chave = 1;
	arvore->direita = criar();
	arvore->direita->chave = 5;
	arvore->direita->direita = criar();
	arvore->direita->direita->chave = 8;
	arvore->direita->direita->direita = criar();
	arvore->direita->direita->direita->chave = 10;

	remover(arvore, 10);
				
	printf("\nRaiz: %d", arvore->chave);
	printf("\nEsq: %d", arvore->esquerda->chave);
	printf("\nDir: %d", arvore->direita->chave);
	printf("\nDir2: %d", arvore->direita->direita->chave);
	printf("\nDir3: %d", arvore->direita->direita->direita->chave);
}
