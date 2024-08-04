import java.util.*;

public class ParityOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); 
        
        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt(); 
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            
            System.out.println(minOperations(arr));
        }
        
        scanner.close();
    }
    
    public static int minOperations(int[] arr) {
        int sum = 0;
        int oddCount = 0;
        
        for (int num : arr) {
            sum += num;
            if (num % 2 != 0) {
                oddCount++;
            }
        }
        
        if (oddCount == 0 || oddCount == arr.length) {
            return 0;
        }
        return sum % 2 == 0 ? oddCount : arr.length - oddCount;
    }
}