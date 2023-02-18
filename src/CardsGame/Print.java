package CardsGame;

import java.util.List;

public class Print {
    public static void print(Card[] cards){
        for (Card c:cards){
            if (c==null) break;
            System.out.println(c.getSuit()+" "+c.getNumber());
        }
        System.out.println(" ");
    }

    public static void print(List<Card> cards){
        for (Card c:cards){
            System.out.println(c.getSuit().ordinal()+" "+c.getNumber());
        }
        System.out.println(" ");
    }

    public static void print(Player player){
        System.out.println("\""+player.getName()+"\""+player.getBuyIn()+"\"");
        print(player.getHand());
    }
    public static void print(Dealer player){
        System.out.println("\""+player.getName()+"\"");
        print(player.getHand());
    }

    public static void print(Hand hand){
        print(hand.getHand());
    }
}
