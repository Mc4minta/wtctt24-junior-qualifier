package kotlin.c0.i.a;

import com.coinbase.ApiConstants;
import java.lang.reflect.Method;
import kotlin.jvm.internal.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebugMetadata.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: b  reason: collision with root package name */
    private static a f17266b;

    /* renamed from: c  reason: collision with root package name */
    public static final h f17267c = new h();
    private static final a a = new a(null, null, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DebugMetadata.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public final Method a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f17268b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f17269c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.f17268b = method2;
            this.f17269c = method3;
        }
    }

    private h() {
    }

    private final a a(kotlin.c0.i.a.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(ApiConstants.NAME, new Class[0]));
            f17266b = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = a;
            f17266b = aVar3;
            return aVar3;
        }
    }

    public final String b(kotlin.c0.i.a.a continuation) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        m.g(continuation, "continuation");
        a aVar = f17266b;
        if (aVar == null) {
            aVar = a(continuation);
        }
        if (aVar == a || (method = aVar.a) == null || (invoke = method.invoke(continuation.getClass(), new Object[0])) == null || (method2 = aVar.f17268b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.f17269c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        return invoke3 instanceof String ? invoke3 : null;
    }
}