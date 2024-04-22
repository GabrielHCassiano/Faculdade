package app;

public class Aresta {
    private String nome;
    private Vertice origem;
    private Vertice destino;
    
    private int peso;
    
    public Aresta(String nome, Vertice origem, Vertice destino) {
    	this.nome = nome;
    	this.origem = origem;
    	this.destino = destino;
    }
    
    public Aresta(String nome, Vertice origem, Vertice destino, int peso) {
    	this.nome = nome;
    	this.origem = origem;
    	this.destino = destino;
    	this.peso = peso;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public Vertice getOrigem() {
    	return origem;
    }
    
    public void setOrigem(Vertice origem) {
    	this.origem = origem;
    }
    
    public Vertice getDestino() {
    	return destino;
    }
    
    public void setDestino(Vertice destino) {
    	this.destino = destino;
    }
    
    public int getPeso() {
    	return peso;
    }
    
    public void setPeso(int peso) {
    	this.peso = peso;
    }
    
    public String toString() {
        return "Aresta " + (nome.isEmpty() ? ":" : nome + ": ") + "("+ origem.getNome()+ ", " + destino.getNome() + ")" + " Distancia : " + peso;
    }
}
