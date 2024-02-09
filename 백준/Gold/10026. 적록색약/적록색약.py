import sys, copy
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(board, color, x, y):
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < N and 0 <= ny < N and board[nx][ny] == color:
        board[nx][ny] = 0
        dfs(board, color, nx, ny)

def main():
  global N
  N = int(input())
  rgbBoard = [list(map(str, input().rstrip())) for _ in range(N)]
  rgBoard = copy.deepcopy(rgbBoard)
  for i in range(N):
    for j in range(N):
      if rgBoard[i][j] == "G": rgBoard[i][j] = "R"
  rgbCnt = 0
  rgCnt = 0
  for i in range(N):
    for j in range(N):
      if rgbBoard[i][j]:
        rgbCnt+=1
        dfs(rgbBoard, rgbBoard[i][j], i, j)
      if rgBoard[i][j]:
        rgCnt+=1
        dfs(rgBoard, rgBoard[i][j], i, j)
  print(rgbCnt, rgCnt)

if __name__ == "__main__":
  main()