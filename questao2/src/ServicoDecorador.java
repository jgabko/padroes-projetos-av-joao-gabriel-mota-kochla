public abstract class ServicoDecorador implements IFatura {
    protected final IFatura fatura;

    public ServicoDecorador(IFatura fatura) { this.fatura = fatura; }
    public double getValorVenda() { return fatura.getValorVenda(); }
}
