public class EmbalagemEspecial extends ServicoDecorador {
    public EmbalagemEspecial(IFatura fatura) { super(fatura); }

    @Override
    public String getDescricao() {
        return fatura.getDescricao() + String.format("%nEmbalagem especial: R$ %.2f", 180.00);
    }

    @Override
    public double getTotal() { return fatura.getTotal() + 180.00; }
}
