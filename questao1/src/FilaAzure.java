public class FilaAzure implements IFila {
    private final String identificador;

    FilaAzure(int numero) {
        identificador = "sb-" + numero;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public double getCustoMensal() {
        return 0.50;
    }
}
