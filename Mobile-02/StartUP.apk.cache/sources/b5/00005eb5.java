package org.reactnative.camera;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import com.lwansbrough.RCTCamera.RCTCameraViewManager;
import e.f.m.p;
import java.util.Arrays;
import java.util.List;
import org.reactnative.facedetector.FaceDetectorModule;

/* compiled from: RNCameraPackage.java */
/* loaded from: classes3.dex */
public class c implements p {
    @Override // e.f.m.p
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RCTCameraModule(reactApplicationContext), new CameraModule(reactApplicationContext), new FaceDetectorModule(reactApplicationContext));
    }

    @Override // e.f.m.p
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RCTCameraViewManager(), new CameraViewManager());
    }
}