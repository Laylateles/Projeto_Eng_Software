package br.inatel.engsoftware;
import java.time.LocalDateTime;

public class Avaliacao {
    private int nota;
    private String comentario;
    private Usuario cliente;
    private LocalDateTime dataHora;

    public  Avaliacao(int nota, String comentario, Usuario cliente) {
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("A nota deve estra entre 1 e 5");
        }

        if (cliente == null) {
            throw new IllegalArgumentException("O cliente autor da avaliação não pode ser nulo.");
        }

        this.nota = nota;
        this.comentario = comentario;
        this.cliente = cliente;
        this.dataHora = LocalDateTime.now();


    }

    public int getNota() { return nota; }

    public String getComentario() { return comentario; }

    public Usuario getCliente() { return cliente; }

    public LocalDateTime getDataHora() { return dataHora; }
}
