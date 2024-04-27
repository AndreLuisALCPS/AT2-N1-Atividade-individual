package sistema_bancário;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
 private static final Lock lock = new ReentrantLock();

 public static void transferir(Conta origem, Conta destino, double valor) {
     lock.lock();
     try {
         if (origem.getSaldo() >= valor) {
             origem.debitar(valor);
             destino.creditar(valor);
             System.out.println("Transferência de R$" + valor + " de " + origem.getCliente().getName() + " para " + destino.getCliente().getName());
         } else {
             System.out.println("Saldo insuficiente para transferência de " + origem.getCliente().getName() + " para " + destino.getCliente().getName());
         }
     } finally {
         lock.unlock();
     }
 }
}
