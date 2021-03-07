package сommand;
import java.util.HashMap;

interface Command {
    void execute();
}

class Switch {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String commandName) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("no command registered for " + commandName);
        }
        command.execute();
    }
}

class Coin {
    public void turnTails() {
        System.out.println("выпала решка");
    }

    public void turnHeads() {
        System.out.println("выпал орёл");
    }
}

class SwitchHeadsCommand implements Command {
    private final Coin coin;

    public SwitchHeadsCommand(Coin coin) {
        this.coin = coin;
    }

    @Override // Command
    public void execute() {
        coin.turnHeads();
    }
}

class SwitchTailsCommand implements Command {
    private final Coin coin;

    public SwitchTailsCommand(Coin coin) {
        this.coin = coin;
    }

    @Override // Command
    public void execute() {
        coin.turnTails();
    }
}

public class CommandExample {
    public static void main(final String[] arguments) {
        Coin coin = new Coin();

        Command switchHeadsCommand = new SwitchHeadsCommand(coin);
        Command switchTailsCommand = new SwitchTailsCommand(coin);

        Switch mySwitch = new Switch();
        mySwitch.register("орёл", switchHeadsCommand);
        mySwitch.register("решка", switchTailsCommand);

        mySwitch.execute("орёл");
        mySwitch.execute("решка");
    }
}
