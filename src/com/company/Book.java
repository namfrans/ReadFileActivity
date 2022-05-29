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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerial(String serial) {
        SerialNo = serial;
    }

    @Override
    public String toString() {
        return
                "Title: " + Title + "\nAuthor: " + Author + "\nYear Published: " + Year + "\nCategory: " + Category + "\nSerial No.: " + SerialNo;
    }
}
