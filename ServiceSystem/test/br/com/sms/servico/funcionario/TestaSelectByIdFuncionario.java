package br.com.sms.servico.funcionario;

import br.com.sms.servico.controllers.FuncionarioController;
import br.com.sms.servico.models.FuncionarioPO;

public class TestaSelectByIdFuncionario {

	public static void main(String[] args) throws Exception {
		FuncionarioController controller = new FuncionarioController();
		FuncionarioPO funcionario = controller.selectById(1L);

		System.out.println(funcionario);
	}
}
