package LabPrac._7Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(10,"Java","Nithish","PHI",1435));
        bookList.add(new Book(11,"Java","Rahul","PHI",1245));
        bookList.add(new Book(12,"Python","Lekha","RA",14335));

        System.out.println("List of All Books: ");
        for (Book bk : bookList){
            System.out.println(bk);
            System.out.println("---------------");
        }
        System.out.println("Meow");

        List<Book> sortedByPrice = new ArrayList<>(bookList);
        sortedByPrice.sort(Comparator.comparingDouble(b -> b.price));
        for (Book bk : sortedByPrice){
            System.out.println(bk);
            System.out.println("--------------");
        }

        System.out.println("Enter an author's name to search: ");
        String searchAuthor = sc.nextLine();
        for (Book bk : bookList){
            if(bk.author.equalsIgnoreCase(searchAuthor)){
                System.out.println(bk);
            }
        }

    }
}
