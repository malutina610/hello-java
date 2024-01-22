import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        //addNewNumberStepsPerDay(); // - вродебы он должен быть вызван здесь
        // printStatistic();
        printMenu();
        while (true) {


            //int i = scanner.nextInt(); // это убрали тк юзер не введет число, в if-ах i  заменили также на command.equals
            String command = scanner.nextLine();//int заменили на String тк юзер введет строку, а не число
            // программа выдаст ошибку, nextline разрешает ипользовать пробелы в строке юзера
            //считает command.equals("") из-за ентера в конце шагов

             if (command.equals("1")) {
                //задать кол-во шагов за день
                stepTracker.addNewNumberStepsPerDay();
            } else if (command.equals("2")) {
                //установить цель
                stepTracker.changeStepGoal();
            } else if (command.equals("3")) {
                //вывести статистику
                stepTracker.printStatistic();
            } else if (command.equals("4")) {
                System.out.println("До встречи !!!");
                scanner.close(); // завершение работы scanner
                return;
            } else {
                System.out.println("Ты наверное ошибся, такой команды нет, попробуй еще раз: введи 1-2-3-4");
            }

        } // while

    }

    static void printMenu() {
        System.out.println("Введите команду: Где 1 - задать кол-во шагов за день; ");// Вывод доступных команд
        System.out.println("                     2 - установить цель на день; ");// Вывод доступных команд
        System.out.println("                     3 - вывести статисику; ");// Вывод доступных команд
        System.out.println("                     4 - выйти из программы ");// Вывод доступных команд



    }
}
