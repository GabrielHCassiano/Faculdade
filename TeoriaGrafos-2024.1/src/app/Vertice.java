package app;

import java.util.*;

public class Vertice {
    private String nome;
    private List<Vertice> adjacencias;
    private int grau = 0;

    public Vertice(String nome) {
        this.nome = nome;
        adjacencias = new ArrayList<>();
    }
    
    public Vertice(String[] nome) {
        this.nome = nome[0];
        adjacencias = new ArrayList<>();
    }

    public String getNome() {
    	return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public List<Vertice> getAdjacencias() {
    	return adjacencias;
    }
    
    public void setNome(List<Vertice> adjacencias) {
    	this.adjacencias = adjacencias;
    }
    
    public int getGrau() {
    	return grau;
    }
    
    public void setGrau(int grau) {
    	this.grau = grau;
    } 
    
    public String toString() {
        return "Vertice " + nome + " com grau " + grau;
    }
}
