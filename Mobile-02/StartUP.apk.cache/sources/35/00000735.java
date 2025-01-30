package com.appsflyer.internal;

import android.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: ı  reason: contains not printable characters */
    public String f264;

    /* renamed from: ǃ  reason: contains not printable characters */
    public String f265;

    /* renamed from: ɩ  reason: contains not printable characters */
    public String f266;

    /* renamed from: ι  reason: contains not printable characters */
    private byte[] f267;

    j() {
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public final byte[] m181() {
        return this.f267;
    }

    public j(String str, byte[] bArr, String str2) {
        this.f264 = str;
        this.f267 = bArr;
        this.f266 = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        int i2 = 0;
        int i3 = 0;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.f264 = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.f266 = nextLine.substring(8).trim();
                Matcher matcher = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.f266);
                if (matcher.matches()) {
                    i2 = Integer.parseInt(matcher.group(1));
                    i3 = Integer.parseInt(matcher.group(2));
                }
            } else if (nextLine.startsWith("data=")) {
                String trim = nextLine.substring(5).trim();
                this.f267 = (i2 > 4 || i3 >= 11) ? Base64.decode(trim, 2) : trim.getBytes();
            }
        }
        scanner.close();
    }
}