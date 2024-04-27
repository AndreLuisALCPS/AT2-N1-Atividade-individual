package sistema_bancário;

public class Funcionario extends Thread {
    private Loja loja;
    private Conta contaSalario;
    private Conta contaInvestimento;

    public Funcionario(Loja loja) {
        this.loja = loja;
        this.contaSalario = new Conta(null, 0);
        this.contaInvestimento = new Conta(null, 0);
    }

    @Override
    public void run() {
        while (true) {
            loja.pagarSalario(this);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Loja getLoja() {
        return loja;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }
}