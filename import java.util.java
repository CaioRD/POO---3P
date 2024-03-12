import java.util.ArrayList;

class Conta {
    private String numero;
    private double saldo;
    private String nomeCliente;

    public Conta(String numero, double saldo, String nomeCliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.nomeCliente = nomeCliente;
    }

    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    // Métodos para depósito e saque
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso. Novo saldo: R$" + saldo);
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para saque.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso. Novo saldo: R$" + saldo);
        }
    }
}

class Banco {
    private ArrayList<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    // Métodos para adicionar e remover contas
    public void adicionarConta(Conta conta) {
        contas.add(conta);
        System.out.println("Conta adicionada com sucesso.");
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
        System.out.println("Conta removida com sucesso.");
    }

    // Método para depositar dinheiro em uma conta
    public void depositar(String numeroConta, double valor) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                conta.depositar(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    // Método para sacar dinheiro de uma conta
    public void sacar(String numeroConta, double valor) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                conta.sacar(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Conta conta1 = new Conta("123", 1000.0, "Cliente 1");
        Conta conta2 = new Conta("456", 2000.0, "Cliente 2");
        Conta conta3 = new Conta("789", 3000.0, "Cliente 3");

        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);
        banco.adicionarConta(conta3);

        // Operações de depósito e saque em uma conta específica
        banco.depositar("123", 500.0);
        banco.sacar("456", 1000.0);
    }
}
