package cinema;

public class FindSeat {

    private int row;
    private int column;

    public FindSeat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public FindSeat() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
