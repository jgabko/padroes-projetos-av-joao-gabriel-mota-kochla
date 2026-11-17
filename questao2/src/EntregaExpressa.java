public class EntregaExpressa extends ServicoDecorador {
    public EntregaExpressa(IFatura fatura) { super(fatura); }

    private double getCusto() { return 450.00; }

    @Override
    public String getDescricao() {
        return fatura.getDescricao() + String.format("%nEntrega expressa: R$ %.2f", getCusto());
    }

    @Override
    public double getTotal() { return fatura.getTotal() + getCusto(); }
}
