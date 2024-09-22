package vehiclerental.service;

import vehiclerental.constants.VehicleType;
import vehiclerental.entity.Branch;
import vehiclerental.entity.Reservation;
import vehiclerental.entity.Vehicle;
import vehiclerental.data.ReservationData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingService {

    private ReservationData reservationData;


    public BookingService(ReservationData reservationData) {
        this.reservationData = reservationData;
    }

    public void addBranchToRepo(Branch branch){
        this.reservationData.addABranch(branch);
    }

    public void addReservationToRepo(Reservation reservation){
        this.reservationData.addAReservation(reservation);
    }

    public void addAVehicleToBranch(String branchName, Vehicle vehicle){
        this.reservationData.addAVehicleToBranch(branchName, vehicle);
    }

    public String rentAVehicle(String branchName, VehicleType vehicleType, LocalDateTime fromDate, LocalDateTime toDate){
        List<Vehicle> availableVehicles = this.getAvailableVehiclesOfAType(branchName, vehicleType, fromDate, toDate);
        Branch branch = this.reservationData.getBranch(branchName);
        if (availableVehicles.isEmpty()){
            return "No availability";
        }
        else {
            Reservation reservation = new Reservation(availableVehicles.get(0), fromDate, toDate, branch);
            this.reservationData.addAReservation(reservation);
            return "Booked from " + branchName + " .";
        }

    }

    public HashMap<VehicleType, List<Vehicle>> getAvailableVehicles(String branchName, LocalDateTime fromDate, LocalDateTime toDate){
        Branch branch = this.reservationData.getBranch(branchName);
        HashMap<VehicleType, List<Vehicle>> vehicles = branch.getVehicles();
        List<Reservation> reservations = this.reservationData.getReservationsForABranch(branchName);
        for (Reservation reservation: reservations){
            if ((reservation.getStartTime().isAfter(fromDate) &&  reservation.getStartTime().isBefore(toDate))
                || reservation.getEndTime().isAfter(fromDate) && reservation.getEndTime().isBefore(toDate)){
                VehicleType type = reservation.getVehicle().getVehicleType();
                if (!vehicles.get(type).isEmpty()) {
                    vehicles.get(type).remove(0);
                }
            }
        }
        return vehicles;
    }

    public HashMap<VehicleType, List<Vehicle>> getAllAvailableVehiclesForABranch(String branchName, LocalDateTime fromDate, LocalDateTime toDate){
        return this.getAvailableVehicles(branchName, fromDate, toDate);
    }

    public HashMap<VehicleType, Integer> getPricesForABranch(String branchName){
        return this.reservationData.getBranch(branchName).getPrices();
    }

    public List<Vehicle> getAvailableVehiclesOfAType(String branchName, VehicleType vehicleType, LocalDateTime fromDate, LocalDateTime toDate){
        return this.getAvailableVehicles(branchName, fromDate, toDate).getOrDefault(vehicleType, new ArrayList<Vehicle>());
    }

    public void printSystemView(LocalDateTime fromDate, LocalDateTime toDate){
        HashMap<String, Branch> branches = this.reservationData.getBranches();
        System.out.println("System view from: " + fromDate + " to: " + toDate);
        branches.forEach((k, v) -> {
            HashMap<VehicleType, List<Vehicle>> availableVehiclesForABranch = getAllAvailableVehiclesForABranch(k, fromDate, toDate);
            HashMap<VehicleType, Integer> prices = getPricesForABranch(k);
            System.out.println(k + ":-");
            availableVehiclesForABranch.forEach((type, allVehicles) -> {
                if (!allVehicles.isEmpty()) {
                    System.out.println(allVehicles.size() + " " + type + " available for Rs. " + prices.get(type) + " per hour.");
                }
                else{
                    System.out.println("All " + type + " are booked.");
                }
            });
        });
    }


}
