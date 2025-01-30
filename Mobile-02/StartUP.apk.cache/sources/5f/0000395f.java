package com.google.firebase.components;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class i implements com.google.firebase.g.a {
    private final l a;

    /* renamed from: b  reason: collision with root package name */
    private final d f8618b;

    private i(l lVar, d dVar) {
        this.a = lVar;
        this.f8618b = dVar;
    }

    public static com.google.firebase.g.a a(l lVar, d dVar) {
        return new i(lVar, dVar);
    }

    @Override // com.google.firebase.g.a
    public Object get() {
        Object a;
        a = r1.d().a(new s(this.f8618b, this.a));
        return a;
    }
}