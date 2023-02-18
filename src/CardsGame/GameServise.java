package CardsGame;


public class GameServise {
    public static void gameStart(){
        Field field;
        Player player1=new Player("player1");
        field = new Field(player1);
        new Graphic(field).graphic();
    }
}
