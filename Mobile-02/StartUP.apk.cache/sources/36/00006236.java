package org.spongycastle.crypto.generators;

import com.coinbase.wallet.core.extensions.Strings;
import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class OpenBSDBCrypt {
    private static final String version = "2a";
    private static final byte[] encodingTable = {46, 47, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
    private static final byte[] decodingTable = new byte[128];

    static {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = decodingTable;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        while (true) {
            byte[] bArr2 = encodingTable;
            if (i2 >= bArr2.length) {
                return;
            }
            decodingTable[bArr2[i2]] = (byte) i2;
            i2++;
        }
    }

    public static boolean checkPassword(String str, char[] cArr) {
        if (str.length() == 60) {
            if (str.charAt(0) == '$' && str.charAt(3) == '$' && str.charAt(6) == '$') {
                if (str.substring(1, 3).equals(version)) {
                    try {
                        int parseInt = Integer.parseInt(str.substring(4, 6));
                        if (parseInt >= 4 && parseInt <= 31) {
                            if (cArr != null) {
                                return str.equals(generate(cArr, decodeSaltString(str.substring(str.lastIndexOf(36) + 1, str.length() - 31)), parseInt));
                            }
                            throw new IllegalArgumentException("Missing password.");
                        }
                        throw new IllegalArgumentException("Invalid cost factor: " + parseInt + ", 4 < cost < 31 expected.");
                    } catch (NumberFormatException unused) {
                        throw new IllegalArgumentException("Invalid cost factor:" + str.substring(4, 6));
                    }
                }
                throw new IllegalArgumentException("Wrong Bcrypt version, 2a expected.");
            }
            throw new IllegalArgumentException("Invalid Bcrypt String format.");
        }
        throw new DataLengthException("Bcrypt String length: " + str.length() + ", 60 required.");
    }

    private static String createBcryptString(byte[] bArr, byte[] bArr2, int i2) {
        String num;
        StringBuffer stringBuffer = new StringBuffer(60);
        stringBuffer.append('$');
        stringBuffer.append(version);
        stringBuffer.append('$');
        if (i2 < 10) {
            num = Strings.zero + i2;
        } else {
            num = Integer.toString(i2);
        }
        stringBuffer.append(num);
        stringBuffer.append('$');
        stringBuffer.append(encodeData(bArr2));
        stringBuffer.append(encodeData(BCrypt.generate(bArr, bArr2, i2)));
        return stringBuffer.toString();
    }

    private static byte[] decodeSaltString(String str) {
        char[] charArray = str.toCharArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16);
        if (charArray.length == 22) {
            for (char c2 : charArray) {
                if (c2 > 'z' || c2 < '.' || (c2 > '9' && c2 < 'A')) {
                    throw new IllegalArgumentException("Salt string contains invalid character: " + ((int) c2));
                }
            }
            char[] cArr = new char[24];
            System.arraycopy(charArray, 0, cArr, 0, charArray.length);
            for (int i2 = 0; i2 < 24; i2 += 4) {
                byte[] bArr = decodingTable;
                byte b2 = bArr[cArr[i2]];
                byte b3 = bArr[cArr[i2 + 1]];
                byte b4 = bArr[cArr[i2 + 2]];
                byte b5 = bArr[cArr[i2 + 3]];
                byteArrayOutputStream.write((b2 << 2) | (b3 >> 4));
                byteArrayOutputStream.write((b3 << 4) | (b4 >> 2));
                byteArrayOutputStream.write(b5 | (b4 << 6));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byte[] bArr2 = new byte[16];
            System.arraycopy(byteArray, 0, bArr2, 0, 16);
            return bArr2;
        }
        throw new DataLengthException("Invalid base64 salt length: " + charArray.length + " , 22 required.");
    }

    private static String encodeData(byte[] bArr) {
        boolean z;
        if (bArr.length != 24 && bArr.length != 16) {
            throw new DataLengthException("Invalid length: " + bArr.length + ", 24 for key or 16 for salt expected");
        }
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[18];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr = bArr2;
            z = true;
        } else {
            bArr[bArr.length - 1] = 0;
            z = false;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = bArr[i2] & 255;
            int i4 = bArr[i2 + 1] & 255;
            int i5 = bArr[i2 + 2] & 255;
            byte[] bArr3 = encodingTable;
            byteArrayOutputStream.write(bArr3[(i3 >>> 2) & 63]);
            byteArrayOutputStream.write(bArr3[((i3 << 4) | (i4 >>> 4)) & 63]);
            byteArrayOutputStream.write(bArr3[((i4 << 2) | (i5 >>> 6)) & 63]);
            byteArrayOutputStream.write(bArr3[i5 & 63]);
        }
        String fromByteArray = org.spongycastle.util.Strings.fromByteArray(byteArrayOutputStream.toByteArray());
        if (z) {
            return fromByteArray.substring(0, 22);
        }
        return fromByteArray.substring(0, fromByteArray.length() - 1);
    }

    public static String generate(char[] cArr, byte[] bArr, int i2) {
        if (cArr != null) {
            if (bArr != null) {
                if (bArr.length != 16) {
                    throw new DataLengthException("16 byte salt required: " + bArr.length);
                } else if (i2 >= 4 && i2 <= 31) {
                    byte[] uTF8ByteArray = org.spongycastle.util.Strings.toUTF8ByteArray(cArr);
                    int length = uTF8ByteArray.length < 72 ? uTF8ByteArray.length + 1 : 72;
                    byte[] bArr2 = new byte[length];
                    if (length > uTF8ByteArray.length) {
                        System.arraycopy(uTF8ByteArray, 0, bArr2, 0, uTF8ByteArray.length);
                    } else {
                        System.arraycopy(uTF8ByteArray, 0, bArr2, 0, length);
                    }
                    Arrays.fill(uTF8ByteArray, (byte) 0);
                    String createBcryptString = createBcryptString(bArr2, bArr, i2);
                    Arrays.fill(bArr2, (byte) 0);
                    return createBcryptString;
                } else {
                    throw new IllegalArgumentException("Invalid cost factor.");
                }
            }
            throw new IllegalArgumentException("Salt required.");
        }
        throw new IllegalArgumentException("Password required.");
    }
}