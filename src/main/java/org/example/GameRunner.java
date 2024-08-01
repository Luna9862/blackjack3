package org.example;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        // Initialize game components
        Deck deck = new Deck();
        deck.shuffle();

        Player player = new Player();
        Dealer dealer = new Dealer();
        Scanner sc = new Scanner(System.in);

        // Game logic implementation
        System.out.println("Welcome to Blackjack!");

        // Example: Deal initial hands
        player.addCardToHand(deck.dealNextCard());
        dealer.addCardToHand(deck.dealNextCard());
        player.addCardToHand(deck.dealNextCard());
        dealer.addCardToHand(deck.dealNextCard());

        System.out.println("Your hand: " + player.getHand() + " Value: " + player.getHandValue());
        System.out.println("Dealer's hand: " + dealer.getHand().get(0) + " [Hidden]");

        // Additional game logic (e.g., player actions, dealer actions, determining winner)
    }
}
