package org.example;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            Deck deck = new Deck();
            deck.shuffle();

            Player player = new Player();
            Dealer dealer = new Dealer();

            System.out.println("Welcome to Blackjack!");

            // Deal initial hands
            player.addCardToHand(deck.dealNextCard());
            dealer.addCardToHand(deck.dealNextCard());
            player.addCardToHand(deck.dealNextCard());
            dealer.addCardToHand(deck.dealNextCard());

            // Check for Blackjack
            if (player.hasBlackjack() && dealer.hasBlackjack()) {
                System.out.println("Both you and the dealer have Blackjack! It's a push!");
            } else if (player.hasBlackjack()) {
                System.out.println("Blackjack! You win!");
                player.adjustBalance(150); // Example win amount for Blackjack
            } else if (dealer.hasBlackjack()) {
                System.out.println("Dealer has Blackjack! You lose.");
                player.adjustBalance(-150); // Example loss amount for Blackjack
            } else {
                // Player's turn
                boolean playerBusted = false;
                while (true) {
                    System.out.println("Your hand: " + player.getHand() + " Value: " + player.getHandValue());
                    System.out.println("Dealer's hand: " + dealer.getHand().get(0) + " [Hidden]");

                    System.out.print("Do you want to (h)it or (s)tand? ");
                    String choice = sc.nextLine();

                    if (choice.equalsIgnoreCase("h")) {
                        player.addCardToHand(deck.dealNextCard());
                        if (player.getHandValue() > 21) {
                            System.out.println("Your hand: " + player.getHand() + " Value: " + player.getHandValue());
                            System.out.println("You bust!");
                            playerBusted = true;
                            break;
                        }
                    } else if (choice.equalsIgnoreCase("s")) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter 'h' or 's'.");
                    }
                }

                // Dealer's turn
                if (!playerBusted) {
                    System.out.println("Dealer's hand: " + dealer.getHand() + " Value: " + dealer.getHandValue());

                    while (dealer.getHandValue() < 17) {
                        dealer.addCardToHand(deck.dealNextCard());
                        System.out.println("Dealer draws: " + dealer.getHand().get(dealer.getHand().size() - 1));
                    }

                    System.out.println("Dealer's final hand: " + dealer.getHand() + " Value: " + dealer.getHandValue());

                    // Determine the winner
                    int playerValue = player.getHandValue();
                    int dealerValue = dealer.getHandValue();

                    if (dealerValue > 21) {
                        System.out.println("Dealer busts! You win!");
                        player.adjustBalance(100); // Example win amount
                    } else if (playerValue > dealerValue) {
                        System.out.println("You win!");
                        player.adjustBalance(100); // Example win amount
                    } else if (playerValue < dealerValue) {
                        System.out.println("Dealer wins!");
                        player.adjustBalance(-100); // Example loss amount
                    } else {
                        System.out.println("It's a tie!");
                    }
                }
            }

            System.out.println("Your final balance: $" + player.getBalance());

            // Ask player if they want to play again
            System.out.print("Do you want to play again? (y/n): ");
            String replayChoice = sc.nextLine();
            if (!replayChoice.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing Blackjack!");
    }
}
