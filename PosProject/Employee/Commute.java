package PosProject.Employee;

public class Commute {
    private String loginId;
    private String startTime;
    private String endTime;

    public Commute(String loginId, String startTime, String endTime) {
        this.loginId = loginId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getLoginID() {
        return this.loginId;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setLoginID(String id) {
        this.loginId = id;
    }
    
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOnlyDay() {
        String[] onlyDate = this.startTime.split(" ");

        String[] onlyDay = onlyDate[0].split("-");

        return onlyDay[2];
    }

    public String getOnlyMonth() {
        String[] onlyDate = this.startTime.split(" ");

        String[] onlyMonth = onlyDate[0].split("-");

        return onlyMonth[1];
    }

    public String getOnlyStartTime() {
        String[] onlyTime = this.startTime.split(" ");

        return onlyTime[1];
    }

    public String getOnlyEndTime() {
        String[] onlyTime = this.endTime.split(" ");

        return onlyTime[1];
    }

    public void print() {
        if (this.endTime.equals("0")) {
            System.out.println("근무자: " + this.loginId + " / 출근 시간: " + this.startTime + " / 퇴근 시간: 아직 근무중입니다." );
        } else {
            System.out.println("근무자: " + this.loginId + " / 출근 시간: " + this.startTime + " / 퇴근 시간: " + this.endTime);
        }
    }
}