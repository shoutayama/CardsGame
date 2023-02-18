package CardsGame;


import java.time.temporal.JulianFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    private Card[] cards;

    public Deck(){
        String[] marks=new String[]{"diamond","spade","heart","club"};
        List<Card> cardList =new ArrayList<>();
        for (int i=0;i<marks.length;i++){
            String mark=marks[i];
            for (int j=1;j<14;j++){
                Card card=new Card(mark,j);
                cardList.add(card);
            }
        }
        this.cards=cardList.toArray(cardList.toArray(new Card[cardList.size()]));
    }

    public void print(){
        for (Card c:cards){
            System.out.println(c.getSuit()+" "+c.getNumber());
        }
    }

    public void shuffle(){
        List<Card> list=Arrays.asList(this.cards);
        Collections.shuffle(list);
        this.cards=list.toArray(new Card[list.size()]);
    }

    public Card[] getCardsArray() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}
