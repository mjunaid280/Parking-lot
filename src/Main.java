import inputs.CommandExecutor;
import inputs.CommandExecutorFactory;
import modals.Command;
import service.ParkingLotService;
import service.ParkingLotServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        final ParkingLotService parkingLotService = new ParkingLotServiceImpl();
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);

        // interactive/shell mode
        if(args.length==0){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                String input = reader.readLine();
                List<String> commandParams = new java.util.ArrayList<>(Arrays.stream(input.trim().split(" ")).map(String::trim).filter(token -> (!token.isEmpty())).toList());
                String commandName = commandParams.get(0).toLowerCase();
                commandParams.remove(0);
                Command command = new Command(commandName, commandParams);

                if(commandName.equals("exit")) break;

                CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
                if(commandExecutor.validator(command)){
                    commandExecutor.executor(command);
                }
                else System.out.println("Invalid input");
            }
        }
    }
}