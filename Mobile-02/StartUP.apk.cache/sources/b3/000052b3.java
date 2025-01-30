package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Standard.kt */
/* loaded from: classes3.dex */
public final class n extends Error {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String message) {
        super(message);
        kotlin.jvm.internal.m.g(message, "message");
    }

    public /* synthetic */ n(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "An operation is not implemented." : str);
    }
}