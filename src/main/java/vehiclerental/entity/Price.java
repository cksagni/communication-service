package vehiclerental.entity;

import vehiclerental.constants.VehicleType;

public class Price {
    private int id;
    private Branch branch;
    private VehicleType vehicleType;
    private int perHourPrice;

    public Price(int id, Branch branch, VehicleType vehicleType, int perHourPrice) {
        this.id = id;
        this.branch = branch;
        this.vehicleType = vehicleType;
        this.perHourPrice = perHourPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getPerHourPrice() {
        return perHourPrice;
    }

    public void setPerHourPrice(int perHourPrice) {
        this.perHourPrice = perHourPrice;
    }
}
