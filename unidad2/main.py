import sys

class Bank:
    def __init__(self):
        self.__bank_account_list = []
        self.__employee_list = []

    def add_employee(self):
        name = input('Insert the employee name: ')
        last_name = input('Insert the employee last name: ')
        account_number = int(input('Insert the account number: '))
        type = input('Insert the account type')

        employee = Employee(name, last_name, account_number, type)
        if(employee.is_status()):
            self.__employee_list.append(employee)
            self.__bank_account_list.append(employee.get_account())
            print('The employee was added succesfully')
        else:
            print("The employee wasn't added")

    def add_account(self):
        if len(self.__employee_list) == 0:
            print("There are no employees registered")

        else:
            i = self.get_employee_index(self.ask_name())
            if self.valid_employee_index(i):
                
                account_number = int(input("Insert the account number: "))
                type = input("Insert the account type: ")
                new_account = self.__employee_list[i].add_account(account_number, type)

                if new_account is not None:
                    self.__bank_account_list.append(new_account)
                    print("The account was added succesfully")
                else:
                    print("The account wasn't added")

            else:
                print("The name wasn't found")


    def add_money_account(self):
        i = self.get_employee_index(self.ask_name())
        if self.valid_employee_index(i):
            if len(self.__employee_list[i].get_account_list()) == 0:
                print("This user has no accounts registered")
            else:
                self.show_bank_accounts(i)
                n = self.get_bank_account_number_index(self.ask_account_number(), i)
                if self.valid_account_number(n):
                    bank_account = self.__employee_list[i].get_account_list()[n]
                    monto = float(input("Ingrese el monto a depositar: "))
                    bank_account.agregar_dinero(monto)
                else:
                    print("The account wasn't found")
        else:
            print("The name wasn't found")

    
    def get_money_account(self):
        i = self.get_employee_index(self.ask_name())
        if self.valid_employee_index(i):
            if len(self.__employee_list[i].get_acount_list()) == 0:
                print("This user has no accounts registered")
            else:
                self.show_bank_accounts(i)
                n = self.get_bank_account_number_index(self.ask_account_number(), i)
                if self.valid_account_number(n):
                    bank_account = self.__employee_list[i].get_account_list()[n]
                    retiro = float(input("Ingrese el monto a retirar: "))
                    bank_account.retirar_dinero(retiro)
                else:
                    print("The account wasn't found")
        else:
            print("The name wasn't found")


    def delete_employee(self):
        if len(self.__employee_list) == 0:
            print("There are no employees registered")

        else:
            i = self.get_employee_index(self.ask_name())
            if self.valid_employee_index(i):
                self.__employee_list.pop(i)
                print("The employee was removed successfully")
            else:
                print("The employee wasn't found")

    def delete_account(self):
        i = self.get_employee_index(self.ask_name())
        if self.valid_employee_index(i):
            if len(self.__bank_account_list) == 0:
                print("There are not bank accounts registered")
            else:
                self.show_bank_accounts(i)
                n = self.get_bank_account_number_index(self.ask_account_number(), i)
                if self.valid_account_number(n):
                    employee = self.__employee_list[i]
                    self.__bank_account_list.remove(employee.get_account_list()[n])
                    employee.get_account_list().pop(n)
                    print("The account was removed succesfully")
                else:
                    print("The account wasn't found")                
        else:
            print("The name wasn't found")

    
    def show_bank_account_list(self):
        if len(self.__bank_account_list) == 0:
            print("There are no bank acounts registered")
        else:
            print(" --------------------------BANK ACCOUNTS INFORMATION--------------------------")
            for employee in self.__employee_list:
                for bank_account in employee.get_account_list():
                    print("| EMPLOYEE: {} | ACCOUNT NUMBER: {} | ACCOUNT TYPE: {} | AMOUNT: {:.2f} |".format(
                        employee.get_full_name(), bank_account.get_account_number(), bank_account.get_type(), bank_account.get_amount()))
                    
    def show_bank_account_data(self):
        i = self.get_employee_index(self.ask_name())
        if self.valid_employee_index(i):
            self.show_bank_accounts(i)
            n = self.get_bank_account_number_index(self.ask_account_number(), i)
            if self.valid_account_number(n):
                bank_account = self.__employee_list[i].get_account_list()[n]
                print("| ACCOUNT NUMBER: {} | ACCOUNT TYPE: {} | AMOUNT: {:.2f} |".format(
                    bank_account.get_account_number(), bank_account.get_type(), bank_account.get_amount()))
            else:
                print("The account wasn't found")
        else:
            print("The name wasn't found")

    def show_employee_list(self):
        if len(self.__employee_list) == 0:
            print("There are no employees registered")
        else:
            print(" --------------------------EMPLOYEES INFORMATION-------------------------- ")
            for employee in self.__employee_list:
                print("| NAME: {} | LASTNAME: {} |".format(employee.get_name(), employee.get_last_name()))
                print("------------------------------EMPLOYEE ACCOUNTS------------------------------")
                for bank_account in employee.get_account_list():
                    print("| ACCOUNT NUMBER: {} | ACCOUNT TYPE: {} | ACCOUNT AMOUNT: {:.2f} |".format(
                        bank_account.get_account_number(), bank_account.get_type(), bank_account.get_amount()))
                print("******************************************************************************")
            print()

    def show_employee_data(self):
        if len(self.__employee_list) == 0:
            print("There are no employees registered")
        else:
            i = self.get_employee_index(self.ask_name())
            if self.valid_employee_index(i):

                employee = self.EmployeeList[i]
                print("| NAME: {} | LASTNAME: {} |".format(employee.get_name(), employee.get_last_name()))
                print("------------------------------EMPLOYEE ACCOUNTS------------------------------")
                for bank_account in employee.getAccountList():
                    print("| ACCOUNT NUMBER: {} | ACCOUNT TYPE: {} | ACCOUNT AMOUNT: {:.2f} |".format(
                        bank_account.get_account_number(), bank_account.get_type(), bank_account.get_amount()))
            else:
                print("The name wasn't found")
    
    def show_user_names(self):
        if len(self.__employee_list) == 0:
            print("There are no employees registered")
            return False
        else:
            print("These are the employees registered in the bank")
            print("--------------------------------------------------")
            for employee in self.__employee_list:
                print("| {} |".format(employee.get_name()))
            return True

    def ask_name(self):
        flag = self.show_user_names()
        if flag:
            name = input("Insert the employee name: ")
            return name
        else:
            return "noUser"
        
    def get_employee_index(self, name):
        x = -1
        for i in range(len(self.__employee_list)):
            if self.__employee_list[i].get_name().lower() == name.lower():
                x = i
                break
        return x

    def valid_employee_index(self, i):
        if i == -1:
            return False
        else:
            return True

    def show_bank_accounts(self, i):
        if len(self.__employee_list[i].get_account_list()) == 0:
            print("This user has no account numbers")
        else:
            print("These are the account numbers of the employee {}".format(self.__employee_list[i].get_name()))
            print("--------------------------------------------------")
            for bank_account in self.__employee_list[i].get_account_list():
                print("| {} |".format(bank_account.get_account_number()))

    def ask_account_number(self):
        account_number = int(input("Insert the account number: "))
        return account_number

    def get_bank_account_number_index(self, accountNumber, index):
        x = -1
        for i in range(len(self.__employee_list[index].get_account_list())):
            if accountNumber == self.__employee_list[index].get_account_list()[i].get_account_number():
                x = i
                break
        return x

    def valid_account_number(self, i):
        if i == -1:
            return False
        else:
            return True

    

    def show_options(self):
        print("*******************BIENVENIDO AL BANCO*******************")
        print("Choose an option")
        print("1. Add employee")
        print("2. Add account to a specific employee")
        print("3. Make a deposit to a specific account")
        print("4. Get money from a specific account")
        print("5. Delete an employee")
        print("6. Delete a bank account from an employee")
        print("7. Show the information of all registered employees")
        print("8. Show the information of a specific employee")
        print("9. Show all the bank accounts registered")
        print("10. Show the information of a specific bank account")
        print("11. Get out of the menu")

    


