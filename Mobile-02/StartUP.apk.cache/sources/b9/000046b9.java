package e.f.j.l;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: LocalContentUriFetchProducer.java */
/* loaded from: classes2.dex */
public class w extends z {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f12777c = {"_id", "_data"};

    /* renamed from: d  reason: collision with root package name */
    private final ContentResolver f12778d;

    public w(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.f12778d = contentResolver;
    }

    private e.f.j.i.d g(Uri uri) throws IOException {
        Cursor query = this.f12778d.query(uri, f12777c, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            if (query.getCount() == 0) {
                return null;
            }
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("_data"));
            if (string != null) {
                return e(new FileInputStream(string), h(string));
            }
            return null;
        } finally {
            query.close();
        }
    }

    private static int h(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // e.f.j.l.z
    protected e.f.j.i.d d(com.facebook.imagepipeline.request.b bVar) throws IOException {
        e.f.j.i.d g2;
        InputStream createInputStream;
        Uri q = bVar.q();
        if (!com.facebook.common.util.e.g(q)) {
            return (!com.facebook.common.util.e.f(q) || (g2 = g(q)) == null) ? e(this.f12778d.openInputStream(q), -1) : g2;
        }
        if (q.toString().endsWith("/photo")) {
            createInputStream = this.f12778d.openInputStream(q);
        } else if (q.toString().endsWith("/display_photo")) {
            try {
                createInputStream = this.f12778d.openAssetFileDescriptor(q, "r").createInputStream();
            } catch (IOException unused) {
                throw new IOException("Contact photo does not exist: " + q);
            }
        } else {
            InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.f12778d, q);
            if (openContactPhotoInputStream == null) {
                throw new IOException("Contact photo does not exist: " + q);
            }
            createInputStream = openContactPhotoInputStream;
        }
        return e(createInputStream, -1);
    }

    @Override // e.f.j.l.z
    protected String f() {
        return "LocalContentUriFetchProducer";
    }
}