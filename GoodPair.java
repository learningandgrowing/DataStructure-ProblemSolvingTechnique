import java.util.Scanner;

public class GoodPair {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numElementArray = sc.nextInt();
        int [] arr = new int[numElementArray];
        for(int i = 0;i<numElementArray; i++){
            int element = sc.nextInt();
            arr[i] = element;
        }
        int resultantElement = sc.nextInt();
        int output = goodPair(numElementArray,arr,resultantElement);
        System.out.println(output);
    }
    public static int goodPair(int numElementArray,int[] arr, int resultantElement){
        boolean isGoodPair = false;
        for(int i = 0;i<numElementArray-1;i++){
            for(int j = i+1;j<numElementArray;j++){
                if(arr[i] + arr[j] == resultantElement){
                    isGoodPair = true;
                    break;
                }
            }

        }
        if(isGoodPair){
            return 1;
        }else{
            return 0;
        }
    }
}
