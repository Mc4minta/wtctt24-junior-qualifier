def validate_args():
    if len(sys.argv) != 4:
        print("Error: You must specify an option (--key/-k), key.txt, and what you want ^o^")
        return None
    option, keyfile, argument = sys.argv[1], sys.argv[2], sys.argv[3]
    # Check for empty strings
    if not all([option, keyfile, argument]):
        print("Error: None of the input parameters can be empty")
        return None
    if option not in ['--key', '-k']:
        print("Error: Invalid option. Use '--key' for encryption or '-k' for decryption.")
        return None
    if not argument.isalnum() or len(argument) != 4:
        print("Error: Argument must be a 4-character alphanumeric string.")
        return None
    return option, keyfile, argument

def keyman():
    args = validate_args()
    if args is None:
        return    
    option, keyfile, argument = args    
    try:
        with open(keyfile, 'r') as f:
            secret = f.read().strip()
        if not secret:
            print("Error: Key file is empty.")
            return
        #data = f"{secret}:{argument}"
        flag = f"flag{{{hashlib.md5(data.encode()).hexdigest()}}}"
        print(flag)
    except FileNotFoundError:
        print(f"Error: The file '{keyfile}' was not found.")
    except Exception as e:
        print(f"Error: {str(e)}")
#if __name__ == "__main__":
#   keyman()
