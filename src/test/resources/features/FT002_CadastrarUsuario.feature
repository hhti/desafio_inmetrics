#language: pt
#encoding: iso-8859-1

@CadastroUsuario
Funcionalidade: Cadastro de usuario
	
  @FE001_CadastroUsuarioSenhasDiferentes
  Cenario: CE001 - Cadastro de usuario - Senhas diferentes
		Dado acesse que o usuario acesse menu cadastre-se
		E preencher o campo usuario com o valor "Jo�o Paulo Cardoso"
		E preencher o campo senha com o valor "inmrobo123"
		E preencher o campo confirmar senha com o valor "inmrobo123135"	
		Quando acionar o botao Cadastrar	
    Entao o sistema emite o texto "Senhas n�o combinam"				
    
  @FE002_CadastroUsuarioCamposObrigatorios
  Cenario: CE002 - Cadastro de usuario - Campos Obrigat�rios
		Dado acesse que o usuario acesse menu cadastre-se
    E que o usuario nao preencha nenhum dos campos
  	Quando acionar o botao Cadastrar
		E posicionar o mouse sobre o campo senha
    Entao o sistema emite o texto "Campo obrigat�rio"	  
		E posicionar o mouse sobre o campo usuario
    Entao o sistema emite o texto "Campo obrigat�rio"	  
		E posicionar o mouse sobre o campo confirmar senha
    Entao o sistema emite o texto "Campo obrigat�rio"	      		
  		
  @FE003_CadastroUsuarioQuantidadeMinimaDeCaracteres
  Cenario: CE003 - Cadastro de usuario - Quantidade M�nima de caracteres
		Dado acesse que o usuario acesse menu cadastre-se
		E preencher o campo usuario com o valor "Jp"
  	Quando acionar o botao Cadastrar		
    Entao o sistema emite o texto "Aumente este texto para 8 caracteres ou mais."		

  @FE004_UsuarioJaCadastrado
  Cenario: CE004 - Cadastro de usuario - Usuario j� cadastrado
		Dado acesse que o usuario acesse menu cadastre-se
		E preencher o campo usuario com o valor "Gandalf da Silva"
		E preencher o campo senha com o valor "inmrobo123"
		E preencher o campo confirmar senha com o valor "inmrobo123"	
		Quando acionar o botao Cadastrar	
    Entao o sistema emite o texto "Usu�rio j� cadastrado"		
    
  @FE005_CadastrarUsuario
  Cenario: CE005 - Cadastro de usuario
		Dado acesse que o usuario acesse menu cadastre-se
		E que o usuario preenha o campo usuario valido
		E preencher o campo senha com o valor "inmrobo123"
		E preencher o campo confirmar senha com o valor "inmrobo123"	
		Quando acionar o botao Cadastrar	
    Entao o sistema emite o texto "Login"		    
