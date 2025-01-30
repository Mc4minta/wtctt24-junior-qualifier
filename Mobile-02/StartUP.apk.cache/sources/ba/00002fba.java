package com.facebook.react.views.picker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/* compiled from: ReactPickerAdapter.java */
/* loaded from: classes2.dex */
class b extends ArrayAdapter<c> {
    private final LayoutInflater a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f5342b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f5343c;

    public b(Context context, List<c> list) {
        super(context, 0, list);
        this.a = (LayoutInflater) e.f.k.a.a.c(context.getSystemService("layout_inflater"));
    }

    private View c(int i2, View view, ViewGroup viewGroup, boolean z) {
        Integer num;
        c item = getItem(i2);
        boolean z2 = false;
        if (view == null) {
            view = this.a.inflate(z ? 17367049 : 17367048, viewGroup, false);
            view.setTag(((TextView) view).getTextColors());
            z2 = true;
        }
        TextView textView = (TextView) view;
        textView.setText(item.a);
        if (!z && (num = this.f5342b) != null) {
            textView.setTextColor(num.intValue());
        } else {
            Integer num2 = item.f5344b;
            if (num2 != null) {
                textView.setTextColor(num2.intValue());
            } else if (textView.getTag() != null && !z2) {
                textView.setTextColor((ColorStateList) textView.getTag());
            }
        }
        Integer num3 = this.f5343c;
        if (num3 != null) {
            textView.setBackgroundColor(num3.intValue());
        }
        return textView;
    }

    public Integer a() {
        return this.f5343c;
    }

    public Integer b() {
        return this.f5342b;
    }

    public void d(Integer num) {
        this.f5343c = num;
        notifyDataSetChanged();
    }

    public void e(Integer num) {
        this.f5342b = num;
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        return c(i2, view, viewGroup, true);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        return c(i2, view, viewGroup, false);
    }
}