public class 피보나치수 {
    public static int fibonacci(int n){

        if(n == 0){
            return 0;            
        }else if(n == 1){
            return 1;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        for(int n = 0; n <= 8; n++){
            System.out.print(fibonacci(n) + " ");
        }
    }
}
