package com.facebook.react.modules.storage;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import com.facebook.fbreact.specs.NativeAsyncStorageSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

@e.f.m.x.a.a(name = AsyncStorageModule.NAME)
/* loaded from: classes2.dex */
public final class AsyncStorageModule extends NativeAsyncStorageSpec {
    private static final int MAX_SQL_KEYS = 999;
    public static final String NAME = "AsyncSQLiteDBStorage";
    private final g executor;
    private com.facebook.react.modules.storage.c mReactDatabaseSupplier;
    private boolean mShuttingDown;

    /* loaded from: classes2.dex */
    class a extends GuardedAsyncTask<Void, Void> {
        final /* synthetic */ Callback a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableArray f5001b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ReactContext reactContext, Callback callback, ReadableArray readableArray) {
            super(reactContext);
            this.a = callback;
            this.f5001b = readableArray;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00c1 A[LOOP:3: B:21:0x00bb->B:23:0x00c1, LOOP_END] */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void doInBackgroundGuarded(java.lang.Void... r20) {
            /*
                Method dump skipped, instructions count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.a.doInBackgroundGuarded(java.lang.Void[]):void");
        }
    }

    /* loaded from: classes2.dex */
    class b extends GuardedAsyncTask<Void, Void> {
        final /* synthetic */ Callback a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableArray f5003b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ReactContext reactContext, Callback callback, ReadableArray readableArray) {
            super(reactContext);
            this.a = callback;
            this.f5003b = readableArray;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            WritableMap writableMap = null;
            if (AsyncStorageModule.this.ensureDatabase()) {
                SQLiteStatement compileStatement = AsyncStorageModule.this.mReactDatabaseSupplier.f().compileStatement("INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);");
                try {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.f().beginTransaction();
                        for (int i2 = 0; i2 < this.f5003b.size(); i2++) {
                            if (this.f5003b.getArray(i2).size() != 2) {
                                WritableMap d2 = com.facebook.react.modules.storage.b.d(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                                    return;
                                } catch (Exception e2) {
                                    e.f.d.d.a.B("ReactNative", e2.getMessage(), e2);
                                    if (d2 == null) {
                                        com.facebook.react.modules.storage.b.b(null, e2.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            } else if (this.f5003b.getArray(i2).getString(0) == null) {
                                WritableMap c2 = com.facebook.react.modules.storage.b.c(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                                    return;
                                } catch (Exception e3) {
                                    e.f.d.d.a.B("ReactNative", e3.getMessage(), e3);
                                    if (c2 == null) {
                                        com.facebook.react.modules.storage.b.b(null, e3.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            } else if (this.f5003b.getArray(i2).getString(1) == null) {
                                WritableMap d3 = com.facebook.react.modules.storage.b.d(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                                    return;
                                } catch (Exception e4) {
                                    e.f.d.d.a.B("ReactNative", e4.getMessage(), e4);
                                    if (d3 == null) {
                                        com.facebook.react.modules.storage.b.b(null, e4.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                compileStatement.clearBindings();
                                compileStatement.bindString(1, this.f5003b.getArray(i2).getString(0));
                                compileStatement.bindString(2, this.f5003b.getArray(i2).getString(1));
                                compileStatement.execute();
                            }
                        }
                        AsyncStorageModule.this.mReactDatabaseSupplier.f().setTransactionSuccessful();
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                        } catch (Exception e5) {
                            e.f.d.d.a.B("ReactNative", e5.getMessage(), e5);
                            writableMap = com.facebook.react.modules.storage.b.b(null, e5.getMessage());
                        }
                    } catch (Exception e6) {
                        e.f.d.d.a.B("ReactNative", e6.getMessage(), e6);
                        WritableMap b2 = com.facebook.react.modules.storage.b.b(null, e6.getMessage());
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                        } catch (Exception e7) {
                            e.f.d.d.a.B("ReactNative", e7.getMessage(), e7);
                            if (b2 == null) {
                                writableMap = com.facebook.react.modules.storage.b.b(null, e7.getMessage());
                            }
                        }
                        writableMap = b2;
                    }
                    if (writableMap != null) {
                        this.a.invoke(writableMap);
                        return;
                    } else {
                        this.a.invoke(new Object[0]);
                        return;
                    }
                } catch (Throwable th) {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                    } catch (Exception e8) {
                        e.f.d.d.a.B("ReactNative", e8.getMessage(), e8);
                        com.facebook.react.modules.storage.b.b(null, e8.getMessage());
                    }
                    throw th;
                }
            }
            this.a.invoke(com.facebook.react.modules.storage.b.a(null));
        }
    }

    /* loaded from: classes2.dex */
    class c extends GuardedAsyncTask<Void, Void> {
        final /* synthetic */ Callback a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableArray f5005b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ReactContext reactContext, Callback callback, ReadableArray readableArray) {
            super(reactContext);
            this.a = callback;
            this.f5005b = readableArray;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            WritableMap writableMap = null;
            try {
                if (AsyncStorageModule.this.ensureDatabase()) {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.f().beginTransaction();
                        for (int i2 = 0; i2 < this.f5005b.size(); i2 += 999) {
                            int min = Math.min(this.f5005b.size() - i2, 999);
                            AsyncStorageModule.this.mReactDatabaseSupplier.f().delete("catalystLocalStorage", com.facebook.react.modules.storage.a.a(min), com.facebook.react.modules.storage.a.b(this.f5005b, i2, min));
                        }
                        AsyncStorageModule.this.mReactDatabaseSupplier.f().setTransactionSuccessful();
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                        } catch (Exception e2) {
                            e.f.d.d.a.B("ReactNative", e2.getMessage(), e2);
                            writableMap = com.facebook.react.modules.storage.b.b(null, e2.getMessage());
                        }
                    } catch (Exception e3) {
                        e.f.d.d.a.B("ReactNative", e3.getMessage(), e3);
                        WritableMap b2 = com.facebook.react.modules.storage.b.b(null, e3.getMessage());
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                        } catch (Exception e4) {
                            e.f.d.d.a.B("ReactNative", e4.getMessage(), e4);
                            if (b2 == null) {
                                writableMap = com.facebook.react.modules.storage.b.b(null, e4.getMessage());
                            }
                        }
                        writableMap = b2;
                    }
                    if (writableMap != null) {
                        this.a.invoke(writableMap);
                        return;
                    } else {
                        this.a.invoke(new Object[0]);
                        return;
                    }
                }
                this.a.invoke(com.facebook.react.modules.storage.b.a(null));
            } catch (Throwable th) {
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                } catch (Exception e5) {
                    e.f.d.d.a.B("ReactNative", e5.getMessage(), e5);
                    com.facebook.react.modules.storage.b.b(null, e5.getMessage());
                }
                throw th;
            }
        }
    }

    /* loaded from: classes2.dex */
    class d extends GuardedAsyncTask<Void, Void> {
        final /* synthetic */ Callback a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableArray f5007b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ReactContext reactContext, Callback callback, ReadableArray readableArray) {
            super(reactContext);
            this.a = callback;
            this.f5007b = readableArray;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            WritableMap writableMap = null;
            try {
                if (AsyncStorageModule.this.ensureDatabase()) {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.f().beginTransaction();
                        for (int i2 = 0; i2 < this.f5007b.size(); i2++) {
                            if (this.f5007b.getArray(i2).size() != 2) {
                                WritableMap d2 = com.facebook.react.modules.storage.b.d(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                                    return;
                                } catch (Exception e2) {
                                    e.f.d.d.a.B("ReactNative", e2.getMessage(), e2);
                                    if (d2 == null) {
                                        com.facebook.react.modules.storage.b.b(null, e2.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            } else if (this.f5007b.getArray(i2).getString(0) == null) {
                                WritableMap c2 = com.facebook.react.modules.storage.b.c(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                                    return;
                                } catch (Exception e3) {
                                    e.f.d.d.a.B("ReactNative", e3.getMessage(), e3);
                                    if (c2 == null) {
                                        com.facebook.react.modules.storage.b.b(null, e3.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            } else if (this.f5007b.getArray(i2).getString(1) == null) {
                                WritableMap d3 = com.facebook.react.modules.storage.b.d(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                                    return;
                                } catch (Exception e4) {
                                    e.f.d.d.a.B("ReactNative", e4.getMessage(), e4);
                                    if (d3 == null) {
                                        com.facebook.react.modules.storage.b.b(null, e4.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            } else if (!com.facebook.react.modules.storage.a.e(AsyncStorageModule.this.mReactDatabaseSupplier.f(), this.f5007b.getArray(i2).getString(0), this.f5007b.getArray(i2).getString(1))) {
                                WritableMap a = com.facebook.react.modules.storage.b.a(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                                    return;
                                } catch (Exception e5) {
                                    e.f.d.d.a.B("ReactNative", e5.getMessage(), e5);
                                    if (a == null) {
                                        com.facebook.react.modules.storage.b.b(null, e5.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        AsyncStorageModule.this.mReactDatabaseSupplier.f().setTransactionSuccessful();
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                        } catch (Exception e6) {
                            e.f.d.d.a.B("ReactNative", e6.getMessage(), e6);
                            writableMap = com.facebook.react.modules.storage.b.b(null, e6.getMessage());
                        }
                    } catch (Exception e7) {
                        e.f.d.d.a.B("ReactNative", e7.getMessage(), e7);
                        WritableMap b2 = com.facebook.react.modules.storage.b.b(null, e7.getMessage());
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                        } catch (Exception e8) {
                            e.f.d.d.a.B("ReactNative", e8.getMessage(), e8);
                            if (b2 == null) {
                                writableMap = com.facebook.react.modules.storage.b.b(null, e8.getMessage());
                            }
                        }
                        writableMap = b2;
                    }
                    if (writableMap != null) {
                        this.a.invoke(writableMap);
                        return;
                    } else {
                        this.a.invoke(new Object[0]);
                        return;
                    }
                }
                this.a.invoke(com.facebook.react.modules.storage.b.a(null));
            } catch (Throwable th) {
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.f().endTransaction();
                } catch (Exception e9) {
                    e.f.d.d.a.B("ReactNative", e9.getMessage(), e9);
                    com.facebook.react.modules.storage.b.b(null, e9.getMessage());
                }
                throw th;
            }
        }
    }

    /* loaded from: classes2.dex */
    class e extends GuardedAsyncTask<Void, Void> {
        final /* synthetic */ Callback a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ReactContext reactContext, Callback callback) {
            super(reactContext);
            this.a = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            if (AsyncStorageModule.this.mReactDatabaseSupplier.e()) {
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.a();
                    this.a.invoke(new Object[0]);
                    return;
                } catch (Exception e2) {
                    e.f.d.d.a.B("ReactNative", e2.getMessage(), e2);
                    this.a.invoke(com.facebook.react.modules.storage.b.b(null, e2.getMessage()));
                    return;
                }
            }
            this.a.invoke(com.facebook.react.modules.storage.b.a(null));
        }
    }

    /* loaded from: classes2.dex */
    class f extends GuardedAsyncTask<Void, Void> {
        final /* synthetic */ Callback a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(ReactContext reactContext, Callback callback) {
            super(reactContext);
            this.a = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            if (!AsyncStorageModule.this.ensureDatabase()) {
                this.a.invoke(com.facebook.react.modules.storage.b.a(null), null);
                return;
            }
            WritableArray createArray = Arguments.createArray();
            Cursor query = AsyncStorageModule.this.mReactDatabaseSupplier.f().query("catalystLocalStorage", new String[]{"key"}, null, null, null, null, null);
            try {
                try {
                    if (query.moveToFirst()) {
                        do {
                            createArray.pushString(query.getString(0));
                        } while (query.moveToNext());
                        query.close();
                        this.a.invoke(null, createArray);
                    }
                    query.close();
                    this.a.invoke(null, createArray);
                } catch (Exception e2) {
                    e.f.d.d.a.B("ReactNative", e2.getMessage(), e2);
                    this.a.invoke(com.facebook.react.modules.storage.b.b(null, e2.getMessage()), null);
                    query.close();
                }
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
    }

    /* loaded from: classes2.dex */
    private class g implements Executor {
        private final ArrayDeque<Runnable> a = new ArrayDeque<>();

        /* renamed from: b  reason: collision with root package name */
        private Runnable f5011b;

        /* renamed from: c  reason: collision with root package name */
        private final Executor f5012c;

        /* loaded from: classes2.dex */
        class a implements Runnable {
            final /* synthetic */ Runnable a;

            a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.a.run();
                } finally {
                    g.this.a();
                }
            }
        }

        g(Executor executor) {
            this.f5012c = executor;
        }

        synchronized void a() {
            Runnable poll = this.a.poll();
            this.f5011b = poll;
            if (poll != null) {
                this.f5012c.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.a.offer(new a(runnable));
            if (this.f5011b == null) {
                a();
            }
        }
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ensureDatabase() {
        return !this.mShuttingDown && this.mReactDatabaseSupplier.e();
    }

    @Override // com.facebook.fbreact.specs.NativeAsyncStorageSpec
    public void clear(Callback callback) {
        new e(getReactApplicationContext(), callback).executeOnExecutor(this.executor, new Void[0]);
    }

    public void clearSensitiveData() {
        this.mReactDatabaseSupplier.b();
    }

    @Override // com.facebook.fbreact.specs.NativeAsyncStorageSpec
    public void getAllKeys(Callback callback) {
        new f(getReactApplicationContext(), callback).executeOnExecutor(this.executor, new Void[0]);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        super.initialize();
        this.mShuttingDown = false;
    }

    @Override // com.facebook.fbreact.specs.NativeAsyncStorageSpec
    public void multiGet(ReadableArray readableArray, Callback callback) {
        if (readableArray == null) {
            callback.invoke(com.facebook.react.modules.storage.b.c(null), null);
        } else {
            new a(getReactApplicationContext(), callback, readableArray).executeOnExecutor(this.executor, new Void[0]);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAsyncStorageSpec
    public void multiMerge(ReadableArray readableArray, Callback callback) {
        new d(getReactApplicationContext(), callback, readableArray).executeOnExecutor(this.executor, new Void[0]);
    }

    @Override // com.facebook.fbreact.specs.NativeAsyncStorageSpec
    public void multiRemove(ReadableArray readableArray, Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(com.facebook.react.modules.storage.b.c(null));
        } else {
            new c(getReactApplicationContext(), callback, readableArray).executeOnExecutor(this.executor, new Void[0]);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAsyncStorageSpec
    public void multiSet(ReadableArray readableArray, Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(com.facebook.react.modules.storage.b.c(null));
        } else {
            new b(getReactApplicationContext(), callback, readableArray).executeOnExecutor(this.executor, new Void[0]);
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
    }

    AsyncStorageModule(ReactApplicationContext reactApplicationContext, Executor executor) {
        super(reactApplicationContext);
        this.mShuttingDown = false;
        this.executor = new g(executor);
        this.mReactDatabaseSupplier = com.facebook.react.modules.storage.c.g(reactApplicationContext);
    }
}