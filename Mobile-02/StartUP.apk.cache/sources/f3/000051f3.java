package kotlin.h0.e;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.m;

/* compiled from: PlatformThreadLocalRandom.kt */
/* loaded from: classes3.dex */
public final class a extends kotlin.h0.a {
    @Override // kotlin.h0.c
    public int d(int i2, int i3) {
        return ThreadLocalRandom.current().nextInt(i2, i3);
    }

    @Override // kotlin.h0.a
    public Random e() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        m.f(current, "ThreadLocalRandom.current()");
        return current;
    }
}