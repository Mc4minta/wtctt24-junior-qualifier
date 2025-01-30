package androidx.room.t;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/* compiled from: DBUtil.java */
/* loaded from: classes.dex */
public class c {
    public static void a(c.r.a.b bVar) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor i0 = bVar.i0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (i0.moveToNext()) {
            try {
                arrayList.add(i0.getString(0));
            } catch (Throwable th) {
                i0.close();
                throw th;
            }
        }
        i0.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.t("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static Cursor b(j jVar, c.r.a.e eVar, boolean z, CancellationSignal cancellationSignal) {
        Cursor query = jVar.query(eVar, cancellationSignal);
        if (z && (query instanceof AbstractWindowedCursor)) {
            AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) query;
            int count = abstractWindowedCursor.getCount();
            return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? b.a(abstractWindowedCursor) : query;
        }
        return query;
    }

    public static int c(File file) throws IOException {
        FileChannel fileChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) == 4) {
                allocate.rewind();
                int i2 = allocate.getInt();
                channel.close();
                return i2;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th) {
            if (0 != 0) {
                fileChannel.close();
            }
            throw th;
        }
    }
}