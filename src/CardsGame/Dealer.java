package CardsGame;

public class Dealer extends Player {
    public Dealer(Deck deck){
        super("dealer");
        this.hand.draw(deck,2);
    }


}
