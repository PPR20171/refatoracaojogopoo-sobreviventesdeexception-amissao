import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Carta extends Actor
{
    protected String nome;

    public abstract boolean mouseclicado();

    public abstract String getNome();

    public abstract void cartavirada();

    public abstract void cartadesv();

    public abstract void imagemdopoder();

    public abstract boolean equals(Carta carta);

}
