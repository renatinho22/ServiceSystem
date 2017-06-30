package br.com.sms.servico.solicitante;

import javax.swing.JOptionPane;

import br.com.sms.servico.controllers.SolicitanteController;
import br.com.sms.servico.models.SolicitantePO;

public class TestaExclusaoSolicitante {

	public static void main(String[] args) {
		try {
			SolicitanteController c = new SolicitanteController();
			SolicitantePO solicitantePO = c.selectById(1L);
			c.excluir(solicitantePO);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
