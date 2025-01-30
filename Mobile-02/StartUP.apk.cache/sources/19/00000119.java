package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* compiled from: MenuPopupWindow.java */
/* loaded from: classes.dex */
public class g0 extends e0 implements f0 {
    private static Method N;
    private f0 O;

    /* compiled from: MenuPopupWindow.java */
    /* loaded from: classes.dex */
    public static class a extends a0 {
        final int q;
        final int t;
        private f0 u;
        private MenuItem v;

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.q = 21;
                this.t = 22;
                return;
            }
            this.q = 22;
            this.t = 21;
        }

        @Override // androidx.appcompat.widget.a0
        public /* bridge */ /* synthetic */ int d(int i2, int i3, int i4, int i5, int i6) {
            return super.d(i2, i3, i4, i5, i6);
        }

        @Override // androidx.appcompat.widget.a0
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i2) {
            return super.e(motionEvent, i2);
        }

        @Override // androidx.appcompat.widget.a0, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.a0, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.a0, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.a0, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.a0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i2;
            androidx.appcompat.view.menu.f fVar;
            int pointToPosition;
            int i3;
            if (this.u != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i2 = headerViewListAdapter.getHeadersCount();
                    fVar = (androidx.appcompat.view.menu.f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i2 = 0;
                    fVar = (androidx.appcompat.view.menu.f) adapter;
                }
                androidx.appcompat.view.menu.i iVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i3 = pointToPosition - i2) >= 0 && i3 < fVar.getCount()) {
                    iVar = fVar.getItem(i3);
                }
                MenuItem menuItem = this.v;
                if (menuItem != iVar) {
                    androidx.appcompat.view.menu.g b2 = fVar.b();
                    if (menuItem != null) {
                        this.u.g(b2, menuItem);
                    }
                    this.v = iVar;
                    if (iVar != null) {
                        this.u.d(b2, iVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.q) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView != null && i2 == this.t) {
                setSelection(-1);
                ((androidx.appcompat.view.menu.f) getAdapter()).b().e(false);
                return true;
            } else {
                return super.onKeyDown(i2, keyEvent);
            }
        }

        @Override // androidx.appcompat.widget.a0, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(f0 f0Var) {
            this.u = f0Var;
        }

        @Override // androidx.appcompat.widget.a0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                N = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public g0(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void N(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.M.setEnterTransition((Transition) obj);
        }
    }

    public void O(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.M.setExitTransition((Transition) obj);
        }
    }

    public void P(f0 f0Var) {
        this.O = f0Var;
    }

    public void Q(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = N;
            if (method != null) {
                try {
                    method.invoke(this.M, Boolean.valueOf(z));
                    return;
                } catch (Exception unused) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.M.setTouchModal(z);
    }

    @Override // androidx.appcompat.widget.f0
    public void d(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        f0 f0Var = this.O;
        if (f0Var != null) {
            f0Var.d(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void g(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        f0 f0Var = this.O;
        if (f0Var != null) {
            f0Var.g(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.e0
    a0 s(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }
}