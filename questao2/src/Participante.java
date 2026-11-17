public class Participante implements IParticipante {
    private final String nome;

    public Participante(String nome) { this.nome = nome; }
    public String getNome() { return nome; }

    public void darLance(Lote lote, double valor) {
        lote.receberLance(this, valor);
    }

    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.printf("%s recebeu: %s com novo lance de R$ %.2f%n",
                nome, lote.getNome(), lance.getValor());
    }
}
