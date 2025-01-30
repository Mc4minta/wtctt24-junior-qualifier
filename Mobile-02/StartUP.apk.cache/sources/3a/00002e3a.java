package com.facebook.react.modules.camera;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Base64OutputStream;
import com.facebook.fbreact.specs.NativeImageStoreSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@e.f.m.x.a.a(name = ImageStoreManager.NAME)
/* loaded from: classes2.dex */
public class ImageStoreManager extends NativeImageStoreSpec {
    private static final int BUFFER_SIZE = 8192;
    public static final String NAME = "ImageStoreManager";

    /* loaded from: classes2.dex */
    private class b extends GuardedAsyncTask<Void, Void> {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final Callback f4871b;

        /* renamed from: c  reason: collision with root package name */
        private final Callback f4872c;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            try {
                InputStream openInputStream = ImageStoreManager.this.getReactApplicationContext().getContentResolver().openInputStream(Uri.parse(this.a));
                try {
                    this.f4871b.invoke(ImageStoreManager.this.convertInputStreamToBase64OutputStream(openInputStream));
                } catch (IOException e2) {
                    this.f4872c.invoke(e2.getMessage());
                }
                ImageStoreManager.closeQuietly(openInputStream);
            } catch (FileNotFoundException e3) {
                this.f4872c.invoke(e3.getMessage());
            }
        }

        private b(ReactContext reactContext, String str, Callback callback, Callback callback2) {
            super(reactContext);
            this.a = str;
            this.f4871b = callback;
            this.f4872c = callback2;
        }
    }

    public ImageStoreManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    @Override // com.facebook.fbreact.specs.NativeImageStoreSpec
    public void addImageFromBase64(String str, Callback callback, Callback callback2) {
    }

    String convertInputStreamToBase64OutputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 2);
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read > -1) {
                    base64OutputStream.write(bArr, 0, read);
                } else {
                    closeQuietly(base64OutputStream);
                    return byteArrayOutputStream.toString();
                }
            } catch (Throwable th) {
                closeQuietly(base64OutputStream);
                throw th;
            }
        }
    }

    @Override // com.facebook.fbreact.specs.NativeImageStoreSpec
    public void getBase64ForTag(String str, Callback callback, Callback callback2) {
        new b(getReactApplicationContext(), str, callback, callback2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeImageStoreSpec
    public void hasImageForTag(String str, Callback callback) {
    }

    @Override // com.facebook.fbreact.specs.NativeImageStoreSpec
    public void removeImageForTag(String str) {
    }
}