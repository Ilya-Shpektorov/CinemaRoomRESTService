package cinema.Models;

import org.springframework.stereotype.Component;

@Component
public class Cinema {

    private final int totalRows = 9;
    private final int totalColumns = 9;
    private Seat[] availableSeats = new Seat[totalColumns * totalColumns];

    public Cinema() {
        if (availableSeats[0] == null) {
            createSeats();
        }
    }

    public String getAvailableSeatsInfo() {
        StringBuffer info = new StringBuffer("{\n");
        info.append("\"total_rows\":" + totalRows + ",\n");
        info.append("\"total_columns\":" + totalColumns + ",\n");
        info.append("\"available_seats\":[\n" + getAvailableSeats());
        info.append("\n]");
        info.append("\n}");
        return info.toString();
    }

    private String getAvailableSeats() {
        StringBuffer seats = new StringBuffer();
        for (int i = 0; i < availableSeats.length; i++) {
            seats.append(availableSeats[i].getSeatNum());
            if (i != availableSeats.length - 1) {
                seats.append(",\n");
            }
        }
        return seats.toString();
    }

    private void createSeats() {
        int seatCounter = 0;
        for (int r = 1; r <= totalRows; r++) {
            for (int c = 1; c <= totalColumns; c++) {
                availableSeats[seatCounter] = new Seat(r, c, true);
                seatCounter++;
            }
        }
    }
}
