package br.inatel.engsoftware;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class Usuariobase extends Usuario {
    public Usuariobase(int id, String nome, String email, String senha, String telefone, CriptografiaService criptografiaService) {
        super(id, nome, email, senha, telefone, criptografiaService);
    }
}

public class UsuarioTest {
    private Usuario usuario;
    private CriptografiaService criptografiaMock;
}
