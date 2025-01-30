package com.google.zxing.t.r.g.e;

import com.google.zxing.NotFoundException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AI013x0x1xDecoder.java */
/* loaded from: classes2.dex */
public final class e extends i {

    /* renamed from: c  reason: collision with root package name */
    private final String f10050c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10051d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.google.zxing.q.a aVar, String str, String str2) {
        super(aVar);
        this.f10050c = str2;
        this.f10051d = str;
    }

    private void k(StringBuilder sb, int i2) {
        int f2 = b().f(i2, 16);
        if (f2 == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f10050c);
        sb.append(')');
        int i3 = f2 % 32;
        int i4 = f2 / 32;
        int i5 = (i4 % 12) + 1;
        int i6 = i4 / 12;
        if (i6 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i6);
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i3 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i3);
    }

    @Override // com.google.zxing.t.r.g.e.j
    public String d() throws NotFoundException {
        if (c().o() == 84) {
            StringBuilder sb = new StringBuilder();
            f(sb, 8);
            j(sb, 48, 20);
            k(sb, 68);
            return sb.toString();
        }
        throw NotFoundException.a();
    }

    @Override // com.google.zxing.t.r.g.e.i
    protected void h(StringBuilder sb, int i2) {
        sb.append('(');
        sb.append(this.f10051d);
        sb.append(i2 / 100000);
        sb.append(')');
    }

    @Override // com.google.zxing.t.r.g.e.i
    protected int i(int i2) {
        return i2 % 100000;
    }
}