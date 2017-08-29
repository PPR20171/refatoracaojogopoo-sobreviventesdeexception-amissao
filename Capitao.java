import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Capitao extends Carta
{
    private String nome;
    private GreenfootSound som = new GreenfootSound("Card - SOUND.mp3");

    public Capitao(){
        setImage("capitao.png");
        this.nome = "Capitão";
    }    


    public boolean mouseclicado(){
        if(Greenfoot.mouseClicked(this)){
            return true;}
        return false;
    }

    public String getNome(){
        return this.nome;
    }

    public void efeito(Player p1, Player p2){
        p1.RemoverRecurso(2);
        p2.AddRecurso(2);
    }

    public void cartavirada(){
        setImage("cartavirada.png");
    }

    public void cartadesv(){
        setImage("capitao.png");
    }
    
    public void imagemdopoder(){
    setImage("Imagem3.png");
    }

    public boolean equals(Carta carta){
        return this.getNome().equals(carta.getNome());
    }

}
