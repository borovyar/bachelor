import java.util.*;

public class Main {

    static int n = 3; // number of timeslots
    static int m = 4; // number of people

    public static void main(String[] args) {

        boolean[][] canTake = {{true, true, true}, // canTake[i][j] = true if person j can take timeslot i
                {true, false, true},
                {true, true, false},
                {true, true, true}};

        List<int[]> result = assignTimeslots(n, m, canTake);
        System.out.println("Assignments: ");
        for (int[] assignment : result) {
            System.out.println(Arrays.toString(assignment));
        }
    }

    public static List<int[]> assignTimeslots(int n, int m, boolean[][] canTake) {
        List<int[]> result = new ArrayList<>();
        int[] assignment = new int[n];
        assign(0, n, m, canTake, assignment, result);
        return uniqueAssignments(result);
    }

    private static void assign(int i, int n, int m, boolean[][] canTake, int[] assignment, List<int[]> result) {
        if (i == n) {
            result.add(Arrays.copyOf(assignment, n)); // found a valid assignment, add it to the result
            return;
        }
        for (int j = 0; j < m; j++) {
            if (canTake[j][i]) { // person j can take timeslot i
                assignment[i] = j;
                assign(i + 1, n, m, canTake, assignment, result);
            }
        }
    }

    private static List<int[]> uniqueAssignments(List<int[]> results){
        List<int[]> resultArrays = new ArrayList<>();
        for (int[] array : results) {
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (int j : array) {
                uniqueNumbers.add(j);
            }

            if (uniqueNumbers.size() == m) {
                resultArrays.add(array);
            }
            else if(m > n && uniqueNumbers.size() == n){
                resultArrays.add(array);
            }
        }

        return resultArrays;
    }
}
