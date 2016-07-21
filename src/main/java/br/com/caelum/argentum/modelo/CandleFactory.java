package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandleFactory {
    public Candle constroiCandleParaData(Calendar data, 
            List<Negociacao> negociacoes) {
        double maximo = 0;
        double minimo = Double.MAX_VALUE;
        double volume = 0;
        double abertura;
        double fechamento;
        
        for (Negociacao negociacao : negociacoes) {
            volume += negociacao.getVolume();
            
            double preco = negociacao.getPreco();
			if(preco > maximo) {
                maximo = preco;
            }
            if (preco < minimo){
                minimo = preco;
            }
        }
        
        if (negociacoes.isEmpty() == false) {
            abertura = negociacoes.get(0).getPreco();
            fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
        }
        else {
            abertura = 0.0;
            fechamento = 0.0;
            minimo = 0.0;
        }
                
        
        return new Candle(abertura, fechamento, minimo, maximo, volume, data);
    }

	public List<Candle> constroiCandles(List<Negociacao> todasNegociacoes) {
		List<Candle> candles = new ArrayList<Candle>();
		List<Negociacao> negociacaoesDoDia = new ArrayList<Negociacao>();
		Calendar dataAtual = todasNegociacoes.get(0).getData();
		for (Negociacao negociacao : todasNegociacoes) {
			if (negociacao.getData().before(dataAtual)){
				throw new IllegalStateException("negociacoes em ordem errada");
			}
			if (!negociacao.isMesmoDia(dataAtual)) {
				criaEGuardaCandle(candles, negociacaoesDoDia, dataAtual);
				negociacaoesDoDia = new ArrayList<Negociacao>();
				dataAtual = negociacao.getData();
			}
			negociacaoesDoDia.add(negociacao);
		}
		criaEGuardaCandle(candles, negociacaoesDoDia, dataAtual);
		
		return candles;
	}

	private void criaEGuardaCandle(List<Candle> candles, List<Negociacao> negociacaoesDoDia, Calendar dataAtual) {
		Candle candleDoDia = constroiCandleParaData(dataAtual, negociacaoesDoDia);
		candles.add(candleDoDia);
	}
		
	
}
