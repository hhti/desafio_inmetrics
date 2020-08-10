#language: pt
#encoding: iso-8859-1

@CadastroFuncionario
Funcionalidade: Cadastro de Funcionario
	
  @FE001_CadastroFucionario
  Cenario: CE001 - Cadastro de Funcionario
		Dado que o usuario preenha o campo usuario com um usuario previamente cadastrado
		E preencher o campo senha com o valor "inmrobo123"		
		E acione o botao Entre	
		E acionar o botao Novo Funcionario		
		E preencher todos campos
		Quando acionar o botao Enviar
    Entao o sistema emite a mensagem de sucesso "SUCESSO! Usuário cadastrado com sucesso "				
		
		
		
		
    
    
