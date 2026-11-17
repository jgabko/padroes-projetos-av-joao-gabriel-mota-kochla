public interface IFactoryNuvem {
    String getProvedor();
    double getCustoHora();
    double getCustoGb();
    double getCustoFila();
    IMaquinaVirtual criarMaquina();
    IArmazenamento criarArmazenamento();
    IFila criarFila();
}
