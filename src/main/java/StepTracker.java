
import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    Converter converter;
    MonthData[] monthToData;    //= new MonthData[12];//monthToData - переменная в которой хранится массив
    //MonthData[] -массив  monthToData - переменная в классе
    int goalByStepsPerDay = 10000; //цель по Шагам в день изначально по условию задачи равна 10000

    // Конструктор
    StepTracker(Scanner scan) {
        scanner = scan;
        converter = new Converter();

        monthToData = new MonthData[12];// вызываю конструктор этого объекта MonthData
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    //Методы
    void addNewNumberStepsPerDay() {
        // ввод и проверка номера месяца
        System.out.println("Введите номер месяца от 1 до 12");
        printMonth();
        int month = scanner.nextInt();// ввели с клавиатуры номер месяца
        // проверка
        if (month < 1 || month > 12) {
            System.out.println("Введен некорректный месяц");
            printMonth();
            return; // нужно вернуться не в начало ?
        }
        // ввод и проверка дня
        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Введено некорректное число месяца, необходтимо ввести от 1 до 30 ");
            return; // нужно вернуться  к выбору дня
        }
        // ввод и проверка количества шагов
        System.out.println("Введите количество шагов");
        int step = scanner.nextInt();
        if (step < 0 || step > 100000) {
            System.out.println("Введено некорректное значение шагов, необходимо ввести от 0 до 100000");
            return; // нужно вернуться не в начало ?
        }
        if (monthToData[month - 1].days[day - 1] !=0){
            System.out.println(month+" месяц" +"-"+day+" день, здесь уже есть данные - "+monthToData[month - 1].days[day - 1]+" шагов");
            System.out.println("Желаете изменить данные? 1 - Да; 2- Нет ");
            String command = scanner.next();
            if (command.equals("2")) {
                return;
            }
        }
        // Получение соответствующего объекта MonthData из массива
        // Сохранение данных
        // MonthData monthData = monthToData[month - 1];//скопировала объект // получили нужный месяц
        monthToData[month - 1].days[day - 1] = step; // обращаемся к массиву  monthToData получили нужный день,записали шаги
        //final int[] days = monthData.days; // заменили monthData.days[....] = .....
        //days[day-1] = step;
    }
    void printStatistic() {
        // ввод и проверка номера месяца
        System.out.println("Введите число месяца от 1 до 12");
        printMonth();

        int month = scanner.nextInt();// ввели месяц с клавиатуры
        String naimMonth = "";

        //проверка - введенный месяц 1< или>12
        if (month < 1 || month > 12) {
            System.out.println("Введен некорректный месяц");
            printMonth();
            return;
        } else {
            switch (month) {
                case 1 -> naimMonth = "январь";
                case 2 -> naimMonth = "февраль";
                case 3 -> naimMonth = "март";
                case 4 -> naimMonth = "апрель";
                case 5 -> naimMonth = "май";
                case 6 -> naimMonth = "июнь";
                case 7 -> naimMonth = "июль";
                case 8 -> naimMonth = "август";
                case 9-> naimMonth = "сентябрь";
                case 10 -> naimMonth = "октябрь";
                case 11 -> naimMonth = "ноябрь";
                case 12 -> naimMonth = "декабрь";
            }
        }
        MonthData monthData = monthToData[month-1];//все данные (по дням) за выбранный месяц
        System.out.println("ВЫВОД ОБЩЕЙ СТАТИСТИКИ: " );
        System.out.println("вывод суммы шагов за " +naimMonth +" месяц:" + monthData.sumStepsFromMonth());
        System.out.println("вывод максимального пройденного количества шагов за " +naimMonth +" месяц: "+ monthData.maxSteps());
        System.out.println("вывод среднего пройденного количества шагов за " +naimMonth +" месяц: "+monthData.averageValue(monthData.sumStepsFromMonth()));
        System.out.println("вывод пройденной за месяц дистанции в км " + converter.stepToKm(monthData.sumStepsFromMonth()));
        System.out.println("вывод количества сожжённых килокалорий за " +naimMonth +" месяц: "+ converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
        System.out.println("вывод лучшей серии  за" +naimMonth +" месяц: "+monthData.bestSeries(goalByStepsPerDay));//+monthData.bestSession()
        System.out.println(); //дополнительный перенос строки
        System.out.println("Вывод статистики за  " +naimMonth +" месяц: ");
        //monthData.printDaysAndStepsFromMonth(monthData);//
        monthData.printDaysAndStepsFromMonth();//
    }
    private void printMonth() {
        System.out.println("Январь - 1, ...... , Декабрь - 12 ");
    }
    public void changeStepGoal() {
        System.out.println("Задайте цель шагов: ");
        goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay <0 ||goalByStepsPerDay == 0) {
            System.out.println("Введено некорректное значение, цель должна быть больше 0");
           // return;
        }

    }
}


