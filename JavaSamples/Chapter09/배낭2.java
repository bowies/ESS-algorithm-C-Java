public class 배낭2 {
    public static void main(String[] args) {
        int KNAP_MAX = 6; //배낭 최대 무게
        int ITEM_NUM = 5; //물건 종류
        int totalWeight = 0; //무게 합계
        int totalValue = 0; //가치 합계
        
        char [] name = {'E', 'D', 'C', 'B', 'A'};
        int [] weight = {5, 4, 3, 2, 1};
        int [] value = {650, 500, 350, 300, 100};

        for(int i = 0; i < ITEM_NUM; i++){
            if(totalWeight + weight[i] <= KNAP_MAX){
                System.out.println(name[i] + " 물건");
                totalWeight += weight[i];
                totalValue += value[i];
            }else{
                break;
            }
        }
        System.out.println(totalWeight + " : 무게 합");
        System.out.println(totalValue + " : 원");
    }
}