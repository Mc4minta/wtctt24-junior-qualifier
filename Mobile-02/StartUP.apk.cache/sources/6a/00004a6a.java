package e.j.m.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;
import org.toshi.R;

/* compiled from: OnboardingPagerAdapter.kt */
/* loaded from: classes2.dex */
public final class j extends androidx.viewpager.widget.a {
    private final float a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.h f13758b;

    /* compiled from: OnboardingPagerAdapter.kt */
    /* loaded from: classes2.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<List<? extends Integer>> {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final List<? extends Integer> invoke() {
            List<? extends Integer> j2;
            j2 = kotlin.a0.r.j(Integer.valueOf((int) R.layout.view_coinbase_wallet), Integer.valueOf((int) R.layout.view_digital_assets), Integer.valueOf((int) R.layout.view_dapps), Integer.valueOf((int) R.layout.view_send_receive_crypto));
            return j2;
        }
    }

    public j(float f2) {
        kotlin.h b2;
        this.a = f2;
        b2 = kotlin.k.b(a.a);
        this.f13758b = b2;
    }

    private final int a(Drawable drawable) {
        return Math.round((drawable.getIntrinsicHeight() * this.a) / drawable.getIntrinsicWidth());
    }

    private final View b(ViewGroup viewGroup, int i2) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(c().get(i2).intValue(), viewGroup, false);
        View findViewById = view.findViewById(R.id.cover);
        kotlin.jvm.internal.m.f(findViewById, "view.findViewById(R.id.cover)");
        d((ImageView) findViewById);
        kotlin.jvm.internal.m.f(view, "view");
        return view;
    }

    private final List<Integer> c() {
        return (List) this.f13758b.getValue();
    }

    private final void d(ImageView imageView) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Drawable drawable = imageView.getDrawable();
        kotlin.jvm.internal.m.f(drawable, "drawable");
        layoutParams.height = a(drawable);
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup container, int i2, Object any) {
        kotlin.jvm.internal.m.g(container, "container");
        kotlin.jvm.internal.m.g(any, "any");
        View view = any instanceof View ? (View) any : null;
        if (view == null) {
            return;
        }
        container.removeView(view);
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return c().size();
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup container, int i2) {
        kotlin.jvm.internal.m.g(container, "container");
        View b2 = b(container, i2);
        container.addView(b2);
        return b2;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        kotlin.jvm.internal.m.g(view, "view");
        kotlin.jvm.internal.m.g(obj, "obj");
        return kotlin.jvm.internal.m.c(view, obj);
    }
}