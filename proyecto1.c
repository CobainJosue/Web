#include <stdio.h>
#include <stdlib.h>

void multiplicar(int m1[], float m2[], double m3[][4]);

int main(int argc, char const *argv[]){

	int m1[4] = {atoi(argv[1]),atoi(argv[2]),atoi(argv[3]),atoi(argv[4])};
	float m2[4] = {atof(argv[5]),atof(argv[6]),atof(argv[7]),atof(argv[8])};
	double m3[4][4];

	(argc == 9) ? multiplicar(m1,m2,m3) : printf("Numero de argumentos incorrecto >:v\n");;

	return EXIT_SUCCESS;
}

void multiplicar(int m1[], float m2[], double m3[][4]){

	//double m3[4][1];
	printf("Matriz 1:\n");
	for (int i = 0; i < 4; i++){
		printf(" | %d |\n", m1[i]);
	}
	printf("Matriz 2:\n |");
	for (int i = 0; i < 4; i++){
		printf(" %f  ", m2[i]);
	}
	printf(" |\n\n\n");

	for (int i = 0; i < 4; i++){
		for(int j = 0; j < 4; j++)
		m3[i][j] = (double)m1[i] * (double)m2[j];
	}
	printf("Matriz resultante:\n");
	for (int i = 0; i < 4; i++){
		for(int j = 0; j < 4; j++)
			printf("%f\t", m3[i][j]);
		printf("\n");
	}

	return;
}