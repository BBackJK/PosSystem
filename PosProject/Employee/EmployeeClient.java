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
    private CommuteManage commuteManage = Main.commuteManage;
    private String loginId = null;
    private int totalTodaySales = 0;
    private String startTime = "0";
    private String endTime = "0";

    // 직원 상품 판매
    public void employeeSaleProduct() {
        System.out.println("===== 직원 상품 판매 =====");
        System.out.println();
        System.out.println("<상품코드>");
        System.out.println("(1)과자 (2)음료 (3)즉석식품 (4)주류 (5)담배");
        System.out.println();
        System.out.print("상품코드를 입력해주세요: ");
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
        int keyWord;
        do {
            System.out.println("===== 직원 전체 상품 조회 =====");
            System.out.println();
            System.out.println("<상품코드>");
            System.out.println("(1)과자 (2)음료 (3)즉석식품 (4)주류 (5)담배 (0)조회 종료");
            System.out.println();
            System.out.print("재고를 확인하실 상품코드를 입력해주세요: ");
            keyWord = Integer.parseInt(sc.nextLine());
            System.out.println();
            if (keyWord > 5) {
                System.out.println("잘못 누르셨습니다. 1번 ~ 5번까지 입니다.");
                System.out.println();
            }
            
            if (keyWord == 0) {
                return;
            }

            this.productManage.codeOfProductPrint(Integer.toString(keyWord));
            System.out.println();
        } while (keyWord != 0);
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
    public void employeeRecordWorkStartTime(String loginId) {
        this.loginId = loginId;
        System.out.println("===== 직원 출근 시간 기록 =====");
        System.out.println();
        this.startTime = this.dateUtils.getToDate();
        this.commuteManage.add(new Commute(this.loginId, this.startTime, this.endTime));
        this.commuteManage.save();
        System.out.println(this.loginId + " 님 출근 시간이 기록 되었습니다.");
        System.out.println();
    }

    public void employeeRecordWorkEndTime() {
        System.out.println("===== 직원 퇴근 시간 기록 =====");
        System.out.println();
        if (this.startTime == "0") {
            System.out.println("출근 시간부터 기록해주세요!");
            System.out.println();
            return;
        }
        this.endTime = this.dateUtils.getToDate();
        this.commuteManage.setEndTime(this.loginId, this.startTime, this.endTime);
        this.commuteManage.save();
        this.startTime = "0";
        this.endTime = "0";
        System.out.println(this.loginId + " 님 퇴근 시간이 기록 되었습니다.");
        System.out.println();
    }

    public void employeeWantToStartTime(String loginId) {
        this.loginId = loginId;
        System.out.println("===== 직원 출근 시간 기록 =====");
        System.out.println();
        System.out.print("년도(YYYY)를 입력해주세요: ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("월(MM)을 입력해주세요: ");
        int month = Integer.parseInt(sc.nextLine());
        System.out.print("일(DD)을 입력해주세요: ");
        int day = Integer.parseInt(sc.nextLine());
        System.out.print("시(HH)를 입력해주세요: ");
        int hour = Integer.parseInt(sc.nextLine());
        System.out.print("분(MM)를 입력해주세요: ");
        int minute = Integer.parseInt(sc.nextLine());
        System.out.println();
        this.startTime = this.dateUtils.wantToDate(year, month, day, hour, minute);
        this.commuteManage.add(new Commute(this.loginId, this.startTime, this.endTime));
        this.commuteManage.save();
        System.out.println(this.loginId + " 님 출근 시간이 기록 되었습니다.");
        System.out.println();
    }

    public void employeeWantToEndTime() {
        System.out.println("===== 직원 퇴근 시간 기록 =====");
        System.out.println();
        if (this.startTime == "0") {
            System.out.println("출근 시간부터 기록해주세요!");
            System.out.println();
            return;
        }
        System.out.print("년도(YYYY)를 입력해주세요: ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("월(MM)을 입력해주세요: ");
        int month = Integer.parseInt(sc.nextLine());
        System.out.print("일(DD)을 입력해주세요: ");
        int day = Integer.parseInt(sc.nextLine());
        System.out.print("시(HH)를 입력해주세요: ");
        int hour = Integer.parseInt(sc.nextLine());
        System.out.print("분(MM)를 입력해주세요: ");
        int minute = Integer.parseInt(sc.nextLine());
        System.out.println();
        this.endTime = this.dateUtils.wantToDate(year, month, day, hour, minute);
        this.commuteManage.setEndTime(this.loginId, this.startTime, this.endTime);
        this.commuteManage.save();
        this.startTime = "0";
        this.endTime = "0";
        System.out.println(this.loginId + " 님 퇴근 시간이 기록 되었습니다.");
        System.out.println();
    }

    // 직원 마감 정산
    public void employeeCheckCurrentSales() {
        System.out.println("===== 직원 정산 확인 =====");
        System.out.println();
        System.out.println("안녕하세요. " + this.loginId + " 님");
        System.out.println();
        System.out.println("현재까지 판매액은 " + this.totalTodaySales + " 입니다.");
        System.out.println();
    }

    public void employeeRecordTotalSales() {
        System.out.println("===== 직원 금일 매출 기록 =====");
        System.out.println();
        String today = this.dateUtils.getToday();
        System.out.println("오늘 날짜: " + today);
        System.out.println("오늘 총 매출액: " + this.totalTodaySales);
        System.out.println();
        this.salesManage.add(new Sales(today, this.totalTodaySales, this.loginId));
        this.salesManage.save();
        this.totalTodaySales = 0;
        System.out.println("오늘 매출액이 기록 되었습니다.");
        System.out.println();
    }

    public void employeeWantToRecord() {
        System.out.println("===== 직원 금일 매출 기록 =====");
        System.out.println();
        System.out.print("년도(YYYY)를 입력해주세요: ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("월(MM)을 입력해주세요: ");
        int month = Integer.parseInt(sc.nextLine());
        System.out.print("일(DD)을 입력해주세요: ");
        int day = Integer.parseInt(sc.nextLine());
        System.out.print("매출 금액을 입력해주세요: ");
        int wantToPay = Integer.parseInt(sc.nextLine());
        System.out.println();
        String today = this.dateUtils.wantToDay(year, month, day);
        System.out.println("지정한 날짜: " + today);
        System.out.println("오늘 총 매출액: " + wantToPay);
        System.out.println();
        this.salesManage.add(new Sales(today, wantToPay, this.loginId));
        this.salesManage.save();
        System.out.println("오늘 매출액이 기록 되었습니다.");
        System.out.println();
    }
}