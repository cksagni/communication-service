package vehiclerental.entity;

import java.time.LocalDateTime;

public class Reservation {

    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Branch branch;


    public Reservation(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime, Branch branch) {
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.branch = branch;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
