import java.util.Arrays;

public class JobScheduler {
    public static void main(String[] args) {
        int[][] jobs = { { 1, 6, 6 }, { 2, 5, 5 }, { 5, 7, 5 }, { 6, 8, 3 } };
        System.out.println(maximumProfit(jobs)); // Output: 11
    }

    private static int binarySearch(int[][] jobs, int i) {
        int low = 0;
        int high = i - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (jobs[mid][1] <= jobs[i][0]) {
                if (jobs[mid + 1][1] <= jobs[i][0]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int maximumProfit(int[][] jobs) {
        return 0;
    }

}