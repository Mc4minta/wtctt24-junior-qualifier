package com.horcrux.svg;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Region;
import com.BV.LinearGradient.LinearGradientManager;
import com.appsflyer.share.Constants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
class RNSVGRenderableManager extends ReactContextBaseJavaModule {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RNSVGRenderableManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getBBox(int i2, ReadableMap readableMap) {
        b0 renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i2);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        boolean z = readableMap.getBoolean("fill");
        boolean z2 = readableMap.getBoolean("stroke");
        boolean z3 = readableMap.getBoolean("markers");
        boolean z4 = readableMap.getBoolean("clipped");
        try {
            renderableViewByTag.F(null, null);
            float f2 = renderableViewByTag.P;
            renderableViewByTag.R();
            RectF rectF = new RectF();
            RectF rectF2 = renderableViewByTag.l0;
            RectF rectF3 = renderableViewByTag.m0;
            RectF rectF4 = renderableViewByTag.n0;
            RectF rectF5 = renderableViewByTag.o0;
            if (z && rectF2 != null) {
                rectF.union(rectF2);
            }
            if (z2 && rectF3 != null) {
                rectF.union(rectF3);
            }
            if (z3 && rectF4 != null) {
                rectF.union(rectF4);
            }
            if (z4 && rectF5 != null) {
                rectF.intersect(rectF5);
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("x", rectF.left / f2);
            createMap.putDouble("y", rectF.top / f2);
            createMap.putDouble("width", rectF.width() / f2);
            createMap.putDouble("height", rectF.height() / f2);
            return createMap;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return Arguments.createMap();
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getCTM(int i2) {
        b0 renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i2);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        float f2 = renderableViewByTag.P;
        Matrix matrix = new Matrix(renderableViewByTag.z);
        matrix.preConcat(renderableViewByTag.getSvgView().O);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("a", fArr[0]);
        createMap.putDouble("b", fArr[3]);
        createMap.putDouble(Constants.URL_CAMPAIGN, fArr[1]);
        createMap.putDouble("d", fArr[4]);
        createMap.putDouble("e", fArr[2] / f2);
        createMap.putDouble("f", fArr[5] / f2);
        return createMap;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNSVGRenderableManager";
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getPointAtLength(int i2, ReadableMap readableMap) {
        b0 renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i2);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        try {
            PathMeasure pathMeasure = new PathMeasure(renderableViewByTag.F(null, null), false);
            float f2 = (float) readableMap.getDouble("length");
            float f3 = renderableViewByTag.P;
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            pathMeasure.getPosTan(Math.max(0.0f, Math.min(f2, pathMeasure.getLength())), fArr, fArr2);
            double atan2 = Math.atan2(fArr2[1], fArr2[0]);
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("x", fArr[0] / f3);
            createMap.putDouble("y", fArr[1] / f3);
            createMap.putDouble(LinearGradientManager.PROP_ANGLE, atan2);
            return createMap;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return Arguments.createMap();
        }
    }

    @ReactMethod
    public void getRawResource(String str, Promise promise) {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Resources resources = reactApplicationContext.getResources();
            InputStream openRawResource = resources.openRawResource(resources.getIdentifier(str, "raw", reactApplicationContext.getPackageName()));
            InputStreamReader inputStreamReader = new InputStreamReader(openRawResource, com.facebook.react.common.e.a);
            char[] cArr = new char[4096];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = inputStreamReader.read(cArr, 0, 4096);
                if (read != -1) {
                    sb.append(cArr, 0, read);
                } else {
                    promise.resolve(sb.toString());
                    try {
                        openRawResource.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            promise.reject(e2);
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getScreenCTM(int i2) {
        b0 renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i2);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        float[] fArr = new float[9];
        renderableViewByTag.z.getValues(fArr);
        float f2 = renderableViewByTag.P;
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("a", fArr[0]);
        createMap.putDouble("b", fArr[3]);
        createMap.putDouble(Constants.URL_CAMPAIGN, fArr[1]);
        createMap.putDouble("d", fArr[4]);
        createMap.putDouble("e", fArr[2] / f2);
        createMap.putDouble("f", fArr[5] / f2);
        return createMap;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public float getTotalLength(int i2) {
        b0 renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i2);
        if (renderableViewByTag == null) {
            return 0.0f;
        }
        try {
            return new PathMeasure(renderableViewByTag.F(null, null), false).getLength() / renderableViewByTag.P;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return -1.0f;
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean isPointInFill(int i2, ReadableMap readableMap) {
        b0 renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i2);
        if (renderableViewByTag == null) {
            return false;
        }
        float f2 = renderableViewByTag.P;
        return renderableViewByTag.G(new float[]{((float) readableMap.getDouble("x")) * f2, ((float) readableMap.getDouble("y")) * f2}) != -1;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean isPointInStroke(int i2, ReadableMap readableMap) {
        b0 renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i2);
        if (renderableViewByTag == null) {
            return false;
        }
        try {
            renderableViewByTag.F(null, null);
            renderableViewByTag.R();
            double d2 = renderableViewByTag.P;
            int i3 = (int) (readableMap.getDouble("x") * d2);
            int i4 = (int) (readableMap.getDouble("y") * d2);
            Region region = renderableViewByTag.r0;
            return region != null && region.contains(i3, i4);
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return false;
        }
    }
}