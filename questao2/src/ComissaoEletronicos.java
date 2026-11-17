public class ComissaoEletronicos implements IComissao {
    @Override
    public double calcular(double valorVenda) {
        return Math.max(valorVenda * 0.12, 50.00);
    }
}
