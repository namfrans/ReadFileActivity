package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class InClass {
    public static void PrintStack(Stack<Book> bookStack)
    {

        if (bookStack.empty())
            return;

        Book bookOnTop = bookStack.peek();
        bookStack.pop();
        System.out.print(bookOnTop + "\n");
        PrintStack(bookStack);
        // Push the element back
        bookStack.push(bookOnTop);
    }
    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        int AA = 1;
        ArrayList<String> lines = new ArrayList<>();
        Stack<Book> stackOfBooks = new Stack<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = input.nextLine().trim();


        File myFile = new File(fileName);
        Scanner reader = new Scanner(myFile);

        try (reader) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                lines.add(line);

                String[] details = line.trim().split(" ");

                String[] TitleArr = details[0].split("_");
                String Title = String.join(" ", TitleArr);
                String Author = details[1]+" "+details[2];
                String YearPublished = details[4];
                String Category = details[3];
                String SerialNo = Author.substring(0, 2)+YearPublished+Title.substring(0, 2)+"00"+Integer.toString(AA);
                AA++;
                stackOfBooks.push(new Book(Title, Author, YearPublished, Category, SerialNo.toUpperCase()));
            }
            PrintStack(stackOfBooks);
            System.out.println(fileName +" contains: "+ lines.get(0) +" and "+ lines.get(1) +"as the data in different lines [See sample file]");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
