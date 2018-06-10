package FirstSemTasks;

import java.util.Scanner;

public class KvadUr {
    public static void main(String[] args) {
        double a, b, c, d;
        double x1, x2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите а: ");
        a = sc.nextInt();
        System.out.println("Введите b: ");
        b = sc.nextInt();
        System.out.println("Введите c: ");
        c = sc.nextInt();

        d = Math.pow(b, 2) - (4 * a * c);
        if(d > 0) {
            x1 = (-1 * b + Math.sqrt(d))/2 * a;
            x2 = (-1 * b - Math.sqrt(d))/2 *a;
            System.out.println("x1 = " + x1 + " x2 = " + x2);
        }
        else if(d == 0){
            x1 = (-1) * b;
        }
        else System.out.println("Ошибка. D меньше нуля");
    }
}
