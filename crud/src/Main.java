import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcoes funcoes = new Funcoes();

        while (true) {
            exibirMenu();

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\u001b[2J\u001b[H");
                    funcoes.novoCadastro();
                    break;

                case 2:
                    System.out.print("\u001b[2J\u001b[H");
                    funcoes.alterarCadastro();
                    break;

                case 3:
                    System.out.print("\u001b[2J\u001b[H");
                    funcoes.pesquisa();
                    break;

                case 4:
                    System.out.print("\u001b[2J\u001b[H");
                    funcoes.deletarCadastro();
                    break;

                case 0:
                    System.out.print("\u001b[2J\u001b[H");
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;

                default:
                    System.out.print("\u001b[2J\u001b[H");
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void exibirMenu() {
        System.out.print("\u001b[2J\u001b[H");
        System.out.println("1- Cadastrar Usuario");
        System.out.println("2- Atualizar Usuario");
        System.out.println("3- Pesquisar Usuario");
        System.out.println("4- Deletar Usuario");
        System.out.println("0- Sair");
        System.out.print("Escolha uma opção: ");
    }
}
