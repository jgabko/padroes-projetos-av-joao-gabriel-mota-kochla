import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.forLanguageTag("pt-BR"));
        Lote quadro = new Lote("Quadro", "Arte", 1000, 1200, new ComissaoArte());
        Lote carro = new Lote("Carro", "Veiculos", 20000, 30000, new ComissaoVeiculos());
        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        for (Lote lote : new Lote[] {quadro, carro}) {
            lote.adicionarObservador(ana);
            lote.adicionarObservador(bruno);
            lote.adicionarObservador(carla);
            lote.adicionarObservador(painel);
            lote.adicionarObservador(auditor);
        }

        ana.darLance(quadro, 1050);
        bruno.darLance(quadro, 1070); // Recusado: aumento inferior a 5%.
        bruno.darLance(quadro, 1200);
        quadro.removerObservador(carla);
        System.out.println("Carla deixou de acompanhar o Quadro.");
        ana.darLance(quadro, 1260);

        carla.darLance(carro, 21000);
        ana.darLance(carro, 20000); // Recusado.
        quadro.setComissao(new ComissaoEletronicos());
        System.out.println("Campanha: Quadro com comissao de Eletronicos.");
        quadro.encerrar();
        carro.encerrar();
        bruno.darLance(quadro, 1500); // Recusado: lote encerrado.

        IFatura fatura = new Venda(quadro);
        fatura = new SeguroTransporte(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);
        imprimir(fatura);
        quadro.imprimirAcerto();
        auditor.imprimir();
    }

    private static void imprimir(IFatura fatura) {
        System.out.println("=== Fatura do comprador ===");
        System.out.println(fatura.getDescricao());
        System.out.printf("Total a pagar: R$ %.2f%n%n", fatura.getTotal());
    }
}
