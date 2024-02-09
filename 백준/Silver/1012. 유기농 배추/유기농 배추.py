from collections import deque
import sys
input = sys.stdin.readline
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
  q = deque([(x, y)])
  board[x][y] = 0
  while (q):
    x, y = q.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if (0 <= nx < N and 0 <= ny < M and board[nx][ny]):
        q.append((nx ,ny))
        board[nx][ny] = 0

def main():
  global N, M, board
  T = int(input())
  for _ in range(T):
    M, N, K = map(int,input().split())
    board = [[0] * M for _ in range(N)]
    for _ in range(K):
      X, Y = map(int,input().split())
      board[Y][X] = 1
    res = 0
    for i in range(N):
      for j in range(M):
        if (board[i][j]):
          res+=1
          bfs(i, j)
    print(res)

if __name__ == "__main__":
  main()