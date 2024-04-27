package sistema_bancário;
public class Funcionario extends Thread {
    private final String nome;
    private final Conta salario;
    private final Conta investimento;
    private boolean recebeuSalario;

    public Funcionario(String nome, Conta salario, Conta investimento) {
        this.nome = nome;
        this.salario = salario;
        this.investimento = investimento;
    }
    @Override
    public void run() {
        synchronized (Banco.class) {
            double valorTransferido = salario.getSaldo() * 0.2;
            if (valorTransferido <= salario.getSaldo()) { 
                if (salario.transferir(investimento, valorTransferido)) {
                    System.out.println("Funcionário " + nome + " transferiu R$" + valorTransferido + " para investimento.");
                } else {
                    System.out.println("Funcionário " + nome + " não conseguiu transferir para investimento.");
                }
            } else {
                System.out.println("Funcionário " + nome + " não possui saldo suficiente para transferir para investimento.");
            }
        }
    }

    public boolean recebeuSalario() {
        return recebeuSalario;
    }

    public void receberSalario() {
        double valorSalario = salario.getSaldo();
        if (salario.transferir(investimento, valorSalario)) {
            System.out.println(nome + " recebeu o salário de R$" + valorSalario + ".");
            recebeuSalario = true;
        } else {
            System.out.println("Erro ao pagar salário para o funcionário " + nome + ".");
        }
    }

    public String getNome() {
        return nome;
    }
}
