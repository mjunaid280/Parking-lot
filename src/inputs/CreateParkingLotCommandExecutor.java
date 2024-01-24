package inputs;

import modals.Command;
import parking.strategy.NearestParkingStrategy;
import service.ParkingLotService;

import java.util.List;

public class CreateParkingLotCommandExecutor implements CommandExecutor{
    private ParkingLotService parkingLotService;
    public static String COMMAND_NAME="create_parking_lot";

    public CreateParkingLotCommandExecutor(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public Boolean validator(Command command) {
        if(!command.getName().equals(COMMAND_NAME)) return false;
        List<String> params = command.getParams();
        return params.get(0) != null;
    }

    // Using hardcoded strategy for now later could be taken as input
    @Override
    public void executor(Command command) {
        Integer capacity = Integer.parseInt(command.getParams().get(0));
        parkingLotService.createParkingLot(capacity, new NearestParkingStrategy());
    }
}
