import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    // Métodos para adicionar e remover contas
    public void adicionarConta(Conta conta) throws ContaEncontradaException {
        if (!contas.contains(conta)) {
            contas.add(conta);
            System.out.println("Conta adicionada com sucesso. Número da conta: " + conta.getNumero());
        } else {
            throw new ContaEncontradaException("Conta já está presente no Banco.");
        }
    }

    public void removerConta(Conta conta) throws ContaNaoEncontradaException {
        if (contas.remove(conta)) {
            System.out.println("Conta removida com sucesso. Número da conta: " + conta.getNumero());
        } else {
            throw new ContaNaoEncontradaException("Conta não encontrada no Banco.");
        }
    }

    // Métodos para depositar e sacar dinheiro de uma conta
    public void depositar(Conta conta, double valor) throws ContaNaoEncontradaException {
        if (contas.contains(conta)) {
            conta.depositar(valor);
        } else {
            throw new ContaNaoEncontradaException("Conta não encontrada no Banco.");
        }
    }

    public void sacar(Conta conta, double valor) throws ContaNaoEncontradaException {
        if (contas.contains(conta)) {
            conta.sacar(valor);
        } else {
            throw new ContaNaoEncontradaException("Conta não encontrada no Banco.");
        }
    }

    // Método para buscar conta pelo número
    public Conta buscarContaPorNumero(String numeroConta) throws ContaNaoEncontradaException, ContaEncontradaException {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                throw new ContaEncontradaException("Conta com número " + numeroConta + " já está presente no Banco.");
            }
        }
        throw new ContaNaoEncontradaException("Conta com número " + numeroConta + " não encontrada no Banco.");
    }

    // Método para buscar conta pelo objeto Conta
    public Conta buscarConta(Conta c) throws ContaNaoEncontradaException, ContaEncontradaException {
        if (contas.contains(c)) {
            throw new ContaEncontradaException("Conta já está presente no Banco.");
        }
        throw new ContaNaoEncontradaException("Conta não encontrada no Banco.");
    }
}
