import java.util.Scanner;

public class SpecialIndex {
    static int n;
    static int[] nums;
    static int[] evenPrefix;
    static int[] oddPrefix;
    static int countSpecialIndex;

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        for(int i = 0;i < n ; i++) {
            nums[i] = sc.nextInt();
        }
        getSpecialIndexCount();
    }

    private static void getSpecialIndexCount(){
        evenPrefix = new int[n];
        oddPrefix = new int[n];
        getPrefixArray();
        int sumOdd; // sum of odd index
        int sumEven; // sum of even index
        for(int i = 0; i < n; i++){
            if(i == 0){
                sumEven = oddPrefix[n-1] - oddPrefix[i];
                sumOdd = evenPrefix[n-1] - evenPrefix[i];
            }else{
                sumEven = evenPrefix[i-1] + oddPrefix[n-1] - oddPrefix[i];
                sumOdd = oddPrefix[i -1] + evenPrefix[n-1] - evenPrefix[i];
            }
            if (sumOdd == sumEven){
                countSpecialIndex++;
            }
        }
        System.out.println(countSpecialIndex);
    }
    // funtion to create prefix array for even and odd seperately
    private static void getPrefixArray(){
        evenPrefix[0] = nums[0];
        oddPrefix[0] = 0;
        for(int i = 1; i<n; i++){
            if(i % 2 == 0){
                evenPrefix[i] = evenPrefix[i - 1] + nums[i];
                oddPrefix[i] = oddPrefix[i-1];
            }else{
                evenPrefix[i] = evenPrefix[i-1];
                oddPrefix[i] = oddPrefix[i-1] + nums[i];
            }
        }
    }

}
