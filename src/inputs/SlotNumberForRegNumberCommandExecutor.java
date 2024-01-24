package inputs;

import modals.Car;
import modals.Command;
import service.ParkingLotService;

import java.util.List;
import java.util.Optional;

public class SlotNumberForRegNumberCommandExecutor implements CommandExecutor{
    private final ParkingLotService parkingLotService;
    public static String COMMAND_NAME="slot_number_for_registration_number";

    public SlotNumberForRegNumberCommandExecutor(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public Boolean validator(Command command) {
        return command.getName().equals(COMMAND_NAME) && command.getParams().size()==1;
    }

    @Override
    public void executor(Command command) {
        List<Car> parkedCars = parkingLotService.getAllParkedCars();
        String regNumber = command.getParams().get(0);

        Integer carSlot = parkedCars.stream().filter(car -> car.getRegistrationNumber().equals(regNumber)).map(Car::getSlot).findFirst().orElse(null);
        if(carSlot==null) System.out.println("Car not found");
        else System.out.println(carSlot);
        System.out.println();
    }
}
