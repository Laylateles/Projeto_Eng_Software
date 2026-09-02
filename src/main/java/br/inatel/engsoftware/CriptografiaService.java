package br.inatel.engsoftware;

public interface CriptografiaService {
    String gerarHash(String senhaNormal);
    boolean verificarSenha(String senhaNormal,String senhaHash);

}
