package service;

import modals.Car;
import parking.strategy.ParkingStrategy;

import java.util.List;

/* Requirement of service :
        1. Create parking lot with capacity
        2. park car and return slot
        3. exit car and make slot available
        Below queries moved to command executor providing them all parked cars
        4. handle queries :
                            status
                            Registration numbers of all cars of a particular colour.
                            Slot number in which a car with a given registration number is parked.
                            Slot numbers of all slots where a car of a particular colour is parked.
     */
public abstract class ParkingLotService {

    public abstract void createParkingLot(Integer capacity, ParkingStrategy parkingStrategy);
    public abstract Integer parkCar(Car car);
    public abstract void unParkCar(Integer slotNumber);
    public abstract List<Car> getAllParkedCars();
}
