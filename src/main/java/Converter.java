public class Converter {
    //метод, переводящий количество шагов в килокалории
    //1 шаг = 50 калорий, 1 килокалория = 1000 калорий.
    public double convertStepsToKilocalories(final int sumStepsFromMonth) {
        double burnedKiloCalories=0;// соженные килокалории
        int burnStep=50;
        double burnCalories=sumStepsFromMonth*burnStep;//один шаг*кол-во шагов
        if(burnCalories>0){
            burnedKiloCalories=burnCalories/1000;
        }
        return burnedKiloCalories;
    }

    //метод, переводящий количество шагов километры;
    // 1 шаг = 75 см
    public double stepToKm(final int sumStepsFromMonth) {
        double sumStepsMonthKM=0;
        int oneStep=75;
        double sumMonthSM=sumStepsFromMonth*oneStep;//один шаг*кол-во шагов
        if (sumMonthSM>0){
            sumStepsMonthKM=sumMonthSM/100000;
        }
        return sumStepsMonthKM;
    }

}
