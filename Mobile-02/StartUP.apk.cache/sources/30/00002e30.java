package com.facebook.react.modules.camera;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.facebook.fbreact.specs.NativeCameraRollManagerSpec;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.internal.cache.DiskLruCache;

@e.f.m.x.a.a(name = CameraRollManager.NAME)
/* loaded from: classes2.dex */
public class CameraRollManager extends NativeCameraRollManagerSpec {
    private static final String ASSET_TYPE_ALL = "All";
    private static final String ASSET_TYPE_PHOTOS = "Photos";
    private static final String ASSET_TYPE_VIDEOS = "Videos";
    private static final String ERROR_UNABLE_TO_FILTER = "E_UNABLE_TO_FILTER";
    private static final String ERROR_UNABLE_TO_LOAD = "E_UNABLE_TO_LOAD";
    private static final String ERROR_UNABLE_TO_LOAD_PERMISSION = "E_UNABLE_TO_LOAD_PERMISSION";
    private static final String ERROR_UNABLE_TO_SAVE = "E_UNABLE_TO_SAVE";
    public static final String NAME = "CameraRollManager";
    private static final String[] PROJECTION = {"_id", "mime_type", "bucket_display_name", "datetaken", "width", "height", "longitude", "latitude", "_data"};
    private static final String SELECTION_BUCKET = "bucket_display_name = ?";
    private static final String SELECTION_DATE_TAKEN = "datetaken < ?";
    private static final String SELECTION_MEDIA_SIZE = "_size < ?";

    /* loaded from: classes2.dex */
    private static class b extends GuardedAsyncTask<Void, Void> {
        private final Context a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4852b;

        /* renamed from: c  reason: collision with root package name */
        private final String f4853c;

        /* renamed from: d  reason: collision with root package name */
        private final String f4854d;

        /* renamed from: e  reason: collision with root package name */
        private final ReadableArray f4855e;

        /* renamed from: f  reason: collision with root package name */
        private final Promise f4856f;

        /* renamed from: g  reason: collision with root package name */
        private final String f4857g;

