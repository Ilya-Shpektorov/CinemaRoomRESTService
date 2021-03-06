package cinema.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class Cinema {

    private final int totalRows = 9;
    private final int totalColumns = 9;
    private Seat[] seats = new Seat[totalColumns * totalColumns];
    private List<Ticket> activeTickets = new ArrayList<>();
    private Statistic statistic = new Statistic(0, seats.length, 0);

    public Cinema() {
        if (seats[0] == null) {
            createSeats();
        }
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    @Bean
    @JsonIgnore
    public Statistic getStatistic() {
        statistic.setNumberOfAvailableSeats(getAvailableSeats().length);
        return statistic;
    }

    @JsonIgnore
    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }

    @JsonIgnore
    public Optional<Seat> getSeat(int row, int column) {
        Optional<Seat> seatOpt = Arrays.stream(seats)
                .filter(s -> s.getRow() == row && s.getColumn() == column)
                .findFirst();
        return seatOpt;
    }

    @JsonIgnore
    public Seat[] getSeats() {
        return seats.clone();
    }

    public Seat[] getAvailableSeats() {
        return Arrays.stream(seats).filter(Seat::isAvailable).toArray(Seat[]::new);
    }

    public void addNewActiveTicket(Ticket activeTicket) {
        this.activeTickets.add(activeTicket);
    }

    public void removeActiveTicket(Ticket activeTicket) {
        this.activeTickets.remove(activeTicket);
    }

    @JsonIgnore
    public List<Ticket> getActiveTickets() {
        return activeTickets;
    }

    private void createSeats() {
        int seatCounter = 0;
        for (int r = 1; r <= totalRows; r++) {
            for (int c = 1; c <= totalColumns; c++) {
                seats[seatCounter] = new Seat(r, c, true);
                seatCounter++;
            }
        }
    }
}
