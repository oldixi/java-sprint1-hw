// Сохранение и изменение количества шагов, вывод статистики
import java.util.Scanner;
class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter conv = new Converter();

    //конструктор
    StepTracker (Scanner scannerStepGoal) {
        scanner = scannerStepGoal;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    //сохранение количества шагов
    void addNewNumberStepsPerDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца");
        int monthNum = scanner.nextInt();
        if (monthNum < 1 || monthNum > 12) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно.");
            return;
        }

        System.out.println("Введите номер дня (от 1 до 30 включительно).");
        int dayNum = scanner.nextInt();
        if (dayNum < 1 || dayNum > 30) {
            System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно.");
            return;
        }

        System.out.println("Введите количество шагов");
        int stepCnt = scanner.nextInt();
        if (stepCnt < 0) {
            System.out.println("Количество шагов не может быть отрицательным.");
            return;
        }

        MonthData monthData = monthToData[monthNum-1]; //получим нужный элемент monthData из массива monthToData объектов класса MonthData
        monthData.days[dayNum-1] = stepCnt; //запишим количество шагов в нужный элемент массива days объекта monthData
    }

    //изменение целевого количества шагов
    void changeStepGoal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целевое количество шагов в день.");
        int stepGoalCnt = scanner.nextInt();
        if (stepGoalCnt < 1 ) {
            System.out.println("Целевое количество шагов должно быть положительным.");
        } else {
            goalByStepsPerDay = stepGoalCnt;
            System.out.println("Ваша новая цель: " + stepGoalCnt + " шагов в день. Удачи!");
        }
    }

    //вывод статистики за месяц
    void printStatistic() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца для вывода статистики");
        int monthNum = scanner.nextInt();
        if (monthNum < 1 || monthNum > 12) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно.");
            return;
        }

        MonthData monthData = monthToData[monthNum-1];
        int stepCntSum = monthData.sumStepsFromMonth();

        System.out.println("Количество пройденных шагов по дням.");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + stepCntSum);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов за месяц: " + stepCntSum/30);
        System.out.println("Пройденная дистанция (в км): " + conv.convertStepsToKm(stepCntSum));
        System.out.println("Количество сожжённых килокалорий: " + conv.convertStepsToKilocalories(stepCntSum));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
