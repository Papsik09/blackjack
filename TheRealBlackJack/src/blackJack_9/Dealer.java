package blackJack_9;
import java.util.*;

public class Dealer extends Player {
    private Deck deck;

    public Dealer(Deck deck) {
        super("Dealer");
        this.deck = deck;
    }

    public void autoPlay(Player player) {
        while (getScore() < 17 && getScore() < player.getScore()) {
            hit(deck);
        }
    }
}