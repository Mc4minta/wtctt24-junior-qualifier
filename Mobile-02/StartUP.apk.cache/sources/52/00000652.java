package c.s;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* compiled from: GhostViewHolder.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class j extends FrameLayout {
    private ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3316b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.a = viewGroup;
        viewGroup.setTag(s.f3350b, this);
        k0.b(this.a).c(this);
        this.f3316b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j b(ViewGroup viewGroup) {
        return (j) viewGroup.getTag(s.f3350b);
    }

    private int c(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (i2 <= childCount) {
            int i3 = (i2 + childCount) / 2;
            d(((l) getChildAt(i3)).f3326c, arrayList2);
            if (f(arrayList, arrayList2)) {
                i2 = i3 + 1;
            } else {
                childCount = i3 - 1;
            }
            arrayList2.clear();
        }
        return i2;
    }

    private static void d(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            d((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean e(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(k0.a(viewGroup, i2));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                break;
            }
        }
        return true;
    }

    private static boolean f(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i2 = 1; i2 < min; i2++) {
            View view = arrayList.get(i2);
            View view2 = arrayList2.get(i2);
            if (view != view2) {
                return e(view, view2);
            }
        }
        return arrayList2.size() == min;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        ArrayList<View> arrayList = new ArrayList<>();
        d(lVar.f3326c, arrayList);
        int c2 = c(arrayList);
        if (c2 >= 0 && c2 < getChildCount()) {
            addView(lVar, c2);
        } else {
            addView(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.f3316b) {
            k0.b(this.a).d(this);
            k0.b(this.a).c(this);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (this.f3316b) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.a.setTag(s.f3350b, null);
            k0.b(this.a).d(this);
            this.f3316b = false;
        }
    }
}