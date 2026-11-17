import java.util.ArrayList;
import java.util.List;

public class Lote {
    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;
    private double lanceAtual;
    private boolean encerrado;
    private boolean vendido;
    private double comissaoCobrada;
    private IComissao comissao;
    private final List<Lance> lances = new ArrayList<>();
    private final List<ObservadorLote> observadores = new ArrayList<>();

    public Lote(String nome, String categoria, double precoInicial,
                double precoReserva, IComissao comissao) {
        if (!Double.isFinite(precoInicial) || !Double.isFinite(precoReserva)
                || precoInicial < 0 || precoReserva < 0 || comissao == null) {
            throw new IllegalArgumentException("Dados do lote invalidos.");
        }
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.comissao = comissao;
    }

    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPrecoInicial() { return precoInicial; }
    public double getLanceAtual() { return lanceAtual; }
    public int getTotalLances() { return lances.size(); }
    public boolean isVendido() { return vendido; }

    public void adicionarObservador(ObservadorLote observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void removerObservador(ObservadorLote observador) {
        observadores.remove(observador);
    }

    public void setComissao(IComissao comissao) {
        if (encerrado || comissao == null) {
            throw new IllegalStateException("Nao foi possivel trocar a comissao.");
        }
        this.comissao = comissao;
    }

    public boolean receberLance(IParticipante participante, double valor) {
        if (encerrado) {
            System.out.println("Lance recusado: lote " + nome + " encerrado.");
            return false;
        }
        double minimo = lanceAtual * 1.05;
        if (participante == null || !Double.isFinite(valor) || valor < minimo || valor <= lanceAtual) {
            System.out.printf("Lance recusado em %s: minimo de R$ %.2f (aumento de 5%%).%n", nome, minimo);
            return false;
        }
        lanceAtual = valor;
        Lance lance = new Lance(participante, valor);
        lances.add(lance);
        System.out.printf("Lance aceito: %s | %s | R$ %.2f%n", nome, participante.getNome(), valor);
        for (ObservadorLote observador : observadores) {
            if (observador != participante) {
                observador.atualizar(this, lance);
            }
        }
        return true;
    }

    public void encerrar() {
        if (encerrado) {
            System.out.println("Lote ja encerrado: " + nome);
            return;
        }
        encerrado = true;
        vendido = !lances.isEmpty() && lanceAtual >= precoReserva;
        if (vendido) {
            comissaoCobrada = comissao.calcular(lanceAtual);
            Lance ultimo = lances.get(lances.size() - 1);
            System.out.printf("%s VENDIDO para %s por R$ %.2f%n", nome,
                    ultimo.getParticipante().getNome(), lanceAtual);
        } else {
            System.out.println(nome + " NAO VENDIDO: sem lance que atinja a reserva.");
        }
    }

    public void imprimirAcerto() {
        if (!vendido) {
            System.out.println("Sem acerto: lote nao vendido.");
            return;
        }
        System.out.println("=== Acerto do vendedor: " + nome + " ===");
        System.out.printf("Valor de venda: R$ %.2f%n", lanceAtual);
        System.out.printf("Comissao: R$ %.2f%n", comissaoCobrada);
        System.out.printf("Valor liquido: R$ %.2f%n", lanceAtual - comissaoCobrada);
    }
}
