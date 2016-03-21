package com.Brendon;

import java.util.LinkedList;

/**
 * Created by Brendon on 3/20/16.
 */
public class Scoring {



    public int playerScore(LinkedList hand) {

        LinkedList playerHand = hand;
        int total = 0;

        for (int x = 0; x < playerHand.size(); x++) {

            String card = playerHand.get(x).toString();
            String temp[] = card.split(" ");
            String process = temp[0];

            if (process.equalsIgnoreCase("ace")) {

                total += 1;

            } else if (process.equalsIgnoreCase("8")) {

                total += 50;

            } else if (process.equalsIgnoreCase("jack") || process.equalsIgnoreCase("queen") ||
                    process.equalsIgnoreCase("king")) {

                total += 10;

            } else {

                total += Integer.parseInt(process);

            }

        }

        return total;


    }

}
