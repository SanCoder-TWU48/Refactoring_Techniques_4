package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    private int count(NumberFilter numberFilter) {
        int count = 0;
        for (int number : numbers) {
            if (numberFilter.satisfy(number)) count++;
        }
        return count;
    }

    public int countEven() {
        return count(new NumberFilter() {
            @Override
            public boolean satisfy(int number) {
                return number % 2 == 0;
            }
        });
    }

    public int countOdd() {
        return count(new NumberFilter() {
            @Override
            public boolean satisfy(int number) {
                return number % 2 == 1;
            }
        });
    }

    public int countPositive() {
        return count(new NumberFilter() {
            @Override
            public boolean satisfy(int number) {
                return number >= 0;
            }
        });
    }

    public int countNegative() {
        return count(new NumberFilter() {
            @Override
            public boolean satisfy(int number) {
                return number < 0;
            }
        });
    }
}
