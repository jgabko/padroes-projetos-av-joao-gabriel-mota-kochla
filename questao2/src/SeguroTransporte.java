public class SeguroTransporte extends ServicoDecorador {
    public SeguroTransporte(IFatura fatura) { super(fatura); }

    private double getCusto() { return getValorVenda() * 0.015; }

    @Override
    public String getDescricao() {
        return fatura.getDescricao() + String.format("%nSeguro de transporte: R$ %.2f", getCusto());
    }

    @Override
    public double getTotal() { return fatura.getTotal() + getCusto(); }
}
