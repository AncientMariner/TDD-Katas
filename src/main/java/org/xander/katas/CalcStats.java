package org.xander.katas;

public class CalcStats {


    public Statistics calculateNumbers(int[] arrayOfNumbers) {
        int counterOfElements = 0;
        for (int elementInArray : arrayOfNumbers) {
            counterOfElements++;
        }

        int minimumValue = 0;
        for (int min : arrayOfNumbers) {
            if (min <= minimumValue) {
                minimumValue = min;
            }
        }

        int maximumValue = 0;
        for (int max : arrayOfNumbers) {
            if (max >= maximumValue) {
                maximumValue = max;
            }
        }

        double averageValue = 0;
        for (int value : arrayOfNumbers) {
            averageValue += value;
        }
        averageValue = (averageValue) / ((double) arrayOfNumbers.length);

        return new Statistics(minimumValue, maximumValue, counterOfElements, averageValue);
    }

    public class Statistics {
        private int minimumValue;
        private int maximumValue;
        private int numberOfElementsInSequence;
        private double averageValue;

        public Statistics(int minimumValue, int maximumValue, int numberOfElementsInSequence, double averageValue) {
            this.averageValue = averageValue;
            this.minimumValue = minimumValue;
            this.maximumValue = maximumValue;
            this.numberOfElementsInSequence = numberOfElementsInSequence;
        }

        public int getMinimumValue() {
            return minimumValue;
        }

        public int getMaximumValue() {
            return maximumValue;
        }

        public int getNumberOfElementsInSequence() {
            return numberOfElementsInSequence;
        }

        public double getAverageValue() {
            return averageValue;
        }
    }
}
