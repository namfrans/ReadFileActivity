package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Reader {
    public static void PrintStack(Stack<Book> books)
    {

        if (books.empty())
            return;
        Book bookOnTop = books.peek();
        books.pop();
        System.out.println(bookOnTop + "\n");

        //recursive call to print next book in stack
        PrintStack(books);
        books.push(bookOnTop);
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        int AA = 1;
        ArrayList<String> lines = new ArrayList<>();
        Stack<Book> stackOfBooks = new Stack<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = input.nextLine().trim();
        System.out.println(" ");


        File myFile = new File(fileName);
        Scanner reader = new Scanner(myFile);

        try (reader) {
            while ( reader.hasNextLine() ) {
                String line = reader.nextLine();
                lines.add(line);

                String[] details = line.trim().split(" ");

                String[] titleArray = details[0].split("_");
                String title = String.join(" ", titleArray);
                String author = details[1]+" "+details[2];
                String yearPublished = details[4];
                String category = details[3];
                String serialNo = author.substring(0, 2) + yearPublished + title.substring(0, 2) + "00" + AA;
                AA++;
                stackOfBooks.push(new Book(title, author, yearPublished, category, serialNo.toUpperCase()));
            }
            PrintStack(stackOfBooks);
            System.out.println(fileName + " contains: " + lines.get(0) + " and " + lines.get(1) + "as the data in different lines [See sample file]");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
