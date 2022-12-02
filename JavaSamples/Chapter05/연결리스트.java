class StationList{
    public String name; //역이름 
    public int next; //연결 정보
}

public class 연결리스트 {
    public static StationList [] list = new StationList[10];
    public static int head;

    public static void main(String[] args) {


        initStationList();
        printStationList();
    }

    public static void initStationList(){
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

    public static void printStationList(){
        int idx = head;
        while (idx != -1){
            //-1인 부산을 맨 마지막으로
            System.out.println(idx + " 는 " + list[idx].name);
            idx = list[idx].next;
        }
    }


}
