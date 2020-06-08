public class GateOr implements LogicGate {
    private LogicVariable output;
    private LogicVariable input1;
    private LogicVariable input2;

    public GateOr(LogicVariable output, LogicVariable input1, LogicVariable input2) throws Exception {
        if (output.getCalculatedBy() != null) throw new ColisionException();
        this.output = output;
        this.input1 = input1;
        this.input2 = input2;
        if (checkCycles()) throw new CycleException();
        calculate();
    }

    private boolean checkCycles(){
        if (input1.getCalculatedBy() != null){
            for (Object l: input1.getCalculatedBy().getInputs())
                if (l == output) return true;
        }
        if (input2.getCalculatedBy() != null){
            for (Object l: input2.getCalculatedBy().getInputs())
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
        output.setValue(input1.getValue() || input2.getValue());
    }

    @Override
    public Object[] getInputs() {
        return new Object[]{input1, input2};
    }

    @Override
    public String getSymbol() {
        return "OR";
    }

    @Override
    public String getFormula() {
        return getSymbol() + "(" + input1.getFormula() + "," + input2.getFormula() + ")";
    }
}
