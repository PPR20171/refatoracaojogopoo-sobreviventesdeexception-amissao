import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class submenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class submenu extends Menu
{    
    private GreenfootImage cenariosubmenu;
    private int escolha = 0;

    public void submenu(){
    }
    public void act(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.mouseClicked(null)) {
            int x = mouse.getX();
            int y = mouse.getY();
            if (Greenfoot.mouseClicked(null)) {
                if (x > 415 && x < 564) {
                    if (y > 420 && y < 505) {
                        submenu submen = new submenu();
                        
                        Greenfoot.setWorld(submen);
                        Greenfoot.delay(30);      

                    }}

                if (x > 415 && x < 686) {
                    if (y > 564 && y < 676) {
                        Menu menu = new Menu();
                        Greenfoot.setWorld(menu);
                        menu.backg(escolha);
                        Greenfoot.delay(30);      

                    }}

                if (x > 164 && x < 686) {
                    if (y > 468 && y < 571) {
                        String  a;
                        do{
                            a = Greenfoot.ask("Digite um nome. Mínimo que 6 caracteres.");
                        }while(a.length() < 6);
                        Player player = new Player(a);
                        Tabuleiro tab = new Tabuleiro(player);
                        Greenfoot.setWorld(tab);
                        Greenfoot.delay(30); 

                        if(sommenu.isPlaying()){
                            sommenu.stop();
                        }
                    }}
            }}
    }

    public void backg(int teste){
        escolha = teste;
        if(escolha == 1){
            cenariosubmenu = new GreenfootImage("submenu.png");
        }
        if(escolha == 2){
            cenariosubmenu = new GreenfootImage("submenueng.png");
        }
        setBackground(cenariosubmenu);
    }
}
