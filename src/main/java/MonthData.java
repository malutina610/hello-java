import java.util.Arrays;

public class MonthData {

    int[] days = new int[30]; // размер массива days =30

    // в этом месяце month выведи все дни списком???
    //<monthData, month> void printDaysAndStepsFromMonth(MonthData monthData) {
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " день: " + days[i] + " шагов");// + Arrays.toString(days))
            // Вывод элементов массива в необходимом формате
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            // подсчёт суммы элементов массива days[]
            sumSteps = sumSteps + days[i]; ////////
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            maxSteps = Math.max(maxSteps, days[i]);
            // поиск максимального элемента
            final int completedSteps = days[i];
            if (completedSteps > maxSteps) {
                maxSteps = completedSteps; ////////////
            }
        }
        return maxSteps;
    }

    // int goalByStepsPerDay = 10000; //цель по Шагам в день изначально по условию задачи равна 10000
    // или измененная пользователем далее в коде
    int bestSeries(int goalByStepsPerDay) {
        int bestSession = 0;//Лучшая сессия
        int countBest = 0; //счет сессий
        //completedSteps -  Пройденные шаги
        //goalByStepsPerDay -Цель на следующий день

        for (int i = 0; i < days.length; i++) {
            // поиск максимальной серии
            final int completedSteps = days[i];// final - означает что переменная не будет изменяться
            if (completedSteps >= goalByStepsPerDay) {
                bestSession = completedSteps; // Если шаги больше чем цель то увеличим лучшую сессию
                countBest++; //счет сессий
            } else {
                //  System.out.println(" Заданная цель в "+goalByStepsPerDay+" шагов в день не достигнута!!!");
                bestSession = 0; //счет сессий сбросить
                // установить countBest и очистить bestSession
                // Придумать что будет если цель не достигнута
                countBest = 0;
            }
            return countBest;
        }
        return bestSession;
    }

    //подсчитаем среднее количество пройденных шагов
    double averageValue() {
        // среднее арифметическое - сумма всех чисел деленная на их количество

        double average = 0;// среднее =0
        if (days.length > 0) {
            double sum = 0;
            for (int j = 0; j < days.length; j++) {
                sum += days[j];
            }
            average = sum / days.length;
        }
        return average;
    }
}
