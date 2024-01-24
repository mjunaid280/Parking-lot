package inputs;

import modals.Car;
import modals.Command;
import service.ParkingLotService;

import java.util.List;

public class ParkingLotStatusCommandExecutor implements CommandExecutor{
    private final ParkingLotService parkingLotService;
    public static String COMMAND_NAME="status";

    public ParkingLotStatusCommandExecutor(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public Boolean validator(Command command) {
        return command.getName().equals(COMMAND_NAME);
    }

    @Override
    public void executor(Command command) {
        List<Car> parkedCars = parkingLotService.getAllParkedCars();
        System.out.println("Slot No.    Registration No     Color");
        for(Car car: parkedCars){
            System.out.println(car.getSlot() + "  " + car.getRegistrationNumber() + "   " + car.getColor());
        }
    }
}
