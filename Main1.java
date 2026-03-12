public class Main1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2,4,5};
        int[] result = sumArray(arr);
        
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] sumArray(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] + arr[i];
        }
        
        return result;
    }
}