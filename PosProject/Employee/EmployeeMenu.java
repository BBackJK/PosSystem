package PosProject.Employee;

import java.util.Scanner;

public class EmployeeMenu {
    private Scanner sc = new Scanner(System.in);
    private String id;

    private EmployeeClient employeeClient = new EmployeeClient();

    public void employeeHome(String id) {
        this.id = id;
        int menu;

        System.out.println(this.id + " 님 좋은 하루되세요.");
        System.out.println();

        do {
            System.out.println("===== 직원 메인 메뉴 =====");
            System.out.println();
            System.out.println("1. 상품 판매");
            System.out.println("2. 재고 관리");
            System.out.println("3. 출/퇴근 기록");
            System.out.println("4. 마감 정산");
            System.out.println("0. 로그아웃");
            System.out.print("# 메뉴선택 >> ");
            menu = Integer.parseInt(this.sc.nextLine());
            System.out.println();

            switch (menu) {
                case 1: // 상품 판매
                    this.employeeClient.employeeSaleProduct();
                    break;
                case 2: // 재고 관리
                    this.employeeManageStock();
                    break;
                case 3: // 출퇴근 기록
                    this.employeeRecordCommute();
                    break;
                case 4: // 마감 정산
                    this.employeeManageDeadline();
                    break;
                case 0: // 직원 로그아웃
                    System.out.println();
                    System.out.println(" 직원 로그아웃 ");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("잘못누르셨습니다. 확인하시고 다시 눌러주세요!");
                    System.out.println();
                    break;
            }
        } while (menu != 0);
    }

    public void employeeManageStock() {
        int menu;

        do {
            System.out.println("===== 직원 재고 관리 메뉴 =====");
            System.out.println();
            System.out.println("1. 전체 재고 조회");
            System.out.println("2. 재고 부족 상품 조회");
            System.out.println("3. 상품 발주");
            System.out.println("0. 이전 메뉴");
            System.out.print("# 메뉴선택 >> ");
            menu = Integer.parseInt(this.sc.nextLine());
            System.out.println();

            switch (menu) {
                case 1: // 전체 재고 조회
                    this.employeeClient.employeeCheckAllProduct();
                    break;
                case 2: // 재고 부족 상품 조회
                    this.employeeClient.employeeCheckLackProduct();
                    break;
                case 3: // 상품 발주
                    this.employeeClient.employeeOrderProduct();
                    break;
                case 0: // 이전 메뉴
                    System.out.println();
                    System.out.println(" 이전 메뉴로 돌아갑니다. ");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("잘못누르셨습니다. 확인하시고 다시 눌러주세요!");
                    System.out.println();
                    break;
            }
        } while (menu != 0);
    }

    public void employeeRecordCommute() {
        int menu;

        do {
            System.out.println("===== 직원 출/퇴근 기록 메뉴 =====");
            System.out.println();
            System.out.println("1. 출근 시간 기록");
            System.out.println("2. 퇴근 시간 기록");
            System.out.println("3. (테스트용도)원하는 시간 입력받아서 출근 시간 기록");
            System.out.println("4. (테스트용도)원하는 시간 입력받아서 퇴근 시간 기록");
            System.out.println("0. 이전 메뉴");
            System.out.print("# 메뉴선택 >> ");
            menu = Integer.parseInt(this.sc.nextLine());
            System.out.println();

            switch (menu) {
                case 1: // 출근 시간 기록
                    this.employeeClient.employeeRecordWorkStartTime(this.id);
                    break;
                case 2: // 퇴근 시간 기록
                    this.employeeClient.employeeRecordWorkEndTime();
                    break;
                case 3: // 특정 시간 기록
                    this.employeeClient.employeeWantToStartTime(this.id);
                    break;
                case 4: // 특정 시간 기록
                    this.employeeClient.employeeWantToEndTime();
                    break;
                case 0: // 이전 메뉴
                    System.out.println();
                    System.out.println(" 이전 메뉴로 돌아갑니다. ");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("잘못누르셨습니다. 확인하시고 다시 눌러주세요!");
                    System.out.println();
                    break;
            }
        } while (menu != 0);
    }

    public void employeeManageDeadline() {
        int menu;

        do {
            System.out.println("===== 직원 마감 정산 메뉴 =====");
            System.out.println();
            System.out.println("1. 정산 확인");
            System.out.println("2. 금일 매출 기록");
            System.out.println("3. (테스트용도)원하는 날짜 입력받아서 원하는 매출 기록");
            System.out.println("0. 이전 메뉴");
            System.out.print("# 메뉴선택 >> ");
            menu = Integer.parseInt(this.sc.nextLine());
            System.out.println();

            switch (menu) {
                case 1: // 정산 확인
                    this.employeeClient.employeeCheckCurrentSales();
                    break;
                case 2: // 금일 매출 기록
                    this.employeeClient.employeeRecordTotalSales();
                    break;
                case 3:
                    this.employeeClient.employeeWantToRecord();
                    break;
                case 0: // 이전 메뉴
                    System.out.println();
                    System.out.println(" 이전 메뉴로 돌아갑니다. ");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("잘못누르셨습니다. 확인하시고 다시 눌러주세요!");
                    System.out.println();
                    break;
            }
        } while (menu != 0);
    }

}