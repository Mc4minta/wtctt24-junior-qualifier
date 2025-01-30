package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.core.util.e;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

@e.f.m.x.a.a(name = RNCWebViewModule.MODULE_NAME)
/* loaded from: classes2.dex */
public class RNCWebViewModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final int FILE_DOWNLOAD_PERMISSION_REQUEST = 1;
    public static final String MODULE_NAME = "RNCWebView";
    private static final int PICKER = 1;
    private static final int PICKER_LEGACY = 3;
    protected static final d shouldOverrideUrlLoadingLock = new d();
    private DownloadManager.Request downloadRequest;
    private ValueCallback<Uri[]> filePathCallback;
    private ValueCallback<Uri> filePathCallbackLegacy;
    private File outputImage;
    private File outputVideo;
    private f webviewFileDownloaderPermissionListener;

    /* loaded from: classes2.dex */
    class a implements f {
        a() {
        }

        @Override // com.facebook.react.modules.core.f
        public boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
            if (i2 != 1) {
                return false;
            }
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(RNCWebViewModule.this.getCurrentActivity().getApplicationContext(), "Cannot download files as permission was denied. Please provide permission to write to storage, in order to download files.", 1).show();
            } else if (RNCWebViewModule.this.downloadRequest != null) {
                RNCWebViewModule.this.downloadFile();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum c {
        DEFAULT("*/*"),
        IMAGE("image"),
        VIDEO("video");
        

        /* renamed from: e  reason: collision with root package name */
        private final String f10777e;

        c(String str) {
            this.f10777e = str;
        }
    }

    /* loaded from: classes2.dex */
    protected static class d {
        private int a = 1;

        /* renamed from: b  reason: collision with root package name */
        private final HashMap<Integer, AtomicReference<a>> f10778b = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes2.dex */
        public enum a {
            UNDECIDED,
            SHOULD_OVERRIDE,
            DO_NOT_OVERRIDE
        }

        protected d() {
        }

        public synchronized AtomicReference<a> a(Integer num) {
            return this.f10778b.get(num);
        }

        public synchronized e<Integer, AtomicReference<a>> b() {
            int i2;
            AtomicReference<a> atomicReference;
            i2 = this.a;
            this.a = i2 + 1;
            atomicReference = new AtomicReference<>(a.UNDECIDED);
            this.f10778b.put(Integer.valueOf(i2), atomicReference);
            return new e<>(Integer.valueOf(i2), atomicReference);
        }

        public synchronized void c(Integer num) {
            this.f10778b.remove(num);
        }
    }

    public RNCWebViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.webviewFileDownloaderPermissionListener = new a();
        reactApplicationContext.addActivityEventListener(this);
    }

    private Boolean acceptsImages(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(".", ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains(c.IMAGE.f10777e));
    }

    private Boolean acceptsVideo(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return Boolean.FALSE;
        }
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(".", ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains(c.VIDEO.f10777e));
    }

    private Boolean arrayContainsString(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.contains(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private String[] getAcceptedMimeType(String[] strArr) {
        if (noAcceptTypesSet(strArr).booleanValue()) {
            return new String[]{c.DEFAULT.f10777e};
        }
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (str.matches("\\.\\w+")) {
                String mimeTypeFromExtension = getMimeTypeFromExtension(str.replace(".", ""));
                if (mimeTypeFromExtension != null) {
                    strArr2[i2] = mimeTypeFromExtension;
                } else {
                    strArr2[i2] = str;
                }
            } else {
                strArr2[i2] = str;
            }
        }
        return strArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File getCapturedFile(com.reactnativecommunity.webview.RNCWebViewModule.c r7) throws java.io.IOException {
        /*
            r6 = this;
            int[] r0 = com.reactnativecommunity.webview.RNCWebViewModule.b.a
            int r7 = r7.ordinal()
            r7 = r0[r7]
            r0 = 1
            java.lang.String r1 = ""
            if (r7 == r0) goto L1a
            r0 = 2
            if (r7 == r0) goto L13
            r7 = r1
            r0 = r7
            goto L23
        L13:
            java.lang.String r1 = android.os.Environment.DIRECTORY_MOVIES
            java.lang.String r7 = "video-"
            java.lang.String r0 = ".mp4"
            goto L20
        L1a:
            java.lang.String r1 = android.os.Environment.DIRECTORY_PICTURES
            java.lang.String r7 = "image-"
            java.lang.String r0 = ".jpg"
        L20:
            r5 = r1
            r1 = r7
            r7 = r5
        L23:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r3 >= r4) goto L4d
            java.io.File r7 = android.os.Environment.getExternalStoragePublicDirectory(r7)
            java.io.File r0 = new java.io.File
            r0.<init>(r7, r2)
            goto L5a
        L4d:
            com.facebook.react.bridge.ReactApplicationContext r7 = r6.getReactApplicationContext()
            r2 = 0
            java.io.File r7 = r7.getExternalFilesDir(r2)
            java.io.File r0 = java.io.File.createTempFile(r1, r0, r7)
        L5a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewModule.getCapturedFile(com.reactnativecommunity.webview.RNCWebViewModule$c):java.io.File");
    }

    private Intent getFileChooserIntent(String str) {
        String str2 = str.isEmpty() ? c.DEFAULT.f10777e : str;
        if (str.matches("\\.\\w+")) {
            str2 = getMimeTypeFromExtension(str.replace(".", ""));
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str2);
        return intent;
    }

    private String getMimeTypeFromExtension(String str) {
        if (str != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        return null;
    }

    private Uri getOutputUri(File file) {
        if (Build.VERSION.SDK_INT < 23) {
            return Uri.fromFile(file);
        }
        String packageName = getReactApplicationContext().getPackageName();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        return FileProvider.e(reactApplicationContext, packageName + ".fileprovider", file);
    }

    private com.facebook.react.modules.core.e getPermissionAwareActivity() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if (currentActivity instanceof com.facebook.react.modules.core.e) {
                return (com.facebook.react.modules.core.e) currentActivity;
            }
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
        throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
    }

    private Intent getPhotoIntent() {
        Intent intent;
        Exception e2;
        try {
            File capturedFile = getCapturedFile(c.IMAGE);
            this.outputImage = capturedFile;
            Uri outputUri = getOutputUri(capturedFile);
            intent = new Intent("android.media.action.IMAGE_CAPTURE");
            try {
                intent.putExtra("output", outputUri);
            } catch (IOException e3) {
                e2 = e3;
                Log.e("CREATE FILE", "Error occurred while creating the File", e2);
                e2.printStackTrace();
                return intent;
            } catch (IllegalArgumentException e4) {
                e2 = e4;
                Log.e("CREATE FILE", "Error occurred while creating the File", e2);
                e2.printStackTrace();
                return intent;
            }
        } catch (IOException | IllegalArgumentException e5) {
            intent = null;
            e2 = e5;
        }
        return intent;
    }

    private Uri[] getSelectedFiles(Intent intent, int i2) {
        if (intent == null) {
            return null;
        }
        if (intent.getClipData() != null) {
            int itemCount = intent.getClipData().getItemCount();
            Uri[] uriArr = new Uri[itemCount];
            for (int i3 = 0; i3 < itemCount; i3++) {
                uriArr[i3] = intent.getClipData().getItemAt(i3).getUri();
            }
            return uriArr;
        } else if (intent.getData() == null || i2 != -1 || Build.VERSION.SDK_INT < 21) {
            return null;
        } else {
            return WebChromeClient.FileChooserParams.parseResult(i2, intent);
        }
    }

    private Intent getVideoIntent() {
        Intent intent;
        Exception e2;
        try {
            File capturedFile = getCapturedFile(c.VIDEO);
            this.outputVideo = capturedFile;
            Uri outputUri = getOutputUri(capturedFile);
            intent = new Intent("android.media.action.VIDEO_CAPTURE");
            try {
                intent.putExtra("output", outputUri);
            } catch (IOException e3) {
                e2 = e3;
                Log.e("CREATE FILE", "Error occurred while creating the File", e2);
                e2.printStackTrace();
                return intent;
            } catch (IllegalArgumentException e4) {
                e2 = e4;
                Log.e("CREATE FILE", "Error occurred while creating the File", e2);
                e2.printStackTrace();
                return intent;
            }
        } catch (IOException | IllegalArgumentException e5) {
            intent = null;
            e2 = e5;
        }
        return intent;
    }

    private Boolean noAcceptTypesSet(String[] strArr) {
        boolean z = true;
        if (strArr.length != 0 && (strArr.length != 1 || strArr[0] == null || strArr[0].length() != 0)) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public void downloadFile() {
        ((DownloadManager) getCurrentActivity().getBaseContext().getSystemService("download")).enqueue(this.downloadRequest);
        Toast.makeText(getCurrentActivity().getApplicationContext(), "Downloading", 1).show();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    public boolean grantFileDownloaderPermissions() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 28) {
            return true;
        }
        boolean z = androidx.core.content.a.a(getCurrentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        if (!z && i2 >= 23) {
            getPermissionAwareActivity().requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1, this.webviewFileDownloaderPermissionListener);
        }
        return z;
    }

    @ReactMethod
    public void isFileUploadSupported(Promise promise) {
        Boolean bool = Boolean.FALSE;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            bool = Boolean.TRUE;
        }
        if (i2 >= 16 && i2 <= 18) {
            bool = Boolean.TRUE;
        }
        promise.resolve(bool);
    }

    protected boolean needsCameraPermission() {
        try {
            if (Arrays.asList(getCurrentActivity().getPackageManager().getPackageInfo(getReactApplicationContext().getPackageName(), 4096).requestedPermissions).contains("android.permission.CAMERA")) {
                if (androidx.core.content.a.a(getCurrentActivity(), "android.permission.CAMERA") != 0) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        if (this.filePathCallback == null && this.filePathCallbackLegacy == null) {
            return;
        }
        File file = this.outputImage;
        boolean z = file != null && file.length() > 0;
        File file2 = this.outputVideo;
        boolean z2 = file2 != null && file2.length() > 0;
        if (i2 != 1) {
            if (i2 == 3) {
                if (i3 != -1) {
                    this.filePathCallbackLegacy.onReceiveValue(null);
                } else if (z) {
                    this.filePathCallbackLegacy.onReceiveValue(getOutputUri(this.outputImage));
                } else if (z2) {
                    this.filePathCallbackLegacy.onReceiveValue(getOutputUri(this.outputVideo));
                } else {
                    this.filePathCallbackLegacy.onReceiveValue(intent.getData());
                }
            }
        } else if (i3 != -1) {
            ValueCallback<Uri[]> valueCallback = this.filePathCallback;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        } else if (z) {
            this.filePathCallback.onReceiveValue(new Uri[]{getOutputUri(this.outputImage)});
        } else if (z2) {
            this.filePathCallback.onReceiveValue(new Uri[]{getOutputUri(this.outputVideo)});
        } else {
            this.filePathCallback.onReceiveValue(getSelectedFiles(intent, i3));
        }
        File file3 = this.outputImage;
        if (file3 != null && !z) {
            file3.delete();
        }
        File file4 = this.outputVideo;
        if (file4 != null && !z2) {
            file4.delete();
        }
        this.filePathCallback = null;
        this.filePathCallbackLegacy = null;
        this.outputImage = null;
        this.outputVideo = null;
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public void onShouldStartLoadWithRequestCallback(boolean z, int i2) {
        AtomicReference<d.a> a2 = shouldOverrideUrlLoadingLock.a(Integer.valueOf(i2));
        if (a2 != null) {
            synchronized (a2) {
                a2.set(z ? d.a.DO_NOT_OVERRIDE : d.a.SHOULD_OVERRIDE);
                a2.notify();
            }
        }
    }

    public void setDownloadRequest(DownloadManager.Request request) {
        this.downloadRequest = request;
    }

    public void startPhotoPickerIntent(ValueCallback<Uri> valueCallback, String str) {
        Intent videoIntent;
        Intent photoIntent;
        this.filePathCallbackLegacy = valueCallback;
        Intent createChooser = Intent.createChooser(getFileChooserIntent(str), "");
        ArrayList arrayList = new ArrayList();
        if (acceptsImages(str).booleanValue() && (photoIntent = getPhotoIntent()) != null) {
            arrayList.add(photoIntent);
        }
        if (acceptsVideo(str).booleanValue() && (videoIntent = getVideoIntent()) != null) {
            arrayList.add(videoIntent);
        }
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        if (createChooser.resolveActivity(getCurrentActivity().getPackageManager()) != null) {
            getCurrentActivity().startActivityForResult(createChooser, 3);
        } else {
            Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
        }
    }

    private Boolean acceptsImages(String[] strArr) {
        String[] acceptedMimeType = getAcceptedMimeType(strArr);
        return Boolean.valueOf(arrayContainsString(acceptedMimeType, c.DEFAULT.f10777e).booleanValue() || arrayContainsString(acceptedMimeType, c.IMAGE.f10777e).booleanValue());
    }

    private Boolean acceptsVideo(String[] strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return Boolean.FALSE;
        }
        String[] acceptedMimeType = getAcceptedMimeType(strArr);
        return Boolean.valueOf(arrayContainsString(acceptedMimeType, c.DEFAULT.f10777e).booleanValue() || arrayContainsString(acceptedMimeType, c.VIDEO.f10777e).booleanValue());
    }

    private Intent getFileChooserIntent(String[] strArr, boolean z) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(c.DEFAULT.f10777e);
        intent.putExtra("android.intent.extra.MIME_TYPES", getAcceptedMimeType(strArr));
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
        return intent;
    }

    public boolean startPhotoPickerIntent(ValueCallback<Uri[]> valueCallback, String[] strArr, boolean z) {
        Intent videoIntent;
        Intent photoIntent;
        this.filePathCallback = valueCallback;
        ArrayList arrayList = new ArrayList();
        if (!needsCameraPermission()) {
            if (acceptsImages(strArr).booleanValue() && (photoIntent = getPhotoIntent()) != null) {
                arrayList.add(photoIntent);
            }
            if (acceptsVideo(strArr).booleanValue() && (videoIntent = getVideoIntent()) != null) {
                arrayList.add(videoIntent);
            }
        }
        Intent fileChooserIntent = getFileChooserIntent(strArr, z);
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INTENT", fileChooserIntent);
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        if (intent.resolveActivity(getCurrentActivity().getPackageManager()) != null) {
            getCurrentActivity().startActivityForResult(intent, 1);
        } else {
            Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
        }
        return true;
    }
}