package model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "sessao")
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(length = 1000)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(nullable = false)
    private LocalDateTime dataHoraFim;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "palestrante_id", nullable = false)
    private Palestrante palestrante;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private TipoSessao tipo = TipoSessao.PALESTRA;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private StatusSessao status = StatusSessao.AGENDADA;

    @Column(nullable = false)
    private int vagasDisponiveis;

    public enum TipoSessao {
        PALESTRA, WORKSHOP, MESA_REDONDA, PAINEL, MINICURSO
    }

    public enum StatusSessao {
        AGENDADA, EM_ANDAMENTO, CONCLUIDA, CANCELADA
    }

    public Sessao() {
    }

    public Sessao(String titulo, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, Evento evento, Sala sala, Palestrante palestrante) {
        this.titulo = titulo;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.evento = evento;
        this.sala = sala;
        this.palestrante = palestrante;
        this.vagasDisponiveis = sala.getCapacidade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Palestrante getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }

    public TipoSessao getTipo() {
        return tipo;
    }

    public void setTipo(TipoSessao tipo) {
        this.tipo = tipo;
    }

    public StatusSessao getStatus() {
        return status;
    }

    public void setStatus(StatusSessao status) {
        this.status = status;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }
}