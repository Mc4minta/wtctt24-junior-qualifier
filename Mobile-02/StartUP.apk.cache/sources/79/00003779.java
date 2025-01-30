package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;

/* compiled from: BottomNavigationPresenter.java */
/* loaded from: classes2.dex */
public class d implements m {
    private g a;

    /* renamed from: b  reason: collision with root package name */
    private c f8115b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8116c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f8117d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BottomNavigationPresenter.java */
    /* loaded from: classes2.dex */
    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0148a();
        int a;

        /* compiled from: BottomNavigationPresenter.java */
        /* renamed from: com.google.android.material.bottomnavigation.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0148a implements Parcelable.Creator<a> {
            C0148a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public a[] newArray(int i2) {
                return new a[i2];
            }
        }

        a() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
        }

        a(Parcel parcel) {
            this.a = parcel.readInt();
        }
    }

    public void a(c cVar) {
        this.f8115b = cVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(boolean z) {
        if (this.f8116c) {
            return;
        }
        if (z) {
            this.f8115b.d();
        } else {
            this.f8115b.i();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.f8117d;
    }

    public void h(int i2) {
        this.f8117d = i2;
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(Context context, g gVar) {
        this.a = gVar;
        this.f8115b.b(gVar);
    }

    @Override // androidx.appcompat.view.menu.m
    public void j(Parcelable parcelable) {
        if (parcelable instanceof a) {
            this.f8115b.h(((a) parcelable).a);
        }
    }

    public void k(boolean z) {
        this.f8116c = z;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean l(r rVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable m() {
        a aVar = new a();
        aVar.a = this.f8115b.getSelectedItemId();
        return aVar;
    }
}