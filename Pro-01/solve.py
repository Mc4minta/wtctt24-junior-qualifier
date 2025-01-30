import hashlib
dice = 4
secret = "dice_master"
flag = hashlib.md5(f"{secret}:{dice}".encode()).hexdigest()
print(f"flag{{{flag}}}")