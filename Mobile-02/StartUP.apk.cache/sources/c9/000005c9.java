package c.i.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter.java */
/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: j  reason: collision with root package name */
    private int f3087j;

    /* renamed from: k  reason: collision with root package name */
    private int f3088k;

    /* renamed from: l  reason: collision with root package name */
    private LayoutInflater f3089l;

    @Deprecated
    public c(Context context, int i2, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f3088k = i2;
        this.f3087j = i2;
        this.f3089l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // c.i.a.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f3089l.inflate(this.f3088k, viewGroup, false);
    }

    @Override // c.i.a.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f3089l.inflate(this.f3087j, viewGroup, false);
    }
}