package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter.java */
/* loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {
    Context a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f580b;

    /* renamed from: c  reason: collision with root package name */
    g f581c;

    /* renamed from: d  reason: collision with root package name */
    ExpandedMenuView f582d;

    /* renamed from: e  reason: collision with root package name */
    int f583e;

    /* renamed from: f  reason: collision with root package name */
    int f584f;

    /* renamed from: g  reason: collision with root package name */
    int f585g;

    /* renamed from: h  reason: collision with root package name */
    private m.a f586h;

    /* renamed from: j  reason: collision with root package name */
    a f587j;

    /* renamed from: k  reason: collision with root package name */
    private int f588k;

    /* compiled from: ListMenuPresenter.java */
    /* loaded from: classes.dex */
    private class a extends BaseAdapter {
        private int a = -1;

        public a() {
            a();
        }

        void a() {
            i x = e.this.f581c.x();
            if (x != null) {
                ArrayList<i> B = e.this.f581c.B();
                int size = B.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (B.get(i2) == x) {
                        this.a = i2;
                        return;
                    }
                }
            }
            this.a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b */
        public i getItem(int i2) {
            ArrayList<i> B = e.this.f581c.B();
            int i3 = i2 + e.this.f583e;
            int i4 = this.a;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return B.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.f581c.B().size() - e.this.f583e;
            return this.a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f580b.inflate(eVar.f585g, viewGroup, false);
            }
            ((n.a) view).f(getItem(i2), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i2) {
        this(i2, 0);
        this.a = context;
        this.f580b = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f587j == null) {
            this.f587j = new a();
        }
        return this.f587j;
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.f586h;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(boolean z) {
        a aVar = this.f587j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
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
    public void g(m.a aVar) {
        this.f586h = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.f588k;
    }

    public n h(ViewGroup viewGroup) {
        if (this.f582d == null) {
            this.f582d = (ExpandedMenuView) this.f580b.inflate(c.a.g.f2476g, viewGroup, false);
            if (this.f587j == null) {
                this.f587j = new a();
            }
            this.f582d.setAdapter((ListAdapter) this.f587j);
            this.f582d.setOnItemClickListener(this);
        }
        return this.f582d;
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(Context context, g gVar) {
        if (this.f584f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f584f);
            this.a = contextThemeWrapper;
            this.f580b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.a != null) {
            this.a = context;
            if (this.f580b == null) {
                this.f580b = LayoutInflater.from(context);
            }
        }
        this.f581c = gVar;
        a aVar = this.f587j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void j(Parcelable parcelable) {
        k((Bundle) parcelable);
    }

    public void k(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f582d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean l(r rVar) {
        if (rVar.hasVisibleItems()) {
            new h(rVar).d(null);
            m.a aVar = this.f586h;
            if (aVar != null) {
                aVar.c(rVar);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable m() {
        if (this.f582d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        n(bundle);
        return bundle;
    }

    public void n(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f582d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f581c.O(this.f587j.getItem(i2), this, 0);
    }

    public e(int i2, int i3) {
        this.f585g = i2;
        this.f584f = i3;
    }
}