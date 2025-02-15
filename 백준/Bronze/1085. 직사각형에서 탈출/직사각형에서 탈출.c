#include <stdio.h>
#include <string.h>
#include<stdlib.h>
#pragma warning(disable : 4996)

int main() {

	int x, y, w, h, length=1000;
	scanf("%d %d %d %d", &x, &y, &w, &h);
	if (x < length)length = x;
	if (y < length)length = y;
	if (w - x < length)length = w - x;
	if (h - y < length)length = h- y;
	printf("%d", length);
	return 0;
}
