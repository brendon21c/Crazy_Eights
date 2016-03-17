package com.Brendon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class GamePlay {

    public static void main(String[] args) {

        Deck newDeck = new Deck();
        PlayerRules player = new PlayerRules();


        Stack deck1 = newDeck.Deck();
        Collections.shuffle(deck1);
        player.setDeck(deck1);

        for (int x = 0; x < 5; x++) {

            player.PlayerHand(deck1.pop().toString());

        }

        LinkedList playerHand1 = player.hand;
        player.setCurrentCard(deck1.pop().toString());

        while (playerHand1 != null) {


            System.out.println("Let's play crazy eights! \n");
            System.out.println("The current card in play: " + player.getCurrentCard());
            System.out.println("This is your hand: \n");

            player.playerSelection();
            player.playCheck();




        }




    }
}
