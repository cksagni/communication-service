package vehiclerental.entity;

import vehiclerental.constants.VehicleType;

public class Vehicle {

    private int id;
    private String name;
    private VehicleType vehicleType;
    private Branch branch;

    public Vehicle(int id, String name, VehicleType vehicleType, Branch branch) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
        this.branch = branch;
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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
