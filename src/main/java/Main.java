import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        String command = "";
        while (!command.equals("4")){
            printMenu();

            command = scanner.next();
            if (command.equals("1")) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command.equals("2")) {
                stepTracker.changeStepGoal();
            } else if (command.equals("3")) {
                stepTracker.printStatistic();
            } else if (command.equals("4")) {
                System.out.println("До встречи !!!");
                scanner.close();
            } else {
                System.out.println("Ты наверное ошибся, такой команды нет, попробуй еще раз: введи 1-2-3-4");
            }
        }
    }

    static void printMenu() {
        System.out.println("Введите команду: Где 1 - задать кол-во шагов за день; ");
        System.out.println("                     2 - установить цель на день (задано - 10.000 шагов);");
        System.out.println("                     3 - вывести статисику; ");
        System.out.println("                     4 - выйти из программы ");
    }
}
