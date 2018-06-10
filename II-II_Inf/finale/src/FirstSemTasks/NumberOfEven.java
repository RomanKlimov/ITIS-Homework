package FirstSemTasks;

public class NumberOfEven {
    public static void main(String[] args) {
        System.out.println(nOfEven(23456));
    }

    private static Integer nOfEven(int n) {
        if (n == 0) {
            return 0;
        }
        int q = 0;
        if (n % 2 == 0) {
            q += 1;
        }

        return q + nOfEven(n / 10);
    }
}
