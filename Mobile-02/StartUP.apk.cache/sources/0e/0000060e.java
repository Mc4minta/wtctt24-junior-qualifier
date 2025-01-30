package c.r.a;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* compiled from: SupportSQLiteDatabase.java */
/* loaded from: classes.dex */
public interface b extends Closeable {
    Cursor A0(e eVar);

    f B(String str);

    boolean F0();

    Cursor S(e eVar, CancellationSignal cancellationSignal);

    void c0();

    String getPath();

    Cursor i0(String str);

    boolean isOpen();

    void o();

    void p0();

    List<Pair<String, String>> r();

    void t(String str) throws SQLException;
}