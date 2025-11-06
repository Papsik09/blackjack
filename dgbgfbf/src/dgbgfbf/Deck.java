package dgbgfbf;

import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    }
    
    // TODO: Create loops to adjust values for ranks.
    //First loop will be suits, then ranks. It will give each rank a  suit. Add math value to ranks.
    // Also should be a logic dealCard(), which also will delete card from list.
}