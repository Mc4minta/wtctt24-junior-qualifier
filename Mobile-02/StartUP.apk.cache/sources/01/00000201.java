package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: ConstraintHelper.java */
/* loaded from: classes.dex */
public abstract class b extends View {
    protected int[] a;

    /* renamed from: b  reason: collision with root package name */
    protected int f1264b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f1265c;

    /* renamed from: d  reason: collision with root package name */
    protected c.f.b.k.i f1266d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f1267e;

    /* renamed from: f  reason: collision with root package name */
    protected String f1268f;

    /* renamed from: g  reason: collision with root package name */
    private View[] f1269g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<Integer, String> f1270h;

    public b(Context context) {
        super(context);
        this.a = new int[32];
        this.f1267e = false;
        this.f1269g = null;
        this.f1270h = new HashMap<>();
        this.f1265c = context;
        i(null);
    }

    private void a(String str) {
        if (str == null || str.length() == 0 || this.f1265c == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        int g2 = g(trim);
        if (g2 != 0) {
            this.f1270h.put(Integer.valueOf(g2), trim);
            b(g2);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void b(int i2) {
        if (i2 == getId()) {
            return;
        }
        int i3 = this.f1264b + 1;
        int[] iArr = this.a;
        if (i3 > iArr.length) {
            this.a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.a;
        int i4 = this.f1264b;
        iArr2[i4] = i2;
        this.f1264b = i4 + 1;
    }

    private int[] e(View view, String str) {
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        for (String str2 : split) {
            int g2 = g(str2.trim());
            if (g2 != 0) {
                iArr[i2] = g2;
                i2++;
            }
        }
        return i2 != split.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    private int f(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f1265c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int g(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i2 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i2 = ((Integer) designInformation).intValue();
            }
        }
        if (i2 == 0 && constraintLayout != null) {
            i2 = f(constraintLayout, str);
        }
        if (i2 == 0) {
            try {
                i2 = h.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i2 == 0 ? this.f1265c.getResources().getIdentifier(str, "id", this.f1265c.getPackageName()) : i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        d((ConstraintLayout) parent);
    }

    protected void d(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i2 = 0; i2 < this.f1264b; i2++) {
            View viewById = constraintLayout.getViewById(this.a[i2]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.a, this.f1264b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View[] h(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f1269g;
        if (viewArr == null || viewArr.length != this.f1264b) {
            this.f1269g = new View[this.f1264b];
        }
        for (int i2 = 0; i2 < this.f1264b; i2++) {
            this.f1269g[i2] = constraintLayout.getViewById(this.a[i2]);
        }
        return this.f1269g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.t1) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1268f = string;
                    setIds(string);
                }
            }
        }
    }

    public void j(d.a aVar, c.f.b.k.j jVar, ConstraintLayout.b bVar, SparseArray<c.f.b.k.e> sparseArray) {
        d.b bVar2 = aVar.f1292d;
        int[] iArr = bVar2.f0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = bVar2.g0;
            if (str != null && str.length() > 0) {
                d.b bVar3 = aVar.f1292d;
                bVar3.f0 = e(this, bVar3.g0);
            }
        }
        jVar.b();
        if (aVar.f1292d.f0 == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int[] iArr2 = aVar.f1292d.f0;
            if (i2 >= iArr2.length) {
                return;
            }
            c.f.b.k.e eVar = sparseArray.get(iArr2[i2]);
            if (eVar != null) {
                jVar.a(eVar);
            }
            i2++;
        }
    }

    public void k(c.f.b.k.e eVar, boolean z) {
    }

    public void l(ConstraintLayout constraintLayout) {
    }

    public void m(ConstraintLayout constraintLayout) {
    }

    public void n(ConstraintLayout constraintLayout) {
    }

    public void o(c.f.b.k.f fVar, c.f.b.k.i iVar, SparseArray<c.f.b.k.e> sparseArray) {
        iVar.b();
        for (int i2 = 0; i2 < this.f1264b; i2++) {
            iVar.a(sparseArray.get(this.a[i2]));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1268f;
        if (str != null) {
            setIds(str);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f1267e) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(ConstraintLayout constraintLayout) {
        String str;
        int f2;
        if (isInEditMode()) {
            setIds(this.f1268f);
        }
        c.f.b.k.i iVar = this.f1266d;
        if (iVar == null) {
            return;
        }
        iVar.b();
        for (int i2 = 0; i2 < this.f1264b; i2++) {
            int i3 = this.a[i2];
            View viewById = constraintLayout.getViewById(i3);
            if (viewById == null && (f2 = f(constraintLayout, (str = this.f1270h.get(Integer.valueOf(i3))))) != 0) {
                this.a[i2] = f2;
                this.f1270h.put(Integer.valueOf(f2), str);
                viewById = constraintLayout.getViewById(f2);
            }
            if (viewById != null) {
                this.f1266d.a(constraintLayout.getViewWidget(viewById));
            }
        }
        this.f1266d.c(constraintLayout.mLayoutWidget);
    }

    public void q() {
        if (this.f1266d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).n0 = (c.f.b.k.e) this.f1266d;
        }
    }

    protected void setIds(String str) {
        this.f1268f = str;
        if (str == null) {
            return;
        }
        int i2 = 0;
        this.f1264b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i2);
            if (indexOf == -1) {
                a(str.substring(i2));
                return;
            } else {
                a(str.substring(i2, indexOf));
                i2 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1268f = null;
        this.f1264b = 0;
        for (int i2 : iArr) {
            b(i2);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new int[32];
        this.f1267e = false;
        this.f1269g = null;
        this.f1270h = new HashMap<>();
        this.f1265c = context;
        i(attributeSet);
    }
}