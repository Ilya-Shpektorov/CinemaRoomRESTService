package cinema.Models;

public class Seat {
    private int row;
    private int column;
    private boolean isFree;

    public Seat(int row, int column, boolean isFree) {
        this.row = row;
        this.column = column;
        this.isFree = isFree;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public String getSeatNum() {
        return String.format("{\n" +
                "\"row\":%d,\n" +
                "\"column\":%d\n" +
                "}", row, column);
    }
}
