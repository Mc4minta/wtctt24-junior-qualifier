package com.facebook.react.views.unimplementedview;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: ReactUnimplementedView.java */
/* loaded from: classes2.dex */
public class a extends LinearLayout {
    private AppCompatTextView a;

    public a(Context context) {
        super(context);
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.a = appCompatTextView;
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.a.setGravity(17);
        this.a.setTextColor(-1);
        setBackgroundColor(1442775040);
        setGravity(1);
        setOrientation(1);
        addView(this.a);
    }

    public void setName(String str) {
        AppCompatTextView appCompatTextView = this.a;
        appCompatTextView.setText("'" + str + "' is not Fabric compatible yet.");
    }
}