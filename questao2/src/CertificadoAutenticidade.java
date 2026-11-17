public class CertificadoAutenticidade extends ServicoDecorador {
    public CertificadoAutenticidade(IFatura fatura) { super(fatura); }

    private double getCusto() { return 300.00; }

    @Override
    public String getDescricao() {
        return fatura.getDescricao() + String.format("%nCertificado de autenticidade: R$ %.2f", getCusto());
    }

    @Override
    public double getTotal() { return fatura.getTotal() + getCusto(); }
}
