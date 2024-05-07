from collections import defaultdict
import sys
input = sys.stdin.readline

def draw(x, y, d1, d2):
  for r in range(1, N + 1):
    for c in range(1, N + 1):
      if 1 <= r < x + d1 and 1 <= c <= y:
        board[r][c] = 1
      elif 1 <= r <= x + d2 and y < c <= N:
        board[r][c] = 2
      elif x + d1 <= r <= N and 1 <= c < y - d1 + d2:
        board[r][c] = 3
      elif x + d2 < r <= N and y - d1 + d2 <= c <= N:
        board[r][c] = 4
  for i in range(d1+1):
    nx = x + i
    ny = y - i
    if nx <= N and 1 <= ny:
      board[nx][ny] = 5
    if nx + d2 <= N and 1 <= ny + d2 <= N:
      board[nx + d2][ny + d2] = 5
    
  for i in range(d2+1):
    nx = x + i
    ny = y + i
    if nx <= N and ny <= N:
      board[nx][ny] = 5
    if nx + d1 <= N and 1 <= ny - d1 <= N:
      board[nx + d1][ny - d1] = 5
  
  for r in range(1, N + 1):
    cnt = 0
    for c in range(1, N + 1):
      if board[r][c] == 5:
        cnt += 1
        if cnt > 1:
          s = c - 1
          while board[r][s] != 5:
            board[r][s] = 5
            s -= 1

def number_count():
  cnt_dict = defaultdict(int)
  for r in range(1, N+1):
    for c in range(1, N+1):
      cnt_dict[board[r][c]] += data[r][c]
  return cnt_dict.values()

def solution():
  global board
  res = int(1e9)
  for x in range(1, N):
    for y in range(1, N):
      for d1 in range(1, N):
        for d2 in range(1, N):
          if 1 <= x < x + d1 + d2 <= N and 1 <= y - d1 < y < y + d2 <= N:
            board = [[0] * (N + 1) for _ in range(N + 1)]
            draw(x, y, d1, d2)
            value = number_count()
            res = min(res, max(value) - min(value))
  return res

if __name__ == "__main__":
  N = int(input())
  data = [[0] * (N+1)]
  for i in range(N):
    data.append([0] + list(map(int,input().split())))
  print(solution())