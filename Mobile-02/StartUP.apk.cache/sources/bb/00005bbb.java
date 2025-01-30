package org.apache.commons.lang3.exception;

/* loaded from: classes3.dex */
public class ContextedRuntimeException extends RuntimeException implements b {
    private final b a = new a();

    @Override // org.apache.commons.lang3.exception.b
    public String a(String str) {
        return this.a.a(str);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return a(super.getMessage());
    }
}