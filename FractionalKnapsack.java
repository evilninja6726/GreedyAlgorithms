package greedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        double x = fractionalKnapsack(new WeightValue[]{new WeightValue(50, 600), new WeightValue(20, 500), new WeightValue(30, 400)}, 70);
        System.out.println(x);
    }

    public static double fractionalKnapsack(WeightValue[] pair, int capacity) {
        Arrays.sort(pair, new Comparator<WeightValue>() {
            @Override
            public int compare(WeightValue o1, WeightValue o2) {
                return (o2.value * o1.weight) - (o1.value * o2.weight);
            }
        });
        double res = 0;
        for (int i = 0; i < pair.length; i++) {
            if (capacity >= pair[i].weight) {
                res += pair[i].value;
                capacity -= pair[i].weight;
            } else {
                res += (double) (pair[i].value * capacity) / pair[i].weight;
                return res;
            }
        }
        return res;
    }
}

class WeightValue {
    int weight;
    int value;

    WeightValue(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
