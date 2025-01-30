package com.google.android.gms.common.api;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final com.google.android.gms.common.d a;

    public UnsupportedApiCallException(com.google.android.gms.common.d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String valueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}