package game.model;

public class CompareResult {
    private final int a;
    private final int b;

    public CompareResult(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString() {
        return a + "A" + b + "B";
    }
}
