import java.time.LocalDateTime;

public class Lance {
    private final IParticipante participante;
    private final double valor;
    private final LocalDateTime dataHora;

    public Lance(IParticipante participante, double valor) {
        this.participante = participante;
        this.valor = valor;
        dataHora = LocalDateTime.now();
    }

    public IParticipante getParticipante() { return participante; }
    public double getValor() { return valor; }
    public LocalDateTime getDataHora() { return dataHora; }
}
