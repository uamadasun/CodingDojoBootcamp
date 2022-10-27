class Ninja:
    def __init__(self, first_name, last_name, pet, treats, pet_food):
        self.first_name = first_name
        self.last_name = last_name
        self.pet = pet
        self.treats = treats
        self.pet_food = pet_food


    def walk(self):
        print(f"{self.first_name} is walking {self.pet.name}.")
        self.pet.play()
        return self

    def feed(self):
        print(f"{self.first_name} is feeding {self.pet.name} some {self.pet_food}.")
        self.pet.eat()
        return self

    def bathe(self):
        print(f"{self.first_name} is giving {self.pet.name} a bath.")
        self.pet.noise()

        return self

class Pet:
    def __init__(self, name, pet_type, tricks, health, energy):
        self.name = name
        self.pet_type = pet_type
        self.tricks = tricks
        self.health = health
        self.energy = energy

    def sleep(self):
        self.energy += 25
        print(f'{self.name} is well-rested.')
        return self

    def eat(self):
        self.energy += 5
        self.health += 10
        print(f'{self.name} is now full and re-energized after eating!')
        return self

    def play(self):
        self.health += 5
        return self

    def noise(self):
        if self.pet_type == 'dog':
            print("Woof Woof!")
        else:
            print("Meow")

first_pet = Pet("Fluffy", "dog", "sit", 10, 5)
first_ninja = Ninja("Michael", "Jameson", first_pet,"Bone", "Dog Chow")

first_ninja.bathe()
first_ninja.walk()
first_ninja.feed()
