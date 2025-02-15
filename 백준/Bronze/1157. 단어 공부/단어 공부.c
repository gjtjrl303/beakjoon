#include <stdio.h>
#include <string.h>
#include<stdlib.h>
#pragma warning(disable : 4996)

int main() {

	char maxch, s2[1000001];
	int s3[26] = { 0 };
	int max = 0, length = 0;
	scanf("%s", s2);
	length = strlen(s2);
	for (int i = 0; i < length; i++) {
		if ('a' <= s2[i] && s2[i] <= 'z') {
			s2[i] = s2[i] - 'a' + 'A';
		}
	}
	maxch = s2[0];
	for (int i = 0; i < length; i++) {
		s3[s2[i] - 65]++;
	}
	for (int i = 0; i < 26; i++) {
		if (max == s3[i] && s3[i] != 0) {
			maxch = '?';
		}
		else if (max < s3[i]) {
			max = s3[i];
			maxch = i + 'A';
		}
	}
	printf("%c", maxch);
	return 0;
}