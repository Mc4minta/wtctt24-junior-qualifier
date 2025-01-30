package com.toshi.view.fragment.legal;

import android.content.Context;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: LegalViewFragment.kt */
/* loaded from: classes2.dex */
public enum b {
    PRIVACY_POLICY,
    TERMS_OF_SERVICE;

    /* compiled from: LegalViewFragment.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            iArr[b.PRIVACY_POLICY.ordinal()] = 1;
            iArr[b.TERMS_OF_SERVICE.ordinal()] = 2;
            a = iArr;
        }
    }

    public final String n(Context context) {
        m.g(context, "context");
        int i2 = a.a[ordinal()];
        if (i2 == 1) {
            String string = context.getString(R.string.privacy_policy_url);
            m.f(string, "context.getString(R.string.privacy_policy_url)");
            return string;
        } else if (i2 == 2) {
            String string2 = context.getString(R.string.terms_of_service_url);
            m.f(string2, "context.getString(R.string.terms_of_service_url)");
            return string2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}