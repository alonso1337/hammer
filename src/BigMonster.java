import java.util.Scanner;
public class BigMonster extends Monster {
    private String image = "Ll";//"\uD83E\uDDDF\u200D";
    BigMonster(int sizeBoard) {

        super(sizeBoard);


    }

    public String getImage() {
        return image;
    }

    // переопредилим метод:
    @Override
    public boolean taskMonster(int difficultGame){
        Scanner sc = new Scanner(System.in);
        System.out.println("Твой противник ярый физик, тебе нужно решить его задачку");
        double x,y;
        switch (difficultGame) {
            case (1):
                x = r.nextInt(10);
                y = r.nextInt(10);
                System.out.println("Найди напряжение резистра если его сопротивление равно " + x + " а сила тока " + y);
                if (x * y == sc.nextInt()) {
                    System.out.println("Физик повержен!");
                    return true;
                } else {
                    System.out.println("К сожалению ты проиграл схватку");
                    return false;
                }
            case (2):
                x = r.nextInt(100);
                y = r.nextInt(30);
                System.out.println("Найди силу тока в резисторе если нарпяжение равно " + x + " а сопротивление " + y);
                if (x / y == sc.nextInt()) {
                    System.out.println("Поздравляю ответ правильный");
                    return true;
                } else {
                    System.out.println("К сожалению ты проиграл схватку");
                    return false;
                }
            case (3):
                x = r.nextInt(35);
                y = r.nextInt(35);
                System.out.println("Найди общее сопротивление резисторов подключенных последовательно, сопротивление первого" + x + " , сопротивление второго " + y);
                if (x + y == sc.nextInt()) {
                    System.out.println("Поздравляю ответ правильный");
                    return true;
                } else {
                    System.out.println("К сожалению ты проиграл схватку");
                    return false;
                }
            case (4):
                x = r.nextInt(20);
                y = r.nextInt(20);
                System.out.println("Какова мощность лампочки если напряжение равно " + x + " а сила тока равна " + y);
                if (x * y == sc.nextInt()) {
                    System.out.println("Поздравляю ответ правильный");
                    return true;
                } else {
                    System.out.println("К сожалению ты проиграл схватку");
                    return false;
                }
            case (5):
                x = r.nextInt(35);
                y = r.nextInt(35);
                System.out.println("Найди общее сопротивление резисторов подключенных паралельно, сопротивление первого" + x + " , сопротивление второго " + y);
                if (x * y / (x + y) == sc.nextInt()) {
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