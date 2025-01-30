package kotlin.i0;

import java.util.NoSuchElementException;
import kotlin.a0.h0;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes3.dex */
public final class b extends h0 {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17283b;

    /* renamed from: c  reason: collision with root package name */
    private int f17284c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17285d;

    public b(int i2, int i3, int i4) {
        this.f17285d = i4;
        this.a = i3;
        boolean z = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.f17283b = z;
        this.f17284c = z ? i2 : i3;
    }

    @Override // kotlin.a0.h0
    public int c() {
        int i2 = this.f17284c;
        if (i2 == this.a) {
            if (this.f17283b) {
                this.f17283b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f17284c = this.f17285d + i2;
        }
        return i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f17283b;
    }
}