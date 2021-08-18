package cinema;

public class Stats {

     private int currentIncome = 0;
     private int numberOfAvailableSeats;
     private int numberOfPurchasedTickets = 0;

    public Stats() {
    }

    public Stats(int currentIncome, int numberOfAvailableSeats, int numberOfPurchasedSeats) {
        this.currentIncome = currentIncome;
        this.numberOfAvailableSeats = numberOfAvailableSeats;
        this.numberOfPurchasedTickets = numberOfPurchasedSeats;
    }

    public Stats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }


    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void addingStatsInfo(int income, int seats, int purchased) {
        currentIncome += income;
        numberOfAvailableSeats -= seats;
        numberOfPurchasedTickets += purchased;
    }
    public void subtractingInfo(int income, int seats, int purchased) {
        currentIncome -= income;
        numberOfAvailableSeats += seats;
        numberOfPurchasedTickets -= purchased;
    }


}
