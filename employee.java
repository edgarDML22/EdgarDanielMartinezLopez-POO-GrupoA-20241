import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Random;

public class employee {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    // Atributos
    private String birthday, name, lastname, lastname2, RFC, CURP, ROLE, date_of_admission, sex, ID, IDEUSUARIO,
            schedule;
    private int salary;

    List<employee> employees = new ArrayList<employee>();
    List<employee> Maintenance = new ArrayList<employee>();

    // constructor
    public employee(String birthday, String name, String lastname, String lastname2, String RFC, String CURP,
            String ROLE, String date_of_admission, String schedule, int salary, String sex, String ID) {
        this.birthday = birthday;
        this.name = name;
        this.lastname = lastname;
        this.lastname2 = lastname2;
        this.RFC = RFC;
        this.CURP = CURP;
        this.ROLE = ROLE;
        this.date_of_admission = date_of_admission;
        this.schedule = schedule;
        this.salary = salary;
        this.sex = sex;
        this.ID = ID;
    }

    public void addEmployee(String birthday, String name, String lastname, String lastname2, String RFC, String CURP,
            String ROLE, String date_of_admission, String schedule, int salary, String sex, String ID) {
        boolean flag = true;

        while (flag) {
            // SE DA INFORMACION DEL USUARIO
            System.out.println("ENTER EMPLOYEE NAME:");
            name = sc.nextLine();
            System.out.println("ENTER FIRST LAST NAME: ");
            lastname = sc.nextLine();
            System.out.println("ENTER SECOND LASTNAME");
            lastname2 = sc.nextLine();
            birthday = verifyBirthday();// Verifica la edad
            date_of_admission = verifydate_of_admission();// verificar fecha
            System.out.println("ENTER SCHEDULE: ");
            schedule = sc.nextLine();
            System.out.println("ENTER SEX(M/F):");
            sex = sc.nextLine();
            sex = sex.toUpperCase();
            ID = generateID();// Genera un ID
            ROLE = verifyROLE(); // verificar/agregar rol
            salary = addsalary(ROLE); // Se agerga salario dependiendo del rol
            CURP = createCURP(name, lastname, lastname2, birthday, sex);// Se crea CURP basado en los datos
            RFC = createRFC(name, lastname, lastname2, birthday); // Se crea RFC basado en los datos

            // SE AGREGA USUARIO maintenance
            if (ROLE.equals("maintenance")) {
                Maintenance.add(new employee(birthday, name, lastname, lastname2, RFC, CURP, ROLE, date_of_admission,
                        schedule, salary, sex, ID));
            }
            // SE AGREGA USUARIO
            employees.add(new employee(birthday, name, lastname, lastname2, RFC, CURP, ROLE, date_of_admission,
                    schedule, salary, sex, ID));
            System.out.println("DO YOU WANT TO CONTINUE?(y/n) ");
            String as = sc.nextLine();
            as = as.toLowerCase();
            if (as.contains("n")) {
                flag = false;
            }

        }

    }

    public String verifyROLE() {

        boolean flag = true;
        while (flag) {
            System.out.println("ENTER ROLE (veterinarian, guide, maintenance, administration): ");
            ROLE = sc.nextLine();
            if (ROLE.equals("veterinarian") || ROLE.equals("guide") || ROLE.contains("maintenance")
                    || ROLE.contains("administration")) {
                flag = false;
            }
        }

        return ROLE;
    }

    public String generateID() {
        String ID = "";

        int codigoLetra = random.nextInt(26) + 65;
        char letra = (char) codigoLetra;
        ID = String.valueOf(letra);
        for (int i = 0; i < 4; i++) {
            ID = ID + random.nextInt(10);

        }
        return ID;

    }

    public String verifyBirthday() {
        boolean flag = true;
        String birthday = " ";
        while (flag) {
            System.out.println("ENTER BIRDHDAY (month/day/year): ");
            System.out.println("Example: 05/11/2005");
            birthday = sc.nextLine();
            if (birthday.length() >= 8) {
                flag = false;
                for (int i = 0; i < birthday.length(); i++) {
                    char caracter = birthday.charAt(i);

                    if (caracter != '/' && (i == 2 || i == 5)) {
                        System.out.println("INCORRECT DATA ENTRY");
                        flag = true;
                    }
                }
            } else {
                System.out.println("INCORRECT DATA ENTRY");
            }

        }
        return birthday;

    }

    public String verifydate_of_admission() {
        boolean flag = true;
        String verifydate_of_admission = "";
        while (flag) {
            System.out.println("DATE OF ADMISSION(month/day/year): ");
            System.out.println("Example: 05/11/2005");
            verifydate_of_admission = sc.nextLine();
            if (verifydate_of_admission.length() >= 8) {
                flag = false;
                for (int i = 0; i < verifydate_of_admission.length(); i++) {
                    char caracter = verifydate_of_admission.charAt(i);

                    if (caracter != '/' && (i == 2 || i == 5)) {
                        System.out.println("INCORRECT DATA ENTRY");
                        flag = true;
                    }
                }
            } else {
                System.out.println("INCORRECT DATA ENTRY");
            }

        }
        return verifydate_of_admission;

    }

