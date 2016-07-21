package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.modelo.CandleBuilder;
import br.com.caelum.argentum.modelo.Candle;
import java.util.GregorianCalendar;

public class TesteCandleBuilder {
    public static void main(String[] args) {
        CandleBuilder builder = new CandleBuilder();
        builder.comAbertura(40.5);
        builder.comFechamento(42.5);
        builder.comMinimo(39.8);
        builder.comMaximo(45.0);
        builder.comVolume(145234.20);
        builder.comData(new GregorianCalendar(2012, 8, 12, 0, 0, 0));
        
        Candle candle = builder.geraCandle();
        
        System.out.println(candle.toString());
        
        Candle newCandle = new CandleBuilder().comAbertura(30).comFechamento(40)
                .comMinimo(28).comMaximo(45).comVolume(1234958.30)
                .comData(new GregorianCalendar(2013, 6, 26, 0, 0, 0)).geraCandle();
        System.out.println(newCandle.toString());
      
    }

    
}
