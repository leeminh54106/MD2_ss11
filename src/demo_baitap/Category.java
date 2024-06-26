package demo_baitap;

import com.sun.security.jgss.GSSUtil;

import java.util.List;
import java.util.Scanner;

public class Category implements ICategory{
    private  int id;
    private String name;
    private boolean status;

    public Category() {
    }

    public Category(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(List<Category> listCate) {
        Scanner scanner = new Scanner(System.in);
        inputName(scanner, listCate);
        inputStatus(scanner);
    }

    @Override
    public void displayData() {
        System.out.println("Category: ");
        System.out.println("\tId: "+id);
        System.out.println("\tName: "+name);
        System.out.println("\tStatus: "+(status?"Active":"Inactive"));
    }

    @Override
    public void inputName(Scanner scanner, List<Category> listCate) {
        while(true){
            System.out.println("Nhap vao ten the loai (6-30 ki tu): ");
            name = scanner.nextLine();
            if(name.length()<6 || name.length()>30){
                System.out.println("Ten the loai phai tu 6 den 30 ki tu");
            }else{
                if(existedName(name, listCate)){
                    System.out.println("Tên bị trùng, nhập lại");
                }else
                    break;
            }
        }
    }

    private boolean existedName(String name, List<Category> listCate) {
        for(Category c: listCate){
            if(c.getName().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    @Override
    public void inputStatus(Scanner scanner) {
        while(true){
            System.out.println("Nhap vao trang thai: ");
            String str = scanner.nextLine();
            if(str.isEmpty()){
                System.out.println("Status phai duoc nhap vao");
            }else{
                if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false")){
                    status = Boolean.parseBoolean(str);
                    break;
                }else{
                    System.out.println("Status phai nhap vao true hoac false");
                }
            }
        }
    }
}