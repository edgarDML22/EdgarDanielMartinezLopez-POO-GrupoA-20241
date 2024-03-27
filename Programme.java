import java.util.Scanner;

public class Programme {
    private final String PASSWORD = "pass1234*";
    private Scanner sc = new Scanner(System.in);
    private Zoo zoo = new Zoo();


    private boolean validPassword = false;
    public void runProgramme(){   
        while (!validPassword) {
            System.out.println("\n**** WELCOME ****");
            System.out.println("Please insert the password to acces to the zoo information");
            String cad = sc.nextLine();
                if(cad.equals(PASSWORD)){
                    validPassword = true;
                    showOptions();
                }
                else{
                    System.out.println("Wrong password. Try again");
                } 
        }
    }

    public void showOptions(){
        while (true) {
            System.out.println("\n**** WELCOME TO THE ZOO SYSTEM ****");
            System.out.println("Please select an option");
            System.out.println("1. Register");
            System.out.println("2. Delete");
            System.out.println("3. Modify information");
            System.out.println("4. Consult information");
            System.out.println("5. Exit of the system");

            int x = sc.nextInt();
            switch (x) {
                case 1:
                    System.out.println("1. Register an employee");
                    System.out.println("2. Register a visitant");
                    System.out.println("3. Register an animal");
                    System.out.println("4. Register a visit to the zoo");
                    System.out.println("5. Register the maintenance done to an animal");
                    System.out.println("6. Get back to the last menu");

                        switch (sc.nextInt()) {
                            case 1:
                                zoo.addEmployee();
                            break;

                            case 2:
                                zoo.addVisitant();
                            break;

                            case 3:
                                zoo.addAnimal();
                            break;

                            case 4:
                                zoo.addZooVisit();
                            break;

                            case 5:
                                zoo.addMaintenance();
                            break;
                        
                            default:
                            break;
                        }
                break;

                case 2:
                    System.out.println("1. Delete an employee");
                    System.out.println("2. Delete a visitant");
                    System.out.println("3. Delete an animal");
                    System.out.println("4. Get back to the last menu");

                        switch (sc.nextInt()) {
                            case 1:
                                zoo.removeEmployee();
                            break;

                            case 2:
                                zoo.removeVisitant();
                            break;

                            case 3:
                                zoo.removeAnimal();
                            break;
                        
                            default:
                            break;
                        }
                break;

                case 3:
                    System.out.println("1. Modify employee information");
                    System.out.println("2. Modify visitant information");
                    System.out.println("3. Modify animal information");
                    System.out.println("4. Get back to the last menu");

                        switch (sc.nextInt()) {
                            case 1:
                                zoo.modifyEmployee();
                            break;

                            case 2:
                                zoo.modifyVisitant();
                            break;

                            case 3:
                                zoo.modifyAnimal();
                            break;
                        
                            default:
                            break;
                        }
                break;

                case 4: 
                    System.out.println("1. Employees information");
                    System.out.println("2. Visitants information");
                    System.out.println("3. Animals information");
                    System.out.println("4. Visits to the zoo information");
                    System.out.println("5. Maintenances information");
                    System.out.println("6. Get back to the last menu");


                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Do you need information of a specific employee?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                    if(sc.nextInt() == 1){//NO ES NECESARIO CREAR 50 VARIABLES, SI PONES SC.NEXT() EN LA CONDICIÓN FUNCIONA
                                        zoo.showEmployeeInfo();
                                    }
                                    else if(sc.nextInt() == 2){
                                        zoo.showEmployeeList();
                                    }
                                    else{
                                        System.out.println("Invalid option");
                                    }
                            break;

                            case 2:
                                System.out.println("Do you need information of a specific visitant?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                    if(sc.nextInt() == 1){
                                        zoo.showVisitantInfo();
                                    }
                                    else if(sc.nextInt() == 2){
                                        zoo.showVisitantList();
                                    }
                                    else{
                                        System.out.println("Invalid option");
                                    }
                            break;

                            case 3:
                                System.out.println("Do you need information of a specific animal?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                    if(sc.nextInt() == 1){
                                        zoo.showAnimalInfo();
                                    }
                                    else if(sc.nextInt() == 2){
                                        zoo.showAnimalList();
                                    }
                                    else{
                                        System.out.println("Invalid option");
                                    }
                            break;

                            case 4:
                                System.out.println("Do you need information of a specific zoo visit?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                    if(sc.nextInt() == 1){
                                        zoo.showZooVisitInfo();
                                    }
                                    else if(sc.nextInt() == 2){
                                        zoo.showZooVisitList();
                                    }
                                    else{
                                        System.out.println("Invalid option");
                                    }
                            break;

                            case 5:
                                System.out.println("Do you need information of a specific maintenance?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                    if(sc.nextInt() == 1){
                                        zoo.showMaintenanceInfo();
                                    }
                                    else if(sc.nextInt() == 2){
                                        zoo.showMaintenanceList();
                                    }
                                    else{
                                        System.out.println("Invalid option");
                                    }
                            break;
                        
                            default:
                            break;
                        }
                break;

                default:
                break;
            }
        }
    }
}