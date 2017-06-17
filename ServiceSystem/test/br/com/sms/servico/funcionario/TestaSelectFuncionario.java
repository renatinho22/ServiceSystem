package br.com.sms.servico.funcionario;

import java.util.List;

import br.com.sms.servico.controllers.FuncionarioController;
import br.com.sms.servico.models.FuncionarioPO;

public class TestaSelectFuncionario {

	public static void main(String[] args) {
		FuncionarioController controller = new FuncionarioController();
		List<FuncionarioPO> funcionarios = controller.select();
		System.out.println(funcionarios);
	}
}
