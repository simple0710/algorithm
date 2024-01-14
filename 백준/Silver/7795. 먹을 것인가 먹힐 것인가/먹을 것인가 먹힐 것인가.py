for _ in range(int(input())):
  N, M = map(int,input().split())
  A = sorted(list(map(int,input().split())), reverse=True)
  B = sorted(list(map(int,input().split())))
  res = 0
  e = M - 1
  for i in A:
    while e >= 0:
      if B[e] < i:
        res += e + 1
        break
      else:
        e -= 1
  print(res)