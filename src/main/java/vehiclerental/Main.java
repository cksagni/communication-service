package vehiclerental;

import vehiclerental.constants.VehicleType;
import vehiclerental.entity.Branch;
import vehiclerental.entity.Vehicle;
import vehiclerental.data.ReservationData;
import vehiclerental.service.BookingService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReservationData reservationData = new ReservationData();
        BookingService bookingService = new BookingService(reservationData);

        // Create branch gachibowli
        HashMap<VehicleType, List<Vehicle>> vehiclesWithType = new HashMap<>();
        List<Vehicle> vehicles = new ArrayList<>();
        HashMap<VehicleType, Integer> pricesWithType = new HashMap<>();
        vehicles.add(new Vehicle(VehicleType.SUV));
        vehiclesWithType.put(VehicleType.SUV, vehicles);
        pricesWithType.put(VehicleType.SUV, 12);

        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(VehicleType.SEDAN));
        vehicles.add(new Vehicle(VehicleType.SEDAN));
        vehicles.add(new Vehicle(VehicleType.SEDAN));
        vehiclesWithType.put(VehicleType.SEDAN, vehicles);
        pricesWithType.put(VehicleType.SEDAN, 10);

        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehiclesWithType.put(VehicleType.BIKE, vehicles);
        pricesWithType.put(VehicleType.BIKE, 20);

        bookingService.addBranchToRepo(new Branch("gachibowli", vehiclesWithType, pricesWithType));


        // create branch kukatpalli
        vehiclesWithType = new HashMap<>();
        pricesWithType = new HashMap<>();

        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(VehicleType.SEDAN));
        vehicles.add(new Vehicle(VehicleType.SEDAN));
        vehicles.add(new Vehicle(VehicleType.SEDAN));
        vehiclesWithType.put(VehicleType.SEDAN, vehicles);
        pricesWithType.put(VehicleType.SEDAN, 11);

        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehiclesWithType.put(VehicleType.BIKE, vehicles);
        pricesWithType.put(VehicleType.BIKE, 30);

        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(VehicleType.HATCHBACK));
        vehicles.add(new Vehicle(VehicleType.HATCHBACK));
        vehicles.add(new Vehicle(VehicleType.HATCHBACK));
        vehicles.add(new Vehicle(VehicleType.HATCHBACK));
        vehiclesWithType.put(VehicleType.HATCHBACK, vehicles);
        pricesWithType.put(VehicleType.HATCHBACK, 8);

        bookingService.addBranchToRepo(new Branch("kukatpally", vehiclesWithType, pricesWithType));


        // create branch miyapur
        vehiclesWithType = new HashMap<>();
        pricesWithType = new HashMap<>();

        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(VehicleType.SUV));
        vehiclesWithType.put(VehicleType.SUV, vehicles);
        pricesWithType.put(VehicleType.SUV, 11);

        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehicles.add(new Vehicle(VehicleType.BIKE));
        vehiclesWithType.put(VehicleType.BIKE, vehicles);
        pricesWithType.put(VehicleType.BIKE, 3);

        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(VehicleType.SEDAN));
        vehicles.add(new Vehicle(VehicleType.SEDAN));
        vehicles.add(new Vehicle(VehicleType.SEDAN));
        vehiclesWithType.put(VehicleType.SEDAN, vehicles);
        pricesWithType.put(VehicleType.SEDAN, 10);

        bookingService.addBranchToRepo(new Branch("miyapur", vehiclesWithType, pricesWithType));


        // add a vehicle to gachibowli
        bookingService.addAVehicleToBranch("gachibowli", new Vehicle(VehicleType.SEDAN));


        // rent a SUV from miyapur
        String status = bookingService.rentAVehicle("miyapur", VehicleType.SUV, LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        System.out.println(status);

        // rent a SUV from gachibowli
        status = bookingService.rentAVehicle("gachibowli", VehicleType.SUV, LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        System.out.println(status);

        // rent a SUV from kukatpally - Not available
        status = bookingService.rentAVehicle("kukatpally", VehicleType.SUV, LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        System.out.println(status);

        // print all available vehicles for gachibowli
        String branchName = "gachibowli";
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to =  LocalDateTime.now().plusHours(2);
        HashMap<VehicleType, List<Vehicle>> availableVehiclesForABranch = bookingService.getAllAvailableVehiclesForABranch(branchName, from, to);
        HashMap<VehicleType, Integer> prices = bookingService.getPricesForABranch(branchName);
        System.out.println("Available vehicles for branch: " + branchName + " from time: " + from + " to time: " + to);

        availableVehiclesForABranch.forEach((k, v) -> {
            if (!v.isEmpty()) {
                System.out.println(v.size() + " " + k + " available for Rs. " + prices.get(k) + " per hour.");
            }
        });

        // print System view
        bookingService.printSystemView(from, to);

    }
}
