public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " день: " + days[i] + " шагов");
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            maxSteps = Math.max(maxSteps, days[i]);
            final int completedSteps = days[i];
            if (completedSteps > maxSteps) {
                maxSteps = completedSteps;
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int bestSession = 0;
        int countBest = 0;
        for (final int completedSteps : days) {
            if (completedSteps >= goalByStepsPerDay) {
                countBest++;
                if (countBest > 2) {
                    bestSession++;
                }
            } else {
                countBest = 0;
            }
        }
        return bestSession;
    }

    double averageValue(int sumStep) {
        int averageStepMonth = sumStep / days.length;
        return averageStepMonth;
    }
}
