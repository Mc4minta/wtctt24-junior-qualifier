package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.s0;
import c.h.k.v;
import com.google.android.material.internal.h;
import e.g.a.f.j;
import e.g.a.f.k;

/* loaded from: classes2.dex */
public class BottomNavigationView extends FrameLayout {
    private final g a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.material.bottomnavigation.c f8089b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.material.bottomnavigation.d f8090c;

    /* renamed from: d  reason: collision with root package name */
    private MenuInflater f8091d;

    /* renamed from: e  reason: collision with root package name */
    private c f8092e;

    /* renamed from: f  reason: collision with root package name */
    private b f8093f;

    /* loaded from: classes2.dex */
    class a implements g.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            if (BottomNavigationView.this.f8093f == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                return (BottomNavigationView.this.f8092e == null || BottomNavigationView.this.f8092e.a(menuItem)) ? false : true;
            }
            BottomNavigationView.this.f8093f.a(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(g gVar) {
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(MenuItem menuItem);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean a(MenuItem menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d extends c.j.a.a {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        Bundle f8094c;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.ClassLoaderCreator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(Parcel parcel, ClassLoader classLoader) {
            this.f8094c = parcel.readBundle(classLoader);
        }

        @Override // c.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f8094c);
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel, classLoader);
        }
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.g.a.f.b.a);
    }

    private void c(Context context) {
        View view = new View(context);
        view.setBackgroundColor(androidx.core.content.a.d(context, e.g.a.f.c.a));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.g.a.f.d.f13248h)));
        addView(view);
    }

    private MenuInflater getMenuInflater() {
        if (this.f8091d == null) {
            this.f8091d = new c.a.o.g(getContext());
        }
        return this.f8091d;
    }

    public void d(int i2) {
        this.f8090c.k(true);
        getMenuInflater().inflate(i2, this.a);
        this.f8090c.k(false);
        this.f8090c.c(true);
    }

    public Drawable getItemBackground() {
        return this.f8089b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f8089b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f8089b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f8089b.getIconTintList();
    }

    public int getItemTextAppearanceActive() {
        return this.f8089b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f8089b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f8089b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f8089b.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public Menu getMenu() {
        return this.a;
    }

    public int getSelectedItemId() {
        return this.f8089b.getSelectedItemId();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        this.a.S(dVar.f8094c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        dVar.f8094c = bundle;
        this.a.U(bundle);
        return dVar;
    }

    public void setItemBackground(Drawable drawable) {
        this.f8089b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i2) {
        this.f8089b.setItemBackgroundRes(i2);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.f8089b.f() != z) {
            this.f8089b.setItemHorizontalTranslationEnabled(z);
            this.f8090c.c(false);
        }
    }

    public void setItemIconSize(int i2) {
        this.f8089b.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f8089b.setIconTintList(colorStateList);
    }

    public void setItemTextAppearanceActive(int i2) {
        this.f8089b.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.f8089b.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f8089b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f8089b.getLabelVisibilityMode() != i2) {
            this.f8089b.setLabelVisibilityMode(i2);
            this.f8090c.c(false);
        }
    }

    public void setOnNavigationItemReselectedListener(b bVar) {
        this.f8093f = bVar;
    }

    public void setOnNavigationItemSelectedListener(c cVar) {
        this.f8092e = cVar;
    }

    public void setSelectedItemId(int i2) {
        MenuItem findItem = this.a.findItem(i2);
        if (findItem == null || this.a.O(findItem, this.f8090c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        com.google.android.material.bottomnavigation.d dVar = new com.google.android.material.bottomnavigation.d();
        this.f8090c = dVar;
        g bVar = new com.google.android.material.bottomnavigation.b(context);
        this.a = bVar;
        com.google.android.material.bottomnavigation.c cVar = new com.google.android.material.bottomnavigation.c(context);
        this.f8089b = cVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        cVar.setLayoutParams(layoutParams);
        dVar.a(cVar);
        dVar.h(1);
        cVar.setPresenter(dVar);
        bVar.b(dVar);
        dVar.i(getContext(), bVar);
        int[] iArr = k.x;
        int i3 = j.f13275f;
        int i4 = k.E;
        int i5 = k.D;
        s0 i6 = h.i(context, attributeSet, iArr, i2, i3, i4, i5);
        int i7 = k.C;
        if (i6.s(i7)) {
            cVar.setIconTintList(i6.c(i7));
        } else {
            cVar.setIconTintList(cVar.e(16842808));
        }
        setItemIconSize(i6.f(k.B, getResources().getDimensionPixelSize(e.g.a.f.d.f13244d)));
        if (i6.s(i4)) {
            setItemTextAppearanceInactive(i6.n(i4, 0));
        }
        if (i6.s(i5)) {
            setItemTextAppearanceActive(i6.n(i5, 0));
        }
        int i8 = k.F;
        if (i6.s(i8)) {
            setItemTextColor(i6.c(i8));
        }
        int i9 = k.y;
        if (i6.s(i9)) {
            v.q0(this, i6.f(i9, 0));
        }
        setLabelVisibilityMode(i6.l(k.G, -1));
        setItemHorizontalTranslationEnabled(i6.a(k.A, true));
        cVar.setItemBackgroundRes(i6.n(k.z, 0));
        int i10 = k.H;
        if (i6.s(i10)) {
            d(i6.n(i10, 0));
        }
        i6.w();
        addView(cVar, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            c(context);
        }
        bVar.V(new a());
    }
}