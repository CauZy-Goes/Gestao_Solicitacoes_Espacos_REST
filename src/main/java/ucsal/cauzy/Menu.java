package ucsal.cauzy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.util.SystemPropertyUtils;

import ucsal.cauzy.domain.entity.Cargo;
import ucsal.cauzy.domain.entity.Equipamento;
import ucsal.cauzy.domain.entity.EspacoFisico;
import ucsal.cauzy.domain.entity.LogAcoes;
import ucsal.cauzy.domain.entity.Solicitacoes;
import ucsal.cauzy.domain.entity.TipoSala;
import ucsal.cauzy.domain.entity.Usuario;
import ucsal.cauzy.domain.service.CargoService;
import ucsal.cauzy.domain.service.EquipamentoService;
import ucsal.cauzy.domain.service.EspacoFisicoService;
import ucsal.cauzy.domain.service.LogAcoesService;
import ucsal.cauzy.domain.service.SolicitacoesService;
import ucsal.cauzy.domain.service.StatusService;
import ucsal.cauzy.domain.service.TipoSalaService;
import ucsal.cauzy.domain.service.UsuarioService;

public class Menu {
	
	private static Scanner scan = new Scanner(System.in);
	
	private static Usuario usuarioAtual ;
	
	private static UsuarioService usuarioService;
	private static CargoService cargoService;
	private static EspacoFisicoService espacoFisicoService;
	private static SolicitacoesService solicitacoesService;
	private static StatusService statusService;
	private static EquipamentoService equipamentoService;
	private static TipoSalaService tipoSalaService;
	private static LogAcoesService logAcoesService;
	

	public Menu(ApplicationContext context) {
		usuarioService = context.getBean(UsuarioService.class);
		cargoService = context.getBean(CargoService.class);
		espacoFisicoService = context.getBean(EspacoFisicoService.class);
		solicitacoesService = context.getBean(SolicitacoesService.class);
		statusService = context.getBean(StatusService.class);
		equipamentoService = context.getBean(EquipamentoService.class);
		tipoSalaService = context.getBean(TipoSalaService.class);
		logAcoesService = context.getBean(LogAcoesService.class);
	}


