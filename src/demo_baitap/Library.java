package demo_baitap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose;

        List<Category> listCate = new ArrayList<>();
        List<Book> listBook = new ArrayList<>();

        while(true){
            System.out.println("➢ ===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Quản lý thế loại");
            System.out.println("2. Quản lý Sách");
            System.out.println("3. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    quanLyTheLoai(listCate, listBook);
                    break;
                case 2:
                    quanLySach(listBook, listCate);
                    break;
                default:
                    System.out.println("Bạn phải nhập vào 1 hoặc 2");
            }
        }
    }

    private static void quanLySach(List<Book> listBook, List<Category> listCate) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        boolean flag = true;
        while(flag){
            System.out.println("➢ ===== QUẢN LÝ SÁCH =====");
            System.out.println("1. Thêm mới sách");
            System.out.println("2. Cập nhật thông tin sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Hiển thị danh sách sách theo nhóm thể loại");
            System.out.println("6. Quay lại");
            System.out.println("Lựa chọn của bạn: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    addNewBook(listBook, listCate);
                    break;
                case 2:
                    updateBook(listBook, listCate);
                    break;
                case 3:
                    deleteBook(listBook);
                    break;
                case 4:
                    searchBook(listBook);
                    break;
                case 5:
                    showBookByCategory(listBook, listCate);
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Bạn phải nhập vào 1 den 6");
            }
        }
    }

    private static void showBookByCategory(List<Book> listBook, List<Category> listCate) {
        System.out.println("Danh sách sách theo thể loại:");
        for(Category c: listCate){
            System.out.println("Thể loại: "+c.getName());
            for(Book b: listBook){
                if(b.getCategory().getId()==c.getId()){
                    b.displayData();
                }
            }
            System.out.println("-------------");
        }
    }

    private static void searchBook(List<Book> listBook) {
        System.out.println("Nhập tên sách hoặc tên tác giả cần tim: ");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();

        boolean blExisted = false;
        for(Book b: listBook) {
            if (b.getTitle().contains(search) || b.getAuthor().contains(search)) {
                blExisted = true;
                b.displayData();
            }
        }
        if(!blExisted)
            System.out.println("Không tìm thấy thông tin nào!");
    }

    private static void deleteBook(List<Book> listBook) {
        System.out.println("Nhập mã sách cần xóa: ");
        Scanner scanner = new Scanner(System.in);
        String bookId = scanner.nextLine();

        boolean blExisted = false;
        for(Book b: listBook) {
            if (b.getId().equals(bookId)) {
                blExisted = true;
                listBook.remove(b);
                break;
            }
        }
        if(!blExisted)
            System.out.println("Không tồn tại mã sách: "+bookId);
    }

    private static void updateBook(List<Book> listBook, List<Category> listCate) {
        System.out.println("Nhập mã sách cần cập nhật: ");
        Scanner scanner = new Scanner(System.in);
        String bookId = scanner.nextLine();

        boolean blExisted = false;
        for(Book b: listBook){
            if(b.getId().equals(bookId)){
                blExisted = true;
                System.out.println("Nhập thông tin sách cập nhật: ");
                b.inputDataUpdate(listBook,listCate);
                System.out.println("Đã cập nhật thành công");
            }
        }
        if(!blExisted)
            System.out.println("Không tồn tại mã sách: "+bookId);
    }

    private static void addNewBook(List<Book> listBook, List<Category> listCate) {
        Book b = new Book();
        b.inputData(listBook,listCate);
        listBook.add(b);
        System.out.println("Đã thêm mới sách: "+b.getTitle());
    }

    private static void quanLyTheLoai(List<Category> listCate, List<Book> listBook) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        boolean flag = true;
        while(flag){
            System.out.println("➢ ===== QUẢN LÝ THỂ LOẠI =====");
            System.out.println("1. Thêm mới thể loại");
            System.out.println("2. Hiển thị danh sách theo tên thể loại A – Z");
            System.out.println("3. Thống kê thể loại và số sách có trong mỗi thể loại");
            System.out.println("4. Cập nhật thể loại");
            System.out.println("5. Xóa thể loại (kiểm tra tồn tai sách trước khi xóa)");
            System.out.println("6. Quay lại");
            System.out.println("Lựa chọn của bạn: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    addNewCategory(listCate);
                    break;
                case 2:
                    sortByNameAndDisplay(listCate);
                    break;
                case 3:
                    statisticalCategoryAndBook(listCate,listBook);
                    break;
                case 4:
                    updateCategory(listCate);
                    break;
                case 5:
                    deleteCategory(listCate,listBook);
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Bạn phải nhập vào 1 den 6");
            }
        }
    }

    private static void deleteCategory(List<Category> listCate, List<Book> listBook) {
        int cateId;
        System.out.println("Nhập mã thể loại cần xóa: ");
        Scanner scanner = new Scanner(System.in);
        cateId = Integer.parseInt(scanner.nextLine());

        boolean existed = false;
        boolean bookExisted = false;
        for(Category c : listCate){
            if(c.getId()==cateId){
                existed = true;

                //kiem tra book co id nay khong
                for(Book b: listBook){
                    if(b.getCategory().getId()==cateId){
                        bookExisted = true;
                        break;
                    }
                }
                if(!bookExisted){
                    listCate.remove(c);
                    System.out.println("Đã xóa danh mục: "+c.getName());
                    break;
                }else{
                    System.out.println("Danh mục này đang có sách, không thể xóa");
                    break;
                }
            }
        }

        if(!existed){
            System.out.println("Không có mã danh mục này trong danh saách");
        }
    }

    private static void updateCategory(List<Category> listCate) {
        int cateId;
        System.out.println("Nhap ma the loại cần câp nhập: ");
        Scanner scanner = new Scanner(System.in);
        cateId = Integer.parseInt(scanner.nextLine());
        boolean existed = false;
        for(Category c: listCate){
            if(c.getId()==cateId){
                System.out.println("Nhập thông tin danh mục cần cập nhật: ");
                c.inputData(listCate);
                System.out.println("Đã cập nhật thông tin danh mục");
                existed = true;
                break;
            }
        }
        if(!existed){
            System.out.println("Không có mã danh mục này trong danh sách");
        }
    }

    private static void statisticalCategoryAndBook(List<Category> listCate, List<Book> listBook) {
        System.out.println("Tổng số thể loại: "+listCate.size());
        for(Category c: listCate){
            System.out.println("Thể loại: "+c.getName());
            int total = 0;
            for(Book b: listBook){
                if(b.getCategory().getId()==c.getId()){
                    total++;
                }
            }
            System.out.println("\tTổng số sách trong thể loại: "+total);
        }
    }

    private static void sortByNameAndDisplay(List<Category> listCate) {
        listCate.sort(new CategoryNameCompator());
        System.out.println("Danh sách thể loại sắp xếp từ A-Z");
        for(Category c: listCate){
            c.displayData();
        }
    }

    private static void addNewCategory(List<Category> listCate) {
        int id;
        if(listCate.isEmpty()){
            id = 1;
        }else{
            id = listCate.get(listCate.size()-1).getId()+1;
        }

        Category c = new Category();
        c.setId(id);
        c.inputData(listCate);
        listCate.add(c);
    }
}