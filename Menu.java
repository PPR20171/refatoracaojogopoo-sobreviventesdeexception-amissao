import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    protected int escolha = 0;
    protected GreenfootImage cenariomenu;
    protected GreenfootSound sommenu = new GreenfootSound("Lux Aeterna - Requiem for a dream.mp3");
    public Menu()
    {    
        super(800, 841, 1); 

        sommenu.playLoop();
        sommenu.stop();
        Greenfoot.start();      
    }

    public void act(){
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (Greenfoot.mouseClicked(null)) {
            int x = mouse.getX();
            int y = mouse.getY();
            if (Greenfoot.mouseClicked(null)) {
                if (x > 230 && x < 564) {
                    if (y > 420 && y < 505) {
                        submenu submen = new submenu();
                        submen.backg(escolha);
                        Greenfoot.setWorld(submen);
                        Greenfoot.delay(30);  
                        if(sommenu.isPlaying()){
                            sommenu.stop();
                        }
                    }}

                if (x > 230 && x < 564) {
                    if (y > 539 && y < 618) {
                        mododejogar modo = new mododejogar();
                        modo.backg(escolha);
                        Greenfoot.setWorld(modo);
                        Greenfoot.delay(30);   
                        if(sommenu.isPlaying()){
                            sommenu.stop();
                        }
                    }}

                if (x > 230 && x < 564) {
                    if (y > 667 && y < 755) {
                        Greenfoot.stop();
                        }
                    }
            }}
    }

    public void backg(int teste){
        this.escolha = teste;
        if(this.escolha == 1){
            cenariomenu = new GreenfootImage("menu.png");
        }
        if(this.escolha == 2){
            cenariomenu = new GreenfootImage("MENUENG.png");
        }
        setBackground(cenariomenu);
    }
}

