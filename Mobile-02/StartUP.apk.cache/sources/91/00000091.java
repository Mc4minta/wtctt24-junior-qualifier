package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.s0;
import c.h.k.v;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {
    private i a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f533b;

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f534c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f535d;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f536e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f537f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f538g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f539h;

    /* renamed from: j  reason: collision with root package name */
    private LinearLayout f540j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f541k;

    /* renamed from: l  reason: collision with root package name */
    private int f542l;
    private Context m;
    private boolean n;
    private Drawable p;
    private boolean q;
    private LayoutInflater t;
    private boolean u;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.D);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i2) {
        LinearLayout linearLayout = this.f540j;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(c.a.g.f2477h, (ViewGroup) this, false);
        this.f536e = checkBox;
        a(checkBox);
    }

    private void e() {
        ImageView imageView = (ImageView) getInflater().inflate(c.a.g.f2478i, (ViewGroup) this, false);
        this.f533b = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(c.a.g.f2480k, (ViewGroup) this, false);
        this.f534c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.t == null) {
            this.t = LayoutInflater.from(getContext());
        }
        return this.t;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f538g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f539h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f539h.getLayoutParams();
        rect.top += this.f539h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void f(i iVar, int i2) {
        this.a = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.i(this));
        setCheckable(iVar.isCheckable());
        h(iVar.A(), iVar.g());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.a;
    }

    public void h(boolean z, char c2) {
        int i2 = (z && this.a.A()) ? 0 : 8;
        if (i2 == 0) {
            this.f537f.setText(this.a.h());
        }
        if (this.f537f.getVisibility() != i2) {
            this.f537f.setVisibility(i2);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        v.m0(this, this.f541k);
        TextView textView = (TextView) findViewById(c.a.f.M);
        this.f535d = textView;
        int i2 = this.f542l;
        if (i2 != -1) {
            textView.setTextAppearance(this.m, i2);
        }
        this.f537f = (TextView) findViewById(c.a.f.F);
        ImageView imageView = (ImageView) findViewById(c.a.f.I);
        this.f538g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.p);
        }
        this.f539h = (ImageView) findViewById(c.a.f.r);
        this.f540j = (LinearLayout) findViewById(c.a.f.f2470l);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f533b != null && this.n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f533b.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f534c == null && this.f536e == null) {
            return;
        }
        if (this.a.m()) {
            if (this.f534c == null) {
                g();
            }
            compoundButton = this.f534c;
            compoundButton2 = this.f536e;
        } else {
            if (this.f536e == null) {
                c();
            }
            compoundButton = this.f536e;
            compoundButton2 = this.f534c;
        }
        if (z) {
            compoundButton.setChecked(this.a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f536e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f534c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.a.m()) {
            if (this.f534c == null) {
                g();
            }
            compoundButton = this.f534c;
        } else {
            if (this.f536e == null) {
                c();
            }
            compoundButton = this.f536e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.u = z;
        this.n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f539h;
        if (imageView != null) {
            imageView.setVisibility((this.q || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.a.z() || this.u;
        if (z || this.n) {
            ImageView imageView = this.f533b;
            if (imageView == null && drawable == null && !this.n) {
                return;
            }
            if (imageView == null) {
                e();
            }
            if (drawable == null && !this.n) {
                this.f533b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f533b;
            if (!z) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f533b.getVisibility() != 0) {
                this.f533b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f535d.setText(charSequence);
            if (this.f535d.getVisibility() != 0) {
                this.f535d.setVisibility(0);
            }
        } else if (this.f535d.getVisibility() != 8) {
            this.f535d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        s0 v = s0.v(getContext(), attributeSet, c.a.j.W1, i2, 0);
        this.f541k = v.g(c.a.j.Y1);
        this.f542l = v.n(c.a.j.X1, -1);
        this.n = v.a(c.a.j.Z1, false);
        this.m = context;
        this.p = v.g(c.a.j.a2);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, c.a.a.A, 0);
        this.q = obtainStyledAttributes.hasValue(0);
        v.w();
        obtainStyledAttributes.recycle();
    }
}