import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ricaço here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ricaço extends Carta
{
    private String nome;
  //  private GreenfootSound som = new GreenfootSound("Card - SOUND.mp3");

    public Ricaço(){
        setImage("ricaco.png");
        this.nome = "Ricaço";
    }   

   /* public void act(){
        som.play();
    }*/

    public boolean mouseclicado(){
        if(Greenfoot.mouseClicked(this)){
            return true;}
        return false;
    }

    public String getNome(){
        return this.nome;
    }

    public void efeito(int valor, Player p, Player p2){
        p.RemoverRecurso(valor);
        p2.AddRecurso(valor);
            }

    public void cartavirada(){
        setImage("cartavirada.png");
    }

    public void cartadesv(){
        setImage("ricaco.png");
    }

     public void imagemdopoder(){
    setImage("Imagem3.png");
    }
        
    public boolean equals(Carta carta){
        return this.getNome().equals(carta.getNome());
    }

}
