package com.library.datastructures.divide;

public class DecreaseAndConquer {

    public int greatestCommonDivisor(int width, int length) {
        if (width == 0) {
            return length;
        } else {
            return greatestCommonDivisor(length % width, width);
        }
    }

    public int greatestCommonDivisorNonRecursive(int width, int length) {
        while (width > 0) {
            int reminder = length % width;
            length = width;
            width = reminder;
        }
        return length;
    }
}
