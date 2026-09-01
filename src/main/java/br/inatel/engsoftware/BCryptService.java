package br.inatel.engsoftware;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptService implements CriptografiaService{

    @Override
    public String gerarHash(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    @Override
    public boolean verificarSenha(String senhaNormal, String senhaHash) {
        return BCrypt.checkpw(senhaNormal, senhaHash);
    }
}
