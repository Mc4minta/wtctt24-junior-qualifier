package e.f.b.a;

/* compiled from: CacheErrorLogger.java */
/* loaded from: classes2.dex */
public interface a {

    /* compiled from: CacheErrorLogger.java */
    /* renamed from: e.f.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0260a {
        READ_DECODE,
        READ_FILE,
        READ_FILE_NOT_FOUND,
        READ_INVALID_ENTRY,
        WRITE_ENCODE,
        WRITE_CREATE_TEMPFILE,
        WRITE_UPDATE_FILE_NOT_FOUND,
        WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND,
        WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND,
        WRITE_RENAME_FILE_OTHER,
        WRITE_CREATE_DIR,
        WRITE_CALLBACK_ERROR,
        WRITE_INVALID_ENTRY,
        DELETE_FILE,
        EVICTION,
        GENERIC_IO,
        OTHER
    }

    void a(EnumC0260a enumC0260a, Class<?> cls, String str, Throwable th);
}