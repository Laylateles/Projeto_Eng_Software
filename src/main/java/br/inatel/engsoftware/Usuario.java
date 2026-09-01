package br.inatel.engsoftware;

public abstract class Usuario {
    public int id;
    private String nome;
    private String email;
    private String senhaHash;
    private String telefone;
    private double notamedia;


    private final CriptografiaService criptografiaService;

    // Construtor
    public Usuario(int id, String nome, String email, String senha, String telefone, CriptografiaService criptografiaService) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;


        this.criptografiaService = criptografiaService;


        this.senhaHash = this.criptografiaService.gerarHash(senha);
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }


    public boolean login(String emailDigitado, String senhaDigitada) {
        boolean emailCorreto = this.email.equals(emailDigitado);
        boolean senhaCorreta = this.criptografiaService.verificarSenha(senhaDigitada, this.senhaHash);

        return emailCorreto && senhaCorreta;
    }


    public boolean alterarSenha(String senhaAtual, String novaSenha) {
        if (!this.criptografiaService.verificarSenha(senhaAtual, this.senhaHash)) {
            return false;
        }
        this.senhaHash = this.criptografiaService.gerarHash(novaSenha);
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

    public void atualizarNotaMedia(double notaMedia) {
        this.notamedia = notaMedia;
    }

    public double getNotamedia() {
        return notamedia;
    }

    public void setNotamedia(double notamedia) {
        this.notamedia = notamedia;
    }
}