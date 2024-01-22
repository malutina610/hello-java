
import java.util.Arrays;
import java.util.Scanner;

public class StepTracker {

    Scanner scanner;
    Converter converter;
    MonthData[] monthToData ;    //= new MonthData[12];
    int goalByStepsPerDay=10000; //цель по Шагам в день изначально по условию задачи равна 10000


    // Конструктор
    StepTracker(Scanner scan) {
        scanner = scan;
        converter = new Converter();

        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    //Методы

    void addNewNumberStepsPerDay() {
        // ввод и проверка номера месяца
        System.out.println("Введите номер месяца от 1 до 12");
        printMonth();
        int month = scanner.nextInt();
        // проверка
        if (month <1 || month > 12) {
            System.out.println("Введен некорректный месяц");
            printMonth();
            return; // нужно вернуться не в начало ?
        }

        // ввод и проверка дня
        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day <1 || day > 30) {
            System.out.println("Введено некорректное число месяца, необходтимо ввести от 1 до 30 ");
            return ; // нужно вернуться не в начало а к выбору дня?
        }

        // ввод и проверка количества шагов
        System.out.println("Введите количество шагов");
        int step = scanner.nextInt();
        if (step <0 || step > 100000) {
            System.out.println("Введено некорректное значение шагов, необходимо ввести от 0 до 20000");
            return; // нужно вернуться не в начало ?
        }

        // Получение соответствующего объекта MonthData из массива
        // Сохранение данных
        // MonthData monthData = monthToData[month - 1];//скопировала объект
        monthToData[month-1].days[day-1]=step;
        //final int[] days = monthData.days; // заменили monthData.days[....] = .....
        //days[day-1] = step;

    }

    void printStatistic() {
        // ввод и проверка номера месяца
        System.out.println("Введите число месяца от 1 до 12");
        printMonth();

        int month = scanner.nextInt();
        //проверка - введенный месц 0< или>12
        if (month <0 || month > 12) {
            System.out.println("Введен некорректный месяц");
            printMonth();
            return;
        }

        MonthData monthData = monthToData[month];
        //*   long sumSteps = // получение суммы шагов за месяц
        System.out.println("ВЫВОД ОБЩЕЙ СТАТИСТИКИ: " );
        System.out.println("вывод суммы шагов за месяц: " + monthData.sumStepsFromMonth());
        System.out.println("вывод максимального пройденного количества шагов за месяц: " + monthData.maxSteps());
        System.out.println("вывод среднего пройденного количества шагов за месяц: ");
        System.out.println("вывод пройденной за месяц дистанции в км " + converter.stepToKm(monthData.sumStepsFromMonth()));
        System.out.println("вывод количества сожжённых килокалорий за месяц "+ converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
        System.out.println("вывод лучшей серии");//+monthData.bestSession()
        System.out.println(); //дополнительный перенос строки
        System.out.println("ВЫВОД СТАТИСТИКИ ЗА  " + month +" месяц");
        monthData.printDaysAndStepsFromMonth();
    }

    private void printMonth() {
        System.out.println("Январь - 1, ...... , Декабрь - 12 ");
    }

    public void changeStepGoal() {
          System.out.println("Задайте цель: ");
          goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay <0 ||goalByStepsPerDay == 0) {
            System.out.println("Введено некорректное значение, цель должна быть больше 0");
            return;
        }

    }
}


