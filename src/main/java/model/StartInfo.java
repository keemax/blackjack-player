package model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: maxkeene
 * Date: 10/1/13
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class StartInfo {

    private List<Card> revealedCards;
    private Hand yourHand;
    private Card dealerUpCard;
    private boolean shuffled;

    public boolean isShuffled() {
        return shuffled;
    }

    public List<Card> getRevealedCards() {
        return revealedCards;
    }

    public Hand getYourHand() {
        return yourHand;
    }

    public Card getDealerUpCard() {
        return dealerUpCard;
    }
}
