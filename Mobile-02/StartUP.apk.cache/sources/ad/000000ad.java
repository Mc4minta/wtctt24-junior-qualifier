package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* compiled from: MenuPresenter.java */
/* loaded from: classes.dex */
public interface m {

    /* compiled from: MenuPresenter.java */
    /* loaded from: classes.dex */
    public interface a {
        void b(g gVar, boolean z);

        boolean c(g gVar);
    }

    void b(g gVar, boolean z);

    void c(boolean z);

    boolean d();

    boolean e(g gVar, i iVar);

    boolean f(g gVar, i iVar);

    void g(a aVar);

    int getId();

    void i(Context context, g gVar);

    void j(Parcelable parcelable);

    boolean l(r rVar);

    Parcelable m();
}