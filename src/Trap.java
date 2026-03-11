import java.util.Random;
import java.util.Scanner;
public class Trap extends Monster {
    private String trap = "Tt";
    private Random random = new Random();

    public Trap(int sizeBoard) {
        super(sizeBoard);
    }

    @Override
    public String getImage() {
        return trap;
    }

    @Override
    public void setImage(String image) {
        this.trap = image;
    }

    @Override
    public boolean taskMonster(int difficultGame, Scanner scanner) {
        System.out.println("У тебя не везучий день, под твоей ногой капкан");
        boolean lucky = random.nextBoolean();
        if (lucky) {
            System.out.println("Фортуна на твоей стороне!");
        } else {
            System.out.println("ПОЗДРАВЛЯЮ, У ТЕБЯ НЕТ НОГИ");
        }
        return lucky;
    }
}