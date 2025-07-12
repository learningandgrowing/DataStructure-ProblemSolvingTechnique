import java.util.Scanner;

public class RotateKElement {

    public static void main(String[] args){
        int [] arr = new int[6];
        Scanner sc = new Scanner(System.in);
        int numberOfRotation = sc.nextInt();
        int numberOfElement = sc.nextInt();
        for(int i = 0;i<numberOfElement;i++){
            int element = sc.nextInt();
            arr[i] = element;
        }
        int[] reversedArray;
        int[] reversedkElement;
        int[] reverseRestArray = new int[6];
        //find modulos of number of rotation with number of element
        numberOfRotation = numberOfRotation % numberOfElement;
        if(numberOfRotation != 0){
            reversedArray = reverse(arr,0, numberOfElement);
            reversedkElement = reverse(reversedArray,0, numberOfRotation);
            reverseRestArray = reverse(reversedkElement,numberOfRotation, numberOfElement);
        }else{
            reverseRestArray = arr;
        }

        for(int i = 1; i <= numberOfElement;i++){
            System.out.print(reverseRestArray[i-1]);
        }
    }

    private static int[] reverse(int[] arr, int startIndex, int endIndex){
        int i = startIndex;
        int j = endIndex-1;
        while(i<j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j--;
            i++;
        }
        return arr;
    }
}
