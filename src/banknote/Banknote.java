package banknote;

import java.util.Objects;
import java.util.Random;

public class Banknote implements Comparable<Banknote> {
    private int value;

    public Banknote() {
        int randomValue = new Random().nextInt(9);
        switch (randomValue) {
            case 0:
                this.value = 1;
                break;
            case 1:
                this.value = 2;
                break;
            case 2:
                this.value = 5;
                break;
            case 3:
                this.value = 10;
                break;
            case 4:
                this.value = 20;
                break;
            case 5:
                this.value = 50;
                break;
            case 6:
                this.value = 100;
                break;
            case 7:
                this.value = 200;
                break;
            case 8:
                this.value = 500;
                break;
        }
    }

    public Banknote(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Banknote other) {
        return Integer.compare(this.value, other.value);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Banknote other = (Banknote) obj;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
