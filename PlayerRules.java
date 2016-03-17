package com.Brendon;


import java.util.*;

public class PlayerRules {

    private String currentCard;
    protected LinkedList hand = new LinkedList();
    protected Stack discardPile = new Stack();
    private String tempCard;
    private Stack deck;

    public Stack getDeck() {
        return deck;
    }

    public void setDeck(Stack deck) {
        this.deck = deck;
    }

    public String getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(String currentCard) {
        this.currentCard = currentCard;
    }

    public void PlayerHand(String card) {

        this.hand.add(card);

    }

    public String playerSelection() {

        String selection = "";
        int startNum = 1;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            for (int x = 0; x < this.hand.size(); x++) {

                System.out.println(startNum + ". " + this.hand.get(x).toString());
                startNum += 1;

            }

            System.out.println();
            System.out.println("Make your selection by entering the number or enter draw to get a new card:");

            String entry = scanner.nextLine();

            if (entry.equalsIgnoreCase("draw")) {

                String card = deck.pop().toString();
                this.hand.add(card);
                startNum = 1;
                System.out.println("current card: " + getCurrentCard());
                continue;

            } else {

                int entry1 = Integer.parseInt(entry);

                selection = this.hand.get(entry1 - 1).toString();
                this.tempCard = selection;
                selection = this.hand.get(entry1 - 1).toString();


                this.tempCard = selection;
                break;

            }

        }

        return tempCard;

    }

    public void playCheck() {

        String selection = this.tempCard;

        String separated[] = selection.split(" ");
        String separated2[] = getCurrentCard().split(" ");

        String number1 = separated[0];
        String number2 = separated2[0];
        String suit1 = separated[2];
        String suit2 = separated2[2];


        if (number1.equalsIgnoreCase(number2)) {

            this.hand.remove(selection);
            this.discardPile.add(getCurrentCard());
            setCurrentCard(selection);

        } else if (suit1.equalsIgnoreCase(suit2)) {

            this.hand.remove(selection);
            this.discardPile.add(getCurrentCard());
            setCurrentCard(selection);

        } else if (number1.equalsIgnoreCase("8")) {

            Scanner scanner = new Scanner(System.in);
            this.hand.remove(selection);
            this.discardPile.add(getCurrentCard());

            System.out.println("Choose a new suit.");
            String choice = scanner.nextLine();

            setCurrentCard(choice);

        } else {

            System.out.println("That is not a valid choice.");
            System.out.println("The current card in play: " + getCurrentCard());
            playerSelection();

        }

    }

    public void newDeck() {

        Stack oldDeck = this.discardPile;
        Collections.shuffle(oldDeck);
        setDeck(oldDeck);

    }



}
