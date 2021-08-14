import java.util.Scanner;

public class programa {
	static Paciente[] pacientes = new Paciente[15];
	static User[] users = new User[15];
	static Anamnese[] anamneses = new Anamnese[20];
	static int posicao = 0;
	static int posicaoanamnse = 0;

	static Scanner ler = new Scanner(System.in);
	public static void main(String[] args) {
		 inicializar();
		 int p = 0;
		 
		 while (p != 2) {
			
		 System.out.println("-----------------------------MENU----------------------------------");
		 System.out.println("1 - LOGIN");
		 System.out.println("2 - SAIR");
		 System.out.println("-------------------------------------------------------------------");
		 
		 p = ler.nextInt();
		 
		 if(p == 1) {
			 System.out.println("DIGITE O NOME");
			 String nome = ler.next();
			 System.out.println("DIGITE A SENHA");
			 String senha = ler.next();
			 
			 
			 
			 if (validarlogin(nome,senha) == 1) {
				 System.out.println("Logado com sucesso");
				 int i = 0;
				 while (i != 6) {
					 System.out.println("------------------------MENU ATENDENTE-----------------------------");
					 System.out.println("1 - INSERIR PACIENTE");
					 System.out.println("2 - ALTERAR PACIENTE");
					 System.out.println("3 - EXCLUIR PACIENTE");
					 System.out.println("4 - LISTAR PACIENTES");
					 System.out.println("5 - BUSCAR PACIENTE");
					 System.out.println("6 - SAIR");
					 System.out.println("-------------------------------------------------------------------");
					 
					 i = ler.nextInt();
					 
					 if (i == 1) {
						 cadastrarPaciente();
						 System.out.println("PACIENTE INCERIDO COM SUCESSO");
					 }
					 if (i == 2) {
						 alterarPaciente();
					 }
					 if (i == 3) {
						 removerPaciente();
					 }
					 if (i == 4) {
						 listarPacientes();
					 }
					 if (i == 5) {
						 buscarPaciente();
					 }
					 if (i == 6) {
						 System.out.println("SAINDO...");
					 }
					 if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6) {
						 System.out.println("OPCAO INVALIDA");
					 }
					 
				 }
			 }
			 
			 if(validarlogin(nome,senha) == 2) {
				 System.out.println("Logado com sucesso");
				 int i = 0;
				 while (i != 5) {
					 System.out.println("------------------------MENU MEDICO-----------------------------");
					 System.out.println("1 - INSERIR ANAMNESE");
					 System.out.println("2 - ALTERAR ANAMNESE");
					 System.out.println("3 - LISTAR ANAMNESE");
					 System.out.println("4 - BUSCAR ANAMNESE");
					 System.out.println("5 - SAIR");
					 System.out.println("----------------------------------------------------------------");
					 
					 i = ler.nextInt();
					 
					 if (i == 1) {
						 inseriranamnese();
					 }
					 if (i == 2) {
						alteraranamnese();
					 }
					 if (i == 3) {
						 listaranamnese();
					 }
					 if (i == 4) {
						 buscaranamnese();
					 }

					 if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
						 System.out.println("OPCAO INVALIDA");
					 }
					 
					 if (i == 5) {
						 System.out.println("SAINDO...");
					 }
					 
				 }
				 
			 }
			 if (validarlogin(nome,senha) == 0) {
				 System.out.println("Login invalido, incira novamente");
			 }
			 
		 }
		 
		 if (p == 2) {
			 System.out.println("SAINDO");
		 }
		 
