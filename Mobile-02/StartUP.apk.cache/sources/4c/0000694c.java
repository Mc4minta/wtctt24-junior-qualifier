package org.spongycastle.util;

/* loaded from: classes3.dex */
public interface Memoable {
    Memoable copy();

    void reset(Memoable memoable);
}