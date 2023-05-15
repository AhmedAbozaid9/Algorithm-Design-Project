import java.util.Arrays;

public class Helper {
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
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        int length = jobs.length;
        int[] solutionArray = new int[length];

        solutionArray[0] = jobs[0][2];

        for (int i = 1; i < length; i++) {
            int profit = jobs[i][2];
            int prevJobIndex = binarySearch(jobs, i);

            if (prevJobIndex != -1) {
                profit += solutionArray[prevJobIndex];
            }
            solutionArray[i] = Math.max(solutionArray[i - 1], profit);
        }

        return solutionArray[length - 1];
    }
}