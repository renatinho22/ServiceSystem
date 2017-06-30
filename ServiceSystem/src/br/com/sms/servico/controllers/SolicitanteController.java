package br.com.sms.servico.controllers;

import java.util.List;

import br.com.sms.servico.daos.SolicitanteDao;
import br.com.sms.servico.models.SolicitantePO;

public class SolicitanteController {

	private SolicitanteDao dao;

	public SolicitanteController() {
		dao = new SolicitanteDao();
	}

	public void inserir(SolicitantePO po) throws Exception {
		dao.inserir(po);
	}

	public void alterar(SolicitantePO po) throws Exception {
		dao.alterar(po);
	}

	public void excluir(SolicitantePO po) throws Exception {
		dao.excluir(po);
	}

	public List<SolicitantePO> select() throws Exception {
		return dao.select();
	}

	public SolicitantePO selectById(Long id) throws Exception {
		return dao.selectById(id);
	}
}
