package com.facebook.imagepipeline.common;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import e.f.d.c.i;
import java.util.regex.Pattern;

/* compiled from: BytesRange.java */
/* loaded from: classes2.dex */
public class a {
    private static Pattern a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4507b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4508c;

    public a(int i2, int i3) {
        this.f4507b = i2;
        this.f4508c = i3;
    }

    public static a b(int i2) {
        i.b(i2 >= 0);
        return new a(i2, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public static a c(String str) throws IllegalArgumentException {
        if (str == null) {
            return null;
        }
        if (a == null) {
            a = Pattern.compile("[-/ ]");
        }
        try {
            String[] split = a.split(str);
            i.b(split.length == 4);
            i.b(split[0].equals("bytes"));
            int parseInt = Integer.parseInt(split[1]);
            int parseInt2 = Integer.parseInt(split[2]);
            int parseInt3 = Integer.parseInt(split[3]);
            i.b(parseInt2 > parseInt);
            i.b(parseInt3 > parseInt2);
            if (parseInt2 < parseInt3 - 1) {
                return new a(parseInt, parseInt2);
            }
            return new a(parseInt, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(String.format(null, "Invalid Content-Range header value: \"%s\"", str), e2);
        }
    }

    public static a e(int i2) {
        i.b(i2 > 0);
        return new a(0, i2);
    }

    private static String f(int i2) {
        return i2 == Integer.MAX_VALUE ? "" : Integer.toString(i2);
    }

    public boolean a(a aVar) {
        return aVar != null && this.f4507b <= aVar.f4507b && this.f4508c >= aVar.f4508c;
    }

    public String d() {
        return String.format(null, "bytes=%s-%s", f(this.f4507b), f(this.f4508c));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f4507b == aVar.f4507b && this.f4508c == aVar.f4508c;
        }
        return false;
    }

    public int hashCode() {
        return com.facebook.common.util.a.a(this.f4507b, this.f4508c);
    }

    public String toString() {
        return String.format(null, "%s-%s", f(this.f4507b), f(this.f4508c));
    }
}