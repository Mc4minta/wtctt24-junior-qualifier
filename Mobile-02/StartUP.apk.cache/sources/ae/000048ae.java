package e.g.b.a.c;

import e.g.b.a.d.f0;
import e.g.b.a.d.j;
import e.g.b.a.d.l;
import e.g.b.a.d.m;
import e.g.b.a.d.n;
import e.g.b.a.d.y;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/* compiled from: JsonGenerator.java */
/* loaded from: classes2.dex */
public abstract class d {
    private void d(boolean z, Object obj) throws IOException {
        boolean z2;
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (j.c(obj)) {
            i();
        } else if (obj instanceof String) {
            r((String) obj);
        } else {
            boolean z3 = true;
            if (obj instanceof Number) {
                if (z) {
                    r(obj.toString());
                } else if (obj instanceof BigDecimal) {
                    n((BigDecimal) obj);
                } else if (obj instanceof BigInteger) {
                    o((BigInteger) obj);
                } else if (obj instanceof Long) {
                    m(((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    float floatValue = ((Number) obj).floatValue();
                    y.a((Float.isInfinite(floatValue) || Float.isNaN(floatValue)) ? false : false);
                    k(floatValue);
                } else if (!(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte)) {
                    double doubleValue = ((Number) obj).doubleValue();
                    y.a((Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) ? false : false);
                    j(doubleValue);
                } else {
                    l(((Number) obj).intValue());
                }
            } else if (obj instanceof Boolean) {
                e(((Boolean) obj).booleanValue());
            } else if (obj instanceof l) {
                r(((l) obj).c());
            } else if (!(obj instanceof Iterable) && !cls.isArray()) {
                if (cls.isEnum()) {
                    String e2 = m.j((Enum) obj).e();
                    if (e2 == null) {
                        i();
                        return;
                    } else {
                        r(e2);
                        return;
                    }
                }
                q();
                boolean z4 = (obj instanceof Map) && !(obj instanceof n);
                e.g.b.a.d.i f2 = z4 ? null : e.g.b.a.d.i.f(cls);
                for (Map.Entry<String, Object> entry : j.f(obj).entrySet()) {
                    Object value = entry.getValue();
                    if (value != null) {
                        String key = entry.getKey();
                        if (z4) {
                            z2 = z;
                        } else {
                            Field a = f2.a(key);
                            z2 = (a == null || a.getAnnotation(h.class) == null) ? false : true;
                        }
                        h(key);
                        d(z2, value);
                    }
                }
                g();
            } else {
                p();
                for (Object obj2 : f0.l(obj)) {
                    d(z, obj2);
                }
                f();
            }
        }
    }

    public abstract void a() throws IOException;

    public abstract void b() throws IOException;

    public final void c(Object obj) throws IOException {
        d(false, obj);
    }

    public abstract void e(boolean z) throws IOException;

    public abstract void f() throws IOException;

    public abstract void g() throws IOException;

    public abstract void h(String str) throws IOException;

    public abstract void i() throws IOException;

    public abstract void j(double d2) throws IOException;

    public abstract void k(float f2) throws IOException;

    public abstract void l(int i2) throws IOException;

    public abstract void m(long j2) throws IOException;

    public abstract void n(BigDecimal bigDecimal) throws IOException;

    public abstract void o(BigInteger bigInteger) throws IOException;

    public abstract void p() throws IOException;

    public abstract void q() throws IOException;

    public abstract void r(String str) throws IOException;
}