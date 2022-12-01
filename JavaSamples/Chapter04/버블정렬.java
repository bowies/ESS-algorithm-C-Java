
public class 버블정렬 {

    public static void printArr(int [] arr){

        for(int i : arr){
            System.out.print(i+"\t");
        }
        System.out.println("");
    }

    public static void main(String[] args) throws Exception {
        int [] a = {90, 34, 78, 12, 56};
        int ins, cmp, temp;
        System.out.println("정렬 전");
        printArr(a);


        for(ins = 0; ins <a.length -1; ins++){
            for(cmp = 0; cmp < a.length - ins - 1; cmp++){
                if(a[cmp] > a[cmp+1]){
                    //다음 요소가 더 작으면 위치 변경
                    System.out.println("\t위치 변경 : " + a[cmp] + " 와 " + a[cmp+1]);

                    temp = a[cmp];
                    a[cmp] = a[cmp+1];
                    a[cmp+1] = temp;
                }
            }
        }   
        System.err.println("정렬 후 ");
        printArr(a);
                
    }
}