	public void startMenu() {
		try {
			System.out.println();
			System.out.println("1 - " + " login ");
			System.out.println("2 - " + " cadastro");
			System.out.print("selecione sua opção de entrada : ");
			int option = scan.nextInt();
			scan.nextLine();
			switch (option) {
			case 1:
				loginMenu();
				break;
			case 2:
				cadastroMenu();
				break;
			default:
				System.out.println("Invalid Option");
				return;
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
		
	}
	
	public void loginMenu() {
			
		try {
			System.out.println();
			System.out.println("\n--- Escolha um usuario : ---");
			
			usuarioService.findAll().forEach(System.out::println);
			
			int option = scan.nextInt();
			scan.nextLine();
			Optional<Usuario> optionalUsuario = usuarioService.findById(option);

			if (optionalUsuario.isPresent()) {
			    Usuario usuario = optionalUsuario.get();
			    usuarioAtual = usuario;
			    System.out.println("Seja bem vindo " + usuario.getNomeUsuario() + " !"); 
			    
			    addLogAcoes("O usuario " + usuario.getNomeUsuario() + " foi logado");
				
			    escolherMenu();
			} else {
			    System.out.println("Usuário não encontrado.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
	
	}
	
	public void cadastroMenu() {
			try {
				System.out.println();
				System.out.println("\n--- Crie seu usuario : ---");
				Usuario usuario = new Usuario();
				
				System.out.println("\n--- Qual seu nome : ---");
				String nome = scan.nextLine();
				usuario.setNomeUsuario(nome);
				
				System.out.println("\n--- Qual o seu email : ---");
				String email = scan.nextLine();
				usuario.setEmail(email);
				
				System.out.println("\n--- Qual o seu cargo : ---");
				cargoService.findAll().forEach(System.out::println);
				int cargo = scan.nextInt();
				scan.nextLine();
				
				Optional<Cargo> optionalCargo = cargoService.findById(cargo);

				if (optionalCargo.isPresent()) {
					usuario.setCargo(optionalCargo.get());
					usuarioService.save(usuario);
					usuarioAtual = usuario;
					System.out.println("o usuario " + usuario.getNomeUsuario() +" foi cadastrado com sucesso !");
					
					addLogAcoes("O usuario " + usuario.getNomeUsuario() + " foi criado");
					
					escolherMenu();
				} else {
				    System.out.println("Cargo não encontrado.");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
			}
		
	}
	
	public void escolherMenu() {
		int cargo = usuarioAtual.getCargo().getIdcargo();
		switch (cargo) {
		case 1:
			menuGestor();
			break;
		case 2:
			menuProfessor();
			break;
		default:
			System.out.println("Invalid Option");
			return;
		}
	}
	
	public void menuProfessor () {
		try {
			boolean sair = true;
			while(sair) {
				System.out.println();
				System.out.println("-- Bem vindo ao menu do professor -- ");
				System.out.println("1 - " + " criar solicitação de espaço ");
				System.out.println("2 - " + " visualizar suas solicitações ");
				System.out.println("3 - " + " Voltar para tela inicial");
				System.out.print("selecione a opção desejada : ");
				
				int option = scan.nextInt();
				scan.nextLine();
				
				switch (option) {
				case 1:
					criarSolicitacao();
					break;
				case 2:
					visualizarMinhasSolicitacoes();
					break;
				case 3:
					sair = false;
					break;
				default:
					System.out.println("Invalid Option");
					return;
				}
			}
			startMenu();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
	}
	
	public void criarSolicitacao() {
		try {
			System.out.println();
			System.out.println("\n--- Crie uma solicitacao : ---");
			Solicitacoes solicitacao = new Solicitacoes();
			
			solicitacao.setUsuarioSolicitante(usuarioAtual);
			
			System.out.println("\n--- Escolha o espaço fisico pelo id : ---");
			espacoFisicoService.findAll().forEach(System.out::println);
			int idEspacoFisico = scan.nextInt();
			scan.nextLine();
			solicitacao.setEspacoFisico(espacoFisicoService.findById(idEspacoFisico).get());
			
			System.out.println("\n--- Digite a data/hora de locação (formato: 'yyyy-MM-dd HH'): ---");
			String dataHoraLocacaoStr = scan.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
			LocalDateTime dataHoraLocacao = LocalDateTime.parse(dataHoraLocacaoStr, formatter);
			solicitacao.setDataHoraLocacao(dataHoraLocacao);
			
			solicitacao.setDataHoraSolicitacao(LocalDateTime.now());
			
			solicitacao.setStatus(statusService.findById(1).get());
			
			addLogAcoes("O professor criou um solicitação para o espaço de id : " + idEspacoFisico);
			
			solicitacoesService.save(solicitacao);
			
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
	}
	
	public void visualizarMinhasSolicitacoes() {
		System.out.println();
		List<Solicitacoes> minhasSolicitacoes = solicitacoesService.findAll();
		
		minhasSolicitacoes = minhasSolicitacoes.stream()
        .filter(solicitacao -> solicitacao.getUsuarioSolicitante().getIdusuario().equals(usuarioAtual.getIdusuario()))
        .collect(Collectors.toList());
		
		addLogAcoes("O professor " + usuarioAtual.getNomeUsuario() + " visualizou as solicitações dele");
		
		minhasSolicitacoes.forEach(System.out::println);
	}
	
	public void menuGestor() {
		try {
			try {
				boolean sair = true;
				while(sair) {
					System.out.println();
					System.out.println("-- Bem vindo ao menu do gestor -- ");
					System.out.println("1 - " + " Menu De Equipamentos ");
					System.out.println("2 - " + " Menu De Espaços Físicos ");
					System.out.println("3 - " + " Menu De Tipos De Sala");
					System.out.println("4 - " + " Menu De Solicitacoes");
					System.out.println("5 - " + " Voltar para a tela inicial");
					System.out.print("selecione a opção desejada : ");
					
					int option = scan.nextInt();
					scan.nextLine();
					
					switch (option) {
					case 1:
						menuEquipamentos();;
						break;
					case 2:
						menuEspacosFisicos();;
						break;
					case 3:
						menuTipoSala();;
						break;
					case 4:
						menuSolicitacoes();;
						break;
					case 5:
						sair = false;
						break;
					default:
						System.out.println("Invalid Option");
						return;
					}
				}
				startMenu();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
	}
	
	public void menuEquipamentos() {
			try {
				int idEquipamento;
				int idEspacoFisico;
				boolean sair = true;
				while(sair) {
					System.out.println();
					System.out.println("-- Bem vindo ao menu de equipamentos -- ");
					System.out.println("1 - " + " Adicinar equipamento novo ");
					System.out.println("2 - " + " Excluir equipamento");
					System.out.println("3 - " + " Remanejar equipamento para um outro espaço físico ");
					System.out.println("4 - " + " Voltar para a tela inicial");
					System.out.print("selecione a opção desejada : ");
					
					int option = scan.nextInt();
					scan.nextLine();
					
					switch (option) {
					case 1:
						System.out.println();
						System.out.println("Qual o nome do equipamento ?");
						String nomeEquipamento = scan.nextLine();
						Equipamento novoEquipamento = new Equipamento();
						novoEquipamento.setNomeEquipamento(nomeEquipamento);
						
						System.out.println("Qual sala o novo equipamento sera vinculado ? ");
						
						espacoFisicoService.findAll().forEach(System.out::println);
						idEspacoFisico = scan.nextInt();
						scan.nextLine();
						
						if(!espacoFisicoService.findById(idEspacoFisico).isPresent()) {
							System.out.println("Espaço fisico nao existe");
							break;
						}
						EspacoFisico espacoFisico = espacoFisicoService.findById(idEspacoFisico).get();
						
						novoEquipamento.setEspacoFisico(espacoFisico);
						
						addLogAcoes("o novo equipamento" + novoEquipamento.getNomeEquipamento() + " foi adicinado no"
								+ " espaco fisico : " + espacoFisico.getIdEspacoFisico());
						
						equipamentoService.save(novoEquipamento);
						break;
						
					case 2:
						System.out.println();
						System.out.println("Qual o id do equipamento que vc deseja excluir ? ");
						equipamentoService.findAll().forEach(System.out::println);
						idEquipamento = scan.nextInt();
						scan.nextLine();
						
						if(!equipamentoService.findById(idEquipamento).isPresent()) {
							System.out.println("Equipamento não encontrado");
							break;
						}
						
						addLogAcoes("O equipamento de id : "+ idEquipamento + " foi excluido");
						
						equipamentoService.delete(idEquipamento);
						
						break;
						
					case 3:
						System.out.println();
						System.out.println("Qual equipamente você deseja remanejar ? ");
						equipamentoService.findAll().forEach(System.out::println);
					    idEquipamento = scan.nextInt();
						scan.nextLine();
						
						if(!equipamentoService.findById(idEquipamento).isPresent()) {
							System.out.println("Equipamento não encontrado");
							break;
						}
						Equipamento equipamento = equipamentoService.findById(idEquipamento).get();
						
						System.out.println("Para qual espaço fisico voce deseja remanejar o equipamento ? ");
						espacoFisicoService.findAll().forEach(System.out::println);
						idEspacoFisico = scan.nextInt();
						scan.nextLine();
						
						if(!espacoFisicoService.findById(idEspacoFisico).isPresent()) {
							System.out.println("Espaço fisico nao existe");
							break;
						}
						EspacoFisico novoEspacoFisico = espacoFisicoService.findById(idEspacoFisico).get();
						
						equipamento.setEspacoFisico(novoEspacoFisico);
						
						addLogAcoes("O usuario " + usuarioAtual.getNomeUsuario() + "realocou o equipamento de id : " 
						+ equipamento.getIdequipamento() + "para o espaco fisico de id : " 
						+ novoEspacoFisico.getIdEspacoFisico());
						
						equipamentoService.save(equipamento);
						break;
						
					case 4:
						sair = false;
						break;
					default:
						System.out.println("Invalid Option");
						return;
					}
				}
				startMenu();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
			}
	}
	
	public void menuEspacosFisicos() {
		try {
			int idEspacoFisico;
			int idTipoDeSala;
			boolean sair = true;
			while(sair) {
				System.out.println();
				System.out.println("-- Bem vindo ao menu de espacos fisicos -- ");
				System.out.println("1 - " + " Adicinar um espaco fisico novo ");
				System.out.println("2 - " + " Excluir espaco fisico");
				System.out.println("3 - " + " Mudar o tipo de sala do espaco fisico");
				System.out.println("4 - " + " Voltar para a tela inicial");
				System.out.print("selecione a opção desejada : ");
				
				int option = scan.nextInt();
				scan.nextLine();
				switch (option) {
				case 1:
					System.out.println();
					System.out.println("Qual a metragem do espaco fisico ?");
					BigDecimal metragemEspaco = scan.nextBigDecimal();
					EspacoFisico novoEspaco = new EspacoFisico();
					novoEspaco.setMetragem(metragemEspaco);
					
					System.out.println("Qual o tipo de sala do novo espaco fisico ? ");
					
					tipoSalaService.findAll().forEach(System.out::println);
					idTipoDeSala = scan.nextInt();
					scan.nextLine();
					
					if(!tipoSalaService.findById(idTipoDeSala).isPresent()) {
						System.out.println("Esse tipo de sala nao existe");
						break;
					}
					TipoSala tipoSala = tipoSalaService.findById(idTipoDeSala).get();
					
					novoEspaco.setTipoSala(tipoSala);
					
					addLogAcoes("o novo espaço fisico id : " + novoEspaco.getIdEspacoFisico() + " foi adicionado no tipo + " + tipoSala.getNomeSala());
					
					espacoFisicoService.save(novoEspaco);
					break;
					
				case 2:
					System.out.println();
					System.out.println("Qual o id do espaco que vc deseja excluir ? ");
					espacoFisicoService.findAll().forEach(System.out::println);
					idEspacoFisico = scan.nextInt();
					scan.nextLine();
					
					if(!espacoFisicoService.findById(idEspacoFisico).isPresent()) {
						System.out.println("espaco fisico não encontrado");
						break;
					}
					
					addLogAcoes("O espaco fisico de id : "+ idEspacoFisico + " foi excluido");
					
					espacoFisicoService.delete(idEspacoFisico);
					
					break;
					
				case 3:
					System.out.println();
					System.out.println("Qual espaco fisico vc deseja modificar ?");
					idEspacoFisico = scan.nextInt();
					
					if(!espacoFisicoService.findById(idEspacoFisico).isPresent()) {
						System.out.println("O espaço fisico nao existe");
					}
					
					EspacoFisico espaco = espacoFisicoService.findById(idEspacoFisico).get();
					
					System.out.println("Para qual tipo de sala voce deseja realocar 0 espaco fisico ? ");
					
					tipoSalaService.findAll().forEach(System.out::println);
					idTipoDeSala = scan.nextInt();
					scan.nextLine();
					
					if(!tipoSalaService.findById(idTipoDeSala).isPresent()) {
						System.out.println("Esse tipo de sala nao existe");
						break;
					}
					TipoSala novoTipoSala = tipoSalaService.findById(idTipoDeSala).get();
					
					espaco.setTipoSala(novoTipoSala);
					
					addLogAcoes("O tipo da sala do espaco fisico id : " + espaco.getIdEspacoFisico() + " foi modificado para " + novoTipoSala.getNomeSala());
					
					espacoFisicoService.save(espaco);
					break;
				case 4:
					sair = false;
					break;
				default:
					System.out.println("Invalid Option");
					return;
				}
			}
			startMenu();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
	}
	
	public void menuTipoSala() {
		try {
			int idTipoSala;
			boolean sair = true;
			while(sair) {
				System.out.println();
				System.out.println("-- Bem vindo ao menu tipo de sala --");
				System.out.println("1 - " + " Criar Tipo De Sala ");
				System.out.println("2 - " + " Deletar Tipo De Sala ");
				System.out.println("3 - " + " Voltar para tela inicial");
				System.out.print("selecione a opção desejada : ");
				
				int option = scan.nextInt();
				scan.nextLine();
				
				switch (option) {
				case 1:
					System.out.println("Qual o nome da nova sala ? ");
					String novoNomeTipoSala = scan.nextLine();
					TipoSala novoTipoSala = new TipoSala();
					novoTipoSala.setNomeSala(novoNomeTipoSala);
					
					addLogAcoes("Um nova tipo de sala foi adicionada : " + novoTipoSala.getNomeSala());
					
					tipoSalaService.save(novoTipoSala);
					
					break;
				case 2:
					System.out.println("Qual o id do tipo de sala que vc deseja remover ? ");
					tipoSalaService.findAll().forEach(System.out::println);
					idTipoSala = scan.nextInt();
					scan.nextLine();
					
					if(!tipoSalaService.findById(idTipoSala).isPresent()) {
						System.out.println("Esse tipo de sala nao existe");
						break;
					}
					
					addLogAcoes("A sala de id : " + idTipoSala + " foi deletada" );
					
					tipoSalaService.delete(idTipoSala);
					
					break;
				case 3:
					sair = false;
					break;
				default:
					System.out.println("Invalid Option");
					return;
				}
			}
			startMenu();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
	}
	
	public void menuSolicitacoes() {
		try {
			int idSolicitacao;
			boolean sair = true;
			while(sair) {
				System.out.println();
				System.out.println("-- Bem vindo ao menu de solicitações --");
				System.out.println("1 - " + " Aceitar solicitações ");
				System.out.println("2 - " + " Rejeitar solicitações ");
				System.out.println("3 - " + " Voltar para tela inicial");
				System.out.print("selecione a opção desejada : ");
				
				List<Solicitacoes> solicitacoesPendentes = solicitacoesService.findAll().stream()
		        .filter(solicitacao -> solicitacao.getStatus().getIdstatus().equals(statusService.findById(1).get().getIdstatus()))
		        .collect(Collectors.toList());
				
				int option = scan.nextInt();
				scan.nextLine();
				
				switch (option) {
				case 1:
					System.out.println("Qual solicitação voce deseja aceitar ? ");
					solicitacoesPendentes.forEach(System.out::println);
					idSolicitacao = scan.nextInt();
					scan.nextLine();
					
					if(!solicitacoesService.findById(idSolicitacao).isPresent()) {
						System.out.println("Essa solicitação nao existe");
						break;
					}
					
					Solicitacoes solicitacoeAceita = solicitacoesService.findById(idSolicitacao).get();
					solicitacoeAceita.setDataHoraAprovacao(LocalDateTime.now());
					solicitacoeAceita.setUsuarioAvaliador(usuarioAtual);
					solicitacoeAceita.setStatus(statusService.findById(2).get());
					
					addLogAcoes("A solicitacao : " + idSolicitacao + "foi aprovada pelo " + usuarioAtual.getNomeUsuario());
					
					solicitacoesService.save(solicitacoeAceita);
					
					break;
				case 2:
					System.out.println("Qual solicitação voce deseja rejeitar ? ");
					solicitacoesPendentes.forEach(System.out::println);
					idSolicitacao = scan.nextInt();
					scan.nextLine();
					
					if(!solicitacoesService.findById(idSolicitacao).isPresent()) {
						System.out.println("Essa solicitação nao existe");
						break;
					}
					
					Solicitacoes solicitacoeRejeitada = solicitacoesService.findById(idSolicitacao).get();
					solicitacoeRejeitada.setDataHoraAprovacao(LocalDateTime.now());
					solicitacoeRejeitada.setUsuarioAvaliador(usuarioAtual);
					solicitacoeRejeitada.setStatus(statusService.findById(3).get());
					
					addLogAcoes("A solicitacao : " + idSolicitacao + "foi rejeitada pelo " + usuarioAtual.getNomeUsuario());
					
					solicitacoesService.save(solicitacoeRejeitada);
				case 3:
					sair = false;
					break;
				default:
					System.out.println("Invalid Option");
					return;
				}
			}
			startMenu();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
	}
	
	public void addLogAcoes(String acao) {
		LogAcoes logAcoes = new LogAcoes();
		logAcoes.setUsuario(usuarioAtual);
		logAcoes.setAcao(acao);
		logAcoes.setDataHora(LocalDateTime.now());
		logAcoesService.save(logAcoes);
	}

}
