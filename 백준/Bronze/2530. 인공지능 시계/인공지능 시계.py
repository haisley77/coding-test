h, m, s = map(int,input().split(' '))
add = int(input())
s = s + add

while s >= 60:
    m +=1
    s = s-60
while m >=60:
    h +=1
    m = m-60
while h >=24:
    h = h-24

print(h,m,s)