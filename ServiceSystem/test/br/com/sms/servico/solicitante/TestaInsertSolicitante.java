package br.com.sms.servico.solicitante;

import javax.swing.JOptionPane;

import br.com.sms.servico.controllers.SolicitanteController;
import br.com.sms.servico.models.SolicitantePO;
import br.com.sms.servico.models.Unidade;

public class TestaInsertSolicitante {

	public static void main(String[] args) {
		try {

			SolicitantePO po = new SolicitantePO();
			po.setCpf("221.44.981-30");
			po.setNome("Maria Betania");
			po.setTelefone("(18) 3322-1013");
			po.setUnidade(Unidade.ESF_VITORIA);

			SolicitanteController c = new SolicitanteController();
			c.inserir(po);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
