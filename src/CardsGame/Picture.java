package CardsGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public enum Picture {
    diamond,heart,spade,club,joker,back;

    public static final EnumMap<Picture, Map<Integer,ImageIcon>> pictures;

    static {
        pictures=new EnumMap<>(Picture.class);
        Map<Integer,ImageIcon> diamond=new HashMap<>();
        Map<Integer,ImageIcon> heart=new HashMap<>();
        Map<Integer,ImageIcon> spade=new HashMap<>();
        Map<Integer,ImageIcon> club=new HashMap<>();
        File file;
        BufferedImage bufferedImage;
        ImageIcon imageIcon;

        for (Picture picture:Picture.values()){
            if (picture==Picture.joker||picture==Picture.back){
                String filename = picture==Picture.joker?"src/CardsGame/cards/card_joker.png":"src/CardsGame/cards/card_back.png";
                try{
                    file=new File(filename);
                    bufferedImage= ImageIO.read(file);
                    imageIcon=new ImageIcon(bufferedImage);

                    if (picture==Picture.joker){
                        Map<Integer,ImageIcon> joker=new HashMap<>();
                        joker.put(0,imageIcon);
                        pictures.put(Picture.joker,joker);
                    }
                    else {
                        Map<Integer,ImageIcon> back=new HashMap<>();
                        back.put(0,imageIcon);
                        pictures.put(Picture.back,back);
                    }
                }catch (IOException e){
                    System.out.println("file error");
                }
            }
            else {
            for (int i=1;i<=13;i++){
                String filename;
                if (i<10)filename="src/CardsGame/cards/card_"+picture+"_"+0+i+".png";
                else filename="src/CardsGame/cards/card_"+picture+"_"+i+".png";
                try {
                    file = new File(filename);
                    bufferedImage = ImageIO.read(file);
                    imageIcon=new ImageIcon(bufferedImage);
                    switch (picture){
                        case club -> club.put(i,imageIcon);
                        case heart -> heart.put(i,imageIcon);
                        case diamond -> diamond.put(i,imageIcon);
                        case spade -> spade.put(i,imageIcon);
                    }
                }catch (IOException e){
                    System.out.println(e);
                }
            }
            }
        }
        pictures.put(Picture.diamond,diamond);
        pictures.put(Picture.club,club);
        pictures.put(Picture.spade,spade);
        pictures.put(Picture.heart,heart);
    }
}
