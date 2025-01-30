package com.facebook.react.views.picker;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.s;
import java.util.List;

/* compiled from: ReactPicker.java */
/* loaded from: classes2.dex */
public class a extends s {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private c f5334b;

    /* renamed from: c  reason: collision with root package name */
    private List<com.facebook.react.views.picker.c> f5335c;

    /* renamed from: d  reason: collision with root package name */
    private List<com.facebook.react.views.picker.c> f5336d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f5337e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f5338f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f5339g;

    /* renamed from: h  reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f5340h;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f5341j;

    /* compiled from: ReactPicker.java */
    /* renamed from: com.facebook.react.views.picker.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0125a implements AdapterView.OnItemSelectedListener {
        C0125a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (a.this.f5334b != null) {
                a.this.f5334b.a(i2);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            if (a.this.f5334b != null) {
                a.this.f5334b.a(-1);
            }
        }
    }

    /* compiled from: ReactPicker.java */
    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.measure(View.MeasureSpec.makeMeasureSpec(aVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(a.this.getHeight(), 1073741824));
            a aVar2 = a.this;
            aVar2.layout(aVar2.getLeft(), a.this.getTop(), a.this.getRight(), a.this.getBottom());
        }
    }

    /* compiled from: ReactPicker.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(int i2);
    }

    public a(Context context, int i2) {
        super(context, i2);
        this.a = 0;
        this.f5340h = new C0125a();
        this.f5341j = new b();
        this.a = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        setOnItemSelectedListener(null);
        com.facebook.react.views.picker.b bVar = (com.facebook.react.views.picker.b) getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        List<com.facebook.react.views.picker.c> list = this.f5336d;
        if (list != null && list != this.f5335c) {
            this.f5335c = list;
            this.f5336d = null;
            if (bVar == null) {
                bVar = new com.facebook.react.views.picker.b(getContext(), this.f5335c);
                setAdapter((SpinnerAdapter) bVar);
            } else {
                bVar.clear();
                bVar.addAll(this.f5335c);
                bVar.notifyDataSetChanged();
            }
        }
        Integer num = this.f5337e;
        if (num != null && num.intValue() != selectedItemPosition) {
            setSelection(this.f5337e.intValue(), false);
            this.f5337e = null;
        }
        Integer num2 = this.f5338f;
        if (num2 != null && bVar != null && num2 != bVar.b()) {
            bVar.e(this.f5338f);
            this.f5338f = null;
        }
        Integer num3 = this.f5339g;
        if (num3 != null && bVar != null && num3 != bVar.a()) {
            bVar.d(this.f5339g);
            this.f5339g = null;
        }
        setOnItemSelectedListener(this.f5340h);
    }

    public int getMode() {
        return this.a;
    }

    public c getOnSelectListener() {
        return this.f5334b;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (getOnItemSelectedListener() == null) {
            setOnItemSelectedListener(this.f5340h);
        }
    }

    @Override // android.widget.AbsSpinner, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.f5341j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImmediateSelection(int i2) {
        if (i2 != getSelectedItemPosition()) {
            setOnItemSelectedListener(null);
            setSelection(i2, false);
            setOnItemSelectedListener(this.f5340h);
        }
    }

    public void setOnSelectListener(c cVar) {
        this.f5334b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStagedBackgroundColor(Integer num) {
        this.f5339g = num;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStagedItems(List<com.facebook.react.views.picker.c> list) {
        this.f5336d = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStagedPrimaryTextColor(Integer num) {
        this.f5338f = num;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStagedSelection(int i2) {
        this.f5337e = Integer.valueOf(i2);
    }
}