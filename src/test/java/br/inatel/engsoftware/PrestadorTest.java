package br.inatel.engsoftware;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class PrestadorTest {

    private Prestador prestador;
    private CriptografiaService criptografiaMock;

    @BeforeEach
    public void setUp() {
        CriptografiaService criptografiaMock = Mockito.mock(CriptografiaService.class);
        when(criptografiaMock.gerarHash(anyString())).thenReturn("hashFalso");

        Prestador prestador = new Prestador(1, "João", "joao@email.com", "senha123", "999999999",
                criptografiaMock, "Encanador", "Consertos em geral", "Santa Rita", 50.0);
    }

    @Test
    public void testePrestadorNovoTemMediaZero() {
        prestador.calcularEAtualizarMedia();
        Assertions.assertEquals(0.0, prestador.getNotamedia());
    }

    @Test
    public void testeReceberAvaliacaoAtualizaMediaCorretamente() {
        // O Mockito "finge" ser a nova classe Avaliacao sem precisar preencher os IDs e Datas no construtor!
        Avaliacao avaliacao1 = Mockito.mock(Avaliacao.class);
        Avaliacao avaliacao2 = Mockito.mock(Avaliacao.class);

        when(avaliacao1.getNota()).thenReturn(5);
        when(avaliacao2.getNota()).thenReturn(4);

        prestador.receberAvaliacao(avaliacao1);
        prestador.receberAvaliacao(avaliacao2);

        Assertions.assertEquals(4.5, prestador.getNotamedia());
    }

    @Test
    public void testeCadastrarServicoComSucesso() {
        prestador.cadastrarServico("Troca de torneira");

        Assertions.assertTrue(prestador.getServicos().contains("Troca de torneira"));
        Assertions.assertEquals(1, prestador.getServicos().size());
    }
}



