#include <stdio.h>
#define LENGTH 100

// 피보나치 수를 저장하는 배열(최대 100번째까지)
int fibonacciNumbers[LENGTH];

// 인수 n의 피보나치 수를 반환하는 함수
int fibonacci(int n) {
  // 함수가 호출된 것을 확인
  // printf("fibonacci(%d)가 호출되었습니다.\n", n);

  for (int i = 0; i <= n; i++) {
    if (i == 0) {
      // 0번째 피보나치 수 0을 저장
      fibonacciNumbers[i] = 0;
    }
    else if (i == 1) {
      // 1번째 피보나치 수 1을 저장
      fibonacciNumbers[i] = 1;
    }
    else {
      // 이후의 피보나치 수를 구해 저장
      fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
    }
  }

  // 피보나치 수를 반환
  return fibonacciNumbers[n];
}

// 프로그램 실행의 시작점인 main 함수
int main() {
  // 0~8번째 피보나치 수를 표시
  for (int n = 0; n <= 8; n++) {
    printf("%d, ", fibonacci(n));

    // 함수 호출 회수를 확인할 때 아래 코드의 주석을 해제하고 윗 코드를 주석 처리
    // printf("%d,\n", fibonacci(n));
  }
  printf("\n");

  return 0;
}