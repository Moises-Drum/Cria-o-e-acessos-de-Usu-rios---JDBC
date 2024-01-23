package dao;

public class UserPessoa {
    private static String nome;
    private static String cpf;
    private static String email;
    private static String senha;
    private static String telefone;

    public UserPessoa(){}

    public UserPessoa(String nome, String cpf, String email, String senha, String telefone) {
        UserPessoa.nome = nome;
        UserPessoa.cpf = cpf;
        UserPessoa.email = email;
        UserPessoa.senha = senha;
        UserPessoa.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        UserPessoa.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        UserPessoa.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        UserPessoa.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        UserPessoa.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        UserPessoa.telefone = telefone;
    }
}
