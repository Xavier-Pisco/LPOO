public interface LogicGate {
    public LogicVariable getOutput();
    void calculate();
    Object[] getInputs();

    String getSymbol();

    String getFormula();
}
