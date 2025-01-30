package androidx.core.os;

/* loaded from: classes.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String str) {
        super(androidx.core.util.d.c(str, "The operation has been canceled."));
    }
}