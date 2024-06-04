import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
# 인접리스트
graph = [[] for _ in range(n+1)]
T = [0 for _ in range(n+1)]
D = [0 for _ in range(n+1)]
res = [0 for _ in range(n+1)]


for i in range(1,n+1):
    li = list(map(int,input().split()))
    T[i] = li[0]
    li = li[1:-1]
    for j in li:
        graph[j].append(i)

    # 진입 차수 갱신
    D[i] = len(li)


q = deque()

for i in range(1,n+1):
    if D[i] == 0:
        q.append(i)
        res[i] = T[i]


while q:
    # 현재 정점 선택
    u = q.popleft()

    for v in graph[u]:
        D[v] -= 1
        res[v] = max(res[u]+T[v],res[v])
        if D[v] == 0:
            q.append(v)


for a in res[1:]:
    print(a)
