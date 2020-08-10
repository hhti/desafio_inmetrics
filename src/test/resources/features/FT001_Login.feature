#language: pt
#encoding: iso-8859-1

@Login
Funcionalidade: Login
	
  @FE001_ValidacaoLoginInvalido
  Cenario: CE001 - Login - LoginInvalido
		Dado que o usuario insira dados invalidos na aplicacao inmrobo 
    Entao o sistema emite a mensagem "ERRO! Usu�rio ou Senha inv�lidos"		

  @FE002_ValidacaoCampoUsuarioObrigatorio
  Cenario: CE002 - Login - Campo usu�rio obrigat�rio 
		Dado que o usuario preenha o campo senha
		E acione o botao Entre
		Quando posicionar o mouse sobre o campo usuario
    Entao o sistema emite o texto "Campo obrigat�rio"	    
    
  @FE003_ValidacaoCampoSenhaObrigatorio
  Cenario: CE003 - Login - Campo senha obrigat�rio 
		Dado que o usuario preenha o campo usuario
		E acione o botao Entre
		Quando posicionar o mouse sobre o campo senha
    Entao o sistema emite o texto "Campo obrigat�rio"	  
    
  @FE004_ValidacaoCamposObrigatorios
  Cenario: CE004 - Login - Campo obrigat�rios 
		Dado que o usuario nao preencha nenhum dos campos
		E acione o botao Entre
		E posicionar o mouse sobre o campo senha
    Entao o sistema emite o texto "Campo obrigat�rio"	  
		E posicionar o mouse sobre o campo usuario
    Entao o sistema emite o texto "Campo obrigat�rio"	    
 
  @FE005_ValidacaoLogin
  Cenario: CE005 - Login
		Dado que o usuario preenha o campo usuario com um usuario previamente cadastrado
		E preencher o campo senha com o valor "inmrobo123"		
		E acione o botao Entre
    Entao o sistema emite o texto "NOME"	            