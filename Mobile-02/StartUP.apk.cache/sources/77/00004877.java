package e.g.a.f.l;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* compiled from: MotionTiming.java */
/* loaded from: classes2.dex */
public class i {
    private long a;

    /* renamed from: b  reason: collision with root package name */
    private long f13299b;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f13300c;

    /* renamed from: d  reason: collision with root package name */
    private int f13301d;

    /* renamed from: e  reason: collision with root package name */
    private int f13302e;

    public i(long j2, long j3) {
        this.a = 0L;
        this.f13299b = 300L;
        this.f13300c = null;
        this.f13301d = 0;
        this.f13302e = 1;
        this.a = j2;
        this.f13299b = j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f13301d = valueAnimator.getRepeatCount();
        iVar.f13302e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return a.f13293c;
            }
            return interpolator instanceof DecelerateInterpolator ? a.f13294d : interpolator;
        }
        return a.f13292b;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.a;
    }

    public long d() {
        return this.f13299b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f13300c;
        return timeInterpolator != null ? timeInterpolator : a.f13292b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f13301d;
    }

    public int h() {
        return this.f13302e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j2, long j3, TimeInterpolator timeInterpolator) {
        this.a = 0L;
        this.f13299b = 300L;
        this.f13300c = null;
        this.f13301d = 0;
        this.f13302e = 1;
        this.a = j2;
        this.f13299b = j3;
        this.f13300c = timeInterpolator;
    }
}