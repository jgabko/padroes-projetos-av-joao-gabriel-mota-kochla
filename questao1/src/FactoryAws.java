public class FactoryAws implements IFactoryNuvem {
    private static int maquinas;
    private static int armazenamentos;
    private static int filas;

    public String getProvedor() { return "Aws"; }
    public double getCustoHora() { return 0.10; }
    public double getCustoGb() { return 0.023; }
    public double getCustoFila() { return 0.40; }

    public IMaquinaVirtual criarMaquina() {
        synchronized (FactoryAws.class) {
            return new MaquinaAws(++maquinas);
        }
    }

    public IArmazenamento criarArmazenamento() {
        synchronized (FactoryAws.class) {
            return new ArmazenamentoAws(++armazenamentos);
        }
    }

    public IFila criarFila() {
        synchronized (FactoryAws.class) {
            return new FilaAws(++filas);
        }
    }
}
