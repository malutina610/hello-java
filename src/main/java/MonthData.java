import java.util.Arrays;

public class MonthData {

       int[] days = new int[30]; // размер массива days =30
        // в этом месяце month выведи все дни списком???
        //<monthData, month> void printDaysAndStepsFromMonth(MonthData monthData) {
         void printDaysAndStepsFromMonth() {
              for (int i = 0; i < days.length; i++) {
              System.out.println(i +1+ " день: "+ days[i] );// + Arrays.toString(days))
              // Вывод элементов массива в необходимом формате
              }
        }
        int sumStepsFromMonth() {
                int sumSteps = 0;
                for (int i = 0; i < days.length; i++) {
                    // подсчёт суммы элементов массива days[]
                    sumSteps = sumSteps + days[i]; ////////
                    // int dayI = i+1;
                   //  System.out.println(dayI + "день: " + Arrays.toString(days));
                }
                return sumSteps;
        }
        int maxSteps() {
                int maxSteps = 0;
                for (int i = 0; i < days.length; i++) {
                maxSteps = Math.max(maxSteps, days[i]);
                // поиск максимального элемента
                final int  completedSteps = days[i];
                if (completedSteps > maxSteps){
                   maxSteps = completedSteps ; ////////////
                }
                }
                return maxSteps;
        }
        int bestSeries(int goalByStepsPerDay) {
                int bestSession = 0;//Лучшая сессия
                int countBest = 0; //счет сессий
                //completedSteps -  Пройденные шаги
                //goalByStepsPerDay -Цель на следующий день

                for (int i = 0; i < days.length; i++) {
                        // поиск максимальной серии
                        final int completedSteps = days[i];// final - означает что переменная не будет изменяться
                        if (completedSteps >= goalByStepsPerDay) {
                                bestSession = goalByStepsPerDay; // Если шаги больше чем цель то увеличим лучшую сессию
                        } else {
                                // установить countBest и очистить bestSession
                                // Придумать что будет если цель не достигнута
                                countBest = countBest ;
                        }
                        return countBest;
                }
                return bestSession;
        }


}
