
package modelo;

public class Hotel {
    private String nome;
    private int qtdEstrelas;
    private double precoSemanaRegular;
    private double precoSemanaVip;
    private double precoFdsRegular;
    private double precoFdsVip;

    public Hotel(String nome, int qtdEstrelas, double precoSemanaRegular, double precoSemanaVip,
                 double precoFdsRegular, double precoFdsVip) {
        this.nome = nome;
        this.qtdEstrelas = qtdEstrelas;
        this.precoSemanaRegular = precoSemanaRegular;
        this.precoSemanaVip = precoSemanaVip;
        this.precoFdsRegular = precoFdsRegular;
        this.precoFdsVip = precoFdsVip;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdEstrelas() {
        return qtdEstrelas;
    }

    public double getPrecoSemanaRegular() {
        return precoSemanaRegular;
    }

    public double getPrecoSemanaVip() {
        return precoSemanaVip;
    }

    public double getPrecoFdsRegular() {
        return precoFdsRegular;
    }

    public double getPrecoFdsVip() {
        return precoFdsVip;
    }
}
