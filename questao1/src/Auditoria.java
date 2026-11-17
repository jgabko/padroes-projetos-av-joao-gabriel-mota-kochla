import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Auditoria {
    private static final Auditoria instancia = new Auditoria();
    private final List<String> registros = new ArrayList<>();

    private Auditoria() { }

    public static Auditoria getInstancia() { return instancia; }

    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        registros.add(LocalDateTime.now() + " | " + ambiente + " | " + provedor + " | " + resultado);
    }

    public synchronized int totalRegistros() { return registros.size(); }

    public synchronized void imprimir() {
        System.out.println("=== Historico de auditoria ===");
        for (String registro : registros) {
            System.out.println(registro);
        }
        System.out.println("Total de registros: " + registros.size());
    }
}
