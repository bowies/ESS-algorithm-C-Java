public class 팩토리얼 {
    public static int factorial(int n){
        System.out.println("factorial" + n + " 호출");
        if(n==0){
            System.out.println(n+"값이라 1을 반환");
            return 1; //0의 계승이 1이라 1을 반환하고, 여기서 재귀가 끝남
        }else{
            int returnVal = n * factorial(n-1);
            System.out.println(n+"값!  " + returnVal);
            return returnVal; 
        }
    }

    public static void main(String[] args) {
        int ans;
        ans = factorial(5);

        System.out.println(ans);
    }
}
