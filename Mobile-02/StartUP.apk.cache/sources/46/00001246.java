package com.coinbase.wallet.application.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.x;

/* compiled from: ProcessPhoenix.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/application/util/ProcessPhoenix;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/x;", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ProcessPhoenix extends Activity {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_RESTART_INTENTS = "phoenix_restart_intents";

    /* compiled from: ProcessPhoenix.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0007\"\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/application/util/ProcessPhoenix$Companion;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "getRestartIntent", "(Landroid/content/Context;)Landroid/content/Intent;", "", "nextIntents", "Lkotlin/x;", "triggerRebirth", "(Landroid/content/Context;[Landroid/content/Intent;)V", "", "isPhoenixProcess", "(Landroid/content/Context;)Z", "", "KEY_RESTART_INTENTS", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Intent getRestartIntent(Context context) {
            String packageName = context.getPackageName();
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(packageName);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268468224);
                return launchIntentForPackage;
            }
            throw new IllegalStateException("Unable to determine default activity for " + ((Object) packageName) + ". Does an activity specify the DEFAULT category in its intent filter?");
        }

        public final boolean isPhoenixProcess(Context context) {
            boolean z;
            m.g(context, "context");
            int myPid = Process.myPid();
            Object systemService = context.getSystemService("activity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        String str = runningAppProcessInfo.processName;
                        m.f(str, "processInfo.processName");
                        z = x.z(str, ":phoenix", false, 2, null);
                        if (z) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public final void triggerRebirth(Context context, Intent... nextIntents) {
            List j2;
            m.g(context, "context");
            m.g(nextIntents, "nextIntents");
            if (!(!(nextIntents.length == 0))) {
                nextIntents = new Intent[]{getRestartIntent(context)};
            }
            Intent intent = new Intent(context, ProcessPhoenix.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            j2 = r.j(Arrays.copyOf(nextIntents, nextIntents.length));
            intent.putParcelableArrayListExtra(ProcessPhoenix.KEY_RESTART_INTENTS, new ArrayList<>(j2));
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
            Runtime.getRuntime().exit(0);
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(KEY_RESTART_INTENTS);
        if (parcelableArrayListExtra != null) {
            Object[] array = parcelableArrayListExtra.toArray(new Intent[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            startActivities((Intent[]) array);
        }
        finish();
        Runtime.getRuntime().exit(0);
    }
}