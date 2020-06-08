public class GateNot implements LogicGate {
    private LogicVariable output;
    private LogicVariable input;

    public GateNot(LogicVariable output, LogicVariable input) throws Exception {
        if (output.getCalculatedBy() != null) throw new ColisionException();
        this.output = output;
        this.input = input;
        if (checkCycles()) throw new CycleException();
        calculate();
    }

    private boolean checkCycles(){
        if (input.getCalculatedBy() != null){
            for (Object l: input.getCalculatedBy().getInputs())
                if (l == output) return true;
        }
        return false;
    }

    @Override
    public LogicVariable getOutput() {
        return output;
    }

    @Override
    public void calculate() {
        output.setCalculatedBy(this);
        output.setValue(!input.getValue());
    }

    @Override
    public Object[] getInputs() {
        return new Object[]{input};
    }

    @Override
    public String getSymbol() {
        return "NOT";
    }

    @Override
    public String getFormula() {
        return getSymbol() + "(" + input.getFormula() + ")";
    }
}
