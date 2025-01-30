package e.j.n;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.cloudbackup.prompts.CloudBackupPrompt;
import com.coinbase.wallet.user.repositories.UserRepository;

/* compiled from: DisplayCoinAddressViewModel.kt */
/* loaded from: classes2.dex */
public final class j2 extends androidx.lifecycle.b0 {
    private final UserRepository a;

    /* renamed from: b */
    private final FeatureFlagsRepository f13879b;

    /* renamed from: c */
    private final CloudBackupPrompt f13880c;

    public j2(UserRepository userRepository, FeatureFlagsRepository featureFlagsRepository, CloudBackupPrompt cloudBackupPrompt) {
        kotlin.jvm.internal.m.g(userRepository, "userRepository");
        kotlin.jvm.internal.m.g(featureFlagsRepository, "featureFlagsRepository");
        kotlin.jvm.internal.m.g(cloudBackupPrompt, "cloudBackupPrompt");
        this.a = userRepository;
        this.f13879b = featureFlagsRepository;
        this.f13880c = cloudBackupPrompt;
    }

    public static /* synthetic */ kotlin.o c(kotlin.o oVar) {
        return e(oVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x005b, code lost:
        if (r5.booleanValue() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.o e(kotlin.o r5) {
        /*
            java.lang.String r0 = "$dstr$user$isFeatureEnabled"
            kotlin.jvm.internal.m.g(r5, r0)
            java.lang.Object r0 = r5.a()
            com.coinbase.wallet.core.util.Optional r0 = (com.coinbase.wallet.core.util.Optional) r0
            java.lang.Object r5 = r5.b()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            java.lang.Object r1 = r0.toNullable()
            com.coinbase.wallet.user.models.User r1 = (com.coinbase.wallet.user.models.User) r1
            if (r1 != 0) goto L1b
            r1 = 0
            goto L1f
        L1b:
            java.lang.String r1 = r1.getUsername()
        L1f:
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L2c
            int r4 = r1.length()
            if (r4 != 0) goto L2a
            goto L2c
        L2a:
            r4 = r3
            goto L2d
        L2c:
            r4 = r2
        L2d:
            if (r4 == 0) goto L3c
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            com.coinbase.wallet.core.extensions.Strings r0 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r0 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r0)
            kotlin.o r5 = kotlin.u.a(r5, r0)
            return r5
        L3c:
            java.lang.Object r0 = r0.toNullable()
            com.coinbase.wallet.user.models.User r0 = (com.coinbase.wallet.user.models.User) r0
            if (r0 != 0) goto L46
            r0 = r3
            goto L50
        L46:
            java.lang.Boolean r0 = r0.isPublic()
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.m.c(r0, r4)
        L50:
            if (r0 != 0) goto L5e
            java.lang.String r0 = "isFeatureEnabled"
            kotlin.jvm.internal.m.f(r5, r0)
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L5e
            goto L5f
        L5e:
            r2 = r3
        L5f:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
            kotlin.o r5 = kotlin.u.a(r5, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.n.j2.e(kotlin.o):kotlin.o");
    }

    public final h.c.b0<Boolean> a(Bundle args) {
        kotlin.jvm.internal.m.g(args, "args");
        return CloudBackupPrompt.backupIfNeeded$default(this.f13880c, args, null, null, 6, null);
    }

    public final h.c.b0<Bitmap> b(String url) {
        kotlin.jvm.internal.m.g(url, "url");
        return e.j.l.h.a.a(url);
    }

    public final h.c.b0<kotlin.o<Boolean, String>> d() {
        h.c.b0<kotlin.o<Boolean, String>> map = h.c.t0.f.a(Observable_CoreKt.takeSingle(this.a.getActiveUserObservable()), FeatureFlagsRepository.value$default(this.f13879b, FeatureFlag.SOCIAL_SEND, false, 0L, 4, null)).map(new h.c.m0.n() { // from class: e.j.n.d0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return j2.c((kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "userRepository.activeUserObservable\n        .takeSingle()\n        .zipWith(featureFlagsRepository.value(FeatureFlag.SOCIAL_SEND, false))\n        .map { (user, isFeatureEnabled) ->\n            val username = user.toNullable()?.username\n\n            if (username.isNullOrEmpty()) return@map false to Strings.empty\n\n            val isSocialSendEnabled = user.toNullable()?.isPublic != false && isFeatureEnabled\n            isSocialSendEnabled to username\n        }");
        return map;
    }
}