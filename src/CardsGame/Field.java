package CardsGame;

public class Field {
    private Deck deck;
    private Dealer dealer;
    private Player player1;
    private double wager;

    public Field(){
        this.deck=new Deck();
        this.deck.shuffle();
        this.player1=new Player("player1");
        this.dealer=new Dealer(this.deck);
        this.wager=0;

    }

    public Field(Player player1){
        this();
        if (player1!=null){
            this.player1=player1;
        }
    }

    public Player getPlayer1() {
        return this.player1;
    }


    public void setWager(double wager) {
        this.wager = wager;
    }

    public double getWager() {
        return wager;
    }

    public void resetWager(){
        this.wager=0;
    }

    public Deck getDeck() {
        return deck;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void resetDeck(){
        this.deck=new Deck();
        this.deck.shuffle();
    }
}
