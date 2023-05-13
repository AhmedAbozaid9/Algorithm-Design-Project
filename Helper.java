import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Helper {
    static ArrayList<Job> JobSequence(ArrayList<Job> arr)
    {
        int length = arr.size();


        Collections.sort(arr, (a, b) -> {
            return a.deadline - b.deadline;
        });

        ArrayList<Job> result = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>(
                (a, b) -> { return b.profit - a.profit; });

        for (int i = length - 1; i > -1; i--) {
            int slot_available;

            if (i == 0) {
                slot_available = arr.get(i).deadline;
            }
            else {
                slot_available = arr.get(i).deadline
                        - arr.get(i - 1).deadline;
            }


            maxHeap.add(arr.get(i));

            while (slot_available > 0
                    && maxHeap.size() > 0) {

                Job job = maxHeap.remove();

                slot_available--;

                result.add(job);
            }

        }


        Collections.sort(result, (a, b) -> {
            return a.deadline - b.deadline;
        });

        System.out.println();
        return result;

    }
}
