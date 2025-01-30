package androidx.navigation.fragment;

import android.view.View;
import androidx.navigation.fragment.b;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: FragmentNavigatorExtras.kt */
/* loaded from: classes.dex */
public final class c {
    public static final b.C0036b a(o<? extends View, String>... sharedElements) {
        m.h(sharedElements, "sharedElements");
        b.C0036b.a aVar = new b.C0036b.a();
        for (o<? extends View, String> oVar : sharedElements) {
            aVar.a(oVar.a(), oVar.b());
        }
        b.C0036b b2 = aVar.b();
        m.d(b2, "FragmentNavigator.Extras…      }\n        }.build()");
        return b2;
    }
}