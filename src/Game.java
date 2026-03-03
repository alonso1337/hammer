import java.util.Random;
import java.util.Scanner;

public class Game {


    public static void main(String[] args) {
        Random random = new Random();


        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";
        int numF;
        int numS;
        int step = 0;//переменные
        int personX;
        int personY;
        int personLive = 3;
        int sizeBoard = 5;//переменные
        int countMonster = (sizeBoard * sizeBoard - sizeBoard);
        int difficultGame;
        //String person = "Hh";
        Person person = new Person(sizeBoard);
        String monster = "Vv";
        String castle = "Cc";
        String gamingField = "+ —— + —— + —— +\n"
                + "|    |    |    |\n"
                + "+ —— + —— + —— +\n"
                + "|    | " + monster + " |    |\n"
                + "+ —— + —— + —— +\n"
                + "| " + person + " |    |    |\n"
                + "+ —— + —— + —— +";
        String begin = "|    | |";
        String end = " |    |";
        String full = begin + monster + end; // |    | Мм |    |
        String[][] board = new String[sizeBoard][sizeBoard];
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        String answer = scanner.nextLine();
        System.out.println(answer);

        if (answer.equalsIgnoreCase("Да")) {
            // первый блок
            System.out.println("Ехала!");

            System.out.println("Выбери сложность игры(от 1 до 5):");
            difficultGame = scanner.nextInt();
            for (int y = 0; y < sizeBoard; y++) {
                for (int x = 0; x < sizeBoard; x++) {
                    board[y][x] = "  ";
                }
            }

            while (difficultGame < 1 || difficultGame > 5) {
                if (difficultGame < 1 || difficultGame > 5) {
                    System.out.println("Некорректный уровень сложности ");
                    difficultGame = scanner.nextInt();
                } else break;

            }
            System.out.println("Выбранная сложность:\t" + difficultGame);
            int castleX = 1 + random.nextInt(sizeBoard);
            int castleY = 1;
            personX = 1 + random.nextInt(sizeBoard);
            personY = sizeBoard;
            for (int i = 0; i <= countMonster; i++) {
                board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = monster;
            }
            board[castleY - 1][castleX - 1] = castle;


            while ((personLive >= 0) && !(castleX == personX && castleY == personY)) {


                board[personY - 1][personX - 1] = person;
                outputBoard(board, personLive, sizeBoard, leftBlock, rightBlock, wall);

                System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;");
                System.out.println(" Координаты персонажа - (x: " + personX + ", y: " + personY + "))");

                int x = scanner.nextInt();
                int y = scanner.nextInt();

                Taskmonster taskmonster = new Taskmonster();

                //System.out.println("ход не коректен");
                //x == personX && Math.abs(y - personY) == 1) || (y == personY && Math.abs(x - personX) == 1) && (x < 6 && x > 0) && (y < 6 && y > 0
                if (person.moveCorrect(x, y)) {
                    if (board[y - 1][x - 1].equals("  ")) {
                        board[personY - 1][personX - 1] = "  ";
                        personX = x;
                        personY = y;
                        board[personY - 1][personX - 1] = person;
                        step++;
                        System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY + "\nХод номер: " + step);
                    } else if (board[y - 1][x - 1].equals(castle)) {
                        System.out.println("Вы прошли игру!!!");
                        break;
                    } else {
                        System.out.println("Тебе нужно решить задачку!!!");
                        if (Taskmonster.taskMonster(difficultGame)) {
                            board[personY - 1][personX - 1] = "  ";
                            personX = x;
                            personY = y;
                        } else {
                            personLive--;
                        }
                    }
                }
                //System.out.println("не корректный ");
                if (personLive == 0) {
                    System.out.println("Твои жизни иссякли но Всевысший сжалился над тобой, ты сможешь вернуться к игре если решишь задачу");
                    numF = random.nextInt(500);
                    numS = random.nextInt(500);
                    int Trueanswer = numF + numS;
                    System.out.println("Чему равно" + numF + " + " + numS);
                    int ansplayer = scanner.nextInt();
                    if (Trueanswer == ansplayer) {
                        System.out.println("Всевысший дарует тебе второй шанс");
                    } else {
                        System.out.println("ТЫ УМЕР");
                        personLive -= 1;
                        System.out.println("Здровье = " + personLive);
                    }
                }
            }


        }
        if (personLive < 0) {
            System.out.println("Поздравляю ты сдох!");
        } else if (answer.equalsIgnoreCase("НЕТ")) {
            // второй блок
            System.out.println("Почему ты не хочешь со мной поиграть?");
        } else {
            //System.out.println("Есть всего два ответа");

        }


    }

    static void outputBoard(String[][] board, int personLive, int sizeBoard, String leftBlock, String rightBlock, String wall) {
        for (int y = 1; y <= sizeBoard; y++) {
            System.out.println(wall);
            for (int x = 1; x <= sizeBoard; x++) {
                System.out.print(leftBlock);
                System.out.print(board[y - 1][x - 1]);
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);

        System.out.println("Жизни: " + +personLive);
    }
}