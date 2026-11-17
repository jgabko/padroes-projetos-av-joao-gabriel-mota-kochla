import java.util.ArrayList;
import java.util.List;

public class Auditor implements ObservadorLote {
    private final List<String> registros = new ArrayList<>();

    @Override
    public void atualizar(Lote lote, Lance lance) {
        registros.add(lance.getDataHora() + " | " + lote.getNome() + " | "
                + lance.getParticipante().getNome() + " | R$ " + lance.getValor());
    }

    public void imprimir() {
        System.out.println("=== Auditoria dos lances ===");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}
