package org.example;

import org.example.data.RetrieveData;
import org.example.model.ChangeDTO;
import org.example.moneyutil.CalculateChange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<ChangeDTO> returnCoinsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wartość reszty w złotówkach, np 1.01, 0.5");
        //double change = scan.nextDouble();

        //System.out.println("Dla reszty " + change + "zł:");
        var cos = new CalculateChange();
        var pp = cos.calculate(45);

    }
}
