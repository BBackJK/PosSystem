package PosProject.Admin;

import java.util.Scanner;

import PosProject.Employee.EmployeeManage;
import PosProject.Product.Product;
import PosProject.Product.ProductManage;
import PosProject.Sales.SalesManage;
import PosProject.Utils.DateOfUtils;

public class AdminClient {

    private Scanner sc = new Scanner(System.in);
    private EmployeeManage employeManage = new EmployeeManage();
    private ProductManage productManage = new ProductManage();
    private SalesManage salesManage = new SalesManage();
    private DateOfUtils dayUtils = new DateOfUtils();

    // 관리자 직원 관리
    public void adminAddEmployee() {
        System.out.println("===== 관리자 직원 추가 =====");
        System.out.println();
        System.out.print("직원의 ID(이름)을 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("직원의 PW(생년월일)을 입력하세요: ");
        String pw = sc.nextLine();
        employeManage.add(id, pw);
        employeManage.save();
        System.out.println();
        System.out.println(id + " 님이 등록 되었습니다.");
        System.out.println();
    }

    public void adminCheckEmployee() {
        System.out.println("===== 관리자 직원 확인 =====");
        System.out.println();
        employeManage.print();
        System.out.println();
    }

    public void adminRemoveEmployee() {
        System.out.println("===== 관리자 직원 삭제 =====");
        System.out.println();
        System.out.print("삭제할 직원의 ID(이름)을 입력하세요: ");
        String id = sc.nextLine();
        System.out.println();
        if (!employeManage.idCheck(id)) {
            System.out.println("존재하지 않은 직원입니다. 다시 확인해 주세요.");
            System.out.println();
            return;
        }
        employeManage.remove(id);
        employeManage.save();
        System.out.println("입력하신 직원 " + id + " 가 삭제 되었습니다.");
        System.out.println();
    }

    // 관리자 재고 관리
    public void adminCheckAllProduct() {
        System.out.println("===== 관리자 전체 상품 조회 =====");
        System.out.println();
        System.out.println("<상품코드>");
        System.out.println("(1)과자 (2)음료 (3)즉석식품 (4)주류 (5)담배");
        System.out.println();
        System.out.print("재고를 확인하실 상품코드를 입력해주세요: ");
        int keyWord = Integer.parseInt(sc.nextLine());
        System.out.println();
        if (keyWord == 0 || keyWord > 5) {
            System.out.println("잘못 누르셨습니다. 1번 ~ 5번까지 입니다.");
            System.out.println();
        }

        productManage.codeOfProductPrint(Integer.toString(keyWord));
        System.out.println();
    }

    public void adminCheckLackProduct() {
        System.out.println("===== 관리자 재고 부족 상품 조회 =====");
        System.out.println();
        productManage.lackOfProductPrint();
        System.out.println();
    }

    public void adminAddProduct() {
        System.out.println("===== 관리자 상품 등록 =====");
        System.out.println();
        System.out.print("상품명을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("상품가격을 입력하세요: ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.print("상품코드를 입력하세요: ");
        String code = sc.nextLine();
        System.out.print("상품수량을 입력하세요: ");
        int number = Integer.parseInt(sc.nextLine());
        productManage.add(new Product(name, price, code, number));
        productManage.save();
        System.out.println();
        System.out.println("새로운 상품 " + name + " 이(가) 등록되었습니다.");
        System.out.println();
    }

    public void adminRemoveProduct() {
        System.out.println("===== 관리자 상품 삭제 =====");
        System.out.println();
        System.out.print("삭제하실 상품명을 입력하세요: ");
        String name = sc.nextLine();
        System.out.println();

        if (!productManage.nameCheck(name)) {
            System.out.println("존재하지 않은 상품입니다. 다시 확인해 주세요.");
            System.out.println();
            return;
        }

        productManage.remove(name);
        productManage.save();
        System.out.println("입력하신 상품 " + name + " 가 삭제되었습니다.");
        System.out.println();
    }

    // 관리자 매출 조회
    public void adminCheckMonthSales() {
        System.out.println("===== 관리자 월별 매출 조회 =====");
        System.out.println();
        System.out.print("조회하실 [월]을 입력해주세요(ex. 05): ");
        String month = sc.nextLine();
        System.out.println();

        if (Integer.parseInt(month) > 12) {
            System.out.println();
            System.out.println("잘못 입력하셨습니다. [월]과 [일]을 확인해주세요!");
            System.out.println();
        }

        int totalMonthSales = salesManage.monthTotalSalesPrint(month);

        if (totalMonthSales == 0) {
            System.out.println();
            System.out.println(month + " 월에는 개시를 하지 않았거나 장사가 너무 안돼서 판매액이 0원입니다.");
            System.out.println();
        }

        System.out.println(month + " 월 판매액: " + totalMonthSales);
        System.out.println();
    }

    public void adminCheckDaySales() {
        System.out.println("===== 관리자 일별 매출 조회 =====");
        System.out.println();
        System.out.print("조회하실 [월]을 입력해주세요(ex. 05): ");
        String month = sc.nextLine();
        System.out.println();
        System.out.print("조회하실 [일]을 입력해주세요(ex. 05): ");
        String day = sc.nextLine();

        if (Integer.parseInt(month) > 12 || Integer.parseInt(day) > 31) {
            System.out.println();
            System.out.println("잘못 입력하셨습니다. [월]과 [일]을 확인해주세요!");
            System.out.println();
        }

        System.out.println();
        salesManage.monthDayOfPrint(day, month);
        System.out.println();
    }

    // 관리자 직원 월급 관리
    public void adminCheckCommute() {
        System.out.println(" 직원 출/퇴근 시간 조회 메뉴 ");
    }

    public void adminCheckMonthlyPay() {
        System.out.println(" 직원 월급 조회 메뉴 ");
    }

    public void adminCheckHourlyPay() {
        System.out.println(" 직원 시급 관리 메뉴 ");
    }

    public void adminModifyHourlyPay() {
        System.out.println(" 직원 시급 변경 메뉴 ");
    }
}