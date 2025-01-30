package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import kotlin.jvm.internal.m;

/* compiled from: Fragment.kt */
/* loaded from: classes.dex */
public final class a {
    public static final NavController a(Fragment findNavController) {
        m.h(findNavController, "$this$findNavController");
        NavController findNavController2 = d.findNavController(findNavController);
        m.d(findNavController2, "NavHostFragment.findNavController(this)");
        return findNavController2;
    }
}