class BankAccount:
    def __init__(self, account_number, account_type):
        if self.valid_type(account_type):
            self.account_number = account_number
            self.account_type = account_type
            self.amount = 0.0
            self.status = True
        else:
            self.status = False

    def get_account_number(self):
        return self.account_number

    def get_type(self):
        return self.account_type

    def get_amount(self):
        return self.amount

    def is_status(self):
        return self.status

    def valid_type(self, account_type):
        return account_type in ["A", "B", "C"]

    def agregar_dinero(self, amount):
        if self.account_type == "A":
            if self.amount + amount >= 50000:
                print("Ha excedido la cantidad máxima de este tipo de cuenta")
            elif amount < 0:
                print("No puede realizar un cargo negativo")
            else:
                self.amount += amount
        elif self.account_type == "B":
            if self.amount + amount >= 100000:
                print("Ha excedido la cantidad máxima de este tipo de cuenta")
            elif amount < 0:
                print("No puede realizar un cargo negativo")
            else:
                self.amount += amount
        elif self.account_type == "C":
            if amount < 0:
                print("No puede realizar un cargo negativo")
            else:
                self.amount += amount

    def retirar_dinero(self, amount):
        if self.account_type == "A":
            if self.amount < 1000:
                print("Saldo insuficiente para retirar")
            elif self.amount < amount:
                print("El dinero a retirar es mayor al saldo disponible")
            else:
                self.amount -= amount
        elif self.account_type == "B":
            if self.amount < 5000:
                print("Saldo insuficiente para retirar")
            elif self.amount < amount:
                print("El dinero a retirar es mayor al saldo disponible")
            else:
                self.amount -= amount
        elif self.account_type == "C":
            if self.amount < 10000:
                print("Saldo insuficiente para retirar")
            elif self.amount < amount:
                print("El dinero a retirar es mayor al saldo disponible")
            else:
                self.amount -= amount


