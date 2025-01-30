package c.s;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import c.s.y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet.java */
/* loaded from: classes.dex */
public class c0 extends y {

    /* renamed from: c  reason: collision with root package name */
    int f3228c;
    private ArrayList<y> a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f3227b = true;

    /* renamed from: d  reason: collision with root package name */
    boolean f3229d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f3230e = 0;

    /* compiled from: TransitionSet.java */
    /* loaded from: classes.dex */
    class a extends z {
        final /* synthetic */ y a;

        a(y yVar) {
            this.a = yVar;
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            this.a.runAnimators();
            yVar.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TransitionSet.java */
    /* loaded from: classes.dex */
    public static class b extends z {
        c0 a;

        b(c0 c0Var) {
            this.a = c0Var;
        }

        @Override // c.s.z, c.s.y.g
        public void a(y yVar) {
            c0 c0Var = this.a;
            if (c0Var.f3229d) {
                return;
            }
            c0Var.start();
            this.a.f3229d = true;
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            c0 c0Var = this.a;
            int i2 = c0Var.f3228c - 1;
            c0Var.f3228c = i2;
            if (i2 == 0) {
                c0Var.f3229d = false;
                c0Var.end();
            }
            yVar.removeListener(this);
        }
    }

    private void i(y yVar) {
        this.a.add(yVar);
        yVar.mParent = this;
    }

    private void x() {
        b bVar = new b(this);
        Iterator<y> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().addListener(bVar);
        }
        this.f3228c = this.a.size();
    }

    @Override // c.s.y
    /* renamed from: b */
    public c0 addListener(y.g gVar) {
        return (c0) super.addListener(gVar);
    }

    @Override // c.s.y
    /* renamed from: c */
    public c0 addTarget(int i2) {
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            this.a.get(i3).addTarget(i2);
        }
        return (c0) super.addTarget(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.s.y
    public void cancel() {
        super.cancel();
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).cancel();
        }
    }

    @Override // c.s.y
    public void captureEndValues(e0 e0Var) {
        if (isValidTarget(e0Var.f3289b)) {
            Iterator<y> it = this.a.iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (next.isValidTarget(e0Var.f3289b)) {
                    next.captureEndValues(e0Var);
                    e0Var.f3290c.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.s.y
    public void capturePropagationValues(e0 e0Var) {
        super.capturePropagationValues(e0Var);
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).capturePropagationValues(e0Var);
        }
    }

    @Override // c.s.y
    public void captureStartValues(e0 e0Var) {
        if (isValidTarget(e0Var.f3289b)) {
            Iterator<y> it = this.a.iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (next.isValidTarget(e0Var.f3289b)) {
                    next.captureStartValues(e0Var);
                    e0Var.f3290c.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.s.y
    public void createAnimators(ViewGroup viewGroup, f0 f0Var, f0 f0Var2, ArrayList<e0> arrayList, ArrayList<e0> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            y yVar = this.a.get(i2);
            if (startDelay > 0 && (this.f3227b || i2 == 0)) {
                long startDelay2 = yVar.getStartDelay();
                if (startDelay2 > 0) {
                    yVar.setStartDelay(startDelay2 + startDelay);
                } else {
                    yVar.setStartDelay(startDelay);
                }
            }
            yVar.createAnimators(viewGroup, f0Var, f0Var2, arrayList, arrayList2);
        }
    }

    @Override // c.s.y
    /* renamed from: d */
    public c0 addTarget(View view) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).addTarget(view);
        }
        return (c0) super.addTarget(view);
    }

