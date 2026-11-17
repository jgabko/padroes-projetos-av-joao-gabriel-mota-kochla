public class ArmazenamentoAzure implements IArmazenamento {
    private final String identificador;

    ArmazenamentoAzure(int numero) {
        identificador = "blob://" + numero;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public double getCustoGb() {
        return 0.02;
    }
}
