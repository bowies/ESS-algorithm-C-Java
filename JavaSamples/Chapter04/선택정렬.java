
public class 선택정렬 {
    public static void printArr(int [] arr){

        for(int i : arr){
            System.out.print(i+"\t");
        }
        System.out.println("");
    }
    public static void main(String[] args) throws Exception {
        int [] a = {90, 34, 78, 12, 56};
        int ins, cmp, min, temp;

        System.out.println("정렬 전 ");
        printArr(a);

        for(ins = 0; ins <a.length-1; ins++){
            int cnt = 1;
            for(cmp = ins+1; cmp < a.length; cmp++){
                
                System.out.print("\t\t" + ins + "번째 " + cnt + "번 실행");
                if(a[cmp] < a[ins]){
                    //왼쪽 요소보다  다음 것이 크면
                    min = cmp;
                    temp = a[ins];
                    a[ins] = a[min];
                    a[min] = temp; 
                
                    System.out.print("에 더 작은 값 " + a[ins] + " 현재 작았던 값 : " + a[min]+"\n");

                }else{
                    System.out.print("\n");
                }
                cnt++;
            }
        }
                
        System.out.println("정렬 후 ");
        printArr(a);

    }
}

