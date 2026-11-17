public class ComissaoVeiculos implements IComissao {
    @Override
    public double calcular(double valorVenda) {
        return Math.min(valorVenda * 0.08, 5000.00);
    }
}
