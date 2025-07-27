import java.util.Scanner;

public class PrefixArrrayEvenIndex {
    int numOfElement;
    int[] nums;
    int numOfQuery;
    int row;
    int col;
    int[][] Queries;
    int[] arrayPrefixEven;

    public static void main(String[] args){
        PrefixArrrayEvenIndex evenPA = new PrefixArrrayEvenIndex();
       Scanner sc = new Scanner(System.in);
       evenPA.numOfElement = sc.nextInt();
       evenPA.nums = new int[evenPA.numOfElement];
       for (int ele = 0; ele < evenPA.numOfElement; ele++){
           evenPA.nums[ele] = Integer.parseInt(sc.next());
           sc.nextLine();
       }
       evenPA.numOfQuery = sc.nextInt();
       evenPA.row = evenPA.numOfQuery;
       evenPA.col = 2;
       // code to take input in 2d array for queries

        for (int i = 0; i < evenPA.row; i++) {
            for (int j = 0; j < evenPA.col; j++) {
                evenPA.Queries[i][j] = sc.nextInt();
            }
        }

        evenPA.arrayPrefixEven = new int[evenPA.nums.length];
        evenPA.prefixArrayHelper();
        int sum = evenPA.sumOfEven();
        System.out.println(sum);

    }

    //function to find prefix array
    public void prefixArrayHelper(){
        this.arrayPrefixEven[0] = this.nums[0];
        for (int j = 1; j < this.nums.length;j++){
            if(j % 2 == 0){
                this.arrayPrefixEven[j] = this.arrayPrefixEven[j - 1] + this.nums[j];
            }else{
                this.arrayPrefixEven[j] = this.arrayPrefixEven[j - 1];
            }
        }
    }

    public int sumOfEven(){
        int sumEven = 0;
        for(int k = 0; k < Queries.length;k++) {
            int left = Queries[k][0];
            int right = Queries[k][1];
            if(left == 0){
                sumEven = arrayPrefixEven[right];
            }else{
                sumEven = arrayPrefixEven[right] - arrayPrefixEven[left - 1];
            }

        }
        return sumEven;
    }
}
