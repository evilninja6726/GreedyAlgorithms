package greedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequenceProblem {
    public static void main(String[] args) {
        System.out.println(jobSequenceProblem(new Jobs[]{new Jobs(4, 50), new Jobs(1, 5), new Jobs(1, 20), new Jobs(5, 10), new Jobs(5, 80)}));
    }

    public static int jobSequenceProblem(Jobs[] jobs) {
        Arrays.sort(jobs, new Comparator<Jobs>() {
            @Override
            public int compare(Jobs o1, Jobs o2) {
                return o2.profit - o1.profit;
            }
        });
        int res = 0;
        int tempLength = 0;
        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i].deadline > tempLength)
                tempLength = jobs[i].deadline;
        }

        boolean[] temp = new boolean[tempLength];
        for (int i = 0; i < jobs.length; i++) {
            for (int j = jobs[i].deadline - 1; j >= 0; j--) {
                if (!temp[j]) {
                    temp[j] = true;
                    res += jobs[i].profit;
                    break;
                }
            }
        }
        return res;
    }
}

class Jobs {
    int deadline;
    int profit;

    Jobs(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }
}