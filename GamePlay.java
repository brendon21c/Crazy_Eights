package com.Brendon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class GamePlay {

    public static void main(String[] args) {

        Deck newDeck = new Deck();
        PlayerRules player = new PlayerRules();
        Scoring scoreP = new Scoring();
        Scoring scoreC = new Scoring();



        Stack deck1 = newDeck.Deck();
        Collections.shuffle(deck1);
        player.setDeck(deck1);

        for (int x = 0; x < 7; x++) {

            player.PlayerHand(deck1.pop().toString());

        }
        for (int x = 0; x < 7; x++) {

            player.computerHand(deck1.pop().toString());

        }

        LinkedList playerHand1 = player.hand;
        LinkedList computerHand = player.compHand;
        player.setCurrentCard(deck1.pop().toString());
        String separated2[] = player.getCurrentCard().split(" ");

        if (separated2[0].equalsIgnoreCase("8")) {

            Collections.shuffle(deck1);
            player.setCurrentCard(deck1.pop().toString());

        }

        int playerScore = 0;
        int compScore = 0;



        Boolean check = true;

        System.out.println("Let's play crazy eights! \n");


        while (true) {

            while (true) {

                if (deck1.isEmpty()) {

                    player.newDeck();
                    deck1 = player.getDeck();
                }


                while (playerHand1 != null) {

                    System.out.println("The current card in play: " + player.getCurrentCard());
                    System.out.println("This is your hand: \n");
                    player.playerSelection();
                    player.playCheck();
                    break;
                }

                while (computerHand != null) {

                    player.CompSelection();
                    break;

                }

                if (playerHand1.isEmpty()) {
                    check = false;
                }

                if (computerHand.isEmpty()) {
                    check = false;
                }

                if (check == false) {
                    break;
                }

            }


            if (playerHand1.isEmpty()) {

                int score = scoreC.playerScore(computerHand);
                System.out.println("Player wins!");
                compScore += score;

            }

            if (computerHand.isEmpty()) {

                int score = scoreP.playerScore(playerHand1);
                System.out.println("computer wins!");
                playerScore += score;

            }

            Scanner playAgain = new Scanner(System.in);

            System.out.println("Do you want to play again?");
            String answer = playAgain.nextLine();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {

                continue;

            } else {

                if (playerScore < compScore) {

                    System.out.println("Congratulations you won! \n");
                    System.out.println("Player: " + playerScore);
                    System.out.println("Computer: " + compScore);
                    break;

                } else if (compScore > playerScore) {

                    System.out.println("Sorry the computer won. \n");
                    System.out.println("Player: " + playerScore);
                    System.out.println("Computer: " + compScore);
                    break;

                }

            }

        }

    }
}
