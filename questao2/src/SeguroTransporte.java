public class SeguroTransporte extends ServicoDecorador {
    public SeguroTransporte(IFatura fatura) { super(fatura); }

    @Override
    public String getDescricao() {
        return fatura.getDescricao() + String.format("%nSeguro de transporte: R$ %.2f", getValorVenda() * 0.015);
    }

    @Override
    public double getTotal() { return fatura.getTotal() + getValorVenda() * 0.015; }
}
