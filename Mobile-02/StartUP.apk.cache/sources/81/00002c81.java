package com.facebook.imagepipeline.common;

/* compiled from: Priority.java */
/* loaded from: classes2.dex */
public enum d {
    LOW,
    MEDIUM,
    HIGH;

    public static d h(d dVar, d dVar2) {
        return dVar == null ? dVar2 : (dVar2 != null && dVar.ordinal() <= dVar2.ordinal()) ? dVar2 : dVar;
    }
}