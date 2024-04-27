package sistema_bancário;

public class Cliente extends Thread {
    private Conta conta;

    public Cliente(String nome, double saldoInicial) {
        this.conta = new Conta(this, saldoInicial);
        this.setName(nome);
    }

    @Override
    public void run() {
        while (conta.getSaldo() > 0) {
            double valorCompra = Math.random() < 0.5 ? 100 : 200;
            Loja.lojas[(int) (Math.random() * Loja.lojas.length)].realizarCompra(this, valorCompra);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Conta getConta() {
        return conta;
    }
}
