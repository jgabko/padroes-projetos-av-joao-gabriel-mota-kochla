public class MaquinaAws implements IMaquinaVirtual {
    private final String identificador;

    MaquinaAws(int numero) {
        identificador = "i-" + numero;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public double getCustoHora() {
        return 0.10;
    }
}
