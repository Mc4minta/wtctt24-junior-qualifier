package com.google.firebase.remoteconfig.internal;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class o implements com.google.firebase.remoteconfig.h {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9462b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(String str, int i2) {
        this.a = str;
        this.f9462b = i2;
    }

    private String b() {
        return asString().trim();
    }

    private void c() {
        if (this.a == null) {
            throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        }
    }

    @Override // com.google.firebase.remoteconfig.h
    public long a() {
        if (this.f9462b == 0) {
            return 0L;
        }
        String b2 = b();
        try {
            return Long.valueOf(b2).longValue();
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", b2, "long"), e2);
        }
    }

    @Override // com.google.firebase.remoteconfig.h
    public boolean asBoolean() throws IllegalArgumentException {
        if (this.f9462b == 0) {
            return false;
        }
        String b2 = b();
        if (k.f9447b.matcher(b2).matches()) {
            return true;
        }
        if (k.f9448c.matcher(b2).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", b2, "boolean"));
    }

    @Override // com.google.firebase.remoteconfig.h
    public double asDouble() {
        if (this.f9462b == 0) {
            return 0.0d;
        }
        String b2 = b();
        try {
            return Double.valueOf(b2).doubleValue();
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", b2, "double"), e2);
        }
    }

    @Override // com.google.firebase.remoteconfig.h
    public String asString() {
        if (this.f9462b == 0) {
            return "";
        }
        c();
        return this.a;
    }

    @Override // com.google.firebase.remoteconfig.h
    public int getSource() {
        return this.f9462b;
    }
}