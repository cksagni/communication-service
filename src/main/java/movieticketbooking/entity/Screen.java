package movieticketbooking.entity;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int id;
    List<Seat> seats = new ArrayList<>();

    public Screen(int id, List<Seat> seats) {
        this.id = id;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id=" + id +
                ", seats=" + seats +
                '}';
    }
}
