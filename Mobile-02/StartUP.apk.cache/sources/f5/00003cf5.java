package com.google.zxing.p.a;

import android.content.Intent;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: DecodeFormatManager.java */
/* loaded from: classes2.dex */
public final class c {
    private static final Pattern a = Pattern.compile(",");

    /* renamed from: b  reason: collision with root package name */
    static final Set<com.google.zxing.a> f9886b;

    /* renamed from: c  reason: collision with root package name */
    static final Set<com.google.zxing.a> f9887c;

    /* renamed from: d  reason: collision with root package name */
    private static final Set<com.google.zxing.a> f9888d;

    /* renamed from: e  reason: collision with root package name */
    static final Set<com.google.zxing.a> f9889e;

    /* renamed from: f  reason: collision with root package name */
    static final Set<com.google.zxing.a> f9890f;

    /* renamed from: g  reason: collision with root package name */
    static final Set<com.google.zxing.a> f9891g;

    /* renamed from: h  reason: collision with root package name */
    static final Set<com.google.zxing.a> f9892h;

    /* renamed from: i  reason: collision with root package name */
    private static final Map<String, Set<com.google.zxing.a>> f9893i;

    static {
        EnumSet of = EnumSet.of(com.google.zxing.a.QR_CODE);
        f9889e = of;
        EnumSet of2 = EnumSet.of(com.google.zxing.a.DATA_MATRIX);
        f9890f = of2;
        EnumSet of3 = EnumSet.of(com.google.zxing.a.AZTEC);
        f9891g = of3;
        EnumSet of4 = EnumSet.of(com.google.zxing.a.PDF_417);
        f9892h = of4;
        EnumSet of5 = EnumSet.of(com.google.zxing.a.UPC_A, com.google.zxing.a.UPC_E, com.google.zxing.a.EAN_13, com.google.zxing.a.EAN_8, com.google.zxing.a.RSS_14, com.google.zxing.a.RSS_EXPANDED);
        f9886b = of5;
        EnumSet of6 = EnumSet.of(com.google.zxing.a.CODE_39, com.google.zxing.a.CODE_93, com.google.zxing.a.CODE_128, com.google.zxing.a.ITF, com.google.zxing.a.CODABAR);
        f9887c = of6;
        EnumSet copyOf = EnumSet.copyOf((Collection) of5);
        f9888d = copyOf;
        copyOf.addAll(of6);
        HashMap hashMap = new HashMap();
        f9893i = hashMap;
        hashMap.put("ONE_D_MODE", copyOf);
        hashMap.put("PRODUCT_MODE", of5);
        hashMap.put("QR_CODE_MODE", of);
        hashMap.put("DATA_MATRIX_MODE", of2);
        hashMap.put("AZTEC_MODE", of3);
        hashMap.put("PDF417_MODE", of4);
    }

    public static Set<com.google.zxing.a> a(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return b(stringExtra != null ? Arrays.asList(a.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }

    private static Set<com.google.zxing.a> b(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet noneOf = EnumSet.noneOf(com.google.zxing.a.class);
            try {
                for (String str2 : iterable) {
                    noneOf.add(com.google.zxing.a.valueOf(str2));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f9893i.get(str);
        }
        return null;
    }
}