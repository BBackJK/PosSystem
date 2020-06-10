package PosProject.Employee;

import java.util.Scanner;

import PosProject.Main;
import PosProject.Product.ProductManage;
import PosProject.Sales.Sales;
import PosProject.Sales.SalesManage;
import PosProject.Utils.DateOfUtils;

public class EmployeeClient {

    private DateOfUtils dateUtils = new DateOfUtils();
    private Scanner sc = new Scanner(System.in);

    private ProductManage productManage = Main.productManage;
    private SalesManage salesManage = Main.salesManage;
    private int totalTodaySales = 0;

    // 직원 상품 판매
    public void employeeSaleProduct() {
        System.out.println("===== 직원 상품 판매 =====");
        System.out.println();
        System.out.println("<상품코드>");
        System.out.println("(1)과자 (2)음료 (3)즉석식품 (4)주류 (5)담배");
        System.out.println();
        System.out.print("상품코드를 입력해주세요:");
        int keyWord = Integer.parseInt(sc.nextLine());
        System.out.println();
        if (keyWord == 0 || keyWord > 5) {
            System.out.println("잘못 누르셨습니다. 1번 ~ 5번까지 입니다.");
            System.out.println();
        }

        this.productManage.codeOfProductPrint(Integer.toString(keyWord));
        System.out.println();
        System.out.print("판매할 상품명을 입력하세요: ");
        String name = this.sc.nextLine();
        if (!this.productManage.nameCheck(name)) {
            System.out.println();
            System.out.println("존재하지 않은 상품입니다. 다시 확인해 주세요.");
            System.out.println();
            return;
        }

        System.out.print("수량을 입력해주세요: ");
        int saleAmount = Integer.parseInt(sc.nextLine());
        int sales = this.productManage.saleProduct(name, saleAmount);
        this.productManage.save();
        this.totalTodaySales += sales;
        System.out.println();
    }

    // 직원 재고 관리
    public void employeeCheckAllProduct() {
        System.out.println("===== 직원 전체 상품 조회 =====");
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

        this.productManage.codeOfProductPrint(Integer.toString(keyWord));
        System.out.println();
    }

    public void employeeCheckLackProduct() {
        System.out.println("===== 직원 재고 부족 상품 조회 =====");
        System.out.println();
        this.productManage.lackOfProductPrint();
        System.out.println();
    }

    public void employeeOrderProduct() {
        System.out.println("===== 직원 상품 발주 =====");
        System.out.println();
        System.out.print("발주하실 상품명을 입력해주세요: ");
        String name = sc.nextLine();
        if (!this.productManage.nameCheck(name)) {
            System.out.println();
            System.out.println("존재하지 않은 상품입니다. 다시 확인해 주세요.");
            System.out.println();
            return;
        }

        System.out.print("발주하실 수량을 입력해주세요: ");
        int orderAmount = Integer.parseInt(sc.nextLine());
        System.out.println();
        this.productManage.orderProduct(name, orderAmount);
        this.productManage.save();
        System.out.println(name + " 상품 발주 완료!");
        System.out.println();
    }

    // 직원 출/퇴근 기록
    public void employeeRecordWorkStartTime() {

    }

    public void employeeRecordWorkEndTime() {

    }

    // 직원 마감 정산
    public void employeeCheckCurrentSales() {
        System.out.println("===== 직원 정산 확인 =====");
        System.out.println();
        System.out.println("현재까지 판매액은 " + this.totalTodaySales + " 입니다.");
        System.out.println();
    }

    public void employeeRecordTotalSales() {
        System.out.println("===== 직원 금일 매출 기록 =====");
        System.out.println();
        System.out.println("오늘 날짜: " + this.dateUtils.getToday());
        System.out.println("오늘 총 매출액: " + this.totalTodaySales);
        System.out.println();
        this.salesManage.add(new Sales(this.dateUtils.getToday(), this.totalTodaySales));
        this.salesManage.save();
        System.out.println("오늘 매출액이 기록 되었습니다.");
        System.out.println();
    }
}