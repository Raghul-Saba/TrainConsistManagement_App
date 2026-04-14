import java.util.Scanner;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] capacities = new int[n];

        for (int i = 0; i < n; i++) {
            capacities[i] = sc.nextInt();
        }

        bubbleSort(capacities);

        for (int i = 0; i < capacities.length; i++) {
            System.out.print(capacities[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}