package vehiclerental.data;

import vehiclerental.constants.VehicleType;
import vehiclerental.entity.Branch;
import vehiclerental.entity.Reservation;
import vehiclerental.entity.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReservationData {
    private HashMap<String, Branch> branches;
    private HashMap<String, List<Reservation>> reservationsForBranch;

    public ReservationData() {
        branches = new HashMap<>();
        reservationsForBranch = new HashMap<>();
    }

    public void addABranch(Branch branch){
        this.branches.put(branch.getName(), branch);
    }

    public void addAReservation(Reservation reservation){
        String branchName = reservation.getBranch().getName();
        List<Reservation> reservations = this.reservationsForBranch.getOrDefault(branchName, new ArrayList<Reservation>());
        reservations.add(reservation);
        this.reservationsForBranch.put(branchName, reservations);
    }

    public List<Reservation> getReservationsForABranch(String branchName){
        return this.reservationsForBranch.getOrDefault(branchName, new ArrayList<Reservation>());
    }

    public void addAVehicleToBranch(String branchName, Vehicle vehicle){
        Branch branch = this.branches.get(branchName);
        HashMap<VehicleType, java.util.List<Vehicle>> vehiclesWithVehicleType = branch.getVehicles();
        java.util.List<Vehicle> vehiclesOfAType = vehiclesWithVehicleType.get(vehicle.getVehicleType());
        vehiclesOfAType.add(vehicle);
        vehiclesWithVehicleType.put(vehicle.getVehicleType(), vehiclesOfAType);
        branch.setVehicles(vehiclesWithVehicleType);
        this.branches.put(branchName, branch);
    }

    public Branch getBranch(String branchName){
        return this.branches.get(branchName);
    }

    public List<Reservation> getReservationsForBranch(String branchName){
        return this.reservationsForBranch.get(branchName);
    }

    public HashMap<String, Branch> getBranches() {
        return branches;
    }

    public void setBranches(HashMap<String, Branch> branches) {
        this.branches = branches;
    }

    public HashMap<String, List<Reservation>> getReservationsForBranch() {
        return reservationsForBranch;
    }

    public void setReservationsForBranch(HashMap<String, List<Reservation>> reservationsForBranch) {
        this.reservationsForBranch = reservationsForBranch;
    }
}
