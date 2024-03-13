import random

class User:
    __name = ''
    __age = 0
    __id = ''
    __book_list = []
    __rent_counter = 0

    
    def __init__(self, name, age):
        self.__name = name
        self.__age = age
        self.__id = self.generate_id()
        self.__book_list = []
        self.__rent_counter = 0

    def get_name(self):
        return self.__name

    def get_age(self):
        return self.__age

    def get_book_list(self):
        return self.__book_list

    def get_id(self):
        return self.__id

    def get_rent_counter(self):
        return self.__rent_counter

    def increase_counter(self):
        self.__rent_counter += 1

    def rent_book(self, book):
        self.__book_list.append(book)
        self.__rent_counter += 1

    def return_book(self, book):
        self.__book_list.remove(book)

    def show_user_books(self):
        print("These are the books rented by:", self.get_name())
        for book in self.__book_list:
            print(f"\n| TITLE: {book.get_title()} | AUTHOR: {book.get_author()} |")

    def generate_id(self):
        bank = "abcdefghijklmnopqrstuvwxyz0123456789"
        cad = ""
        for i in range(6):
            cad += random.choice(bank)
        return cad
    
class Book:
        __title = ''
        __author = ''
        __id = ''
        __is_rented = False
        __rent_counter = 0
        __owner = None

        def __init__(self, title, author):
            self.__title = title
            self.__author = author
            self.__id = self.generate_id()

        def get_title(self):
            return self.__title

        def get_author(self):
            return self.__author

        def get_id(self):
            return self.__id

        def is_rented(self):
            return self.__is_rented

        def set_rented(self, is_rented):
            self.__is_rented = is_rented

        def get_rent_counter(self):
            return self.__rent_counter

        def increase_counter(self):
            self.__rent_counter += 1

        def set_owner(self, owner):
            self.__owner = owner

        def get_owner(self):
            return self.__owner

        def rent_book(self, owner):
            self.set_owner(owner)
            self.set_rented(True)
            self.__rent_counter += 1
            print("The book was rented successfully")

        def return_book(self):
            self.set_rented(False)
            self.set_owner(None)

        def generate_id(self):
            bank = "abcdefghijklmnopqrstuvwxyz0123456789"
            cad = ""
            for i in range(6):
                cad += random.choice(bank)
            return cad

