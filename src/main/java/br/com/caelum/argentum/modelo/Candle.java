package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Candle {
    
    //atributes
    private final double abertura;
    private final double fechamento;
    private final double minimo;
    private final double maximo;
    private final double volume;
    private final Calendar data;

    //constructor
    public Candle(double abertura, double fechamento, double minimo, 
                       double maximo, double volume, Calendar data) {
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volume;
        this.data = data;
        
        if (minimo > maximo) {
            throw new IllegalArgumentException("minimo nao pode ser maior que o maximo");
        }
        
        if (data == null) {
            throw new IllegalArgumentException("data nao pode ser null"); 
        }
        
        if (abertura < 0 || fechamento < 0 || minimo < 0 || maximo < 0 || volume < 0) {
        	throw new IllegalArgumentException("nao pode ter valor negativo");
        }
    }
    
    //getters
    public double getAbertura() {
        return abertura;
    }

    public double getFechamento() {
        return fechamento;
    }

    public double getMinimo() {
        return minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getVolume() {
        return volume;
    }

    public Calendar getData() {
        return data;
    }
    
    //methods
    public boolean isAlta() {
        return this.abertura <= this.fechamento;
    }
    
    public boolean isBaixa() {
        return this.abertura > this.fechamento;
    }
    
    @Override
    public String toString () {

        return "[Abertura " + this.abertura +
                ", Fechamento " + this.fechamento +
                ", Mínima " + this.minimo +
                ", Máxima " + this.maximo +
                ", Volume " + this.volume +
                ", Data " + this.data.get(Calendar.DATE) + "/" 
                + this.data.get(Calendar.MONTH)+ "/" 
                + this.data.get(Calendar.YEAR) + "]";
        
    }
    
}