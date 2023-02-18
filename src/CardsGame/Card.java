package CardsGame;

import javax.swing.*;

public class Card {
    private Picture suit;
    private final int  number;

    public Card(String suit){
        this(suit,0);
    }
    public Card(String suit,int number){
        switch (suit){
            case "heart":
                this.suit=Picture.heart;
                break;
            case "spade":
                this.suit=Picture.spade;
                break;
            case "club":
                this.suit=Picture.club;
                break;
            case "diamond":
                this.suit=Picture.diamond;
                break;
            case "joker":
                this.suit=Picture.joker;
                number=0;
                break;
            default:
                throw new RuntimeException("suit error");
        }
        if (number>0&&number<14) {
            this.number = number;
        }
        else throw new RuntimeException("number error");
    }

    public int getNumber() {
        return number;
    }

    public Picture getSuit() {
        return suit;
    }

    public ImageIcon getImage(){
        return Picture.pictures.get(this.suit).get(number);
    }
}
