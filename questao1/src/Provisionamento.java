import java.util.ArrayList;
import java.util.List;

public class Provisionamento {
    private final IFactoryNuvem fabrica;

    public Provisionamento(IFactoryNuvem fabrica) {
        this.fabrica = fabrica;
    }

    public void provisionar(String nome, int quantidadeMaquinas, int quantidadeGb) {
        Configuracao configuracao = Configuracao.getInstancia();
        if (quantidadeMaquinas < 0 || quantidadeGb < 0) {
            recusar(nome, "Quantidade negativa.");
            return;
        }
        // O orcamento e verificado antes de criar qualquer recurso.
        double custo = quantidadeMaquinas * fabrica.getCustoHora() * 730
                + quantidadeGb * fabrica.getCustoGb() + fabrica.getCustoFila();
        if (custo > configuracao.getOrcamento()) {
            recusar(nome, "Orcamento mensal excedido.");
            return;
        }

        List<IMaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < quantidadeMaquinas; i++) {
            maquinas.add(fabrica.criarMaquina());
        }
        IArmazenamento armazenamento = fabrica.criarArmazenamento();
        IFila fila = fabrica.criarFila();

        // Mantem o resumo de cada ambiente junto na saida das threads.
        synchronized (System.out) {
            System.out.println("=== Ambiente: " + nome + " ===");
            System.out.println("Provedor: " + fabrica.getProvedor());
            System.out.println("Regiao: " + configuracao.getRegiao());
            for (IMaquinaVirtual maquina : maquinas) {
                System.out.println("Maquina: " + maquina.getIdentificador());
            }
            System.out.println("Armazenamento: " + armazenamento.getIdentificador());
            System.out.println("Fila: " + fila.getIdentificador());
            System.out.printf("Custo mensal estimado: R$ %.2f%n%n", custo);
        }
        Auditoria.getInstancia().registrar(nome, fabrica.getProvedor(), "ACEITO");
    }

    private void recusar(String nome, String motivo) {
        System.out.println(nome + " RECUSADO: " + motivo);
        Auditoria.getInstancia().registrar(nome, fabrica.getProvedor(), "RECUSADO: " + motivo);
    }
}
