package org.spongycastle.crypto.generators;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import okhttp3.internal.http.StatusLine;
import org.apache.http.HttpStatus;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import org.spongycastle.crypto.params.NaccacheSternKeyParameters;
import org.spongycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.Primes;

/* loaded from: classes3.dex */
public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NaccacheSternKeyGenerationParameters param;
    private static int[] smallPrimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, 199, Primes.SMALL_FACTOR_LIMIT, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, HttpStatus.SC_UNAUTHORIZED, HttpStatus.SC_CONFLICT, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, StatusLine.HTTP_MISDIRECTED_REQUEST, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, HttpStatus.SC_SERVICE_UNAVAILABLE, 509, 521, 523, 541, 547, 557};
    private static final BigInteger ONE = BigInteger.valueOf(1);

    private static Vector findFirstPrimes(int i2) {
        Vector vector = new Vector(i2);
        for (int i3 = 0; i3 != i2; i3++) {
            vector.addElement(BigInteger.valueOf(smallPrimes[i3]));
        }
        return vector;
    }

    private static BigInteger generatePrime(int i2, int i3, SecureRandom secureRandom) {
        BigInteger bigInteger = new BigInteger(i2, i3, secureRandom);
        while (bigInteger.bitLength() != i2) {
            bigInteger = new BigInteger(i2, i3, secureRandom);
        }
        return bigInteger;
    }

    private static int getInt(SecureRandom secureRandom, int i2) {
        int nextInt;
        int i3;
        if (((-i2) & i2) == i2) {
            return (int) ((i2 * (secureRandom.nextInt() & RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO)) >> 31);
        }
        do {
            nextInt = secureRandom.nextInt() & RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
            i3 = nextInt % i2;
        } while ((nextInt - i3) + (i2 - 1) < 0);
        return i3;
    }

    private static Vector permuteList(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i2 = 0; i2 < vector.size(); i2++) {
            vector3.addElement(vector.elementAt(i2));
        }
        vector2.addElement(vector3.elementAt(0));
        vector3.removeElementAt(0);
        while (vector3.size() != 0) {
            vector2.insertElementAt(vector3.elementAt(0), getInt(secureRandom, vector2.size() + 1));
            vector3.removeElementAt(0);
        }
        return vector2;
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        long j2;
        BigInteger generatePrime;
        BigInteger add;
        BigInteger generatePrime2;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger add2;
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        BigInteger bigInteger5;
        BigInteger bigInteger6;
        BigInteger bigInteger7;
        boolean z;
        BigInteger bigInteger8;
        BigInteger bigInteger9;
        int i2;
        long j3;
        BigInteger bigInteger10;
        int i3;
        int strength = this.param.getStrength();
        SecureRandom random = this.param.getRandom();
        int certainty = this.param.getCertainty();
        boolean isDebug = this.param.isDebug();
        if (isDebug) {
            PrintStream printStream = System.out;
            printStream.println("Fetching first " + this.param.getCntSmallPrimes() + " primes.");
        }
        Vector permuteList = permuteList(findFirstPrimes(this.param.getCntSmallPrimes()), random);
        BigInteger bigInteger11 = ONE;
        BigInteger bigInteger12 = bigInteger11;
        for (int i4 = 0; i4 < permuteList.size() / 2; i4++) {
            bigInteger12 = bigInteger12.multiply((BigInteger) permuteList.elementAt(i4));
        }
        for (int size = permuteList.size() / 2; size < permuteList.size(); size++) {
            bigInteger11 = bigInteger11.multiply((BigInteger) permuteList.elementAt(size));
        }
        BigInteger multiply = bigInteger12.multiply(bigInteger11);
        int bitLength = (((strength - multiply.bitLength()) - 48) / 2) + 1;
        BigInteger generatePrime3 = generatePrime(bitLength, certainty, random);
        BigInteger generatePrime4 = generatePrime(bitLength, certainty, random);
        if (isDebug) {
            System.out.println("generating p and q");
        }
        BigInteger shiftLeft = generatePrime3.multiply(bigInteger12).shiftLeft(1);
        BigInteger shiftLeft2 = generatePrime4.multiply(bigInteger11).shiftLeft(1);
        long j4 = 0;
        while (true) {
            j2 = j4 + 1;
            generatePrime = generatePrime(24, certainty, random);
            add = generatePrime.multiply(shiftLeft).add(ONE);
            if (add.isProbablePrime(certainty)) {
                while (true) {
                    do {
                        generatePrime2 = generatePrime(24, certainty, random);
                    } while (generatePrime.equals(generatePrime2));
                    BigInteger multiply2 = generatePrime2.multiply(shiftLeft2);
                    bigInteger = shiftLeft2;
                    bigInteger2 = ONE;
                    add2 = multiply2.add(bigInteger2);
                    if (add2.isProbablePrime(certainty)) {
                        break;
                    }
                    shiftLeft2 = bigInteger;
                }
                bigInteger3 = shiftLeft;
                if (!multiply.gcd(generatePrime.multiply(generatePrime2)).equals(bigInteger2)) {
                    continue;
                } else if (add.multiply(add2).bitLength() >= strength) {
                    break;
                } else if (isDebug) {
                    PrintStream printStream2 = System.out;
                    printStream2.println("key size too small. Should be " + strength + " but is actually " + add.multiply(add2).bitLength());
                }
            } else {
                bigInteger = shiftLeft2;
                bigInteger3 = shiftLeft;
            }
            j4 = j2;
            shiftLeft2 = bigInteger;
            shiftLeft = bigInteger3;
        }
        BigInteger bigInteger13 = generatePrime4;
        if (isDebug) {
            PrintStream printStream3 = System.out;
            bigInteger4 = generatePrime3;
            printStream3.println("needed " + j2 + " tries to generate p and q.");
        } else {
            bigInteger4 = generatePrime3;
        }
        BigInteger multiply3 = add.multiply(add2);
        BigInteger multiply4 = add.subtract(bigInteger2).multiply(add2.subtract(bigInteger2));
        if (isDebug) {
            System.out.println("generating g");
        }
        long j5 = 0;
        while (true) {
            Vector vector = new Vector();
            bigInteger5 = add;
            bigInteger6 = add2;
            int i5 = 0;
            while (i5 != permuteList.size()) {
                BigInteger divide = multiply4.divide((BigInteger) permuteList.elementAt(i5));
                while (true) {
                    j3 = j5 + 1;
                    bigInteger10 = new BigInteger(strength, certainty, random);
                    i3 = strength;
                    if (bigInteger10.modPow(divide, multiply3).equals(ONE)) {
                        j5 = j3;
                        strength = i3;
                    }
                }
                vector.addElement(bigInteger10);
                i5++;
                j5 = j3;
                strength = i3;
            }
            int i6 = strength;
            bigInteger7 = ONE;
            int i7 = 0;
            while (i7 < permuteList.size()) {
                bigInteger7 = bigInteger7.multiply(((BigInteger) vector.elementAt(i7)).modPow(multiply.divide((BigInteger) permuteList.elementAt(i7)), multiply3)).mod(multiply3);
                i7++;
                random = random;
            }
            SecureRandom secureRandom = random;
            int i8 = 0;
            while (true) {
                if (i8 >= permuteList.size()) {
                    z = false;
                    break;
                } else if (bigInteger7.modPow(multiply4.divide((BigInteger) permuteList.elementAt(i8)), multiply3).equals(ONE)) {
                    if (isDebug) {
                        PrintStream printStream4 = System.out;
                        printStream4.println("g has order phi(n)/" + permuteList.elementAt(i8) + "\n g: " + bigInteger7);
                    }
                    z = true;
                } else {
                    i8++;
                }
            }
            if (!z) {
                BigInteger modPow = bigInteger7.modPow(multiply4.divide(BigInteger.valueOf(4L)), multiply3);
                BigInteger bigInteger14 = ONE;
                if (modPow.equals(bigInteger14)) {
                    if (isDebug) {
                        PrintStream printStream5 = System.out;
                        printStream5.println("g has order phi(n)/4\n g:" + bigInteger7);
                    }
                } else if (bigInteger7.modPow(multiply4.divide(generatePrime), multiply3).equals(bigInteger14)) {
                    if (isDebug) {
                        PrintStream printStream6 = System.out;
                        printStream6.println("g has order phi(n)/p'\n g: " + bigInteger7);
                    }
                } else if (!bigInteger7.modPow(multiply4.divide(generatePrime2), multiply3).equals(bigInteger14)) {
                    bigInteger8 = bigInteger4;
                    if (!bigInteger7.modPow(multiply4.divide(bigInteger8), multiply3).equals(bigInteger14)) {
                        bigInteger9 = bigInteger13;
                        if (!bigInteger7.modPow(multiply4.divide(bigInteger9), multiply3).equals(bigInteger14)) {
                            break;
                        } else if (isDebug) {
                            PrintStream printStream7 = System.out;
                            StringBuilder sb = new StringBuilder();
                            i2 = certainty;
                            sb.append("g has order phi(n)/b\n g: ");
                            sb.append(bigInteger7);
                            printStream7.println(sb.toString());
                            bigInteger4 = bigInteger8;
                            certainty = i2;
                            add2 = bigInteger6;
                            add = bigInteger5;
                            strength = i6;
                            random = secureRandom;
                            bigInteger13 = bigInteger9;
                        }
                    } else {
                        if (isDebug) {
                            PrintStream printStream8 = System.out;
                            printStream8.println("g has order phi(n)/a\n g: " + bigInteger7);
                        }
                        bigInteger9 = bigInteger13;
                    }
                    i2 = certainty;
                    bigInteger4 = bigInteger8;
                    certainty = i2;
                    add2 = bigInteger6;
                    add = bigInteger5;
                    strength = i6;
                    random = secureRandom;
                    bigInteger13 = bigInteger9;
                } else if (isDebug) {
                    PrintStream printStream9 = System.out;
                    printStream9.println("g has order phi(n)/q'\n g: " + bigInteger7);
                }
            }
            bigInteger9 = bigInteger13;
            bigInteger8 = bigInteger4;
            i2 = certainty;
            bigInteger4 = bigInteger8;
            certainty = i2;
            add2 = bigInteger6;
            add = bigInteger5;
            strength = i6;
            random = secureRandom;
            bigInteger13 = bigInteger9;
        }
        if (isDebug) {
            PrintStream printStream10 = System.out;
            printStream10.println("needed " + j5 + " tries to generate g");
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            PrintStream printStream11 = System.out;
            printStream11.println("smallPrimes: " + permuteList);
            PrintStream printStream12 = System.out;
            printStream12.println("sigma:...... " + multiply + " (" + multiply.bitLength() + " bits)");
            PrintStream printStream13 = System.out;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("a:.......... ");
            sb2.append(bigInteger8);
            printStream13.println(sb2.toString());
            PrintStream printStream14 = System.out;
            printStream14.println("b:.......... " + bigInteger9);
            PrintStream printStream15 = System.out;
            printStream15.println("p':......... " + generatePrime);
            PrintStream printStream16 = System.out;
            printStream16.println("q':......... " + generatePrime2);
            PrintStream printStream17 = System.out;
            printStream17.println("p:.......... " + bigInteger5);
            PrintStream printStream18 = System.out;
            printStream18.println("q:.......... " + bigInteger6);
            PrintStream printStream19 = System.out;
            printStream19.println("n:.......... " + multiply3);
            PrintStream printStream20 = System.out;
            printStream20.println("phi(n):..... " + multiply4);
            PrintStream printStream21 = System.out;
            printStream21.println("g:.......... " + bigInteger7);
            System.out.println();
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NaccacheSternKeyParameters(false, bigInteger7, multiply3, multiply.bitLength()), (AsymmetricKeyParameter) new NaccacheSternPrivateKeyParameters(bigInteger7, multiply3, multiply.bitLength(), permuteList, multiply4));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (NaccacheSternKeyGenerationParameters) keyGenerationParameters;
    }
}