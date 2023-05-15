import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Job> jobs = new ArrayList<Job>();

        jobs.add(new Job(1,4,20));
        jobs.add(new Job(2,1,10));
        jobs.add(new Job(3,1,40));
        jobs.add(new Job(3,1,40));

        ArrayList<Job> result = Helper.JobSequence(jobs);

        System.out.println("Maximum Profit = "+ Helper.maxProfit(result));
        System.out.println("Number of Jobs Done = "+result.size());
        System.out.println("Jobs Sequence = "+Arrays.toString(Helper.getDoneJobsID(result)));

    }


}