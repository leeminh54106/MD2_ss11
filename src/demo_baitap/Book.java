package demo_baitap;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Book implements IBook{
    private String id;
    private String title;
    private String author;
    private int year;
    private String description;
    private Category category;

    public Book() {
    }

    public Book(String id, String title, String author, int year, String description, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public void inputData(List<Book> list, List<Category> listCate) {
        Scanner scanner = new Scanner(System.in);
        inputId(scanner,list);
        inputTitle(scanner,list);
        inputAuthor(scanner);
        inputYear(scanner);
        inputDescription(scanner);
        inputCategory(scanner,listCate);
    }

    @Override
    public void displayData() {
        System.out.println("Book: ");
        System.out.println("\tMã sách: "+id);
        System.out.println("\tTên sách: "+title);
        System.out.println("\tTác giả: "+author);
        System.out.println("\tNăm xuất bản: "+year);
        System.out.println("\tMô tả: "+description);
        System.out.println("\tDanh mục: "+category.getName());
    }

    @Override
    public void inputDataUpdate(List<Book> list, List<Category> listCate) {
        Scanner scanner = new Scanner(System.in);
        inputTitle(scanner,list);
        inputAuthor(scanner);
        inputYear(scanner);
        inputDescription(scanner);
        inputCategory(scanner,listCate);
    }

    @Override
    public void inputId(Scanner scanner, List<Book> list) {
        while (true){
            System.out.println("Nhap vao ma sach: ");
            id = scanner.nextLine();
            if(id.isEmpty() && !id.startsWith("B")){
                System.out.println("Phai nhap ma sach bat dau bang chu B");
            }else if(id.length()!=4){
                System.out.println("Ma sach nhap vao la 4 ki tu");
            }else{
                if(existedId(id,list)){
                    System.out.println("Mã sách này đã tồn tại");
                }else
                    break;
            }
        }
    }

    private boolean existedId(String id, List<Book> list) {
        for(Book b: list){
            if(b.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void inputTitle(Scanner scanner, List<Book> list) {
        while(true){
            System.out.println("Nhap vao tieu de sach: ");
            title = scanner.nextLine();
            if(title.isEmpty()){
                System.out.println("Phai nhap title");
            }else{
                //check do rong:
                if(title.length()<6 || title.length()>50){
                    System.out.println("Title phai tu 6 den 40 ki tu");
                }else{
                    if(checkExistedTitle(title,list)){
                        System.out.println("Title da ton tai");
                    }else{
                        break;
                    }
                }
            }
        }
    }

    private boolean checkExistedTitle(String title, List<Book> list) {
        for(Book b : list){
            if(b.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void inputAuthor(Scanner scanner) {
        while(true){
            System.out.println("Nhap vao ten tac gia: ");
            author = scanner.nextLine();
            if(author.isEmpty()){
                System.out.println("Phai nhap vao author");
            }else{
                break;
            }
        }
    }

    @Override
    public void inputYear(Scanner scanner) {
        while(true){
            System.out.println("Nhap vao nam xuat ban >=1970: ");
            String strYear = scanner.nextLine();
            //lay nam hien thoi:
            int currentYear = LocalDate.now().getYear();
            if(strYear.compareTo("1970")>0 && strYear.compareTo(""+currentYear)<0 ){
                year = Integer.parseInt(strYear);
                break;
            }else{
                System.out.println("phai nhap nam xuat ban tu 1970 den nam hien tai");
            }
        }
    }

    @Override
    public void inputDescription(Scanner scanner) {
        while(true){
            System.out.println("Nhap vao description: ");
            description = scanner.nextLine();
            if(description.trim().isEmpty()){
                System.out.println("Phai nhap vao description");
            }else{
                break;
            }
        }
    }

    @Override
    public void inputCategory(Scanner scanner, List<Category> listCate) {
        boolean blExist = true;
        while(blExist){
            System.out.println("nhap vao category id:");
            int cateId = Integer.parseInt(scanner.nextLine());
            for(Category c: listCate){
                if(c.getId()==cateId){
                    category = c;
                    blExist = false;
                }
            }
            if(blExist)
                System.out.println("Category id chua co trong list category");
        }
    }
}