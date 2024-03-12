import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Criando o banco
            Banco banco = new Banco();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Exibindo o menu
                System.out.println("Escolha uma opção:");
                System.out.println("1. Adicionar Conta");
                System.out.println("2. Remover Conta");
                System.out.println("3. Depositar");
                System.out.println("4. Sacar");
                System.out.println("5. Sair");

                // Lendo a escolha do usuário
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        // Adicionando conta
                        System.out.println("Informe o número da conta:");
                        String numeroConta = scanner.next();
                        System.out.println("Informe o saldo inicial:");
                        double saldoInicial = scanner.nextDouble();
                        System.out.println("Informe o nome do cliente:");
                        String nomeCliente = scanner.next();
                        Conta novaConta = new Conta(numeroConta, saldoInicial, nomeCliente);
                        banco.adicionarConta(novaConta);
                        break;
                    case 2:
                        // Removendo conta
                        System.out.println("Informe o número da conta a ser removida:");
                        String numeroContaRemover = scanner.next();
                        Conta contaRemover = banco.buscarContaPorNumero(numeroContaRemover);
                        banco.removerConta(contaRemover);
                        break;
                    case 3:
                        // Depositando dinheiro
                        System.out.println("Informe o número da conta para depositar:");
                        String numeroContaDepositar = scanner.next();
                        Conta contaDepositar = banco.buscarContaPorNumero(numeroContaDepositar);
                        System.out.println("Informe o valor a ser depositado:");
                        double valorDeposito = scanner.nextDouble();
                        banco.depositar(contaDepositar, valorDeposito);
                        break;
                    case 4:
                        // Sacando dinheiro
                        System.out.println("Informe o número da conta para sacar:");
                        String numeroContaSacar = scanner.next();
                        Conta contaSacar = banco.buscarContaPorNumero(numeroContaSacar);
                        System.out.println("Informe o valor a ser sacado:");
                        double valorSaque = scanner.nextDouble();
                        banco.sacar(contaSacar, valorSaque);
                        break;
                    case 5:
                        // Saindo do programa
                        System.out.println("Saindo do programa. Obrigado!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                }
            }
        } catch (ContaNaoEncontradaException | ContaEncontradaException e) {
            e.printStackTrace();
        }
    }
}
