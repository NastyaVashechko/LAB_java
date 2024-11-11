package lab0;

import java.util.ArrayList;
import java.util.List;

public class Variant3 {

    public int integerNumbersTask(int sizeInBytes) {
        return sizeInBytes / 1024;
    }

    public boolean booleanTask(int A) {
        return A % 2 == 0;
    }

    public int ifTask(int number) {
        if (number > 0) {
            return number + 1;
        } else if (number < 0) {
            return number - 2;
        } else {
            return 10;
        }
    }

    public String switchTask(int month) {
        return switch (month) {
            case 12, 1, 2 -> "зима";
            case 3, 4, 5 -> "весна";
            case 6, 7, 8 -> "літо";
            case 9, 10, 11 -> "осінь";
            default -> throw new IllegalArgumentException("Місяць повинен бути в діапазоні 1-12");
        };
    }

    public List<Integer> forTask(int A, int B) {
        List<Integer> result = new ArrayList<>();
        for (int i = B - 1; i > A; i--) {
            result.add(i);
        }
        return result;
    }

    public int[] whileTask(int N, int K) {
        int quotient = 0;
        int remainder = N;
        while (remainder >= K) {
            remainder -= K;
            quotient++;
        }
        return new int[]{quotient, remainder};
    }

    public int[] arrayTask(int N, int A, int D) {
        int[] result = new int[N];
        result[0] = A;
        for (int i = 1; i < N; i++) {
            result[i] = result[i - 1] + D;
        }
        return result;
    }

    public int[][] twoDimensionArrayTask(int[] MValues, int M, int N) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = MValues[i];
            }
        }
        return matrix;
    }
}
