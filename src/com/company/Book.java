package com.company;

public class Book {
    String Title, Author, Year, Category, SerialNo;

    public Book(String title, String author, String year, String category, String serial_no) {
        Title = title;
        Author = author;
        Year = year;
        Category = category;
        SerialNo = serial_no;
    }

    @Override
    public String toString() {
        return
                "Title: " + Title + "\nAuthor: " + Author + "\nYear Published: " + Year + "\nCategory: " + Category + "\nSerial No.: " + SerialNo;
    }
}
