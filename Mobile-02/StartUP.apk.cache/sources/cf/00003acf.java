package com.google.firebase.i;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes2.dex */
public final class a extends f {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9108b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, String str2) {
        Objects.requireNonNull(str, "Null libraryName");
        this.a = str;
        Objects.requireNonNull(str2, "Null version");
        this.f9108b = str2;
    }

    @Override // com.google.firebase.i.f
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.i.f
    public String c() {
        return this.f9108b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.a.equals(fVar.b()) && this.f9108b.equals(fVar.c());
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f9108b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.a + ", version=" + this.f9108b + "}";
    }
}