import java.util.ArrayList;
import java.util.Scanner;

public class PrefixSumArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // number of element in array
        int numberofElement = sc.nextInt();
        ArrayList<Integer> arrayWithElement = new ArrayList<>(numberofElement);
        // for loop to take number of element in array
        for(int i = 1; i<= numberofElement;i++){
            int element = sc.nextInt();
            arrayWithElement.add(element);
        }
        
        int numOfQueries = sc.nextInt();
        int column = sc.nextInt();
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>(numOfQueries);
        for(int i = 1; i<= numOfQueries;i++){
            int element = sc.nextInt();
            queries.add(element);
        }


    }
}
