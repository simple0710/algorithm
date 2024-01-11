from itertools import combinations
import sys
input = sys.stdin.readline

def solution(N):
  nums = []
  for i in range(1, 11):
    for j in combinations(range(10), i):
      j = sorted(list(j), reverse=True)
      nums.append(int("".join(map(str, j))))
  nums.sort()
  return nums[N] if len(nums) > N else -1

def main():
  N = int(input())
  print(solution(N))

if __name__ == "__main__":
  main()