package greedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        ActivityPair[] pairs = new ActivityPair[4];
        pairs[0] = new ActivityPair(3, 8);
        pairs[1] = new ActivityPair(1, 3);
        pairs[2] = new ActivityPair(2, 4);
        pairs[3] = new ActivityPair(10, 14);
        int x = activitySelection(pairs);
        System.out.println(x);
    }

    public static int activitySelection(ActivityPair[] pair) {
        int res = 1;
        Arrays.sort(pair, new Comparator<ActivityPair>() {
            @Override
            public int compare(ActivityPair o1, ActivityPair o2) {
                if (o1.finishTime > o2.finishTime)
                    return 1;
                return -1;
            }
        });
        ActivityPair solution = pair[0];
        for (int i = 1; i < pair.length; i++) {
            if (pair[i].startTime >= solution.finishTime) {
                solution = pair[i];
                res++;
            }
        }
        return res;
    }
}

class ActivityPair {
    int startTime;
    int finishTime;

    ActivityPair(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }
}