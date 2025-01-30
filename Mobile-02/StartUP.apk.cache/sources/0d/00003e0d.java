package com.journeyapps.barcodescanner;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: DefaultDecoderFactory.java */
/* loaded from: classes2.dex */
public class i implements f {
    private Collection<com.google.zxing.a> a;

    /* renamed from: b  reason: collision with root package name */
    private Map<com.google.zxing.d, ?> f10380b;

    /* renamed from: c  reason: collision with root package name */
    private String f10381c;

    /* renamed from: d  reason: collision with root package name */
    private int f10382d;

    public i() {
    }

    @Override // com.journeyapps.barcodescanner.f
    public e a(Map<com.google.zxing.d, ?> map) {
        EnumMap enumMap = new EnumMap(com.google.zxing.d.class);
        enumMap.putAll(map);
        Map<com.google.zxing.d, ?> map2 = this.f10380b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection<com.google.zxing.a> collection = this.a;
        if (collection != null) {
            enumMap.put((EnumMap) com.google.zxing.d.POSSIBLE_FORMATS, (com.google.zxing.d) collection);
        }
        String str = this.f10381c;
        if (str != null) {
            enumMap.put((EnumMap) com.google.zxing.d.CHARACTER_SET, (com.google.zxing.d) str);
        }
        com.google.zxing.h hVar = new com.google.zxing.h();
        hVar.e(enumMap);
        int i2 = this.f10382d;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return new e(hVar);
                }
                return new k(hVar);
            }
            return new j(hVar);
        }
        return new e(hVar);
    }

    public i(Collection<com.google.zxing.a> collection, Map<com.google.zxing.d, ?> map, String str, int i2) {
        this.a = collection;
        this.f10380b = map;
        this.f10381c = str;
        this.f10382d = i2;
    }
}