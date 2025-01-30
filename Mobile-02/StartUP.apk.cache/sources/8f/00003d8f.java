package com.horcrux.svg;

import android.graphics.Matrix;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.caverock.androidsvg.SVGParser;
import com.coinbase.ApiConstants;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i;
import java.lang.reflect.Array;
import java.util.Locale;

/* loaded from: classes2.dex */
class RenderableViewManager extends ViewGroupManager<x0> {
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 5.0f;
    private static final double EPSILON = 1.0E-5d;
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private final String mClassName;
    private final e svgClass;
    private static final c sMatrixDecompositionContext = new c();
    private static final double[] sTransformDecompositionArray = new double[16];
    private static final SparseArray<b0> mTagToRenderableView = new SparseArray<>();
    private static final SparseArray<Runnable> mTagToRunnable = new SparseArray<>();

    /* loaded from: classes2.dex */
    static class CircleViewManager extends RenderableViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CircleViewManager() {
            super(e.RNSVGCircle, null);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, View view) {
            super.addEventEmitters(i0Var, (x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ com.facebook.react.uimanager.y createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ View createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
            return super.createViewInstance(i0Var);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ void onDropViewInstance(View view) {
            super.onDropViewInstance((x0) view);
        }

        @com.facebook.react.uimanager.c1.a(name = "cx")
        public void setCx(com.horcrux.svg.b bVar, Dynamic dynamic) {
            bVar.setCx(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "cy")
        public void setCy(com.horcrux.svg.b bVar, Dynamic dynamic) {
            bVar.setCy(dynamic);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
        @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            super.setOpacity((x0) view, f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "r")
        public void setR(com.horcrux.svg.b bVar, Dynamic dynamic) {
            bVar.setR(dynamic);
        }
    }

    /* loaded from: classes2.dex */
    static class ClipPathViewManager extends GroupViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ClipPathViewManager() {
            super(e.RNSVGClipPath);
        }
    }

    /* loaded from: classes2.dex */
    static class DefsViewManager extends RenderableViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public DefsViewManager() {
            super(e.RNSVGDefs, null);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, View view) {
            super.addEventEmitters(i0Var, (x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ com.facebook.react.uimanager.y createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ View createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
            return super.createViewInstance(i0Var);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ void onDropViewInstance(View view) {
            super.onDropViewInstance((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
        @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            super.setOpacity((x0) view, f2);
        }
    }

    /* loaded from: classes2.dex */
    static class EllipseViewManager extends RenderableViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EllipseViewManager() {
            super(e.RNSVGEllipse, null);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, View view) {
            super.addEventEmitters(i0Var, (x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ com.facebook.react.uimanager.y createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ View createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
            return super.createViewInstance(i0Var);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ void onDropViewInstance(View view) {
            super.onDropViewInstance((x0) view);
        }

        @com.facebook.react.uimanager.c1.a(name = "cx")
        public void setCx(g gVar, Dynamic dynamic) {
            gVar.setCx(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "cy")
        public void setCy(g gVar, Dynamic dynamic) {
            gVar.setCy(dynamic);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
        @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            super.setOpacity((x0) view, f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "rx")
        public void setRx(g gVar, Dynamic dynamic) {
            gVar.setRx(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "ry")
        public void setRy(g gVar, Dynamic dynamic) {
            gVar.setRy(dynamic);
        }
    }

    /* loaded from: classes2.dex */
    static class ForeignObjectManager extends GroupViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ForeignObjectManager() {
            super(e.RNSVGForeignObject);
        }

        @com.facebook.react.uimanager.c1.a(name = "height")
        public void setHeight(i iVar, Dynamic dynamic) {
            iVar.setHeight(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "width")
        public void setWidth(i iVar, Dynamic dynamic) {
            iVar.setWidth(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "x")
        public void setX(i iVar, Dynamic dynamic) {
            iVar.setX(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "y")
        public void setY(i iVar, Dynamic dynamic) {
            iVar.setY(dynamic);
        }
    }

    /* loaded from: classes2.dex */
    static class GroupViewManager extends RenderableViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public GroupViewManager() {
            super(e.RNSVGGroup, null);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, View view) {
            super.addEventEmitters(i0Var, (x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ com.facebook.react.uimanager.y createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ View createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
            return super.createViewInstance(i0Var);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ void onDropViewInstance(View view) {
            super.onDropViewInstance((x0) view);
        }

        @com.facebook.react.uimanager.c1.a(name = "font")
        public void setFont(l lVar, ReadableMap readableMap) {
            lVar.setFont(readableMap);
        }

        @com.facebook.react.uimanager.c1.a(name = "fontSize")
        public void setFontSize(l lVar, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i2 = b.a[dynamic.getType().ordinal()];
            if (i2 == 1) {
                javaOnlyMap.putDouble("fontSize", dynamic.asDouble());
            } else if (i2 != 2) {
                return;
            } else {
                javaOnlyMap.putString("fontSize", dynamic.asString());
            }
            lVar.setFont(javaOnlyMap);
        }

        @com.facebook.react.uimanager.c1.a(name = "fontWeight")
        public void setFontWeight(l lVar, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i2 = b.a[dynamic.getType().ordinal()];
            if (i2 == 1) {
                javaOnlyMap.putDouble("fontWeight", dynamic.asDouble());
            } else if (i2 != 2) {
                return;
            } else {
                javaOnlyMap.putString("fontWeight", dynamic.asString());
            }
            lVar.setFont(javaOnlyMap);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
        @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            super.setOpacity((x0) view, f2);
        }

        GroupViewManager(e eVar) {
            super(eVar, null);
        }
    }

    /* loaded from: classes2.dex */
    static class ImageViewManager extends RenderableViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ImageViewManager() {
            super(e.RNSVGImage, null);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, View view) {
            super.addEventEmitters(i0Var, (x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ com.facebook.react.uimanager.y createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ View createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
            return super.createViewInstance(i0Var);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ void onDropViewInstance(View view) {
            super.onDropViewInstance((x0) view);
        }

        @com.facebook.react.uimanager.c1.a(name = "align")
        public void setAlign(m mVar, String str) {
            mVar.setAlign(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "height")
        public void setHeight(m mVar, Dynamic dynamic) {
            mVar.setHeight(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "meetOrSlice")
        public void setMeetOrSlice(m mVar, int i2) {
            mVar.setMeetOrSlice(i2);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
        @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            super.setOpacity((x0) view, f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "src")
        public void setSrc(m mVar, ReadableMap readableMap) {
            mVar.setSrc(readableMap);
        }

        @com.facebook.react.uimanager.c1.a(name = "width")
        public void setWidth(m mVar, Dynamic dynamic) {
            mVar.setWidth(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "x")
        public void setX(m mVar, Dynamic dynamic) {
            mVar.setX(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "y")
        public void setY(m mVar, Dynamic dynamic) {
            mVar.setY(dynamic);
        }
    }

    /* loaded from: classes2.dex */
    static class LineViewManager extends RenderableViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public LineViewManager() {
            super(e.RNSVGLine, null);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, View view) {
            super.addEventEmitters(i0Var, (x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ com.facebook.react.uimanager.y createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ View createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
            return super.createViewInstance(i0Var);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ void onDropViewInstance(View view) {
            super.onDropViewInstance((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
        @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            super.setOpacity((x0) view, f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "x1")
        public void setX1(n nVar, Dynamic dynamic) {
            nVar.setX1(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "x2")
        public void setX2(n nVar, Dynamic dynamic) {
            nVar.setX2(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "y1")
        public void setY1(n nVar, Dynamic dynamic) {
            nVar.setY1(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "y2")
        public void setY2(n nVar, Dynamic dynamic) {
            nVar.setY2(dynamic);
        }
    }

    /* loaded from: classes2.dex */
    static class LinearGradientManager extends RenderableViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public LinearGradientManager() {
            super(e.RNSVGLinearGradient, null);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, View view) {
            super.addEventEmitters(i0Var, (x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ com.facebook.react.uimanager.y createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ View createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
            return super.createViewInstance(i0Var);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ void onDropViewInstance(View view) {
            super.onDropViewInstance((x0) view);
        }

        @com.facebook.react.uimanager.c1.a(name = "gradient")
        public void setGradient(o oVar, ReadableArray readableArray) {
            oVar.setGradient(readableArray);
        }

        @com.facebook.react.uimanager.c1.a(name = "gradientTransform")
        public void setGradientTransform(o oVar, ReadableArray readableArray) {
            oVar.setGradientTransform(readableArray);
        }

        @com.facebook.react.uimanager.c1.a(name = "gradientUnits")
        public void setGradientUnits(o oVar, int i2) {
            oVar.setGradientUnits(i2);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
        @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            super.setOpacity((x0) view, f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "x1")
        public void setX1(o oVar, Dynamic dynamic) {
            oVar.setX1(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "x2")
        public void setX2(o oVar, Dynamic dynamic) {
            oVar.setX2(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "y1")
        public void setY1(o oVar, Dynamic dynamic) {
            oVar.setY1(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "y2")
        public void setY2(o oVar, Dynamic dynamic) {
            oVar.setY2(dynamic);
        }
    }

    /* loaded from: classes2.dex */
    static class MarkerManager extends GroupViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public MarkerManager() {
            super(e.RNSVGMarker);
        }

        @com.facebook.react.uimanager.c1.a(name = "align")
        public void setAlign(p pVar, String str) {
            pVar.setAlign(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "markerHeight")
        public void setMarkerHeight(p pVar, Dynamic dynamic) {
            pVar.setMarkerHeight(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "markerUnits")
        public void setMarkerUnits(p pVar, String str) {
            pVar.setMarkerUnits(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "markerWidth")
        public void setMarkerWidth(p pVar, Dynamic dynamic) {
            pVar.setMarkerWidth(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "meetOrSlice")
        public void setMeetOrSlice(p pVar, int i2) {
            pVar.setMeetOrSlice(i2);
        }

        @com.facebook.react.uimanager.c1.a(name = "minX")
        public void setMinX(p pVar, float f2) {
            pVar.setMinX(f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "minY")
        public void setMinY(p pVar, float f2) {
            pVar.setMinY(f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "orient")
        public void setOrient(p pVar, String str) {
            pVar.setOrient(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "refX")
        public void setRefX(p pVar, Dynamic dynamic) {
            pVar.setRefX(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "refY")
        public void setRefY(p pVar, Dynamic dynamic) {
            pVar.setRefY(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "vbHeight")
        public void setVbHeight(p pVar, float f2) {
            pVar.setVbHeight(f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "vbWidth")
        public void setVbWidth(p pVar, float f2) {
            pVar.setVbWidth(f2);
        }
    }

    /* loaded from: classes2.dex */
    static class MaskManager extends GroupViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public MaskManager() {
            super(e.RNSVGMask);
        }

        @com.facebook.react.uimanager.c1.a(name = "height")
        public void setHeight(q qVar, Dynamic dynamic) {
            qVar.setHeight(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "maskContentUnits")
        public void setMaskContentUnits(q qVar, int i2) {
            qVar.setMaskContentUnits(i2);
        }

        @com.facebook.react.uimanager.c1.a(name = "maskTransform")
        public void setMaskTransform(q qVar, ReadableArray readableArray) {
            qVar.setMaskTransform(readableArray);
        }

        @com.facebook.react.uimanager.c1.a(name = "maskUnits")
        public void setMaskUnits(q qVar, int i2) {
            qVar.setMaskUnits(i2);
        }

        @com.facebook.react.uimanager.c1.a(name = "width")
        public void setWidth(q qVar, Dynamic dynamic) {
            qVar.setWidth(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "x")
        public void setX(q qVar, Dynamic dynamic) {
            qVar.setX(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "y")
        public void setY(q qVar, Dynamic dynamic) {
            qVar.setY(dynamic);
        }
    }

    /* loaded from: classes2.dex */
    static class PathViewManager extends RenderableViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public PathViewManager() {
            super(e.RNSVGPath, null);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, View view) {
            super.addEventEmitters(i0Var, (x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ com.facebook.react.uimanager.y createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ View createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
            return super.createViewInstance(i0Var);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ void onDropViewInstance(View view) {
            super.onDropViewInstance((x0) view);
        }

        @com.facebook.react.uimanager.c1.a(name = "d")
        public void setD(t tVar, String str) {
            tVar.setD(str);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
        @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            super.setOpacity((x0) view, f2);
        }
    }

    /* loaded from: classes2.dex */
    static class PatternManager extends GroupViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public PatternManager() {
            super(e.RNSVGPattern);
        }

        @com.facebook.react.uimanager.c1.a(name = "align")
        public void setAlign(u uVar, String str) {
            uVar.setAlign(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "height")
        public void setHeight(u uVar, Dynamic dynamic) {
            uVar.setHeight(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "meetOrSlice")
        public void setMeetOrSlice(u uVar, int i2) {
            uVar.setMeetOrSlice(i2);
        }

        @com.facebook.react.uimanager.c1.a(name = "minX")
        public void setMinX(u uVar, float f2) {
            uVar.setMinX(f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "minY")
        public void setMinY(u uVar, float f2) {
            uVar.setMinY(f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "patternContentUnits")
        public void setPatternContentUnits(u uVar, int i2) {
            uVar.setPatternContentUnits(i2);
        }

        @com.facebook.react.uimanager.c1.a(name = "patternTransform")
        public void setPatternTransform(u uVar, ReadableArray readableArray) {
            uVar.setPatternTransform(readableArray);
        }

        @com.facebook.react.uimanager.c1.a(name = "patternUnits")
        public void setPatternUnits(u uVar, int i2) {
            uVar.setPatternUnits(i2);
        }

        @com.facebook.react.uimanager.c1.a(name = "vbHeight")
        public void setVbHeight(u uVar, float f2) {
            uVar.setVbHeight(f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "vbWidth")
        public void setVbWidth(u uVar, float f2) {
            uVar.setVbWidth(f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "width")
        public void setWidth(u uVar, Dynamic dynamic) {
            uVar.setWidth(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "x")
        public void setX(u uVar, Dynamic dynamic) {
            uVar.setX(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "y")
        public void setY(u uVar, Dynamic dynamic) {
            uVar.setY(dynamic);
        }
    }

    /* loaded from: classes2.dex */
    static class RadialGradientManager extends RenderableViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public RadialGradientManager() {
            super(e.RNSVGRadialGradient, null);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, View view) {
            super.addEventEmitters(i0Var, (x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ com.facebook.react.uimanager.y createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ View createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
            return super.createViewInstance(i0Var);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ void onDropViewInstance(View view) {
            super.onDropViewInstance((x0) view);
        }

        @com.facebook.react.uimanager.c1.a(name = "cx")
        public void setCx(z zVar, Dynamic dynamic) {
            zVar.setCx(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "cy")
        public void setCy(z zVar, Dynamic dynamic) {
            zVar.setCy(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "fx")
        public void setFx(z zVar, Dynamic dynamic) {
            zVar.setFx(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "fy")
        public void setFy(z zVar, Dynamic dynamic) {
            zVar.setFy(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "gradient")
        public void setGradient(z zVar, ReadableArray readableArray) {
            zVar.setGradient(readableArray);
        }

        @com.facebook.react.uimanager.c1.a(name = "gradientTransform")
        public void setGradientTransform(z zVar, ReadableArray readableArray) {
            zVar.setGradientTransform(readableArray);
        }

        @com.facebook.react.uimanager.c1.a(name = "gradientUnits")
        public void setGradientUnits(z zVar, int i2) {
            zVar.setGradientUnits(i2);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
        @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            super.setOpacity((x0) view, f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "rx")
        public void setRx(z zVar, Dynamic dynamic) {
            zVar.setRx(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "ry")
        public void setRy(z zVar, Dynamic dynamic) {
            zVar.setRy(dynamic);
        }
    }

    /* loaded from: classes2.dex */
    static class RectViewManager extends RenderableViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public RectViewManager() {
            super(e.RNSVGRect, null);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, View view) {
            super.addEventEmitters(i0Var, (x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ com.facebook.react.uimanager.y createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ View createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
            return super.createViewInstance(i0Var);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ void onDropViewInstance(View view) {
            super.onDropViewInstance((x0) view);
        }

        @com.facebook.react.uimanager.c1.a(name = "height")
        public void setHeight(a0 a0Var, Dynamic dynamic) {
            a0Var.setHeight(dynamic);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
        @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            super.setOpacity((x0) view, f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "rx")
        public void setRx(a0 a0Var, Dynamic dynamic) {
            a0Var.setRx(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "ry")
        public void setRy(a0 a0Var, Dynamic dynamic) {
            a0Var.setRy(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "width")
        public void setWidth(a0 a0Var, Dynamic dynamic) {
            a0Var.setWidth(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "x")
        public void setX(a0 a0Var, Dynamic dynamic) {
            a0Var.setX(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "y")
        public void setY(a0 a0Var, Dynamic dynamic) {
            a0Var.setY(dynamic);
        }
    }

    /* loaded from: classes2.dex */
    static class SymbolManager extends GroupViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public SymbolManager() {
            super(e.RNSVGSymbol);
        }

        @com.facebook.react.uimanager.c1.a(name = "align")
        public void setAlign(g0 g0Var, String str) {
            g0Var.setAlign(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "meetOrSlice")
        public void setMeetOrSlice(g0 g0Var, int i2) {
            g0Var.setMeetOrSlice(i2);
        }

        @com.facebook.react.uimanager.c1.a(name = "minX")
        public void setMinX(g0 g0Var, float f2) {
            g0Var.setMinX(f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "minY")
        public void setMinY(g0 g0Var, float f2) {
            g0Var.setMinY(f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "vbHeight")
        public void setVbHeight(g0 g0Var, float f2) {
            g0Var.setVbHeight(f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "vbWidth")
        public void setVbWidth(g0 g0Var, float f2) {
            g0Var.setVbWidth(f2);
        }
    }

    /* loaded from: classes2.dex */
    static class TSpanViewManager extends TextViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public TSpanViewManager() {
            super(e.RNSVGTSpan);
        }

        @com.facebook.react.uimanager.c1.a(name = "content")
        public void setContent(h0 h0Var, String str) {
            h0Var.setContent(str);
        }
    }

    /* loaded from: classes2.dex */
    static class TextPathViewManager extends TextViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public TextPathViewManager() {
            super(e.RNSVGTextPath);
        }

        @com.facebook.react.uimanager.c1.a(name = SVGParser.XML_STYLESHEET_ATTR_HREF)
        public void setHref(i0 i0Var, String str) {
            i0Var.setHref(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "method")
        public void setMethod(i0 i0Var, String str) {
            i0Var.setMethod(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "midLine")
        public void setSharp(i0 i0Var, String str) {
            i0Var.setSharp(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "side")
        public void setSide(i0 i0Var, String str) {
            i0Var.setSide(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "spacing")
        public void setSpacing(i0 i0Var, String str) {
            i0Var.setSpacing(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "startOffset")
        public void setStartOffset(i0 i0Var, Dynamic dynamic) {
            i0Var.setStartOffset(dynamic);
        }
    }

    /* loaded from: classes2.dex */
    static class TextViewManager extends GroupViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public TextViewManager() {
            super(e.RNSVGText);
        }

        @com.facebook.react.uimanager.c1.a(name = "baselineShift")
        public void setBaselineShift(u0 u0Var, Dynamic dynamic) {
            u0Var.setBaselineShift(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "dx")
        public void setDeltaX(u0 u0Var, Dynamic dynamic) {
            u0Var.setDeltaX(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "dy")
        public void setDeltaY(u0 u0Var, Dynamic dynamic) {
            u0Var.setDeltaY(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "font")
        public void setFont(u0 u0Var, ReadableMap readableMap) {
            u0Var.setFont(readableMap);
        }

        @com.facebook.react.uimanager.c1.a(name = "inlineSize")
        public void setInlineSize(u0 u0Var, Dynamic dynamic) {
            u0Var.setInlineSize(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "lengthAdjust")
        public void setLengthAdjust(u0 u0Var, String str) {
            u0Var.setLengthAdjust(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "alignmentBaseline")
        public void setMethod(u0 u0Var, String str) {
            u0Var.setMethod(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "rotate")
        public void setRotate(u0 u0Var, Dynamic dynamic) {
            u0Var.setRotate(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "textLength")
        public void setTextLength(u0 u0Var, Dynamic dynamic) {
            u0Var.setTextLength(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "verticalAlign")
        public void setVerticalAlign(u0 u0Var, String str) {
            u0Var.setVerticalAlign(str);
        }

        @com.facebook.react.uimanager.c1.a(name = "x")
        public void setX(u0 u0Var, Dynamic dynamic) {
            u0Var.setPositionX(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "y")
        public void setY(u0 u0Var, Dynamic dynamic) {
            u0Var.setPositionY(dynamic);
        }

        TextViewManager(e eVar) {
            super(eVar);
        }
    }

    /* loaded from: classes2.dex */
    static class UseViewManager extends RenderableViewManager {
        /* JADX INFO: Access modifiers changed from: package-private */
        public UseViewManager() {
            super(e.RNSVGUse, null);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, View view) {
            super.addEventEmitters(i0Var, (x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ com.facebook.react.uimanager.y createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ View createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
            return super.createViewInstance(i0Var);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((x0) view);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.ViewManager
        public /* bridge */ /* synthetic */ void onDropViewInstance(View view) {
            super.onDropViewInstance((x0) view);
        }

        @com.facebook.react.uimanager.c1.a(name = "height")
        public void setHeight(v0 v0Var, Dynamic dynamic) {
            v0Var.setHeight(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = SVGParser.XML_STYLESHEET_ATTR_HREF)
        public void setHref(v0 v0Var, String str) {
            v0Var.setHref(str);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
        @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            super.setOpacity((x0) view, f2);
        }

        @com.facebook.react.uimanager.c1.a(name = "width")
        public void setWidth(v0 v0Var, Dynamic dynamic) {
            v0Var.setWidth(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "x")
        public void setX(v0 v0Var, Dynamic dynamic) {
            v0Var.setX(dynamic);
        }

        @com.facebook.react.uimanager.c1.a(name = "y")
        public void setY(v0 v0Var, Dynamic dynamic) {
            v0Var.setY(dynamic);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view instanceof x0) {
                RenderableViewManager.this.invalidateSvgView((x0) view);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view instanceof x0) {
                RenderableViewManager.this.invalidateSvgView((x0) view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f10180b;

        static {
            int[] iArr = new int[e.values().length];
            f10180b = iArr;
            try {
                iArr[e.RNSVGGroup.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10180b[e.RNSVGPath.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10180b[e.RNSVGCircle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10180b[e.RNSVGEllipse.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10180b[e.RNSVGLine.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10180b[e.RNSVGRect.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10180b[e.RNSVGText.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10180b[e.RNSVGTSpan.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10180b[e.RNSVGTextPath.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10180b[e.RNSVGImage.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10180b[e.RNSVGClipPath.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10180b[e.RNSVGDefs.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10180b[e.RNSVGUse.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f10180b[e.RNSVGSymbol.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f10180b[e.RNSVGLinearGradient.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f10180b[e.RNSVGRadialGradient.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f10180b[e.RNSVGPattern.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f10180b[e.RNSVGMask.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f10180b[e.RNSVGMarker.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f10180b[e.RNSVGForeignObject.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr2 = new int[ReadableType.values().length];
            a = iArr2;
            try {
                iArr2[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c extends i.a {

        /* renamed from: f  reason: collision with root package name */
        final double[] f10181f = new double[4];

        /* renamed from: g  reason: collision with root package name */
        final double[] f10182g = new double[3];

        /* renamed from: h  reason: collision with root package name */
        final double[] f10183h = new double[3];

        /* renamed from: i  reason: collision with root package name */
        final double[] f10184i = new double[3];

        /* renamed from: j  reason: collision with root package name */
        final double[] f10185j = new double[3];

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends com.facebook.react.uimanager.h {
        d() {
        }

        @com.facebook.react.uimanager.c1.b(names = {"alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "justifyContent", "overflow", "alignContent", "display", "position", "right", "top", "bottom", "left", "start", "end", "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd", "borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
        public void ignoreLayoutProps(int i2, Dynamic dynamic) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum e {
        RNSVGGroup,
        RNSVGPath,
        RNSVGText,
        RNSVGTSpan,
        RNSVGTextPath,
        RNSVGImage,
        RNSVGCircle,
        RNSVGEllipse,
        RNSVGLine,
        RNSVGRect,
        RNSVGClipPath,
        RNSVGDefs,
        RNSVGUse,
        RNSVGSymbol,
        RNSVGLinearGradient,
        RNSVGRadialGradient,
        RNSVGPattern,
        RNSVGMask,
        RNSVGMarker,
        RNSVGForeignObject
    }

    /* synthetic */ RenderableViewManager(e eVar, a aVar) {
        this(eVar);
    }

    private static void decomposeMatrix() {
        c cVar = sMatrixDecompositionContext;
        double[] dArr = cVar.f10181f;
        double[] dArr2 = cVar.f10182g;
        double[] dArr3 = cVar.f10183h;
        double[] dArr4 = cVar.f10184i;
        double[] dArr5 = cVar.f10185j;
        if (isZero(sTransformDecompositionArray[15])) {
            return;
        }
        double[][] dArr6 = (double[][]) Array.newInstance(double.class, 4, 4);
        double[] dArr7 = new double[16];
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                double[] dArr8 = sTransformDecompositionArray;
                int i4 = (i2 * 4) + i3;
                double d2 = dArr8[i4] / dArr8[15];
                dArr6[i2][i3] = d2;
                if (i3 == 3) {
                    d2 = 0.0d;
                }
                dArr7[i4] = d2;
            }
        }
        dArr7[15] = 1.0d;
        if (isZero(com.facebook.react.uimanager.i.m(dArr7))) {
            return;
        }
        if (isZero(dArr6[0][3]) && isZero(dArr6[1][3]) && isZero(dArr6[2][3])) {
            dArr[2] = 0.0d;
            dArr[1] = 0.0d;
            dArr[0] = 0.0d;
            dArr[3] = 1.0d;
        } else {
            com.facebook.react.uimanager.i.q(new double[]{dArr6[0][3], dArr6[1][3], dArr6[2][3], dArr6[3][3]}, com.facebook.react.uimanager.i.t(com.facebook.react.uimanager.i.n(dArr7)), dArr);
        }
        System.arraycopy(dArr6[3], 0, dArr4, 0, 3);
        double[][] dArr9 = (double[][]) Array.newInstance(double.class, 3, 3);
        for (int i5 = 0; i5 < 3; i5++) {
            dArr9[i5][0] = dArr6[i5][0];
            dArr9[i5][1] = dArr6[i5][1];
            dArr9[i5][2] = dArr6[i5][2];
        }
        dArr2[0] = com.facebook.react.uimanager.i.x(dArr9[0]);
        dArr9[0] = com.facebook.react.uimanager.i.y(dArr9[0], dArr2[0]);
        dArr3[0] = com.facebook.react.uimanager.i.w(dArr9[0], dArr9[1]);
        dArr9[1] = com.facebook.react.uimanager.i.u(dArr9[1], dArr9[0], 1.0d, -dArr3[0]);
        dArr3[0] = com.facebook.react.uimanager.i.w(dArr9[0], dArr9[1]);
        dArr9[1] = com.facebook.react.uimanager.i.u(dArr9[1], dArr9[0], 1.0d, -dArr3[0]);
        dArr2[1] = com.facebook.react.uimanager.i.x(dArr9[1]);
        dArr9[1] = com.facebook.react.uimanager.i.y(dArr9[1], dArr2[1]);
        dArr3[0] = dArr3[0] / dArr2[1];
        dArr3[1] = com.facebook.react.uimanager.i.w(dArr9[0], dArr9[2]);
        dArr9[2] = com.facebook.react.uimanager.i.u(dArr9[2], dArr9[0], 1.0d, -dArr3[1]);
        dArr3[2] = com.facebook.react.uimanager.i.w(dArr9[1], dArr9[2]);
        dArr9[2] = com.facebook.react.uimanager.i.u(dArr9[2], dArr9[1], 1.0d, -dArr3[2]);
        dArr2[2] = com.facebook.react.uimanager.i.x(dArr9[2]);
        dArr9[2] = com.facebook.react.uimanager.i.y(dArr9[2], dArr2[2]);
        dArr3[1] = dArr3[1] / dArr2[2];
        dArr3[2] = dArr3[2] / dArr2[2];
        if (com.facebook.react.uimanager.i.w(dArr9[0], com.facebook.react.uimanager.i.v(dArr9[1], dArr9[2])) < 0.0d) {
            for (int i6 = 0; i6 < 3; i6++) {
                dArr2[i6] = dArr2[i6] * (-1.0d);
                double[] dArr10 = dArr9[i6];
                dArr10[0] = dArr10[0] * (-1.0d);
                double[] dArr11 = dArr9[i6];
                dArr11[1] = dArr11[1] * (-1.0d);
                double[] dArr12 = dArr9[i6];
                dArr12[2] = dArr12[2] * (-1.0d);
            }
        }
        dArr5[0] = com.facebook.react.uimanager.i.s((-Math.atan2(dArr9[2][1], dArr9[2][2])) * 57.29577951308232d);
        dArr5[1] = com.facebook.react.uimanager.i.s((-Math.atan2(-dArr9[2][0], Math.sqrt((dArr9[2][1] * dArr9[2][1]) + (dArr9[2][2] * dArr9[2][2])))) * 57.29577951308232d);
        dArr5[2] = com.facebook.react.uimanager.i.s((-Math.atan2(dArr9[1][0], dArr9[0][0])) * 57.29577951308232d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b0 getRenderableViewByTag(int i2) {
        return mTagToRenderableView.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateSvgView(x0 x0Var) {
        f0 svgView = x0Var.getSvgView();
        if (svgView != null) {
            svgView.invalidate();
        }
        if (x0Var instanceof u0) {
            ((u0) x0Var).n0().z();
        }
    }

    private static boolean isZero(double d2) {
        return !Double.isNaN(d2) && Math.abs(d2) < EPSILON;
    }

    private static void resetTransformProperty(View view) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(0.0f);
    }

    static void runWhenViewIsAvailable(int i2, Runnable runnable) {
        mTagToRunnable.put(i2, runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setRenderableView(int i2, b0 b0Var) {
        mTagToRenderableView.put(i2, b0Var);
        SparseArray<Runnable> sparseArray = mTagToRunnable;
        Runnable runnable = sparseArray.get(i2);
        if (runnable != null) {
            runnable.run();
            sparseArray.delete(i2);
        }
    }

    private static void setTransformProperty(View view, ReadableArray readableArray) {
        com.facebook.react.uimanager.k0.b(readableArray, sTransformDecompositionArray);
        decomposeMatrix();
        c cVar = sMatrixDecompositionContext;
        view.setTranslationX(com.facebook.react.uimanager.o.c((float) cVar.f10184i[0]));
        view.setTranslationY(com.facebook.react.uimanager.o.c((float) cVar.f10184i[1]));
        view.setRotation((float) cVar.f10185j[2]);
        view.setRotationX((float) cVar.f10185j[0]);
        view.setRotationY((float) cVar.f10185j[1]);
        view.setScaleX((float) cVar.f10182g[0]);
        view.setScaleY((float) cVar.f10182g[1]);
        double[] dArr = cVar.f10181f;
        if (dArr.length > 2) {
            float f2 = (float) dArr[2];
            if (f2 == 0.0f) {
                f2 = 7.8125E-4f;
            }
            float f3 = (-1.0f) / f2;
            float f4 = com.facebook.react.uimanager.c.e().density;
            view.setCameraDistance(f4 * f4 * f3 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return this.mClassName;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public Class<d> getShadowNodeClass() {
        return d.class;
    }

    @com.facebook.react.uimanager.c1.a(name = "clipPath")
    public void setClipPath(x0 x0Var, String str) {
        x0Var.setClipPath(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "clipRule")
    public void setClipRule(x0 x0Var, int i2) {
        x0Var.setClipRule(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "display")
    public void setDisplay(x0 x0Var, String str) {
        x0Var.setDisplay(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "fill")
    public void setFill(b0 b0Var, Dynamic dynamic) {
        b0Var.setFill(dynamic);
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(b0 b0Var, float f2) {
        b0Var.setFillOpacity(f2);
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 1, name = "fillRule")
    public void setFillRule(b0 b0Var, int i2) {
        b0Var.setFillRule(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "markerEnd")
    public void setMarkerEnd(x0 x0Var, String str) {
        x0Var.setMarkerEnd(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "markerMid")
    public void setMarkerMid(x0 x0Var, String str) {
        x0Var.setMarkerMid(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "markerStart")
    public void setMarkerStart(x0 x0Var, String str) {
        x0Var.setMarkerStart(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "mask")
    public void setMask(x0 x0Var, String str) {
        x0Var.setMask(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "matrix")
    public void setMatrix(x0 x0Var, Dynamic dynamic) {
        x0Var.setMatrix(dynamic);
    }

    @com.facebook.react.uimanager.c1.a(name = ApiConstants.NAME)
    public void setName(x0 x0Var, String str) {
        x0Var.setName(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "onLayout")
    public void setOnLayout(x0 x0Var, boolean z) {
        x0Var.setOnLayout(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "pointerEvents")
    public void setPointerEvents(x0 x0Var, String str) {
        if (str == null) {
            x0Var.setPointerEvents(com.facebook.react.uimanager.p.AUTO);
        } else {
            x0Var.setPointerEvents(com.facebook.react.uimanager.p.valueOf(str.toUpperCase(Locale.US).replace("-", "_")));
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "propList")
    public void setPropList(b0 b0Var, ReadableArray readableArray) {
        b0Var.setPropList(readableArray);
    }

    @com.facebook.react.uimanager.c1.a(name = "responsible")
    public void setResponsible(x0 x0Var, boolean z) {
        x0Var.setResponsible(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "stroke")
    public void setStroke(b0 b0Var, Dynamic dynamic) {
        b0Var.setStroke(dynamic);
    }

    @com.facebook.react.uimanager.c1.a(name = "strokeDasharray")
    public void setStrokeDasharray(b0 b0Var, ReadableArray readableArray) {
        b0Var.setStrokeDasharray(readableArray);
    }

    @com.facebook.react.uimanager.c1.a(name = "strokeDashoffset")
    public void setStrokeDashoffset(b0 b0Var, float f2) {
        b0Var.setStrokeDashoffset(f2);
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(b0 b0Var, int i2) {
        b0Var.setStrokeLinecap(i2);
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(b0 b0Var, int i2) {
        b0Var.setStrokeLinejoin(i2);
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(b0 b0Var, float f2) {
        b0Var.setStrokeMiterlimit(f2);
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(b0 b0Var, float f2) {
        b0Var.setStrokeOpacity(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "strokeWidth")
    public void setStrokeWidth(b0 b0Var, Dynamic dynamic) {
        b0Var.setStrokeWidth(dynamic);
    }

    @com.facebook.react.uimanager.c1.a(name = "transform")
    public void setTransform(x0 x0Var, Dynamic dynamic) {
        if (dynamic.getType() != ReadableType.Array) {
            return;
        }
        ReadableArray asArray = dynamic.asArray();
        if (asArray == null) {
            resetTransformProperty(x0Var);
        } else {
            setTransformProperty(x0Var, asArray);
        }
        Matrix matrix = x0Var.getMatrix();
        x0Var.B = matrix;
        x0Var.H = matrix.invert(x0Var.E);
    }

    @com.facebook.react.uimanager.c1.a(name = "vectorEffect")
    public void setVectorEffect(b0 b0Var, int i2) {
        b0Var.setVectorEffect(i2);
    }

    private RenderableViewManager(e eVar) {
        this.svgClass = eVar;
        this.mClassName = eVar.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(com.facebook.react.uimanager.i0 i0Var, x0 x0Var) {
        super.addEventEmitters(i0Var, (com.facebook.react.uimanager.i0) x0Var);
        x0Var.setOnHierarchyChangeListener(new a());
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public com.facebook.react.uimanager.h createShadowNodeInstance() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public x0 createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
        switch (b.f10180b[this.svgClass.ordinal()]) {
            case 1:
                return new l(i0Var);
            case 2:
                return new t(i0Var);
            case 3:
                return new com.horcrux.svg.b(i0Var);
            case 4:
                return new g(i0Var);
            case 5:
                return new n(i0Var);
            case 6:
                return new a0(i0Var);
            case 7:
                return new u0(i0Var);
            case 8:
                return new h0(i0Var);
            case 9:
                return new i0(i0Var);
            case 10:
                return new m(i0Var);
            case 11:
                return new com.horcrux.svg.c(i0Var);
            case 12:
                return new com.horcrux.svg.e(i0Var);
            case 13:
                return new v0(i0Var);
            case 14:
                return new g0(i0Var);
            case 15:
                return new o(i0Var);
            case 16:
                return new z(i0Var);
            case 17:
                return new u(i0Var);
            case 18:
                return new q(i0Var);
            case 19:
                return new p(i0Var);
            case 20:
                return new i(i0Var);
            default:
                throw new IllegalStateException("Unexpected type " + this.svgClass.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(x0 x0Var) {
        super.onAfterUpdateTransaction((RenderableViewManager) x0Var);
        invalidateSvgView(x0Var);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(x0 x0Var) {
        super.onDropViewInstance((RenderableViewManager) x0Var);
        mTagToRenderableView.remove(x0Var.getId());
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(x0 x0Var, float f2) {
        x0Var.setOpacity(f2);
    }
}