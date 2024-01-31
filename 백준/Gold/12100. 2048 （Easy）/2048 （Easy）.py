import sys, copy
input = sys.stdin.readline

def dfs(board, turn, depth):
  global res
  if depth == 5:
    p = 0
    for col in board:
      res = max(res, max(col))
    return
  n_board = copy.deepcopy(board)
  if turn == 0:
    for i in range(N):
      for j in range(N):
        if n_board[i][j] == 0:
          continue
        move_left(n_board, i, j)
  elif turn == 1:
    for i in range(N):
      for j in range(N-1, -1, -1):
        if n_board[i][j] == 0:
          continue
        move_right(n_board, i, j)
  elif turn == 2:
    for i in range(N):
      for j in range(N):
        if n_board[j][i] == 0:
          continue
        move_up(n_board, j, i)
  else:
    for i in range(N):
      for j in range(N-1, -1, -1):
        if n_board[j][i] == 0:
          continue
        move_down(n_board, j, i)

  for i in range(4):
    dfs(n_board, i, depth + 1)

def move_right(board, x, y):
  for i in range(y-1, -1, -1):
    if board[x][i] != 0:
      if board[x][y] == board[x][i]:
        board[x][y] = board[x][y] * 2
        board[x][i] = 0
        break
      else:
        break
  value = board[x][y]
  board[x][y] = 0
  for i in range(y+1, N):
    if board[x][i] == 0:
      y = i
    else:
      break
  board[x][y] = value

def move_left(board, x, y):
  for i in range(y+1, N):
    if board[x][i] != 0:
      if board[x][y] == board[x][i]:
        board[x][y] = board[x][y] * 2
        board[x][i] = 0
        break
      else:
        break
  value = board[x][y]
  board[x][y] = 0
  for i in range(y-1, -1, -1):
    if board[x][i] == 0:
      y = i
    else:
      break
  board[x][y] = value

def move_down(board, x, y):
  for i in range(x-1, -1, -1):
    if board[i][y] != 0:
      if board[x][y] == board[i][y]:
        board[x][y] = board[x][y] * 2
        board[i][y] = 0
        break
      else:
        break
  value = board[x][y]
  board[x][y] = 0
  for i in range(x+1, N):
    if board[i][y] == 0:
      x = i
    else:
      break
  board[x][y] = value

def move_up(board, x, y):
  for i in range(x+1, N):
    if board[i][y] != 0:
      if board[x][y] == board[i][y]:
        board[x][y] = board[x][y] * 2
        board[i][y] = 0
        break
      else:
        break
  value = board[x][y]
  board[x][y] = 0
  for i in range(x-1, -1, -1):
    if board[i][y] == 0:
      x = i
    else:
      break
  board[x][y] = value
    
N = int(input())
board = [list(map(int,input().split())) for _ in range(N)]

res = 0
for i in range(4):
  dfs(board, i, 0)

print(res)