import java.util.ArrayList;
import java.util.Scanner;

public class EquibiliriumIndex {
    public static void main(String[] args){
        int n;
        ArrayList<Integer> nums;
        ArrayList<Integer> arrayPrefix;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new ArrayList<>(n);
        arrayPrefix = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            nums.add(sc.nextInt());
        }
        EquibiliriumIndex eq = new EquibiliriumIndex();
        int res = eq.equibiliriumIndex(nums, eq.prefixArrayHelper(nums, arrayPrefix));
        System.out.println(res);

    }

    //function to find prefix array
    public ArrayList<Integer> prefixArrayHelper(ArrayList<Integer> nums, ArrayList<Integer> arrayPrefix){
        arrayPrefix.add(nums.get(0));
        for (int j = 1; j < nums.size();j++){
            arrayPrefix.add(arrayPrefix.get(j - 1) + nums.get(j));
        }
        return arrayPrefix;
    }

    public int equibiliriumIndex(ArrayList<Integer> nums, ArrayList<Integer> arrayPrefix){
        for(int k = 0; k < nums.size(); k++){
            int sumLeft = 0;
            int sumRight = 0;
            if(k == 0){
                sumRight = arrayPrefix.get(arrayPrefix.size() - 1) - arrayPrefix.get(k);
            }else if(k == nums.size() - 1){
                sumLeft = arrayPrefix.get(k - 1);
            }else{
                sumLeft = arrayPrefix.get(k - 1);
                sumRight = arrayPrefix.get(arrayPrefix.size() - 1) - arrayPrefix.get(k);
            }
            if (sumLeft == sumRight){
                return k;
            }
        }
        return -1;
    }

}
