package inputs;

import modals.Command;
import service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private final Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(final ParkingLotService parkingLotService) {
        commands.put(
                CreateParkingLotCommandExecutor.COMMAND_NAME,
                new CreateParkingLotCommandExecutor(parkingLotService));
        commands.put(
                ParkCarCommandExecutor.COMMAND_NAME,
                new ParkCarCommandExecutor(parkingLotService));
        commands.put(
                LeaveCarCommandExecutor.COMMAND_NAME,
                new LeaveCarCommandExecutor(parkingLotService));
        commands.put(
                ParkingLotStatusCommandExecutor.COMMAND_NAME,
                new ParkingLotStatusCommandExecutor(parkingLotService));
        commands.put(
                ColorToRegNumberCommandExecutor.COMMAND_NAME,
                new ColorToRegNumberCommandExecutor(parkingLotService));
        commands.put(
                SlotNumberForRegNumberCommandExecutor.COMMAND_NAME,
                new SlotNumberForRegNumberCommandExecutor(parkingLotService));
        commands.put(
                SlotNumbersForCarColorCommandExecutor.COMMAND_NAME,
                new SlotNumbersForCarColorCommandExecutor(parkingLotService));
          }

    public CommandExecutor getCommandExecutor(final Command command){
        final CommandExecutor commandExecutor = commands.get(command.getName());
        if(commandExecutor==null){
            System.out.println("Invalid input");
        }
        return commandExecutor;
    }
}
