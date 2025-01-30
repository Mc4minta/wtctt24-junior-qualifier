package kotlinx.coroutines;

import com.coinbase.ApiConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* compiled from: Timeout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001b\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/r;", "b", "()Lkotlinx/coroutines/TimeoutCancellationException;", "Lkotlinx/coroutines/r0;", "a", "Lkotlinx/coroutines/r0;", "coroutine", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/r0;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class TimeoutCancellationException extends CancellationException implements r<TimeoutCancellationException> {
    public final r0 a;

    public TimeoutCancellationException(String str, r0 r0Var) {
        super(str);
        this.a = r0Var;
    }

    @Override // kotlinx.coroutines.r
    /* renamed from: b */
    public TimeoutCancellationException a() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.a);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }
}