package entities;

public class AdministradorDTO {

    // Atributos da classe

    private String nomeUsuario;
    private String sobrenomeUsuario;
    private String usuario;
    private Integer senha;

    // Construtores

    public AdministradorDTO(){}

    public AdministradorDTO(String nomeUsuario, String sobrenomeUsuario, String usuario, Integer senha) {
        this.nomeUsuario = nomeUsuario;
        this.sobrenomeUsuario = sobrenomeUsuario;
        this.usuario = usuario;
        this.senha = senha;
    }

    // Getters e Setter

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    // ToString

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "nomeUsuario='" + nomeUsuario + '\'' +
                ", sobrenomeUsuario='" + sobrenomeUsuario + '\'' +
                ", usuario='" + usuario + '\'' +
                ", senha=" + senha +
                '}';
    }

}
