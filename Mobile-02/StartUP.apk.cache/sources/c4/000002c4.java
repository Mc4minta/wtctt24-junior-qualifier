package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentLayoutInflaterFactory.java */
/* loaded from: classes.dex */
public class k implements LayoutInflater.Factory2 {
    private final m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (g.class.getName().equals(str)) {
            return new g(context, attributeSet, this.a);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.l.c.f3139d);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(c.l.c.f3140e);
            }
            int resourceId = obtainStyledAttributes.getResourceId(c.l.c.f3141f, -1);
            String string = obtainStyledAttributes.getString(c.l.c.f3142g);
            obtainStyledAttributes.recycle();
            if (attributeValue == null || !i.b(context.getClassLoader(), attributeValue)) {
                return null;
            }
            int id = view != null ? view.getId() : 0;
            if (id == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
            }
            Fragment Y = resourceId != -1 ? this.a.Y(resourceId) : null;
            if (Y == null && string != null) {
                Y = this.a.Z(string);
            }
            if (Y == null && id != -1) {
                Y = this.a.Y(id);
            }
            if (m.r0(2)) {
                Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + Y);
            }
            if (Y == null) {
                Y = this.a.g0().a(context.getClassLoader(), attributeValue);
                Y.mFromLayout = true;
                Y.mFragmentId = resourceId != 0 ? resourceId : id;
                Y.mContainerId = id;
                Y.mTag = string;
                Y.mInLayout = true;
                m mVar = this.a;
                Y.mFragmentManager = mVar;
                j<?> jVar = mVar.p;
                Y.mHost = jVar;
                Y.onInflate(jVar.e(), attributeSet, Y.mSavedFragmentState);
                this.a.d(Y);
                this.a.B0(Y);
            } else if (!Y.mInLayout) {
                Y.mInLayout = true;
                j<?> jVar2 = this.a.p;
                Y.mHost = jVar2;
                Y.onInflate(jVar2.e(), attributeSet, Y.mSavedFragmentState);
            } else {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            m mVar2 = this.a;
            if (mVar2.o < 1 && Y.mFromLayout) {
                mVar2.C0(Y, 1);
            } else {
                mVar2.B0(Y);
            }
            View view2 = Y.mView;
            if (view2 != null) {
                if (resourceId != 0) {
                    view2.setId(resourceId);
                }
                if (Y.mView.getTag() == null) {
                    Y.mView.setTag(string);
                }
                return Y.mView;
            }
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        return null;
    }
}