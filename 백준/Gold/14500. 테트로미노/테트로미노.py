import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

def dfs(x, y, tsum, cnt):
  global result

  if cnt == 4:
    result = max(result, tsum)
    return

  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
      visited[nx][ny] = True
      dfs(nx, ny, tsum + graph[nx][ny], cnt + 1)
      visited[nx][ny] = False
  
def check_ah(x, y):
  global result
  for i in range(4):
    tmp = graph[x][y]
    for j in range(3):
      t = (i+j) % 4
      nx = x + dx[t]
      ny = y + dy[t]
      if not (0 <= nx < n and 0 <= ny < m):
        tmp = 0
        break
      tmp += graph[nx][ny]
    result = max(result, tmp)
    
n, m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

visited = [[False] * m for _ in range(n)]
result = 0
for i in range(n):
  for j in range(m):
    visited[i][j] = True
    dfs(i, j, graph[i][j], 1)
    visited[i][j] = False

    check_ah(i, j)
    
print(result)