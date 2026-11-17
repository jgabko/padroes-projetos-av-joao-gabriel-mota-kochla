public class EntregaExpressa extends ServicoDecorador {
    public EntregaExpressa(IFatura fatura) { super(fatura); }

    @Override
    public String getDescricao() {
        return fatura.getDescricao() + String.format("%nEntrega expressa: R$ %.2f", 450.00);
    }

    @Override
    public double getTotal() { return fatura.getTotal() + 450.00; }
}
