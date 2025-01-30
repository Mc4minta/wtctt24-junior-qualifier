package e.j.l.m;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import kotlin.e0.c.p;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: ResizeAnimation.kt */
/* loaded from: classes2.dex */
public final class c extends Animation {
    private View a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13715b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13716c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13717d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13718e;

    /* compiled from: ResizeAnimation.kt */
    /* loaded from: classes2.dex */
    public static final class a extends e.j.l.m.a {
        final /* synthetic */ p<View, Animation, x> a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f13719b;

        /* JADX WARN: Multi-variable type inference failed */
        a(p<? super View, ? super Animation, x> pVar, c cVar) {
            this.a = pVar;
            this.f13719b = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.invoke(this.f13719b.b(), animation);
        }
    }

    public /* synthetic */ c(View view, int i2, int i3, int i4, int i5, p pVar, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5, pVar);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f2, Transformation t) {
        m.g(t, "t");
        int i2 = this.f13715b;
        int i3 = (int) (i2 + ((this.f13716c - i2) * f2));
        int i4 = this.f13717d;
        this.a.getLayoutParams().width = i3;
        this.a.getLayoutParams().height = (int) (i4 + ((this.f13718e - i4) * f2));
        this.a.requestLayout();
    }

    public final View b() {
        return this.a;
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }

    public c(View view, int i2, int i3, int i4, int i5, p<? super View, ? super Animation, x> pVar) {
        m.g(view, "view");
        this.a = view;
        this.f13715b = i2;
        this.f13716c = i3;
        this.f13717d = i4;
        this.f13718e = i5;
        if (pVar != null) {
            setAnimationListener(new a(pVar, this));
        }
    }
}