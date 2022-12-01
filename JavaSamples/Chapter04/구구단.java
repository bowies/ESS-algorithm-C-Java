
public class 구구단 {
    public static void main(String[] args) throws Exception {
        int step, num;
        for(step = 1; step <= 9; step++){
            System.out.print(step+"단");
            for(num = 1; num <=9; num++){
                System.out.print("\t"+num*step);
            }
            System.out.println("");
        }
                
                
    }
}

