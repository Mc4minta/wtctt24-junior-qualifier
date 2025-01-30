package e.d.a.a.a;

import android.util.Log;
import com.crashlytics.android.answers.Answers;

/* compiled from: AnswersKitEventLogger.java */
/* loaded from: classes2.dex */
class a implements d {
    private final Answers a;

    private a(Answers answers) {
        this.a = answers;
    }

    public static a b() throws NoClassDefFoundError, IllegalStateException {
        return c(Answers.getInstance());
    }

    static a c(Answers answers) throws IllegalStateException {
        if (answers != null) {
            return new a(answers);
        }
        throw new IllegalStateException("Answers must be initialized before logging kit events");
    }

    @Override // e.d.a.a.a.d
    public void a(c cVar) {
        try {
            this.a.logCustom(cVar.b());
        } catch (Throwable th) {
            Log.w("AnswersKitEventLogger", "Unexpected error sending Answers event", th);
        }
    }
}