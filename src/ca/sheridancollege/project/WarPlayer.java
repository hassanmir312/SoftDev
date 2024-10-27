package ca.sheridancollege.project;

import java.util.ArrayList;

public class WarPlayer extends Player {
    private ArrayList<WarCard> hand;
    private int score;

    public WarPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public void addCard(WarCard card) {
        hand.add(card);
    }

    public WarCard playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        }
        return null;
    }

    public int getHandSize() {
        return hand.size();
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }
    public ArrayList<WarCard> getAllCards() {
    return new ArrayList<>(hand);
}

    public void clearHand() {
    hand.clear();
}
    @Override
    public void play() {
        // This method is not used in War game
    }

    public String getStatus() {
        return getName() + " - Cards: " + getHandSize() + ", Score: " + getScore();
    }
}