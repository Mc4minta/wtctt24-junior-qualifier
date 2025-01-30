package org.reactnative.facedetector;

import android.graphics.PointF;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;

/* compiled from: FaceDetectorUtils.java */
/* loaded from: classes3.dex */
public class a {
    private static final String[] a = {"bottomMouthPosition", "leftCheekPosition", "leftEarPosition", "leftEarTipPosition", "leftEyePosition", "leftMouthPosition", "noseBasePosition", "rightCheekPosition", "rightEarPosition", "rightEarTipPosition", "rightEyePosition", "rightMouthPosition"};

    public static WritableMap a(WritableMap writableMap) {
        writableMap.putDouble("rollAngle", ((-writableMap.getDouble("rollAngle")) + 360.0d) % 360.0d);
        writableMap.putDouble("yawAngle", ((-writableMap.getDouble("yawAngle")) + 360.0d) % 360.0d);
        return writableMap;
    }

    public static WritableMap b(PointF pointF, double d2, double d3, int i2, int i3, int i4, int i5) {
        WritableMap createMap = Arguments.createMap();
        Float valueOf = Float.valueOf(pointF.x);
        Float valueOf2 = Float.valueOf(pointF.y);
        float f2 = pointF.x;
        float f3 = i2 / 2;
        if (f2 < f3) {
            valueOf.floatValue();
            int i6 = i4 / 2;
        } else if (f2 > f3) {
            valueOf.floatValue();
            int i7 = i4 / 2;
        }
        float f4 = pointF.y;
        float f5 = i3 / 2;
        if (f4 < f5) {
            valueOf2.floatValue();
            int i8 = i5 / 2;
        } else if (f4 > f5) {
            valueOf2.floatValue();
            int i9 = i5 / 2;
        }
        createMap.putDouble("x", pointF.x * d2);
        createMap.putDouble("y", pointF.y * d3);
        return createMap;
    }

    public static WritableMap c(ReadableMap readableMap, int i2, double d2) {
        WritableMap createMap = Arguments.createMap();
        createMap.merge(readableMap);
        createMap.putDouble("x", h(readableMap.getDouble("x"), i2, d2));
        return createMap;
    }

    public static WritableMap d(ReadableMap readableMap, double d2) {
        WritableMap createMap = Arguments.createMap();
        createMap.merge(readableMap);
        createMap.putDouble("x", readableMap.getDouble("x") + d2);
        return createMap;
    }

    public static WritableMap e(WritableMap writableMap, int i2, double d2) {
        String[] strArr;
        ReadableMap map = writableMap.getMap("bounds");
        WritableMap d3 = d(c(map.getMap("origin"), i2, d2), -map.getMap("size").getDouble("width"));
        WritableMap createMap = Arguments.createMap();
        createMap.merge(map);
        createMap.putMap("origin", d3);
        for (String str : a) {
            ReadableMap map2 = writableMap.hasKey(str) ? writableMap.getMap(str) : null;
            if (map2 != null) {
                writableMap.putMap(str, c(map2, i2, d2));
            }
        }
        writableMap.putMap("bounds", createMap);
        return writableMap;
    }

    public static WritableMap f(Face face) {
        return g(face, 1.0d, 1.0d, 0, 0, 0, 0);
    }

    public static WritableMap g(Face face, double d2, double d3, int i2, int i3, int i4, int i5) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("faceID", face.getId());
        createMap.putDouble("rollAngle", face.getEulerZ());
        createMap.putDouble("yawAngle", face.getEulerY());
        if (face.getIsSmilingProbability() >= 0.0f) {
            createMap.putDouble("smilingProbability", face.getIsSmilingProbability());
        }
        if (face.getIsLeftEyeOpenProbability() >= 0.0f) {
            createMap.putDouble("leftEyeOpenProbability", face.getIsLeftEyeOpenProbability());
        }
        if (face.getIsRightEyeOpenProbability() >= 0.0f) {
            createMap.putDouble("rightEyeOpenProbability", face.getIsRightEyeOpenProbability());
        }
        for (Landmark landmark : face.getLandmarks()) {
            createMap.putMap(a[landmark.getType()], b(landmark.getPosition(), d2, d3, i2, i3, i4, i5));
        }
        WritableMap createMap2 = Arguments.createMap();
        Float valueOf = Float.valueOf(face.getPosition().x);
        Float valueOf2 = Float.valueOf(face.getPosition().y);
        float f2 = i2 / 2;
        if (face.getPosition().x < f2) {
            valueOf = Float.valueOf(valueOf.floatValue() + (i4 / 2));
        } else if (face.getPosition().x > f2) {
            valueOf = Float.valueOf(valueOf.floatValue() - (i4 / 2));
        }
        float f3 = i3 / 2;
        if (face.getPosition().y < f3) {
            valueOf2 = Float.valueOf(valueOf2.floatValue() + (i5 / 2));
        } else if (face.getPosition().y > f3) {
            valueOf2 = Float.valueOf(valueOf2.floatValue() - (i5 / 2));
        }
        createMap2.putDouble("x", valueOf.floatValue() * d2);
        createMap2.putDouble("y", valueOf2.floatValue() * d3);
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putDouble("width", face.getWidth() * d2);
        createMap3.putDouble("height", face.getHeight() * d3);
        WritableMap createMap4 = Arguments.createMap();
        createMap4.putMap("origin", createMap2);
        createMap4.putMap("size", createMap3);
        createMap.putMap("bounds", createMap4);
        return createMap;
    }

    public static double h(double d2, int i2, double d3) {
        return (i2 - (d2 / d3)) * d3;
    }
}