package br.com.sms.servico.funcionario;

import br.com.sms.servico.controllers.FuncionarioController;
import br.com.sms.servico.models.FuncionarioPO;

public class TestaAlterarFuncionario {

	public static void main(String[] args) throws Exception {

		FuncionarioController controller = new FuncionarioController();
		FuncionarioPO funcionarioPO = controller.selectById(2L);

		funcionarioPO.setNome("Guto");
		controller.alterar(funcionarioPO);
		System.out.println(funcionarioPO);

	}

}
