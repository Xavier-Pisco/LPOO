public class Pendular extends Comboio {
    public Pendular(String name) {
        super(name);
        servicoABordo = new ServicoSemEnjoos();
    }

    @Override
    public String toString() {
        return "Pendular " + nome + ", " + getNumCarruagens() + (getNumCarruagens() == 1 ? " carruagem, " : " carruagens, ")
                + getNumLugares() + (getNumLugares() == 1 ? " lugar, " : " lugares, ")
                + getNumPassageiros() + (getNumPassageiros() == 1 ? " passageiro" : " passageiros");
    }
}
