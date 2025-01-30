package c.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
public abstract class y implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private ArrayList<e0> mEndValuesList;
    private f mEpicenterCallback;
    private c.e.a<String, String> mNameOverrides;
    b0 mPropagation;
    private ArrayList<e0> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final p STRAIGHT_PATH_MOTION = new a();
    private static ThreadLocal<c.e.a<Animator, d>> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    private long mStartDelay = -1;
    long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private f0 mStartValues = new f0();
    private f0 mEndValues = new f0();
    c0 mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private ViewGroup mSceneRoot = null;
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private int mNumInstances = 0;
    private boolean mPaused = false;
    private boolean mEnded = false;
    private ArrayList<g> mListeners = null;
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    private p mPathMotion = STRAIGHT_PATH_MOTION;

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    static class a extends p {
        a() {
        }

        @Override // c.s.p
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        final /* synthetic */ c.e.a a;

        b(c.e.a aVar) {
            this.a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            y.this.mCurrentAnimators.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            y.this.mCurrentAnimators.add(animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            y.this.end();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static class d {
        View a;

        /* renamed from: b  reason: collision with root package name */
        String f3401b;

        /* renamed from: c  reason: collision with root package name */
        e0 f3402c;

        /* renamed from: d  reason: collision with root package name */
        a1 f3403d;

        /* renamed from: e  reason: collision with root package name */
        y f3404e;

        d(View view, String str, y yVar, a1 a1Var, e0 e0Var) {
            this.a = view;
            this.f3401b = str;
            this.f3402c = e0Var;
            this.f3403d = a1Var;
            this.f3404e = yVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static class e {
        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t) {
            if (arrayList != null) {
                arrayList.remove(t);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
            return arrayList;
        }
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static abstract class f {
        public abstract Rect a(y yVar);
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public interface g {
        void a(y yVar);

        void b(y yVar);

        void c(y yVar);

        void d(y yVar);

        void e(y yVar);
    }

    public y() {
    }

    private void addUnmatched(c.e.a<View, e0> aVar, c.e.a<View, e0> aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            e0 valueAt = aVar.valueAt(i2);
            if (isValidTarget(valueAt.f3289b)) {
                this.mStartValuesList.add(valueAt);
                this.mEndValuesList.add(null);
            }
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            e0 valueAt2 = aVar2.valueAt(i3);
            if (isValidTarget(valueAt2.f3289b)) {
                this.mEndValuesList.add(valueAt2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private static void addViewValues(f0 f0Var, View view, e0 e0Var) {
        f0Var.a.put(view, e0Var);
        int id = view.getId();
        if (id >= 0) {
            if (f0Var.f3293b.indexOfKey(id) >= 0) {
                f0Var.f3293b.put(id, null);
            } else {
                f0Var.f3293b.put(id, view);
            }
        }
        String H = c.h.k.v.H(view);
        if (H != null) {
            if (f0Var.f3295d.containsKey(H)) {
                f0Var.f3295d.put(H, null);
            } else {
                f0Var.f3295d.put(H, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (f0Var.f3294c.k(itemIdAtPosition) >= 0) {
                    View h2 = f0Var.f3294c.h(itemIdAtPosition);
                    if (h2 != null) {
                        c.h.k.v.s0(h2, false);
                        f0Var.f3294c.n(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                c.h.k.v.s0(view, true);
                f0Var.f3294c.n(itemIdAtPosition, view);
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i2) {
        int i3 = iArr[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            if (iArr[i4] == i3) {
                return true;
            }
        }
        return false;
    }

    private void captureHierarchy(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.mTargetExcludes;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.mTargetTypeExcludes.get(i2).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    e0 e0Var = new e0(view);
                    if (z) {
                        captureStartValues(e0Var);
                    } else {
                        captureEndValues(e0Var);
                    }
                    e0Var.f3290c.add(this);
                    capturePropagationValues(e0Var);
                    if (z) {
                        addViewValues(this.mStartValues, view, e0Var);
                    } else {
                        addViewValues(this.mEndValues, view, e0Var);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    if (this.mTargetTypeChildExcludes.get(i3).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                captureHierarchy(viewGroup.getChildAt(i4), z);
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i2, boolean z) {
        if (i2 > 0) {
            if (z) {
                return e.a(arrayList, Integer.valueOf(i2));
            }
            return e.b(arrayList, Integer.valueOf(i2));
        }
        return arrayList;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        if (t != null) {
            if (z) {
                return e.a(arrayList, t);
            }
            return e.b(arrayList, t);
        }
        return arrayList;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        if (cls != null) {
            if (z) {
                return e.a(arrayList, cls);
            }
            return e.b(arrayList, cls);
        }
        return arrayList;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view != null) {
            if (z) {
                return e.a(arrayList, view);
            }
            return e.b(arrayList, view);
        }
        return arrayList;
    }

    private static c.e.a<Animator, d> getRunningAnimators() {
        c.e.a<Animator, d> aVar = sRunningAnimators.get();
        if (aVar == null) {
            c.e.a<Animator, d> aVar2 = new c.e.a<>();
            sRunningAnimators.set(aVar2);
            return aVar2;
        }
        return aVar;
    }

    private static boolean isValidMatch(int i2) {
        return i2 >= 1 && i2 <= 4;
    }

    private static boolean isValueChanged(e0 e0Var, e0 e0Var2, String str) {
        Object obj = e0Var.a.get(str);
        Object obj2 = e0Var2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void matchIds(c.e.a<View, e0> aVar, c.e.a<View, e0> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && isValidTarget(view)) {
                e0 e0Var = aVar.get(valueAt);
                e0 e0Var2 = aVar2.get(view);
                if (e0Var != null && e0Var2 != null) {
                    this.mStartValuesList.add(e0Var);
                    this.mEndValuesList.add(e0Var2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void matchInstances(c.e.a<View, e0> aVar, c.e.a<View, e0> aVar2) {
        e0 remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View keyAt = aVar.keyAt(size);
            if (keyAt != null && isValidTarget(keyAt) && (remove = aVar2.remove(keyAt)) != null && isValidTarget(remove.f3289b)) {
                this.mStartValuesList.add(aVar.removeAt(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(c.e.a<View, e0> aVar, c.e.a<View, e0> aVar2, c.e.d<View> dVar, c.e.d<View> dVar2) {
        View h2;
        int q = dVar.q();
        for (int i2 = 0; i2 < q; i2++) {
            View r = dVar.r(i2);
            if (r != null && isValidTarget(r) && (h2 = dVar2.h(dVar.l(i2))) != null && isValidTarget(h2)) {
                e0 e0Var = aVar.get(r);
                e0 e0Var2 = aVar2.get(h2);
                if (e0Var != null && e0Var2 != null) {
                    this.mStartValuesList.add(e0Var);
                    this.mEndValuesList.add(e0Var2);
                    aVar.remove(r);
                    aVar2.remove(h2);
                }
            }
        }
    }

    private void matchNames(c.e.a<View, e0> aVar, c.e.a<View, e0> aVar2, c.e.a<String, View> aVar3, c.e.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = aVar3.valueAt(i2);
            if (valueAt != null && isValidTarget(valueAt) && (view = aVar4.get(aVar3.keyAt(i2))) != null && isValidTarget(view)) {
                e0 e0Var = aVar.get(valueAt);
                e0 e0Var2 = aVar2.get(view);
                if (e0Var != null && e0Var2 != null) {
                    this.mStartValuesList.add(e0Var);
                    this.mEndValuesList.add(e0Var2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void matchStartAndEnd(f0 f0Var, f0 f0Var2) {
        c.e.a<View, e0> aVar = new c.e.a<>(f0Var.a);
        c.e.a<View, e0> aVar2 = new c.e.a<>(f0Var2.a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 == 1) {
                    matchInstances(aVar, aVar2);
                } else if (i3 == 2) {
                    matchNames(aVar, aVar2, f0Var.f3295d, f0Var2.f3295d);
                } else if (i3 == 3) {
                    matchIds(aVar, aVar2, f0Var.f3293b, f0Var2.f3293b);
                } else if (i3 == 4) {
                    matchItemIds(aVar, aVar2, f0Var.f3294c, f0Var2.f3294c);
                }
                i2++;
            } else {
                addUnmatched(aVar, aVar2);
                return;
            }
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (MATCH_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i2] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i2] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i2] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i2] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                i2--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i2++;
        }
        return iArr;
    }

    private void runAnimator(Animator animator, c.e.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            animate(animator);
        }
    }

    public y addListener(g gVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(gVar);
        return this;
    }

    public y addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    protected void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new c());
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<g> arrayList = this.mListeners;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((g) arrayList2.get(i2)).d(this);
        }
    }

    public abstract void captureEndValues(e0 e0Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void capturePropagationValues(e0 e0Var) {
        String[] b2;
        if (this.mPropagation == null || e0Var.a.isEmpty() || (b2 = this.mPropagation.b()) == null) {
            return;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= b2.length) {
                z = true;
                break;
            } else if (!e0Var.a.containsKey(b2[i2])) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            return;
        }
        this.mPropagation.a(e0Var);
    }

    public abstract void captureStartValues(e0 e0Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void captureValues(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        c.e.a<String, String> aVar;
        clearValues(z);
        if ((this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) || (((arrayList = this.mTargetNames) != null && !arrayList.isEmpty()) || ((arrayList2 = this.mTargetTypes) != null && !arrayList2.isEmpty()))) {
            captureHierarchy(viewGroup, z);
        } else {
            for (int i2 = 0; i2 < this.mTargetIds.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i2).intValue());
                if (findViewById != null) {
                    e0 e0Var = new e0(findViewById);
                    if (z) {
                        captureStartValues(e0Var);
                    } else {
                        captureEndValues(e0Var);
                    }
                    e0Var.f3290c.add(this);
                    capturePropagationValues(e0Var);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, e0Var);
                    } else {
                        addViewValues(this.mEndValues, findViewById, e0Var);
                    }
                }
            }
            for (int i3 = 0; i3 < this.mTargets.size(); i3++) {
                View view = this.mTargets.get(i3);
                e0 e0Var2 = new e0(view);
                if (z) {
                    captureStartValues(e0Var2);
                } else {
                    captureEndValues(e0Var2);
                }
                e0Var2.f3290c.add(this);
                capturePropagationValues(e0Var2);
                if (z) {
                    addViewValues(this.mStartValues, view, e0Var2);
                } else {
                    addViewValues(this.mEndValues, view, e0Var2);
                }
            }
        }
        if (z || (aVar = this.mNameOverrides) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList3.add(this.mStartValues.f3295d.remove(this.mNameOverrides.keyAt(i4)));
        }
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) arrayList3.get(i5);
            if (view2 != null) {
                this.mStartValues.f3295d.put(this.mNameOverrides.valueAt(i5), view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.a.clear();
            this.mStartValues.f3293b.clear();
            this.mStartValues.f3294c.c();
            return;
        }
        this.mEndValues.a.clear();
        this.mEndValues.f3293b.clear();
        this.mEndValues.f3294c.c();
    }

    public Animator createAnimator(ViewGroup viewGroup, e0 e0Var, e0 e0Var2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, f0 f0Var, f0 f0Var2, ArrayList<e0> arrayList, ArrayList<e0> arrayList2) {
        Animator createAnimator;
        int i2;
        int i3;
        View view;
        Animator animator;
        e0 e0Var;
        Animator animator2;
        e0 e0Var2;
        c.e.a<Animator, d> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            e0 e0Var3 = arrayList.get(i4);
            e0 e0Var4 = arrayList2.get(i4);
            if (e0Var3 != null && !e0Var3.f3290c.contains(this)) {
                e0Var3 = null;
            }
            if (e0Var4 != null && !e0Var4.f3290c.contains(this)) {
                e0Var4 = null;
            }
            if (e0Var3 != null || e0Var4 != null) {
                if ((e0Var3 == null || e0Var4 == null || isTransitionRequired(e0Var3, e0Var4)) && (createAnimator = createAnimator(viewGroup, e0Var3, e0Var4)) != null) {
                    if (e0Var4 != null) {
                        view = e0Var4.f3289b;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            e0Var2 = new e0(view);
                            i2 = size;
                            e0 e0Var5 = f0Var2.a.get(view);
                            if (e0Var5 != null) {
                                int i5 = 0;
                                while (i5 < transitionProperties.length) {
                                    e0Var2.a.put(transitionProperties[i5], e0Var5.a.get(transitionProperties[i5]));
                                    i5++;
                                    i4 = i4;
                                    e0Var5 = e0Var5;
                                }
                            }
                            i3 = i4;
                            int size2 = runningAnimators.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    animator2 = createAnimator;
                                    break;
                                }
                                d dVar = runningAnimators.get(runningAnimators.keyAt(i6));
                                if (dVar.f3402c != null && dVar.a == view && dVar.f3401b.equals(getName()) && dVar.f3402c.equals(e0Var2)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i2 = size;
                            i3 = i4;
                            animator2 = createAnimator;
                            e0Var2 = null;
                        }
                        animator = animator2;
                        e0Var = e0Var2;
                    } else {
                        i2 = size;
                        i3 = i4;
                        view = e0Var3.f3289b;
                        animator = createAnimator;
                        e0Var = null;
                    }
                    if (animator != null) {
                        b0 b0Var = this.mPropagation;
                        if (b0Var != null) {
                            long c2 = b0Var.c(viewGroup, this, e0Var3, e0Var4);
                            sparseIntArray.put(this.mAnimators.size(), (int) c2);
                            j2 = Math.min(c2, j2);
                        }
                        runningAnimators.put(animator, new d(view, getName(), this, p0.d(viewGroup), e0Var));
                        this.mAnimators.add(animator);
                        j2 = j2;
                    }
                    i4 = i3 + 1;
                    size = i2;
                }
            }
            i2 = size;
            i3 = i4;
            i4 = i3 + 1;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator3 = this.mAnimators.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay((sparseIntArray.valueAt(i7) - j2) + animator3.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void end() {
        int i2 = this.mNumInstances - 1;
        this.mNumInstances = i2;
        if (i2 == 0) {
            ArrayList<g> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((g) arrayList2.get(i3)).c(this);
                }
            }
            for (int i4 = 0; i4 < this.mStartValues.f3294c.q(); i4++) {
                View r = this.mStartValues.f3294c.r(i4);
                if (r != null) {
                    c.h.k.v.s0(r, false);
                }
            }
            for (int i5 = 0; i5 < this.mEndValues.f3294c.q(); i5++) {
                View r2 = this.mEndValues.f3294c.r(i5);
                if (r2 != null) {
                    c.h.k.v.s0(r2, false);
                }
            }
            this.mEnded = true;
        }
    }

    public y excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public y excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void forceToEnd(ViewGroup viewGroup) {
        c.e.a<Animator, d> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        a1 d2 = p0.d(viewGroup);
        c.e.a aVar = new c.e.a(runningAnimators);
        runningAnimators.clear();
        for (int i2 = size - 1; i2 >= 0; i2--) {
            d dVar = (d) aVar.valueAt(i2);
            if (dVar.a != null && d2 != null && d2.equals(dVar.f3403d)) {
                ((Animator) aVar.keyAt(i2)).end();
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        f fVar = this.mEpicenterCallback;
        if (fVar == null) {
            return null;
        }
        return fVar.a(this);
    }

    public f getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0 getMatchedTransitionValues(View view, boolean z) {
        c0 c0Var = this.mParent;
        if (c0Var != null) {
            return c0Var.getMatchedTransitionValues(view, z);
        }
        ArrayList<e0> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            e0 e0Var = arrayList.get(i3);
            if (e0Var == null) {
                return null;
            }
            if (e0Var.f3289b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            return (z ? this.mEndValuesList : this.mStartValuesList).get(i2);
        }
        return null;
    }

    public String getName() {
        return this.mName;
    }

    public p getPathMotion() {
        return this.mPathMotion;
    }

    public b0 getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public e0 getTransitionValues(View view, boolean z) {
        c0 c0Var = this.mParent;
        if (c0Var != null) {
            return c0Var.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).a.get(view);
    }

    public boolean isTransitionRequired(e0 e0Var, e0 e0Var2) {
        if (e0Var == null || e0Var2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            for (String str : transitionProperties) {
                if (!isValueChanged(e0Var, e0Var2, str)) {
                }
            }
            return false;
        }
        for (String str2 : e0Var.a.keySet()) {
            if (isValueChanged(e0Var, e0Var2, str2)) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 == null || !arrayList3.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList4 = this.mTargetExcludes;
            if (arrayList4 == null || !arrayList4.contains(view)) {
                ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.mTargetTypeExcludes.get(i2).isInstance(view)) {
                            return false;
                        }
                    }
                }
                if (this.mTargetNameExcludes == null || c.h.k.v.H(view) == null || !this.mTargetNameExcludes.contains(c.h.k.v.H(view))) {
                    if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
                        return true;
                    }
                    ArrayList<String> arrayList6 = this.mTargetNames;
                    if (arrayList6 == null || !arrayList6.contains(c.h.k.v.H(view))) {
                        if (this.mTargetTypes != null) {
                            for (int i3 = 0; i3 < this.mTargetTypes.size(); i3++) {
                                if (this.mTargetTypes.get(i3).isInstance(view)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void pause(View view) {
        if (this.mEnded) {
            return;
        }
        c.e.a<Animator, d> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        a1 d2 = p0.d(view);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            d valueAt = runningAnimators.valueAt(i2);
            if (valueAt.a != null && d2.equals(valueAt.f3403d)) {
                c.s.a.b(runningAnimators.keyAt(i2));
            }
        }
        ArrayList<g> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((g) arrayList2.get(i3)).b(this);
            }
        }
        this.mPaused = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void playTransition(ViewGroup viewGroup) {
        d dVar;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        c.e.a<Animator, d> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        a1 d2 = p0.d(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator keyAt = runningAnimators.keyAt(i2);
            if (keyAt != null && (dVar = runningAnimators.get(keyAt)) != null && dVar.a != null && d2.equals(dVar.f3403d)) {
                e0 e0Var = dVar.f3402c;
                View view = dVar.a;
                e0 transitionValues = getTransitionValues(view, true);
                e0 matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.a.get(view);
                }
                if (!(transitionValues == null && matchedTransitionValues == null) && dVar.f3404e.isTransitionRequired(e0Var, matchedTransitionValues)) {
                    if (!keyAt.isRunning() && !keyAt.isStarted()) {
                        runningAnimators.remove(keyAt);
                    } else {
                        keyAt.cancel();
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public y removeListener(g gVar) {
        ArrayList<g> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(gVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public y removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                c.e.a<Animator, d> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                a1 d2 = p0.d(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    d valueAt = runningAnimators.valueAt(i2);
                    if (valueAt.a != null && d2.equals(valueAt.f3403d)) {
                        c.s.a.c(runningAnimators.keyAt(i2));
                    }
                }
                ArrayList<g> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((g) arrayList2.get(i3)).e(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runAnimators() {
        start();
        c.e.a<Animator, d> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public y setDuration(long j2) {
        this.mDuration = j2;
        return this;
    }

    public void setEpicenterCallback(f fVar) {
        this.mEpicenterCallback = fVar;
    }

    public y setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (isValidMatch(iArr[i2])) {
                    if (alreadyContains(iArr, i2)) {
                        throw new IllegalArgumentException("matches contains a duplicate value");
                    }
                } else {
                    throw new IllegalArgumentException("matches contains invalid value");
                }
            }
            this.mMatchOrder = (int[]) iArr.clone();
            return;
        }
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
    }

    public void setPathMotion(p pVar) {
        if (pVar == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pVar;
        }
    }

    public void setPropagation(b0 b0Var) {
        this.mPropagation = b0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public y setStartDelay(long j2) {
        this.mStartDelay = j2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<g> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((g) arrayList2.get(i2)).a(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    public y addTarget(int i2) {
        if (i2 != 0) {
            this.mTargetIds.add(Integer.valueOf(i2));
        }
        return this;
    }

    @Override // 
    /* renamed from: clone */
    public y mo0clone() {
        try {
            y yVar = (y) super.clone();
            yVar.mAnimators = new ArrayList<>();
            yVar.mStartValues = new f0();
            yVar.mEndValues = new f0();
            yVar.mStartValuesList = null;
            yVar.mEndValuesList = null;
            return yVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public y excludeChildren(int i2, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i2, z);
        return this;
    }

    public y excludeTarget(int i2, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i2, z);
        return this;
    }

    public y removeTarget(int i2) {
        if (i2 != 0) {
            this.mTargetIds.remove(Integer.valueOf(i2));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            String str3 = str2 + "tgts(";
            if (this.mTargetIds.size() > 0) {
                for (int i2 = 0; i2 < this.mTargetIds.size(); i2++) {
                    if (i2 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.mTargetIds.get(i2);
                }
            }
            if (this.mTargets.size() > 0) {
                for (int i3 = 0; i3 < this.mTargets.size(); i3++) {
                    if (i3 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.mTargets.get(i3);
                }
            }
            return str3 + ")";
        }
        return str2;
    }

    public y addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public y excludeChildren(Class<?> cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    public y excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    public y removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public y excludeTarget(Class<?> cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public y removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public y addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public y(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x.f3391c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long g2 = androidx.core.content.d.h.g(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (g2 >= 0) {
            setDuration(g2);
        }
        long g3 = androidx.core.content.d.h.g(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (g3 > 0) {
            setStartDelay(g3);
        }
        int h2 = androidx.core.content.d.h.h(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (h2 > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, h2));
        }
        String i2 = androidx.core.content.d.h.i(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (i2 != null) {
            setMatchOrder(parseMatchOrder(i2));
        }
        obtainStyledAttributes.recycle();
    }
}