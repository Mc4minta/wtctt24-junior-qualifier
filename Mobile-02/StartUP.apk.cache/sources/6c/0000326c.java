package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b0 implements Iterator {
    private int a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f6368b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ a0 f6369c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(a0 a0Var) {
        this.f6369c = a0Var;
        this.f6368b = a0Var.size();
    }

    private final byte nextByte() {
        try {
            a0 a0Var = this.f6369c;
            int i2 = this.a;
            this.a = i2 + 1;
            return a0Var.s(i2);
        } catch (IndexOutOfBoundsException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.f6368b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}