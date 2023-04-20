# Spring_POO_Project

<b>Code smells list:</b>
  <ul>
  <li> -Duplicated Code, Arquivos: alunoController, professorController, turmaController<br>
		-Funções de Excluir, alterar, Listar, Cadastro das entidades </li>
  <li>
	-Large Class<br>
	-HomeController.java com a função de undo e redo dentro dela está fazendo mais do que o seu papel;
  </li>
  <li> 
  	- Shotgun Surgery<br>
	-Sempre que mudamos algo das classes aluno, professor, turma temos que mudar nas classes repositores, e nas funções dos controllers dos mesmos</li>
  <li> 
  	- Primitive Obsession:
 	<br>
	As classes abaixo possuem um método para armazenar listas de notas de forma muito primitiva, tratando-as apenas como strings:
  	- Aluno.java:
		@Column(name = "Notas")
    		public ArrayList<String> notas = new ArrayList<String>();
		@Column(name = "Disciplinas_Pagas")
    		public ArrayList<String> Disciplinas_Pagas = new ArrayList<String>();
	<br>
	- Turma.java:
		@Column(name = "diaseHorarios")
    		private String diaseHorarios;<br>
  </li>
  <li> 
  	- Speculative Generality:<br>
	Modelo.java existem métodos com nomes pouco descritivos ao e que divergem do seu propósito exemplo: get e set Code, get e set List, get e set Bool, get e set AcademicalInfo
  </li>
  <li>
  - Dead Code:<br>
	Modelo.java existe o método ver_info() que não é mais usado<br>
	Boletim.java existe o método get_identificador() e setId() que não é usado
  </li>
  <li>
  - Data Class:<br>
	aluno,professor,turma modelo todas tem apenas getters e setters de atributos
  </li>
  </ul>
