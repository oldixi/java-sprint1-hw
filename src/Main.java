import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                stepTracker.changeStepGoal();
            } else if (command == 2) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 0) {
                System.out.println("Выход");
                System.exit(0);
            } else {
                System.out.println("Данная команда не поддерживается");
            }
        }
    }

    static void printMenu() {
        System.out.println("\nВыберите действие: \n" +
                "1 - Ввод цели по количеству шагов в день \n" +
                "2 - Ввод пройденного количества шагов за день \n" +
                "3 - Вывод статистики за месяц \n" +
                "0 - Выход \n");
    }
}