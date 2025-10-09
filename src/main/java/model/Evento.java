package model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, length = 500)
	private String descricao;

	@Column(nullable = false)
	private LocalDateTime dataInicio;

	@Column(nullable = false)
	private LocalDateTime dataFim;

	@Column(nullable = false, length = 200)
	private String local;

	@Column(nullable = false)
	private int capacidadeMaxima;

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private StatusEvento status = StatusEvento.PLANEJAMENTO;

	@Column(nullable = false)
	private LocalDateTime dataCriacao = LocalDateTime.now();

	public Evento() {
	}

	public Evento(String nome, String descricao, LocalDateTime dataInicio, LocalDateTime dataFim, String local,
			int capacidadeMaxima) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.local = local;
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public StatusEvento getStatus() {
		return status;
	}

	public void setStatus(StatusEvento status) {
		this.status = status;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	enum StatusEvento {
		PLANEJAMENTO, ABERTO, EM_ANDAMENTO, ENCERRADO, CANCELADO
	}
}