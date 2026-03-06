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
        int step = 0;
        int personLive = 3;
        int sizeBoard = 5;
        int difficultGame;

        Person person = new Person(sizeBoard);
        //String monster = "Vv";
        String castle = "Cc";
        String[][] board = new String[sizeBoard][sizeBoard];
        Scanner scanner = new Scanner(System.in, "UTF-8");

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        String answer = scanner.nextLine();
        System.out.println(answer);

        if (answer.equalsIgnoreCase("ДА")) {
            System.out.println("Ехала!");
            System.out.println("Выбери сложность игры(от 1 до 5):");
            difficultGame = scanner.nextInt();

            // Инициализация поля
            for (int y = 0; y < sizeBoard; y++) {
                for (int x = 0; x < sizeBoard; x++) {
                    board[y][x] = "  ";
                }
            }

            while (difficultGame < 1 || difficultGame > 5) {
                System.out.println("Некорректный уровень сложности ");
                difficultGame = scanner.nextInt();
            }
            System.out.println("Выбранная сложность:\t" + difficultGame);

            // Размещение замка
            int castleX = 1 + random.nextInt(sizeBoard - 1);
            int castleY = 1;
            board[castleY - 1][castleX - 1] = castle;

            // Размещение монстров
            int countMonster = sizeBoard * sizeBoard - sizeBoard - 5;
            Monster[] arrMonster = new Monster[countMonster + 1];
            int count = 0;
            Monster test;
            while (count <= countMonster){
                if (random.nextBoolean()) {
                    test = new Monster(sizeBoard);
                }else {
                    test = new BigMonster(sizeBoard);
                }
                if (board[test.getY()][test.getX()].equals("  ")){
                    board[test.getY()][test.getX()] = test.getImage();
                    arrMonster[count] = test;
                    count++;
                }

            }
            // Основной игровой цикл
            while ((personLive >= 0) && !(castleX == person.getX() && castleY == person.getY())) {
                board[person.getY() - 1][person.getX() - 1] = person.getImage();
                outputBoard(board, personLive, sizeBoard, leftBlock, rightBlock, wall);

                System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку);");
                System.out.println(" Координаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + "))");

                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (person.moveCorrect(x, y)) {
                    if (board[y - 1][x - 1].equals("  ")) {
                        board[person.getY() - 1][person.getX() - 1] = "  ";
                        person.move(x, y);
                        board[person.getY() - 1][person.getX() - 1] = person.getImage();
                        step++;
                        System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() + "\nХод номер: " + step);
                    }
                    else if (board[y - 1][x - 1].equals(castle)) {
                        System.out.println("Вы прошли игру!!!");
                        break;
                    }
                    else {
                        // Проверка на монстра
                        boolean monsterDefeated = false;
                        for (Monster m : arrMonster) {
                            if (m != null && m.conflictPerson(x, y)) {
                                System.out.println("Тебе нужно решить задачку!!!");
                                if (m.taskMonster(difficultGame)) {
                                    board[person.getY() - 1][person.getX() - 1] = "  ";
                                    person.move(x, y);
                                    monsterDefeated = true;
                                } else {
                                    personLive--;
                                    System.out.println("Жизней осталось: " + personLive);
                                }
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Некорректный ход!");
                }

                // Проверка жизней и возможность воскрешения
                if (personLive == 0) {boolean monsterDefeated = false;
                    System.out.println("Твои жизни иссякли но Всевышний сжалился над тобой, ты сможешь вернуться к игре если решишь задачу");
                    numF = random.nextInt(500);
                    numS = random.nextInt(500);
                    int Trueanswer = numF + numS;
                    System.out.println("Чему равно " + numF + " + " + numS + "?");
                    int ansplayer = scanner.nextInt();
                    if (Trueanswer == ansplayer) {
                        System.out.println("Всевышний дарует тебе второй шанс");
                        personLive = 1;
                    } else {
                        System.out.println("ТЫ УМЕР");
                        personLive = -1;
                    }
                }
            }

            if (personLive < 0) {
                System.out.println("Поздравляю ты сдох!");
            }
        }
        else if (answer.equalsIgnoreCase("НЕТ")) {
            System.out.println("Почему ты не хочешь со мной поиграть?");
        }
        scanner.close();
    }

    static void outputBoard(String[][] board, int personLive, int sizeBoard,
                            String leftBlock, String rightBlock, String wall) {
        for (int y = 0; y < sizeBoard; y++) {
            System.out.println(wall);
            System.out.print(leftBlock);
            for (int x = 0; x < sizeBoard; x++) {
                System.out.print(board[y][x]);
                if (x < sizeBoard - 1) System.out.print(leftBlock);
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);
        System.out.println("Жизни: " + personLive);
    }
}