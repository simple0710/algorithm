def main():
  N, K = map(int,input().split())
  room = [[0] * 7 for _ in range(2)]
  for _ in range(N):
    S, Y = map(int,input().split())
    room[S][Y] += 1
  res = 0
  for i in room:
    for j in i:
      res += j // K
      if j % K:
        res += 1
  print(res)

if __name__ == "__main__":
  main()