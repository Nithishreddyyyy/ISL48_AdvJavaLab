package _7Book;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer,Book> bookMap = new HashMap<>();
        bookMap.put(1,new Book(10,"Java","Nithish","PHI",1435));
        bookMap.put(2,new Book(11,"Java","Rahul","PHI",1245));
        bookMap.put(3,new Book(12,"Python","Nova","RA",14335));

        System.out.println("List of All Books: ");
        for (Book bk : bookMap.values()){           //Look at it
            System.out.println(bk);
        }
        System.out.println("---------------");

        List<Book> sortedByPrice = new ArrayList<>(bookMap.values());
        sortedByPrice.sort(Comparator.comparingDouble(b->b.price));
        System.out.println("List of All Books SortedBy Price: ");
        for (Book bk : sortedByPrice){
            System.out.println(bk);
        }
        System.out.println("--------------");

        System.out.println("Enter an author's name to search: ");
        String searchAuthor = sc.nextLine();
        for (Book bk : bookMap.values()){
            if(bk.author.equalsIgnoreCase(searchAuthor)){
                System.out.println(bk);
            }
        }
        System.out.println("--------------");

    }
}
