public class CertificadoAutenticidade extends ServicoDecorador {
    public CertificadoAutenticidade(IFatura fatura) { super(fatura); }

    @Override
    public String getDescricao() {
        return fatura.getDescricao() + String.format("%nCertificado de autenticidade: R$ %.2f", 300.00);
    }

    @Override
    public double getTotal() { return fatura.getTotal() + 300.00; }
}
