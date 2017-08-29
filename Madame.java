import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Madame extends Carta
{
    private String nome;
    //private GreenfootSound som = new GreenfootSound("Card - SOUND.mp3");

    public Madame(){
        setImage("madame.png");
        this.nome = "Madame";

    }

    public boolean mouseclicado(){
        if(Greenfoot.mouseClicked(this)){
            return true;
        }
        return false;
    }

    public String getNome(){
        return this.nome;
    }

    public void efeito(Deck cemiterio, Player p, Carta c){
        p.AddCarta(cemiterio.pegarcartaespecif(c));
    }

    public void cartavirada(){
        setImage("cartavirada.png");
    }

    public void cartadesv(){
        setImage("madame.png");
    }

    public void imagemdopoder(){
        setImage("Imagem3.png");
    }

    public boolean equals(Carta carta){
        return this.getNome().equals(carta.getNome());
    }
}
