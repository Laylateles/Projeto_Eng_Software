package br.inatel.engsoftware;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AvaliacaoTest {
    @Test
    void testeValidarAvaliacaoCorreta() {
        // IDs diferentes, nota entre 1 e 5, data preenchida
        Avaliacao avaliacao = new Avaliacao(1, 2, 5, "Serviço excelente!", LocalDate.now());

        Assertions.assertTrue(avaliacao.validar());
    }

    @Test
    void testeValidarBloqueiaNotaForaDoLimite() {
        Avaliacao avaliacaoAcima = new Avaliacao(1, 2, 6, "Nota alta", LocalDate.now());
        Avaliacao avaliacaoAbaixo = new Avaliacao(1, 2, 0, "Nota baixa", LocalDate.now());

        Assertions.assertFalse(avaliacaoAcima.validar());
        Assertions.assertFalse(avaliacaoAbaixo.validar());
    }

    @Test
    void testeValidarBloqueiaAutoAvaliacao() {
        // Autor e Avaliado têm o mesmo ID (1)
        Avaliacao avaliacao = new Avaliacao(1, 1, 4, "Avaliando a mim mesmo", LocalDate.now());

        Assertions.assertFalse(avaliacao.validar());
    }

    @Test
    void testeValidarBloqueiaDataNula() {
        Avaliacao avaliacao = new Avaliacao(1, 2, 4, "Faltou a data", null);

        Assertions.assertFalse(avaliacao.validar());
    }

    @Test
    void testeFormatarComComentario() {
        LocalDate data = LocalDate.of(2026, 9, 3);
        Avaliacao avaliacao = new Avaliacao(1, 2, 5, "Muito bom!", data);

        Assertions.assertEquals("[2026-09-03] Nota 5/5 - Muito bom!", avaliacao.formatar());
    }

    @Test
    void testeFormatarSemComentario() {
        LocalDate data = LocalDate.of(2026, 9, 3);
        // Passando string vazia (blank)
        Avaliacao avaliacao = new Avaliacao(1, 2, 3, "   ", data);

        Assertions.assertEquals("[2026-09-03] Nota 3/5 - sem comentario", avaliacao.formatar());
    }
}






