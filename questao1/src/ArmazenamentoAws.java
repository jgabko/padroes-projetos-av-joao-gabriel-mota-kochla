public class ArmazenamentoAws implements IArmazenamento {
    private final String identificador;

    ArmazenamentoAws(int numero) {
        identificador = "s3://" + numero;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public double getCustoGb() {
        return 0.023;
    }
}
