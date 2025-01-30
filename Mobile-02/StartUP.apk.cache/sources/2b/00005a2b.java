package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.c0.f;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Executors.kt */
/* loaded from: classes3.dex */
public abstract class k0 extends t implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f17517b = new a(null);

    /* compiled from: Executors.kt */
    /* loaded from: classes3.dex */
    public static final class a extends kotlin.c0.b<t, k0> {

        /* compiled from: Executors.kt */
        /* renamed from: kotlinx.coroutines.k0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0422a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<f.b, k0> {
            public static final C0422a a = new C0422a();

            C0422a() {
                super(1);
            }

            @Override // kotlin.e0.c.l
            /* renamed from: a */
            public final k0 invoke(f.b bVar) {
                if (!(bVar instanceof k0)) {
                    bVar = null;
                }
                return (k0) bVar;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
            super(t.a, C0422a.a);
        }
    }
}