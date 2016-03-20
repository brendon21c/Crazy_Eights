package com.Brendon;


import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class ComputerPlayer extends Deck{

    //PlayerRules helpfulCode = new PlayerRules();
    Deck test = new Deck();

    protected LinkedList compHand = new LinkedList();
    protected String currentCard = test.currentCard;




    public void computerHand(String card) {

        this.compHand.add(card);

    }

    public void CompSelection() {

        String selection = "";
        String currentCard = this.currentCard;

        for (int x = 0; x < this.compHand.size(); x++) {

            String tempCard = this.compHand.get(x).toString();

            String separated[] = tempCard.split(" ");
            String separated2[] = currentCard.split(" ");
            String number1 = separated[0];
            String number2 = separated2[0];
            String suit1 = separated[2];
            String suit2 = separated2[2];

            if (number1.equalsIgnoreCase("8")) {

                Random num = new Random();
                LinkedList suits = new LinkedList();
                suits.add("Diamonds");
                suits.add("Hearts");
                suits.add("Clubs");
                suits.add("Spades");

                int random = num.nextInt(0) + 5;
                String newSuit = suits.get(random).toString();

                selection = newSuit;
                this.compHand.remove(tempCard);
                this.discardPile.add(tempCard);
                this.discardPile.add(getCurrentCard());
                this.setCurrentCard(selection);

            }

            else if (number1.equalsIgnoreCase(number2) || suit1.equalsIgnoreCase(suit2)) {

                selection = tempCard;

                this.compHand.remove(tempCard);
                this.discardPile.add(tempCard);
                this.discardPile.add(getCurrentCard());
                this.setCurrentCard(selection);

            } else {

                String card = this.deck.pop().toString();
                this.compHand.add(card);


            }

        }

    }


}
