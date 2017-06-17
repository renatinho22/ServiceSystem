package br.com.sms.servico.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.sms.servico.abstracts.AbstractPO;

@Entity
@Table(name = "funcionarios", uniqueConstraints = @UniqueConstraint(columnNames = { "cpf" }))
public class FuncionarioPO extends AbstractPO {

	@Column(name = "nome", length = 150, nullable = false)
	private String nome;

	@Column(name = "cpf", length = 14, nullable = false)
	private String cpf;

	@Column(name = "cargo", length = 25, nullable = false)
	private String cargo;

	@Column(name = "email", length = 120, nullable = true)
	private String email;

	@Column(name = "setor", length = 25, nullable = false)
	private String setor;

	@Column(name = "telefone", length = 15, nullable = true)
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", setor=" + setor + ", telefone=" + telefone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionarioPO other = (FuncionarioPO) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
