package service;

import modals.Car;
import modals.ParkingLot;
import parking.strategy.ParkingStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParkingLotServiceImpl extends ParkingLotService{
    private ParkingLot parkingLot;
    private Integer parkingLotCapacity;
    private ParkingStrategy parkingStrategy;

    @Override
    public void createParkingLot(Integer capacity, ParkingStrategy parkingStrategy) {
        if(this.parkingLot!=null) {
            System.out.println("Parking lot already exists");
        }
        this.parkingStrategy = parkingStrategy;
        this.parkingLot = new ParkingLot(capacity);
        this.parkingLotCapacity = capacity;

        for(int i=1; i<=capacity; i++){
            parkingStrategy.addSlot(i);
        }

        System.out.println("Created a parking lot with " + capacity + " slots");
    }

    @Override
    public Integer parkCar(Car car) {
        Integer freeSlot = parkingStrategy.getNextSlot();
        if(freeSlot==-1) {
            System.out.println("Sorry,Parking lot is full");
        }
        else{
            car.setSlot(freeSlot);
            parkingLot.parkCar(car, freeSlot);
            parkingStrategy.removeSlot(freeSlot);
        }
        return freeSlot;
    }

    @Override
    public void unParkCar(Integer slotNumber) {
        if(slotNumber<1 || slotNumber>parkingLotCapacity) System.out.println("Invalid input");
        else{
            parkingLot.unassignCar(slotNumber);
            parkingStrategy.addSlot(slotNumber);
            System.out.println("Slot number " + slotNumber + " is free");
        }
    }

    @Override
    public List<Car> getAllParkedCars() {
        return parkingLot.getSlots().values().stream().filter(Objects::nonNull).collect(Collectors.toList());
    }
}
