public class 퀵정렬 {
    public static void printArray(int [] a){
        for(int i : a){
            System.out.print("[" + i + "] ");
        }
        System.out.println("배열 인쇄 끝");
    }
    public static void sortArray(int [] a, int start, int end){
        System.out.println("sortArray 호출 head 값 : " + start + " end 값 : " + end);
        printArray(a);
        int pivot;

        if(start < end){
            //기준값 대소 관계에 따라 그룹 나누기
            pivot = divideArray(a, start, end);
            System.out.println(pivot + " 기준값 ");

            sortArray(a, start, pivot-1); //기준값보다 <<<
            sortArray(a, pivot+1, end); // 기준값보다 >>> (끝까지)
        }
    }
    private static int divideArray(int[] a, int head, int tail) {
        System.out.println("divideArray 호출 head 값 : " + head + " tail 값 : " + tail);
        int left, right, temp;
        left = head+1; //첫요소 +1부터 뒤까지 >>>
        right = tail; //끝 -> 앞까지 <<<

        //기준값 a[head]보다 작은 요소를 <<< 큰 요소를 >>>
        while(true){
            while(left < tail && a[head] > a[left]){
                //첫요소 +1 부터 >>>> 으로 이동
                left++; 
            }

            while(a[head] < a[right]){
                //끝 -> 앞으로 가다가 기준값보다 작은 요소 찾기
                right--;
            }

            if(left >= right){
                //찾다가 확인할 거 없으면 종료
                break;
            }

            temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            //기준값보다 큰 a[left]랑 
            //기준값보다 작은 a[right]를 교환함

            left++;
            right--;
        }
            
            temp = a[head];
            a[head] = a[right];
            a[right] = temp;
            //기준값이랑 a[right]를 교환함

        System.out.println(right + " 현재 기준값 위치");

        return right; //현재 기준값 위치를 반환함            
    
    }
    public static void main(String[] args) {
        int [] a = {4, 7, 1, 6, 2, 5, 3};


        sortArray(a, 0, a.length-1);

    }
}
