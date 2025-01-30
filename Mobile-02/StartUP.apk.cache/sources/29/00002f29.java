package com.facebook.react.uimanager;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: NativeViewHierarchyManager.java */
/* loaded from: classes2.dex */
public class l {
    private static final String a = "l";

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<View> f5140b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<ViewManager> f5141c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseBooleanArray f5142d;

    /* renamed from: e  reason: collision with root package name */
    private final y0 f5143e;

    /* renamed from: f  reason: collision with root package name */
    private final e.f.m.z.a f5144f;

    /* renamed from: g  reason: collision with root package name */
    private final RootViewManager f5145g;

    /* renamed from: h  reason: collision with root package name */
    private final com.facebook.react.uimanager.f1.e f5146h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f5147i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5148j;

    /* renamed from: k  reason: collision with root package name */
    private PopupMenu f5149k;

    /* renamed from: l  reason: collision with root package name */
    private HashMap<Integer, Set<Integer>> f5150l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NativeViewHierarchyManager.java */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.react.uimanager.f1.f {
        final /* synthetic */ ViewGroupManager a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f5151b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f5152c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Set f5153d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f5154e;

        a(ViewGroupManager viewGroupManager, ViewGroup viewGroup, View view, Set set, int i2) {
            this.a = viewGroupManager;
            this.f5151b = viewGroup;
            this.f5152c = view;
            this.f5153d = set;
            this.f5154e = i2;
        }

        @Override // com.facebook.react.uimanager.f1.f
        public void a() {
            UiThreadUtil.assertOnUiThread();
            this.a.removeView(this.f5151b, this.f5152c);
            l.this.n(this.f5152c);
            this.f5153d.remove(Integer.valueOf(this.f5152c.getId()));
            if (this.f5153d.isEmpty()) {
                l.this.f5150l.remove(Integer.valueOf(this.f5154e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeViewHierarchyManager.java */
    /* loaded from: classes2.dex */
    public static class b implements PopupMenu.OnMenuItemClickListener, PopupMenu.OnDismissListener {
        final Callback a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5156b;

        /* synthetic */ b(Callback callback, a aVar) {
            this(callback);
        }

        @Override // android.widget.PopupMenu.OnDismissListener
        public void onDismiss(PopupMenu popupMenu) {
            if (this.f5156b) {
                return;
            }
            this.a.invoke("dismissed");
            this.f5156b = true;
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.f5156b) {
                return false;
            }
            this.a.invoke("itemSelected", Integer.valueOf(menuItem.getOrder()));
            this.f5156b = true;
            return true;
        }

        private b(Callback callback) {
            this.f5156b = false;
            this.a = callback;
        }
    }

    public l(y0 y0Var) {
        this(y0Var, new RootViewManager());
    }

    private void D(View view, int i2, int i3, int i4, int i5) {
        if (this.f5148j && this.f5146h.h(view)) {
            this.f5146h.b(view, i2, i3, i4, i5);
        } else {
            view.layout(i2, i3, i4 + i2, i5 + i3);
        }
    }

    private boolean d(int[] iArr, int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private void g(View view, int[] iArr) {
        this.f5147i.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        s(view, this.f5147i);
        iArr[0] = Math.round(this.f5147i.left);
        iArr[1] = Math.round(this.f5147i.top);
        RectF rectF = this.f5147i;
        iArr[2] = Math.round(rectF.right - rectF.left);
        RectF rectF2 = this.f5147i;
        iArr[3] = Math.round(rectF2.bottom - rectF2.top);
    }

    private static String i(ViewGroup viewGroup, ViewGroupManager viewGroupManager, int[] iArr, u0[] u0VarArr, int[] iArr2) {
        int i2;
        int i3;
        int i4;
        int i5;
        StringBuilder sb = new StringBuilder();
        if (viewGroup != null) {
            sb.append("View tag:" + viewGroup.getId() + "\n");
            sb.append("  children(" + viewGroupManager.getChildCount(viewGroup) + "): [\n");
            for (int i6 = 0; i6 < viewGroupManager.getChildCount(viewGroup); i6 += 16) {
                int i7 = 0;
                while (true) {
                    if (i6 + i7 < viewGroupManager.getChildCount(viewGroup) && i7 < 16) {
                        sb.append(viewGroupManager.getChildAt(viewGroup, i5).getId() + ",");
                        i7++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (iArr != null) {
            sb.append("  indicesToRemove(" + iArr.length + "): [\n");
            for (int i8 = 0; i8 < iArr.length; i8 += 16) {
                int i9 = 0;
                while (true) {
                    if (i8 + i9 < iArr.length && i9 < 16) {
                        sb.append(iArr[i4] + ",");
                        i9++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (u0VarArr != null) {
            sb.append("  viewsToAdd(" + u0VarArr.length + "): [\n");
            for (int i10 = 0; i10 < u0VarArr.length; i10 += 16) {
                int i11 = 0;
                while (true) {
                    if (i10 + i11 < u0VarArr.length && i11 < 16) {
                        sb.append("[" + u0VarArr[i3].f5267c + "," + u0VarArr[i3].f5266b + "],");
                        i11++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (iArr2 != null) {
            sb.append("  tagsToDelete(" + iArr2.length + "): [\n");
            for (int i12 = 0; i12 < iArr2.length; i12 += 16) {
                int i13 = 0;
                while (true) {
                    if (i12 + i13 < iArr2.length && i13 < 16) {
                        sb.append(iArr2[i2] + ",");
                        i13++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ]\n");
        }
        return sb.toString();
    }

    private Set<Integer> p(int i2) {
        if (this.f5150l == null) {
            this.f5150l = new HashMap<>();
        }
        if (!this.f5150l.containsKey(Integer.valueOf(i2))) {
            this.f5150l.put(Integer.valueOf(i2), new HashSet());
        }
        return this.f5150l.get(Integer.valueOf(i2));
    }

    private i0 q(int i2) {
        View view = this.f5140b.get(i2);
        if (view != null) {
            return (i0) view.getContext();
        }
        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i2);
    }

    private void s(View view, RectF rectF) {
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.mapRect(rectF);
        }
        rectF.offset(view.getLeft(), view.getTop());
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset(-view2.getScrollX(), -view2.getScrollY());
            Matrix matrix2 = view2.getMatrix();
            if (!matrix2.isIdentity()) {
                matrix2.mapRect(rectF);
            }
            rectF.offset(view2.getLeft(), view2.getTop());
            parent = view2.getParent();
        }
    }

    public void A(boolean z) {
        this.f5148j = z;
    }

    public synchronized void B(int i2, ReadableArray readableArray, Callback callback, Callback callback2) {
        UiThreadUtil.assertOnUiThread();
        View view = this.f5140b.get(i2);
        if (view == null) {
            callback2.invoke("Can't display popup. Could not find view with tag " + i2);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(q(i2), view);
        this.f5149k = popupMenu;
        Menu menu = popupMenu.getMenu();
        for (int i3 = 0; i3 < readableArray.size(); i3++) {
            menu.add(0, 0, i3, readableArray.getString(i3));
        }
        b bVar = new b(callback, null);
        this.f5149k.setOnMenuItemClickListener(bVar);
        this.f5149k.setOnDismissListener(bVar);
        this.f5149k.show();
    }

    public synchronized void C(int i2, int i3, int i4, int i5, int i6, int i7) {
        UiThreadUtil.assertOnUiThread();
        com.facebook.systrace.b.a(0L, "NativeViewHierarchyManager_updateLayout").a("parentTag", i2).a("tag", i3).c();
        View w = w(i3);
        w.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
        ViewParent parent = w.getParent();
        if (parent instanceof d0) {
            parent.requestLayout();
        }
        if (!this.f5142d.get(i2)) {
            ViewManager viewManager = this.f5141c.get(i2);
            if (viewManager instanceof f) {
                f fVar = (f) viewManager;
                if (fVar != null && !fVar.needsCustomLayoutForChildren()) {
                    D(w, i4, i5, i6, i7);
                }
            } else {
                throw new IllegalViewOperationException("Trying to use view with tag " + i2 + " as a parent, but its Manager doesn't implement IViewManagerWithChildren");
            }
        } else {
            D(w, i4, i5, i6, i7);
        }
        com.facebook.systrace.a.g(0L);
    }

    public synchronized void E(int i2, a0 a0Var) {
        UiThreadUtil.assertOnUiThread();
        try {
            ViewManager x = x(i2);
            View w = w(i2);
            if (a0Var != null) {
                x.updateProperties(w, a0Var);
            }
        } catch (IllegalViewOperationException e2) {
            String str = a;
            e.f.d.d.a.j(str, "Unable to update properties for view tag " + i2, e2);
        }
    }

    public synchronized void F(int i2, Object obj) {
        UiThreadUtil.assertOnUiThread();
        x(i2).updateExtraData(w(i2), obj);
    }

    public synchronized void b(int i2, View view) {
        c(i2, view);
    }

    protected final synchronized void c(int i2, View view) {
        if (view.getId() != -1) {
            String str = a;
            e.f.d.d.a.i(str, "Trying to add a root view with an explicit id (" + view.getId() + ") already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
        }
        this.f5140b.put(i2, view);
        this.f5141c.put(i2, this.f5145g);
        this.f5142d.put(i2, true);
        view.setId(i2);
    }

    public void e() {
        this.f5144f.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f5146h.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ReadableMap readableMap, Callback callback) {
        this.f5146h.e(readableMap, callback);
    }

    public synchronized void j(i0 i0Var, int i2, String str, a0 a0Var) {
        UiThreadUtil.assertOnUiThread();
        com.facebook.systrace.b.a(0L, "NativeViewHierarchyManager_createView").a("tag", i2).b("className", str).c();
        ViewManager a2 = this.f5143e.a(str);
        View createView = a2.createView(i0Var, null, null, this.f5144f);
        this.f5140b.put(i2, createView);
        this.f5141c.put(i2, a2);
        createView.setId(i2);
        if (a0Var != null) {
            a2.updateProperties(createView, a0Var);
        }
        com.facebook.systrace.a.g(0L);
    }

    public void k() {
        PopupMenu popupMenu = this.f5149k;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
    }

    @Deprecated
    public synchronized void l(int i2, int i3, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        View view = this.f5140b.get(i2);
        if (view != null) {
            x(i2).receiveCommand((ViewManager) view, i3, readableArray);
        } else {
            throw new RetryableMountingLayerException("Trying to send command to a non-existing view with tag [" + i2 + "] and command " + i3);
        }
    }

    public synchronized void m(int i2, String str, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        View view = this.f5140b.get(i2);
        if (view != null) {
            x(i2).receiveCommand((ViewManager) view, str, readableArray);
        } else {
            throw new RetryableMountingLayerException("Trying to send command to a non-existing view with tag [" + i2 + "] and command " + str);
        }
    }

    protected synchronized void n(View view) {
        UiThreadUtil.assertOnUiThread();
        if (view == null) {
            return;
        }
        if (this.f5141c.get(view.getId()) == null) {
            return;
        }
        if (!this.f5142d.get(view.getId())) {
            x(view.getId()).onDropViewInstance(view);
        }
        ViewManager viewManager = this.f5141c.get(view.getId());
        if ((view instanceof ViewGroup) && (viewManager instanceof ViewGroupManager)) {
            ViewGroup viewGroup = (ViewGroup) view;
            ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
            for (int childCount = viewGroupManager.getChildCount(viewGroup) - 1; childCount >= 0; childCount--) {
                View childAt = viewGroupManager.getChildAt(viewGroup, childCount);
                if (childAt == null) {
                    e.f.d.d.a.i(a, "Unable to drop null child view");
                } else if (this.f5140b.get(childAt.getId()) != null) {
                    n(childAt);
                }
            }
            viewGroupManager.removeAllViews(viewGroup);
        }
        this.f5140b.remove(view.getId());
        this.f5141c.remove(view.getId());
    }

    public synchronized int o(int i2, float f2, float f3) {
        View view;
        UiThreadUtil.assertOnUiThread();
        view = this.f5140b.get(i2);
        if (view != null) {
        } else {
            throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i2);
        }
        return j0.c(f2, f3, (ViewGroup) view);
    }

    public synchronized void r(int i2, int[] iArr, u0[] u0VarArr, int[] iArr2) {
        int i3;
        int[] iArr3 = iArr;
        synchronized (this) {
            UiThreadUtil.assertOnUiThread();
            Set<Integer> p = p(i2);
            ViewGroup viewGroup = (ViewGroup) this.f5140b.get(i2);
            ViewGroupManager viewGroupManager = (ViewGroupManager) x(i2);
            if (viewGroup != null) {
                int childCount = viewGroupManager.getChildCount(viewGroup);
                if (iArr3 != null) {
                    int length = iArr3.length - 1;
                    while (length >= 0) {
                        int i4 = iArr3[length];
                        if (i4 >= 0) {
                            if (i4 >= viewGroupManager.getChildCount(viewGroup)) {
                                if (this.f5142d.get(i2) && viewGroupManager.getChildCount(viewGroup) == 0) {
                                    return;
                                }
                                throw new IllegalViewOperationException("Trying to remove a view index above child count " + i4 + " view tag: " + i2 + "\n detail: " + i(viewGroup, viewGroupManager, iArr3, u0VarArr, iArr2));
                            } else if (i4 < childCount) {
                                View childAt = viewGroupManager.getChildAt(viewGroup, i4);
                                if (!this.f5148j || !this.f5146h.h(childAt) || !d(iArr2, childAt.getId())) {
                                    viewGroupManager.removeViewAt(viewGroup, i4);
                                }
                                length--;
                                childCount = i4;
                            } else {
                                throw new IllegalViewOperationException("Trying to remove an out of order view index:" + i4 + " view tag: " + i2 + "\n detail: " + i(viewGroup, viewGroupManager, iArr3, u0VarArr, iArr2));
                            }
                        } else {
                            throw new IllegalViewOperationException("Trying to remove a negative view index:" + i4 + " view tag: " + i2 + "\n detail: " + i(viewGroup, viewGroupManager, iArr3, u0VarArr, iArr2));
                        }
                    }
                }
                if (iArr2 != null) {
                    int i5 = 0;
                    while (i5 < iArr2.length) {
                        int i6 = iArr2[i5];
                        View view = this.f5140b.get(i6);
                        if (view != null) {
                            if (this.f5148j && this.f5146h.h(view)) {
                                p.add(Integer.valueOf(i6));
                                i3 = i5;
                                this.f5146h.c(view, new a(viewGroupManager, viewGroup, view, p, i2));
                            } else {
                                i3 = i5;
                                n(view);
                            }
                            i5 = i3 + 1;
                            iArr3 = iArr;
                        } else {
                            throw new IllegalViewOperationException("Trying to destroy unknown view tag: " + i6 + "\n detail: " + i(viewGroup, viewGroupManager, iArr, u0VarArr, iArr2));
                        }
                    }
                }
                int[] iArr4 = iArr3;
                if (u0VarArr != null) {
                    for (u0 u0Var : u0VarArr) {
                        View view2 = this.f5140b.get(u0Var.f5266b);
                        if (view2 != null) {
                            int i7 = u0Var.f5267c;
                            if (!p.isEmpty()) {
                                i7 = 0;
                                int i8 = 0;
                                while (i7 < viewGroup.getChildCount() && i8 != u0Var.f5267c) {
                                    if (!p.contains(Integer.valueOf(viewGroup.getChildAt(i7).getId()))) {
                                        i8++;
                                    }
                                    i7++;
                                }
                            }
                            viewGroupManager.addView(viewGroup, view2, i7);
                        } else {
                            throw new IllegalViewOperationException("Trying to add unknown view tag: " + u0Var.f5266b + "\n detail: " + i(viewGroup, viewGroupManager, iArr4, u0VarArr, iArr2));
                        }
                    }
                }
                if (p.isEmpty()) {
                    this.f5150l.remove(Integer.valueOf(i2));
                }
                return;
            }
            throw new IllegalViewOperationException("Trying to manageChildren view with tag " + i2 + " which doesn't exist\n detail: " + i(viewGroup, viewGroupManager, iArr3, u0VarArr, iArr2));
        }
    }

    public synchronized void t(int i2, int[] iArr) {
        UiThreadUtil.assertOnUiThread();
        View view = this.f5140b.get(i2);
        if (view != null) {
            View view2 = (View) e0.a(view);
            if (view2 != null) {
                g(view2, iArr);
                int i3 = iArr[0];
                int i4 = iArr[1];
                g(view, iArr);
                iArr[0] = iArr[0] - i3;
                iArr[1] = iArr[1] - i4;
            } else {
                throw new NoSuchNativeViewException("Native view " + i2 + " is no longer on screen");
            }
        } else {
            throw new NoSuchNativeViewException("No native view for " + i2 + " currently exists");
        }
    }

    public synchronized void u(int i2, int[] iArr) {
        UiThreadUtil.assertOnUiThread();
        View view = this.f5140b.get(i2);
        if (view != null) {
            view.getLocationOnScreen(iArr);
            Resources resources = view.getContext().getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                iArr[1] = iArr[1] - ((int) resources.getDimension(identifier));
            }
            iArr[2] = view.getWidth();
            iArr[3] = view.getHeight();
        } else {
            throw new NoSuchNativeViewException("No native view for " + i2 + " currently exists");
        }
    }

    public synchronized void v(int i2) {
        UiThreadUtil.assertOnUiThread();
        if (!this.f5142d.get(i2)) {
            SoftAssertions.assertUnreachable("View with tag " + i2 + " is not registered as a root view");
        }
        n(this.f5140b.get(i2));
        this.f5142d.delete(i2);
    }

    public final synchronized View w(int i2) {
        View view;
        view = this.f5140b.get(i2);
        if (view == null) {
            throw new IllegalViewOperationException("Trying to resolve view with tag " + i2 + " which doesn't exist");
        }
        return view;
    }

    public final synchronized ViewManager x(int i2) {
        ViewManager viewManager;
        viewManager = this.f5141c.get(i2);
        if (viewManager == null) {
            throw new IllegalViewOperationException("ViewManager for tag " + i2 + " could not be found.\n");
        }
        return viewManager;
    }

    public void y(int i2, int i3) {
        View view = this.f5140b.get(i2);
        if (view != null) {
            view.sendAccessibilityEvent(i3);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i2);
    }

    public synchronized void z(int i2, int i3, boolean z) {
        if (!z) {
            this.f5144f.d(i3, null);
            return;
        }
        View view = this.f5140b.get(i2);
        if (i3 != i2 && (view instanceof ViewParent)) {
            this.f5144f.d(i3, (ViewParent) view);
            return;
        }
        if (this.f5142d.get(i2)) {
            SoftAssertions.assertUnreachable("Cannot block native responder on " + i2 + " that is a root view");
        }
        this.f5144f.d(i3, view.getParent());
    }

    public l(y0 y0Var, RootViewManager rootViewManager) {
        this.f5144f = new e.f.m.z.a();
        this.f5146h = new com.facebook.react.uimanager.f1.e();
        this.f5147i = new RectF();
        this.f5143e = y0Var;
        this.f5140b = new SparseArray<>();
        this.f5141c = new SparseArray<>();
        this.f5142d = new SparseBooleanArray();
        this.f5145g = rootViewManager;
    }
}