package CardsGame;

public class BJJudge {
    //player1とplayer2のハンドの合計値を比較し、player1が勝ったら1,player2が勝ったら-1,引き分けの場合は0を返す。
    public static int judge(Player player1,Player player2){
        int player1Value= player1.hand.getHandSumAdvanced();
        int player2Value= player2.hand.getHandSumAdvanced();

        if (player1Value>21&&player2Value<=21){
            System.out.println(player2.getName()+" win");
            return -1;
        }else if (player1Value<=21&&player2Value>21){
            System.out.println(player1.getName()+" win");
            return 1;
        }else if (player1Value<=21&&player2Value<=21){
            if (player1Value==player2Value){
                System.out.println("draw");
                return 0;
            }else if (player1Value>player2Value){
                System.out.println(player1.getName()+" win");
                return 1;
            }
            else {
                System.out.println(player2.getName()+" win");
                return -1;
            }
        }
        else {
            System.out.println("draw");
            return 0;
        }
    }

    public static String judgeString(Player player1,Player player2){
        int player1Value= player1.hand.getHandSumAdvanced();
        int player2Value= player2.hand.getHandSumAdvanced();

        if (player1Value>21&&player2Value<=21){
            System.out.println(player2.getName()+" win");
            return player2.getName()+" win";
        }else if (player1Value<=21&&player2Value>21){
            System.out.println(player1.getName()+" win");
            return player1.getName()+" win";
        }else if (player1Value<=21&&player2Value<=21){
            if (player1Value==player2Value){
                System.out.println("draw");
                return "draw";
            }else if (player1Value>player2Value){
                System.out.println(player1.getName()+" win");
                return player1.getName()+" win";
            }
            else {
                System.out.println(player2.getName()+" win");
                return player2.getName()+" win";
            }
        }
        else {
            System.out.println("draw");
            return "draw";
        }
    }

    public static int[] dealerJudge(Dealer dealer,Player... players){
        int[] ints = new int[players.length];
        int i=0;
        for (Player player:players){
            ints[i]= BJJudge.judge(dealer,player);
            i++;
        }
        return ints;
    }
}
