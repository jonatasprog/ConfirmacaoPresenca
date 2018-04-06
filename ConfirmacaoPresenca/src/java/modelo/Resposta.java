package modelo;

/**
 *
 * @author Jônatas e Wesley
 */
public class Resposta {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;
    private int presenca;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPresenca() {
        return presenca;
    }

    public void setPresenca(int presenca) {
        this.presenca = presenca;
    }

}
