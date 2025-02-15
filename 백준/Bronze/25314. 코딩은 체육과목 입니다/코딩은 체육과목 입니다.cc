#include <stdio.h>
#pragma warning(disable : 4996)
 
int main() {
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N / 4; i++) {
		printf("long ");
	}
	printf("int");
	
	return 0;
}