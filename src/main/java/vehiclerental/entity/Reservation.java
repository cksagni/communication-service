package vehiclerental.entity;

import java.time.LocalDateTime;

public class Reservation {

    private int Id;
    private Vehicle vehicle;
    private User user;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Branch branch;

    public Reservation(int id, Vehicle vehicle, User user, LocalDateTime startTime, LocalDateTime endTime, Branch branch) {
        Id = id;
        this.vehicle = vehicle;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.branch = branch;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
