# Spring_POO_Project

<b>Code smells list:</b>
  <ul>
  <li> Duplicated Code, Arquivos: alunoController, professorController, turmaController<br>
		-Funções de Excluir, alterar, Listar, Cadastro das entidades </li>
  <li> Long Method, arquivos: alunoController, professorController, turmaController<br>
		-Metodos de "alterar" das entidades estão fazendo um processo idêntico ao da função de cadastro</li>
  <li> Função Ver_info() - Função abstrata vinda de Modelo e implementada em Aluno, Turma, Professor </li>
  <li> Atributos ID, NOME - Atributos privados herdados de Modelo para Aluno, Turma e Professor </li>
  <li> ArrayList Modelo no Arquivo Menu.java que recebe objetos do tipo Aluno,Professor,Turma (Polimorfismo)</li>
  </ul>


- Large Class
	//filipe
	-talvez a HomeController com a função de undo e redo dentro dela;
	//Emmanuel
	se esse for o caso, poderia ser feita uma função só para o undo e redo (desde que hajam métodos próprios, senão vira uma lazy class).
	//filipe
	acho que mais certo seria fazer uma classe só pra undo e redo não só uma função
- Divergent Change
- Shotgun Surgery
	//filipe
	-Não sei ao certo se é, porém sempre que mudamos algo das classes aluno, professor, turma temos que mudar nas classes repositores, e nas funções dos controllers
- Feature Envy
	//filipe
- Primitive Obsession:
	//Sarah
	Entrada das notas/disciplinas/dias/horas em formato de tipo confuso que pode gerar erros de input
	- Aluno.java:
		@Column(name = "Notas")
    		public ArrayList<String> notas = new ArrayList<String>();
		@Column(name = "Disciplinas_Pagas")
    		public ArrayList<String> Disciplinas_Pagas = new ArrayList<String>();
	- Turma.java: 
		@Column(name = "diaseHorarios")
    		private String diaseHorarios;

- Lazy Class
- Speculative Generality
- Message Chains

- Middle Man:
	//Sarah
	Métodos não usados, já que ao buscar o Id, o caminho apresentado aparenta usar o setId/getId de modelo.Modelo.setId().
	- Boletim.java*:
		public int getIdentificador() {
       	 	return id;
    	}

    	public void setId(int id) {
        	this.id = id;
   	}
	//Emmanuel 
	de certa forma também é uma lazy class, não?
	//Sarah
	acredito que não, porque ela ainda tem relevância do overriding na hora do polimorfismo
		
- Indecent Exposure
- Data Class
- Comments
