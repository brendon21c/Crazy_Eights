package com.Brendon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class GamePlay {

    public static void main(String[] args) {

        Deck newDeck = new Deck();
        PlayerRules player = new PlayerRules();
        //ComputerPlayer comp = new ComputerPlayer();



        Stack deck1 = newDeck.Deck();
        Collections.shuffle(deck1);
        player.setDeck(deck1);

        for (int x = 0; x < 5; x++) {

            player.PlayerHand(deck1.pop().toString());

        }
        for (int x = 0; x < 5; x++) {

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


        Boolean check = true;

        System.out.println("Let's play crazy eights! \n");


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

            System.out.println("Player wins!");

        }

        if (computerHand.isEmpty()) {
            System.out.println("computer wins!");
        }



    }
}
