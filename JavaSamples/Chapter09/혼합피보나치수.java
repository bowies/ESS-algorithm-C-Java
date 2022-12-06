public class 혼합피보나치수 {
    public static int[] fibonacciNumbers = new int[100];

    public static void initFibonacciNumbers(){
        for(int i = 0; i < fibonacciNumbers.length; i++){
            fibonacciNumbers[i] = -1;
        }
    }


    public static int fibonacci(int n){
        
        System.out.println("피보나치 " + n +" 이 호출되었습니다.");

        if(fibonacciNumbers[n] == -1){
            if(n == 0){
                fibonacciNumbers[n] = 0;
            }else if(n == 1){
                fibonacciNumbers[n] = 1;
            }else{
                fibonacciNumbers[n] = fibonacci(n-1) + fibonacci(n-2);
            }
        }
        return fibonacciNumbers[n];
    }

    public static void main(String[] args) {
        initFibonacciNumbers();

        System.out.println(fibonacci(5));
    }
}
