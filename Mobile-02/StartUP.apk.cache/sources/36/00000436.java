package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: TransactionExecutor.java */
/* loaded from: classes.dex */
class r implements Executor {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<Runnable> f2299b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private Runnable f2300c;

    /* compiled from: TransactionExecutor.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ Runnable a;

        a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } finally {
                r.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Executor executor) {
        this.a = executor;
    }

    synchronized void a() {
        Runnable poll = this.f2299b.poll();
        this.f2300c = poll;
        if (poll != null) {
            this.a.execute(poll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.f2299b.offer(new a(runnable));
        if (this.f2300c == null) {
            a();
        }
    }
}