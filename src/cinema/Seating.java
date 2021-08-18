package cinema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class Seating {

    private int row;
    private int column;
    private int price;

    public Seating(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
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

    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seating seating = (Seating) o;
        return row == seating.row && column == seating.column && price == seating.price;
    }


}

@JsonIgnoreProperties(ignoreUnknown = true)
class TokenAndSeating {


    private String token;
    private Seating Ticket;


    public TokenAndSeating() {
    }

    public TokenAndSeating(String uuid) {
        this.token = uuid;
    }

    public TokenAndSeating(String token, Seating ticket) {
        this.Ticket = ticket;
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }


    public Seating getTicket() {
        return Ticket;
    }

    public void setTicket(Seating ticket) {
        this.Ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenAndSeating that = (TokenAndSeating) o;
        return Objects.equals(token, that.token) && Objects.equals(Ticket, that.Ticket);
    }


}

class ReturnedTicket {

    private Seating returnedTicket;


    public ReturnedTicket(Seating returnedTicket) {
        this.returnedTicket = returnedTicket;

    }

    public ReturnedTicket() {
    }

    public Seating getReturnedTicket() {
        return returnedTicket;
    }

    public void setReturnedTicket(Seating returnedTicket) {
        this.returnedTicket = returnedTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnedTicket that = (ReturnedTicket) o;
        return Objects.equals(returnedTicket, that.returnedTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returnedTicket);
    }
}
