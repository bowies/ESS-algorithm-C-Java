import java.util.Arrays;
import java.util.Collections;

public class TestCode {
    public static void main(String[] args) throws Exception {
        int [] a = new int[10]; 
        for(int i : a){
            i = (int)(Math.random()*10);
        }

        //오름차순
        Arrays.sort(a);

        //내림차순 : Stream으로 쉽게 해결할 수 있다. (컬렉션이라 Integer로 사용해야 한다.)
        Integer [] tempA = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Arrays.sort(tempA, Collections.reverseOrder());
        a = Arrays.stream(tempA).mapToInt(i->i).toArray();

        int x, pos, left, right, middle;
        x = a[1];
        pos = -1;
        left = 0;
        right = 9;
        System.out.println("반복 실행 전 x 값 : " + x);
        System.out.println("반복 실행 전 pos 값 : " + pos + " left 값 : " + left + " right 값 : " + right);
    
        while(pos == -1 && left <= right){
            middle = (left+right)/2;
            if(a[middle] == x){
                pos = middle;
            }else if(a[middle] > x){
                right = middle -1;
            }else{
                left = middle + 1;
            }
            System.out.println("반복 실행 중 x 값 : " + x);
            System.out.println("반복 실행 중 pos 값 : " + pos + " left 값 : " + left + " right 값 : " + right);
        }

        System.out.println("pos 값은 " + pos);
    }
}

