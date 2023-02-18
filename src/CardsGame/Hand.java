package CardsGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {
    private Card[] hand;
    private int i;

    public Hand(int n){
        this.hand=new Card[n];
        i=0;
    }

    public void draw(Deck deck){
        try{
            if (hand[i]==null){
                hand[i]=Draw.draw(deck.getCardsArray());
                i++;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("hands error\n");
        }
    }
    public void draw(Deck deck,int n){
        for (int i=0;i<n;i++){
            draw(deck);
        }
    }

    public void add(Card card){
        List<Card> cards=new ArrayList<>(Arrays.asList(this.hand));
        cards.add(card);
        this.hand=cards.toArray(new Card[cards.size()]);
    }

    public int getHandSum(){
        int sum=0;
        for (Card card:this.hand){
            int value = card.getNumber()>=10?10: card.getNumber();
            sum += value;
        }
        return sum;
    }

    public int getHandSumAdvanced(){
        int sum=0;
        int value;
        int flag=0;
        for (Card card:this.hand){
            if (getHandSum()+10<=21&&card.getNumber()==1&&flag==0){
                value=11;
                flag++;
            }
            else value = card.getNumber()>=10?10: card.getNumber();
            sum += value;
        }
        return sum;
    }

    public Card[] getHand() {
        return hand;
    }
}
