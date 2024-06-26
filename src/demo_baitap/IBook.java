package demo_baitap;

import java.util.List;
import java.util.Scanner;

public interface IBook {
    void inputData(List<Book> list, List<Category> listCate);
    void displayData();
    void inputId(Scanner scanner, List<Book> list);
    void inputTitle(Scanner scanner, List<Book> list);
    void inputAuthor(Scanner scanner);
    void inputYear(Scanner scanner);
    void inputDescription(Scanner scanner);
    void inputCategory(Scanner scanner, List<Category> listCate);
    void inputDataUpdate(List<Book> list, List<Category> listCate);
}