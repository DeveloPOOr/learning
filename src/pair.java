import java.util.Objects;

class Pair <X,Y> {
    private X first = null;
    private Y second = null;

    public X getFirst() {
        return first;
    }

    public Y getSecond() {
        return second;
    }

    private Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public static <X, Y> Pair<X, Y> of(X first, Y second) {
        return new Pair<>(first, second);
    }

    public boolean equals(Pair<X, Y> pair) {
        if (this == pair) {
            return true;
        }
        if (Objects.equals(this.first, pair.first) == true && Objects.equals(this.second, pair.second) == true) {
            return true;
        }
        return false;

    }

    public int hashCode() {
        return Objects.hash(this.first, this.second);
    }
}
