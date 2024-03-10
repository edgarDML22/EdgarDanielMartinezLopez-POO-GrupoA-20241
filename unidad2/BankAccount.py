class BankAccount:          ##CLASE LISTA
    __account_number = 0
    __amount = 0.0
    __type = ''
    __status = True

    def __init__(self, account_number, type):
        if(self._valid_type(type)):
            self.__account_number = account_number
            self.__type = type
        else:
            self.__status = False

    def get_account_number(self):
        return self.__account_number
    
    def get_account_type(self):
        return self.__type
    
    def get_amount(self):
        return self.__amount
    
    def is_status(self):
        return self.__status
    
    def _valid_type(self, type):
        if type == 'A' or type == 'B' or type == 'C':
            return True
        else:
            return False
            
    def agregar_dinero(self, cargo):
        if self.__type == 'A':
            self.agregar_dineroA(cargo)
            print('Money added succesfully')
        elif self.__type == 'B':
            self.agregar_dineroB(cargo)
            print('Money added succesfully')
        elif self.__type == 'C':
            self.agregar_dineroC(cargo)
            print('Money added succesfully')


    def retirar_dinero(self, retiro):
        if self.__type == 'A':
            self.retirar_dineroA(retiro)
            print('Money taken succesfully')
        elif self.__type == 'B':
            self.retirar_dineroB(retiro)
            print('Money taken succesfully')
        elif self.__type == 'C':
            self.retirar_dineroC(retiro)
            print('Money taken succesfully')



    def agregar_dineroA(self, cargo):
        if self.__amount + cargo >= 50000:
            print('\nHa excedido la cantidad máxima de este tipo de cuenta')
        elif cargo < 0:
            print('\nNo puede realizar un cargo negativo')
        else:
            self.__amount += cargo

    def agregar_dineroB(self, cargo):
        if self.__amount + cargo >= 100000:
            print('\nHa excedido la cantidad máxima de este tipo de cuenta')
        elif cargo < 0:
            print('\nNo puede realizar un cargo negativo')
        else:
            self.__amount += cargo

    def agregar_dineroC(self, cargo):
        if cargo < 0:
            print('\nNo puede realizar un cargo negativo')
        else:
            self.__amount += cargo


    def retirar_dineroA(self, retiro):
        if self.__amount < 1000:
            print('\nSaldo insuficiente para retirar')
        elif self.__amount < retiro:
            print('\nEl dinero a retirar es mayor al saldo disponible')
        else:
            self.__amount -= retiro

    def retirar_dineroB(self, retiro):
        if self.__amount < 5000:
            print('\nSaldo insuficiente para retirar')
        elif self.__amount < retiro:
            print('\nEl dinero a retirar es mayor al saldo disponible')
        else:
            self.__amount -= retiro

    def retirar_dineroC(self, retiro):
        if self.__amount < 10000:
            print('\nSaldo insuficiente para retirar')
        elif self.__amount < retiro :
            print('\nEl dinero a retirar es mayor al saldo disponible')
        else:
            self.__amount -= retiro
 