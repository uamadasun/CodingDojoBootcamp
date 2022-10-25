class User:
    def __init__(self, first_name, last_name, email, age):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_rewards_member = False
        self.gold_card_points = 0

    def display_info(self):
        print(f"First Name: {self.first_name}\nLast Name: {self.last_name}\nEmail: {self.email}\nAge: {self.age}\nRewards Member? {self.is_rewards_member}\nGold Card Points: {self.gold_card_points}")
        return self

    def enroll(self):
        if self.is_rewards_member:
            print(f"{self.first_name} {self.last_name} is already a rewards member.")
            return self

        else:
            self.is_rewards_member = True
            print(f"{self.first_name} {self.last_name} is now a rewards member.")
            return self
  
    def spend_points(self,amount):
        if amount > self.gold_card_points:
            print("Not enough points available to spend.")
            return self
        else:
            self.gold_card_points -= amount
            print(f'{self.first_name} {self.last_name} now has {self.gold_card_points} gold card points.')
            return self

first_user = User("Marco", "Polo", 'marco@gmail.com', 40)

first_user.display_info().enroll()

#create 2 more users
second_user = User("Anna", 'Bey', 'anna@codingdojo.com',21)

third_user = User("Christian", "Johnson", 'cj@gmail.com', 39)


first_user.spend_points(50)

second_user.enroll()
second_user.gold_card_points = 190
second_user.spend_points(50).spend_points(80)

user_list = [first_user, second_user, third_user]
for user in user_list:
    user.display_info()


first_user.enroll()

third_user.spend_points(40)

