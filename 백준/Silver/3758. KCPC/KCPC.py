import sys
input = sys.stdin.readline

def solution():
  n, k, t, m = map(int,input().split())
  score = [[0] * (k+3) + [i] for i in range(n+1)]
  for idx in range(m):
    i, j, s = map(int,input().split())
    score[i][j] = max(score[i][j], s)
    score[i][k+1] += 1
    score[i][k+2] = idx
  score = score[1:]
  score.sort(key=lambda x:(-sum(x[:k+1]), x[k+1], x[k+2]))
  for i in range(n):
    if score[i][k+3] == t:
      return i + 1

def main():
  T = int(input())
  for _ in range(T):
    print(solution())

if __name__ == "__main__":
  main()