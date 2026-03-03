import java.util.Random;
import java.util.Scanner;

public class Taskmonster {
    static boolean taskMonster(int difficultGame) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        Random random = new Random();
        int x;
        int y;
        switch (difficultGame) {
            case (1):
                x = random.nextInt(100);
                y = random.nextInt(100);
                System.out.println("Чему равно" + x + " + " + y);
                if (x + y == scanner.nextInt()) {
                    System.out.println("Поздравляю ответ правильный");
                    return true;
                } else {
                    System.out.println("К сожалению ты проиграл схватку");
                    return false;
                }
            case (2):
                x = random.nextInt(200);
                y = random.nextInt(200);
                System.out.println("Чему равно" + x + " + " + y);
                if (x + y == scanner.nextInt()) {
                    System.out.println("Поздравляю ответ правильный");
                    return true;
                } else {
                    System.out.println("К сожалению ты проиграл схватку");
                    return false;
                }
            case (3):
                x = random.nextInt(20);
                y = random.nextInt(20);
                System.out.println("Чему равно" + x + " * " + y);
                if (x * y == scanner.nextInt()) {
                    System.out.println("Поздравляю ответ правильный");
                    return true;
                } else {
                    System.out.println("К сожалению ты проиграл схватку");
                    return false;
                }
            case (4):
                x = random.nextInt(35);
                y = random.nextInt(35);
                System.out.println("Чему равно" + x + " * " + y);
                if (x * y == scanner.nextInt()) {
                    System.out.println("Поздравляю ответ правильный");
                    return true;
                } else {
                    System.out.println("К сожалению ты проиграл схватку");
                    return false;
                }
            case (5):

                x = random.nextInt(50);
                y = random.nextInt(50);
                System.out.println("Чему равно" + x + " * " + y);
                if (x * y == scanner.nextInt()) {
                    System.out.println("Поздравляю ответ правильный");
                    return true;
                } else {
                    System.out.println("К сожалению ты проиграл схватку");
                    return false;
                }
        }
        return  false;

    }
}