class BookStore:
    def __init__(self):
        self.__book_list = []
        self.__user_list = []

    def add_user(self):
        name = input("Insert the name: ")
        age = int(input("Insert the age: "))
        self.__user_list.append(User(name, age))
        print("The user was added successfully")

    def delete_user(self):
        if not self.__user_list:
            print("There are no users registered")
        else:
            i = self.get_user_index()
            if self.valid_user_index(i):
                del self.__user_list[i]
                print("The user was removed successfully")
            else:
                print("The user wasn't found")

    def add_book(self):
        title = input("Insert the title: ")
        author = input("Insert the author: ")
        self.__book_list.append(Book(title, author))
        print("The book was added successfully")

    def delete_book(self):
        if not self.__book_list:
            print("There are no books registered")
        else:
            i = self.get_book_index()
            if self.valid_book_index(i):
                del self.__book_list[i]
                print("The book was removed successfully")
            else:
                print("The book wasn't found")

    def rent_book(self):
        if not self.__user_list or not self.__book_list:
            print("There are no users or books to make a rent")
        else:
            i = self.get_book_index()
            if self.valid_book_index(i):
                if not self.__book_list[i].is_rented():
                    n = self.get_user_index()
                    if self.valid_user_index(n):
                        self.__book_list[i].rent_book(self.__user_list[n])
                        self.__user_list[n].rent_book(self.__book_list[i])
                    else:
                        print("The user wasn't found")
                else:
                    print("This book is currently rented by: " + self.__book_list[i].get_owner().get_name())
            else:
                print("The book wasn't found")

    def return_book(self):
        if not self.__book_list:
            print("There are no books registered")
        else:
            i = self.get_user_index()
            if self.valid_user_index(i):
                if not self.__user_list[i].get_book_list():
                    print("This user hasn't rented any books yet")
                else:
                    n = self.get_book_INDEX(i)
                    if self.valid_book_index(n):
                        self.__user_list[i].return_book(self.__book_list[n])
                        self.__book_list[n].return_book()
                        print("The book has been returned to the book store")
                    else:
                        print("The book wasn't found")
            else:
                print("The user wasn't found")

    def show_user_list(self):
        if not self.__user_list:
            print("There are no users registered")
        else:
            print(" -------------USERS INFORMATION------------- ")
            for user in self.__user_list:
                print(f"\n | NAME: {user.get_name()} | AGE: {user.get_age()} | ID: {user.get_id()} |")
                if not user.get_book_list():
                    print("---------This user hasn't rented any books---------")
                else:
                    print(" _____________BOOKS RENTED_____________ ")
                    for book in user.get_book_list():
                        print(f"\n | TITLE: {book.get_title()} | AUTHOR: {book.get_author()} |")
                print()

    def show_user_data(self):
        if not self.__user_list:
            print("There are no users registered")
        else:
            i = self.get_user_index()
            if self.valid_user_index(i):
                print(" INFORMATION FROM THE USER: " + self.__user_list[i].get_name())
                print(f" | NAME: {self.__user_list[i].get_name()} | AGE: {self.__user_list[i].get_age()} | ID: {self.__user_list[i].get_id()} |")
                if not self.__user_list[i].get_book_list():
                    print("---------This user hasn't rented any books---------")
                else:
                    print(" _____________BOOKS RENTED_____________ ")
                    for book in self.__user_list[i].get_book_list():
                        print(f" | TITLE: {book.get_title()} | AUTHOR: {book.get_author()} |")
                    print()
            else:
                print("The user wasn't found")

    def show_book_list(self):
        if not self.__book_list:
            print("There are no books registered")
        else:
            print(" ------------BOOK LIST------------")
            for book in self.__book_list:
                print(f"\n | TITLE: {book.get_title()} | AUTHOR: {book.get_author()} | NUMBER OF RENTS: {book.get_rent_counter()} | ")
                if not book.is_rented():
                    print(" | NO ACTUAL OWNER | ")
                else:
                    print(f" | ACTUAL OWNER: {book.get_owner().get_name()} | ")
                print()

    def show_active_users(self):
        if not self.__user_list:
            print("There are no users registered")
        else:
            print("These users have at least one rent on the register")
            for user in self.__user_list:
                if user.get_rent_counter() > 0:
                    print(f"\n | NAME: {user.get_name()} | AGE: {user.get_age()} |")


    def show_active_books(self):
        if not self.__book_list:
            print("There are no books registered")
        else:
            for book in self.__book_list:
                if book.get_rent_counter() > 0:
                    print(f"| TITLE: {book.get_title()} | AUTHOR: {book.get_author()} | NUMBER OF RENTS: {book.get_rent_counter()} | ")
                    if not book.is_rented():
                        print(" | NO ACTUAL OWNER | ")
                    else:
                        print(f" | ACTUAL OWNER: {book.get_owner().get_name()} | ")
                    print()

    def show_inactive_books(self):
        if not self.__book_list:
            print("There are no books registered")
        else:
            print("These books have never been rented")
            for book in self.__book_list:
                if book.get_rent_counter() == 0:
                    print(f"| TITLE: {book.get_title()} | AUTHOR: {book.get_author()} | NUMBER OF RENTS: {book.get_rent_counter()} | ")                 

    def show_user_names(self):
        print("These are the ID available")
        print("----------------------------------")
        for user in self.__user_list:
            print(" | NAME: {} | ID: {} | ".format(user.get_name(), user.get_id()))
            print()

    def get_user_index(self):
        x = -1
        self.show_user_names()
        print("Insert the ID of the user")
        ID = input()

        for i in range(len(self.__user_list)):
            if ID == self.__user_list[i].get_id():
                x = i
                break
        return x

    def valid_user_index(self, i):
        if i == -1:
            return False
        else:
            return True

    def show_book_titles(self):
        print("These are the ID available")
        print("----------------------------------")
        for book in self.__book_list:
            print(" | TITLE: {} | ID: {} | ".format(book.get_title(), book.get_id()))
            print()

    def show_book_TITLES(self, i):
        print("These are the ID available for the user: {}".format(self.__user_list[i].get_name()))
        print("----------------------------------")
        for book in self.__user_list[i].get_book_list():
            print(" | TITLE: {} | ID: {} | ".format(book.get_title(), book.get_id()))
            print()

    def get_book_index(self):
        x = -1
        self.show_book_titles()
        print("Insert the ID of the book")
        ID = input()

        for i in range(len(self.__book_list)):
            if ID == self.__book_list[i].get_id():
                x = i
                break
        return x

    def get_book_INDEX(self, i):
        x = -1
        self.show_book_TITLES(i)
        print("Insert the ID of the book")
        ID = input()

        for j in range(len(self.__book_list)):
            if ID == self.__user_list[i].get_book_list()[j].get_id():
                x = j
                break
        return x

    def valid_book_index(self, i):
        if i == -1:
            return False
        else:
            return True


def show_options():
    print("********WELCOME TO THE BOOK STORE********")
    print("1. Register an user")
    print("2. Remove an user")
    print("3. Register a book")
    print("4. Remove a book")
    print("5. Rent a book")
    print("6. Return book")
    print("7. Show the information of a specific user")
    print("8. Show all the users registered")
    print("9. Show all the books registered")
    print("10. Show all the users registered with at least one book rented")
    print("11. Show all the books that have been rented")
    print("12. Show all the books that haven't been rented")
    print("13. Get out of the book store")
    print("*********************************************************")


def main():
    book_store = BookStore()
    flag = True

    while flag:
        show_options()
        x = int(input())

        if x == 1:
            book_store.add_user()
        elif x == 2:
            book_store.delete_user()
        elif x == 3:
            book_store.add_book()
        elif x == 4:
            book_store.delete_book()
        elif x == 5:
            book_store.rent_book()
        elif x == 6:
            book_store.return_book()
        elif x == 7:
            book_store.show_user_data()
        elif x == 8:
            book_store.show_user_list()
        elif x == 9:
            book_store.show_book_list()
        elif x == 10:
            book_store.show_active_users()
        elif x == 11:
            book_store.show_active_books()
        elif x == 12:
            book_store.show_inactive_books()
        else:
            flag = False


if __name__ == "__main__":
    main()
