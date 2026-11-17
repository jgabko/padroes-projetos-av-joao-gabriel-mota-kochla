public class FilaAws implements IFila {
    private final String identificador;

    FilaAws(int numero) {
        identificador = "sqs-" + numero;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public double getCustoMensal() {
        return 0.40;
    }
}
