package model;

public enum EmployeeRoleType {

     PROJECT_LEADER("A", 6),
     ANALYST("B",3),
     DEVELOPER("B", 3),
    Tester("C", 1);


    private final String salary;
       private final int notice;

       private EmployeeRoleType(String salary, int notice){

           this.salary = salary;
           this.notice = notice;

       }

    private int getNotice() {
        return this.notice;
    }

    private String getSalary() {
        return this.salary;
    }
}
