package br.com.sms.servico.solicitante;

import javax.swing.JOptionPane;

import br.com.sms.servico.controllers.SolicitanteController;
import br.com.sms.servico.models.SolicitantePO;

public class TestaAlterarSolicitante {

	public static void main(String[] args) {
		try {

			SolicitanteController c = new SolicitanteController();
			SolicitantePO po = c.selectById(1L);
			po.setNome("Maria Chulapa");
			c.alterar(po);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
