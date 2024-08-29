package vehiclerental.entity;

import vehiclerental.constants.VehicleType;

import java.util.HashMap;
import java.util.List;

public class Branch {
    private String name;
    private HashMap<VehicleType, List<Vehicle>> vehicles;
    private HashMap<VehicleType, Integer> prices;

    public Branch(String name, HashMap<VehicleType, List<Vehicle>> vehicles, HashMap<VehicleType, Integer> prices) {
        this.name = name;
        this.vehicles = vehicles;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<VehicleType, List<Vehicle>> getVehicles() {
        return vehicles;
    }

    public void setVehicles(HashMap<VehicleType, List<Vehicle>> vehicles) {
        this.vehicles = vehicles;
    }

    public HashMap<VehicleType, Integer> getPrices() {
        return prices;
    }

    public void setPrices(HashMap<VehicleType, Integer> prices) {
        this.prices = prices;
    }

    public Integer getPrice(VehicleType vehicleType){
        return this.prices.get(vehicleType);
    }
}
