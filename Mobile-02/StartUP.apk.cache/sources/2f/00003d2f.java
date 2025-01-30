package com.google.zxing.t;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* compiled from: UPCAReader.java */
/* loaded from: classes2.dex */
public final class l extends p {

    /* renamed from: i  reason: collision with root package name */
    private final p f10007i = new e();

    private static com.google.zxing.k s(com.google.zxing.k kVar) throws FormatException {
        String f2 = kVar.f();
        if (f2.charAt(0) == '0') {
            return new com.google.zxing.k(f2.substring(1), null, kVar.e(), com.google.zxing.a.UPC_A);
        }
        throw FormatException.a();
    }

    @Override // com.google.zxing.t.k, com.google.zxing.j
    public com.google.zxing.k a(com.google.zxing.c cVar, Map<com.google.zxing.d, ?> map) throws NotFoundException, FormatException {
        return s(this.f10007i.a(cVar, map));
    }

    @Override // com.google.zxing.t.k, com.google.zxing.j
    public com.google.zxing.k b(com.google.zxing.c cVar) throws NotFoundException, FormatException {
        return s(this.f10007i.b(cVar));
    }

    @Override // com.google.zxing.t.p, com.google.zxing.t.k
    public com.google.zxing.k c(int i2, com.google.zxing.q.a aVar, Map<com.google.zxing.d, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return s(this.f10007i.c(i2, aVar, map));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.zxing.t.p
    public int l(com.google.zxing.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.f10007i.l(aVar, iArr, sb);
    }

    @Override // com.google.zxing.t.p
    public com.google.zxing.k m(int i2, com.google.zxing.q.a aVar, int[] iArr, Map<com.google.zxing.d, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return s(this.f10007i.m(i2, aVar, iArr, map));
    }

    @Override // com.google.zxing.t.p
    com.google.zxing.a q() {
        return com.google.zxing.a.UPC_A;
    }
}