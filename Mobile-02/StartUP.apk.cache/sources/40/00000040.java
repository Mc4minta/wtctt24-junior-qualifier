package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    private final Runnable a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayDeque<b> f402b = new ArrayDeque<>();

    /* loaded from: classes.dex */
    private class LifecycleOnBackPressedCancellable implements m, androidx.activity.a {
        private final i a;

        /* renamed from: b  reason: collision with root package name */
        private final b f403b;

        /* renamed from: c  reason: collision with root package name */
        private androidx.activity.a f404c;

        LifecycleOnBackPressedCancellable(i iVar, b bVar) {
            this.a = iVar;
            this.f403b = bVar;
            iVar.a(this);
        }

        @Override // androidx.lifecycle.m
        public void c(o oVar, i.a aVar) {
            if (aVar == i.a.ON_START) {
                this.f404c = OnBackPressedDispatcher.this.b(this.f403b);
            } else if (aVar == i.a.ON_STOP) {
                androidx.activity.a aVar2 = this.f404c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            } else if (aVar == i.a.ON_DESTROY) {
                cancel();
            }
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.a.c(this);
            this.f403b.e(this);
            androidx.activity.a aVar = this.f404c;
            if (aVar != null) {
                aVar.cancel();
                this.f404c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.activity.a {
        private final b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f402b.remove(this.a);
            this.a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    public void a(o oVar, b bVar) {
        i lifecycle = oVar.getLifecycle();
        if (lifecycle.b() == i.b.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(lifecycle, bVar));
    }

    androidx.activity.a b(b bVar) {
        this.f402b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator<b> descendingIterator = this.f402b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}