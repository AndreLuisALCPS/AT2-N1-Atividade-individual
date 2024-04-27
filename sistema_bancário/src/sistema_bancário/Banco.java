package sistema_bancário;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    public static List<Loja> lojas = new ArrayList<>();

    public static void main(String[] args) {
        Conta contaBanco = new Conta(0);
        Banco banco = new Banco();

        Loja loja1 = new Loja(new Conta(0));
        Loja loja2 = new Loja(new Conta(0));

        Conta salarioFuncionario1 = new Conta(1400);
        Conta investimentoFuncionario1 = new Conta(0);
        Funcionario funcionario1 = new Funcionario("Funcionário 1", salarioFuncionario1, investimentoFuncionario1);
        Conta salarioFuncionario2 = new Conta(1400);
        Conta investimentoFuncionario2 = new Conta(0);
        Funcionario funcionario2 = new Funcionario("Funcionário 2", salarioFuncionario2, investimentoFuncionario2);
        Conta salarioFuncionario3 = new Conta(1400);
        Conta investimentoFuncionario3 = new Conta(0);
        Funcionario funcionario3 = new Funcionario("Funcionário 3", salarioFuncionario3, investimentoFuncionario3);
        Conta salarioFuncionario4 = new Conta(1400);
        Conta investimentoFuncionario4 = new Conta(0);
        Funcionario funcionario4 = new Funcionario("Funcionário 4", salarioFuncionario4, investimentoFuncionario4);


        loja1.adicionarFuncionario(funcionario1);
        loja1.adicionarFuncionario(funcionario2);
        loja2.adicionarFuncionario(funcionario3);
        loja2.adicionarFuncionario(funcionario4);


        funcionario1.start();
        funcionario2.start();
        funcionario3.start();
        funcionario4.start();

        Conta contaCliente1 = new Conta(1000);
        Cliente cliente1 = new Cliente("Cliente 1", contaCliente1);
        Conta contaCliente2 = new Conta(1000);
        Cliente cliente2 = new Cliente("Cliente 2", contaCliente2);
        Conta contaCliente3 = new Conta(1000);
        Cliente cliente3 = new Cliente("Cliente 3", contaCliente3);
        Conta contaCliente4 = new Conta(1000);
        Cliente cliente4 = new Cliente("Cliente 4", contaCliente4);
        Conta contaCliente5 = new Conta(1000);
        Cliente cliente5 = new Cliente("Cliente 5", contaCliente5);

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
    }
}
