package e.g.b.a.c.j;

import e.g.b.a.c.f;
import e.g.b.a.c.i;
import e.g.b.a.d.y;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GsonParser.java */
/* loaded from: classes2.dex */
class c extends f {

    /* renamed from: c  reason: collision with root package name */
    private final com.google.gson.stream.a f13395c;

    /* renamed from: d  reason: collision with root package name */
    private final e.g.b.a.c.j.a f13396d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f13397e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private i f13398f;

    /* renamed from: g  reason: collision with root package name */
    private String f13399g;

    /* compiled from: GsonParser.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f13400b;

        static {
            int[] iArr = new int[com.google.gson.stream.b.values().length];
            f13400b = iArr;
            try {
                iArr[com.google.gson.stream.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13400b[com.google.gson.stream.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13400b[com.google.gson.stream.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13400b[com.google.gson.stream.b.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13400b[com.google.gson.stream.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13400b[com.google.gson.stream.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13400b[com.google.gson.stream.b.STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13400b[com.google.gson.stream.b.NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13400b[com.google.gson.stream.b.NAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[i.values().length];
            a = iArr2;
            try {
                iArr2[i.START_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[i.START_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e.g.b.a.c.j.a aVar, com.google.gson.stream.a aVar2) {
        this.f13396d = aVar;
        this.f13395c = aVar2;
        aVar2.w0(true);
    }

    private void D() {
        i iVar = this.f13398f;
        y.a(iVar == i.VALUE_NUMBER_INT || iVar == i.VALUE_NUMBER_FLOAT);
    }

    @Override // e.g.b.a.c.f
    public void a() throws IOException {
        this.f13395c.close();
    }

    @Override // e.g.b.a.c.f
    public BigInteger b() {
        D();
        return new BigInteger(this.f13399g);
    }

    @Override // e.g.b.a.c.f
    public byte c() {
        D();
        return Byte.parseByte(this.f13399g);
    }

    @Override // e.g.b.a.c.f
    public String e() {
        if (this.f13397e.isEmpty()) {
            return null;
        }
        List<String> list = this.f13397e;
        return list.get(list.size() - 1);
    }

    @Override // e.g.b.a.c.f
    public i f() {
        return this.f13398f;
    }

    @Override // e.g.b.a.c.f
    public BigDecimal g() {
        D();
        return new BigDecimal(this.f13399g);
    }

    @Override // e.g.b.a.c.f
    public double h() {
        D();
        return Double.parseDouble(this.f13399g);
    }

    @Override // e.g.b.a.c.f
    public e.g.b.a.c.c i() {
        return this.f13396d;
    }

    @Override // e.g.b.a.c.f
    public float j() {
        D();
        return Float.parseFloat(this.f13399g);
    }

    @Override // e.g.b.a.c.f
    public int k() {
        D();
        return Integer.parseInt(this.f13399g);
    }

    @Override // e.g.b.a.c.f
    public long l() {
        D();
        return Long.parseLong(this.f13399g);
    }

    @Override // e.g.b.a.c.f
    public short m() {
        D();
        return Short.parseShort(this.f13399g);
    }

    @Override // e.g.b.a.c.f
    public String n() {
        return this.f13399g;
    }

    @Override // e.g.b.a.c.f
    public i o() throws IOException {
        com.google.gson.stream.b bVar;
        i iVar = this.f13398f;
        if (iVar != null) {
            int i2 = a.a[iVar.ordinal()];
            if (i2 == 1) {
                this.f13395c.a();
                this.f13397e.add(null);
            } else if (i2 == 2) {
                this.f13395c.b();
                this.f13397e.add(null);
            }
        }
        try {
            bVar = this.f13395c.k0();
        } catch (EOFException unused) {
            bVar = com.google.gson.stream.b.END_DOCUMENT;
        }
        switch (a.f13400b[bVar.ordinal()]) {
            case 1:
                this.f13399g = "[";
                this.f13398f = i.START_ARRAY;
                break;
            case 2:
                this.f13399g = "]";
                this.f13398f = i.END_ARRAY;
                List<String> list = this.f13397e;
                list.remove(list.size() - 1);
                this.f13395c.f();
                break;
            case 3:
                this.f13399g = "{";
                this.f13398f = i.START_OBJECT;
                break;
            case 4:
                this.f13399g = "}";
                this.f13398f = i.END_OBJECT;
                List<String> list2 = this.f13397e;
                list2.remove(list2.size() - 1);
                this.f13395c.g();
                break;
            case 5:
                if (this.f13395c.A()) {
                    this.f13399g = "true";
                    this.f13398f = i.VALUE_TRUE;
                    break;
                } else {
                    this.f13399g = "false";
                    this.f13398f = i.VALUE_FALSE;
                    break;
                }
            case 6:
                this.f13399g = "null";
                this.f13398f = i.VALUE_NULL;
                this.f13395c.a0();
                break;
            case 7:
                this.f13399g = this.f13395c.e0();
                this.f13398f = i.VALUE_STRING;
                break;
            case 8:
                String e0 = this.f13395c.e0();
                this.f13399g = e0;
                this.f13398f = e0.indexOf(46) == -1 ? i.VALUE_NUMBER_INT : i.VALUE_NUMBER_FLOAT;
                break;
            case 9:
                this.f13399g = this.f13395c.O();
                this.f13398f = i.FIELD_NAME;
                List<String> list3 = this.f13397e;
                list3.set(list3.size() - 1, this.f13399g);
                break;
            default:
                this.f13399g = null;
                this.f13398f = null;
                break;
        }
        return this.f13398f;
    }

    @Override // e.g.b.a.c.f
    public f y() throws IOException {
        i iVar = this.f13398f;
        if (iVar != null) {
            int i2 = a.a[iVar.ordinal()];
            if (i2 == 1) {
                this.f13395c.J0();
                this.f13399g = "]";
                this.f13398f = i.END_ARRAY;
            } else if (i2 == 2) {
                this.f13395c.J0();
                this.f13399g = "}";
                this.f13398f = i.END_OBJECT;
            }
        }
        return this;
    }
}