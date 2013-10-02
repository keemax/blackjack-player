import model.StartInfo;
import org.springframework.web.client.RestTemplate;

import model.Card;

/**
 * Created with IntelliJ IDEA.
 * User: maxkeene
 * Date: 10/2/13
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerController {

    private final static String BASE_URL = "http://localhost:8080";
    private static String playerId;
    private static Player player;
    private static RestTemplate rest;

    public static void main(String args[]) {
        player = new Player();
        rest = new RestTemplate();

        //init
        playerId = rest.getForObject(BASE_URL + "/addPlayer?name=" + player.PLAYER_NAME, String.class);
        System.out.println("created player with player id: " + playerId);


        while(true) {
            int wager = player.getWager();
            StartInfo start = rest.getForObject(BASE_URL + "/start?playerId=" + playerId + "&wager=" + wager, StartInfo.class);
            if (start == null) {
                break;
            }
            for (Card c : start.getRevealedCards()) {
                player.consumeCard(c);
            }
            if (start.isShuffled()) {
                player.deckShuffled();
            }
            player.myHand = start.getYourHand();
            player.dealerUpCard = start.getDealerUpCard();

            while(player.hit() && player.myHand.getValue() <= 21) {
                Card newCard = rest.getForObject(BASE_URL + "/hit?playerId=" + playerId, Card.class);
                player.myHand.addCard(newCard);
            }
            if (player.myHand.getValue() <= 21) {
                rest.getForObject(BASE_URL + "/stand?playerId=" + playerId, Object.class);
            }

        }

    }
}
