package br.inatel.engsoftware;
import org.mindrot.jbcrypt.BCrypt;

public abstract class Usuario {
    public int id;
    private String nome;
    private String email;
    private String senhaHash;
    private String telefone;
    private double notamedia;


    // Construtor
    public Usuario(String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senhaHash = BCrypt.hashpw(senha, BCrypt.gensalt());
        this.telefone = telefone;
    }

    // Métodos para ver e alterar os dados
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    // Meio de login
    public boolean login(String emailDigitado, String senhaDigitada) {
        boolean emailCorreto = this.email.equals(emailDigitado);
        boolean senhaCorreta = BCrypt.checkpw(senhaDigitada, this.senhaHash);
        return emailCorreto && senhaCorreta;
    }

    // Meio de alterar senha
    public boolean alterarSenha(String senhaAtual, String novaSenha) {
        if (!BCrypt.checkpw(senhaAtual, this.senhaHash)) {
            System.out.println("Senha atual incorreta. Alteração não realizada.");
            return false;
        }
        this.senhaHash = BCrypt.hashpw(novaSenha, BCrypt.gensalt());
        System.out.println("Senha alterada com sucesso.");
        return true;
    }

    // Meio de exibir o perfil do usuário
    public void exibirPerfil() {
        System.out.println("Perfil do Usuário");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
    }

    public void AtualizarNotaMedia(double notaMedia) {
        this.notamedia = notaMedia;
    }
}
