package entities;

public class ClienteDTO {

    // Atributos da classe

    private String nome;
    private String sobreNome;
    private String endereco;
    private String email;
    private Integer senha;

    // Construtor

    public ClienteDTO(){};

    public ClienteDTO(String nome, String sobreNome, String endereco, String email, Integer senha){
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    // toString

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", senha=" + senha +
                '}';
    }

}
