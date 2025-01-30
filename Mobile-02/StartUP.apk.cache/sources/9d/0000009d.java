package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* compiled from: MenuAdapter.java */
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    g a;

    /* renamed from: b  reason: collision with root package name */
    private int f590b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f591c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f592d;

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f593e;

    /* renamed from: f  reason: collision with root package name */
    private final int f594f;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f592d = z;
        this.f593e = layoutInflater;
        this.a = gVar;
        this.f594f = i2;
        a();
    }

    void a() {
        i x = this.a.x();
        if (x != null) {
            ArrayList<i> B = this.a.B();
            int size = B.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (B.get(i2) == x) {
                    this.f590b = i2;
                    return;
                }
            }
        }
        this.f590b = -1;
    }

    public g b() {
        return this.a;
    }

    @Override // android.widget.Adapter
    /* renamed from: c */
    public i getItem(int i2) {
        ArrayList<i> B = this.f592d ? this.a.B() : this.a.G();
        int i3 = this.f590b;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return B.get(i2);
    }

    public void d(boolean z) {
        this.f591c = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> B = this.f592d ? this.a.B() : this.a.G();
        if (this.f590b < 0) {
            return B.size();
        }
        return B.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f593e.inflate(this.f594f, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.a.H() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.f591c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.f(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}