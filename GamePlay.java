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


        while (playerHand1 != null || computerHand != null) {


            System.out.println("Let's play crazy eights! \n");
            System.out.println("The current card in play: " + player.getCurrentCard());
            System.out.println("This is your hand: \n");

            player.CompSelection();
            player.playerSelection();
            player.playCheck();
            //comp.CompSelection();

            if (deck1 == null) {

                player.newDeck();
                deck1 = player.getDeck();
            }


        }




    }
}
