import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public  static int brute(int len, int sum, int k, int s) {
        if(len == k) {
            return (sum==s)?1:0;
        }
        int c = (len == 0 ? 1 : 0);
        int res = 0;
        for(int i = c; i < 10; i++) {
            res += brute(len + 1, sum + i, k, s);
        }

        return res;
    }

    public static int sumDigits(int k){
        if(k/10 == 0)
            return k;
        return k%10 + sumDigits(k/10);
    }

    public static boolean simpleOrNot(int Simple, int check){
        if(check == Simple && Simple != 1){
            return true;
        }
        if(Simple%check==0 && check!=1 || Simple == 1){
            return false;
        }
        return simpleOrNot(Simple, ++check);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задания для проверки (0 для выхода) =");
        int NumberOfExercise = scanner.nextInt();
        while(NumberOfExercise != 0) {
            switch (NumberOfExercise) {
                case 4:
                    System.out.print("4)Введите K число (k-значные числа) = ");
                    int k4 = scanner.nextInt();
                    System.out.print("4)Введите s (сумма цифр в числе) = ");
                    int s4 = scanner.nextInt();
                    System.out.println("Кол-во " + k4 + "-значных чисел суммой " + s4 + " cуществует = "+ brute(0,0,k4,s4));
                    break;
                case 5:
                    System.out.print("5)Введите Число (сумма цифр в числе) = ");
                    int k5 = scanner.nextInt();
                    System.out.println("Сумма цифр в числе " + k5 + " = " + sumDigits(k5));
                    break;
                case 6:
                    System.out.print("6)Введите число (простое или нет) = ");
                    int Simple6 = scanner.nextInt();
                    System.out.println("Число " + Simple6 + " простое - " + ((simpleOrNot(Simple6, 1) == true) ? "Yes" : "No"));
                    break;
                default:
                    System.out.println(ANSI_RED + "Номера заданий только 4, 5, 6!" + ANSI_RESET);
                    break;
            }
            System.out.print("Введите номер задания для проверки (0 для выхода) =");
            NumberOfExercise = scanner.nextInt();
        }
    }
}
