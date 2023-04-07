class Converter {
    int convertStepsToKm(int steps) {
        return (int)(steps * 0.00075); //один шаг - 75см
    }
    int convertStepsToKilocalories(int steps) {
        return (int)(steps * 0.05); //один шаг - 50кал
    }
}
