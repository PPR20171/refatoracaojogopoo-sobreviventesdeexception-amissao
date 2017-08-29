import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
public class Player extends Actor
{
    private String nome;
    private List <Carta> cartasdamao = new ArrayList<>();;
    private int recurso;

    public Player(String nome) {
        this.nome = nome;
        recurso = 2;

    }

    public void act() 
    {
        // Add your action code here.
    }  

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void AddCarta(Carta carta){
        cartasdamao.add(carta);
    }

    public List<Carta> getCartasdamao() {
        return this.cartasdamao;
    }

    public void AddRecurso(int valor) {
        this.recurso += valor;
    }

    public void RemoverRecurso(int valor) {
        this.recurso -= valor;
    }

    public int getRecurso() {
        return this.recurso;
    }
   
  
    @Override
    public String toString() {
        return "Número de recursos: "+getRecurso()+"\nJogador: "+this.getNome();
    }

    public boolean equals(Player obj){

        return this.getNome().equals(obj.getNome());
    }

}
