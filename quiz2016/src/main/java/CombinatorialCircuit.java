import java.util.ArrayList;
import java.util.List;

public class CombinatorialCircuit {
    private List<LogicVariable> variables = new ArrayList<>();

    public boolean addVariable(LogicVariable l){
        if (!variables.contains(l)) return variables.add(l);
        return false;
    }


    public Object getVariableByName(String name) {
        for (LogicVariable l: variables){
            if (l.getName().equals(name)) return l;
        }
        return null;
    }
}
