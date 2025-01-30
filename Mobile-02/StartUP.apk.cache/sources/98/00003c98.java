package com.google.protobuf;

import com.google.protobuf.i.b;
import com.google.protobuf.l;
import com.google.protobuf.n;
import com.google.protobuf.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: FieldSet.java */
/* loaded from: classes2.dex */
final class i<FieldDescriptorType extends b<FieldDescriptorType>> {
    private static final i a = new i(true);

    /* renamed from: c  reason: collision with root package name */
    private boolean f9708c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9709d = false;

    /* renamed from: b  reason: collision with root package name */
    private final s<FieldDescriptorType, Object> f9707b = s.p(16);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FieldSet.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f9710b;

        static {
            int[] iArr = new int[y.b.values().length];
            f9710b = iArr;
            try {
                iArr[y.b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9710b[y.b.f9764b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9710b[y.b.f9765c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9710b[y.b.f9766d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9710b[y.b.f9767e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9710b[y.b.f9768f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9710b[y.b.f9769g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9710b[y.b.f9770h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9710b[y.b.f9772k.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9710b[y.b.f9773l.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9710b[y.b.f9771j.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9710b[y.b.m.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f9710b[y.b.n.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f9710b[y.b.q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f9710b[y.b.t.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f9710b[y.b.u.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f9710b[y.b.v.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f9710b[y.b.p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[y.c.values().length];
            a = iArr2;
            try {
                iArr2[y.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[y.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[y.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[y.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[y.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[y.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[y.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[y.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[y.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* compiled from: FieldSet.java */
    /* loaded from: classes2.dex */
    public interface b<T extends b<T>> extends Comparable<T> {
        y.c getLiteJavaType();

        y.b getLiteType();

        boolean isRepeated();

        n.a m(n.a aVar, n nVar);
    }

    private i() {
    }

    private Object b(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    private void h(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof l) {
            value = ((l) value).d();
        }
        if (key.isRepeated()) {
            Object c2 = c(key);
            if (c2 == null) {
                c2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) c2).add(b(obj));
            }
            this.f9707b.put(key, c2);
        } else if (key.getLiteJavaType() == y.c.MESSAGE) {
            Object c3 = c(key);
            if (c3 == null) {
                this.f9707b.put(key, b(value));
                return;
            }
            this.f9707b.put(key, key.m(((n) c3).toBuilder(), (n) value).build());
        } else {
            this.f9707b.put(key, b(value));
        }
    }

    public static <T extends b<T>> i<T> i() {
        return new i<>();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        if ((r3 instanceof java.lang.Integer) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
        if ((r3 instanceof byte[]) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if ((r3 instanceof com.google.protobuf.l) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void k(com.google.protobuf.y.b r2, java.lang.Object r3) {
        /*
            java.util.Objects.requireNonNull(r3)
            int[] r0 = com.google.protobuf.i.a.a
            com.google.protobuf.y$c r2 = r2.h()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L2f;
                case 7: goto L23;
                case 8: goto L1e;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L40
        L15:
            boolean r2 = r3 instanceof com.google.protobuf.n
            if (r2 != 0) goto L2d
            boolean r2 = r3 instanceof com.google.protobuf.l
            if (r2 == 0) goto L2c
            goto L2d
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L2d
            goto L2c
        L23:
            boolean r2 = r3 instanceof com.google.protobuf.e
            if (r2 != 0) goto L2d
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L2c
            goto L2d
        L2c:
            r0 = r1
        L2d:
            r1 = r0
            goto L40
        L2f:
            boolean r1 = r3 instanceof java.lang.String
            goto L40
        L32:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L40
        L35:
            boolean r1 = r3 instanceof java.lang.Double
            goto L40
        L38:
            boolean r1 = r3 instanceof java.lang.Float
            goto L40
        L3b:
            boolean r1 = r3 instanceof java.lang.Long
            goto L40
        L3e:
            boolean r1 = r3 instanceof java.lang.Integer
        L40:
            if (r1 == 0) goto L43
            return
        L43:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.i.k(com.google.protobuf.y$b, java.lang.Object):void");
    }

    /* renamed from: a */
    public i<FieldDescriptorType> clone() {
        i<FieldDescriptorType> i2 = i();
        for (int i3 = 0; i3 < this.f9707b.j(); i3++) {
            Map.Entry<FieldDescriptorType, Object> i4 = this.f9707b.i(i3);
            i2.j(i4.getKey(), i4.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f9707b.l()) {
            i2.j(entry.getKey(), entry.getValue());
        }
        i2.f9709d = this.f9709d;
        return i2;
    }

    public Object c(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f9707b.get(fielddescriptortype);
        return obj instanceof l ? ((l) obj).d() : obj;
    }

    public boolean d() {
        return this.f9708c;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        if (this.f9709d) {
            return new l.c(this.f9707b.entrySet().iterator());
        }
        return this.f9707b.entrySet().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            return this.f9707b.equals(((i) obj).f9707b);
        }
        return false;
    }

    public void f() {
        if (this.f9708c) {
            return;
        }
        this.f9707b.o();
        this.f9708c = true;
    }

    public void g(i<FieldDescriptorType> iVar) {
        for (int i2 = 0; i2 < iVar.f9707b.j(); i2++) {
            h(iVar.f9707b.i(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : iVar.f9707b.l()) {
            h(entry);
        }
    }

    public int hashCode() {
        return this.f9707b.hashCode();
    }

    public void j(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.isRepeated()) {
            if (obj instanceof List) {
                ArrayList<Object> arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                for (Object obj2 : arrayList) {
                    k(fielddescriptortype.getLiteType(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            k(fielddescriptortype.getLiteType(), obj);
        }
        if (obj instanceof l) {
            this.f9709d = true;
        }
        this.f9707b.put(fielddescriptortype, obj);
    }

    private i(boolean z) {
        f();
    }
}