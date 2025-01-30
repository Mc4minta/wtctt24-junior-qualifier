package kotlin.h0;

import java.util.Random;
import kotlin.jvm.internal.m;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes3.dex */
public final class b extends kotlin.h0.a {

    /* renamed from: c  reason: collision with root package name */
    private final a f17278c = new a();

    /* compiled from: PlatformRandom.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // kotlin.h0.a
    public Random e() {
        Random random = this.f17278c.get();
        m.f(random, "implStorage.get()");
        return random;
    }
}