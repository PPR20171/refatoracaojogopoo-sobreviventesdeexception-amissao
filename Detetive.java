import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Detetive extends Carta
{
    private String nome;
  //  private GreenfootSound som = new GreenfootSound("Card - SOUND.mp3");
    
    public Detetive(){
        setImage("detetive.png");
        this.nome = "Detetive";
    }   

  /*  public void act(){
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

    public void efeito(Deck baralho, Player p, Carta c){
        baralho.devolverCarta(c);
        if(p.getCartasdamao().contains(c)){
            p.getCartasdamao().set(p.getCartasdamao().indexOf(c), baralho.pegarCarta());
        }
        //   p.AddCarta(baralho.pegarCarta());
            }

    public void cartavirada(){
        setImage("cartavirada.png");
    }

    public void cartadesv(){
        setImage("detetive.png");
    }
   
     public void imagemdopoder(){
    setImage("Imagem3.png");
    }
    
    public boolean equals(Carta carta){
        return this.getNome().equals(carta.getNome());
    }
}
