public class Converter {
       //метод, переводящий количество шагов в килокалории
       //1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.
       public double convertStepsToKilocalories(int steps) {
       return 0;
   }

       //метод, переводящий количество шагов километры;
       // 1 шаг = 75 см
        public double stepToKm(final int sumStepsFromMonth) {
           double sumStepsMonthKM=0;
           int oneStep=75;
           int sumMonthSM=sumStepsFromMonth*oneStep;//один шаг*кол-во шагов
           if (sumMonthSM>0){
               sumStepsMonthKM=sumMonthSM/100000;
           }
        return sumStepsMonthKM;
    }

}
