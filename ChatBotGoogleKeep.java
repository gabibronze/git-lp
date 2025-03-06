package aula03fevereiro;
import java.util.Scanner;
import java.util.ArrayList;

public class ChatBotGoogleKeep {
    public static void main(String[] args) throws Exception {
        System.out.println("Bem vind# ao ChatBotBlocoDeNotas");
        Menu();
        BlocoDeNotas bloco1 = new BlocoDeNotas();
        Scanner sc = new Scanner(System.in);
        int escolha = sc.nextInt();

        do {
            switch (escolha) {
                case 1:
                    System.out.println("Insira a nova anotação: ");
                    String nota = sc.nextLine();
                    sc.nextLine();
                    Anotacao novaAnotacao = new Anotacao(nota);
                    bloco1.adicionarAnotacao(novaAnotacao);
                    break;
                case 2:
                    System.out.println("Busque por texto a anotação que você deseja editar: ");
                    sc.nextLine(); // Limpa o buffer
                    String textoBusca = sc.nextLine();

                    // Supondo que o método recuperarPorTexto retorne uma lista de anotações
                    ArrayList<Anotacao> anotacoesEncontradas = bloco1.recuperarPorTexto(textoBusca);

                    if (anotacoesEncontradas.isEmpty()) {
                        System.out.println("Nenhuma anotação encontrada com o texto fornecido.");
                    } else {
                        System.out.println("Anotações encontradas:");
                        for (int i = 0; i < anotacoesEncontradas.size(); i++) {
                            Anotacao anotacao = anotacoesEncontradas.get(i);
                            System.out.println("ID: " + anotacao.getID() + " - Nota: " + anotacao.getTexto());
                        }

                        System.out.println("Agora insira o ID da anotação que deseja modificar: ");
                        int ID = sc.nextInt();

                        // Verifica se o ID existe na lista de anotações encontradas
                        boolean anotacaoEncontrada = false;
                        for (int i = 0; i < anotacoesEncontradas.size(); i++) {
                            Anotacao anotacao = anotacoesEncontradas.get(i);
                            if (anotacao.getID() == ID) {
                                anotacaoEncontrada = true;
                                break;
                            }
                        }
                        if (anotacaoEncontrada) {
                            System.out.println("Agora insira o que deseja modificar: ");
                            sc.nextLine(); // Limpa o buffer
                            String notaEditada = sc.nextLine();
                            bloco1.editarAnotacao(ID, notaEditada);
                        } else {
                            System.out.println("ID não encontrado entre as anotações listadas.");
                        }
                    }
                    break;
                case 3:
                    System.out.println(bloco1.listar());
                    System.out.println("Insira o ID da anotação que deseja deletar: ");
                    int ID = sc.nextInt();
                    bloco1.deletarAnotacao(ID);
                    break;
                case 4:
                    System.out.println("Insira o texto para buscar a anotação a partir dele: ");
                    String texto = sc.nextLine();
                    bloco1.recuperarPorTexto(texto);
                    break;
                case 5:
                    System.out.println("Listando todas as anotações...");
                    ArrayList<Anotacao> anotacoes = bloco1.listar();

                    if (anotacoes.isEmpty()) {
                        System.out.println("Nenhuma anotação encontrada.");
                    } else {
                        for (Anotacao anotacao : anotacoes) {
                            System.out.println("ID: " + anotacao.getID() + " - Nota: " + anotacao.getTexto());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            Menu();
            escolha = sc.nextInt();
        } while (escolha != 6);
        sc.close();
    }

    private static void Menu() {
        System.out.println("""
                Digite o número correspondente ao que você deseja realizar:
                Digite [1] para: Adicionar uma nova anotação;
                Digite [2] para: Editar uma anotação existente;
                Digite [3] para: Deletar anotações;
                Digite [4] para: Buscar anotações a partir de um texto;
                Digite [5] para: Listar todas as anotações
                Digite [6] para: Sair do programa""");
    }
}
