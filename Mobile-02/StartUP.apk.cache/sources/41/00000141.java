package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.c;

/* compiled from: AppCompatSpinner.java */
/* loaded from: classes.dex */
public class s extends Spinner implements c.h.k.u {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = {16843505};
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private final androidx.appcompat.widget.e mBackgroundTintHelper;
    int mDropDownWidth;
    private c0 mForwardingListener;
    private g mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    class a extends c0 {

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ e f884k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, e eVar) {
            super(view);
            this.f884k = eVar;
        }

        @Override // androidx.appcompat.widget.c0
        public androidx.appcompat.view.menu.p b() {
            return this.f884k;
        }

        @Override // androidx.appcompat.widget.c0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (s.this.getInternalPopup().a()) {
                return true;
            }
            s.this.showPopup();
            return true;
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!s.this.getInternalPopup().a()) {
                s.this.showPopup();
            }
            ViewTreeObserver viewTreeObserver = s.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    class c implements g, DialogInterface.OnClickListener {
        androidx.appcompat.app.c a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f886b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f887c;

        c() {
        }

        @Override // androidx.appcompat.widget.s.g
        public boolean a() {
            androidx.appcompat.app.c cVar = this.a;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.s.g
        public void b(Drawable drawable) {
            Log.e(s.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.s.g
        public int c() {
            return 0;
        }

        @Override // androidx.appcompat.widget.s.g
        public void dismiss() {
            androidx.appcompat.app.c cVar = this.a;
            if (cVar != null) {
                cVar.dismiss();
                this.a = null;
            }
        }

        @Override // androidx.appcompat.widget.s.g
        public void e(int i2) {
            Log.e(s.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.s.g
        public CharSequence f() {
            return this.f887c;
        }

        @Override // androidx.appcompat.widget.s.g
        public Drawable i() {
            return null;
        }

        @Override // androidx.appcompat.widget.s.g
        public void j(CharSequence charSequence) {
            this.f887c = charSequence;
        }

        @Override // androidx.appcompat.widget.s.g
        public void l(int i2) {
            Log.e(s.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.s.g
        public void m(int i2) {
            Log.e(s.TAG, "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.s.g
        public void n(int i2, int i3) {
            if (this.f886b == null) {
                return;
            }
            c.a aVar = new c.a(s.this.getPopupContext());
            CharSequence charSequence = this.f887c;
            if (charSequence != null) {
                aVar.o(charSequence);
            }
            androidx.appcompat.app.c a = aVar.m(this.f886b, s.this.getSelectedItemPosition(), this).a();
            this.a = a;
            ListView a2 = a.a();
            if (Build.VERSION.SDK_INT >= 17) {
                a2.setTextDirection(i2);
                a2.setTextAlignment(i3);
            }
            this.a.show();
        }

        @Override // androidx.appcompat.widget.s.g
        public int o() {
            return 0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s.this.setSelection(i2);
            if (s.this.getOnItemClickListener() != null) {
                s.this.performItemClick(null, i2, this.f886b.getItemId(i2));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.s.g
        public void p(ListAdapter listAdapter) {
            this.f886b = listAdapter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    public static class d implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f889b;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f889b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof o0) {
                    o0 o0Var = (o0) spinnerAdapter;
                    if (o0Var.getDropDownViewTheme() == null) {
                        o0Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f889b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f889b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    class e extends e0 implements g {
        private CharSequence N;
        ListAdapter O;
        private final Rect P;
        private int Q;

        /* compiled from: AppCompatSpinner.java */
        /* loaded from: classes.dex */
        class a implements AdapterView.OnItemClickListener {
            final /* synthetic */ s a;

            a(s sVar) {
                this.a = sVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                s.this.setSelection(i2);
                if (s.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    s.this.performItemClick(view, i2, eVar.O.getItemId(i2));
                }
                e.this.dismiss();
            }
        }

        /* compiled from: AppCompatSpinner.java */
        /* loaded from: classes.dex */
        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.Q(s.this)) {
                    e.this.dismiss();
                    return;
                }
                e.this.O();
                e.super.h();
            }
        }

        /* compiled from: AppCompatSpinner.java */
        /* loaded from: classes.dex */
        class c implements PopupWindow.OnDismissListener {
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = s.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.a);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.P = new Rect();
            z(s.this);
            F(true);
            K(0);
            H(new a(s.this));
        }

        void O() {
            int P;
            Drawable i2 = i();
            int i3 = 0;
            if (i2 != null) {
                i2.getPadding(s.this.mTempRect);
                i3 = y0.b(s.this) ? s.this.mTempRect.right : -s.this.mTempRect.left;
            } else {
                Rect rect = s.this.mTempRect;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = s.this.getPaddingLeft();
            int paddingRight = s.this.getPaddingRight();
            int width = s.this.getWidth();
            s sVar = s.this;
            int i4 = sVar.mDropDownWidth;
            if (i4 == -2) {
                int compatMeasureContentWidth = sVar.compatMeasureContentWidth((SpinnerAdapter) this.O, i());
                int i5 = s.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = s.this.mTempRect;
                int i6 = (i5 - rect2.left) - rect2.right;
                if (compatMeasureContentWidth > i6) {
                    compatMeasureContentWidth = i6;
                }
                B(Math.max(compatMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (i4 == -1) {
                B((width - paddingLeft) - paddingRight);
            } else {
                B(i4);
            }
            if (y0.b(s.this)) {
                P = i3 + (((width - paddingRight) - v()) - P());
            } else {
                P = i3 + paddingLeft + P();
            }
            e(P);
        }

        public int P() {
            return this.Q;
        }

        boolean Q(View view) {
            return c.h.k.v.Q(view) && view.getGlobalVisibleRect(this.P);
        }

        @Override // androidx.appcompat.widget.s.g
        public CharSequence f() {
            return this.N;
        }

        @Override // androidx.appcompat.widget.s.g
        public void j(CharSequence charSequence) {
            this.N = charSequence;
        }

        @Override // androidx.appcompat.widget.s.g
        public void m(int i2) {
            this.Q = i2;
        }

        @Override // androidx.appcompat.widget.s.g
        public void n(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean a2 = a();
            O();
            E(2);
            super.h();
            ListView k2 = k();
            k2.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                k2.setTextDirection(i2);
                k2.setTextAlignment(i3);
            }
            L(s.this.getSelectedItemPosition());
            if (a2 || (viewTreeObserver = s.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            G(new c(bVar));
        }

        @Override // androidx.appcompat.widget.e0, androidx.appcompat.widget.s.g
        public void p(ListAdapter listAdapter) {
            super.p(listAdapter);
            this.O = listAdapter;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    public static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();
        boolean a;

        /* compiled from: AppCompatSpinner.java */
        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public f[] newArray(int i2) {
                return new f[i2];
            }
        }

        f(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
        }

        f(Parcel parcel) {
            super(parcel);
            this.a = parcel.readByte() != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    public interface g {
        boolean a();

        void b(Drawable drawable);

        int c();

        void dismiss();

        void e(int i2);

        CharSequence f();

        Drawable i();

        void j(CharSequence charSequence);

        void l(int i2);

        void m(int i2);

        void n(int i2, int i3);

        int o();

        void p(ListAdapter listAdapter);
    }

    public s(Context context) {
        this(context, (AttributeSet) null);
    }

    int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            Rect rect = this.mTempRect;
            return i3 + rect.left + rect.right;
        }
        return i3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        g gVar = this.mPopup;
        if (gVar != null) {
            return gVar.c();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        g gVar = this.mPopup;
        if (gVar != null) {
            return gVar.o();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    final g getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        g gVar = this.mPopup;
        if (gVar != null) {
            return gVar.i();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        g gVar = this.mPopup;
        return gVar != null ? gVar.f() : super.getPrompt();
    }

    @Override // c.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // c.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.mPopup;
        if (gVar == null || !gVar.a()) {
            return;
        }
        this.mPopup.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.mPopup == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        if (!fVar.a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        g gVar = this.mPopup;
        fVar.a = gVar != null && gVar.a();
        return fVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c0 c0Var = this.mForwardingListener;
        if (c0Var == null || !c0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        g gVar = this.mPopup;
        if (gVar != null) {
            if (gVar.a()) {
                return true;
            }
            showPopup();
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        androidx.appcompat.widget.e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i2) {
        g gVar = this.mPopup;
        if (gVar != null) {
            gVar.m(i2);
            this.mPopup.e(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i2) {
        g gVar = this.mPopup;
        if (gVar != null) {
            gVar.l(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i2) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.mPopup;
        if (gVar != null) {
            gVar.b(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(c.a.k.a.a.d(getPopupContext(), i2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        g gVar = this.mPopup;
        if (gVar != null) {
            gVar.j(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // c.h.k.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // c.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    void showPopup() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.mPopup.n(getTextDirection(), getTextAlignment());
        } else {
            this.mPopup.n(-1, -1);
        }
    }

    public s(Context context, int i2) {
        this(context, null, c.a.a.K, i2);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mPopup != null) {
            Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            this.mPopup.p(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.K);
    }

    public s(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    public s(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (r11 == null) goto L7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.s, android.widget.Spinner] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public s(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.s.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}