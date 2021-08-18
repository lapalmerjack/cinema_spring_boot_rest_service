package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Theater {

    private int totalRows;
    private int totalColumns;
    private List<Seating> availableSeats;
    private List<TokenAndSeating> tokenHolder;

    public Theater(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = makeSeats();
        tokenHolder = new ArrayList<>();
    }

    public void removeSeating (Seating seating) {
        availableSeats.remove(seating);
    }

    public void addTokens(TokenAndSeating tokenSaver) {
        this.tokenHolder.add(tokenSaver);
    }

    public boolean checkSeatingAvailability(Seating seating) {
        return this.availableSeats.contains(seating);
    }



    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seating> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seating> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Seating getSeating(int row, int column) {
        Seating savedSeat = null;
        for(Seating seats : this.availableSeats) {
            if(row == seats.getRow() && column == seats.getColumn()) {
                savedSeat = seats;

            }
        }

        return savedSeat;
    }

    private  List<Seating> makeSeats() {
        List<Seating> seating = new ArrayList<>();
        int rows = getTotalRows();
        int columns = getTotalColumns();
        int [][] twoDimensionalArray = new int [rows][columns];

        for(int row = 0; row < twoDimensionalArray.length; row ++) {
            for(int column = 0; column < twoDimensionalArray[row].length; column ++) {
                if (row <= 4) {
                    seating.add(new Seating(row + 1, column + 1, 10));
                } else {
                    seating.add(new Seating(row + 1, column + 1, 8));
                }
            }
        }

        return seating;
    }
}
