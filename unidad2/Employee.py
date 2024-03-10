import BankAccount

class Employee:
    __name = ''
    __last_name = ''
    __account = BankAccount()
    __status = True
    __account_list = []

    def __init__(self, name, last_name, account_number, type):
        if(self._valid_type(type)):
            self.__name = name
            self.__last_name = last_name
            self.__account = BankAccount(account_number, type)
            __account_list.append(self.__account)
        else:
            self.__status = False

    def get_name(self):
        return self.__name
    
    def get_last_name(self):
        return self.__last_name
    
    def get_account(self):
        return self.__account
    
    def is_status(self):
        return self.__status
    
    def get_account_list(self):
        return __account_list
    
    def add_account(self, account_number, type):
    ##VAS EN LA PARTE QUE HACE NULL el objeto newAccount Edgar
    
        


    def _valid_type(self, type):
        if type == 'A':
            return True
        elif type == 'B':
            return True
        elif type == 'C':
            return True
        else:
            return False
        
