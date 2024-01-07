def main():
  n = int(input())
  res = set()
  for i in range(n):
    name, enterFlag = input().split(" ")
    res.add(name)
    if (enterFlag == "leave"): res.remove(name)
  for i in sorted(res, reverse=True): print(i)

if __name__ == "__main__":
  main()