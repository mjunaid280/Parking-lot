package modals;

import java.util.List;

public class Command {
    private final String name;
    private final List<String> params;

    public Command(String name, List<String> params) {
        this.name = name;
        this.params = params;
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", params=" + params +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<String> getParams() {
        return params;
    }
}
