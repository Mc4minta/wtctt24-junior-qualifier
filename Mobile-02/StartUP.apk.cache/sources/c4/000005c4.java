package c.i.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import c.i.a.b;

/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {
    protected boolean a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f3080b;

    /* renamed from: c  reason: collision with root package name */
    protected Cursor f3081c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f3082d;

    /* renamed from: e  reason: collision with root package name */
    protected int f3083e;

    /* renamed from: f  reason: collision with root package name */
    protected C0071a f3084f;

    /* renamed from: g  reason: collision with root package name */
    protected DataSetObserver f3085g;

    /* renamed from: h  reason: collision with root package name */
    protected c.i.a.b f3086h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* renamed from: c.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0071a extends ContentObserver {
        C0071a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        f(context, cursor, z ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor j2 = j(cursor);
        if (j2 != null) {
            j2.close();
        }
    }

    @Override // c.i.a.b.a
    public Cursor b() {
        return this.f3081c;
    }

    public abstract CharSequence c(Cursor cursor);

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i2) {
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.f3080b = true;
        } else {
            this.f3080b = false;
        }
        boolean z = cursor != null;
        this.f3081c = cursor;
        this.a = z;
        this.f3082d = context;
        this.f3083e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f3084f = new C0071a();
            this.f3085g = new b();
        } else {
            this.f3084f = null;
            this.f3085g = null;
        }
        if (z) {
            C0071a c0071a = this.f3084f;
            if (c0071a != null) {
                cursor.registerContentObserver(c0071a);
            }
            DataSetObserver dataSetObserver = this.f3085g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.a || (cursor = this.f3081c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (this.a) {
            this.f3081c.moveToPosition(i2);
            if (view == null) {
                view = g(this.f3082d, this.f3081c, viewGroup);
            }
            e(view, this.f3082d, this.f3081c);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f3086h == null) {
            this.f3086h = new c.i.a.b(this);
        }
        return this.f3086h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.a || (cursor = this.f3081c) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f3081c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        Cursor cursor;
        if (this.a && (cursor = this.f3081c) != null && cursor.moveToPosition(i2)) {
            return this.f3081c.getLong(this.f3083e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (this.a) {
            if (this.f3081c.moveToPosition(i2)) {
                if (view == null) {
                    view = h(this.f3082d, this.f3081c, viewGroup);
                }
                e(view, this.f3082d, this.f3081c);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i2);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.f3080b || (cursor = this.f3081c) == null || cursor.isClosed()) {
            return;
        }
        this.a = this.f3081c.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f3081c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0071a c0071a = this.f3084f;
            if (c0071a != null) {
                cursor2.unregisterContentObserver(c0071a);
            }
            DataSetObserver dataSetObserver = this.f3085g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f3081c = cursor;
        if (cursor != null) {
            C0071a c0071a2 = this.f3084f;
            if (c0071a2 != null) {
                cursor.registerContentObserver(c0071a2);
            }
            DataSetObserver dataSetObserver2 = this.f3085g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f3083e = cursor.getColumnIndexOrThrow("_id");
            this.a = true;
            notifyDataSetChanged();
        } else {
            this.f3083e = -1;
            this.a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}