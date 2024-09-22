package movieticketbooking.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Show {
    int id;
    Movie movie;
    Screen screen;
    LocalDateTime showStartTime;
    List<Seat> bookedSeats;

    public Show(int id, Movie movie, Screen screen, LocalDateTime showStartTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.showStartTime = showStartTime;
        this.bookedSeats = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public LocalDateTime getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(LocalDateTime showStartTime) {
        this.showStartTime = showStartTime;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", movie=" + movie +
                ", screen=" + screen +
                ", showStartTime=" + showStartTime +
                ", bookedSeats=" + bookedSeats +
                '}';
    }
}
