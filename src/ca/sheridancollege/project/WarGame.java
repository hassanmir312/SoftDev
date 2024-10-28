package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WarGame extends Game {
    private ArrayList<WarPlayer> players;
    private final int MAX_ROUNDS = 26;

    public WarGame(String name) {
        super(name);
        this.players = new ArrayList<>();
    }

    public void registerPlayer(String name) {
        if (players.size() < 2) {
            WarPlayer player = new WarPlayer(name);
            players.add(player);
            getPlayers().add(player);
            System.out.println(name + " has been registered.");
        } else {
            System.out.println("Cannot register more than 2 players.");
        }
    }

    @Override
    public void play() {
        if (players.size() != 2) {
            System.out.println("War game requires exactly 2 players.");
            return;
        }

        dealCards();

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            System.out.println("\nRound " + round + ":");
            playRound();
            displayStatus();
            
            // Optional: Add a delay between rounds
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void playRound() {
        WarCard card1 = players.get(0).playCard();
        WarCard card2 = players.get(1).playCard();

        if (card1 == null || card2 == null) {
            System.out.println("One or both players are out of cards. Reshuffling...");
            reshuffleCards();
            card1 = players.get(0).playCard();
            card2 = players.get(1).playCard();
        }

        System.out.println(players.get(0).getName() + " plays " + card1);
        System.out.println(players.get(1).getName() + " plays " + card2);

        if (card1.getRank() > card2.getRank()) {
            players.get(0).incrementScore();
            System.out.println(players.get(0).getName() + " wins the round");
        } else if (card2.getRank() > card1.getRank()) {
            players.get(1).incrementScore();
            System.out.println(players.get(1).getName() + " wins the round");
        } else {
            System.out.println("It's a tie! No points awarded.");
        }
    }

    private void reshuffleCards() {
        GroupOfCards allCards = new GroupOfCards(52);
        for (WarPlayer player : players) {
            allCards.getCards().addAll(player.getAllCards());
            player.clearHand();
        }
        allCards.shuffle();
        int halfSize = allCards.getSize() / 2;
        for (int i = 0; i < allCards.getSize(); i++) {
            players.get(i < halfSize ? 0 : 1).addCard((WarCard) allCards.getCards().get(i));
        }
    }

    private void displayStatus() {
        for (WarPlayer player : players) {
            System.out.println(player.getStatus());
        }
    }

    @Override
    public void declareWinner() {
        WarPlayer player1 = players.get(0);
        WarPlayer player2 = players.get(1);
        
        if (player1.getScore() > player2.getScore()) {
            System.out.println("\n" + player1.getName() + " wins the game!");
        } else if (player2.getScore() > player1.getScore()) {
            System.out.println("\n" + player2.getName() + " wins the game!");
        } else {
            System.out.println("\nIt's a tie!");
        }
        
        System.out.println("Final scores:");
        displayStatus();
    }

    private void dealCards() {
        GroupOfCards deck = new GroupOfCards(52);
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) {
                deck.getCards().add(new WarCard(suit, rank));
            }
        }

        deck.shuffle();

        for (int i = 0; i < deck.getSize(); i++) {
            players.get(i % 2).addCard((WarCard) deck.getCards().get(i));
        }
    }
}