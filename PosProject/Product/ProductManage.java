package PosProject.Product;

import java.io.*;
import java.util.Vector;

public class ProductManage {
    private Vector<Product> productList = new Vector<Product>();

    public ProductManage() {
        FileReader fr = null;
        try {
            fr = new FileReader("./PosProject/Product/ProductList.txt");
        } catch (FileNotFoundException fnfe) {
            System.out.println("ProductList.txt를 읽을 수 없습니다.");
        }
        BufferedReader br = new BufferedReader(fr);
        String data;
        try {
            while ((data = br.readLine()) != null) {
                String[] p = data.split(" / ");
                this.productList.add(new Product(p[0], Integer.parseInt(p[1]), p[2], Integer.parseInt(p[3])));
            }
        } catch (IOException ioe) {
            System.out.println("ProductList.txt를 readLine()으로 읽을 수 없습니다");
        }
    }

    public void save() { // ProductList 저장
        FileWriter fw = null;
        try {
            fw = new FileWriter("./PosProject/Product/ProductList.txt");
        } catch (IOException ioe) {
            System.out.println("ProductList.txt에 쓸 수 없습니다.");
        }
        PrintWriter pw = new PrintWriter(fw);
        for (Product p : this.productList) {
            String data = p.getName() + " / " + p.getPrice() + " / " + p.getCode() + " / " + p.getNumber();
            pw.println(data);
        }
        pw.flush();

    }

    public void add(Product p) { // 상품추가
        this.productList.add(p);
    }

    public boolean nameCheck(String name) { // 상품명이 존재하는지 확인
        for (Product e : this.productList) {
            if (e.nameEquals(name)) {
                return true;
            }
        }
        return false;
    }

    public void remove(String name) { // 상품 삭제
        for (int i = 0; i < this.productList.size(); i++) {
            if (name.equals(this.productList.get(i).getName())) {
                this.productList.remove(i);
                break;
            }
        }
    }

    public void codeOfProductPrint(String code) { // 상품코드를 입력받아서 출력
        int i = 0;
        for (Product p : this.productList) {
            if (code.equals(p.getCode())) {
                i++;
                p.print();
            }
        }
        if (i == 0) {
            System.out.println("입력하신 상품코드에 등록된 상품이 없습니다.");
        }
    }

    public void lackOfProductPrint() { // 수량 부족한 상품 출력
        int i = 0;
        for (Product p : this.productList) {
            if (p.getNumber() < 10) {
                i++;
                p.print();
            }
        }
        if (i == 0) {
            System.out.println("수량이 부족한 상품이 없습니다.");
        }
    }

    public int saleProduct(String name, int saleAmount) { // 상품 판매
        int idx = 0;
        for (int i = 0; i < this.productList.size(); i++) { // 상품명의 index값 찾기
            if (name.equals(this.productList.get(i).getName())) {
                idx = i;
                break;
            }
        }
        int currentAmount = this.productList.get(idx).getNumber(); // 찾은 상품명의 현재 수량 가져오기
        int productPrice = this.productList.get(idx).getPrice();
        if (currentAmount > saleAmount) {
            this.productList.get(idx).setNumber(currentAmount - saleAmount); // (현재 수량 - 판매 수량)으로 남은 값 셋팅
            System.out.println(name + " 판매 완료!");
            return productPrice * saleAmount; // 총 판매액 return
        } else {
            System.out.println("판매 수량이 재고 수량보다 많습니다. 판매 수량을 조정해주세요");
            return 0; // 판매 못했을 시 return 0;
        }
    }

    public void orderProduct(String name, int orderAmount) { // 상품 발주
        int idx = 0;
        for (int i = 0; i < this.productList.size(); i++) {
            if (name.equals(this.productList.get(i).getName())) {
                idx = i;
                break;
            }
        }
        int currentAmount = this.productList.get(idx).getNumber();
        this.productList.get(idx).setNumber(currentAmount + orderAmount);
    }
}