package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatTextViewAutoSizeHelper.java */
/* loaded from: classes.dex */
public class v {
    private static final RectF a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f923b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f924c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f925d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f926e = false;

    /* renamed from: f  reason: collision with root package name */
    private float f927f = -1.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f928g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f929h = -1.0f;

    /* renamed from: i  reason: collision with root package name */
    private int[] f930i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    private boolean f931j = false;

    /* renamed from: k  reason: collision with root package name */
    private TextPaint f932k;

    /* renamed from: l  reason: collision with root package name */
    private final TextView f933l;
    private final Context m;
    private final c n;

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* loaded from: classes.dex */
    private static class a extends c {
        a() {
        }

        @Override // androidx.appcompat.widget.v.c
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) v.r(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* loaded from: classes.dex */
    private static class b extends a {
        b() {
        }

        @Override // androidx.appcompat.widget.v.a, androidx.appcompat.widget.v.c
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.v.c
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* loaded from: classes.dex */
    public static class c {
        c() {
        }

        void a(StaticLayout.Builder builder, TextView textView) {
        }

        boolean b(TextView textView) {
            return ((Boolean) v.r(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TextView textView) {
        this.f933l = textView;
        this.m = textView.getContext();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            this.n = new b();
        } else if (i2 >= 23) {
            this.n = new a();
        } else {
            this.n = new c();
        }
    }

    private void A(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f930i = c(iArr);
            B();
        }
    }

    private boolean B() {
        int[] iArr = this.f930i;
        int length = iArr.length;
        boolean z = length > 0;
        this.f931j = z;
        if (z) {
            this.f925d = 1;
            this.f928g = iArr[0];
            this.f929h = iArr[length - 1];
            this.f927f = -1.0f;
        }
        return z;
    }

    private boolean C(int i2, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f933l.getText();
        TransformationMethod transformationMethod = this.f933l.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f933l)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f933l.getMaxLines() : -1;
        q(i2);
        StaticLayout e2 = e(text, (Layout.Alignment) r(this.f933l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (e2.getLineCount() <= maxLines && e2.getLineEnd(e2.getLineCount() - 1) == text.length())) && ((float) e2.getHeight()) <= rectF.bottom;
    }

    private boolean D() {
        return !(this.f933l instanceof AppCompatEditText);
    }

    private void E(float f2, float f3, float f4) throws IllegalArgumentException {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 > 0.0f) {
            this.f925d = 1;
            this.f928g = f2;
            this.f929h = f3;
            this.f927f = f4;
            this.f931j = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
    }

    private static <T> T a(Object obj, String str, T t) {
        try {
            Field o = o(str);
            return o == null ? t : (T) o.get(obj);
        } catch (IllegalAccessException e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return t;
        }
    }

    private int[] c(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    private void d() {
        this.f925d = 0;
        this.f928g = -1.0f;
        this.f929h = -1.0f;
        this.f927f = -1.0f;
        this.f930i = new int[0];
        this.f926e = false;
    }

    private StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f932k, i2);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f933l.getLineSpacingExtra(), this.f933l.getLineSpacingMultiplier()).setIncludePad(this.f933l.getIncludeFontPadding()).setBreakStrategy(this.f933l.getBreakStrategy()).setHyphenationFrequency(this.f933l.getHyphenationFrequency());
        if (i3 == -1) {
            i3 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        }
        hyphenationFrequency.setMaxLines(i3);
        try {
            this.n.a(obtain, this.f933l);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    private StaticLayout g(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        return new StaticLayout(charSequence, this.f932k, i2, alignment, ((Float) a(this.f933l, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.f933l, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) a(this.f933l, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    private StaticLayout h(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        return new StaticLayout(charSequence, this.f932k, i2, alignment, this.f933l.getLineSpacingMultiplier(), this.f933l.getLineSpacingExtra(), this.f933l.getIncludeFontPadding());
    }

    private int i(RectF rectF) {
        int i2;
        int length = this.f930i.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i3 = 0;
        int i4 = 1;
        int i5 = length - 1;
        while (true) {
            int i6 = i4;
            int i7 = i3;
            i3 = i6;
            while (i3 <= i5) {
                i2 = (i3 + i5) / 2;
                if (C(this.f930i[i2], rectF)) {
                    break;
                }
                i7 = i2 - 1;
                i5 = i7;
            }
            return this.f930i[i7];
            i4 = i2 + 1;
        }
    }

    private static Field o(String str) {
        try {
            Field field = f924c.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                f924c.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return null;
        }
    }

    private static Method p(String str) {
        try {
            Method method = f923b.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f923b.put(str, method);
            }
            return method;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    static <T> T r(Object obj, String str, T t) {
        try {
            return (T) p(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return t;
        }
    }

    private void x(float f2) {
        if (f2 != this.f933l.getPaint().getTextSize()) {
            this.f933l.getPaint().setTextSize(f2);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.f933l.isInLayout() : false;
            if (this.f933l.getLayout() != null) {
                this.f926e = false;
                try {
                    Method p = p("nullLayouts");
                    if (p != null) {
                        p.invoke(this.f933l, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    this.f933l.requestLayout();
                } else {
                    this.f933l.forceLayout();
                }
                this.f933l.invalidate();
            }
        }
    }

    private boolean z() {
        if (D() && this.f925d == 1) {
            if (!this.f931j || this.f930i.length == 0) {
                int floor = ((int) Math.floor((this.f929h - this.f928g) / this.f927f)) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round(this.f928g + (i2 * this.f927f));
                }
                this.f930i = c(iArr);
            }
            this.f926e = true;
        } else {
            this.f926e = false;
        }
        return this.f926e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (s()) {
            if (this.f926e) {
                if (this.f933l.getMeasuredHeight() <= 0 || this.f933l.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.n.b(this.f933l) ? PKIFailureInfo.badCertTemplate : (this.f933l.getMeasuredWidth() - this.f933l.getTotalPaddingLeft()) - this.f933l.getTotalPaddingRight();
                int height = (this.f933l.getHeight() - this.f933l.getCompoundPaddingBottom()) - this.f933l.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = a;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float i2 = i(rectF);
                    if (i2 != this.f933l.getTextSize()) {
                        y(0, i2);
                    }
                }
            }
            this.f926e = true;
        }
    }

    StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            return f(charSequence, alignment, i2, i3);
        }
        if (i4 >= 16) {
            return h(charSequence, alignment, i2);
        }
        return g(charSequence, alignment, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return Math.round(this.f929h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return Math.round(this.f928g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return Math.round(this.f927f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] m() {
        return this.f930i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f925d;
    }

    void q(int i2) {
        TextPaint textPaint = this.f932k;
        if (textPaint == null) {
            this.f932k = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f932k.set(this.f933l.getPaint());
        this.f932k.setTextSize(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return D() && this.f925d != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(AttributeSet attributeSet, int i2) {
        int resourceId;
        Context context = this.m;
        int[] iArr = c.a.j.i0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        TextView textView = this.f933l;
        c.h.k.v.i0(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i2, 0);
        int i3 = c.a.j.n0;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f925d = obtainStyledAttributes.getInt(i3, 0);
        }
        int i4 = c.a.j.m0;
        float dimension = obtainStyledAttributes.hasValue(i4) ? obtainStyledAttributes.getDimension(i4, -1.0f) : -1.0f;
        int i5 = c.a.j.k0;
        float dimension2 = obtainStyledAttributes.hasValue(i5) ? obtainStyledAttributes.getDimension(i5, -1.0f) : -1.0f;
        int i6 = c.a.j.j0;
        float dimension3 = obtainStyledAttributes.hasValue(i6) ? obtainStyledAttributes.getDimension(i6, -1.0f) : -1.0f;
        int i7 = c.a.j.l0;
        if (obtainStyledAttributes.hasValue(i7) && (resourceId = obtainStyledAttributes.getResourceId(i7, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            A(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (D()) {
            if (this.f925d == 1) {
                if (!this.f931j) {
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    E(dimension2, dimension3, dimension);
                }
                z();
                return;
            }
            return;
        }
        this.f925d = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (D()) {
            DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(i5, i2, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (z()) {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int[] iArr, int i2) throws IllegalArgumentException {
        if (D()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, iArr[i3], displayMetrics));
                    }
                }
                this.f930i = c(iArr2);
                if (!B()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f931j = false;
            }
            if (z()) {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i2) {
        if (D()) {
            if (i2 == 0) {
                d();
            } else if (i2 == 1) {
                DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                E(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (z()) {
                    b();
                }
            } else {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i2, float f2) {
        Resources resources;
        Context context = this.m;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        x(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
    }
}