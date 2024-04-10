res = []
for i in range(1, 6):
  if "FBI" in input(): res.append(i)
print(" ".join(map(str, res)) if len(res) else "HE GOT AWAY!")