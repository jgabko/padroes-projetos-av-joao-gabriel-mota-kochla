public class FactoryAzure implements IFactoryNuvem {
    private static int maquinas;
    private static int armazenamentos;
    private static int filas;

    public String getProvedor() { return "Azure"; }
    public double getCustoHora() { return 0.12; }
    public double getCustoGb() { return 0.02; }
    public double getCustoFila() { return 0.50; }

    public IMaquinaVirtual criarMaquina() {
        synchronized (FactoryAzure.class) {
            return new MaquinaAzure(++maquinas);
        }
    }

    public IArmazenamento criarArmazenamento() {
        synchronized (FactoryAzure.class) {
            return new ArmazenamentoAzure(++armazenamentos);
        }
    }

    public IFila criarFila() {
        synchronized (FactoryAzure.class) {
            return new FilaAzure(++filas);
        }
    }
}
