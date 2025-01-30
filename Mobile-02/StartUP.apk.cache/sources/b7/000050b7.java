package io.branch.referral;

import android.os.AsyncTask;
import android.os.Build;

/* compiled from: BranchAsyncTask.java */
/* loaded from: classes2.dex */
public abstract class c<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public AsyncTask<Params, Progress, Result> a(Params... paramsArr) {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                return executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
            } catch (Throwable unused) {
                return execute(paramsArr);
            }
        }
        return execute(paramsArr);
    }
}