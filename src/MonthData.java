class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i+1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int stepCntSum = 0;
        for (int i: days) {
            stepCntSum = stepCntSum + i;
        }
        return stepCntSum;
    }

    int maxSteps() {
        int stepCntMax = 0;
        for (int i: days) {
            if (i > stepCntMax) {
                stepCntMax = i;
            }
        }
        return stepCntMax;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        int index = 0;
        int cnt = 0;

        while (index < days.length) {
            for (int i = index; i < days.length; i++) {
                cnt = i + 1;
                if (days[i] >= goalByStepsPerDay) {
                    currentSeries = currentSeries + 1;
                    if (currentSeries > finalSeries) {
                        finalSeries = currentSeries;
                    }
                } else {
                    currentSeries = 0;
                    break;
                }
            }
            index = cnt;
        }
        return finalSeries;
    }
}
