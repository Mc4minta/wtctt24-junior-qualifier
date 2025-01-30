package kotlin.h0;

import java.util.Random;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes3.dex */
public abstract class a extends c {
    @Override // kotlin.h0.c
    public int b(int i2) {
        return d.d(e().nextInt(), i2);
    }

    @Override // kotlin.h0.c
    public int c() {
        return e().nextInt();
    }

    public abstract Random e();
}