package inputs;

import modals.Command;
import service.ParkingLotService;

public class LeaveCarCommandExecutor implements CommandExecutor{
    private final ParkingLotService parkingLotService;
    public static String COMMAND_NAME="leave";

    public LeaveCarCommandExecutor(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public Boolean validator(Command command) {
        return command.getName().equals(COMMAND_NAME) && command.getParams().size()==1;
    }

    @Override
    public void executor(Command command) {
        Integer slot = Integer.parseInt(command.getParams().get(0));
        parkingLotService.unParkCar(slot);
    }
}
