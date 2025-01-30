package com.facebook.react.modules.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.fbreact.specs.NativeImageEditorSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

@e.f.m.x.a.a(name = ImageEditingManager.NAME)
/* loaded from: classes2.dex */
public class ImageEditingManager extends NativeImageEditorSpec {
    private static final int COMPRESS_QUALITY = 90;
    public static final String NAME = "ImageEditingManager";
    private static final String TEMP_FILE_PREFIX = "ReactNative_cropped_image_";
    private static final List<String> LOCAL_URI_PREFIXES = Arrays.asList("file://", "content://");
    @SuppressLint({"InlinedApi"})
    private static final String[] EXIF_ATTRIBUTES = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};

    /* loaded from: classes2.dex */
    private static class b extends GuardedAsyncTask<Void, Void> {
        private final Context a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements FilenameFilter {
            a() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith(ImageEditingManager.TEMP_FILE_PREFIX);
            }
        }

        private void a(File file) {
            File[] listFiles = file.listFiles(new a());
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: b */
        public void doInBackgroundGuarded(Void... voidArr) {
            a(this.a.getCacheDir());
            File externalCacheDir = this.a.getExternalCacheDir();
            if (externalCacheDir != null) {
                a(externalCacheDir);
            }
        }

        private b(ReactContext reactContext) {
            super(reactContext);
            this.a = reactContext;
        }
    }

    /* loaded from: classes2.dex */
    private static class c extends GuardedAsyncTask<Void, Void> {
        final Context a;

        /* renamed from: b  reason: collision with root package name */
        final String f4861b;

        /* renamed from: c  reason: collision with root package name */
        final int f4862c;

        /* renamed from: d  reason: collision with root package name */
        final int f4863d;

        /* renamed from: e  reason: collision with root package name */
        final int f4864e;

        /* renamed from: f  reason: collision with root package name */
        final int f4865f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f4866g;

        /* renamed from: h  reason: collision with root package name */
        int f4867h;

        /* renamed from: i  reason: collision with root package name */
        int f4868i;

        /* renamed from: j  reason: collision with root package name */
        final Callback f4869j;

        /* renamed from: k  reason: collision with root package name */
        final Callback f4870k;

        private Bitmap a(BitmapFactory.Options options) throws IOException {
            InputStream d2 = d();
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(d2, false);
            try {
                int i2 = this.f4862c;
                int i3 = this.f4863d;
                return newInstance.decodeRegion(new Rect(i2, i3, this.f4864e + i2, this.f4865f + i3), options);
            } finally {
                if (d2 != null) {
                    d2.close();
                }
                newInstance.recycle();
            }
        }

        private Bitmap b(int i2, int i3, BitmapFactory.Options options) throws IOException {
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            e.f.k.a.a.c(options);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            InputStream d2 = d();
            try {
                BitmapFactory.decodeStream(d2, null, options2);
                if (d2 != null) {
                    d2.close();
                }
                int i4 = this.f4864e;
                int i5 = this.f4865f;
                float f7 = i2;
                float f8 = i3;
                float f9 = f7 / f8;
                if (i4 / i5 > f9) {
                    f2 = i5 * f9;
                    f6 = i5;
                    f3 = this.f4862c + ((i4 - f2) / 2.0f);
                    f4 = this.f4863d;
                    f5 = f8 / i5;
                } else {
                    f2 = i4;
                    float f10 = i4 / f9;
                    f3 = this.f4862c;
                    f4 = this.f4863d + ((i5 - f10) / 2.0f);
                    f5 = f7 / i4;
                    f6 = f10;
                }
                options.inSampleSize = ImageEditingManager.getDecodeSampleSize(i4, i5, i2, i3);
                options2.inJustDecodeBounds = false;
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(d(), null, options);
                    if (decodeStream != null) {
                        float f11 = f5 * options.inSampleSize;
                        Matrix matrix = new Matrix();
                        matrix.setScale(f11, f11);
                        return Bitmap.createBitmap(decodeStream, (int) Math.floor(f3 / options.inSampleSize), (int) Math.floor(f4 / options.inSampleSize), (int) Math.floor(f2 / options.inSampleSize), (int) Math.floor(f6 / options.inSampleSize), matrix, true);
                    }
                    throw new IOException("Cannot decode bitmap: " + this.f4861b);
                } finally {
                }
            } finally {
                if (d2 != null) {
                    d2.close();
                }
            }
        }

        private InputStream d() throws IOException {
            InputStream inputStream;
            if (ImageEditingManager.isLocalUri(this.f4861b)) {
                inputStream = this.a.getContentResolver().openInputStream(Uri.parse(this.f4861b));
            } else {
                inputStream = ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.f4861b).openConnection())).getInputStream();
            }
            if (inputStream != null) {
                return inputStream;
            }
            throw new IOException("Cannot open bitmap: " + this.f4861b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: c */
        public void doInBackgroundGuarded(Void... voidArr) {
            Bitmap a;
            File writeBitmapToExternalCache;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                int i2 = this.f4867h;
                if (i2 > 0 && this.f4868i > 0) {
                    a = b(i2, this.f4868i, options);
                } else {
                    a = a(options);
                }
                String str = options.outMimeType;
                if (str != null && !str.isEmpty()) {
                    try {
                        writeBitmapToExternalCache = ImageEditingManager.writeBitmapToInternalCache(this.a, a, str);
                    } catch (Exception unused) {
                        if (this.f4866g) {
                            writeBitmapToExternalCache = ImageEditingManager.writeBitmapToExternalCache(this.a, a, str);
                        } else {
                            throw new SecurityException("We couldn't create file in internal cache and external cache is disabled. Did you forget to pass allowExternalStorage=true?");
                        }
                    }
                    if (str.equals("image/jpeg")) {
                        ImageEditingManager.copyExif(this.a, Uri.parse(this.f4861b), writeBitmapToExternalCache);
                    }
                    this.f4869j.invoke(Uri.fromFile(writeBitmapToExternalCache).toString());
                    return;
                }
                throw new IOException("Could not determine MIME type");
            } catch (Exception e2) {
                this.f4870k.invoke(e2.getMessage());
            }
        }

        public void e(int i2, int i3) {
            if (i2 > 0 && i3 > 0) {
                this.f4867h = i2;
                this.f4868i = i3;
                return;
            }
            throw new JSApplicationIllegalArgumentException(String.format("Invalid target size: [%d, %d]", Integer.valueOf(i2), Integer.valueOf(i3)));
        }

        private c(ReactContext reactContext, String str, int i2, int i3, int i4, int i5, boolean z, Callback callback, Callback callback2) {
            super(reactContext);
            this.f4867h = 0;
            this.f4868i = 0;
            if (i2 >= 0 && i3 >= 0 && i4 > 0 && i5 > 0) {
                this.a = reactContext;
                this.f4861b = str;
                this.f4862c = i2;
                this.f4863d = i3;
                this.f4864e = i4;
                this.f4865f = i5;
                this.f4866g = z;
                this.f4869j = callback;
                this.f4870k = callback2;
                return;
            }
            throw new JSApplicationIllegalArgumentException(String.format("Invalid crop rectangle: [%d, %d, %d, %d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
        }
    }

    public ImageEditingManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        new b(getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void copyExif(Context context, Uri uri, File file) throws IOException {
        String[] strArr;
        File fileFromUri = getFileFromUri(context, uri);
        if (fileFromUri == null) {
            e.f.d.d.a.A("ReactNative", "Couldn't get real path for uri: " + uri);
            return;
        }
        ExifInterface exifInterface = new ExifInterface(fileFromUri.getAbsolutePath());
        ExifInterface exifInterface2 = new ExifInterface(file.getAbsolutePath());
        for (String str : EXIF_ATTRIBUTES) {
            String attribute = exifInterface.getAttribute(str);
            if (attribute != null) {
                exifInterface2.setAttribute(str, attribute);
            }
        }
        exifInterface2.saveAttributes();
    }

    private static File createTempFile(File file, String str) throws IOException {
        if (file != null) {
            return File.createTempFile(TEMP_FILE_PREFIX, getFileExtensionForType(str), file);
        }
        throw new IOException("No cache directory available");
    }

    private static Bitmap.CompressFormat getCompressFormatForType(String str) {
        if ("image/png".equals(str)) {
            return Bitmap.CompressFormat.PNG;
        }
        if ("image/webp".equals(str)) {
            return Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getDecodeSampleSize(int i2, int i3, int i4, int i5) {
        int i6 = 1;
        if (i3 > i4 || i2 > i5) {
            int i7 = i3 / 2;
            int i8 = i2 / 2;
            while (i8 / i6 >= i4 && i7 / i6 >= i5) {
                i6 *= 2;
            }
        }
        return i6;
    }

    private static String getFileExtensionForType(String str) {
        return "image/png".equals(str) ? ".png" : "image/webp".equals(str) ? ".webp" : ".jpg";
    }

    private static File getFileFromUri(Context context, Uri uri) {
        Cursor query;
        if (uri.getScheme().equals("file")) {
            return new File(uri.getPath());
        }
        if (!uri.getScheme().equals("content") || (query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
            return null;
        }
        try {
            if (query.moveToFirst()) {
                String string = query.getString(0);
                if (!TextUtils.isEmpty(string)) {
                    return new File(string);
                }
            }
            return null;
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLocalUri(String str) {
        for (String str2 : LOCAL_URI_PREFIXES) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File writeBitmapToExternalCache(Context context, Bitmap bitmap, String str) throws IOException {
        File createTempFile = createTempFile(context.getExternalCacheDir(), str);
        writeCompressedBitmapToFile(bitmap, str, createTempFile);
        return createTempFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File writeBitmapToInternalCache(Context context, Bitmap bitmap, String str) throws IOException {
        File createTempFile = createTempFile(context.getCacheDir(), str);
        writeCompressedBitmapToFile(bitmap, str, createTempFile);
        return createTempFile;
    }

    private static void writeCompressedBitmapToFile(Bitmap bitmap, String str, File file) throws IOException {
        bitmap.compress(getCompressFormatForType(str), 90, new FileOutputStream(file));
    }

    @Override // com.facebook.fbreact.specs.NativeImageEditorSpec
    public void cropImage(String str, ReadableMap readableMap, Callback callback, Callback callback2) {
        ReadableMap map = readableMap.hasKey("offset") ? readableMap.getMap("offset") : null;
        ReadableMap map2 = readableMap.hasKey("size") ? readableMap.getMap("size") : null;
        boolean z = readableMap.hasKey("allowExternalStorage") ? readableMap.getBoolean("allowExternalStorage") : true;
        if (map != null && map2 != null && map.hasKey("x") && map.hasKey("y") && map2.hasKey("width") && map2.hasKey("height")) {
            if (str != null && !str.isEmpty()) {
                c cVar = new c(getReactApplicationContext(), str, (int) map.getDouble("x"), (int) map.getDouble("y"), (int) map2.getDouble("width"), (int) map2.getDouble("height"), z, callback, callback2);
                if (readableMap.hasKey("displaySize")) {
                    ReadableMap map3 = readableMap.getMap("displaySize");
                    cVar.e((int) map3.getDouble("width"), (int) map3.getDouble("height"));
                }
                cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Please specify a URI");
        }
        throw new JSApplicationIllegalArgumentException("Please specify offset and size");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        new b(getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}