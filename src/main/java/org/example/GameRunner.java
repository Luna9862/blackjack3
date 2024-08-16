package org.example; // Declares the package name, organizing the class into the 'org.example' package.

import java.util.Scanner; // Imports the Scanner class from the Java standard library, which is used for reading input from the user.

public class GameRunner { // Declares the 'GameRunner' class, which contains the main method and runs the Blackjack game.

    public static void main(String[] args) { // The main method is the entry point of the Java application where the program starts executing.
        Scanner sc = new Scanner(System.in); // Creates a Scanner object 'sc' to read input from the console.
        boolean playAgain = true; // A boolean variable 'playAgain' is initialized to true, controlling whether the game loop continues.

        while (playAgain) { // Starts a loop that runs as long as 'playAgain' is true, allowing the player to play multiple rounds of the game.
            Deck deck = new Deck(); // Creates a new Deck object 'deck', representing a standard deck of playing cards.
            deck.shuffle(); // Shuffles the deck to randomize the order of the cards.

            Player player = new Player(); // Creates a new Player object 'player', representing the player in the game.
            Dealer dealer = new Dealer(); // Creates a new Dealer object 'dealer', representing the dealer in the game.

            System.out.println("Welcome to Blackjack!"); // Prints a welcome message to the player.

            // Deal initial hands to both the player and the dealer
            player.addCardToHand(deck.dealNextCard()); // Deals the first card from the deck to the player's hand.
            dealer.addCardToHand(deck.dealNextCard()); // Deals the first card from the deck to the dealer's hand.
            player.addCardToHand(deck.dealNextCard()); // Deals the second card from the deck to the player's hand.
            dealer.addCardToHand(deck.dealNextCard()); // Deals the second card from the deck to the dealer's hand.

            // Check if either the player or the dealer has Blackjack with their initial two cards
            if (player.hasBlackjack() && dealer.hasBlackjack()) { // Checks if both the player and the dealer have Blackjack (an Ace and a 10-point card).
                System.out.println("Both you and the dealer have Blackjack! It's a push!"); // If both have Blackjack, it's a tie, and this message is displayed.
            } else if (player.hasBlackjack()) { // Checks if only the player has Blackjack.
                System.out.println("Blackjack! You win!"); // If the player has Blackjack, they win, and this message is displayed.
                player.adjustBalance(150); // The player's balance is increased by 150 units as a reward for winning with Blackjack.
            } else if (dealer.hasBlackjack()) { // Checks if only the dealer has Blackjack.
                System.out.println("Dealer has Blackjack! You lose."); // If the dealer has Blackjack, the player loses, and this message is displayed.
                player.adjustBalance(-100); // The player's balance is decreased by 100 units as a penalty for losing to the dealer's Blackjack.
            } else { // If neither has Blackjack, the game continues.
                // Player's turn: The player decides whether to 'hit' (draw another card) or 'stand' (stop drawing cards).
                boolean playerBusted = false; // A boolean flag 'playerBusted' is initialized to false to track if the player busts (exceeds 21 points).
                while (true) { // A loop that allows the player to keep drawing cards until they bust or decide to stand.
                    System.out.println("Your hand: " + player.getHand() + " Value: " + player.getHandValue()); // Displays the player's current hand and its total value.
                    System.out.println("Dealer's hand: " + dealer.getHand().get(0) + " [Hidden]"); // Displays the dealer's first card, keeping the second card hidden.

                    System.out.print("Do you want to (h)it or (s)tand? "); // Prompts the player to choose whether to hit or stand.
                    String choice = sc.nextLine(); // Reads the player's choice from the console.

                    if (choice.equalsIgnoreCase("h")) { // If the player chooses to 'hit' (case-insensitive check), the following code executes.
                        player.addCardToHand(deck.dealNextCard()); // Deals another card to the player's hand.
                        if (player.getHandValue() > 21) { // Checks if the player's hand value exceeds 21, meaning they bust.
                            System.out.println("Your hand: " + player.getHand() + " Value: " + player.getHandValue()); // Displays the player's final hand and its value.
                            System.out.println("You bust!"); // Informs the player that they have busted.
                            player.adjustBalance(-100); // The player's balance is decreased by 100 units as a penalty for busting.
                            playerBusted = true; // Sets 'playerBusted' to true to indicate that the player has busted.
                            break; // Exits the loop as the player has busted.
                        }
                    } else if (choice.equalsIgnoreCase("s")) { // If the player chooses to 'stand' (case-insensitive check), the following code executes.
                        break; // Exits the loop as the player has decided to stand.
                    } else { // If the player enters an invalid choice, the following code executes.
                        System.out.println("Invalid choice. Please enter 'h' or 's'."); // Displays an error message prompting the player to enter a valid choice.
                    }
                }

                // Dealer's turn: The dealer draws cards until their hand value is at least 17.
                if (!playerBusted) { // If the player has not busted, the dealer takes their turn.
                    System.out.println("Dealer's hand: " + dealer.getHand() + " Value: " + dealer.getHandValue()); // Displays the dealer's current hand and its total value.

                    while (dealer.getHandValue() < 17) { // The dealer must keep drawing cards until their hand value is at least 17.
                        dealer.addCardToHand(deck.dealNextCard()); // Deals another card to the dealer's hand.
                        System.out.println("Dealer draws: " + dealer.getHand().get(dealer.getHand().size() - 1)); // Displays the card that the dealer just drew.
                    }

                    System.out.println("Dealer's final hand: " + dealer.getHand() + " Value: " + dealer.getHandValue()); // Displays the dealer's final hand and its total value.

                    // Determine the winner by comparing the player's and dealer's hand values.
                    int playerValue = player.getHandValue(); // Retrieves the total value of the player's hand.
                    int dealerValue = dealer.getHandValue(); // Retrieves the total value of the dealer's hand.

                    if (dealerValue > 21) { // If the dealer's hand value exceeds 21, the dealer busts.
                        System.out.println("Dealer busts! You win!"); // Informs the player that the dealer has busted, so the player wins.
                        player.adjustBalance(100); // The player's balance is increased by 100 units as a reward for winning.
                    } else if (playerValue > dealerValue) { // If the player's hand value is greater than the dealer's without busting, the player wins.
                        System.out.println("You win!"); // Informs the player that they have won.
                        player.adjustBalance(100); // The player's balance is increased by 100 units as a reward for winning.
                    } else if (playerValue < dealerValue) { // If the dealer's hand value is greater than the player's without busting, the dealer wins.
                        System.out.println("Dealer wins!"); // Informs the player that the dealer has won.
                        player.adjustBalance(-100); // The player's balance is decreased by 100 units as a penalty for losing.
                    } else { // If the player's and dealer's hand values are equal, it's a tie.
                        System.out.println("It's a tie!"); // Informs the player that the game is a tie.
                    }
                }
            }

            System.out.println("Your final balance: $" + player.getBalance()); // Displays the player's final balance after the round.

            // Ask the player if they want to play another round of Blackjack.
            System.out.print("Do you want to play again? (y/n): "); // Prompts the player to choose whether to play again.
            String replayChoice = sc.nextLine(); // Reads the player's choice from the console.
            if (!replayChoice.equalsIgnoreCase("y")) { // If the player chooses anything other than 'y' (yes), the following code executes.
                playAgain = false; // Sets 'playAgain' to false, which will exit the game loop and end the game.
            }
        }

        System.out.println("Thanks for playing Blackjack!"); // Displays a message thanking the player for playing when the game ends.
    }
}
