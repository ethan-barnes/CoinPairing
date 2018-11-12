package coinpairing;

import java.util.Scanner;

/**
 *
 * @author klaudiabzdyk
 */
public class Problem4 {

    Scanner nCoins = new Scanner(System.in);
    public int coins;
    private int[] rowOfCoins;
    private int counter;
    private int coinCounter = coins;
    private int numberOfMoves = 0;

    public void numberOfCoins() {
        System.out.println("How many coins do we have?");

        coins = nCoins.nextInt();

        while (coins < 4) {
            System.out.println("You need to have more than three coins! Write the number of coins again.");
            coins = nCoins.nextInt();
        }

        //create row of coins
        //empty place = 0
        //single coin = 1
        //pair of coins = 2
        rowOfCoins = new int[coins + 1]; //rowOfCoins array wasn't given a length/////////////////////
        rowOfCoins[coins - 1] = 0; //changed to coins-1 to reflect above problem//////////////////
        for (int i = 0; i < rowOfCoins.length - 1; i++) {
            rowOfCoins[i] = 1;
        }
        System.out.println("Unsorted coins: ");
        for (int i = 0; i < rowOfCoins.length; i++) {
            System.out.print(rowOfCoins[i] + " ");
        }
        System.out.println("");
    }

    public void even() {
        coinCounter = coins;
        while (coinCounter > 4) {
            //find index of the fourth single coin 
            int thSingleCoin = findCoin(4);
            //find index of the first single coin 
            int stSingleCoin = findCoin(1);
            rowOfCoins[thSingleCoin] = 0;
            rowOfCoins[stSingleCoin] = 2;
            numberOfMoves++;
            //check if there are more than four single coins (using trdCounter)
            coinCounter = 0;
            for (int i = 0; i < rowOfCoins.length; i++) {
                if (rowOfCoins[i] == 1) {
                    coinCounter++; //number of single coins
                }
            }
        }

        //If 4 coins left
        //find indexes of first four single coins 
        int firstCoin = findCoin(1);
        int secondCoin = findCoin(2);
        int thirdCoin = findCoin(3);
        int fourthCoin = findCoin(4); //this returns 7 when 4 coins are used/////////////////////
        rowOfCoins[firstCoin] = 0;
        rowOfCoins[fourthCoin] = 2;
        numberOfMoves++;
        rowOfCoins[thirdCoin] = 0;
        rowOfCoins[coins] = 1;
        numberOfMoves++;
        rowOfCoins[secondCoin] = 0;
        rowOfCoins[coins] = 2;
        numberOfMoves++;
    }

    public void odd() {

        coinCounter = coins;
        while (coinCounter > 5) {
//            check if there are more than five single coins 
//            find index of the fourth single coin 
            int thSingleCoin = findCoin(4);
            //find index of the first single coin 
            int stSingleCoin = findCoin(1);
            rowOfCoins[thSingleCoin] = 0;
            rowOfCoins[stSingleCoin] = 2;
            coinCounter = 0;
            for (int i = 0; i < rowOfCoins.length; i++) {
                if (rowOfCoins[i] == 1) {
                    coinCounter++; //number of single coins
                }
            }
            numberOfMoves++;
        }

        //If five coins left
        //find the indexes of first five single coins
        int firstCoin = findCoin(1);
        int thirdCoin = findCoin(3);
        int fourthCoin = findCoin(4);
        int fifthCoin = findCoin(5);
        rowOfCoins[firstCoin] = 0;
        rowOfCoins[fourthCoin] = 2;
        numberOfMoves++;
        rowOfCoins[thirdCoin] = 0;
        rowOfCoins[fifthCoin] = 2;
        numberOfMoves++;
    }

    public int findCoin(int a) {
        int count = 0;
        for (int i = 0; i < rowOfCoins.length; i++) {
            if (rowOfCoins[i] == 1) {
                count++;
                if (a == count) {
                    return i;
                }
            }
        }
        return 0;
    }

    public void coinsOutput() {
        System.out.println("Sorted coins: ");
        for (int i = 0; i < rowOfCoins.length; i++) {
            System.out.print(rowOfCoins[i] + " ");
        }
        System.out.println("");
        System.out.println("Number of moves: " + numberOfMoves);
    }
}