    public int addsalary(String ROLE) {
        int salary = 0;
        if (ROLE.equals("veterinarian")) {
            salary = 10000;
        } else if (ROLE.equals("guide")) {
            salary = 2000;

        } else if (ROLE.contains("maintenance")) {
            salary = 5000;

        } else if (ROLE.contains("administration")) {
            salary = 2000;
        }
        return salary;
    }

    public String createCURP(String name, String lastname, String lastname2, String birthday, String sex) {
        String Lastname = lastname.substring(0, 2);
        String Lastname2 = lastname2.substring(0, 1);
        String Name = name.substring(0, 0);
        String year = birthday.substring(8, 10);
        String month = birthday.substring(0, 2);
        String day = birthday.substring(3, 5);
        String consonantes = "";
        Random random = new Random();
        int a1 = random.nextInt(100);
        int a2 = random.nextInt(100);

        // Iterar a través de cada carácter de la cadena
        for (int i = 0; i < lastname.length(); i++) {
            char c = lastname.charAt(i);
            // Comparar cada carácter con una letra específica
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                consonantes = consonantes + "";
            }

        }
        for (int i = 0; i < lastname2.length(); i++) {
            char c = lastname2.charAt(i);
            // Comparar cada carácter con una letra específica
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                consonantes = consonantes + "";
            }
        }
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            // Comparar cada carácter con una letra específica
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                consonantes = consonantes + "";
            }
        }
        String consonante = (String) consonantes;

        String curp = Lastname + Lastname2 + Name + year + month + day + sex + "MIC" + consonante + a1 + a2;
        curp = curp.toUpperCase();

        return curp;
    }

    public String createRFC(String name, String lastname, String lastname2, String birthday) {
        Random random = new Random();
        int a1 = random.nextInt(100);
        int a2 = random.nextInt(100);
        int codigoLetra = random.nextInt(26) + 65;
        char letraAleatoria = (char) codigoLetra;

        String Lastname = lastname.substring(0, 2);
        String Lastname2 = lastname2.substring(0, 1);
        String Name = name.substring(0, 0);
        String year = birthday.substring(8, 10);
        String month = birthday.substring(0, 2);
        String day = birthday.substring(3, 5);
        String RFC = Lastname + Lastname2 + Name + year + month + day + a1 + letraAleatoria + a2;
        RFC = RFC.toUpperCase();

        return RFC;
    }

    public void removeEmployee() {

        System.out.println("WHICH EMPLOOYE DO YOU WANT TO REMOVE(ID): ");
        String removeUser = sc.nextLine();
        if (verifyMa(removeUser)) {
            System.out.println("EMPLOYEE CANT BE CAHNGE (TYPE:Maintenance )");

        } else {

            for (int i = 0; i < employees.size(); i++) {

                if ((employees.get(i).getID()).equals(removeUser)) {
                    employees.remove(i);
                }

            }
        }
    }

    public void modifyEmployee() {
        String newChange = "";
        System.out.println("-------------------MODIFY EMPLOYEE-----------------");
        System.out.println("SELECT EMPLOYEE (ID)");
        IDEUSUARIO = sc.nextLine();

        if (verifyMa(IDEUSUARIO)) {
            System.out.println("EMPLOYEE CAN´T BE CAHNGE (TYPE:Maintenance )");

        } else {
            System.out.println(
                    "SELECT CHANGE(birthday, name, lastname, second lastname, RFC, CURP, ROLE, date of admission, sex, ID, schedule):");
            String change = sc.nextLine();
            for (int i = 0; i < employees.size(); i++) {

                if ((employees.get(i).getID()).equals(IDEUSUARIO)) {
                    switch (change) {
                        case "birthday":
                            System.out.println("Input the new " + change);
                            newChange = sc.nextLine();
                            employees.get(i).setBirthday(newChange);
                            break;
                        case "name":
                            System.out.println("Input the new " + change);
                            newChange = sc.nextLine();
                            employees.get(i).setName(newChange);
                            break;

                        case "lastname":
                            System.out.println("Input the new " + change);
                            newChange = sc.nextLine();
                            employees.get(i).setLastname(newChange);
                            break;
                        case "second lastname":
                            System.out.println("Input the new " + change);
                            newChange = sc.nextLine();
                            employees.get(i).setLastname2(newChange);
                            break;

                        case "ROLE":
                            System.out.println("Input the new " + change);
                            newChange = sc.nextLine();
                            employees.get(i).setROLE(newChange);
                            break;
                        case "date of admission":
                            System.out.println("Input the new " + change);
                            newChange = sc.nextLine();
                            employees.get(i).setDate_of_admission(newChange);
                            break;
                        case "sex":
                            System.out.println("Input the new " + change);
                            newChange = sc.nextLine();
                            employees.get(i).setSex(newChange);
                            break;

                        case "schedule":
                            System.out.println("Input the new " + change);
                            newChange = sc.nextLine();
                            employees.get(i).setSchedule(newChange);
                            break;

                        default:
                            break;
                    }

                }

            }

        }
    }

    public boolean verifyMa(String IDEUSUARIO) {
        boolean flag = false;
        for (int i = 0; i < Maintenance.size(); i++) {
            if (Maintenance.get(i).getID().equals(IDEUSUARIO)) {
                flag = true;
            }

        }
        return flag;

    }

    public void showMaintenanceInfo() {

        System.out.println("SELECT MAINTENECE EMPLOYEE (ID)");
        IDEUSUARIO = sc.nextLine();
        System.out.println("-------------------EMPLOYE INFO---------------------");

        for (int i = 0; i < Maintenance.size(); i++) {

            if ((Maintenance.get(i).getID()).equals(IDEUSUARIO)) {
                System.out.println(String.format(
                        "EMPLOYEE: %s %s %s | ID: %s | birthday: %s | Sex: %s | Curp: %s| RFC: %s |Date of admission: %s| Role: %s | Salary: %s | Schedule: %s| ",
                        Maintenance.get(i).name, Maintenance.get(i).getLastname(), Maintenance.get(i).getLastname2(),
                        Maintenance.get(i).generateID(), Maintenance.get(i).getBirthday(), Maintenance.get(i).getSex(),
                        Maintenance.get(i).getCURP(), Maintenance.get(i).getRFC(),
                        Maintenance.get(i).getDate_of_admission(),
                        Maintenance.get(i).getROLE(), Maintenance.get(i).getSalary(),
                        Maintenance.get(i).getSchedule()));
            }

        }

    }

    public void showMaintenanceList() {
        System.out.println("-----------------Maintenance List----------------------");
        for (int i = 0; i < Maintenance.size(); i++) {
            System.out.println(String.format("Maintenece: %s %s %s | ID: %s | ",
                    Maintenance.get(i).name, Maintenance.get(i).getLastname(), Maintenance.get(i).getLastname2(),
                    Maintenance.get(i).getID()));

        }
    }

    // retorna Roll especifico de algun empleado
    public String returnRole() {
        System.out.println("SELECT EMPLOYEE (ID)");
        IDEUSUARIO = sc.nextLine();
        String role = "";

        for (int i = 0; i < employees.size(); i++) {

            if ((employees.get(i).getID()).equals(IDEUSUARIO)) {
                role = employees.get(i).getROLE();
            }

        }
        return role;
    }

    public void showEmployeeInfo() {

        System.out.println("SELECT EMPLOYEE (ID)");
        IDEUSUARIO = sc.nextLine();
        System.out.println("---------------EMPLOYEE INFO-----------------");

        for (int i = 0; i < employees.size(); i++) {

            if ((employees.get(i).getID()).equals(IDEUSUARIO)) {
                System.out.println(String.format(
                        "EMPLOYEE: %s %s %s | ID: %s | birthday: %s | Sex: %s | Curp: %s| RFC: %s |Date of admission: %s| Role: %s | Salary: %s | Schedule: %s| ",
                        employees.get(i).name, employees.get(i).getLastname(), employees.get(i).getLastname2(),
                        employees.get(i).generateID(), employees.get(i).getBirthday(), employees.get(i).getSex(),
                        employees.get(i).getCURP(), employees.get(i).getRFC(), employees.get(i).getDate_of_admission(),
                        employees.get(i).getROLE(), employees.get(i).getSalary(), employees.get(i).getSchedule()));
            }

        }

    }

    public void showEmployeeList() {
        System.out.println("---------------EMPLOYEE LIST------------------------");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(String.format("EMPLOYEE: %s %s %s | ID: %s | ",
                    employees.get(i).name, employees.get(i).getLastname(), employees.get(i).getLastname2(),
                    employees.get(i).getID()));

        }

    }

    // Getters y setter

    public String getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public void setROLE(String rOLE) {
        ROLE = rOLE;
    }

    public void setDate_of_admission(String date_of_admission) {
        this.date_of_admission = date_of_admission;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLastname2() {
        return lastname2;
    }

    public String getRFC() {
        return RFC;
    }

    public String getCURP() {
        return CURP;
    }

    public String getROLE() {
        return ROLE;
    }

    public String getDate_of_admission() {
        return date_of_admission;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getSalary() {
        return salary;
    }

    public List<employee> getEmployees() {
        return employees;
    }

}