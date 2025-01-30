package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import java.security.MessageDigest;
import java.util.Formatter;

/* loaded from: classes.dex */
public final class z {
    z() {
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static String m206(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            return m209(messageDigest.digest());
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to MD5");
            AFLogger.afErrorLog(sb.toString(), e2);
            return null;
        }
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public static String m207(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("Error turning ");
            sb2.append(str.substring(0, 6));
            sb2.append(".. to SHA-256");
            AFLogger.afErrorLog(sb2.toString(), e2);
            return null;
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    public static String m208(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            return m209(messageDigest.digest());
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA1");
            AFLogger.afErrorLog(sb.toString(), e2);
            return null;
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    public static String m210(long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        sb.append(j2);
        return m208(sb.toString());
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static String m209(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            formatter.format("%02x", Byte.valueOf(bArr[i2]));
        }
        String obj = formatter.toString();
        formatter.close();
        return obj;
    }
}