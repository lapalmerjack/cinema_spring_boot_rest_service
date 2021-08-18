package cinema;



import cinema.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class Controller {

    Theater theater = new Theater(9,9);
    Stats stats = new Stats(theater.getTotalColumns()* theater.getTotalRows());
   ConcurrentMap<String, Seating> savePurchasedSeats = new ConcurrentHashMap<>();




    @GetMapping("/seats")
    public Theater getSeating () {
        return theater;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTickets(@RequestBody FindSeat seating) {
        ErrorResponse errorResponse = new ErrorResponse();
        if(seating.getRow() > theater.getTotalRows()  || seating.getRow() < 1 || seating.getColumn() < 1
                || seating.getColumn() > theater.getTotalColumns()) {
            errorResponse.setError("The number of a row or a column is out of bounds!");
            return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
        }
        Seating mySeat = theater.getSeating(seating.getRow(), seating.getColumn());
        UUID uuid = UUID.randomUUID();
        TokenAndSeating tokenAndSeating = new TokenAndSeating(uuid.toString(),mySeat);
        if(!theater.checkSeatingAvailability(mySeat)) {
            errorResponse.setError("The ticket has been already purchased!");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }
        theater.removeSeating(mySeat);
        stats.addingStatsInfo(mySeat.getPrice(), 1, 1);
        savePurchasedSeats.put(tokenAndSeating.getToken(), tokenAndSeating.getTicket());



        return new ResponseEntity<>(tokenAndSeating, HttpStatus.OK);
    }


    @PostMapping("/return")
    public ResponseEntity<?>returnTicket(@RequestBody TokenAndSeating uuid) {
        ErrorResponse errorResponse = new ErrorResponse();
        System.out.println(uuid.getToken());
        System.out.println(savePurchasedSeats);

        if(!savePurchasedSeats.containsKey(uuid.getToken())) {
            errorResponse.setError("Wrong token!");
           return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        }

        System.out.println("It's the same!");
        uuid.setTicket(savePurchasedSeats.get(uuid.getToken()));
        savePurchasedSeats.remove(uuid.getToken());

        ReturnedTicket ticketReturn = new ReturnedTicket();
        ticketReturn.setReturnedTicket(uuid.getTicket());
        stats.subtractingInfo(uuid.getTicket().getPrice(),1,1);
        return new ResponseEntity<>(ticketReturn, HttpStatus.OK);

    }

    @PostMapping("/stats")
    public ResponseEntity<?>statOfCinema(@RequestParam(value = "password", required = false) String password) {
        ErrorResponse errorResponse = new ErrorResponse();

        if(password == null || !password.equals("super_secret")) {
            errorResponse.setError("The password is wrong!");
            System.out.println(password);
            return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);

        }

        return new ResponseEntity<>(stats, HttpStatus.OK);

    }















}
