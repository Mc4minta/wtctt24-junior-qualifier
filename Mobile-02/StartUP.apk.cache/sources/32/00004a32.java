package e.j.l.m;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.e0.c.p;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: AnimatorListener.kt */
/* loaded from: classes2.dex */
public abstract class b extends AnimatorListenerAdapter {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final View f13710b;

    /* renamed from: c  reason: collision with root package name */
    private final p<View, Boolean, x> f13711c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13712d;

    /* compiled from: AnimatorListener.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* compiled from: AnimatorListener.kt */
        /* renamed from: e.j.l.m.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0325a extends b {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ View f13713e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ p<View, Boolean, x> f13714f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0325a(View view, p<? super View, ? super Boolean, x> pVar) {
                super(view, pVar);
                this.f13713e = view;
                this.f13714f = pVar;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(View view, p<? super View, ? super Boolean, x> pVar) {
            m.g(view, "view");
            if (pVar == null) {
                return null;
            }
            return new C0325a(view, pVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(View view, p<? super View, ? super Boolean, x> listener) {
        m.g(view, "view");
        m.g(listener, "listener");
        this.f13710b = view;
        this.f13711c = listener;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f13712d = true;
        super.onAnimationCancel(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.f13711c.invoke(this.f13710b, Boolean.valueOf(this.f13712d));
    }
}