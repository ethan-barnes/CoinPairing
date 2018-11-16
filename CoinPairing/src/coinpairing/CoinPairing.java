/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinpairing;
/**
 *
 * @author ethanbarnes
 */
public class CoinPairing {
    public static void main(String[] args) {
        Problem4 test = new Problem4();
        test.numberOfCoins();
        if (test.coins % 2 == 0) {
            test.even();
        } else {
            test.odd();
        }
        test.coinsOutput();
        
       
    }
}