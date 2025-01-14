import hashlib
secret = "114efb32b2951bf33ae9fdad3e155cbe"
argument = "flag"
data = f"{secret}:{argument}"
flag = f"flag{{{hashlib.md5(data.encode()).hexdigest()}}}"
print(flag)