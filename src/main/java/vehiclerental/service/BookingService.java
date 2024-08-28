package vehiclerental.service;

import vehiclerental.constants.VehicleType;
import vehiclerental.entity.Branch;
import vehiclerental.entity.Reservation;
import vehiclerental.entity.Vehicle;
import vehiclerental.repository.ReservationRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class BookingService {

    private ReservationRepository reservationRepository;


    public BookingService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void addBranchToRepo(Branch branch){
        this.reservationRepository.addABranch(branch);
    }

    public void addReservationToRepo(Reservation reservation){
        this.reservationRepository.addAReservation(reservation);
    }

    public void addAVehicleToBranch(String branchName, Vehicle vehicle){
        this.reservationRepository.addAVehicleToBranch(branchName, vehicle);
    }

    public String rentAVehicle(String branchName, VehicleType vehicleType, LocalDateTime fromDate, LocalDateTime toDate){
        List<Vehicle> availableVehicles = this.getAvailableVehiclesOfAType(branchName, vehicleType, fromDate, toDate);
        Branch branch = this.reservationRepository.getBranch(branchName);
        if (availableVehicles.isEmpty()){
            return "No availability";
        }
        else {
            Reservation reservation = new Reservation(availableVehicles.get(0), fromDate, toDate, branch);
            this.reservationRepository.addAReservation(reservation);
            return "Booked from " + branchName + " .";
        }

    }

    public HashMap<VehicleType, List<Vehicle>> getAvailableVehicles(String branchName, LocalDateTime fromDate, LocalDateTime toDate){
        Branch branch = this.reservationRepository.getBranch(branchName);
        HashMap<VehicleType, List<Vehicle>> vehicles = branch.getVehicles();
        List<Reservation> reservations = this.reservationRepository.getReservationsForABranch(branchName);
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

    public void printAllAvailableVehicles(String branchName, LocalDateTime fromDate, LocalDateTime toDate){
        HashMap<VehicleType, Integer> prices = this.reservationRepository.getBranch(branchName).getPrices();
        HashMap<VehicleType, List<Vehicle>> vehicles = this.getAvailableVehicles(branchName, fromDate, toDate);
        System.out.println("Available vehicles for branch: " + branchName + " from time: " + fromDate + " to time: " + toDate);
        vehicles.forEach((k, v) ->
                        System.out.println(v.size() + " " + k + " available for Rs. " + prices.get(k) + " per hour.")
                );
    }

    public List<Vehicle> getAvailableVehiclesOfAType(String branchName, VehicleType vehicleType, LocalDateTime fromDate, LocalDateTime toDate){
        return this.getAvailableVehicles(branchName, fromDate, toDate).get(vehicleType);
    }


}
