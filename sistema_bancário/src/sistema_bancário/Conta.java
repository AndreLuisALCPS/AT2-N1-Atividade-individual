 package sistema_bancário;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conta {
    private double saldo;
    private final Lock lock;

    public Conta(double saldo) {
        this.saldo = saldo;
        this.lock = new ReentrantLock();
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        lock.lock();
        try {
            saldo += valor;
        } finally {
            lock.unlock();
        }
    }

    public boolean sacar(double valor) {
        lock.lock();
        try {
            if (saldo >= valor) {
                saldo -= valor;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public boolean transferir(Conta destino, double valor) {
        lock.lock();
        try {
            if (sacar(valor)) {
                destino.depositar(valor);
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}
