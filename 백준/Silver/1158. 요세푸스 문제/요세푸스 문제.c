#include<stdio.h>
#pragma warning(disable:4996)

void push(int* queue, int* rear, int data);
int pop(int* queue, int* front);
int empty(int front, int rear);

int main() {
	
	int queue[5002];
	int front = 0, rear = 0;
	int num,N;
	scanf("%d %d", &num, &N);
	for (int i = 1; i <= num; i++) {
		push(queue, &rear, i);
	}

	printf("<");
	while (!empty(front, rear)) {
		for (int i = 0; i < N - 1; i++) {
			push(queue, &rear, pop(queue, &front));
		}
		printf("%d", pop(queue, &front));
		if (!empty(front, rear)) {
			printf(", ");
		}
	}
	printf(">");

	return 0;
}

void push(int* queue, int* rear, int data) {
	*rear = (*rear + 1 + 5002) % 5002;
	queue[*rear] = data;
}

int pop(int* queue, int* front) {
	*front = (*front + 1 + 5002) % 5002;
	return queue[*front];
}

int empty(int front, int rear) {
	return front == rear;
}