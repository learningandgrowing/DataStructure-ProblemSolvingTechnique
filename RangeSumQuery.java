import java.util.ArrayList;
import java.util.Scanner;

public class RangeSumQuery {
    static int n;
    static ArrayList<Integer> A;
    static ArrayList<ArrayList<Integer>> B;
    static ArrayList<Integer> prefixArray;
    static int numOfQuery;
    static int row;
    static int col;
    static ArrayList<Integer> result;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        A = new ArrayList<>(n);
        for (int ele = 0; ele < n; ele++){
            A.add(Integer.parseInt(sc.next()));
        }

        numOfQuery = sc.nextInt();
        row = numOfQuery;
        col = 2;
        result = new ArrayList<>(numOfQuery);
        // Initialize Queries array before using it
        B = new ArrayList<>(row);
        for (int i = 0; i < row; i++) {
            B.add(new ArrayList<Integer>(col));
        }

        // code to take input in 2d array for queries
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                B.get(i).add(sc.nextInt());
            }
        }

        prefixSumArray();

        for(int j = 0; j < numOfQuery; j++){
            sumRange(B.get(j).get(0), B.get(j).get(1));
        }
        for(int k = 0; k < numOfQuery; k++){
            System.out.println(result.get(k));
        }

    }
    public static void prefixSumArray(){
        prefixArray = new ArrayList<Integer>(n);
        prefixArray.add(A.get(0));
        for (int i = 1; i < n; i++){
            prefixArray.add(prefixArray.get(i-1) + A.get(i));
        }
    }

    public static void sumRange(int left, int right) {
        if(left == 0){
            result.add(prefixArray.get(right));
        }else{
            result.add(prefixArray.get(right) - prefixArray.get(left - 1));
        }
    }
}

