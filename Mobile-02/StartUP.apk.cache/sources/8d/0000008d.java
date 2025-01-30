package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.u0;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements n.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: e  reason: collision with root package name */
    i f523e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f524f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f525g;

    /* renamed from: h  reason: collision with root package name */
    g.b f526h;

    /* renamed from: j  reason: collision with root package name */
    private c0 f527j;

    /* renamed from: k  reason: collision with root package name */
    b f528k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f529l;
    private boolean m;
    private int n;
    private int p;
    private int q;

    /* loaded from: classes.dex */
    private class a extends c0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.c0
        public p b() {
            b bVar = ActionMenuItemView.this.f528k;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.c0
        protected boolean c() {
            p b2;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.f526h;
            return bVar != null && bVar.a(actionMenuItemView.f523e) && (b2 = b()) != null && b2.a();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract p a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean i() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void j() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f524f);
        if (this.f525g != null && (!this.f523e.B() || (!this.f529l && !this.m))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f524f : null);
        CharSequence contentDescription = this.f523e.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f523e.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f523e.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            u0.a(this, z3 ? null : this.f523e.getTitle());
        } else {
            u0.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return h();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return h() && this.f523e.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void f(i iVar, int i2) {
        this.f523e = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.i(this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f527j == null) {
            this.f527j = new a();
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f523e;
    }

    public boolean h() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar = this.f526h;
        if (bVar != null) {
            bVar.a(this.f523e);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f529l = i();
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        boolean h2 = h();
        if (h2 && (i5 = this.p) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i4 = Math.min(size, this.n);
        } else {
            i4 = this.n;
        }
        if (mode != 1073741824 && this.n > 0 && measuredWidth < i4) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
        }
        if (h2 || this.f525g == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f525g.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c0 c0Var;
        if (this.f523e.hasSubMenu() && (c0Var = this.f527j) != null && c0Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.m != z) {
            this.m = z;
            i iVar = this.f523e;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f525g = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.q;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (intrinsicHeight * (i2 / intrinsicWidth));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, null, null, null);
        j();
    }

    public void setItemInvoker(g.b bVar) {
        this.f526h = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.p = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.f528k = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f524f = charSequence;
        j();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.f529l = i();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.v, i2, 0);
        this.n = obtainStyledAttributes.getDimensionPixelSize(c.a.j.w, 0);
        obtainStyledAttributes.recycle();
        this.q = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.p = -1;
        setSaveEnabled(false);
    }
}