class BST{
    int data;
    int left;
    int right;
}

public class 이진탐색트리 {
    //이진 탐색 트리 실체 배열 - 요소 수 원래 정해져 있음
    public static BST[] tree = new BST[10];
    public static int rootIdx = 0; //루트의 물리 위치 인덱스 = head
    public static int newIdx = 0; //다음 삽입할 것 물리 위치 인덱스

    public static void addBST(int data){
        //요소 삽입하기

        int currentIdx; //현재 요소 위치 인덱스
        boolean addFlag; //요소 추가 완료 확인 플래그

        tree[newIdx].data = data;
        tree[newIdx].left = -1;
        tree[newIdx].right = -1;

        if(newIdx != rootIdx){
            //루트 인덱스면 위에서 끝나고, 아니면 여기로 옴
            currentIdx = rootIdx; //루트인 0부터 내려감
            addFlag = false; //요소 추가 안 됨

            do{
                if(data <tree[currentIdx].data){
                    //루트보다 작으면 <<<로 감
                    if(tree[currentIdx].left == -1){
                        //끝이면 
                        tree[currentIdx].left = newIdx; //현재 -1인 값을 newIdx로 바꿔준다.
                        addFlag = true; //끝냄
                    }else{
                        currentIdx = tree[currentIdx].left; //더 내려가고 루프를 돔
                    }
                }else{
                    //루트보다 크면 >>>로 감
                    if(tree[currentIdx].right == -1){
                        //끝이면
                        tree[currentIdx].right = newIdx; //현재 -1인 값을 newIdx로 바꿔준다.
                        addFlag = true; //끝냄
                    }else{
                        currentIdx = tree[currentIdx].right;
                    }

                }

            }while(addFlag == false); //true 되면 끝남
        }
        newIdx++; //다음 추가용을 위해 인덱스를 1 늘려놓음 
    }


    public static void printPhysicalBST(){
        for(int i = 0; i< newIdx; i++){
            //인덱스 개수만큼 루프
            System.out.println("데이터 " + tree[i].data + " 왼쪽 : " + tree[i].left + " 오른쪽 : " + tree[i].right);
        }
        System.out.println("");
    }
    
    public static void printLogicalBST(int currentIdx){
        //현재 요소 위치를 받아와야 한다.
        if(currentIdx != -1){
            System.out.println("데이터 " + tree[currentIdx].data + " 왼쪽 : " + tree[currentIdx].left + " 오른쪽 : " + tree[currentIdx].right);
            printLogicalBST(tree[currentIdx].left);
            printLogicalBST(tree[currentIdx].right);

        } 
    }


    public static int searchBST(int x){
        int idx;
        int currentIdx;
        idx = -1;
        currentIdx = rootIdx;

        while(currentIdx != -1){
            if(tree[currentIdx].data == x){
                idx = currentIdx;
                break;
            }else if(tree[currentIdx].data > x){
                //크면 >>>
                currentIdx = tree[currentIdx].left;
            }else{
                //작으면 <<<
                currentIdx = tree[currentIdx].right;
            }
        }

        
        return idx;

    }


    public static int searchRecBST(int x, int currentIdx){
        if(currentIdx == -1){
            //끝일 경우 -1을 리턴
            return -1;
        }else{
            if(tree[currentIdx].data == x){
                return currentIdx;
            }else if(tree[currentIdx].data > x){
                //크면 >>>
                return searchRecBST(x, tree[currentIdx].left);
            }else{
                //작으면 <<<
                return searchRecBST(x, tree[currentIdx].right);
            }

        }

    }

    public static void main(String[] args) {
        for(int i = 0; i < tree.length; i++){
            tree[i] = new BST();
            //이진 탐색 트리 10개 만듬
        }

        addBST(4);
        addBST(6);
        addBST(5);
        addBST(2);
        addBST(3);
        addBST(7);
        addBST(1);

        System.out.println("물리적 순서");
        printPhysicalBST();

        System.out.println("깊이 우선 탐색");
        printLogicalBST(rootIdx);

        System.out.println("5의 물리적 위치 찾기 " + searchBST(5));
        System.out.println("1의 물리적 위치 찾기 " + searchBST(1));

        System.out.println("재귀로 찾기");
        
        System.out.println("5의 물리적 위치 찾기 " + searchRecBST(5, rootIdx));
        System.out.println("1의 물리적 위치 찾기 " + searchRecBST(1, rootIdx));
    } 
}
