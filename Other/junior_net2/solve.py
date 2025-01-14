from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import hashes
import base64

# load private key
with open("private_key.pem", "rb") as key_file:
    private_key = serialization.load_pem_private_key(
        key_file.read(),
        password=None,
    )

encrypted_data = base64.b64decode("m3/oQS/FYXuPgKEsoCXO2NCBxkEAtMycpnl+2vY0VMaOgAGuyciaQNzYAJtSF/JpRILcmDOHJ6TRyFVw3OoEGWcSKydSbneDVgQXIEptRh0z4kvW/5ixC9o1T0Q0Yn2oH/g3mxVIng1NVzMJzENlOO1vUPtn8ktdxvW939Ovt0h4Z8HkxAwDBAsvFWA6AIALhXhb9Ih3UWx/xQoQfrf468sQldMUS29QyOHCPhpAi1CPIikiXx2Teid7AFagvFcJ2OzTax8pg3VzPv/kLnzkMxclLJA8e7/O3Mj1S+08MzU9HaDJi4Emxu+L8LoYfQHVqxkkFi3pI7v2bq/7kBWQLA==")

# decrypt data
decrypted_data = private_key.decrypt(
    encrypted_data,
    padding.OAEP(
        mgf=padding.MGF1(algorithm=hashes.SHA256()),
        algorithm=hashes.SHA256(),
        label=None
    )
)

print(decrypted_data.decode())