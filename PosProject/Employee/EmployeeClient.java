package PosProject.Employee;

import java.util.Scanner;

import PosProject.Product.ProductManage;
import PosProject.Sales.Sales;
import PosProject.Sales.SalesManage;
import PosProject.Utils.DateOfUtils;

public class EmployeeClient {
    private ProductManage productManage = new ProductManage();
    private SalesManage salesManage = new SalesManage();
    private DateOfUtils dateUtils = new DateOfUtils();
    private Scanner sc = new Scanner(System.in);

    int totalTodaySales = 0;

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

        productManage.codeOfProductPrint(Integer.toString(keyWord));
        System.out.println();
        System.out.print("판매할 상품명을 입력하세요: ");
        String name = sc.nextLine();
        if (!productManage.nameCheck(name)) {
            System.out.println();
            System.out.println("존재하지 않은 상품입니다. 다시 확인해 주세요.");
            System.out.println();
            return;
        }

        System.out.print("수량을 입력해주세요: ");
        int saleAmount = Integer.parseInt(sc.nextLine());
        int sales = productManage.saleProduct(name, saleAmount);
        productManage.save();
        totalTodaySales += sales;
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

        productManage.codeOfProductPrint(Integer.toString(keyWord));
        System.out.println();
    }

    public void employeeCheckLackProduct() {
        System.out.println("===== 직원 재고 부족 상품 조회 =====");
        System.out.println();
        productManage.lackOfProductPrint();
        System.out.println();
    }

    public void employeeOrderProduct() {
        System.out.println("===== 직원 상품 발주 =====");
        System.out.println();
        System.out.print("발주하실 상품명을 입력해주세요: ");
        String name = sc.nextLine();
        if (!productManage.nameCheck(name)) {
            System.out.println();
            System.out.println("존재하지 않은 상품입니다. 다시 확인해 주세요.");
            System.out.println();
            return;
        }

        System.out.print("발주하실 수량을 입력해주세요: ");
        int orderAmount = Integer.parseInt(sc.nextLine());
        System.out.println();
        productManage.orderProduct(name, orderAmount);
        productManage.save();
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
        System.out.println("현재까지 판매액은 " + totalTodaySales + " 입니다.");
        System.out.println();
    }

    public void employeeRecordTotalSales() {
        System.out.println("===== 직원 금일 매출 기록 =====");
        System.out.println();
        System.out.println("오늘 날짜: " + dateUtils.getToday());
        System.out.println("오늘 총 매출액: " + totalTodaySales);
        System.out.println();
        salesManage.add(new Sales(dateUtils.getToDate(), totalTodaySales));
        salesManage.save();
        System.out.println("오늘 매출액이 기록 되었습니다.");
        System.out.println();
    }
}