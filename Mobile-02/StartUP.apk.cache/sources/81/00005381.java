package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.a0.p;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: BuiltInsLoader.kt */
/* loaded from: classes3.dex */
final class BuiltInsLoader$Companion$Instance$2 extends o implements a<BuiltInsLoader> {
    public static final BuiltInsLoader$Companion$Instance$2 INSTANCE = new BuiltInsLoader$Companion$Instance$2();

    BuiltInsLoader$Companion$Instance$2() {
        super(0);
    }

    @Override // kotlin.e0.c.a
    public final BuiltInsLoader invoke() {
        ServiceLoader implementations = ServiceLoader.load(BuiltInsLoader.class, BuiltInsLoader.class.getClassLoader());
        m.f(implementations, "implementations");
        BuiltInsLoader builtInsLoader = (BuiltInsLoader) p.Z(implementations);
        if (builtInsLoader != null) {
            return builtInsLoader;
        }
        throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
    }
}