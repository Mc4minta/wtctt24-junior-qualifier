package e.a.a.u.b;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import e.a.a.w.k.h;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class l implements m, j {

    /* renamed from: d  reason: collision with root package name */
    private final String f11648d;

    /* renamed from: f  reason: collision with root package name */
    private final e.a.a.w.k.h f11650f;
    private final Path a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f11646b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f11647c = new Path();

    /* renamed from: e  reason: collision with root package name */
    private final List<m> f11649e = new ArrayList();

    /* compiled from: MergePathsContent.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.a.values().length];
            a = iArr;
            try {
                iArr[h.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[h.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[h.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(e.a.a.w.k.h hVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f11648d = hVar.c();
            this.f11650f = hVar;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    private void a() {
        for (int i2 = 0; i2 < this.f11649e.size(); i2++) {
            this.f11647c.addPath(this.f11649e.get(i2).getPath());
        }
    }

    @TargetApi(19)
    private void c(Path.Op op) {
        this.f11646b.reset();
        this.a.reset();
        for (int size = this.f11649e.size() - 1; size >= 1; size--) {
            m mVar = this.f11649e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> i2 = dVar.i();
                for (int size2 = i2.size() - 1; size2 >= 0; size2--) {
                    Path path = i2.get(size2).getPath();
                    path.transform(dVar.j());
                    this.f11646b.addPath(path);
                }
            } else {
                this.f11646b.addPath(mVar.getPath());
            }
        }
        m mVar2 = this.f11649e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> i3 = dVar2.i();
            for (int i4 = 0; i4 < i3.size(); i4++) {
                Path path2 = i3.get(i4).getPath();
                path2.transform(dVar2.j());
                this.a.addPath(path2);
            }
        } else {
            this.a.set(mVar2.getPath());
        }
        this.f11647c.op(this.a, this.f11646b, op);
    }

    @Override // e.a.a.u.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < this.f11649e.size(); i2++) {
            this.f11649e.get(i2).b(list, list2);
        }
    }

    @Override // e.a.a.u.b.j
    public void e(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c previous = listIterator.previous();
            if (previous instanceof m) {
                this.f11649e.add((m) previous);
                listIterator.remove();
            }
        }
    }

    @Override // e.a.a.u.b.m
    public Path getPath() {
        this.f11647c.reset();
        if (this.f11650f.d()) {
            return this.f11647c;
        }
        int i2 = a.a[this.f11650f.b().ordinal()];
        if (i2 == 1) {
            a();
        } else if (i2 == 2) {
            c(Path.Op.UNION);
        } else if (i2 == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i2 == 4) {
            c(Path.Op.INTERSECT);
        } else if (i2 == 5) {
            c(Path.Op.XOR);
        }
        return this.f11647c;
    }
}