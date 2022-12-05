import java.util.Scanner;


public class 해시테이블_충돌 {
    public static int[] hashTable = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public static int hashFunc(int data){
        System.out.println("해시 key는 이것이다 : " + data%10);
        return data % 10;
    }
    public static void main(String[] args) {
        int data, hashValue;
        int pos;

        Scanner scn = new Scanner(System.in);
        do{
            System.out.print("\n 저장할 데이터 : ");
            data = scn.nextInt();

            if(data < 0){
                break;
            }

            hashValue = hashFunc(data);

            pos = hashValue;
            while(hashTable[pos] != -1){
                pos++;

                if(pos >= hashTable.length){
                    pos = 0;
                }

                if(pos == hashValue){
                    break;
                }
            }

            if(hashTable[pos] == -1){
                hashTable[pos] = data;
            }else{
                System.out.println("해시 테이블이 가득 찼습니다.");
            }
        }while(true);


        do{
            System.out.print("\n 검색할 데이터 = ");
            data  = scn.nextInt();
            if(data < 0){
                break;
            }

            hashValue = hashFunc(data);

            pos = hashValue;

            while(hashTable[pos] != -1 && hashTable[pos] != data){
                pos++;

                if(pos >= hashTable.length){
                    pos = 0;
                }

                if(hashTable[pos] == -1 || pos == hashValue){
                    break;
                }
            }

            if(hashTable[pos] == data){
                System.out.println(pos+ "번째에서 발견되었습니다.");
            }else{
                System.out.println("찾을 수 없습니다.");
            }

        }while(true);

        scn.close();
    }
}
