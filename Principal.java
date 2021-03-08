
public class Principal {

	public static void main(String[] args) {
		
		String nomeJogador1 = Teclado.leString("Jogador 1, digite seu nome: ");
		Jogador jogador1 = new Jogador(nomeJogador1);


		String nomeJogador2 = Teclado.leString("Jogador 2, digite seu nome: ");
		Jogador jogador2 = new Jogador(nomeJogador2);

		int opcao = 1;
		
		while (opcao == 1) {
		
			int dimensaoTabuleiro = Teclado.leInt("Qual a dimensão do tabuleiro?");
			JogoDaVelha jogoDaVelha = new JogoDaVelha(dimensaoTabuleiro);
		
			System.out.println("\nVisualização do Tabuleiro:");
			System.out.println(jogoDaVelha.toString());

			boolean fechou = false; 
			boolean empate = false;
			int jogada = 0; 		
			while (!fechou) { //enquanto não fechar algum ponto ou fechar no empate, ele continuará rodando
			
				//se a jogada for impar, o jogador 1 joga
				if (jogada % 2 == 0) {
					desenvolveJogo(nomeJogador1, 'X', jogoDaVelha);
					fechou = jogoDaVelha.verificaGanhador();
				}
				else { //se a jogada for par, o jogador 2 joga
					desenvolveJogo(nomeJogador2, 'O', jogoDaVelha);
					fechou = jogoDaVelha.verificaGanhador();
				}
				jogada++;
				if (jogada == dimensaoTabuleiro * dimensaoTabuleiro ) { // se o números de jogadas for igual ao tamanho do tabuleiro e não encontramos ganhador, temos um empate
					empate = true;
					fechou = true;
				}
				System.out.println(jogoDaVelha.toString());
				System.out.println("----------------------------------");
			}
		
			
			//Imprime quem ganhou
			System.out.println("*-*-*-*-*- FIM DE JOGO -*-*-*-*-*");
			if (empate)  // se deu empate, ele não precisa imprimir o vencedor
				System.out.println("VISH! Deu empate :p ");
			else {
				if (jogada % 2 == 1) {
					System.out.println("PARABENS!:D\n" + nomeJogador1 + ", ganhou o jogo!");
					jogador1.setPontos(jogador1.getPontos() +1);
				}
				else { 
					System.out.println("PARABENS!:D\n" + nomeJogador2 + ", ganhou o jogo!");
					jogador2.setPontos(jogador2.getPontos() +1);
					}
			}
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
	
			//Menu de opcoes que oferece, ao jogador, jogar novamente ou mostrar os pontos
			opcao = Teclado.leInt("Escolha uma opcão:\n1 - Desejo jogar novamente!\n2 - Desejo ver os pontos dos jogadores\n3 - Não desejo jogar novamente");
			
			if (opcao == 2) {
				System.out.println("\n*-------------------------*");
				System.out.println(jogador1.toString());
				System.out.println();
				System.out.println(jogador2.toString());
				System.out.println("*-------------------------*\n");
				opcao = Teclado.leInt("Escolha uma opcão:\n1 - Desejo jogar novamente!\n2 - Não desejo jogar novamente");
				if (opcao == 2)
					System.out.println("Obrigada por jogar :D ");
			}
			else if (opcao == 3)
				System.out.println("Obrigada por jogar :D ");
		}
		
	}
	
	
	//metodo para ler as jogadas e colocar no tabuleiro
	public static void desenvolveJogo(String nome, char caractere, JogoDaVelha jogoDaVelha) {
		System.out.println(nome + ", escolha sua a posição: ");
		int linha = Teclado.leInt("Linha: ");
		int coluna = Teclado.leInt("Coluna: ");
		boolean jogada = jogoDaVelha.realizaJogada(linha, coluna, caractere);
		while (!jogada) {
		
			System.out.println( "ATENÇÃO! " + nome + ", por favor, escolha uma posição que não está ocupada");
			linha = Teclado.leInt("Linha: ");
			coluna = Teclado.leInt("Coluna: ");
			jogada = jogoDaVelha.realizaJogada(linha, coluna, caractere);
		}
	}


}
