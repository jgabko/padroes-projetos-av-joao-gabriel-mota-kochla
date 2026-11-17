public class PainelLeiloeiro implements ObservadorLote {
    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.printf("Painel: %s | Maior lance: R$ %.2f | Total de lances: %d%n",
                lote.getNome(), lote.getLanceAtual(), lote.getTotalLances());
    }
}
