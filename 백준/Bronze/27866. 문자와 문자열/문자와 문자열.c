#include <stdio.h>
#include<stdlib.h>
#pragma warning(disable : 4996)

int main() {

	char array[1000];
	int i = 0;
	while(1) {
		scanf("%c", &array[i]);
		if (array[i] == ' ' || array[i] == '\n') {
			break;
		}
		i++;
	}
	scanf("%d", &i);
	printf("%c",array[i - 1]);
	return 0;
}