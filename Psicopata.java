import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Psicopata extends Carta
{
    private String nome;
    private GreenfootSound som = new GreenfootSound("Card - SOUND.mp3");

    public Psicopata(){
        setImage("psicopata.png");
        this.nome = "Psicopata";
    }   


    public boolean mouseclicado(){
        if(Greenfoot.mouseClicked(this)){
            return true;}
        return false;
    }

    public String getNome(){
        return this.nome;
    }

    public void efeito(Deck cemiterio,Player p, Player p2,  Carta c){
        if(p.getCartasdamao().contains(c)){
            p.getCartasdamao().remove(p.getCartasdamao().get(p.getCartasdamao().indexOf(c)));
        }
        cemiterio.devolverCarta(c);
        p2.RemoverRecurso(3);
    }

    public void cartavirada(){
        setImage("cartavirada.png");
    }

    public void cartadesv(){
        setImage("psicopata.png");
    }

     public void imagemdopoder(){
    setImage("Imagem3.png");
    }
    
    public boolean equals(Carta carta){
        return this.getNome().equals(carta.getNome());
    }
}
