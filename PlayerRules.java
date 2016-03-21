package com.Brendon;


import java.util.*;

public class PlayerRules extends Deck {

    protected String currentCard;
    protected LinkedList hand = new LinkedList();
    protected LinkedList compHand = new LinkedList();
    protected Stack discardPile = new Stack();
    protected String tempCard;
    protected Stack deck;


    public Stack getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(Stack discardPile) {
        this.discardPile = discardPile;
    }

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
                //this.tempCard = selection;
                //selection = this.hand.get(entry1 - 1).toString();


                this.tempCard = selection;
                break;

            }

        }

        return tempCard;

    }

    public void playCheck() {

        String selection = this.tempCard;
        String suitCheck = "";
        String currentCard = this.currentCard;

        if (currentCard.equalsIgnoreCase("diamonds") || currentCard.equalsIgnoreCase("hearts") ||
                currentCard.equalsIgnoreCase("spades") || currentCard.equalsIgnoreCase("clubs")) {

            currentCard = currentCard + " " + currentCard + " " + currentCard;
        }


        String separated[] = selection.split(" ");
        String separated2[] = currentCard.split(" ");

        String number1 = separated[0];
        String number2 = separated2[0];
        String suit1 = separated[2];
        String suit2 = separated2[2];
        suitCheck = number2 + " " + suit2;
        String suitTest = suit2 + " " + suit2;

        if (number1.equalsIgnoreCase("8")) {

            Scanner scanner = new Scanner(System.in);
            this.hand.remove(selection);
            this.discardPile.add(getCurrentCard());
            this.discardPile.add(selection);

            System.out.println("Choose a new suit.");
            String choice = scanner.nextLine();

            setCurrentCard(choice);

        } else if (number1.equalsIgnoreCase(number2) || suit1.equalsIgnoreCase(suit2)) {

            if (suitCheck.equalsIgnoreCase(suitTest)) {

                this.hand.remove(tempCard);
                this.setCurrentCard(selection);


            } else {

                this.hand.remove(tempCard);
                this.discardPile.add(currentCard);
                this.setCurrentCard(selection);

            }
        }
         else {

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

    public void computerHand(String card) {

        this.compHand.add(card);

    }

    public void CompSelection() {

        String selection = "";
        String currentCard = this.currentCard;
        String suitCheck = "";




            for (int x = 0; x < this.compHand.size(); x++) {

                String tempCard = this.compHand.get(x).toString();

                if (currentCard.equalsIgnoreCase("diamonds") || currentCard.equalsIgnoreCase("hearts") ||
                        currentCard.equalsIgnoreCase("spades") || currentCard.equalsIgnoreCase("clubs")) {

                    currentCard = currentCard + " " + currentCard + " " + currentCard;
                }

                String separatedComp[] = tempCard.split(" ");
                String separated2Comp[] = currentCard.split(" ");
                String number1 = separatedComp[0];
                String number2 = separated2Comp[0];
                String suit1 = separatedComp[2];
                String suit2 = separated2Comp[2];
                suitCheck = number2 + " " + suit2;
                String suitTest = suit2 + " " + suit2;



                if (number1.equalsIgnoreCase("8")) {

                    Random num = new Random();
                    LinkedList suits = new LinkedList();
                    suits.add("Diamonds");
                    suits.add("Hearts");
                    suits.add("Clubs");
                    suits.add("Spades");

                    int random = num.nextInt(4);
                    String newSuit = suits.get(random).toString();

                    selection = newSuit;
                    this.compHand.remove(tempCard);
                    this.discardPile.add(tempCard);
                    this.setCurrentCard(selection);
                    break;

                } else if (number1.equalsIgnoreCase(number2) || suit1.equalsIgnoreCase(suit2)) {

                    selection = tempCard;

                    if (suitCheck.equalsIgnoreCase(suitTest)) {

                        this.compHand.remove(tempCard);
                        this.setCurrentCard(selection);
                        break;

                    } else {

                        this.compHand.remove(tempCard);
                        this.discardPile.add(currentCard);
                        this.setCurrentCard(selection);
                        break;
                    }

                } else if (tempCard.equalsIgnoreCase(this.compHand.getLast().toString())) {

                    String card = this.deck.pop().toString();
                    this.compHand.add(card);

                }

                else if (this.deck.isEmpty()) {

                    newDeck();

                }

            }

    }

}
