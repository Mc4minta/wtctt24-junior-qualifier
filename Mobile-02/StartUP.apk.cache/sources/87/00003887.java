package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: AbstractIterator.java */
/* loaded from: classes2.dex */
abstract class a<T> implements Iterator<T> {
    private b a = b.NOT_READY;

    /* renamed from: b  reason: collision with root package name */
    private T f8418b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractIterator.java */
    /* renamed from: com.google.common.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0154a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractIterator.java */
    /* loaded from: classes2.dex */
    public enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean d() {
        this.a = b.FAILED;
        this.f8418b = b();
        if (this.a != b.DONE) {
            this.a = b.READY;
            return true;
        }
        return false;
    }

    protected abstract T b();

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public final T c() {
        this.a = b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        l.o(this.a != b.FAILED);
        int i2 = C0154a.a[this.a.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return d();
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.a = b.NOT_READY;
            T t = this.f8418b;
            this.f8418b = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}