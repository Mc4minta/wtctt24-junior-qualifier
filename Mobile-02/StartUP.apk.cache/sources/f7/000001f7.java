package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import c.f.b.k.e;
import c.f.b.k.n.b;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.1";
    SparseArray<View> mChildrenByIds;
    private ArrayList<androidx.constraintlayout.widget.b> mConstraintHelpers;
    protected androidx.constraintlayout.widget.c mConstraintLayoutSpec;
    private d mConstraintSet;
    private int mConstraintSetId;
    private f mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected c.f.b.k.f mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    c mMeasurer;
    private c.f.b.e mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<c.f.b.k.e> mTempMapIdToWidget;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.b.values().length];
            a = iArr;
            try {
                iArr[e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements b.InterfaceC0060b {
        ConstraintLayout a;

        /* renamed from: b  reason: collision with root package name */
        int f1244b;

        /* renamed from: c  reason: collision with root package name */
        int f1245c;

        /* renamed from: d  reason: collision with root package name */
        int f1246d;

        /* renamed from: e  reason: collision with root package name */
        int f1247e;

        /* renamed from: f  reason: collision with root package name */
        int f1248f;

        /* renamed from: g  reason: collision with root package name */
        int f1249g;

        public c(ConstraintLayout constraintLayout) {
            this.a = constraintLayout;
        }

        @Override // c.f.b.k.n.b.InterfaceC0060b
        public final void a() {
            int childCount = this.a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.a.getChildAt(i2);
                if (childAt instanceof g) {
                    ((g) childAt).a(this.a);
                }
            }
            int size = this.a.mConstraintHelpers.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    ((androidx.constraintlayout.widget.b) this.a.mConstraintHelpers.get(i3)).m(this.a);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:103:0x016d A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:113:0x0186  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01a5  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x01b0  */
        /* JADX WARN: Removed duplicated region for block: B:122:0x01bc  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x01c6  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x01d3  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x01dd  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x01e5  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x01ea  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x01ef  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x01f7 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:143:0x0203 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:146:0x020e A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:152:0x021a  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x0220  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x0236  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x0238  */
        /* JADX WARN: Removed duplicated region for block: B:161:0x023e  */
        /* JADX WARN: Removed duplicated region for block: B:168:0x024d  */
        /* JADX WARN: Removed duplicated region for block: B:169:0x024f  */
        /* JADX WARN: Removed duplicated region for block: B:171:0x0252  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x014f  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x015a  */
        @Override // c.f.b.k.n.b.InterfaceC0060b
        @android.annotation.SuppressLint({"WrongCall"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(c.f.b.k.e r20, c.f.b.k.n.b.a r21) {
            /*
                Method dump skipped, instructions count: 615
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.c.b(c.f.b.k.e, c.f.b.k.n.b$a):void");
        }

        public void c(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f1244b = i4;
            this.f1245c = i5;
            this.f1246d = i6;
            this.f1247e = i7;
            this.f1248f = i2;
            this.f1249g = i3;
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new c.f.b.k.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.mMaxHeight = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 263;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Build.VERSION.SDK_INT >= 17 ? Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart()) : 0;
        return max2 > 0 ? max2 : max;
    }

    private final c.f.b.k.e getTargetWidget(int i2) {
        if (i2 == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i2);
        if (view == null && (view = findViewById(i2)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).n0;
    }

    private void init(AttributeSet attributeSet, int i2, int i3) {
        this.mLayoutWidget.d0(this);
        this.mLayoutWidget.i1(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.a1, i2, i3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == i.k1) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == i.l1) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == i.i1) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == i.j1) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == i.L2) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == i.M1) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == i.s1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.mConstraintSet = dVar;
                        dVar.x(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.j1(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            c.f.b.k.e viewWidget = getViewWidget(getChildAt(i2));
            if (viewWidget != null) {
                viewWidget.Z();
            }
        }
        if (isInEditMode) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).e0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof e)) {
                    this.mConstraintSet = ((e) childAt2).getConstraintSet();
                }
            }
        }
        d dVar = this.mConstraintSet;
        if (dVar != null) {
            dVar.f(this, true);
        }
        this.mLayoutWidget.O0();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                this.mConstraintHelpers.get(i5).p(this);
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt3 = getChildAt(i6);
            if (childAt3 instanceof g) {
                ((g) childAt3).b(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt4 = getChildAt(i7);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt5 = getChildAt(i8);
            c.f.b.k.e viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                b bVar = (b) childAt5.getLayoutParams();
                this.mLayoutWidget.a(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, bVar, this.mTempMapIdToWidget);
            }
        }
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (getChildAt(i2).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            setChildrenConstraints();
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void applyConstraintsFromLayoutParams(boolean r20, android.view.View r21, c.f.b.k.e r22, androidx.constraintlayout.widget.ConstraintLayout.b r23, android.util.SparseArray<c.f.b.k.e> r24) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.applyConstraintsFromLayoutParams(boolean, android.view.View, c.f.b.k.e, androidx.constraintlayout.widget.ConstraintLayout$b, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.b> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.mConstraintHelpers.get(i2).n(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i4 = (int) ((parseInt / 1080.0f) * width);
                        int i5 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = i4;
                        float f3 = i5;
                        float f4 = i4 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float parseInt4 = i5 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f4, f3, f4, parseInt4, paint);
                        canvas.drawLine(f4, parseInt4, f2, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f2, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f3, f4, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f4, f3, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(c.f.b.e eVar) {
        this.mLayoutWidget.W0(eVar);
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i2, Object obj) {
        if (i2 == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap<String, Integer> hashMap = this.mDesignIds;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return null;
            }
            return this.mDesignIds.get(str);
        }
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.Y0();
    }

    public View getViewById(int i2) {
        return this.mChildrenByIds.get(i2);
    }

    public final c.f.b.k.e getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).n0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRtl() {
        if (Build.VERSION.SDK_INT >= 17) {
            return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
        }
        return false;
    }

    public void loadLayoutDescription(int i2) {
        if (i2 != 0) {
            try {
                this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.c(getContext(), this, i2);
                return;
            } catch (Resources.NotFoundException unused) {
                this.mConstraintLayoutSpec = null;
                return;
            }
        }
        this.mConstraintLayoutSpec = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            b bVar = (b) childAt.getLayoutParams();
            c.f.b.k.e eVar = bVar.n0;
            if ((childAt.getVisibility() != 8 || bVar.Z || bVar.a0 || bVar.c0 || isInEditMode) && !bVar.b0) {
                int R = eVar.R();
                int S = eVar.S();
                int Q = eVar.Q() + R;
                int w = eVar.w() + S;
                childAt.layout(R, S, Q, w);
                if ((childAt instanceof g) && (content = ((g) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(R, S, Q, w);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.mConstraintHelpers.get(i7).l(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        this.mOnMeasureWidthMeasureSpec = i2;
        this.mOnMeasureHeightMeasureSpec = i3;
        this.mLayoutWidget.k1(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.m1();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i2, i3);
        resolveMeasuredDimension(i2, i3, this.mLayoutWidget.Q(), this.mLayoutWidget.w(), this.mLayoutWidget.e1(), this.mLayoutWidget.c1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        c.f.b.k.e viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof c.f.b.k.h)) {
            b bVar = (b) view.getLayoutParams();
            c.f.b.k.h hVar = new c.f.b.k.h();
            bVar.n0 = hVar;
            bVar.Z = true;
            hVar.S0(bVar.S);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar2 = (androidx.constraintlayout.widget.b) view;
            bVar2.q();
            ((b) view.getLayoutParams()).a0 = true;
            if (!this.mConstraintHelpers.contains(bVar2)) {
                this.mConstraintHelpers.add(bVar2);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.N0(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int i2) {
        this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.c(getContext(), this, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resolveMeasuredDimension(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        c cVar = this.mMeasurer;
        int i6 = cVar.f1247e;
        int i7 = i4 + cVar.f1246d;
        int i8 = i5 + i6;
        if (Build.VERSION.SDK_INT >= 11) {
            int resolveSizeAndState = ViewGroup.resolveSizeAndState(i7, i2, 0);
            int min = Math.min(this.mMaxWidth, resolveSizeAndState & 16777215);
            int min2 = Math.min(this.mMaxHeight, ViewGroup.resolveSizeAndState(i8, i3, 0) & 16777215);
            if (z) {
                min |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
            }
            if (z2) {
                min2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
            }
            setMeasuredDimension(min, min2);
            this.mLastMeasureWidth = min;
            this.mLastMeasureHeight = min2;
            return;
        }
        setMeasuredDimension(i7, i8);
        this.mLastMeasureWidth = i7;
        this.mLastMeasureHeight = i8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resolveSystem(c.f.b.k.f fVar, int i2, int i3, int i4) {
        int max;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        int max2 = Math.max(0, getPaddingTop());
        int max3 = Math.max(0, getPaddingBottom());
        int i5 = max2 + max3;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.c(i3, i4, max2, max3, paddingWidth, i5);
        if (Build.VERSION.SDK_INT >= 17) {
            int max4 = Math.max(0, getPaddingStart());
            int max5 = Math.max(0, getPaddingEnd());
            if (max4 <= 0 && max5 <= 0) {
                max4 = Math.max(0, getPaddingLeft());
            } else if (isRtl()) {
                max4 = max5;
            }
            max = max4;
        } else {
            max = Math.max(0, getPaddingLeft());
        }
        int i6 = size - paddingWidth;
        int i7 = size2 - i5;
        setSelfDimensionBehaviour(fVar, mode, i6, mode2, i7);
        fVar.f1(i2, mode, i6, mode2, i7, this.mLastMeasureWidth, this.mLastMeasureHeight, max, max2);
    }

    public void setConstraintSet(d dVar) {
        this.mConstraintSet = dVar;
    }

    public void setDesignInformation(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.View
    public void setId(int i2) {
        this.mChildrenByIds.remove(getId());
        super.setId(i2);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i2;
        requestLayout();
    }

    public void setMaxWidth(int i2) {
        if (i2 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i2;
        requestLayout();
    }

    public void setMinHeight(int i2) {
        if (i2 == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i2;
        requestLayout();
    }

    public void setMinWidth(int i2) {
        if (i2 == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i2;
        requestLayout();
    }

    public void setOnConstraintsChanged(f fVar) {
        androidx.constraintlayout.widget.c cVar = this.mConstraintLayoutSpec;
        if (cVar != null) {
            cVar.c(fVar);
        }
    }

    public void setOptimizationLevel(int i2) {
        this.mOptimizationLevel = i2;
        this.mLayoutWidget.j1(i2);
    }

    protected void setSelfDimensionBehaviour(c.f.b.k.f fVar, int i2, int i3, int i4, int i5) {
        e.b bVar;
        c cVar = this.mMeasurer;
        int i6 = cVar.f1247e;
        int i7 = cVar.f1246d;
        e.b bVar2 = e.b.FIXED;
        int childCount = getChildCount();
        if (i2 == Integer.MIN_VALUE) {
            bVar = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i3 = Math.max(0, this.mMinWidth);
            }
        } else if (i2 == 0) {
            bVar = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i3 = Math.max(0, this.mMinWidth);
            }
            i3 = 0;
        } else if (i2 != 1073741824) {
            bVar = bVar2;
            i3 = 0;
        } else {
            i3 = Math.min(this.mMaxWidth - i7, i3);
            bVar = bVar2;
        }
        if (i4 == Integer.MIN_VALUE) {
            bVar2 = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i5 = Math.max(0, this.mMinHeight);
            }
        } else if (i4 != 0) {
            if (i4 == 1073741824) {
                i5 = Math.min(this.mMaxHeight - i6, i5);
            }
            i5 = 0;
        } else {
            bVar2 = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i5 = Math.max(0, this.mMinHeight);
            }
            i5 = 0;
        }
        if (i3 != fVar.Q() || i5 != fVar.w()) {
            fVar.b1();
        }
        fVar.G0(0);
        fVar.H0(0);
        fVar.t0(this.mMaxWidth - i7);
        fVar.s0(this.mMaxHeight - i6);
        fVar.v0(0);
        fVar.u0(0);
        fVar.m0(bVar);
        fVar.F0(i3);
        fVar.B0(bVar2);
        fVar.i0(i5);
        fVar.v0(this.mMinWidth - i7);
        fVar.u0(this.mMinHeight - i6);
    }

    public void setState(int i2, int i3, int i4) {
        androidx.constraintlayout.widget.c cVar = this.mConstraintLayoutSpec;
        if (cVar != null) {
            cVar.d(i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new c.f.b.k.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.mMaxHeight = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 263;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new c.f.b.k.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.mMaxHeight = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 263;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i2, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new c.f.b.k.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.mMaxHeight = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 263;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i2, i3);
    }

    /* loaded from: classes.dex */
    public static class b extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        float C;
        int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        public String V;
        boolean W;
        boolean X;
        boolean Y;
        boolean Z;
        public int a;
        boolean a0;

        /* renamed from: b  reason: collision with root package name */
        public int f1233b;
        boolean b0;

        /* renamed from: c  reason: collision with root package name */
        public float f1234c;
        boolean c0;

        /* renamed from: d  reason: collision with root package name */
        public int f1235d;
        int d0;

        /* renamed from: e  reason: collision with root package name */
        public int f1236e;
        int e0;

        /* renamed from: f  reason: collision with root package name */
        public int f1237f;
        int f0;

        /* renamed from: g  reason: collision with root package name */
        public int f1238g;
        int g0;

        /* renamed from: h  reason: collision with root package name */
        public int f1239h;
        int h0;

        /* renamed from: i  reason: collision with root package name */
        public int f1240i;
        int i0;

        /* renamed from: j  reason: collision with root package name */
        public int f1241j;
        float j0;

        /* renamed from: k  reason: collision with root package name */
        public int f1242k;
        int k0;

        /* renamed from: l  reason: collision with root package name */
        public int f1243l;
        int l0;
        public int m;
        float m0;
        public int n;
        c.f.b.k.e n0;
        public float o;
        public boolean o0;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        /* loaded from: classes.dex */
        private static class a {
            public static final SparseIntArray a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                a = sparseIntArray;
                sparseIntArray.append(i.l2, 8);
                sparseIntArray.append(i.m2, 9);
                sparseIntArray.append(i.o2, 10);
                sparseIntArray.append(i.p2, 11);
                sparseIntArray.append(i.v2, 12);
                sparseIntArray.append(i.u2, 13);
                sparseIntArray.append(i.T1, 14);
                sparseIntArray.append(i.S1, 15);
                sparseIntArray.append(i.Q1, 16);
                sparseIntArray.append(i.U1, 2);
                sparseIntArray.append(i.W1, 3);
                sparseIntArray.append(i.V1, 4);
                sparseIntArray.append(i.D2, 49);
                sparseIntArray.append(i.E2, 50);
                sparseIntArray.append(i.a2, 5);
                sparseIntArray.append(i.b2, 6);
                sparseIntArray.append(i.c2, 7);
                sparseIntArray.append(i.b1, 1);
                sparseIntArray.append(i.q2, 17);
                sparseIntArray.append(i.r2, 18);
                sparseIntArray.append(i.Z1, 19);
                sparseIntArray.append(i.Y1, 20);
                sparseIntArray.append(i.H2, 21);
                sparseIntArray.append(i.K2, 22);
                sparseIntArray.append(i.I2, 23);
                sparseIntArray.append(i.F2, 24);
                sparseIntArray.append(i.J2, 25);
                sparseIntArray.append(i.G2, 26);
                sparseIntArray.append(i.h2, 29);
                sparseIntArray.append(i.w2, 30);
                sparseIntArray.append(i.X1, 44);
                sparseIntArray.append(i.j2, 45);
                sparseIntArray.append(i.y2, 46);
                sparseIntArray.append(i.i2, 47);
                sparseIntArray.append(i.x2, 48);
                sparseIntArray.append(i.O1, 27);
                sparseIntArray.append(i.N1, 28);
                sparseIntArray.append(i.z2, 31);
                sparseIntArray.append(i.d2, 32);
                sparseIntArray.append(i.B2, 33);
                sparseIntArray.append(i.A2, 34);
                sparseIntArray.append(i.C2, 35);
                sparseIntArray.append(i.f2, 36);
                sparseIntArray.append(i.e2, 37);
                sparseIntArray.append(i.g2, 38);
                sparseIntArray.append(i.k2, 39);
                sparseIntArray.append(i.t2, 40);
                sparseIntArray.append(i.n2, 41);
                sparseIntArray.append(i.R1, 42);
                sparseIntArray.append(i.P1, 43);
                a.append(i.s2, 51);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            this.a = -1;
            this.f1233b = -1;
            this.f1234c = -1.0f;
            this.f1235d = -1;
            this.f1236e = -1;
            this.f1237f = -1;
            this.f1238g = -1;
            this.f1239h = -1;
            this.f1240i = -1;
            this.f1241j = -1;
            this.f1242k = -1;
            this.f1243l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = false;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = 0.5f;
            this.n0 = new c.f.b.k.e();
            this.o0 = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = a.a.get(index);
                switch (i4) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.m);
                        this.m = resourceId;
                        if (resourceId == -1) {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        float f2 = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        this.o = f2;
                        if (f2 < 0.0f) {
                            this.o = (360.0f - f2) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.a = obtainStyledAttributes.getDimensionPixelOffset(index, this.a);
                        break;
                    case 6:
                        this.f1233b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1233b);
                        break;
                    case 7:
                        this.f1234c = obtainStyledAttributes.getFloat(index, this.f1234c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f1235d);
                        this.f1235d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1235d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f1236e);
                        this.f1236e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1236e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f1237f);
                        this.f1237f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1237f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f1238g);
                        this.f1238g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f1238g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f1239h);
                        this.f1239h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1239h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f1240i);
                        this.f1240i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1240i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f1241j);
                        this.f1241j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1241j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f1242k);
                        this.f1242k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1242k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f1243l);
                        this.f1243l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f1243l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId11;
                        if (resourceId11 == -1) {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.q);
                        this.q = resourceId12;
                        if (resourceId12 == -1) {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId13;
                        if (resourceId13 == -1) {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId14;
                        if (resourceId14 == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        int i5 = obtainStyledAttributes.getInt(index, 0);
                        this.I = i5;
                        if (i5 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i6 = obtainStyledAttributes.getInt(index, 0);
                        this.J = i6;
                        if (i6 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        this.I = 2;
                        break;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        this.J = 2;
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = Float.NaN;
                                this.D = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.D = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.D = 1;
                                        }
                                        i2 = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.B.substring(i2, indexOf2);
                                        String substring3 = this.B.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.D == 1) {
                                                        this.C = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        this.C = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.B.substring(i2);
                                        if (substring4.length() > 0) {
                                            this.C = Float.parseFloat(substring4);
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                                break;
                            case 45:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                continue;
                            case 46:
                                this.F = obtainStyledAttributes.getFloat(index, this.F);
                                continue;
                            case 47:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.H = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                continue;
                            case 50:
                                this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                                continue;
                            case 51:
                                this.V = obtainStyledAttributes.getString(index);
                                continue;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            c();
        }

        public String a() {
            return this.V;
        }

        public c.f.b.k.e b() {
            return this.n0;
        }

        public void c() {
            this.Z = false;
            this.W = true;
            this.X = true;
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            int i3 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i3 == -2 && this.U) {
                this.X = false;
                if (this.J == 0) {
                    this.J = 1;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.W = false;
                if (i2 == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.T = true;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.X = false;
                if (i3 == 0 && this.J == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.U = true;
                }
            }
            if (this.f1234c == -1.0f && this.a == -1 && this.f1233b == -1) {
                return;
            }
            this.Z = true;
            this.W = true;
            this.X = true;
            if (!(this.n0 instanceof c.f.b.k.h)) {
                this.n0 = new c.f.b.k.h();
            }
            ((c.f.b.k.h) this.n0).S0(this.S);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r10) {
            /*
                Method dump skipped, instructions count: 263
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }

        public b(int i2, int i3) {
            super(i2, i3);
            this.a = -1;
            this.f1233b = -1;
            this.f1234c = -1.0f;
            this.f1235d = -1;
            this.f1236e = -1;
            this.f1237f = -1;
            this.f1238g = -1;
            this.f1239h = -1;
            this.f1240i = -1;
            this.f1241j = -1;
            this.f1242k = -1;
            this.f1243l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = false;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = 0.5f;
            this.n0 = new c.f.b.k.e();
            this.o0 = false;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = -1;
            this.f1233b = -1;
            this.f1234c = -1.0f;
            this.f1235d = -1;
            this.f1236e = -1;
            this.f1237f = -1;
            this.f1238g = -1;
            this.f1239h = -1;
            this.f1240i = -1;
            this.f1241j = -1;
            this.f1242k = -1;
            this.f1243l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = false;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = 0.5f;
            this.n0 = new c.f.b.k.e();
            this.o0 = false;
        }
    }
}