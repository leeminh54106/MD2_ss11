package demo_baitap;

import java.util.List;
import java.util.Scanner;

public interface ICategory {
    void inputData(List<Category> listCate);
    void displayData();
    void inputName(Scanner scanner, List<Category> listCate);
    void inputStatus(Scanner scanner);
}