package entidade;

public class Usuario {
    private int idusuario;
    private String nome_usuario;
    private int idade_usuario;
    private String email_usuario;
    private int cpf_usuario;
    private int senha_usuario;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public int getIdade_usuario() {
        return idade_usuario;
    }

    public void setIdade_usuario(int idade_usuario) {
        this.idade_usuario = idade_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public int getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(int cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public int getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(int senha_usuario) {
        this.senha_usuario = senha_usuario;
    }
}
