package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UseProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> productsList = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Product #" + (i + 1) + " data:");
            System.out.print("Common, used, or imported (c/u/i)? ");
            char type = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (type == 'c') {
                productsList.add(new Product(name, price));
            }
            else if (type == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufactureDate = LocalDate.parse(sc.next(), fmt);

                productsList.add(new UseProduct(name, price, manufactureDate));
            }
            else {
                System.out.print("Customs fee: ");
                Double customs = sc.nextDouble();

                productsList.add(new ImportedProduct(name, price, customs));
            }
        }

        System.out.println();
        System.out.println("PRICE TAG:");
        for (Product p : productsList) {
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}