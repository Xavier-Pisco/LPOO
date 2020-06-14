import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comboio {
    protected String nome;
    private List<Carruagem> carruagens;
    private int numPassageiros;
    protected ServicoABordo servicoABordo;

    public Comboio(String nome) {
        this.nome = nome;
        carruagens = new ArrayList<>();
        servicoABordo = new ServicoRegular();
    }

    public String getNome() {
        return nome;
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public ServicoABordo getServicoABordo() {
        return servicoABordo;
    }

    public void setServicoABordo(ServicoABordo servicoABordo) {
        this.servicoABordo = servicoABordo;
    }

    public int getNumLugares() {
        int result = 0;
        for (Carruagem carruagem: carruagens) result += carruagem.getNumLugares();
        return result;
    }

    public int getNumCarruagens() {
        return carruagens.size();
    }

    public void addCarruagem(Carruagem a1) {
        carruagens.add(a1);
    }

    public Carruagem getCarruagemByOrder(int i) {
        return carruagens.get(i);
    }

    public void removeAllCarruagens(int i) {
        carruagens.removeIf(carruagem -> carruagem.getNumLugares() == i);
    }

    public int getLugaresLivres() {
        return getNumLugares() - getNumPassageiros();
    }

    public void addPassageiros(int i) throws PassengerCapacityExceeded {
        if (i > getLugaresLivres()) throw new PassengerCapacityExceeded();
        numPassageiros += i;
    }

    public void removePassageiros(int i) {
        numPassageiros -= 1;
    }

    public void removePassageiros() {
        numPassageiros = 0;
    }

    @Override
    public String toString() {
        return "Comboio " + nome + ", " + getNumCarruagens() + (getNumCarruagens() == 1 ? " carruagem, " : " carruagens, ")
                + getNumLugares() + (getNumLugares() == 1 ? " lugar, " : " lugares, ")
                + getNumPassageiros() + (getNumPassageiros() == 1 ? " passageiro" : " passageiros");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comboio)) return false;
        Comboio comboio = (Comboio) o;
        return Objects.equals(carruagens, comboio.carruagens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carruagens);
    }

    public String getDescricaoServico() {
        return servicoABordo.getDescricao();
    }
}
