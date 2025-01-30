package com.bugsnag.android;

import com.bugsnag.android.o0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadState.java */
/* loaded from: classes.dex */
public class c1 implements o0.a {
    private final o[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThreadState.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<Thread> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Thread thread, Thread thread2) {
            return Long.valueOf(thread.getId()).compareTo(Long.valueOf(thread2.getId()));
        }
    }

    public c1(s sVar, Thread thread, Map<Thread, StackTraceElement[]> map, Throwable th) {
        if (!map.containsKey(thread)) {
            map.put(thread, thread.getStackTrace());
        }
        if (th != null) {
            map.put(thread, th.getStackTrace());
        }
        long id = thread.getId();
        Thread[] a2 = a(map);
        this.a = new o[a2.length];
        for (int i2 = 0; i2 < a2.length; i2++) {
            Thread thread2 = a2[i2];
            this.a[i2] = new o(sVar, thread2.getId(), thread2.getName(), "android", thread2.getId() == id, map.get(thread2));
        }
    }

    private Thread[] a(Map<Thread, StackTraceElement[]> map) {
        Thread[] threadArr = (Thread[]) map.keySet().toArray(new Thread[0]);
        Arrays.sort(threadArr, new a());
        return threadArr;
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.c();
        for (o oVar : this.a) {
            o0Var.n0(oVar);
        }
        o0Var.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c1(o[] oVarArr) {
        this.a = oVarArr;
    }
}