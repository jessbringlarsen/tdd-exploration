package dk.bringlarsen.tdd.levenshteindistance;

import java.util.Objects;

public class LevenshteinDistance {
    private final byte[] first;
    private final byte[] second;

    public LevenshteinDistance(String first, String second) {
        this.first = Objects.isNull(first) ? new byte[0] : first.getBytes();
        this.second = Objects.isNull(second) ? new byte[0] : second.getBytes();
    }

    public int getDistance() {
        int result = 0;
        int length = Math.max(first.length, second.length);
        for (int index=0; index<length; index++) {
            if (getOrBlank(first, index) != getOrBlank(second, index)) {
                result++;
            }
        }
        return result;
    }

    private int getOrBlank(byte[] string, int index) {
        return index > string.length-1 ? ' ' : string[index];
    }
}
