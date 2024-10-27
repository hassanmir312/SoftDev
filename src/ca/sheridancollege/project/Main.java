/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author hassa
 */
public class Main {

    public static void main(String[] args) {
        WarGame game = new WarGame("War Card Game");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the War Card Game!");

        for (int i = 1; i <= 2; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String playerName = scanner.nextLine();
            game.registerPlayer(playerName);
        }

        game.play();
        game.declareWinner();

        scanner.close();
    }
}   

