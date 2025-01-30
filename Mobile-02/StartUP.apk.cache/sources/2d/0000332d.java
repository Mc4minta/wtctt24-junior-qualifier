package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzco extends IOException {
    private i2 a;

    public zzco(String str) {
        super(str);
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzco a() {
        return new zzco("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzco b() {
        return new zzco("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcp c() {
        return new zzcp("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzco d() {
        return new zzco("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzco e() {
        return new zzco("Protocol message had invalid UTF-8.");
    }

    public final zzco f(i2 i2Var) {
        this.a = i2Var;
        return this;
    }
}