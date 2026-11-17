public class MaquinaAzure implements IMaquinaVirtual {
    private final String identificador;

    MaquinaAzure(int numero) {
        identificador = "vm-" + numero;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public double getCustoHora() {
        return 0.12;
    }
}