    @Override // c.s.y
    /* renamed from: e */
    public c0 addTarget(Class<?> cls) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).addTarget(cls);
        }
        return (c0) super.addTarget(cls);
    }

    @Override // c.s.y
    public y excludeTarget(View view, boolean z) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    @Override // c.s.y
    /* renamed from: f */
    public c0 addTarget(String str) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).addTarget(str);
        }
        return (c0) super.addTarget(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.s.y
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).forceToEnd(viewGroup);
        }
    }

    public c0 h(y yVar) {
        i(yVar);
        long j2 = this.mDuration;
        if (j2 >= 0) {
            yVar.setDuration(j2);
        }
        if ((this.f3230e & 1) != 0) {
            yVar.setInterpolator(getInterpolator());
        }
        if ((this.f3230e & 2) != 0) {
            yVar.setPropagation(getPropagation());
        }
        if ((this.f3230e & 4) != 0) {
            yVar.setPathMotion(getPathMotion());
        }
        if ((this.f3230e & 8) != 0) {
            yVar.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    public y k(int i2) {
        if (i2 < 0 || i2 >= this.a.size()) {
            return null;
        }
        return this.a.get(i2);
    }

    public int l() {
        return this.a.size();
    }

    @Override // c.s.y
    /* renamed from: n */
    public c0 removeListener(y.g gVar) {
        return (c0) super.removeListener(gVar);
    }

    @Override // c.s.y
    /* renamed from: o */
    public c0 removeTarget(int i2) {
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            this.a.get(i3).removeTarget(i2);
        }
        return (c0) super.removeTarget(i2);
    }

    @Override // c.s.y
    /* renamed from: p */
    public c0 removeTarget(View view) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).removeTarget(view);
        }
        return (c0) super.removeTarget(view);
    }

    @Override // c.s.y
    public void pause(View view) {
        super.pause(view);
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).pause(view);
        }
    }

    @Override // c.s.y
    /* renamed from: q */
    public c0 removeTarget(Class<?> cls) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).removeTarget(cls);
        }
        return (c0) super.removeTarget(cls);
    }

    @Override // c.s.y
    /* renamed from: r */
    public c0 removeTarget(String str) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).removeTarget(str);
        }
        return (c0) super.removeTarget(str);
    }

    @Override // c.s.y
    public void resume(View view) {
        super.resume(view);
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).resume(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.s.y
    public void runAnimators() {
        if (this.a.isEmpty()) {
            start();
            end();
            return;
        }
        x();
        if (!this.f3227b) {
            for (int i2 = 1; i2 < this.a.size(); i2++) {
                this.a.get(i2 - 1).addListener(new a(this.a.get(i2)));
            }
            y yVar = this.a.get(0);
            if (yVar != null) {
                yVar.runAnimators();
                return;
            }
            return;
        }
        Iterator<y> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().runAnimators();
        }
    }

    @Override // c.s.y
    /* renamed from: s */
    public c0 setDuration(long j2) {
        ArrayList<y> arrayList;
        super.setDuration(j2);
        if (this.mDuration >= 0 && (arrayList = this.a) != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.a.get(i2).setDuration(j2);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.s.y
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).setCanRemoveViews(z);
        }
    }

    @Override // c.s.y
    public void setEpicenterCallback(y.f fVar) {
        super.setEpicenterCallback(fVar);
        this.f3230e |= 8;
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).setEpicenterCallback(fVar);
        }
    }

    @Override // c.s.y
    public void setPathMotion(p pVar) {
        super.setPathMotion(pVar);
        this.f3230e |= 4;
        if (this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                this.a.get(i2).setPathMotion(pVar);
            }
        }
    }

    @Override // c.s.y
    public void setPropagation(b0 b0Var) {
        super.setPropagation(b0Var);
        this.f3230e |= 2;
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).setPropagation(b0Var);
        }
    }

    @Override // c.s.y
    /* renamed from: t */
    public c0 setInterpolator(TimeInterpolator timeInterpolator) {
        this.f3230e |= 1;
        ArrayList<y> arrayList = this.a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.a.get(i2).setInterpolator(timeInterpolator);
            }
        }
        return (c0) super.setInterpolator(timeInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.s.y
    public String toString(String str) {
        String yVar = super.toString(str);
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(yVar);
            sb.append("\n");
            sb.append(this.a.get(i2).toString(str + "  "));
            yVar = sb.toString();
        }
        return yVar;
    }

    public c0 u(int i2) {
        if (i2 == 0) {
            this.f3227b = true;
        } else if (i2 == 1) {
            this.f3227b = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.s.y
    /* renamed from: v */
    public c0 setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // c.s.y
    /* renamed from: w */
    public c0 setStartDelay(long j2) {
        return (c0) super.setStartDelay(j2);
    }

    @Override // c.s.y
    /* renamed from: clone */
    public y mo0clone() {
        c0 c0Var = (c0) super.mo0clone();
        c0Var.a = new ArrayList<>();
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            c0Var.i(this.a.get(i2).mo0clone());
        }
        return c0Var;
    }

    @Override // c.s.y
    public y excludeTarget(String str, boolean z) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    @Override // c.s.y
    public y excludeTarget(int i2, boolean z) {
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            this.a.get(i3).excludeTarget(i2, z);
        }
        return super.excludeTarget(i2, z);
    }

    @Override // c.s.y
    public y excludeTarget(Class<?> cls, boolean z) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }
}