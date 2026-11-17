import java.util.Locale;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Locale.setDefault(Locale.forLanguageTag("pt-BR"));
        Provisionamento aws = new Provisionamento(new FactoryAws());
        Provisionamento azure = new Provisionamento(new FactoryAzure());

        Thread primeiro = new Thread(() -> aws.provisionar("Desenvolvimento", 2, 100));
        Thread segundo = new Thread(() -> azure.provisionar("Homologacao", 1, 200));
        primeiro.start();
        segundo.start();
        primeiro.join();
        segundo.join();

        aws.provisionar("Producao", 3, 300);
        aws.provisionar("Ambiente muito caro", 100, 1000);
        Auditoria.getInstancia().imprimir();
    }
}
