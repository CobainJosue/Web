/*Programa que lea 10 cadenas ingresadas por el usuario y les guarde en un arreglo void por medio de 
sus referencias. El programa deberá permitir listar las cadenas, reordenar el contenido de su orden en 
ASCII (qsort()), sobreescribir y borrar algun registro. El programa debe liberar toda la memoria que utilice.
Extra: menu */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int menu();
void listar(void **cadenas);
void reordenar(void **cadenas);
void sobreescribir(void **cadenas);
void borrar(void **cadenas);
void ingresar(void **cadenas);

int compare(const void *_a, const void *_b) {
 
        int *a, *b;
        
        a = (int *) _a;
        b = (int *) _b;
        
        return (*a - *b);
}

int main(){

	void **cadenas;
	int opcion;

	cadenas = calloc(10,sizeof(void*));

	for (int i = 0; i < 10; i++){
		cadenas[i] = calloc(50,sizeof(void));
	}

	printf("\n");

	do{

	opcion = menu();

	switch(opcion){
		case 1:
			ingresar(cadenas);
		break;
		case 2:
			listar(cadenas);
		break;
		case 3:
			reordenar(cadenas);
		break;
		case 4:
			sobreescribir(cadenas);
		break;
		case 5:
			borrar(cadenas);
		break;
		default:
		break;
	}

	}while(opcion != 6);

	for (int i = 0; i < 10; i++){
		free(cadenas[i]);
	}
	free(cadenas);

	return EXIT_SUCCESS;
}

void reordenar(void **cadenas){
	//qsort(cadenas, 10, sizeof(char*), &compare);
	void *aux;
	aux = calloc(50, sizeof(void));
	for(int i = 0; i < 10; i++){
		for(int j = i+1; j < 10; j++)
			if(strcmp(((char*)cadenas[i]) , ((char*)cadenas[j])) > 0){
				aux = cadenas[i];
				cadenas[i] = cadenas[j];
				cadenas[j] = aux;
			}
	}
}

void sobreescribir(void **cadenas){
	int opcion = 0;
	printf("¿numero de la cadena a sobreescribir? ");
	scanf("%d", &opcion);
	getchar();
	printf("Ingresa mensaje: \n");
	gets(cadenas[opcion]); 
}
void borrar(void **cadenas){
	int opcion = 0;
	printf("Numero de la cadena a borrar: \n");
	scanf("%d", &opcion);
	cadenas[opcion] = "";
}

void listar(void **cadenas){
	for(int i = 0; i < 10; i++){
		printf("Cadena %d : %s\n", i, (char*)cadenas[i]);
	}
}

void ingresar(void **cadenas){
	for(int i = 0; i < 10; i++){
		printf("Cadena %d : \n", i);
		gets(cadenas[i]);
	}
}

int menu(){
	int opcion = 0;

	printf("\t1.-Ingresar cadenas.\n");
	printf("\t2.-Listar cadenas.\n");
	printf("\t3.-Reordenar.\n");
	printf("\t4.-Sobreescribir.\n");
	printf("\t5.-Borrar.\n");
	printf("\t6.-Salir.\n");
	printf("Opcion: ");
	scanf("%d", &opcion);
	getchar();
	return opcion;
}