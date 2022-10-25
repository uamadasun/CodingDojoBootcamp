'''
1. Countdown - Create a function that accepts a number as an input. Return a new list that counts down by one, from the number (as the 0th element) down to 0 (as the last element).
'''

def count_down(number):
    new_list = []
    for i in range(number,-1, -1):
        new_list.append(i)
    return new_list

#print(count_down(5))

'''
2. Print and Return - Create a function that will receive a list with two numbers. Print the first value and return the second.
'''
def print_return(list1):
    print(list1[0])
    return(list1[1])

#print(print_return([1,2]))

'''
3. First Plus Length - Create a function that accepts a list and returns the sum of the first value in the list plus the list's length.
'''
def first_plus_length(list1):
    return list1[0] + len(list1)

#print(first_plus_length([1,2,3,4,5]))

'''
4. Values Greater than Second - Write a function that accepts a list and creates a new list containing only the values from the original list that are greater than its 2nd value. Print how many values this is and then return the new list. If the list has less than 2 elements, have the function return False
'''
def greater_than(list1):
    if len(list1) < 2:
        return False
    new_list = []
    second_value = list1[1]
    for num in list1:
        if num > second_value:
            new_list.append(num)
    print(len(new_list))
    return new_list

#print(greater_than([5,2,3,2,1,4]))
#print(greater_than([3]))

'''
5. This Length, That Value - Write a function that accepts two integers as parameters: size and value. The function should create and return a list whose length is equal to the given size, and whose values are all the given value.
'''
def length_value(size, value):
    new_list = []
    for i in range(size):
        new_list.append(value)
    return new_list

#print(length_value(4,7))
#print(length_value(6,2))
