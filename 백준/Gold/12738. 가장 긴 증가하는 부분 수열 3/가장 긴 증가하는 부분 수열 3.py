N = int(input())
data = list(map(int,input().split()))
lis = [data[0]]
for v in data:
  if lis[-1] < v:
    lis.append(v)
  else:
    s = 0
    e = len(lis)
    while s < e:
      mid = (s + e) // 2
      if lis[mid] < v:
        s = mid + 1
      else:
        e = mid
    lis[e] = v
print(len(lis))