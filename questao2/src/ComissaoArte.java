public class ComissaoArte implements IComissao {
    @Override
    public double calcular(double valorVenda) {
        return valorVenda * 0.20;
    }
}
