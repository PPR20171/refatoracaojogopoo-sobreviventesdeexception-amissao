import greenfoot.*; 
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro extends World
{
    private int recurso = 20;
    private Deck baralho = new Deck();
    private Deck cemiterio = new Deck();
    private List <Player>  mesadotabuleiro = new ArrayList<>();
    private Player jogador2, jogador3, jogador4, jogador5;

    private Player playeraux = new Player("testes"); //usando
    private  Carta cartaaux = null;  //usando
    private int auxselecionar = 0, auxturno = 0, aux = 0, auxturnodef = 0, auxataque = 6, posX = 0, posY = 0, auxIA = 0, auxIAdef = 0 ; //usando

    private gameover gov = new gameover();

    private Botaoafogar ba = new Botaoafogar();
    private Botaochantagem bc = new Botaochantagem();
    private BotaoEspionar be = new BotaoEspionar(); 
    private BotaoDisfarce bd = new BotaoDisfarce();
    private BloquearRecurso blockr = new BloquearRecurso();
    private BotaoBloqAfo blocka = new BotaoBloqAfo(); 
    private Botaopularvez bpv = new Botaopularvez(); 
    private BotãoNdef bnd = new BotãoNdef();

    public Tabuleiro(Player player){
        super(1000, 674, 1); 
        GreenfootImage cenario1 = new GreenfootImage("teladojogo.png");
        setBackground(cenario1);

        //Add baralho no tabuleiro e a qntd de cartas
        cemiterio.getDeck().clear();
        baralho.embaralhar();
        addObject(baralho, 908, 535);

        addObject(ba, 635, 530);
        addObject(bc, 635, 576);
        addObject(be, 756, 530);
        addObject(bd, 756, 484);
        addObject(blockr, 756, 576);
        addObject(blocka, 635, 484);
        addObject(bpv, 756, 619);
        addObject(bnd, 634, 619);
        //construindo jogadores fixos
        jogador2 = new Player("Julio");
        jogador3 = new Player("Kayo");
        jogador4 = new Player("Matheus");
        jogador5 = new Player("Scarlate");
        //e add no campo de batalha
        mesadotabuleiro.add(player);
        mesadotabuleiro.add(jogador2);
        mesadotabuleiro.add(jogador3);
        mesadotabuleiro.add(jogador4);
        mesadotabuleiro.add(jogador5);

        // for each para preencher as cartas de cada jogador
        //---Area para distribuir as cartas aos  jogadores e aos outros 4
        /// virar as cartas no tabuleiro
        for(Player p : mesadotabuleiro){

            p.AddCarta(baralho.pegarCarta());
            p.AddCarta(baralho.pegarCarta());
        }

    }

    public void act(){

        if(!mesadotabuleiro.get(auxturno).getNome().equals("Afogado")){
            showText("JOGADOR "+mesadotabuleiro.get(auxturno).getNome()+" É SUA VEZ" , 500, 30);

            if (Greenfoot.isKeyDown("escape")) {
                Telainicial tela = new Telainicial();
                Greenfoot.setWorld(tela);
                Greenfoot.delay(30);      
            }

            if(auxselecionar == 0 ){
                Desenharnatela();
                showText("SELECIONE UMA CARTA PARA O EFEITO" , 500, 60);
                Greenfoot.delay(100);
                if(auxturno != 0){
                    aiataque();
                }
                for(Player p : mesadotabuleiro){
                    if( !p.equals(mesadotabuleiro.get(auxturno)) && !p.getNome().equals("Afogado")){
                        if(p.getCartasdamao().get(0).mouseclicado()){
                            cartaaux = p.getCartasdamao().get(0);

                            playeraux = p;
                            auxselecionar = 1;
                        }
                    }

                    if(p.getCartasdamao().size() >= 2){
                        if( !p.equals(mesadotabuleiro.get(auxturno)) && !p.getNome().equals("Afogado")){
                            if(p.getCartasdamao().get(1).mouseclicado()){
                                cartaaux = p.getCartasdamao().get(1);
                                playeraux = p;
                                auxselecionar = 1;
                            }
                        }
                    }
                }
            }

            //===============AREA PARA VERIFICAR OS BOTOES DO JOGO -- A STRING AÇÃO VERIFICARA SE BATE COM O NOME DA CARTA=====================
            if(auxselecionar == 1 && auxataque == 6){
                showText("ESCOLHA UM BOTÃO", 500, 60);
                Greenfoot.delay(100);
                if(auxturno != 0){
                    aiataquebotao();
                }
                if(ba.mouseclicado() || auxIA == 2){
                    auxIA = 2;
                    if(mesadotabuleiro.get(auxturno).getRecurso() >= 3){

                        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
                            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Psicopata()) && aux == 0){
                                boolean b = false;
                                if(mesadotabuleiro.contains(playeraux)){
                                    if(mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)).getCartasdamao().size() > 1){
                                        removeObject(mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)).getCartasdamao().get(0));
                                        removeObject(mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)).getCartasdamao().get(1));
                                        Greenfoot.delay(80);
                                        b= true;                                    
                                    }

                                    if(mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)).getCartasdamao().get(0).equals(cartaaux) && b==false ){
                                        removeObject(mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)).getCartasdamao().get(0));
                                        Greenfoot.delay(80);
                                        b = true;
                                    }                                                              

                                }

                                auxataque = ba.efeitobot(mesadotabuleiro, cemiterio, auxturno, aux, playeraux, cartaaux);
                                Greenfoot.delay(80);
                                if(auxataque == 0){
                                    for(int j = 0; j < mesadotabuleiro.get(auxturno).getCartasdamao().size(); j++){
                                        if(mesadotabuleiro.get(auxturno).getCartasdamao().get(j).equals(new Psicopata()) && b == true){

                                            posX = mesadotabuleiro.get(auxturno).getCartasdamao().get(j).getX();
                                            posY = mesadotabuleiro.get(auxturno).getCartasdamao().get(j).getY();

                                            mesadotabuleiro.get(auxturno).getCartasdamao().get(j).cartadesv();
                                            mesadotabuleiro.get(auxturno).getCartasdamao().get(j).setLocation(470, 282);
                                            Greenfoot.delay(80);
                                            b = false;
                                        }
                                    }
                                }

                            }}if(auxataque == 6){
                            showText("VOCÊ NÃO POSSUI UM PSICOPATA", 500, 80);
                            Greenfoot.delay(100);
                            showText("", 500, 80);                    
                        } } else if (mesadotabuleiro.get(auxturno).getRecurso() < 3) {
                        showText("VOCÊ POSSUI MENOS DE 3 RECURSOS", 500, 80);
                        auxIA = 0;
                        Greenfoot.delay(100);
                        showText("", 500, 80);
                    }
                }

                if(bc.mouseclicado() || auxIA == 1){
                    auxIA = 2;
                    if( playeraux.getRecurso() >= 2){
                        boolean b = false;
                        auxataque = bc.efeitobot(mesadotabuleiro, auxturno, aux, playeraux);
                        if(auxataque == 0){
                            for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
                                if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Capitao()) && b == false){

                                    posX = mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getX();
                                    posY = mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getY();

                                    mesadotabuleiro.get(auxturno).getCartasdamao().get(i).cartadesv();
                                    mesadotabuleiro.get(auxturno).getCartasdamao().get(i).setLocation(470, 282);
                                    Greenfoot.delay(80);
                                    b = true;
                                }
                            }
                        }

                        if(auxataque == 6){
                            showText("VOCÊ NÃO POSSUI UM CAPITÃO", 500, 80);
                            Greenfoot.delay(100);
                            showText("", 500, 80);
                        }

                    } else {
                        showText("ESTE JOGADOR TEM MENOS DE DOIS RECURSOS ", 500, 80);
                        auxIA = 0; 
                        Greenfoot.delay(100);
                        showText("", 500, 80);
                        auxselecionar = 0;
                    }
                }

                if(be.mouseclicado() || auxIA == 3){
                    boolean b = false;
                    for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
                        if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Detetive())){

                            if(mesadotabuleiro.contains(playeraux)){
                                if(mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)).getCartasdamao().get(0).equals(cartaaux) && b==false ){
                                    removeObject(mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)).getCartasdamao().get(0));
                                    b = true;
                                }
                                if(mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)).getCartasdamao().get(1).equals(cartaaux) && b==false){
                                    removeObject(mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)).getCartasdamao().get(1));
                                    b = true;
                                }
                            }

                        }}
                    aux = be.efeitobot(mesadotabuleiro, auxturno, aux, baralho, playeraux, cartaaux);
                    Greenfoot.delay(80);
                    if(aux == 1){
                        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
                            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Detetive()) && b == true){

                                posX = mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getX();
                                posY = mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getY();

                                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).cartadesv();
                                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).setLocation(470, 282);
                                Greenfoot.delay(100);
                                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).setLocation(posX, posY);
                                b = false;
                            }
                        }
                    }

                    if(aux == 0){
                        showText("VOCÊ NÃO POSSUI UM POLICIAL", 500, 80);
                        Greenfoot.delay(100);
                        showText("", 500, 80);
                        auxselecionar = 0;
                    }
                }

                if(bd.mouseclicado() || auxIA == 4){

                    auxselecionar = 2;

                    boolean b = false;

                    if(mesadotabuleiro.get(auxturno).getCartasdamao().get(0).equals(new Detetive()) && b==false ){
                        removeObject(mesadotabuleiro.get(auxturno).getCartasdamao().get(0));
                        b = true;
                    }
                    if(mesadotabuleiro.get(auxturno).getCartasdamao().get(1).equals(new Detetive()) && b==false){
                        removeObject(mesadotabuleiro.get(auxturno).getCartasdamao().get(1));
                        b = true;
                    }

                    aux = bd.efeitobot(mesadotabuleiro, auxturno, aux,baralho, playeraux, cartaaux);
                    Greenfoot.delay(80);
                    if(aux == 1){
                        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
                            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Detetive()) && b == true){

                                posX = mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getX();
                                posY = mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getY();

                                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).cartadesv();
                                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).setLocation(470, 282);
                                Greenfoot.delay(100);
                                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).setLocation(posX, posY);
                                b = false;
                            }
                        }
                    }

                    if (aux == 0){
                        showText("VOCÊ NÃO POSSUI UM POLICIAL", 500, 80);
                        Greenfoot.delay(100);
                        showText("", 500, 80);
                        auxselecionar = 0;
                    }

                }
            }

            if(auxataque < mesadotabuleiro.size()){

                showText("DEFENDA "+mesadotabuleiro.get(auxataque).getNome(), 500, 60);
                Greenfoot.delay(100);
                if(auxataque != 0) {
                    aidefesa();
                }
                if(blocka.mouseclicado()  || auxIAdef == 1){
                    aux = blocka.efeitobot(cemiterio, mesadotabuleiro, aux, playeraux, cartaaux, auxataque);
                    Greenfoot.delay(80);
                    if(aux == 1){
                        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
                            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Psicopata())){
                                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).setLocation(posX, posY);
                                Greenfoot.delay(80);
                            }
                        }
                    }
                    if(aux == 0) {
                        showText("VOCÊ NÃO POSSUI UMA MADAME", 500, 80);
                        Greenfoot.delay(100);
                        showText("", 500, 80);
                    }

                }
                if(blockr.mouseclicado()  || auxIAdef == 2){
                    aux = blockr.efeitobot(mesadotabuleiro, playeraux, aux, auxataque, auxturno);
                    Greenfoot.delay(80);
                    if(aux == 1){
                        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
                            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Capitao())){
                                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).setLocation(posX, posY);
                                Greenfoot.delay(80);
                            }
                        }
                    }
                    if(aux == 0) {
                        showText("VOCÊ NÃO POSSUI UM RICAÇO", 500, 80);
                        Greenfoot.delay(100);
                        showText("", 500, 80);
                    }

                }

                if(bnd.mouseclicado() || auxIAdef == 3 && aux != 1){
                    auxataque++;
                    if(auxataque ==  mesadotabuleiro.size()){
                        aux = 1;
                        boolean verificar = false;
                        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
                            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Capitao()) && verificar == false ){
                                cemiterio.devolverCarta(mesadotabuleiro.get(auxturno).getCartasdamao().get(i));
                                Greenfoot.delay(80);
                                removeObject(mesadotabuleiro.get(auxturno).getCartasdamao().get(i));
                                Greenfoot.delay(80);
                                mesadotabuleiro.get(auxturno).getCartasdamao().remove(mesadotabuleiro.get(auxturno).getCartasdamao().get(i));
                                if(baralho.getDeck().size() > 0){
                                    mesadotabuleiro.get(auxturno).getCartasdamao().add(baralho.pegarCarta());     
                                }
                                Greenfoot.delay(80);
                                mesadotabuleiro.get(auxturno).getCartasdamao().get(1).setLocation(posX, posY);
                                Greenfoot.delay(80);
                                verificar = true;
                            }
                        }

                        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
                            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Psicopata()) && verificar == false){
                                cemiterio.devolverCarta(mesadotabuleiro.get(auxturno).getCartasdamao().get(i));
                                removeObject(mesadotabuleiro.get(auxturno).getCartasdamao().get(i));
                                mesadotabuleiro.get(auxturno).getCartasdamao().remove(mesadotabuleiro.get(auxturno).getCartasdamao().get(i));
                                if(baralho.getDeck().size() > 0){
                                    mesadotabuleiro.get(auxturno).getCartasdamao().add(baralho.pegarCarta());     
                                }
                                Greenfoot.delay(80);
                                mesadotabuleiro.get(auxturno).getCartasdamao().get(1).setLocation(posX, posY);
                                Greenfoot.delay(80);
                                verificar = true;
                            }
                        }
                    }
                    if(auxataque == 6){
                        auxataque = 0;}
                }                       

            }

            if(bpv.mouseclicado() /*&& auxturno == 0*/ ){
                aux = 1;                
            }

            if(aux == 1){
                auxataque = 6;
                auxselecionar = 0;
                cartaaux = null;
                playeraux = null;
                if(recurso > 0){
                    recurso--;
                    mesadotabuleiro.get(auxturno).AddRecurso(1);
                }

                for(int i = 0; i < mesadotabuleiro.size(); i++){
                    if(mesadotabuleiro.get(i).getCartasdamao().size() == 0){
                        showText("O JOGADOR "+mesadotabuleiro.get(i).getNome()+" MORREEEEEUU!!!", 500, 60);
                        mesadotabuleiro.get(i).setNome("Afogado");
                        Greenfoot.delay(50);
                    }
                }
                auxIA = 0;
                auxIAdef = 0;
                aux = 0;
                auxturno++;
                int cont = 0;
                for(Player p : mesadotabuleiro){
                    if(!p.getNome().equals("Afogado")){
                        playeraux = p;
                        cont++;
                    }
                }
                if(cont == 1){
                    addObject(gov, 450, 270);
                    Greenfoot.stop();
                }

            }

            if(auxturno == mesadotabuleiro.size()){
                auxturno = 0;
            }

            if(mesadotabuleiro.get(0).getNome().equals("Afogado")){
                addObject(gov, 450, 270);
                Greenfoot.stop();
            }

            if(recurso == 0 && baralho.getDeck().size() == 0){
                for(Player p : mesadotabuleiro){
                    if(!p.getNome().equals("Afogado")){
                        for(int i = 0; i < mesadotabuleiro.size(); i++){
                            if(p.getRecurso() > mesadotabuleiro.get(i).getRecurso()){
                                playeraux = p;
                            }
                        }
                    }
                }
                addObject(gov, 450, 270);
                showText("O VENCEDOR É O JOGADOR "+playeraux.toString(), 450, 300);
                Greenfoot.delay(100);
                Greenfoot.stop();
            }
        } else if(auxturno < 4){auxturno++;}
        else if(auxturno == 4){auxturno = 0;}
    }

    public void aiataque(){
        Random r = new Random();
        if(auxIA == 0){
            do{
                playeraux = mesadotabuleiro.get(r.nextInt(mesadotabuleiro.size()));
            }while(mesadotabuleiro.get(auxturno).equals(playeraux));

            cartaaux = playeraux.getCartasdamao().get(r.nextInt(1));
            auxselecionar = 1;

        }
    }

    public void aiataquebotao(){
        Random ra = new Random();
        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Psicopata()) && auxIA == 0){
                if(mesadotabuleiro.get(auxturno).getRecurso() >3){
                    auxIA = 2;
                }
            }
        }

        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Capitao()) && auxIA == 0 ){
                if(playeraux.getRecurso() > 1){
                    auxIA = 1;
                }
            }
        }

        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Detetive()) && auxIA == 0){
                auxIA = ra.nextInt(1);
                if(auxIA == 0){
                    auxIA = 3;
                }
                if(auxIA == 1){
                    auxIA = 4;
                }
            }
        }

        if(auxIA == 0){
            auxturno++;
        }

    }

    public void aidefesa(){
        Random ran = new Random();
        if(auxIA == 1 ){
            for(int i = 0; i < mesadotabuleiro.get(auxataque).getCartasdamao().size(); i++){
                if(mesadotabuleiro.get(auxataque).getCartasdamao().get(i).equals(new Madame())){
                    if(playeraux.equals(auxataque)){
                        auxIAdef = 1;
                    } else{
                        auxIAdef = ran.nextInt(1);
                    }
                }
            }
        }
        if(auxIA == 2){
            for(int i = 0; i < mesadotabuleiro.get(auxataque).getCartasdamao().size(); i++){
                if(mesadotabuleiro.get(auxataque).getCartasdamao().get(i).equals(new Ricaço())){
                    if(mesadotabuleiro.get(auxataque).equals(playeraux)){
                        auxIAdef = 2;
                    } else{
                        auxIAdef = ran.nextInt(2);
                    }
                }
            }
        }

        if(auxIAdef != 1 && auxIAdef != 2){
            auxIAdef = 3;
            showText("sffzvvvx", 500, 700);
        }

    }

    public void Desenharnatela(){
        for(Player p : mesadotabuleiro){
            if(!p.equals(mesadotabuleiro.get(0))){
                for(Carta card : p.getCartasdamao()){
                    card.cartavirada();                  
                }
            }
        }

        //------------------Area que adiciona as cartas no mundo nas suas respectivas posições
        //--------------------como tbm o nome do jogador e qntd de recursos
        addObject (mesadotabuleiro.get(0).getCartasdamao().get(0), 325, 547);
        if(mesadotabuleiro.get(0).getCartasdamao().size() >= 2){addObject (mesadotabuleiro.get(0).getCartasdamao().get(1), 490, 547);}
        showText (mesadotabuleiro.get(0).toString(), 140, 600);

        if(!mesadotabuleiro.get(1).getNome().equals("Afogado")) {
            addObject (mesadotabuleiro.get(1).getCartasdamao().get(0), 63, 98);
            if(mesadotabuleiro.get(1).getCartasdamao().size() >= 2){addObject (mesadotabuleiro.get(1).getCartasdamao().get(1), 167, 98);}
        }
        showText (mesadotabuleiro.get(1).toString(), 120, 200);

        if(!mesadotabuleiro.get(2).getNome().equals("Afogado")) {
            addObject (mesadotabuleiro.get(2).getCartasdamao().get(0), 63, 307);
            if(mesadotabuleiro.get(2).getCartasdamao().size() >=2){addObject (mesadotabuleiro.get(2).getCartasdamao().get(1), 167, 307);}
        }
        showText (mesadotabuleiro.get(2).toString(), 120, 410);

        if(!mesadotabuleiro.get(3).getNome().equals("Afogado")) {
            addObject (mesadotabuleiro.get(3).getCartasdamao().get(0), 824, 98);
            if(mesadotabuleiro.get(3).getCartasdamao().size() >=2){addObject (mesadotabuleiro.get(3).getCartasdamao().get(1), 929, 98);}
        }
        showText (mesadotabuleiro.get(3).toString(), 880, 200);

        if(!mesadotabuleiro.get(4).getNome().equals("Afogado")) {
            addObject (mesadotabuleiro.get(4).getCartasdamao().get(0), 822, 307);
            if(mesadotabuleiro.get(4).getCartasdamao().size() >=2){addObject (mesadotabuleiro.get(4).getCartasdamao().get(1), 927, 307);}
        }
        showText (mesadotabuleiro.get(4).toString(), 878, 410);
        //===============================================

        showText(this.toString(), 500, 380);

        showText(baralho.toString(), 908, 645);
        showText("Cemitério "+cemiterio.toString(), 500, 410);
    }

    public String toString(){ 
        return "Banco de Recursos = "+this.recurso;

    }

}











