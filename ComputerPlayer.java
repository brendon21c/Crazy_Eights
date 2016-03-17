package com.Brendon;


import java.util.LinkedList;
import java.util.Scanner;


public class ComputerPlayer {

    PlayerRules helpfulCode = new PlayerRules();

    protected LinkedList compHand = new LinkedList();
    private String tempCard;

    public void computerHand(String card) {

        this.compHand.add(card);

    }

    public String CompSelection() {

        String selection = "";
        String currentCard = helpfulCode.getCurrentCard();

        for (int x = 0; x < this.compHand.size(); x++) {

            String tempCard = this.compHand.get(x).toString();

            String separated[] = tempCard.split(" ");
            String separated2[] = currentCard.split(" ");
            String number1 = separated[0];
            String number2 = separated2[0];
            String suit1 = separated[2];
            String suit2 = separated2[2];

            if (number1.equalsIgnoreCase("8")) {

                LinkedList suits = new LinkedList();
                suits.add("Diamonds");
                suits.add("Hearts");
                suits.add("Clubs");
                suits.add("Spades");



            }

        }







    }


}
