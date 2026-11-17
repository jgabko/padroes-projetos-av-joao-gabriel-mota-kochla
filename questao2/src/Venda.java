public class Venda implements IFatura {
    private final String lote;
    private final double valorVenda;

    public Venda(Lote lote) {
        if (!lote.isVendido()) {
            throw new IllegalStateException("Somente lotes vendidos possuem fatura.");
        }
        this.lote = lote.getNome();
        this.valorVenda = lote.getLanceAtual();
    }

    public String getDescricao() {
        return String.format("Lote: %s%nValor de venda: R$ %.2f", lote, valorVenda);
    }

    public double getValorVenda() { return valorVenda; }
    public double getTotal() { return valorVenda; }
}
