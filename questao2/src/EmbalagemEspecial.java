public class EmbalagemEspecial extends ServicoDecorador {
    public EmbalagemEspecial(IFatura fatura) { super(fatura); }

    private double getCusto() { return 180.00; }

    @Override
    public String getDescricao() {
        return fatura.getDescricao() + String.format("%nEmbalagem especial: R$ %.2f", getCusto());
    }

    @Override
    public double getTotal() { return fatura.getTotal() + getCusto(); }
}
