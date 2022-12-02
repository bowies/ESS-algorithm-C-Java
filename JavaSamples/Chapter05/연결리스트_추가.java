class StationList{
    public String name; //역이름 
    public int next; //연결 정보
}

public class 연결리스트_추가 {
    public static StationList [] list = new StationList[10];
    public static int head;

    public static void main(String[] args) {

        initStationList_();
        printStationList();
        System.out.println("---------------------------");
        initStationList(5, "광명", 2);
        printStationList();
        System.out.println("---------------------------");
        deleteStationList(5, 2);
        printStationList();
        

    }

    private static void deleteStationList(int delIdx, int prevIdx) {
        list[prevIdx].next = list[delIdx].next;
        //삭제할 요소의 하나 앞 인덱스를 현재 삭제할 요소의 인덱스로 바꿔준다. 
        // 그러면 삭제할 요소는 연결 리스트에서 빠짐
    }

    public static void initStationList_(){
        for(int i = 0; i< list.length; i++){
            list[i] = new StationList();
        }

        list[0].name = "부산";
        list[0].next = -1;
        list[1].name = "대전";
        list[1].next = 3;
        list[2].name = "서울";
        list[2].next = 4;
        list[3].name = "동대구";
        list[3].next = 0;
        list[4].name = "천안아산";
        list[4].next = 1;

        head = 2; //서울을 head로 설정함
    }   

    public static void initStationList(int insIdx, String insName, int prevIdx){
    
        list[insIdx].name = insName;
        list[insIdx].next = list[prevIdx].next; //앞 연결 요소 설정
        list[prevIdx].next = insIdx; 
        
    }   

    public static void printStationList(){
        int idx = head;
        while (idx != -1){
            //-1인 부산을 맨 마지막으로
            System.out.println(idx + " 는 " + list[idx].name);
            idx = list[idx].next;
        }
    }


}
