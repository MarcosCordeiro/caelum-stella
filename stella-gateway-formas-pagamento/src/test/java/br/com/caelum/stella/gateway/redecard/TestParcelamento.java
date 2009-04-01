package br.com.caelum.stella.gateway.redecard;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.stella.gateway.core.InvalidCheckoutException;
import br.com.caelum.stella.gateway.redecard.FormaPagamento;
import br.com.caelum.stella.gateway.redecard.TipoTransacao;

public class TestParcelamento {

	@Test
	public void testParcelamentoComTipoDeTransacaoAVistaENumeroDeParcelasMaiorQue1(){
		try{
			new FormaPagamento(TipoTransacao.A_VISTA,2);
		}
		catch (InvalidCheckoutException e) {
			// TODO: handle exception
			Assert.assertEquals("Para transa��o a vista o n�mero de parcelas deve ser igual a 0",e.getMessage());
		}
	}
	
	@Test
	public void testParcelamentoComTipoDeTransacaoAPrazoENumeroDeParcelasMenorOuIgualA1(){
		try{
			new FormaPagamento(TipoTransacao.A_VISTA,1);
		}
		catch (InvalidCheckoutException e) {
			// TODO: handle exception
			Assert.assertEquals("Para transa��es com 1 parcela(s), use o tipo de transa��o a vista",e.getMessage());
		}
	}	
	
	@Test
	public void testFormatacaoDeNumeroDeParcelasAVista(){
		Assert.assertEquals("00",FormaPagamento.newPagamentoAVista().getNumeroDeParcelasComNoMinimoDoisDigitos());
	}
	

}