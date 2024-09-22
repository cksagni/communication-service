package movieticketbooking.entity;

import java.util.List;

public class Theatre {
    int id;
    String address;
    City city;
    List<Screen> screen;
    List<Show> shows;

    public Theatre(int id, String address, City city, List<Screen> screen, List<Show> shows) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.screen = screen;
        this.shows = shows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreen() {
        return screen;
    }

    public void setScreen(List<Screen> screen) {
        this.screen = screen;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", screen=" + screen +
                ", shows=" + shows +
                '}';
    }
}
