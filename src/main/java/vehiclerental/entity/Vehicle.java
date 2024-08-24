package vehiclerental.entity;

import vehiclerental.constants.VehicleType;

public class Vehicle {

    private int id;
    private String name;
    private VehicleType vehicleType;

    public Vehicle(int id, String name, VehicleType vehicleType) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
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

}
