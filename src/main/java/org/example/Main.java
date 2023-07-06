package org.example;

import org.example.model.ChangeDTO;
import org.example.moneyutil.CalculateChange;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CalculateChange calculateChange = new CalculateChange();

        while (true){
            System.out.println("Podaj wartość reszty w złotówkach, np 1.01, 0.5");
            double change = scan.nextDouble();

            System.out.println("\nDla reszty " + String.format("%.2f", change) + "zł:\n");
            var result = calculateChange.calculate((int)(change * 100));

            if(result.isEmpty()) System.out.println("Nie udało się znaleźć wystarczającej liczby monet\n");
            else {
                for (ChangeDTO changeCoin : result) {
                    System.out.println("Wydaj " + changeCoin.count() + " monet " + changeCoin.name());
                }
                System.out.println();
            }
        }
    }
}
