package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class SVGImageView extends ImageView {
    private static Method setLayerTypeMethod;
    private RenderOptions renderOptions;
    private SVG svg;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LoadResourceTask extends AsyncTask<Integer, Integer, SVG> {
        private Context context;
        private int resourceId;

        LoadResourceTask(Context context, int i2) {
            this.context = context;
            this.resourceId = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public SVG doInBackground(Integer... numArr) {
            try {
                return SVG.getFromResource(this.context, this.resourceId);
            } catch (SVGParseException e2) {
                Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", Integer.valueOf(this.resourceId), e2.getMessage()));
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(SVG svg) {
            SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LoadURITask extends AsyncTask<InputStream, Integer, SVG> {
        private LoadURITask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public SVG doInBackground(InputStream... inputStreamArr) {
            try {
                try {
                    SVG fromInputStream = SVG.getFromInputStream(inputStreamArr[0]);
                    try {
                        inputStreamArr[0].close();
                    } catch (IOException unused) {
                    }
                    return fromInputStream;
                } catch (Throwable th) {
                    try {
                        inputStreamArr[0].close();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
            } catch (SVGParseException e2) {
                Log.e("SVGImageView", "Parse error loading URI: " + e2.getMessage());
                try {
                    inputStreamArr[0].close();
                    return null;
                } catch (IOException unused3) {
                    return null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(SVG svg) {
            SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    static {
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public SVGImageView(Context context) {
        super(context);
        this.svg = null;
        this.renderOptions = new RenderOptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRender() {
        SVG svg = this.svg;
        if (svg == null) {
            return;
        }
        Picture renderToPicture = svg.renderToPicture(this.renderOptions);
        setSoftwareLayerType();
        setImageDrawable(new PictureDrawable(renderToPicture));
    }

    private void init(AttributeSet attributeSet, int i2) {
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGImageView, i2, 0);
        try {
            String string = obtainStyledAttributes.getString(R.styleable.SVGImageView_css);
            if (string != null) {
                this.renderOptions.css(string);
            }
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SVGImageView_svg, -1);
            if (resourceId != -1) {
                setImageResource(resourceId);
                return;
            }
            String string2 = obtainStyledAttributes.getString(R.styleable.SVGImageView_svg);
            if (string2 != null) {
                if (internalSetImageURI(Uri.parse(string2))) {
                    return;
                }
                if (internalSetImageAsset(string2)) {
                    return;
                }
                setFromString(string2);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private boolean internalSetImageAsset(String str) {
        try {
            new LoadURITask().execute(getContext().getAssets().open(str));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private boolean internalSetImageURI(Uri uri) {
        try {
            new LoadURITask().execute(getContext().getContentResolver().openInputStream(uri));
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    private void setFromString(String str) {
        try {
            this.svg = SVG.getFromString(str);
            doRender();
        } catch (SVGParseException unused) {
            Log.e("SVGImageView", "Could not find SVG at: " + str);
        }
    }

    private void setSoftwareLayerType() {
        if (setLayerTypeMethod == null) {
            return;
        }
        try {
            setLayerTypeMethod.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
        } catch (Exception e2) {
            Log.w("SVGImageView", "Unexpected failure calling setLayerType", e2);
        }
    }

    public void setCSS(String str) {
        this.renderOptions.css(str);
        doRender();
    }

    public void setImageAsset(String str) {
        if (internalSetImageAsset(str)) {
            return;
        }
        Log.e("SVGImageView", "File not found: " + str);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        new LoadResourceTask(getContext(), i2).execute(new Integer[0]);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (internalSetImageURI(uri)) {
            return;
        }
        Log.e("SVGImageView", "File not found: " + uri);
    }

    public void setSVG(SVG svg) {
        if (svg != null) {
            this.svg = svg;
            doRender();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.svg = null;
        this.renderOptions = new RenderOptions();
        init(attributeSet, 0);
    }

    public void setSVG(SVG svg, String str) {
        if (svg != null) {
            this.svg = svg;
            this.renderOptions.css(str);
            doRender();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.svg = null;
        this.renderOptions = new RenderOptions();
        init(attributeSet, i2);
    }
}