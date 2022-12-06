public class 배낭 {
    //예제가 c가 기본이라 전역변수를 많이 쓴다...
    public static final int KNAP_MAX = 6; //배낭 최대 무게
    public static final int ITEM_NUM = 5; //물건 종류
    public static char [] name = {'A', 'B', 'C', 'D', 'E'}; //물건 이름
    public static int [] weight = {1, 2, 3, 4, 5}; //물건 무게
    public static int [] value = {100, 300, 350, 500, 650}; //물건 가치
    public static int [][] maxValue = new int[ITEM_NUM][KNAP_MAX+1]; //물건을 넣을지 판단한 직후의 최대 가치
    public static int [] lastItem = new int[KNAP_MAX + 1]; //마지막에 넣은 물건

    //item 번째 물건을 넣을지 판단한 직후 배낭의 내용을 표시하는 메소드
    public static void showKnap(int item){
        int knap; //0~6kg의 배낭
        System.out.println(name[item] + "의 " + weight[item] + "kg " + value[item] + "원");
        
        for(knap = 0; knap <= KNAP_MAX; knap++){
           System.out.println(maxValue[item][knap]+"원");
        }
        
        for(knap = 0; knap <= KNAP_MAX; knap++){
            if(lastItem[knap] != -1){
               System.out.println(name[lastItem[knap]]+"를 넣음");
            }else{
               System.out.println("없음");
            }
        }
    }

    public static void main(String[] args) {
        int item; //물건 번호
        int knap; //0~6kg 배낭
        int selVal; //임시로 물건을 선택한 경우의 가치 합계
        int totalWeight; //중량 합계

        item = 0; 
        for(knap=0; knap <= KNAP_MAX; knap++){
            if(weight[item] <= knap){ //최대 무게 이하면 선택
                maxValue[item][knap] = value[item];
                lastItem[knap] = item;
            }else{
                //최대 무게 이하가 아니면 선택 안함
                maxValue[0][knap] = 0;
                lastItem[knap] = -1;
            }
        }
        showKnap(item);

        for(item = 1; item< ITEM_NUM; item++){
            //1번째~ITEM_NUM-1까지 고려
            for(knap = 0; knap<=KNAP_MAX; knap++){
                if(weight[item] <= knap){
                    selVal = maxValue[item-1][knap-weight[item]] + value[item]; 
                    //선택한 경우 가치를 구해봄

                    if(selVal > maxValue[item-1][knap]){
                        maxValue[item][knap] = selVal;
                        lastItem[knap] = item;
                    }else{
                        maxValue[item][knap] = maxValue[item-1][knap];
                    }
                }else{
                    maxValue[item][knap] = maxValue[item-1][knap];
                }
            }
            showKnap(item);
            }
            //현재 배낭에 들어 있는 물건을 조사해서 정답 표시
            System.out.println("배낭 물건 조사");
            totalWeight = 0;
            for(knap = KNAP_MAX; knap > 0; knap -= weight[item]){
                item = lastItem[knap];
                System.out.println(knap+"kg의 배낭에 마지막으로 넣은 물건 : " + name[item]);
                totalWeight += weight[item];

                System.out.println(name[item] + "의 " + weight[item] + "kg " + value[item] + "원 이다.");
                System.out.println(knap+"kg - " + weight[item] + "kg = " + (knap-weight[item]) + "kg 이다.");
            }
            System.out.println("정답");
            System.out.println("무게 합 " + totalWeight);
            System.out.println("가치 최대 값 : " + maxValue[ITEM_NUM-1][KNAP_MAX]);
       
        
    }


}

