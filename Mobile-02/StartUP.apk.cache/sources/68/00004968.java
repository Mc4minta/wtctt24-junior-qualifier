package e.j.f;

/* compiled from: DatabaseExtensions.kt */
/* loaded from: classes2.dex */
public final class i {
    public static final boolean a(androidx.room.j jVar) {
        boolean z = false;
        if (jVar == null) {
            return false;
        }
        jVar.beginTransaction();
        try {
            jVar.clearAllTables();
            jVar.setTransactionSuccessful();
            z = true;
        } catch (Exception unused) {
        } catch (Throwable th) {
            jVar.endTransaction();
            throw th;
        }
        jVar.endTransaction();
        return z;
    }
}