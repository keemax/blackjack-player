import model.Card;
import model.Hand;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: maxkeene
 * Date: 10/2/13
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    /************change this*************/
    final static String PLAYER_NAME = "max";

    Hand myHand;
    Card dealerUpCard;


    public Player() {

    }


    public int getWager() {
        /*******change this******/







        return 10;
    }



    public void consumeCard(Card card) {






    }

    public void deckShuffled() {




    }

    public boolean hit() {
        if (myHand.getValue() < 17) {
            return true;
        }
        return false;
    }
}
