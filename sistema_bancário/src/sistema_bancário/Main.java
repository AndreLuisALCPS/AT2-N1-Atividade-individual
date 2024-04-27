package sistema_bancário;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Loja loja1 = new Loja(0, 2);
        Loja loja2 = new Loja(0, 2);
        Loja.lojas = new Loja[]{loja1, loja2};

        Cliente[] clientes = {
                new Cliente("Cliente 1", 1000),
                new Cliente("Cliente 2", 1000),
                new Cliente("Cliente 3", 1000),
                new Cliente("Cliente 4", 1000),
                new Cliente("Cliente 5", 1000)
        };
        for (Cliente cliente : clientes) {
            cliente.start();
        }


        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}