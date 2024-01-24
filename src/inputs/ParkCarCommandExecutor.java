package inputs;

import modals.Car;
import modals.Command;
import service.ParkingLotService;

import java.util.List;

public class ParkCarCommandExecutor implements CommandExecutor{
    private final ParkingLotService parkingLotService;
    public static String COMMAND_NAME="park";

    public ParkCarCommandExecutor(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public Boolean validator(Command command) {
        String commandName = command.getName();
        List<String> params = command.getParams();

        return commandName.equals(COMMAND_NAME) && params.size() == 2;
    }

    @Override
    public void executor(Command command) {
        Car car = new Car(command.getParams().get(0), command.getParams().get(1));
        Integer slotNumber  = parkingLotService.parkCar(car);
        if(slotNumber!=-1) System.out.println("Allocated slot number: "+slotNumber);
    }
}
