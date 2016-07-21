package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {
    private double abertura = -1.0;
    private double fechamento = -1.0;
    private double minimo = -1.0;
    private double maximo = -1.0;
    private double volume = -1.0;
    private Calendar data = null;
    
    public CandleBuilder comAbertura (double abertura) {
        this.abertura = abertura;
        return this;
    }
    public CandleBuilder comFechamento (double fechamento) {
        this.fechamento = fechamento;
        return this;
    }
    public CandleBuilder comMinimo (double minimo) {
        this.minimo = minimo;
        return this;
    }
    public CandleBuilder comMaximo (double maximo) {
        this.maximo = maximo;
        return this;
    }
    public CandleBuilder comVolume (double volume) {
        this.volume = volume;
        return this;
    }
    public CandleBuilder comData (Calendar data) {
        this.data = data;
        return this;
    }
    
    public Candle geraCandle () {
        if (this.abertura < 0 || this.fechamento < 0 || this.minimo < 0 
                || this.maximo < 0 || this.volume < 0 || this.data == null) {
            throw new IllegalStateException("O candlestick deve ter todos os dados gerados");
        }
        else {
        return new Candle (abertura, fechamento, minimo, maximo, volume, data); 
        }
    }
            
}
