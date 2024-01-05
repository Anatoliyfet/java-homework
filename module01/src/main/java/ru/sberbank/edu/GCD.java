package ru.sberbank.edu;

public class GCD implements CommonDivisor {

    /**
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    @Override
    public int getDivisor(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int tmp = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = tmp;
        }
        return firstNumber;

    }
}