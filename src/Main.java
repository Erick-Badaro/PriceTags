import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<Product> product = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of products:");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++){
            System.out.println("Product # " + (i+1) + " data:");
            System.out.println("Common, used or imported (c/u/i)?");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.println("Name:");
            String name = sc.nextLine();
            System.out.println("Price:");
            double price = sc.nextDouble();
            if (ch == 'c'){
                product.add(new Product(name,price));
            }
            else if (ch == 'u'){
                System.out.println("Manufacture date:");
                LocalDate manufactureDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                product.add(new UsedProduct(name, price, manufactureDate));
            } else {
                System.out.println("Customs fee:");
                double customsFee = sc.nextDouble();
                product.add(new ImportedProduct(name, price, customsFee));
            }
        }

        System.out.println();
        System.out.println("PRICE TAG:");
        for (Product p : product ){
            System.out.println(p.priceTag());
        }


        sc.close();








    }
}