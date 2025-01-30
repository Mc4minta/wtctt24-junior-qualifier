package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    private TypedValue a;

    /* renamed from: b  reason: collision with root package name */
    private TypedValue f690b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f691c;

    /* renamed from: d  reason: collision with root package name */
    private TypedValue f692d;

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f693e;

    /* renamed from: f  reason: collision with root package name */
    private TypedValue f694f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f695g;

    /* renamed from: h  reason: collision with root package name */
    private a f696h;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void b(int i2, int i3, int i4, int i5) {
        this.f695g.set(i2, i3, i4, i5);
        if (c.h.k.v.S(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f693e == null) {
            this.f693e = new TypedValue();
        }
        return this.f693e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f694f == null) {
            this.f694f = new TypedValue();
        }
        return this.f694f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f691c == null) {
            this.f691c = new TypedValue();
        }
        return this.f691c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f692d == null) {
            this.f692d = new TypedValue();
        }
        return this.f692d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.a == null) {
            this.a = new TypedValue();
        }
        return this.a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f690b == null) {
            this.f690b = new TypedValue();
        }
        return this.f690b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f696h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f696h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f696h = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f695g = new Rect();
    }
}