//перевод в Ккалл и км
class Converter {
    //количество шагов в километры;
    int convertStepsToKm(int steps) {
        return (int)(steps * 0.00075); //один шаг - 75см
    }

    //количество шагов в потраченные килокалории
    int convertStepsToKilocalories(int steps) {
        return (int)(steps * 0.05); //один шаг - 50кал
    }
}
