
public class 삽입정렬 {
    public static void main(String[] args) throws Exception {
        int [] a = {90, 34, 78, 12, 56};
        int ins, cmp, temp;
        System.out.println("변경 전 a 값");
        
        for(int i : a){
            System.out.print(i+"\t");
        }
        System.out.println("");

        for(ins = 1; ins < 5; ins++){
            temp = a[ins]; //temp에 삽입할 값을 저장한다.
            System.out.println("\t외부 반복문 " + " ins : " + ins + " a[ins] : " + a[ins]);

            for(cmp = ins - 1; cmp >= 0; cmp--){
                
            System.out.println("\t\t내부 반복문 " + " cmp : " + cmp + " a[ins] : " + a[cmp]);
                //cmp 값은 ins 에서 1씩 감소하므로, 1씩 감소시킨다.
                if(a[cmp] > temp){
                    a[cmp+1 ] = a[cmp]; //뒤쪽으로 하나 이동
                }else{
                    //같거나 temp 값이 더 크면 종료
                    break;
                }
            }
            a[cmp+1] = temp; 
        }
        System.out.println("\n\n변경 후 a 값");
        
        for(int i : a){
            System.out.print(i+"\t");
        }
        
                
    }
}

