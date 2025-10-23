package model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "participante_id", nullable = false)
    private Participante participante;

    @ManyToOne
    @JoinColumn(name = "sessao_id", nullable = false)
    private Sessao sessao;

    @Column(nullable = false)
    private int notaConteudo;

    @Column(nullable = false)
    private int notaPalestrante;

    @Column(nullable = false)
    private int notaOrganizacao;

    @Column(length = 1000)
    private String comentario;

    @Column(nullable = false)
    private LocalDateTime dataAvaliacao = LocalDateTime.now();

    public Feedback() {
    }

    public Feedback(Participante participante, Sessao sessao, int notaConteudo, int notaPalestrante, int notaOrganizacao) {
        this.participante = participante;
        this.sessao = sessao;
        this.notaConteudo = notaConteudo;
        this.notaPalestrante = notaPalestrante;
        this.notaOrganizacao = notaOrganizacao;
    }

    public double getMediaGeral() {
        return (notaConteudo + notaPalestrante + notaOrganizacao) / 3.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public int getNotaConteudo() {
        return notaConteudo;
    }

    public void setNotaConteudo(int notaConteudo) {
        this.notaConteudo = notaConteudo;
    }

    public int getNotaPalestrante() {
        return notaPalestrante;
    }

    public void setNotaPalestrante(int notaPalestrante) {
        this.notaPalestrante = notaPalestrante;
    }

    public int getNotaOrganizacao() {
        return notaOrganizacao;
    }

    public void setNotaOrganizacao(int notaOrganizacao) {
        this.notaOrganizacao = notaOrganizacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}