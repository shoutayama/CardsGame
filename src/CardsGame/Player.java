package CardsGame;

public class Player {
    protected Hand hand;
    private double buyIn;
    private String name;

    public Player(String name){
        this.hand=new Hand(2);
        this.buyIn=100;
        this.name=name;
    }

    public void draw(Deck deck){
        this.hand.draw(deck);
    }
    public void draw(Deck deck,int n){
        for (int i=0;i<n;i++){
            draw(deck);
        }
    }

    public void addDraw(Deck deck){
        this.hand.add(Draw.draw(deck.getCardsArray()));
    }

    public void handReset(){
        this.hand=new Hand(2);
    }

    public void add(Card card){
        this.hand.add(card);
    }


    public Card[] getHand() {
        return this.hand.getHand();
    }

    public int getHandSum(){
        return this.hand.getHandSumAdvanced();
    }

    public double getBuyIn() {
        return this.buyIn;
    }

    public String getName() {
        return name;
    }

    public void setBuyIn(double buyIn) {
        this.buyIn = buyIn;
    }
    public void autDraw(Deck deck) {
        while (this.hand.getHandSumAdvanced()<=16){
            this.hand.add(Draw.draw(deck.getCardsArray()));
        }
    }

    public void bet(Field field,double bets){
        field.setWager(field.getWager()+bets);
        this.buyIn-=bets;
    }
}
