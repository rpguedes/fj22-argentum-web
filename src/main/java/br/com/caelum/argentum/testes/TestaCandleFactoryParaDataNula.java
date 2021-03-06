package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestaCandleFactoryParaDataNula {
        public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
        
       Negociacao negociacao1 = new Negociacao (30.0, 100, null);
       
       List<Negociacao> negociacoes = Arrays.asList(negociacao1);
       
       CandleFactory fabrica = new CandleFactory();
       
       Candle candle = fabrica.constroiCandleParaData(hoje, negociacoes);
       
        System.out.println(candle.toString());
    }
}
