package CardsGame;

import javax.swing.*;

public class PopUp {
    public static void sss() {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Hello there! How are you today?");
    }

    public static void sss(String s) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame,s);
    }

    public static int getInt(){
        JFrame jFrame = new JFrame();
        String s= JOptionPane.showInputDialog(jFrame, "How much do you bet ?");
        if (s==null){
            return 0;
        }
        try{
         return Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            return getInt();
        }
    }

    public static int getInt(double string){
        JFrame jFrame = new JFrame();
        String s= JOptionPane.showInputDialog(jFrame, "How much do you bet ?\nNow you have $"+string);
        if (s==null){
            return 0;
        }
        try{
            int wager= Integer.parseInt(s);
            return wager<=100&&wager>=0?wager:getInt(string);
        }
        catch (NumberFormatException e){
            return getInt(string);
        }
    }
}
