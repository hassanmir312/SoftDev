package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. 
 * Must be general enough to be instantiated for any Card game.
 * Students wishing to add to the code should remember to add themselves as a modifier.
 */
public abstract class Card {
    // Default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card.
     */
    @Override
    public abstract String toString();
}
