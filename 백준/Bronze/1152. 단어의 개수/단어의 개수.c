#include <stdio.h>
#include <string.h>
#include<stdlib.h>
#pragma warning(disable : 4996)

int main() {

	char str[1000000];
	int count = 0, flag = 0;
	gets(str);
	for (int i = 0; i < strlen(str); i++) {
		if (flag == 0 && str[i] != ' ') {
			count++;
		}
		flag = 1;
		if (str[i] == ' ') {
			flag = 0;
		}
	}
	printf("%d", count);
	

	return 0;
}