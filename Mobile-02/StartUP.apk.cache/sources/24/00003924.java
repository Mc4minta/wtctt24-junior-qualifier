package com.google.common.util.concurrent;

import com.google.common.collect.r;
import com.google.common.collect.t;
import com.google.common.collect.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

@CanIgnoreReturnValue
/* loaded from: classes2.dex */
public class CycleDetectingLockFactory {
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, c>> a = new u().h().f();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f8551b = Logger.getLogger(CycleDetectingLockFactory.class.getName());

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<c>> f8552c = new a();

    /* loaded from: classes2.dex */
    public static final class PotentialDeadlockException extends b {

        /* renamed from: c  reason: collision with root package name */
        private final b f8553c;

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder sb = new StringBuilder(super.getMessage());
            for (Throwable th = this.f8553c; th != null; th = th.getCause()) {
                sb.append(", ");
                sb.append(th.getMessage());
            }
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    static class a extends ThreadLocal<ArrayList<c>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<c> initialValue() {
            return t.f(3);
        }
    }

    /* loaded from: classes2.dex */
    private static class b extends IllegalStateException {
        static final StackTraceElement[] a = new StackTraceElement[0];

        /* renamed from: b  reason: collision with root package name */
        static final Set<String> f8554b = r.s(CycleDetectingLockFactory.class.getName(), b.class.getName(), c.class.getName());
    }

    /* loaded from: classes2.dex */
    private static class c {
    }
}