		 if (p != 1 && p != 2) {
			 System.out.println("OPCAO INVALIDA");
		 }
		 
		}
	}   
	
	public static int validarlogin(String nome, String senha) {
		 int validador = 0; 
		 for (int i = 0; i < users.length; i++) {
			 if(users[i] != null && users[i].nome.equals(nome) && users[i].senha.equals(senha)) {
				 validador = users[i].tipo;
			 }
		 }
		 return validador;//0 se nao for nenhum do dois, 1 se for medico e 2 se for user
		
	}
	
	public static boolean cadastrarPaciente() {
		
		Paciente paciente = new Paciente();
		
		System.out.println("INSIRA O NOME");
		String nome = ler.next();
		while (nome == "") {
			System.out.println("INSIRA O NOME NOVAMENTE NOVAMENTE");
			nome = ler.next();
		}
		
		paciente.nome = nome;
		int cont = 0;
		
		while (cont == 0) {		
			int cont2 = 0;
			System.out.println("INSIRA O CNS");
			int cns = ler.nextInt();
			while (cns == 0) {
				System.out.println("INSIRA O CNS NOVAMENTE NOVAMENTE");
				cns = ler.nextInt();
			}
			
			for(int i = 0; i < pacientes.length; i++) {
				if(pacientes[i] != null && pacientes[i].cns == cns) {
					cont2++;
				}
			}
			
			if(cont2 == 0) {
				cont = 1;
			}else {
				System.out.println("INVALIDO! JA EXITE PACIENTE COM ESSE CNS");
			}
			
			paciente.cns = cns;
		}
		
		System.out.println("INSIRA A DATE DE NASCIMENTO");
		String data = ler.next();
		while (data == "") {
			System.out.println("INSIRA A DATA DE NASCIMENTO NOVAMENTE");
			data = ler.next();
		}
		
		paciente.dataNascimento = data;
		
		System.out.println("INSIRA O SEXO 1 PARA MASCULINO E 2 PARA FEMININO");
		int sexo = ler.nextInt();
		while (sexo != 1 && sexo != 2) {
			System.out.println("INVALIDO!! INSIRA O SEXO NOVAMENTE");
			sexo = ler.nextInt();
		}
		
		paciente.sexo = sexo;
		
		System.out.println("INSIRA O NOME DA MAE");
		String nomemae = ler.next();
		while (nomemae == "") {
			System.out.println("INSIRA O NOME DA MAE NOVAMENTE");
			nomemae = ler.next();
		}
		
		paciente.nomeMae = nomemae;
		
		System.out.println("INSIRA OS SINTOMAS");
		String sintomas = ler.next();
		while (sintomas == "") {
			System.out.println("INSIRA OS SINTOMAS NOVAMENTE");
			sintomas = ler.next();
		}
		
		paciente.sintomas = sintomas;
		
		System.out.println("INSIRA O ENDERECO");
		String endereco = ler.next();
		while (endereco == "") {
			System.out.println("INSIRA O ENDERECO NOVAMENTE");
			endereco = ler.next();
		}
		
		paciente.endereco[4] = endereco;
		
		System.out.println("INSIRA O TELEFONE");
		int telefone = ler.nextInt();
		while (telefone <0) {
			System.out.println("INSIRA O TELEFONE NOVAMENTE ");
			telefone = ler.nextInt();
		}
		
		paciente.telefone = telefone;
		
		pacientes[posicao]=paciente;
		
		posicao++;
		
		return true;
	}
	
	public static void alterarPaciente() {
		int cont = 0;
		int id = 0;
		System.out.println("DIGITE O CNS DO PACIENTE QUE DESEJA ALTERAR");
		int cns = ler.nextInt();
		while(cns < 0) {
			System.out.println("INVALIDO!!! DIGITE O CNS DO PACIENTE NOVAMENTE");
			cns = ler.nextInt();
		}
		
		for (int i = 0; i < pacientes.length; i++) {
			if(pacientes[i] != null && pacientes[i].cns == cns) {	
				cont++;
				id = i;
			}
		}
		
		if(cont > 0) {
			int i = 0;
			while (i != 8) {
				System.out.println("--------------------------------MENU DE ALTERACAO-----------------------------------");
				System.out.println("1 - NOME");
				System.out.println("2 - DATA DE NASCIMENTO");
				System.out.println("3 - SEXO");
				System.out.println("4 - NOME DA MAE");
				System.out.println("5 - SINTOMAS");
				System.out.println("6 - ENDERECO");
				System.out.println("7 - TELEFONE");
				System.out.println("8 - SAIR");
				System.out.println("------------------------------------------------------------------------------------");
				
				i = ler.nextInt();
				 
				 if (i == 1) {
					 System.out.println("DIGITE O NOVO NOME");
						String nome = ler.next();
						while (nome == "") {
							System.out.println("INSIRA O NOME NOVAMENTE");
							nome = ler.next();
						}
					pacientes[id].nome = nome;
					System.out.println("ALTERADO COM SUCESSO");
				 }
				 if (i == 2) {
					 System.out.println("DIGITE A NOVA DATA DE NASCIMENTO");
						String dataNascimento = ler.next();
						while (dataNascimento == "") {
							System.out.println("INSIRA O NOME NOVAMENTE");
							dataNascimento = ler.next();
						}
					pacientes[id].dataNascimento = dataNascimento;
					System.out.println("ALTERADO COM SUCESSO");
					
				 }
				 if (i == 3) {
					 System.out.println("DIGITE O NOVO SEXO 1 MASCULINO 2 FEMININO");
						int sexo = ler.nextInt();
						while (sexo != 1 && sexo != 2) {
							System.out.println("INSIRA O SEXO NOVAMENTE");
							sexo = ler.nextInt();
						}
					pacientes[id].sexo = sexo;
					System.out.println("ALTERADO COM SUCESSO");
				 }
				 if (i == 4) {
					 System.out.println("DIGITE O NOVO NOME DA MAE");
						String nomeMae = ler.next();
						while (nomeMae == "") {
							System.out.println("INSIRA O NOME NOVAMENTE");
							nomeMae = ler.next();
						}
					pacientes[id].nomeMae = nomeMae;
					System.out.println("ALTERADO COM SUCESSO");
				 }
				 if (i == 5) {
					 System.out.println("DIGITE OS SINTOMAS");
						String sintomas = ler.next();
						while (sintomas == "") {
							System.out.println("INSIRA OS SINTOMAS");
							sintomas = ler.next();
						}
					pacientes[id].sintomas = sintomas;
					System.out.println("ALTERADO COM SUCESSO");
				 }
				 if (i == 6) {
					 System.out.println("DIGITE O NOVO ENDERECO");
						String endereco = ler.next();
						while (endereco == "") {
							System.out.println("INSIRA O NOVO ENDERECO");
							endereco = ler.next();
						}
				
					
					 
					 
					int verificador = 0;
					int verificador2 = 0;
					for (int a = 4; a >= 0  ; a--) {
						if (pacientes[id].endereco[a] == null && verificador == 0) { // verificador serve para preencher uma vez apenas
							pacientes[id].endereco[a] = endereco;
							verificador++; 
						}else {
							verificador2++; // conta quantas posicoes estao preechidas
						}
					}
					
					if(verificador2 == 5) { //isso indica que o vetor de enderecos esta cheio, sendo assim:
						pacientes[id].endereco[4] = pacientes[id].endereco[3];
						pacientes[id].endereco[3] = pacientes[id].endereco[2];
						pacientes[id].endereco[2] = pacientes[id].endereco[1];
						pacientes[id].endereco[1] = pacientes[id].endereco[0];
						pacientes[id].endereco[0] = endereco;
					}
					
					System.out.println("ADICIONADO COM SUCESSO");

				 }
				 if (i == 7) {
					 System.out.println("DIGITE O NOVO TELEFONE");
						int telefone = ler.nextInt();
						while (telefone < 0) {
							System.out.println("INSIRA O TELEFONE NOVAMENTE");
							telefone = ler.nextInt();
						}
					pacientes[id].telefone = telefone;
					System.out.println("ALTERADO COM SUCESSO");
				 }
				 if (i == 8) {
					 System.out.println("SAINDO...");
				 }
				 if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6 && i != 7 && i != 8) {
					 System.out.println("OPCAO INVALIDA");
				 }
				
				
			}
		}
		
		

	}
	
	public static void removerPaciente() {
		int cont = 0;
		int cont2 = 0;
		System.out.println("DIGITE O CNS DO PACIENTE QUE DESEJA EXCLUIR");
		int cns = ler.nextInt();
		while(cns < 0) {
			System.out.println("INVALIDO!!! DIGITE O CNS DO PACIENTE NOVAMENTE");
			cns = ler.nextInt();
		}
		
		for (int i = 0; i < pacientes.length; i++) {
			for (int j = 0; j < anamneses.length; j++) {
				if(pacientes[i] != null && anamneses[j] != null && pacientes[i].cns == anamneses[j].cns) {
					cont2 = 1;
				}
			}
		}
		
		for (int i = 0; i < pacientes.length; i++) {
			if(pacientes[i] != null && pacientes[i].cns == cns && cont2 == 0) {		
				pacientes[i] = null;
				cont++;
				System.out.println("PACIENTE EXCLUIDO COM SUCESSO");
			}
		}
		
		if (cont == 0 || cont2 != 0 ) {
			System.out.println("PACIENTE COM ESSE CNS NAO ESTA CASDASTRADO NO SISTEMA OU POSSUI UMA ANAMNESE CADASTRADA");
		}
		
	}
	
	
	public static void listarPacientes() {
		int cont = 0;
		for (int i = 0; i < pacientes.length; i++) {
			if(pacientes[i] != null) {		
				System.out.println("--------------------------PACIENTE: " + i + "-----------------------------");
				System.out.println("NOME: " + pacientes[i].nome);
				System.out.println("CNS: " + pacientes[i].cns);
				System.out.println("NOME DA MAE: " + pacientes[i].nomeMae);
				System.out.println("TELEFONE: " + pacientes[i].telefone);
				cont++;
			}
		}
		
		if (cont == 0) {
			System.out.println("NAO EXITEM PACIENTES CADASTRADOS NO SISTEMA!!!");
		}
	}
	
	public static void buscarPaciente() {
		int cont = 0;
		System.out.println("DIGITE O CNS DO PACIENTE");
		int cns = ler.nextInt();
		while(cns < 0) {
			System.out.println("INVALIDO!!! DIGITE O CNS DO PACIENTE NOVAMENTE");
			cns = ler.nextInt();
		}
		
		for (int i = 0; i < pacientes.length; i++) {
			if(pacientes[i] != null && pacientes[i].cns == cns) {		
				System.out.println("--------------------------PACIENTE: " + i + "-----------------------------");
				System.out.println("NOME: " + pacientes[i].nome);
				System.out.println("CNS: " + pacientes[i].cns);
				System.out.println("NOME DA MAE: " + pacientes[i].nomeMae);
				System.out.println("TELEFONE: " + pacientes[i].telefone);
				cont++;
			}
		}
		
		if (cont == 0) {
			System.out.println("PACIENTE COM ESSE CNS NAO ESTA CASDASTRADO NO SISTEMA");
		}
	}
	
	public static void inseriranamnese() {
		
		Anamnese anamnese = new Anamnese();
		int verificador = 0;
		while (verificador == 0) {
			
			System.out.println("INSIRA O CNS DO PACIENTE");
			int cns = ler.nextInt();
			while (cns < 0) {
				System.out.println("INSIRA O CNS NOVAMENTE");
				cns = ler.nextInt();
			}
			
			int cont = 0;
			for (int i = 0; i < pacientes.length; i++) {
				if (pacientes[i] != null && pacientes[i].cns == cns) {
					cont++;	
				}
			}
			
			if (cont == 0) {
				System.out.println("NÃO EXITE PACIENTE COM ESSE CNS, DIGITE NOVAMENTE");
			}else {
				anamnese.cns = cns;
				verificador = 1;
			}
		}
		
		
		System.out.println("INSIRA O MOTIVO");
		String motivo = ler.next();
		while (motivo == "") {
			System.out.println("INSIRA O MOTIVO NOVAMENTE");
			motivo = ler.next();
		}
		
		anamnese.motivo = motivo;
		
		System.out.println("INSIRA O HISTORICO");
		String his = ler.next();
		while (his == "") {
			System.out.println("INSIRA O HISTORICO");
			his = ler.next();
		}
		
		anamnese.historico = his;
		
		System.out.println("INSIRA A QUEIXA");
		String queixa = ler.next();
		while (queixa == "") {
			System.out.println("INVALIDO!! A QUEIXA NOVAMENTE");
			queixa = ler.next();
		}
		
		anamnese.queixa = queixa;
		
		System.out.println("INSIRA OS MEDICAMENTOS");
		String medicamentos = ler.next();
		while (medicamentos == "") {
			System.out.println("INSIRA OS MEDICAMENTOS NOVAMENTE");
			medicamentos = ler.next();
		}
		
		anamnese.medicamentos = medicamentos;
		
		System.out.println("INSIRA O TRATAMENTO");
		String tratamentos = ler.next();
		while (tratamentos == "") {
			System.out.println("INSIRA O TRATAMENTO NOVAMENTE!");
			tratamentos = ler.next();
		}
		anamnese.tratamentos = tratamentos;
		
		System.out.println("DESEJA REGISTRAR ANALISE DO EXAME CLINICO? 1-SIM 2-NAO");
		int resposta = ler.nextInt();
		while (resposta != 1 && resposta != 2) {
			System.out.println("DIGITE A RESPOSTA NOVAMENTE!");
			resposta = ler.nextInt();
		}
		
		if(resposta == 1) {
			System.out.println("DIGITE O DIAGNOSTICO");
			String diag = ler.next();
			while (diag == "") {
				System.out.println("DIGITE A DIAGNOSTICO NOVAMENTE!");
				diag = ler.next();
			}
			anamnese.diagnostico = diag;
		}
		
		anamneses[posicaoanamnse] = anamnese;
		posicaoanamnse++;
		
	}
	
	public static void alteraranamnese() {
		int cont =0;
		for(int i = 0; i < anamneses.length; i++) {
			if(anamneses[i] != null) {
				cont++;
			}
		}
		
		listaranamnese();
		
		if (cont != 0) {				
			int id = 0;
			System.out.println("DIGITE O ID DA ANAMNESE QUE DESEJA ALTERAR");
			int pose = ler.nextInt();
			while(pose > (posicaoanamnse-1)) {
				System.out.println("INVALIDO!!! DIGITE O ID DA ANAMNESE NOVAMENTE");
				pose = ler.nextInt();
			}
			
			id = pose;
			
			int i = 0;
			while (i != 7) {
				System.out.println("--------------------------------MENU DE ALTERACAO-----------------------------------");
				System.out.println("1 - MOTIVO");
				System.out.println("2 - HISTORICO");
				System.out.println("3 - QUEIXA");
				System.out.println("4 - MEDICAMENTOS");
				System.out.println("5 - TRATAMENTOS");
				System.out.println("6 - DIAGNOSTICO");
				System.out.println("7 - SAIR");
				System.out.println("------------------------------------------------------------------------------------");
				
				i = ler.nextInt();
				 
				 if (i == 1) {
					System.out.println("DIGITE O MOTIVO");
						String motivo = ler.next();
						while (motivo == "") {
							System.out.println("DIGITE O MOTIVO NOVAMENTE");
							motivo = ler.next();
						}
					anamneses[id].motivo = motivo;
					System.out.println("ALTERADO COM SUCESSO");
					
				 }
				 if (i == 2) {
					 System.out.println("DIGITE O HISTORICO");
						String historico = ler.next();
						while (historico == "") {
							System.out.println("DIGITE O HISTORICO NOVAMENTE");
							historico = ler.next();
						}
					anamneses[id].historico = historico;
					System.out.println("ALTERADO COM SUCESSO");
				 }
				 if (i == 3) {
					 System.out.println("DIGITE A QUEIXA");
						String queixa = ler.next();
						while (queixa == "") {
							System.out.println("DIGITE A QUEIXA NOVAMENTE");
							queixa = ler.next();
						}
					anamneses[id].queixa = queixa;
					System.out.println("ALTERADO COM SUCESSO");
				 }
				 if (i == 4) {
					 System.out.println("DIGITE OS MEDICAMENTOS");
						String medicamentos = ler.next();
						while (medicamentos == "") {
							System.out.println("DIGITE OS MEDICAMENTOS NOVAMENTE");
							medicamentos = ler.next();
						}
					anamneses[id].medicamentos = medicamentos;
					System.out.println("ALTERADO COM SUCESSO");
				 }
				 if (i == 5) {
					 System.out.println("DIGITE OS TRATAMENTOS");
						String tratamentos = ler.next();
						while (tratamentos == "") {
							System.out.println("DIGITE OS TRATAMENTOS NOVAMENTE");
							tratamentos = ler.next();
						}
					anamneses[id].tratamentos = tratamentos;
					System.out.println("ALTERADO COM SUCESSO");
				 }
				 
				 if (i == 6) {
					 System.out.println("DIGITE O DIAGNOSTICO TRATAMENTOS");
						String diagnostico = ler.next();
						while (diagnostico == "") {
							System.out.println("DIGITE O DIAGNOSTICO NOVAMENTE");
							diagnostico = ler.next();
						}
					anamneses[id].diagnostico = diagnostico;
					System.out.println("ALTERADO COM SUCESSO");
				 }
				 if (i == 7) {
					 System.out.println("SAINDO...");
				 }
				 if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6 && i != 7) {
					 System.out.println("OPCAO INVALIDA");
				 }
			}
		}
			
	}
	
		
		

	
	
	public static void listaranamnese() {
		int cont = 0;
		for (int i = 0; i < anamneses.length; i++) {
			if(anamneses[i] != null) {		
				System.out.println("--------------------------ANAMNESES: " + i + "-----------------------------");
				System.out.println("NOME DO PACIENTE: " + buscarPacienteCns(anamneses[i].cns));
				System.out.println("NOME DA MAE: " + buscarPacienteMaeCns(anamneses[i].cns));
				System.out.println("HISTORICO: " + anamneses[i].historico);
				System.out.println("MOTIVO: " + anamneses[i].motivo);
				System.out.println("MEDICAMENTOS USADOS: " + anamneses[i].medicamentos);
				System.out.println("TRATAMENTOS FEITOS: " + anamneses[i].tratamentos);
				System.out.println("QUEIXA DO PACIENTE: " + anamneses[i].queixa);
				if(anamneses[i].diagnostico != null) {
					System.out.println("DIAGNOSTICO: " + anamneses[i].diagnostico);
				}
				cont++;
			}
		}
		
		if (cont == 0) {
			System.out.println("NAO EXITEM ANAMNESES CADASTRADAS NO SISTEMA!!!");
		}
		
	}
	
	public static String buscarPacienteCns(int cns) {
		String nome;
		for (int i = 0; i < pacientes.length; i++) {
			if (pacientes[i] != null && pacientes[i].cns == cns) {
				nome = pacientes[i].nome;
				return nome;
			}
		}
		return "ERRO";
	}
	
	public static String buscarPacienteMaeCns(int cns) {
		String nome;
		for (int i = 0; i < pacientes.length; i++) {
			if (pacientes[i] != null && pacientes[i].cns == cns) {
				nome = pacientes[i].nomeMae;
				return nome;
			}
		}
		return "ERRO";
	}
	
	
	public static void buscaranamnese() {
		
		System.out.println("DIGITE O NOME DO PACIENTE");
		String nome = ler.next();
		while(nome == "") {
			System.out.println("INVALIDO!!! DIGITE O NOME DO PACIENTE NOVAMENTE");
			nome = ler.next();
		}
		
		int pose = 0;
		
		Anamnese[] aux = new Anamnese[15];
		int auxposicao = 0;
		int verificador01 = 0;
		for (int i = 0; i < anamneses.length; i++) {
			if(anamneses[i] != null && buscarPacienteCns(anamneses[i].cns).equalsIgnoreCase(nome)) {
				aux[auxposicao] = anamneses[i];
				auxposicao++;
				verificador01++;
			}
		}
		
		if (verificador01 != 0 ) {
			for (int i = 0; i < aux.length; i++) {
				if(aux[i] != null) {		
					System.out.println("--------------------------ANAMNESES: " + i + "---------------------------------------");
					System.out.println("CNS DO PACIENTE:" + aux[i].cns + " NOME DO PACIENTE: "
					+ buscarPacienteCns(aux[i].cns) + " NOME DA MAE:" + buscarPacienteMaeCns(anamneses[i].cns));
				}
			} 
			
			int cont = 0;
			while(cont == 0) {
				System.out.println("DIGITE O CNS DO PACIENTE QUE DESEJA");
				int cns2 = ler.nextInt();
				while(cns2 < 0) {
					System.out.println("INVALIDO!!! DIGITE O CNS DO PACIENTE NOVAMENTE");
					cns2 = ler.nextInt();
				}
				
				
				for (int i = 0; i < aux.length; i++) {
					if(aux[i] != null && aux[i].cns == cns2) {		
						System.out.println("--------------------------ANAMNESES: " + i + "-----------------------------");
						System.out.println("NOME DO PACIENTE: " + buscarPacienteCns(aux[i].cns));
						System.out.println("HISTORICO: " + aux[i].historico);
						System.out.println("MOTIVO: " + aux[i].motivo);
						System.out.println("MEDICAMENTOS USADOS: " + aux[i].medicamentos);
						System.out.println("TRATAMENTOS FEITOS: " + aux[i].tratamentos);
						System.out.println("QUEIXA DO PACIENTE: " + aux[i].queixa);
						if(aux[i].diagnostico != null) {
							System.out.println("DIAGNOSTICO: " + aux[i].diagnostico);
						}
						cont++;
					}
				}
			}
		}else {
			System.out.println("ANAMNESE NAO ENCONTRADA");
		}
		
	}
	
	
	
	public static void inicializar() {
		User atendente = new User();
		atendente.nome = "1";
		atendente.senha = "1";
		atendente.tipo = 1;
		
	
		users[0] = atendente;

		User medico = new User();
		medico.nome = "2";
		medico.senha = "2";
		medico.tipo = 2;
		
		users[1] = medico;

		
		Paciente x = new Paciente();
		
		x.nome = "esther";
		x.cns = 14;
		x.dataNascimento = "14052001";
		x.endereco[4] = "rua tal";
		x.endereco[3] = "teste";
		x.endereco[2] = "tupinamba";
		x.endereco[1] = "vida";
		x.endereco[0] = "rural";
		x.sexo = 2;
		x.nomeMae = "Cleidi";
		x.telefone = 9847521;
		x.sintomas = "Febre";
		pacientes[posicao] = x;
		posicao++;
	}

}
