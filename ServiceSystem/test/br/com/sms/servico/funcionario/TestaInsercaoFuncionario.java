package br.com.sms.servico.funcionario;

import br.com.sms.servico.controllers.FuncionarioController;
import br.com.sms.servico.models.FuncionarioPO;

public class TestaInsercaoFuncionario {

	public static void main(String[] args) {
		FuncionarioPO po = new FuncionarioPO();
		po.setCargo("Estagiário");
		po.setCpf("222.222.221-30");
		po.setEmail("teste@teste.com");
		po.setNome("João");
		po.setSetor("Informática");
		po.setTelefone("(18) 99711-1100");

		FuncionarioController controller = new FuncionarioController();

		controller.inserir(po);
	}
}
