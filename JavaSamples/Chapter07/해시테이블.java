import java.util.Scanner;


public class 해시테이블 {
    public static int[] hashtable = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public static int hashFunc(int data){
        System.out.println("해시 key는 이것이다 : " + data%10);
        return data % 10;
    }
    public static void main(String[] args) {
        int data, hashValue;

        Scanner scn = new Scanner(System.in);
        
        do{
            System.out.printf("\n저장할 데이터 = ");
            data = scn.nextInt();

            if(data < 0){
                break;
            }

            hashValue = hashFunc(data); //해시값을 구한다
            hashtable[hashValue] = data; //해시 테이블에 저장한다.
            System.out.println("삽입한 hashValue는 이것이다 " + data);
        }while(true);
        
        do{
            System.out.printf("\n탐색할 데이터 = ");
            data = scn.nextInt();
            if(data < 0){
                break;
            }
            hashValue = hashFunc(data); //해시값을 구한다.

            if(hashtable[hashValue] == data){
                System.out.println(hashValue+"번째에서 발견되었습니다.");
            }else{
                System.out.println("찾을 수 없습니다.");
            }
        }while(true);

        scn.close();
    }
}
