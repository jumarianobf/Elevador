
public class Elevador {
	double pesoMaximo;
	int quantidadeMaximaPassageiros;
	int andarAtual;
	boolean subindo = true;
	int quantidadePassageirosAtual;
	double pesoAtual;
	boolean[] andares;
	
	Elevador(
			double pesoMaximo, 
			int quantidadeMaximaPassageiros, 
			int quantidadeAndares) {
		
		this.pesoMaximo = pesoMaximo;
		this.quantidadeMaximaPassageiros = quantidadeMaximaPassageiros;
		this.andares = new boolean[quantidadeAndares];
	}
	
	boolean marcarAndar(int andar) {
		if (andar >= 0 
		 && andar < this.andares.length 
		 && andar != this.andarAtual) {
			this.andares[andar] = true;
			return true;
		}
		
		return false;
	}
	
	boolean embarcarPassageiro(Passageiro passageiro) {
		
		if (this.quantidadePassageirosAtual == this.quantidadeMaximaPassageiros
		 || this.pesoAtual + passageiro.peso > this.pesoMaximo) {
			return false;
		}
		
		this.quantidadePassageirosAtual++;
		this.pesoAtual += passageiro.peso;
		return true;
	}
	
	void desembarcarPassageiro(Passageiro novoPassageiro) {
		this.quantidadePassageirosAtual--;
		this.pesoAtual -= novoPassageiro.peso;
	}
	
	boolean andar() {
		
		boolean aoMenosUmAndarMarcado = false;
		
		for (boolean marcado: this.andares) {
			if (marcado) {
				aoMenosUmAndarMarcado = true;
				break;
			}
		}
		
		if (!aoMenosUmAndarMarcado) {
			return false;
		}
		
		int proximoAndarAcima = -1;
		int proximoAndarAbaixo = -1;
		
		for (int i = 0; i < this.andares.length; i++) {
			
			if(this.andares[i]) {
				
				if (i > this.andarAtual && proximoAndarAcima == -1) {
					proximoAndarAcima = i;
				} else if (proximoAndarAbaixo == -1) {
					proximoAndarAbaixo = i;
				}
			}
		}
		
		if (this.subindo && proximoAndarAcima != -1) {
			this.andarAtual = proximoAndarAcima;
		} else if (this.subindo && proximoAndarAbaixo != -1) {
			this.subindo = false;
			this.andarAtual = proximoAndarAbaixo;
		} else if (!this.subindo && proximoAndarAbaixo != -1) {
			this.andarAtual = proximoAndarAbaixo;
		} else if (!this.subindo && proximoAndarAcima != -1) {
			this.subindo = true;
			this.andarAtual = proximoAndarAcima;
		}
		
		this.andares[this.andarAtual] = false;
		
		if (this.andarAtual == 0) {
			this.subindo = true;
		} else if (this.andarAtual == this.andares.length - 1) {
			this.subindo = false;
		}
		
		return true;
	}
	
	
}
