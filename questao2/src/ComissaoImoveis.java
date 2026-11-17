public class ComissaoImoveis implements IComissao {
    @Override
    public double calcular(double valorVenda) {
        return valorVenda * 0.03 + 1500.00;
    }
}
