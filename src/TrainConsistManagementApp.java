import java.util.Scanner;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] bogieIds = new String[n];

        for (int i = 0; i < n; i++) {
            bogieIds[i] = sc.next();
        }

        String key = sc.next();

        sortArray(bogieIds);

        boolean found = binarySearch(bogieIds, key);

        if (found) {
            System.out.println("Bogie ID found");
        } else {
            System.out.println("Bogie ID not found");
        }
    }

    public static void sortArray(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static boolean binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(key);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}