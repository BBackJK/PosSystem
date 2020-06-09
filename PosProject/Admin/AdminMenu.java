package PosProject.Admin;

import java.util.Scanner;

public class AdminMenu {
    private Scanner sc = new Scanner(System.in);
    private AdminClient adminClient = new AdminClient();

    public void adminHome() {
        int menu;

        do {
            System.out.println("===== 관리자 메인 메뉴 =====");
            System.out.println();
            System.out.println("1. 직원 관리");
            System.out.println("2. 재고 관리");
            System.out.println("3. 매출 통계");
            System.out.println("4. 월급 관리");
            System.out.println("0. 로그아웃");
            System.out.print("# 메뉴선택 >> ");
            menu = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (menu) {
                case 1: // 직원 관리
                    this.adminManageEmployee();
                    break;
                case 2: // 재고 관리
                    this.adminManageStock();
                    break;
                case 3: // 매출 통계
                    this.adminSalesStatistics();
                    break;
                case 4: // 월급 관리
                    this.adminManagePayCheck();
                    break;
                case 0: // 관리자 로그아웃
                    System.out.println();
                    System.out.println(" 관리자 로그아웃 ");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println(" 잘못누르셨습니다. 확인하시고 다시 눌러주세요! ");
                    System.out.println();
                    break;
            }
        } while (menu != 0);
    }

    public void adminManageEmployee() {
        int menu = 0;

        do {
            System.out.println("===== 관리자 직원 관리 메뉴 =====");
            System.out.println();
            System.out.println("1. 직원 등록");
            System.out.println("2. 직원 조회");
            System.out.println("3. 직원 삭제");
            System.out.println("0. 이전 메뉴");
            System.out.print("# 메뉴선택 >> ");
            menu = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (menu) {
                case 1: // 직원 등록
                    adminClient.adminAddEmployee();
                    break;
                case 2: // 직원 조회
                    adminClient.adminCheckEmployee();
                    break;
                case 3: // 직원 삭제
                    adminClient.adminRemoveEmployee();
                    break;
                case 0:
                    System.out.println();
                    System.out.println(" 이전 메뉴로 돌아갑니다. ");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println(" 잘못누르셨습니다. 확인하시고 다시 눌러주세요! ");
                    System.out.println();
                    break;
            }
        } while (menu != 0);
    }

    public void adminManageStock() {
        int menu = 0;

        do {
            System.out.println("===== 관리자 재고 관리 메뉴 =====");
            System.out.println();
            System.out.println("1. 전체 재고 조회");
            System.out.println("2. 재고 부족 상품 조회");
            System.out.println("3. 상품 추가");
            System.out.println("4. 상품 삭제");
            System.out.println("0. 이전 메뉴");
            System.out.print("# 메뉴선택 >> ");
            menu = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (menu) {
                case 1: // 전체 재고 조회
                    adminClient.adminCheckAllProduct();
                    break;
                case 2: // 재고 부족 상품 조회
                    adminClient.adminCheckLackProduct();
                    break;
                case 3: // 상품 추가
                    adminClient.adminAddProduct();
                    break;
                case 4: // 상품 삭제
                    adminClient.adminRemoveProduct();
                    break;
                case 0:
                    System.out.println();
                    System.out.println(" 이전 메뉴로 돌아갑니다. ");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println(" 잘못누르셨습니다. 확인하시고 다시 눌러주세요! ");
                    System.out.println();
                    break;
            }
        } while (menu != 0);
    }

    public void adminSalesStatistics() {
        int menu = 0;

        do {
            System.out.println("===== 관리자 매출 통계 메뉴 =====");
            System.out.println();
            System.out.println("1. 당월 매출 조회");
            System.out.println("2. 당일 매출 조회");
            System.out.println("0. 이전 메뉴");
            System.out.print("# 메뉴선택 >> ");
            menu = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (menu) {
                case 1: // 당월 매출 조회
                    adminClient.adminCheckMonthSales();
                    break;
                case 2: // 당일 매출 조회
                    adminClient.adminCheckDaySales();
                    break;
                case 0:
                    System.out.println();
                    System.out.println(" 이전 메뉴로 돌아갑니다. ");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println(" 잘못누르셨습니다. 확인하시고 다시 눌러주세요! ");
                    System.out.println();
                    break;
            }
        } while (menu != 0);
    }

    public void adminManagePayCheck() {
        int menu = 0;

        do {
            System.out.println("===== 관리자 월급 관리 메뉴 =====");
            System.out.println();
            System.out.println("1. 직원 출/퇴근 시간 조회");
            System.out.println("2. 직원 시급 조회");
            System.out.println("3. 직원 시급 변경");
            System.out.println("4. 직원 월급 조회");
            System.out.println("0. 이전 메뉴");
            System.out.print("# 메뉴선택 >> ");
            menu = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (menu) {
                case 1: // 직원 출/퇴근 시간 조회
                    adminClient.adminCheckCommute();
                    break;
                case 2: // 직원 월급 조회
                    adminClient.adminCheckMonthlyPay();
                    break;
                case 3: // 직원 시급 조회
                    adminClient.adminCheckHourlyPay();
                    break;
                case 4: // 직원 시급 변경
                    adminClient.adminModifyHourlyPay();
                    break;
                case 0:
                    System.out.println();
                    System.out.println(" 이전 메뉴로 돌아갑니다. ");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println(" 잘못누르셨습니다. 확인하시고 다시 눌러주세요! ");
                    System.out.println();
                    break;
            }
        } while (menu != 0);
    }
}