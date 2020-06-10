package PosProject.Admin;

import java.util.Scanner;

import PosProject.Main;
import PosProject.Employee.CommuteManage;
import PosProject.Employee.Employee;
import PosProject.Employee.EmployeeManage;
import PosProject.Product.Product;
import PosProject.Product.ProductManage;
import PosProject.Sales.SalesManage;

public class AdminClient {

    private Scanner sc = new Scanner(System.in);
    
    private EmployeeManage employeeManage = Main.employeeManage;
    private ProductManage productManage = Main.productManage;
    private SalesManage salesManage = Main.salesManage;
    private CommuteManage commuteManage = Main.commuteManage;

    // 관리자 직원 관리
    public void adminAddEmployee() {
        System.out.println("===== 관리자 직원 추가 =====");
        System.out.println();
        System.out.print("직원의 ID(이름)을 입력하세요: ");
        String id = this.sc.nextLine();
        System.out.print("직원의 PW(생년월일)을 입력하세요: ");
        String pw = this.sc.nextLine();
        this.employeeManage.add(new Employee(id, pw, 6580));
        this.employeeManage.save();
        System.out.println();
        System.out.println(id + " 님이 등록 되었습니다.");
        System.out.println();
    }

    public void adminCheckEmployee() {
        System.out.println("===== 관리자 직원 확인 =====");
        System.out.println();
        this.employeeManage.print();
        System.out.println();
    }

    public void adminRemoveEmployee() {
        System.out.println("===== 관리자 직원 삭제 =====");
        System.out.println();
        System.out.print("삭제할 직원의 ID(이름)을 입력하세요: ");
        String id = this.sc.nextLine();
        System.out.println();
        if (!this.employeeManage.idCheck(id)) {
            System.out.println("존재하지 않은 직원입니다. 다시 확인해 주세요.");
            System.out.println();
            return;
        }
        this.employeeManage.remove(id);
        this.employeeManage.save();
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
        int keyWord = Integer.parseInt(this.sc.nextLine());
        System.out.println();
        if (keyWord == 0 || keyWord > 5) {
            System.out.println("잘못 누르셨습니다. 1번 ~ 5번까지 입니다.");
            System.out.println();
        }

        this.productManage.codeOfProductPrint(Integer.toString(keyWord));
        System.out.println();
    }

    public void adminCheckLackProduct() {
        System.out.println("===== 관리자 재고 부족 상품 조회 =====");
        System.out.println();
        this.productManage.lackOfProductPrint();
        System.out.println();
    }

    public void adminAddProduct() {
        System.out.println("===== 관리자 상품 등록 =====");
        System.out.println();
        System.out.print("상품명을 입력하세요: ");
        String name = this.sc.nextLine();
        System.out.print("상품가격을 입력하세요: ");
        int price = Integer.parseInt(this.sc.nextLine());
        System.out.print("상품코드를 입력하세요: ");
        String code = this.sc.nextLine();
        System.out.print("상품수량을 입력하세요: ");
        int number = Integer.parseInt(this.sc.nextLine());
        this.productManage.add(new Product(name, price, code, number));
        this.productManage.save();
        System.out.println();
        System.out.println("새로운 상품 " + name + " 이(가) 등록되었습니다.");
        System.out.println();
    }

    public void adminRemoveProduct() {
        System.out.println("===== 관리자 상품 삭제 =====");
        System.out.println();
        System.out.print("삭제하실 상품명을 입력하세요: ");
        String name = this.sc.nextLine();
        System.out.println();

        if (!this.productManage.nameCheck(name)) {
            System.out.println("존재하지 않은 상품입니다. 다시 확인해 주세요.");
            System.out.println();
            return;
        }

        this.productManage.remove(name);
        this.productManage.save();
        System.out.println("입력하신 상품 " + name + " 가 삭제되었습니다.");
        System.out.println();
    }

    // 관리자 매출 조회
    public void adminCheckMonthSales() {
        System.out.println("===== 관리자 월별 매출 조회 =====");
        System.out.println();
        System.out.print("조회하실 [월]을 입력해주세요(ex. 05): ");
        String month = this.sc.nextLine();
        System.out.println();

        if (Integer.parseInt(month) > 12) {
            System.out.println();
            System.out.println("잘못 입력하셨습니다. [월]과 [일]을 확인해주세요!");
            System.out.println();
        }

        int totalMonthSales = this.salesManage.monthTotalSalesPrint(month);

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
        String month = this.sc.nextLine();
        System.out.println();
        System.out.print("조회하실 [일]을 입력해주세요(ex. 05): ");
        String day = this.sc.nextLine();

        if (Integer.parseInt(month) > 12 || Integer.parseInt(day) > 31) {
            System.out.println();
            System.out.println("잘못 입력하셨습니다. [월]과 [일]을 확인해주세요!");
            System.out.println();
        }

        System.out.println();
        this.salesManage.monthDayOfPrint(day, month);
        System.out.println();
    }

    // 관리자 직원 월급 관리
    public void adminCheckCommute() {
        System.out.println("===== 관리자 직원 출/퇴근 시간 조회 =====");
        System.out.println();
        System.out.print("조회하고 싶은 직원의 이름을 입력해주세요: ");
        String name = this.sc.nextLine();
        if(!this.commuteManage.checkName(name)) {
            System.out.println();
            System.out.println("해당 직원은 없습니다. 다시 확인하시고 입력해주세요.");
            System.out.println();
            return;
        }
        
        System.out.print("조회하실 [월]을 입력해주세요(ex. 05): ");
        String month = this.sc.nextLine();
        System.out.print("조회하실 [일]을 입력해주세요(ex. 05): ");
        String day = this.sc.nextLine();

        System.out.println();
        this.commuteManage.monthAndDayPrint(name, month, day);
        System.out.println();

    }

    public void adminCheckMonthlyPay() {
        System.out.println("===== 관리자 직원 월급 조회 =====");
        System.out.println();
        System.out.print("조회하고 싶은 직원의 ID을 입력해주세요: ");
        String id = this.sc.nextLine();
        if(!this.commuteManage.checkName(id)) {
            System.out.println();
            System.out.println("해당 직원은 없습니다. 다시 확인하시고 입력해주세요.");
            System.out.println();
            return;
        }
        System.out.print("조회하실 [월]을 입력해주세요(ex. 05): ");
        String month = this.sc.nextLine();

        System.out.println();
        double hour = this.commuteManage.checkMonthlyTime(id, month);
        int hourlyPay = this.employeeManage.getEmployeeHourlyPay(id);
        System.out.println(id + " 님의 시급: " + hourlyPay );
        System.out.println("총 근무시간: " + hour);
        System.out.println(id + " 님의 총 월급: " + hour * hourlyPay);
        System.out.println();
    }

    public void adminCheckHourlyPay() {
        System.out.println(" 직원 시급 관리 메뉴 ");
    }

    public void adminModifyHourlyPay() {
        System.out.println(" 직원 시급 변경 메뉴 ");
    }
}