package kotlinx.coroutines;

import com.coinbase.ApiConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* compiled from: Exceptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B!\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/r;", "", "fillInStackTrace", "()Ljava/lang/Throwable;", "b", "()Lkotlinx/coroutines/JobCancellationException;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlinx/coroutines/r0;", "a", "Lkotlinx/coroutines/r0;", "job", ApiConstants.MESSAGE, "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/r0;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class JobCancellationException extends CancellationException implements r<JobCancellationException> {
    public final r0 a;

    public JobCancellationException(String str, Throwable th, r0 r0Var) {
        super(str);
        this.a = r0Var;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // kotlinx.coroutines.r
    /* renamed from: b */
    public JobCancellationException a() {
        if (x.b()) {
            String message = getMessage();
            kotlin.jvm.internal.m.e(message);
            return new JobCancellationException(message, this, this.a);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!kotlin.jvm.internal.m.c(jobCancellationException.getMessage(), getMessage()) || !kotlin.jvm.internal.m.c(jobCancellationException.a, this.a) || !kotlin.jvm.internal.m.c(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (x.b()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.m.e(message);
        int hashCode = ((message.hashCode() * 31) + this.a.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.a;
    }
}