public class 동적피보나치수 {
    public static int[] fibonacciNumbers = new int[100];


    public static int fibonacci(int n){
        for(int i = 0; i<= n; i++){
            if(i == 0){
                fibonacciNumbers[i] = 0;
            }else if(i == 1){
                fibonacciNumbers[i] = 1;
            }else{
                fibonacciNumbers[i] = fibonacciNumbers[i-1] + fibonacciNumbers[i-2];
            }
        }
        return fibonacciNumbers[n];
    }

    public static void main(String[] args) {
        for(int n = 0; n <= 8; n++){
            System.out.print(fibonacci(n) + " ");
        }
    }
}
