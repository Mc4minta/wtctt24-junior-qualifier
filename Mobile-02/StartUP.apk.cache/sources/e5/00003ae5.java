package com.google.firebase.iid;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
final class d implements a {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9140b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2) {
        this.a = str;
        this.f9140b = str2;
    }

    @Override // com.google.firebase.iid.a
    public final String a() {
        return this.f9140b;
    }

    @Override // com.google.firebase.iid.a
    public final String getId() {
        return this.a;
    }
}