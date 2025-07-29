import java.util.Scanner;

public class InPlacePrefixSum {
    public static void main(String[] args){
        int n;
        int[] nums;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        InPlacePrefixSum ps = new InPlacePrefixSum();
        int [] res = ps.inPlacePrefixArray(nums);

        for(int j = 0; j < n; j++){
            System.out.println(nums[j]);
        }
    }
    public int[] inPlacePrefixArray(int[] nums){
        for(int ele = 1; ele < nums.length; ele++){
            nums[ele] = nums[ele] + nums[ele - 1];
        }
        return nums;

    }
}
