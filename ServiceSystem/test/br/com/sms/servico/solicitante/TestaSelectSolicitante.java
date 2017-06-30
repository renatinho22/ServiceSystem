package br.com.sms.servico.solicitante;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.sms.servico.controllers.SolicitanteController;
import br.com.sms.servico.models.SolicitantePO;

public class TestaSelectSolicitante {

	public static void main(String[] args) {
		try {
			SolicitanteController c = new SolicitanteController();
			List<SolicitantePO> solicitantes = c.select();
			System.out.println(solicitantes);

			SolicitantePO solicitantePO = c.selectById(1L);
			System.err.println(solicitantePO);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
