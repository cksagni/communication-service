package movieticketbooking.entity;

public class Movie {
    int id;
    String name;
    int durationInMinutes;

    public Movie(int id, String name, int durationInMinutes) {
        this.id = id;
        this.name = name;
        this.durationInMinutes = durationInMinutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                '}';
    }
}
