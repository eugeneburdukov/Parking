package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number of cars: ");
        Parking parking = new Parking(scanner.nextInt());

    }
}
