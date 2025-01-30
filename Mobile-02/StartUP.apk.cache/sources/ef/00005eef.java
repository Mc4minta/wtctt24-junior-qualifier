package org.reactnative.facedetector.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.vision.face.Face;
import java.io.File;
import java.io.IOException;
import org.reactnative.facedetector.b;

/* compiled from: FileFaceDetectionAsyncTask.java */
/* loaded from: classes3.dex */
public class a extends AsyncTask<Void, Void, SparseArray<Face>> {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f17756b;

    /* renamed from: c  reason: collision with root package name */
    private Promise f17757c;

    /* renamed from: f  reason: collision with root package name */
    private Context f17760f;

    /* renamed from: g  reason: collision with root package name */
    private ReadableMap f17761g;

    /* renamed from: i  reason: collision with root package name */
    private b f17763i;

    /* renamed from: d  reason: collision with root package name */
    private int f17758d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f17759e = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f17762h = 0;

    public a(Context context, ReadableMap readableMap, Promise promise) {
        this.a = readableMap.getString("uri");
        this.f17757c = promise;
        this.f17761g = readableMap;
        this.f17760f = context;
    }

    private static b a(ReadableMap readableMap, Context context) {
        b bVar = new b(context);
        bVar.i(false);
        if (readableMap.hasKey("mode")) {
            bVar.h(readableMap.getInt("mode"));
        }
        if (readableMap.hasKey("runClassifications")) {
            bVar.f(readableMap.getInt("runClassifications"));
        }
        if (readableMap.hasKey("detectLandmarks")) {
            bVar.g(readableMap.getInt("detectLandmarks"));
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public SparseArray<Face> doInBackground(Void... voidArr) {
        if (isCancelled()) {
            return null;
        }
        this.f17763i = a(this.f17761g, this.f17760f);
        Bitmap decodeFile = BitmapFactory.decodeFile(this.f17756b);
        this.f17758d = decodeFile.getWidth();
        this.f17759e = decodeFile.getHeight();
        try {
            this.f17762h = new ExifInterface(this.f17756b).getAttributeInt("Orientation", 0);
        } catch (IOException e2) {
            Log.e("E_FACE_DETECTION_FAILED", "Reading orientation from file `" + this.f17756b + "` failed.", e2);
        }
        return this.f17763i.b(k.b.b.b.a(decodeFile));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(SparseArray<Face> sparseArray) {
        super.onPostExecute(sparseArray);
        WritableMap createMap = Arguments.createMap();
        WritableArray createArray = Arguments.createArray();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            WritableMap f2 = org.reactnative.facedetector.a.f(sparseArray.valueAt(i2));
            f2.putDouble("yawAngle", ((-f2.getDouble("yawAngle")) + 360.0d) % 360.0d);
            f2.putDouble("rollAngle", ((-f2.getDouble("rollAngle")) + 360.0d) % 360.0d);
            createArray.pushMap(f2);
        }
        createMap.putArray("faces", createArray);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt("width", this.f17758d);
        createMap2.putInt("height", this.f17759e);
        createMap2.putInt("orientation", this.f17762h);
        createMap2.putString("uri", this.a);
        createMap.putMap("image", createMap2);
        this.f17763i.d();
        this.f17757c.resolve(createMap);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        String str = this.a;
        if (str == null) {
            this.f17757c.reject("E_FACE_DETECTION_FAILED", "You have to provide an URI of an image.");
            cancel(true);
            return;
        }
        String path = Uri.parse(str).getPath();
        this.f17756b = path;
        if (path == null) {
            Promise promise = this.f17757c;
            promise.reject("E_FACE_DETECTION_FAILED", "Invalid URI provided: `" + this.a + "`.");
            cancel(true);
            return;
        }
        if (!(path.startsWith(this.f17760f.getCacheDir().getPath()) || this.f17756b.startsWith(this.f17760f.getFilesDir().getPath()))) {
            this.f17757c.reject("E_FACE_DETECTION_FAILED", "The image has to be in the local app's directories.");
            cancel(true);
        } else if (new File(this.f17756b).exists()) {
        } else {
            Promise promise2 = this.f17757c;
            promise2.reject("E_FACE_DETECTION_FAILED", "The file does not exist. Given path: `" + this.f17756b + "`.");
            cancel(true);
        }
    }
}