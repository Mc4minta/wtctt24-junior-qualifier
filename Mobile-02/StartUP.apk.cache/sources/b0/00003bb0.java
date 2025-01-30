package com.google.firebase.remoteconfig;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public interface h {
    long a() throws IllegalArgumentException;

    boolean asBoolean() throws IllegalArgumentException;

    double asDouble() throws IllegalArgumentException;

    String asString();

    int getSource();
}