package SampleTest2;

import W11.W11_KnapSackDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

public class ExerciseManagement {
    public static void main(String[] args) {
        FitnessExercise e1 = new FitnessExercise("Swimming", 30, 100);  // duration is given before fitness
        FitnessExercise e2 = new FitnessExercise("Football", 45, 120);
        FitnessExercise e3 = new FitnessExercise("Table tennis", 60, 150);
        ExerciseManagement mgmt = new ExerciseManagement();
        mgmt.add(e1);
        mgmt.add(e2);
        mgmt.add(e3);
        ArrayList<FitnessExercise> test = new ArrayList<>();
        test.add(e1);
        test.add(e2);
        mgmt.exercises(test);  // return "Swimming, Football"
        //Replace element 2 = element 3
        test.set(1,e3);
        mgmt.exercises(test);  // return "Swimming, Table Tennis"
        mgmt.optimalExercises(120);  // You can do either Swimming or Football in 120 minutes, but doing Football gives you more fitness, so you should return a list containing Football
//        mgmt.optimalExercises(250);  // Doing Swimming and Table Tennis brings you 90, which is the highest in 250 minutes, so you should return a list containing Swimming and Table Tennis
    }

    ArrayList<FitnessExercise> exercises;

    public ExerciseManagement() {
        this.exercises = new ArrayList<>();
    }

    static class FitnessExercise {
        String name;
        int duration;
        int fitness;

        public FitnessExercise(String name, int duration, int fitness) {
            this.name = name;
            this.duration = duration;
            this.fitness = fitness;
        }

    }

    void add(FitnessExercise input) {
        exercises.add(input);
    }

    String exercises(List<FitnessExercise> exercises) {
        HashMap<FitnessExercise, Boolean> found = new HashMap<>();
        StringJoiner sb = new StringJoiner(", ");
        for(FitnessExercise ex : exercises) {
            found.put(ex, false);
        }

        for(FitnessExercise ex: this.exercises) {
            if(found.containsKey(ex)) {
                found.replace(ex, true);
            }
        }

        for(FitnessExercise ex : exercises) {
            if(found.get(ex)) {
                sb.add(ex.name);
            }
        }
        //Remove the last comma

        System.out.println(sb.toString());
        return sb.toString();
    }

    //Perform Knapsack problem
    List<FitnessExercise> optimalExercises(int N) {
        // dynamic programming solution to knapsack problem
        int n = this.exercises.size();
        int[][] V = new int[n + 1][N + 1];

        // denote whether an item i of knapsack N j is selected or not
        // taken[i][j] == true if item i is selected, false otherwise
        boolean[][] taken = new boolean[n + 1][N + 1];

        // initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= N; j++) {
                V[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= N; j++) {
                if (exercises.get(i - 1).duration > j) {
                    // this item is too heavy to put in the knapsack of N j
                    // so, the maximum value should NOT include this item
                    V[i][j] = V[i - 1][j];
                    continue;
                }
                // it is OK to put this item into the knapsack
                // but we should only do so if we can increase the total value
                if (V[i - 1][j - exercises.get(i - 1).duration] + exercises.get(i- 1).fitness > V[i - 1][j]) {
                    V[i][j] = V[i - 1][j - exercises.get(i - 1).duration] + exercises.get(i - 1).fitness;
                    taken[i][j] = true;
                } else {
                    V[i][j] = V[i - 1][j];
                }
            }
        }

        // rebuild the solution
        ArrayList<FitnessExercise> res = new ArrayList<>();
        int cap = N;
        int last = n;
        while (cap > 0 && last > 0) {
            if (taken[last][cap]) {
                // the last-th index item is taken
                res.add(exercises.get(last-1));
                cap -= exercises.get(last - 1).duration;
            }
            System.out.println(exercises.get(last - 1).name);
            last--;
        }

        test(res);
        return res;
    }

    public static void test(List<FitnessExercise> input) {
        StringJoiner sb = new StringJoiner(", ");
        for(FitnessExercise ex : input) {
            sb.add(ex.name);
        }
        System.out.println(sb.toString());
    }
}
