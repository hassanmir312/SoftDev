package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 */
public class GroupOfCards {
    private ArrayList<Card> cards; // The group of cards, stored in an ArrayList
    private int size; // The size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>(size); // Initialize the ArrayList with the specified size
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
}
