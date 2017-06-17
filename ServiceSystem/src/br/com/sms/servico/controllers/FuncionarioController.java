package br.com.sms.servico.controllers;

import java.util.List;

import br.com.sms.servico.daos.FuncionarioDao;
import br.com.sms.servico.models.FuncionarioPO;

public class FuncionarioController {

	private FuncionarioDao dao = new FuncionarioDao();

	public void inserir(FuncionarioPO po) {
		dao.inserir(po);
	}

	public List<FuncionarioPO> select() {
		return dao.select();
	}

	public FuncionarioPO selectById(Long id) {
		return dao.selectById(id);
	}
}
