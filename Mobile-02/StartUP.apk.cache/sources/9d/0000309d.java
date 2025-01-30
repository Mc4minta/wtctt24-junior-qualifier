package com.google.android.datatransport.cct;

import e.g.a.c.b;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
public final class a implements e.g.a.c.i.f {
    static final String a;

    /* renamed from: b  reason: collision with root package name */
    static final String f5727b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f5728c;

    /* renamed from: d  reason: collision with root package name */
    private static final Set<b> f5729d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f5730e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f5731f;

    /* renamed from: g  reason: collision with root package name */
    private final String f5732g;

    /* renamed from: h  reason: collision with root package name */
    private final String f5733h;

    static {
        String a2 = f.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        a = a2;
        String a3 = f.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f5727b = a3;
        String a4 = f.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f5728c = a4;
        f5729d = Collections.unmodifiableSet(new HashSet(Arrays.asList(b.b("proto"), b.b("json"))));
        f5730e = new a(a2, null);
        f5731f = new a(a3, a4);
    }

    public a(String str, String str2) {
        this.f5732g = str;
        this.f5733h = str2;
    }

    public static a d(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    @Override // e.g.a.c.i.f
    public Set<b> a() {
        return f5729d;
    }

    @Override // e.g.a.c.i.e
    public byte[] b() {
        return c();
    }

    public byte[] c() {
        String str = this.f5733h;
        if (str == null && this.f5732g == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f5732g;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    public String e() {
        return this.f5733h;
    }

    public String f() {
        return this.f5732g;
    }

    @Override // e.g.a.c.i.e
    public String getName() {
        return "cct";
    }
}