package inputs;

import modals.Car;
import modals.Command;
import service.ParkingLotService;

import java.util.List;

public class SlotNumbersForCarColorCommandExecutor implements CommandExecutor{

    private final ParkingLotService parkingLotService;
    public static String COMMAND_NAME="slot_numbers_for_cars_with_colour";

    public SlotNumbersForCarColorCommandExecutor(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public Boolean validator(Command command) {
        return command.getName().equals(COMMAND_NAME) && command.getParams().size()==1;
    }

    @Override
    public void executor(Command command) {
        List<Car> parkedCars = parkingLotService.getAllParkedCars();
        String askedColor = command.getParams().get(0);

        List<Integer> carSlots = parkedCars.stream().filter(car -> car.getColor().equals(askedColor)).map(Car::getSlot).toList();
        for(Integer i:carSlots){
            System.out.printf("%d, ", i);
        }
        System.out.println();
    }
}