class Employee:
    def __init__(self, name, last_name, account_number=None, account_type=None):
        self.name = name
        self.last_name = last_name
        self.account_list = []
        self.status = True
        if account_number and account_type:
            if self.valid_type(account_type):
                self.account = BankAccount(account_number, account_type)
                if self.account.is_status():
                    self.account_list.append(self.account)
                else:
                    self.status = False
            else:
                self.status = False

    def get_name(self):
        return self.name

    def get_last_name(self):
        return self.last_name

    def get_account(self):
        return self.account

    def is_status(self):
        return self.status

    def get_account_list(self):
        return self.account_list

    def add_account(self, account_number, account_type):
        if self.valid_type(account_type):
            new_account = BankAccount(account_number, account_type)
            if new_account.is_status():
                self.account_list.append(new_account)
                return new_account
        return None

    def valid_type(self, account_type):
        return account_type in ["A", "B", "C"]

    def get_full_name(self):
        return self.name + " " + self.last_name


def main():
    bank = Bank()

    while True:
        bank.show_options()
        x = int(input())
        if x == 1:
            bank.add_employee()
        elif x == 2:
            bank.add_account()
        elif x == 3:
            bank.add_money_account()
        elif x == 4:
            bank.get_money_account()
        elif x == 5:
            bank.delete_employee()
        elif x == 6:
            bank.delete_account()
        elif x == 7:
            bank.show_employee_list()
        elif x == 8:
            bank.show_bank_account_list()
        elif x == 9:
            bank.show_bank_account_data()
        elif x == 10:
            bank.show_bank_account_list()
        elif x == 11:
            sys.exit()
        else:
            print("Invalid option")


if __name__ == "__main__":
    main()