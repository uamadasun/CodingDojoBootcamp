#1. Basic - Print all integers from 0 to 150.

for i in range(0,151):
    print(i)
    
print("-------------")

#2. Multiples of Five - Print all the multiples of 5 from 5 to 1,000

for i in range(5,1001):
    if i%5:
        continue
    else:
        print(i)
        
print("-------------")

#3. Counting, the Dojo Way - Print integers 1 to 100. If divisible by 5, print "Coding" instead. If divisible by 10, print "Coding Dojo".
for i in range(1,101):
    if i%5==0:
        print("Coding")
    if i%10==0:
        print("Coding Dojo")
    else:
        print(i)
        
print("-------------")

#4. Whoa. That Sucker's Huge - Add odd integers from 0 to 500,000, and print the final sum.
count = 0
odd_sum = 0
while count <=500000:
    if count%2:
        odd_sum+=count
    count+=1
print("The sum of odd numbers is", odd_sum)

print("-------------")

#5. Countdown by Fours - Print positive numbers starting at 2018, counting down by fours.
for i in range(2018,0, -4):
    print(i)
    
print("-------------")

#6 Flexible Counter - Set three variables: lowNum, highNum, mult. Starting at lowNum and going through highNum, print only the integers that are a multiple of mult. For example, if lowNum=2, highNum=9, and mult=3, the loop should print 3, 6, 9 (on successive lines)
#REGULAR
lowNum = 2
highNum = 9
mult = 3
for i in range(lowNum, highNum+1):
    if i%mult == 0:
        print(i)
        
#FUNCTION
def flexer(lowNum, highNum,mult):

    for i in range(lowNum, highNum+1):
        if i%mult == 0:
            print(i)
flexer(2,9,3)

 

