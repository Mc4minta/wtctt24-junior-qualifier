package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: Function.java */
/* loaded from: classes2.dex */
public interface f<F, T> {
    @CanIgnoreReturnValue
    T apply(F f2);

    boolean equals(Object obj);
}