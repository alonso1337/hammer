import java.util.Scanner;

public class BigMonster extends Monster {
    private String image = "Ll";

    BigMonster(int sizeBoard) {
        super(sizeBoard);
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean taskMonster(int difficultGame, Scanner scanner) {
        System.out.println("Твой противник — ярый физик. Тебе нужно решить его задачку:");
        int x, y;

        switch (difficultGame) {
            case 1:
                x = r.nextInt(10) + 1;
                y = r.nextInt(10) + 1;
                System.out.println("Найди напряжение на резисторе, если его сопротивление равно " + x + " Ом, а сила тока " + y + " А.");
                System.out.print("U = ");
                if (Math.abs(x * y - scanner.nextDouble()) < 0.001) {
                    System.out.println("Физик повержен!");
                    return true;
                } else {
                    System.out.println("К сожалению, ты проиграл схватку.");
                    return false;
                }
            case 2:
                x = r.nextInt(100) + 1;
                y = r.nextInt(30) + 1;
                System.out.println("Найди силу тока в резисторе, если напряжение равно " + x + " В, а сопротивление " + y + " Ом.(округли до целого)");
                System.out.print("I = ");
                if (Math.abs(x / y - scanner.nextDouble()) < 0.001) {
                    System.out.println("Физик повержен!");
                    return true;
                } else {
                    System.out.println("К сожалению, ты проиграл схватку.");
                    return false;
                }
            case 3:
                x = r.nextInt(35) + 1;
                y = r.nextInt(35) + 1;
                System.out.println("Найди общее сопротивление резисторов, подключенных последовательно. Сопротивление первого: " + x + " Ом, сопротивление второго: " + y + " Ом.");
                System.out.print("R = ");
                if (Math.abs(x + y - scanner.nextDouble()) < 0.001) {
                    System.out.println("Физик повержен!");
                    return true;
                } else {
                    System.out.println("К сожалению, ты проиграл схватку.");
                    return false;
                }
            case 4:
                x = r.nextInt(20) + 1;
                y = r.nextInt(20) + 1;
                System.out.println("Какова мощность лампочки, если напряжение равно " + x + " В, а сила тока равна " + y + " А?");
                System.out.print("P = ");
                if (Math.abs(x * y - scanner.nextDouble()) < 0.001) {
                    System.out.println("Физик повержен!");
                    return true;
                } else {
                    System.out.println("К сожалению, ты проиграл схватку.");
                    return false;
                }
            case 5:
                x = r.nextInt(35) + 1;
                y = r.nextInt(35) + 1;
                System.out.println("Найди общее сопротивление резисторов, подключенных параллельно. Сопротивление первого: " + x + " Ом, сопротивление второго: " + y + " Ом.(округли до целого)");
                System.out.print("R = ");
                double correctAnswer = (x * y) / (x + y);
                if (Math.abs(correctAnswer - scanner.nextDouble()) < 0.001) {
                    System.out.println("Физик повержен!");
                    return true;
                } else {
                    System.out.println("К сожалению, ты проиграл схватку.");
                    return false;
                }
            default:
                return false;
        }
    }
}