package c.r.a;

/* compiled from: SimpleSQLiteQuery.java */
/* loaded from: classes.dex */
public final class a implements e {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f3208b;

    public a(String str, Object[] objArr) {
        this.a = str;
        this.f3208b = objArr;
    }

    private static void c(d dVar, int i2, Object obj) {
        if (obj == null) {
            dVar.B0(i2);
        } else if (obj instanceof byte[]) {
            dVar.f0(i2, (byte[]) obj);
        } else if (obj instanceof Float) {
            dVar.I(i2, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            dVar.I(i2, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            dVar.b0(i2, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            dVar.b0(i2, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            dVar.b0(i2, ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            dVar.b0(i2, ((Byte) obj).byteValue());
        } else if (obj instanceof String) {
            dVar.u(i2, (String) obj);
        } else if (obj instanceof Boolean) {
            dVar.b0(i2, ((Boolean) obj).booleanValue() ? 1L : 0L);
        } else {
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i2 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
        }
    }

    public static void d(d dVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i2 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            i2++;
            c(dVar, i2, obj);
        }
    }

    @Override // c.r.a.e
    public String a() {
        return this.a;
    }

    @Override // c.r.a.e
    public void b(d dVar) {
        d(dVar, this.f3208b);
    }

    public a(String str) {
        this(str, null);
    }
}