        /* renamed from: h  reason: collision with root package name */
        private final Integer f4858h;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            StringBuilder sb = new StringBuilder(DiskLruCache.VERSION_1);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.f4853c)) {
                sb.append(" AND datetaken < ?");
                arrayList.add(this.f4853c);
            }
            if (!TextUtils.isEmpty(this.f4854d)) {
                sb.append(" AND bucket_display_name = ?");
                arrayList.add(this.f4854d);
            }
            if (this.f4858h != null) {
                sb.append(" AND _size < ?");
                arrayList.add(this.f4858h.toString());
            }
            String str = this.f4857g;
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1905167199:
                    if (str.equals(CameraRollManager.ASSET_TYPE_PHOTOS)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1732810888:
                    if (str.equals(CameraRollManager.ASSET_TYPE_VIDEOS)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 65921:
                    if (str.equals(CameraRollManager.ASSET_TYPE_ALL)) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    sb.append(" AND media_type = 1");
                    break;
                case 1:
                    sb.append(" AND media_type = 3");
                    break;
                case 2:
                    sb.append(" AND media_type IN (3,1)");
                    break;
                default:
                    this.f4856f.reject(CameraRollManager.ERROR_UNABLE_TO_FILTER, "Invalid filter option: '" + this.f4857g + "'. Expected one of '" + CameraRollManager.ASSET_TYPE_PHOTOS + "', '" + CameraRollManager.ASSET_TYPE_VIDEOS + "' or '" + CameraRollManager.ASSET_TYPE_ALL + "'.");
                    return;
            }
            ReadableArray readableArray = this.f4855e;
            if (readableArray != null && readableArray.size() > 0) {
                sb.append(" AND mime_type IN (");
                for (int i2 = 0; i2 < this.f4855e.size(); i2++) {
                    sb.append("?,");
                    arrayList.add(this.f4855e.getString(i2));
                }
                sb.replace(sb.length() - 1, sb.length(), ")");
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ContentResolver contentResolver = this.a.getContentResolver();
            try {
                Cursor query = contentResolver.query(MediaStore.Files.getContentUri("external"), CameraRollManager.PROJECTION, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), "datetaken DESC, date_modified DESC LIMIT " + (this.f4852b + 1));
                if (query != null) {
                    CameraRollManager.putEdges(contentResolver, query, writableNativeMap, this.f4852b);
                    CameraRollManager.putPageInfo(query, writableNativeMap, this.f4852b);
                    query.close();
                    this.f4856f.resolve(writableNativeMap);
                } else {
                    this.f4856f.reject(CameraRollManager.ERROR_UNABLE_TO_LOAD, "Could not get media");
                }
            } catch (SecurityException e2) {
                this.f4856f.reject(CameraRollManager.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get media: need READ_EXTERNAL_STORAGE permission", e2);
            }
        }

        private b(ReactContext reactContext, int i2, String str, String str2, ReadableArray readableArray, String str3, Integer num, Promise promise) {
            super(reactContext);
            this.a = reactContext;
            this.f4852b = i2;
            this.f4853c = str;
            this.f4854d = str2;
            this.f4855e = readableArray;
            this.f4856f = promise;
            this.f4857g = str3;
            this.f4858h = num;
        }
    }

    /* loaded from: classes2.dex */
    private static class c extends GuardedAsyncTask<Void, Void> {
        private final Context a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f4859b;

        /* renamed from: c  reason: collision with root package name */
        private final Promise f4860c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements MediaScannerConnection.OnScanCompletedListener {
            a() {
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                if (uri != null) {
                    c.this.f4860c.resolve(uri.toString());
                } else {
                    c.this.f4860c.reject(CameraRollManager.ERROR_UNABLE_TO_SAVE, "Could not add image to gallery");
                }
            }
        }

        public c(ReactContext reactContext, Uri uri, Promise promise) {
            super(reactContext);
            this.a = reactContext;
            this.f4859b = uri;
            this.f4860c = promise;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't wrap try/catch for region: R(6:(2:2|3)|(4:8|9|10|(2:12|(1:24)(3:16|17|19))(19:26|(1:28)(1:104)|29|(2:32|30)|33|34|35|36|37|(2:40|38)|41|42|(2:45|43)|46|47|48|(2:57|58)|50|(3:52|53|54)(1:56)))|109|9|10|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0128, code lost:
            r2 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0129, code lost:
            r12 = r4;
            r4 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x012d, code lost:
            r2 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x012e, code lost:
            r12 = r4;
            r4 = null;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0055 A[Catch: all -> 0x0128, IOException -> 0x012d, TRY_LEAVE, TryCatch #12 {IOException -> 0x012d, all -> 0x0128, blocks: (B:10:0x0046, B:12:0x0055, B:21:0x006f, B:23:0x0085, B:26:0x009b, B:28:0x00a1, B:29:0x00c1), top: B:111:0x0046 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[Catch: all -> 0x0128, IOException -> 0x012d, TRY_ENTER, TryCatch #12 {IOException -> 0x012d, all -> 0x0128, blocks: (B:10:0x0046, B:12:0x0055, B:21:0x006f, B:23:0x0085, B:26:0x009b, B:28:0x00a1, B:29:0x00c1), top: B:111:0x0046 }] */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void doInBackgroundGuarded(java.lang.Void... r14) {
            /*
                Method dump skipped, instructions count: 383
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.camera.CameraRollManager.c.doInBackgroundGuarded(java.lang.Void[]):void");
        }
    }

    public CameraRollManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private static void putBasicNodeInfo(Cursor cursor, WritableMap writableMap, int i2, int i3, int i4) {
        writableMap.putString("type", cursor.getString(i2));
        writableMap.putString("group_name", cursor.getString(i3));
        writableMap.putDouble("timestamp", cursor.getLong(i4) / 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putEdges(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i2) {
        WritableNativeArray writableNativeArray;
        int i3;
        WritableNativeArray writableNativeArray2 = new WritableNativeArray();
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("mime_type");
        int columnIndex3 = cursor.getColumnIndex("bucket_display_name");
        int columnIndex4 = cursor.getColumnIndex("datetaken");
        int columnIndex5 = cursor.getColumnIndex("width");
        int columnIndex6 = cursor.getColumnIndex("height");
        int columnIndex7 = cursor.getColumnIndex("longitude");
        int columnIndex8 = cursor.getColumnIndex("latitude");
        int columnIndex9 = cursor.getColumnIndex("_data");
        int i4 = i2;
        int i5 = 0;
        while (i5 < i4 && !cursor.isAfterLast()) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            WritableNativeArray writableNativeArray3 = writableNativeArray2;
            int i6 = columnIndex;
            int i7 = columnIndex5;
            int i8 = i5;
            int i9 = columnIndex;
            int i10 = columnIndex8;
            int i11 = columnIndex5;
            int i12 = columnIndex7;
            if (putImageInfo(contentResolver, cursor, writableNativeMap2, i6, i7, columnIndex6, columnIndex9, columnIndex2)) {
                putBasicNodeInfo(cursor, writableNativeMap2, columnIndex2, columnIndex3, columnIndex4);
                putLocationInfo(cursor, writableNativeMap2, i12, i10);
                writableNativeMap.putMap("node", writableNativeMap2);
                writableNativeArray = writableNativeArray3;
                writableNativeArray.pushMap(writableNativeMap);
                i3 = i8;
            } else {
                writableNativeArray = writableNativeArray3;
                i3 = i8 - 1;
            }
            cursor.moveToNext();
            i5 = i3 + 1;
            i4 = i2;
            writableNativeArray2 = writableNativeArray;
            columnIndex8 = i10;
            columnIndex7 = i12;
            columnIndex = i9;
            columnIndex5 = i11;
        }
        writableMap.putArray("edges", writableNativeArray2);
    }

    private static boolean putImageInfo(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i2, int i3, int i4, int i5, int i6) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Uri parse = Uri.parse("file://" + cursor.getString(i5));
        writableNativeMap.putString("uri", parse.toString());
        float f2 = (float) cursor.getInt(i3);
        float f3 = (float) cursor.getInt(i4);
        String string = cursor.getString(i6);
        if (string != null && string.startsWith("video")) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(parse, "r");
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(openAssetFileDescriptor.getFileDescriptor());
                if (f2 <= 0.0f || f3 <= 0.0f) {
                    try {
                        f2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        f3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    } catch (NumberFormatException e2) {
                        e.f.d.d.a.j("ReactNative", "Number format exception occurred while trying to fetch video metadata for " + parse.toString(), e2);
                        mediaMetadataRetriever.release();
                        openAssetFileDescriptor.close();
                        return false;
                    }
                }
                writableNativeMap.putInt("playableDuration", Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) / RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
                mediaMetadataRetriever.release();
                openAssetFileDescriptor.close();
            } catch (Exception e3) {
                e.f.d.d.a.j("ReactNative", "Could not get video metadata for " + parse.toString(), e3);
                return false;
            }
        }
        if (f2 <= 0.0f || f3 <= 0.0f) {
            try {
                AssetFileDescriptor openAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(parse, "r");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(openAssetFileDescriptor2.getFileDescriptor(), null, options);
                f2 = options.outWidth;
                f3 = options.outHeight;
                openAssetFileDescriptor2.close();
            } catch (IOException e4) {
                e.f.d.d.a.j("ReactNative", "Could not get width/height for " + parse.toString(), e4);
                return false;
            }
        }
        writableNativeMap.putDouble("width", f2);
        writableNativeMap.putDouble("height", f3);
        writableMap.putMap("image", writableNativeMap);
        return true;
    }

    private static void putLocationInfo(Cursor cursor, WritableMap writableMap, int i2, int i3) {
        double d2 = cursor.getDouble(i2);
        double d3 = cursor.getDouble(i3);
        if (d2 > 0.0d || d3 > 0.0d) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("longitude", d2);
            writableNativeMap.putDouble("latitude", d3);
            writableMap.putMap("location", writableNativeMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putPageInfo(Cursor cursor, WritableMap writableMap, int i2) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("has_next_page", i2 < cursor.getCount());
        if (i2 < cursor.getCount()) {
            cursor.moveToPosition(i2 - 1);
            writableNativeMap.putString("end_cursor", cursor.getString(cursor.getColumnIndex("datetaken")));
        }
        writableMap.putMap("page_info", writableNativeMap);
    }

    @Override // com.facebook.fbreact.specs.NativeCameraRollManagerSpec
    public void deletePhotos(ReadableArray readableArray, Promise promise) {
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeCameraRollManagerSpec
    public void getPhotos(ReadableMap readableMap, Promise promise) {
        int i2 = readableMap.getInt("first");
        String string = readableMap.hasKey("after") ? readableMap.getString("after") : null;
        String string2 = readableMap.hasKey("groupName") ? readableMap.getString("groupName") : null;
        String string3 = readableMap.hasKey("assetType") ? readableMap.getString("assetType") : ASSET_TYPE_PHOTOS;
        Integer valueOf = readableMap.hasKey("maxSize") ? Integer.valueOf(readableMap.getInt("maxSize")) : null;
        ReadableArray array = readableMap.hasKey("mimeTypes") ? readableMap.getArray("mimeTypes") : null;
        if (!readableMap.hasKey("groupTypes")) {
            new b(getReactApplicationContext(), i2, string, string2, array, string3, valueOf, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new JSApplicationIllegalArgumentException("groupTypes is not supported on Android");
    }

    @Override // com.facebook.fbreact.specs.NativeCameraRollManagerSpec
    public void saveToCameraRoll(String str, String str2, Promise promise) {
        new c(getReactApplicationContext(), Uri.parse(str), promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}