package CardsGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphic {
    private Field field;
    private  Deck deck;
    private final JFrame frame;
    private final Player player;

    private Dealer dealer;

    private JButton button;
    private JButton button1;
    private JButton button2;
    private JLabel[] label;
    private JLabel[] dealerHands;
    private JLabel playerName;
    private JLabel dealerName;

    public Graphic(Deck deck){
        this.deck=deck;
        this.player=new Player("aaa");
        this.frame=new JFrame();
    }
    public Graphic(Field field){
        this.field=field;
        this.deck=this.field.getDeck();
        this.dealer=this.field.getDealer();
        this.player=this.field.getPlayer1();
        this.frame=new JFrame();
        this.playerName=new JLabel(this.player.getName());
        this.dealerName=new JLabel(this.dealer.getName());
    }

    public void graphic() {

        button=new JButton("Draw");
        button1=new JButton("New Game");
        button2=new JButton("Stay");

        this.player.draw(this.deck,2);

        setDealerFirstHands();

        frame.add(button);
        frame.add(button2);
        frame.add(button1);
        frame.setLayout(new FlowLayout(FlowLayout.LEADING));
        frame.setSize(1500,500);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bet(PopUp.getInt(this.player.getBuyIn()));
        this.setHand();



        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.getHandSum()<21){
                    player.addDraw(deck);
                    setIcon();
                    frame.setVisible(true);
                }
                if (player.getHandSum()>21){
                    dealerSet();
                    PopUp.sss(BJJudge.judgeString(dealer,player));
                    pay(BJJudge.judge(dealer,player));
                }
                else if (player.getHandSum()==21){
                    dealerSet();
                    PopUp.sss(BJJudge.judgeString(dealer,player));
                    pay(BJJudge.judge(dealer,player));
                }
            }
        });
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dealerSet();
                PopUp.sss(BJJudge.judgeString(dealer,player));
                pay(BJJudge.judge(dealer,player));
            }
        });
    }

    public void setHand(){
        this.label=new JLabel[this.player.getHand().length];
        for (int i=0;i<this.player.getHand().length;i++){
            label[i]=new JLabel();
            label[i].setIcon(this.player.getHand()[i].getImage());
            this.frame.add(label[i]);
        }
        frame.add(playerName);
        frame.setVisible(true);
    }

    public void setDealerFirstHands(){
        frame.add(dealerName);
        this.dealerHands=new JLabel[this.dealer.getHand().length];
        dealerHands[0]=new JLabel();
        dealerHands[0].setIcon(this.dealer.getHand()[0].getImage());
        this.frame.add(dealerHands[0]);
        dealerHands[1]=new JLabel();
        dealerHands[1].setIcon(Picture.pictures.get(Picture.back).get(0));
        this.frame.add(dealerHands[1]);
        frame.setVisible(true);
    }

    public void setDealerHands(){
        frame.add(dealerName);
        this.dealerHands=new JLabel[this.dealer.getHand().length];
        for (int i=0;i<this.dealer.getHand().length;i++){
            dealerHands[i]=new JLabel();
            dealerHands[i].setIcon(this.dealer.getHand()[i].getImage());
            this.frame.add(dealerHands[i]);
        }
        frame.setVisible(true);
    }
    public void setDealerIcon(){

        for (JLabel label1:this.dealerHands){
            //label1.setIcon(null);
            frame.remove(label1);
        }
        setDealerHands();
    }

    public void setIcon(){
        for (JLabel label1:this.label){
            //label1.setIcon(null);
            frame.remove(label1);
        }
        setHand();
    }
    public void resetIcon(){
        for (JLabel label1:this.label) {
            //label1.setIcon(null);
            frame.remove(label1);
        }
        frame.remove(playerName);
    }

    public void dealerSet(){
        frame.remove(button);
        frame.remove(button1);
        frame.remove(button2);
        dealer.autDraw(deck);
        setDealerIcon();
        frame.add(button);
        frame.add(button2);
        frame.add(button1);
        setIcon();
    }

    public void setDealerFirstIcon(){

        for (JLabel label1:this.dealerHands){
            //label1.setIcon(null);
            frame.remove(label1);
        }
        setDealerFirstHands();
    }
    public void bet(int wager){
        this.player.bet(this.field,wager);
    }

    public void pay(int win){
        if (win==-1&&this.player.getHandSum()==21){
            this.player.setBuyIn(this.player.getBuyIn()+this.field.getWager()*2.5);
            PopUp.sss("you gets"+this.field.getWager()*2.5+"!");
        }
        else if (win==-1) {
            this.player.setBuyIn(this.player.getBuyIn() + this.field.getWager() * 2);
            PopUp.sss("you gets" + this.field.getWager() * 2.0 + "!");
        }
        else if(win==0){
            this.player.setBuyIn(this.player.getBuyIn() + this.field.getWager());
            PopUp.sss("you gets" + this.field.getWager()+ "!");
        }
        this.field.setWager(0);
    }

    public void reset(){
        resetDeck();
        frame.remove(button);
        frame.remove(button1);
        frame.remove(button2);
        player.handReset();
        dealer.handReset();
        player.draw(deck,2);
        dealer.draw(deck,2);
        setDealerFirstIcon();
        frame.add(button);
        frame.add(button2);
        frame.add(button1);
        resetIcon();
        frame.setVisible(true);
        bet(PopUp.getInt(this.player.getBuyIn()));
        setIcon();
    }
    public void resetDeck(){
        this.field.resetDeck();
        this.deck=this.field.getDeck();
    }
}
