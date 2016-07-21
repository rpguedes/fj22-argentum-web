package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestaCandleFactoryParaZeroNegociacoes {
        public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
        
       Negociacao petrobras = new Negociacao (30.0, 0, hoje);
       
       List<Negociacao> negociacoes = Arrays.asList(petrobras);
       
       CandleFactory fabrica = new CandleFactory();
       
       Candle candle = fabrica.constroiCandleParaData(hoje, negociacoes);
       
       System.out.println(candle.toString());
    }
}
