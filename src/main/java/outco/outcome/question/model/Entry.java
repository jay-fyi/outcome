package outco.outcome.question.model;

public class Entry {
    public int num;
    public int listIdx;
    public int elementIdx;

    public Entry(int num, int listIdx, int elementIdx) {
        this.num = num;
        this.listIdx = listIdx;
        this.elementIdx = elementIdx;
    }

    @Override
    public String toString() {
        return "{n=" + num + ", l=" + listIdx + ", e=" + elementIdx + "}";
    }

}
