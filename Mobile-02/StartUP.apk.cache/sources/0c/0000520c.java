package kotlin.j0;

import java.util.List;
import java.util.Map;

/* compiled from: KCallable.kt */
/* loaded from: classes3.dex */
public interface c<R> extends b {
    R call(Object... objArr);

    R callBy(Map<l, ? extends Object> map);

    String getName();

    List<l> getParameters();

    q getReturnType();

    List<r> getTypeParameters();

    v getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}