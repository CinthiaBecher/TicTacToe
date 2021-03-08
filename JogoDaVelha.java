
public class JogoDaVelha {
	
	private char[][] tabuleiro;
	
	public JogoDaVelha(int dimensoesTabuleiro) {
		
		this.tabuleiro = new char[dimensoesTabuleiro][dimensoesTabuleiro];
	}
	
	public boolean realizaJogada(int linha, int coluna, char caractere) {
		
		if (tabuleiro[linha][coluna] == 0)
			tabuleiro[linha][coluna] =  caractere;
		else
			return false;
		return true;
	}
	
	public boolean verificaGanhador() {
		int iguais = 0;
		//verifica diagonal principal
		for (int i = 0; i < tabuleiro.length; i++)
			if (tabuleiro[0][0] == tabuleiro[i][i] &&  tabuleiro[i][i] != 0)
				iguais++;
		if (iguais == tabuleiro.length) {
			System.out.println("Diagonal Principal");
			return true;
		}
		
		iguais = 0;
		//verifica diagonal secundária
		for (int i = 0; i < tabuleiro.length; i++) {
			int x = tabuleiro.length - 1;
			if (tabuleiro[tabuleiro.length - 1][0] == tabuleiro[i][x - i] &&  tabuleiro[i][x - i] != 0 )
				iguais++;
			
		}
		if (iguais == tabuleiro.length) {
			System.out.println("Diagonal secundária");
			return true;
		}
		
		//verifica linhas
		for (int i = 0; i < tabuleiro.length; i++) {
			iguais = 0;
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][tabuleiro.length-1] == tabuleiro[i][j] &&  tabuleiro[i][j] != 0)
					iguais++;
			}
			if (iguais == tabuleiro.length) {
				System.out.println("linhas");
				return true;
			}	
		}
		//verifica coluna
		for (int j = 0; j < tabuleiro[0].length; j++) {
			iguais = 0;
			for (int i = 0; i < tabuleiro.length; i++){
				if (tabuleiro[tabuleiro.length-1][j] == tabuleiro[i][j] &&  tabuleiro[i][j] != 0)
					iguais++;
			}
			if (iguais == tabuleiro.length) {
				System.out.println("linhas");
				return true;
			}	
		}
		
		return false;
	}
	
	public char[][] getTabuleiro() {
		return tabuleiro;
	}
	
	@Override
	public String toString() {
		String s = ""; 
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (j == (tabuleiro[i].length-1))
					s += (tabuleiro[i][j]);
				else
					s+= (tabuleiro[i][j] + " | ");
			}
			s += "\n";
		} 
		return s;
	}
	
}
