package model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "inscricao", uniqueConstraints = @UniqueConstraint(columnNames = {"participante_id", "sessao_id"}))
public class Inscricao {

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
    private LocalDateTime dataInscricao = LocalDateTime.now();

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private StatusInscricao status = StatusInscricao.CONFIRMADA;

    @Column
    private LocalDateTime dataComparecimento;

    @Column(nullable = false)
    private boolean compareceu = false;

    @Column(length = 100)
    private String codigoCracha;

    public enum StatusInscricao {
        CONFIRMADA, CANCELADA, LISTA_ESPERA
    }

    public Inscricao() {
    }

    public Inscricao(Participante participante, Sessao sessao) {
        this.participante = participante;
        this.sessao = sessao;
        this.codigoCracha = gerarCodigoCracha();
    }

    private String gerarCodigoCracha() {
        return "CR-" + System.currentTimeMillis();
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

    public LocalDateTime getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDateTime dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public StatusInscricao getStatus() {
        return status;
    }

    public void setStatus(StatusInscricao status) {
        this.status = status;
    }

    public LocalDateTime getDataComparecimento() {
        return dataComparecimento;
    }

    public void setDataComparecimento(LocalDateTime dataComparecimento) {
        this.dataComparecimento = dataComparecimento;
    }

    public boolean isCompareceu() {
        return compareceu;
    }

    public void setCompareceu(boolean compareceu) {
        this.compareceu = compareceu;
    }

    public String getCodigoCracha() {
        return codigoCracha;
    }

    public void setCodigoCracha(String codigoCracha) {
        this.codigoCracha = codigoCracha;
    }
}