package kotlin.j0.b0;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.j0.g;
import kotlin.j0.h;
import kotlin.j0.m;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;

/* compiled from: KCallablesJvm.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final void a(kotlin.j0.c<?> isAccessible, boolean z) {
        Caller<?> defaultCaller;
        m.g(isAccessible, "$this$isAccessible");
        if (isAccessible instanceof h) {
            kotlin.j0.m mVar = (kotlin.j0.m) isAccessible;
            Field b2 = c.b(mVar);
            if (b2 != null) {
                b2.setAccessible(z);
            }
            Method c2 = c.c(mVar);
            if (c2 != null) {
                c2.setAccessible(z);
            }
            Method e2 = c.e((h) isAccessible);
            if (e2 != null) {
                e2.setAccessible(z);
            }
        } else if (isAccessible instanceof kotlin.j0.m) {
            kotlin.j0.m mVar2 = (kotlin.j0.m) isAccessible;
            Field b3 = c.b(mVar2);
            if (b3 != null) {
                b3.setAccessible(z);
            }
            Method c3 = c.c(mVar2);
            if (c3 != null) {
                c3.setAccessible(z);
            }
        } else if (isAccessible instanceof m.b) {
            Field b4 = c.b(((m.b) isAccessible).getProperty());
            if (b4 != null) {
                b4.setAccessible(z);
            }
            Method d2 = c.d((g) isAccessible);
            if (d2 != null) {
                d2.setAccessible(z);
            }
        } else if (isAccessible instanceof h.a) {
            Field b5 = c.b(((h.a) isAccessible).getProperty());
            if (b5 != null) {
                b5.setAccessible(z);
            }
            Method d3 = c.d((g) isAccessible);
            if (d3 != null) {
                d3.setAccessible(z);
            }
        } else if (isAccessible instanceof g) {
            g gVar = (g) isAccessible;
            Method d4 = c.d(gVar);
            if (d4 != null) {
                d4.setAccessible(z);
            }
            KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(isAccessible);
            Object mo2204getMember = (asKCallableImpl == null || (defaultCaller = asKCallableImpl.getDefaultCaller()) == null) ? null : defaultCaller.mo2204getMember();
            AccessibleObject accessibleObject = mo2204getMember instanceof AccessibleObject ? mo2204getMember : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(true);
            }
            Constructor a = c.a(gVar);
            if (a != null) {
                a.setAccessible(z);
            }
        } else {
            throw new UnsupportedOperationException("Unknown callable: " + isAccessible + " (" + isAccessible.getClass() + ')');
        }
    }
}