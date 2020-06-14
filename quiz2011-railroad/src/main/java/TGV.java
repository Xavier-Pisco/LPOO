public class TGV extends Comboio {
    public TGV(String name) {
        super(name);
        servicoABordo = new ServicoPrioritario();
    }

    @Override
    public String toString() {
        return "TGV " + nome + ", " + getNumCarruagens() + (getNumCarruagens() == 1 ? " carruagem, " : " carruagens, ")
                + getNumLugares() + (getNumLugares() == 1 ? " lugar, " : " lugares, ")
                + getNumPassageiros() + (getNumPassageiros() == 1 ? " passageiro" : " passageiros");
    }
}
