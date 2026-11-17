import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracao {
    private static final Configuracao instancia = new Configuracao();
    private final String regiao;
    private final double orcamento;

    private Configuracao() {
        Properties propriedades = new Properties();
        try (FileInputStream arquivo = new FileInputStream("config.properties")) {
            propriedades.load(arquivo);
            regiao = propriedades.getProperty("regiao");
            orcamento = Double.parseDouble(propriedades.getProperty("orcamento"));
            if (regiao == null || regiao.trim().isEmpty()
                    || !Double.isFinite(orcamento) || orcamento < 0) {
                throw new IllegalArgumentException("Configuracao invalida.");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Erro ao ler config.properties.", e);
        }
    }

    public static Configuracao getInstancia() { return instancia; }
    public String getRegiao() { return regiao; }
    public double getOrcamento() { return orcamento; }
}
