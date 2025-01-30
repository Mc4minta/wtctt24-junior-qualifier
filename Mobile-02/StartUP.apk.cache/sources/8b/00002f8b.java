package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: ARTTextShadowNode.java */
/* loaded from: classes2.dex */
public class e extends b {
    private ReadableMap O;
    private int P = 0;

    private void v1(Paint paint) {
        ReadableMap map;
        int i2 = this.P;
        int i3 = 2;
        if (i2 == 0) {
            paint.setTextAlign(Paint.Align.LEFT);
        } else if (i2 == 1) {
            paint.setTextAlign(Paint.Align.RIGHT);
        } else if (i2 == 2) {
            paint.setTextAlign(Paint.Align.CENTER);
        }
        ReadableMap readableMap = this.O;
        if (readableMap == null || !readableMap.hasKey("font") || (map = this.O.getMap("font")) == null) {
            return;
        }
        paint.setTextSize((map.hasKey("fontSize") ? (float) map.getDouble("fontSize") : 12.0f) * this.G);
        boolean z = map.hasKey("fontWeight") && "bold".equals(map.getString("fontWeight"));
        boolean z2 = map.hasKey("fontStyle") && "italic".equals(map.getString("fontStyle"));
        if (z && z2) {
            i3 = 3;
        } else if (z) {
            i3 = 1;
        } else if (!z2) {
            i3 = 0;
        }
        paint.setTypeface(Typeface.create(map.getString("fontFamily"), i3));
    }

    @Override // com.facebook.react.views.art.b, com.facebook.react.views.art.f
    public void n1(Canvas canvas, Paint paint, float f2) {
        ReadableArray array;
        ReadableMap readableMap = this.O;
        if (readableMap == null) {
            return;
        }
        float f3 = f2 * this.E;
        if (f3 > 0.01f && readableMap.hasKey("lines") && (array = this.O.getArray("lines")) != null && array.size() != 0) {
            p1(canvas);
            int size = array.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = array.getString(i2);
            }
            String join = TextUtils.join("\n", strArr);
            if (u1(paint, f3)) {
                v1(paint);
                Path path = this.H;
                if (path == null) {
                    canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                } else {
                    canvas.drawTextOnPath(join, path, 0.0f, 0.0f, paint);
                }
            }
            if (t1(paint, f3)) {
                v1(paint);
                Path path2 = this.H;
                if (path2 == null) {
                    canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                } else {
                    canvas.drawTextOnPath(join, path2, 0.0f, 0.0f, paint);
                }
            }
            o1(canvas);
            d();
        }
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 0, name = "alignment")
    public void setAlignment(int i2) {
        this.P = i2;
    }

    @com.facebook.react.uimanager.c1.a(name = "frame")
    public void setFrame(ReadableMap readableMap) {
        this.O = readableMap;
    }
}