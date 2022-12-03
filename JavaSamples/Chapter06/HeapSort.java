public class HeapSort {
    public void sort(int arr[])
    {
        int N = arr.length;
 
        // 배열을 재정렬하는 힙 만들기
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        // 힙에서 요소를 하나씩 추출한다
        for (int i = N - 1; i > 0; i--) {
            // 현재 루트를 끝부분으로 이동한다
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // 감소된 힙에서 최대 heapify 를 호출한다.
            heapify(arr, i, 0);
        }
    }
 
    // 노드 i를 기반으로 하는 하위 트리를 힙화한다.
    // n은 힙의 크기이다.
    void heapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // 왼쪽 자식이 루트보다 크면 
        if (l < N && arr[l] > arr[largest])
            largest = l;
 
        // 오른쪽 자식이 지금 가장 큰 것보다 크면
        if (r < N && arr[r] > arr[largest])
            largest = r;
 
        // 루트가 최대값이 아닌 경우에는
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // 하위 트리를 재귀적으로 힙화한다.
            heapify(arr, N, largest);
        }
    }
 
    /*크기가 n인 배열을 출력하는 함수*/
    static void printArray(int arr[])
    {
        int N = arr.length;
 
        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // 동작코드
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int N = arr.length;
 
        // Function call
        HeapSort ob = new HeapSort();
        ob.sort(arr);
 
        System.out.println("정렬된 배열은 ");
        printArray(arr);

    }
}