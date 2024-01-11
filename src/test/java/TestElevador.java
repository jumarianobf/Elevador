import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestElevador {
	@Test
	public void testElevador() {
		//Cria o meu elevador. Aguenta 200kg, 4 passageiros e possui 4 andares: 0, 1, 2, 3
		Elevador elevador = new Elevador(200, 4, 4);
		
		//Ao ser criado, elevador deve ter quantidadePassageirosAtual = 0
		assertEquals(0, elevador.quantidadePassageirosAtual);
		//Ao ser criado, elevador deve ter pesoAtual = 0
		assertEquals(0, elevador.pesoAtual);
		//Ao ser criado, elevador deve ter andarAtual = 0
		assertEquals(0, elevador.andarAtual);
		//Ao ser criado, elevador deve ter subindo = true
		assertTrue(elevador.subindo);
		//Tentar marcar o andar 5, que não existe, deve retornar false
		assertFalse(elevador.marcarAndar(5)); 
		//Se eu tentar marcar o meu andar atual, deve retornar false
		assertFalse(elevador.marcarAndar(0));
		
		//Se o andar existe e não é meu andar atual, deve retornar true
		assertTrue(elevador.marcarAndar(2));
		
		Passageiro ana = new Passageiro(50);
		Passageiro daniel = new Passageiro(70);
		Passageiro aline = new Passageiro(50);
		Passageiro mariana = new Passageiro(20);
		Passageiro luiz = new Passageiro(50);




		//Ao ser criada, a passageira ana deve ter 50 quilos
		assertEquals(50, ana.peso);
		//Ao ser criada, o passageiro daniel deve ter 70 quilos
		assertEquals(70, daniel.peso);
		//Ao ser criada, a passageira aline deve ter 50 quilos
		assertEquals(50, aline.peso);
		//Ao ser criada, a passageira aline deve ter 20 quilos
		assertEquals(20, mariana.peso);
		//Ao ser criada, o passageiro luiz deve ter 20 quilos
		assertEquals(50, luiz.peso);
		

		//Deve ser capaz de embarcar o passageiro Daniel
		assertTrue(elevador.embarcarPassageiro(daniel));
		//Após o embarque, o elevador deve ter o peso de 70
		assertEquals(70, elevador.pesoAtual);
		//Após o embarque, o elevador deve ter 1 passageiro
		assertEquals(1, elevador.quantidadePassageirosAtual);
		
		//Deve ser capaz de embarcar a passageira ana
		assertTrue(elevador.embarcarPassageiro(ana));
		//Após o embarque, o elevador deve ter o peso de 120
		assertEquals(120, elevador.pesoAtual);
		//Após o embarque, o elevador deve ter 2 passageiros
		assertEquals(2, elevador.quantidadePassageirosAtual);
		
		//Deve ser capaz de embarcar a passageira aline
		assertTrue(elevador.embarcarPassageiro(aline));
		//Após o embarque, o elevador deve ter o peso de 170
		assertEquals(170, elevador.pesoAtual);
		//Após o embarque, o elevador deve ter 3 passageiros
		assertEquals(3, elevador.quantidadePassageirosAtual);
		
		//Deve ser capaz de embarcar a passageira mariana
		assertTrue(elevador.embarcarPassageiro(mariana));
		//Após o embarque, o elevador deve ter o peso de 190
		assertEquals(190, elevador.pesoAtual);
		//Após o embarque, o elevador deve ter 4 passageiros
		assertEquals(4, elevador.quantidadePassageirosAtual);
		
		
		//Não deve ser capaz de embarcar o passageiro luiz
		assertFalse(elevador.embarcarPassageiro(luiz));
		//o elevador deve manter o peso de 190
		assertEquals(190, elevador.pesoAtual);
		//Após o embarque, o elevador deve manter 4 passageiros
		assertEquals(4, elevador.quantidadePassageirosAtual);
		
		//Elevador deve subir até o segundo andar
		assertTrue(elevador.andar());
		assertEquals(2, elevador.andarAtual); 
		assertTrue(elevador.subindo);
		
		//Ao desembarcar, elevador deve atualizar peso e quantidade de pessoas
		elevador.desembarcarPassageiro(daniel);
		assertEquals(3, elevador.quantidadePassageirosAtual);
		assertEquals(120, elevador.pesoAtual);
		
		//Elevador não deve andar porque não há nenhum andar marcado
		assertFalse(elevador.andar());
		//Marcado para elevador ir para terceiro andar
		assertTrue(elevador.marcarAndar(3));
		//Marcado para elevador ir para primeiro andar
		assertTrue(elevador.marcarAndar(1));
		
		//Elevador deve andar pois existe andar marcado
		assertTrue(elevador.andar());
		//Como elevador estava subindo, ele vai primeiro completar a rota e ir para o terceiro andar
		assertEquals(3, elevador.andarAtual);
		assertTrue(elevador.andar());
		//Elevador vai para o próximo andar marcado 
		assertEquals(1, elevador.andarAtual);
		//Elevador agora está descendo
		assertFalse(elevador.subindo);
	}
}
