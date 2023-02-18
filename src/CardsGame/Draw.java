package CardsGame;
public class Draw {
    public static Card draw(Card[] cards){
        Card card=cards[0];
        cards[0]=null;
        int i;
        for (i = 1; i<cards.length && cards[i]!=null; i++) {
            cards[i-1]=cards[i];
        }
        cards[i-1]=null;
        return card;
    }
}
