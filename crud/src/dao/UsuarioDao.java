package dao;

import conexao.Conexao;
import entidade.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UsuarioDao {
    public void cadastrarUsuario(Usuario usuario) {
        String sql = "insert into javacrud.usuario (nome_usuario, idade_usuario, email_usuario, senha_usuario, cpf_usuario) values(?,?,?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = Objects.requireNonNull(Conexao.getConnection()).prepareStatement(sql);

            ps.setString(1, usuario.getNome_usuario());
            ps.setInt(2, usuario.getIdade_usuario());
            ps.setString(3, usuario.getEmail_usuario());
            ps.setInt(4, usuario.getSenha_usuario());
            ps.setInt(5, usuario.getCpf_usuario());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar usuário");
        }
    }

    public Usuario obterUsuarioPorCPF(int cpf) {
        String sql = "select * from javacrud.usuario where cpf_usuario = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            ps = Objects.requireNonNull(Conexao.getConnection()).prepareStatement(sql);
            ps.setInt(1, cpf);
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("idUsuario"));
                usuario.setNome_usuario(rs.getString("nome_usuario"));
                usuario.setIdade_usuario(rs.getInt("idade_usuario"));
                usuario.setEmail_usuario(rs.getString("email_usuario"));
                usuario.setSenha_usuario(rs.getInt("senha_usuario"));
                usuario.setCpf_usuario(rs.getInt("cpf_usuario"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao obter usuário por CPF");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuario;
    }

    public Usuario obterUsuarioPorId(int id) {
        String sql = "select * from javacrud.usuario where idUsuario = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            ps = Objects.requireNonNull(Conexao.getConnection()).prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("idUsuario"));
                usuario.setNome_usuario(rs.getString("nome_usuario"));
                usuario.setIdade_usuario(rs.getInt("idade_usuario"));
                usuario.setEmail_usuario(rs.getString("email_usuario"));
                usuario.setSenha_usuario(rs.getInt("senha_usuario"));
                usuario.setCpf_usuario(rs.getInt("cpf_usuario"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao obter usuário por ID");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuario;
    }

    public void atualizarUsuario(Usuario usuario) {
        String sql = "update javacrud.usuario set email_usuario = ?, senha_usuario = ? where idUsuario = ?";
        PreparedStatement ps = null;

        try {
            ps = Objects.requireNonNull(Conexao.getConnection()).prepareStatement(sql);

            ps.setString(1, usuario.getEmail_usuario());
            ps.setInt(2, usuario.getSenha_usuario());
            ps.setInt(3, usuario.getIdusuario());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar usuário");
        }
    }

    public void deletarUsuario(int id) {
        String sql = "delete from javacrud.usuario where idUsuario = ?";
        PreparedStatement ps = null;

        try {
            ps = Objects.requireNonNull(Conexao.getConnection()).prepareStatement(sql);

            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar usuário");
        }
    }
}
