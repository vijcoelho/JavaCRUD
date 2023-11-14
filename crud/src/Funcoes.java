import dao.UsuarioDao;
import entidade.Usuario;

import java.util.Scanner;

public class Funcoes {
    private final Scanner scanner;
    private final UsuarioDao usuarioDao;

    public Funcoes() {
        this.scanner = new Scanner(System.in);
        this.usuarioDao = new UsuarioDao();
    }

    public void novoCadastro() {
        Usuario usuario = new Usuario();
        System.out.print("\u001b[2J\u001b[H");

        System.out.print("Nome: ");
        usuario.setNome_usuario(scanner.next());

        System.out.print("Idade: ");
        usuario.setIdade_usuario(scanner.nextInt());

        System.out.print("Email: ");
        usuario.setEmail_usuario(scanner.next());

        System.out.print("Senha (somente numeros): ");
        usuario.setSenha_usuario(scanner.nextInt());

        System.out.print("CPF: ");
        usuario.setCpf_usuario(scanner.nextInt());

        usuarioDao.cadastrarUsuario(usuario);
    }

    public void alterarCadastro() {
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();

        Usuario usuario = usuarioDao.obterUsuarioPorId(id);

        if (usuario != null) {
            System.out.print("\u001b[2J\u001b[H");
            System.out.println("ID encontrado. Escolha o que deseja alterar:");
            System.out.println("1. Alterar Email");
            System.out.println("2. Alterar Senha");
            System.out.println("Seu email atual é: " + usuario.getEmail_usuario());
            System.out.println("Sua senha atual é: " + usuario.getSenha_usuario());
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\u001b[2J\u001b[H");
                    System.out.print("Novo email: ");
                    usuario.setEmail_usuario(scanner.next());
                    break;

                case 2:
                    System.out.print("\u001b[2J\u001b[H");
                    System.out.print("Nova senha: ");
                    usuario.setSenha_usuario(scanner.nextInt());
                    break;

                default:
                    System.out.println("Opção Inválida");
            }

            usuarioDao.atualizarUsuario(usuario);
        } else {
            System.out.println("ID não encontrado");
        }
    }

    public void pesquisa() {
        System.out.print("\u001b[2J\u001b[H");
        System.out.print("Digite o CPF para pesquisar o usuário: ");
        int cpf = scanner.nextInt();

        Usuario usuario = usuarioDao.obterUsuarioPorCPF(cpf);

        if (usuario != null) {
            System.out.println("ID do Usuário: " + usuario.getIdusuario());
            System.out.println("Nome do Usuário: " + usuario.getNome_usuario());
            System.out.println("Idade do Usuário: " + usuario.getIdade_usuario());
            System.out.println("E-mail do Usuário: " + usuario.getEmail_usuario());
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void deletarCadastro() {
        System.out.print("\u001b[2J\u001b[H");
        System.out.print("Digite o ID para deletar o usuário: ");
        int id = scanner.nextInt();

        usuarioDao.deletarUsuario(id);

        System.out.println("Usuário deletado com sucesso (se existir).");
    }
}
