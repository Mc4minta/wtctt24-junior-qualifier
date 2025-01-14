import hashlib

def main():
    print("=== Roll the Dice for the Highest Score ===")
    print("Each die has 6 sides (1-6)")
    print("If you roll the highest number (6) on each die and need a total score of 24,")
    print("how many dice would you need?")
    print("------------------------")
    
    try:
        dice = int(input("Enter the number of dice: "))
        
        MAX_SUM = dice * 6
        
        if MAX_SUM == 24:
            fIag = "flag{d1c3_1s_l1f3}"
            secret = "dice_master"
            flag = hashlib.md5(f"{secret}:{dice}".encode()).hexdigest()
            print(f"\nCongratulations! You answered correctly!")
            print(f"Flag: flag{{{fIag}}}")
        else:
            print(f"\nIf you roll {dice} dice,")
            print(f"The maximum possible score is {MAX_SUM}.")
            print(f"(You need a total score of 24)")
            print("Try again!")

    except ValueError:
        print("\nPlease enter numbers only.")
main()
