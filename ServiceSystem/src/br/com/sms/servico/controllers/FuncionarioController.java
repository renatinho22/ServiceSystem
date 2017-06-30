package br.com.sms.servico.controllers;

import java.util.List;

import br.com.sms.servico.daos.FuncionarioDao;
import br.com.sms.servico.models.FuncionarioPO;

public class FuncionarioController {

	private FuncionarioDao dao = new FuncionarioDao();

	public void inserir(FuncionarioPO po) throws Exception {
		dao.inserir(po);
	}

	public void alterar(FuncionarioPO po) throws Exception {
		dao.alterar(po);
	}

	public void excluir(FuncionarioPO po) throws Exception {
		dao.alterar(po);
	}

	public List<FuncionarioPO> selectDynamic(String nome, String cpf, String setor) throws Exception {
		return dao.selectDynamic(nome, cpf, setor);
	}

	public List<FuncionarioPO> select() throws Exception {
		return dao.select();
	}

	public FuncionarioPO selectById(Long id) throws Exception {
		return dao.selectById(id);
	}
}
