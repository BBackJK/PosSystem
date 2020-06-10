package PosProject;

import java.util.Scanner;

import PosProject.Admin.AdminMenu;
import PosProject.Employee.CommuteManage;
import PosProject.Employee.EmployeeManage;
import PosProject.Employee.EmployeeMenu;
import PosProject.Product.ProductManage;
import PosProject.Sales.SalesManage;

public class Main {

    public static EmployeeManage employeeManage = new EmployeeManage();
    public static ProductManage productManage = new ProductManage();
    public static SalesManage salesManage = new SalesManage();
    public static CommuteManage commuteManage = new CommuteManage();

    private void login() {
        Scanner sc = new Scanner(System.in);
        
        AdminMenu admin = new AdminMenu();
        EmployeeMenu employee = new EmployeeMenu();

        do {

            System.out.println("===== Pos System =====");
            System.out.println();
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("PW: ");
            String pw = sc.nextLine();
            System.out.println();
            if (id.equals("admin") && pw.equals("admin")) {
                admin.adminHome();
            } else if (employeeManage.loginCheck(id, pw)) {
                employee.employeeHome(id);
            } else {
                System.out.println("입력하신 정보를 가진 직원이 없습니다. 다시 확인해주세요. ");
                System.out.println();
            }

        } while (true);
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.login();
        
    }
}