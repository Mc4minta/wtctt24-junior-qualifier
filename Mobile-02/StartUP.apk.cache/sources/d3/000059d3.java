package kotlinx.coroutines.android;

import android.os.Build;
import androidx.annotation.Keep;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.c0.a;
import kotlin.c0.f;
import kotlin.h;
import kotlin.j0.m;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: AndroidExceptionPreHandler.kt */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/c0/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/Function0;", "Ljava/lang/reflect/Method;", "invoke", "()Ljava/lang/reflect/Method;", "Lkotlin/c0/f;", "context", "", "exception", "Lkotlin/x;", "handleException", "(Lkotlin/c0/f;Ljava/lang/Throwable;)V", "preHandler$delegate", "Lkotlin/h;", "getPreHandler", "preHandler", "<init>", "()V", "kotlinx-coroutines-android"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class AndroidExceptionPreHandler extends a implements CoroutineExceptionHandler, kotlin.e0.c.a<Method> {
    static final /* synthetic */ m[] $$delegatedProperties = {e0.h(new x(e0.b(AndroidExceptionPreHandler.class), "preHandler", "getPreHandler()Ljava/lang/reflect/Method;"))};
    private final h preHandler$delegate;

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.r);
        h b2;
        b2 = k.b(this);
        this.preHandler$delegate = b2;
    }

    private final Method getPreHandler() {
        h hVar = this.preHandler$delegate;
        m mVar = $$delegatedProperties[0];
        return (Method) hVar.getValue();
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(f context, Throwable exception) {
        kotlin.jvm.internal.m.h(context, "context");
        kotlin.jvm.internal.m.h(exception, "exception");
        Thread thread = Thread.currentThread();
        if (Build.VERSION.SDK_INT >= 28) {
            kotlin.jvm.internal.m.d(thread, "thread");
            thread.getUncaughtExceptionHandler().uncaughtException(thread, exception);
            return;
        }
        Method preHandler = getPreHandler();
        Object invoke = preHandler != null ? preHandler.invoke(null, new Object[0]) : null;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = invoke instanceof Thread.UncaughtExceptionHandler ? invoke : null;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, exception);
        }
    }

    @Override // kotlin.e0.c.a
    public Method invoke() {
        try {
            boolean z = false;
            Method it = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            kotlin.jvm.internal.m.d(it, "it");
            if (Modifier.isPublic(it.getModifiers())) {
                if (Modifier.isStatic(it.getModifiers())) {
                    z = true;
                }
            }
            if (z) {
                return it;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}