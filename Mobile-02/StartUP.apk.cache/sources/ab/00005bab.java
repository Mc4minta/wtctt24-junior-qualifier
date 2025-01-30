package org.apache.commons.io;

import java.io.IOException;

/* loaded from: classes3.dex */
public class TaggedIOException extends IOExceptionWithCause {
    @Override // java.lang.Throwable
    /* renamed from: a */
    public IOException getCause() {
        return (IOException) super.getCause();
    }
}