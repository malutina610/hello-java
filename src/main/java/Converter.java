public class Converter {
    public double convertStepsToKilocalories(final int sumStepsFromMonth) {
        double burnedKiloCalories = 0;
        int burnStep = 50;
        double burnCalories=sumStepsFromMonth*burnStep;
        if(burnCalories > 0) {
            burnedKiloCalories = burnCalories / 1000;
        }
        return burnedKiloCalories;
    }

    public double stepToKm(final int sumStepsFromMonth) {
        double sumStepsMonthKM = 0;
        int oneStep = 75;
        double sumMonthSM = sumStepsFromMonth * oneStep;
        if (sumMonthSM > 0) {
            sumStepsMonthKM = sumMonthSM / 100000;
        }
        return sumStepsMonthKM;
    }
}
