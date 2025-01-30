package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isLocked;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Resources.Theme theme;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;
    private float sizeMultiplier = 1.0f;
    private DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
    private Priority priority = Priority.NORMAL;
    private boolean isCacheable = true;
    private int overrideHeight = -1;
    private int overrideWidth = -1;
    private Key signature = EmptySignature.obtain();
    private boolean isTransformationAllowed = true;
    private Options options = new Options();
    private Map<Class<?>, Transformation<?>> transformations = new CachedHashCodeArrayMap();
    private Class<?> resourceClass = Object.class;
    private boolean isScaleOnlyOrNoTransform = true;

    private boolean isSet(int i2) {
        return isSet(this.fields, i2);
    }

    private static boolean isSet(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    private T optionalScaleOnlyTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(downsampleStrategy, transformation, false);
    }

    private T scaleOnlyTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(downsampleStrategy, transformation, true);
    }

    private T self() {
        return this;
    }

    private T selfOrThrowIfLocked() {
        if (!this.isLocked) {
            return self();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public T apply(BaseRequestOptions<?> baseRequestOptions) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().apply(baseRequestOptions);
        }
        if (isSet(baseRequestOptions.fields, 2)) {
            this.sizeMultiplier = baseRequestOptions.sizeMultiplier;
        }
        if (isSet(baseRequestOptions.fields, 262144)) {
            this.useUnlimitedSourceGeneratorsPool = baseRequestOptions.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(baseRequestOptions.fields, 1048576)) {
            this.useAnimationPool = baseRequestOptions.useAnimationPool;
        }
        if (isSet(baseRequestOptions.fields, 4)) {
            this.diskCacheStrategy = baseRequestOptions.diskCacheStrategy;
        }
        if (isSet(baseRequestOptions.fields, 8)) {
            this.priority = baseRequestOptions.priority;
        }
        if (isSet(baseRequestOptions.fields, 16)) {
            this.errorPlaceholder = baseRequestOptions.errorPlaceholder;
            this.errorId = 0;
            this.fields &= -33;
        }
        if (isSet(baseRequestOptions.fields, 32)) {
            this.errorId = baseRequestOptions.errorId;
            this.errorPlaceholder = null;
            this.fields &= -17;
        }
        if (isSet(baseRequestOptions.fields, 64)) {
            this.placeholderDrawable = baseRequestOptions.placeholderDrawable;
            this.placeholderId = 0;
            this.fields &= -129;
        }
        if (isSet(baseRequestOptions.fields, 128)) {
            this.placeholderId = baseRequestOptions.placeholderId;
            this.placeholderDrawable = null;
            this.fields &= -65;
        }
        if (isSet(baseRequestOptions.fields, 256)) {
            this.isCacheable = baseRequestOptions.isCacheable;
        }
        if (isSet(baseRequestOptions.fields, 512)) {
            this.overrideWidth = baseRequestOptions.overrideWidth;
            this.overrideHeight = baseRequestOptions.overrideHeight;
        }
        if (isSet(baseRequestOptions.fields, 1024)) {
            this.signature = baseRequestOptions.signature;
        }
        if (isSet(baseRequestOptions.fields, 4096)) {
            this.resourceClass = baseRequestOptions.resourceClass;
        }
        if (isSet(baseRequestOptions.fields, 8192)) {
            this.fallbackDrawable = baseRequestOptions.fallbackDrawable;
            this.fallbackId = 0;
            this.fields &= -16385;
        }
        if (isSet(baseRequestOptions.fields, 16384)) {
            this.fallbackId = baseRequestOptions.fallbackId;
            this.fallbackDrawable = null;
            this.fields &= -8193;
        }
        if (isSet(baseRequestOptions.fields, 32768)) {
            this.theme = baseRequestOptions.theme;
        }
        if (isSet(baseRequestOptions.fields, 65536)) {
            this.isTransformationAllowed = baseRequestOptions.isTransformationAllowed;
        }
        if (isSet(baseRequestOptions.fields, 131072)) {
            this.isTransformationRequired = baseRequestOptions.isTransformationRequired;
        }
        if (isSet(baseRequestOptions.fields, 2048)) {
            this.transformations.putAll(baseRequestOptions.transformations);
            this.isScaleOnlyOrNoTransform = baseRequestOptions.isScaleOnlyOrNoTransform;
        }
        if (isSet(baseRequestOptions.fields, 524288)) {
            this.onlyRetrieveFromCache = baseRequestOptions.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            int i2 = this.fields & (-2049);
            this.fields = i2;
            this.isTransformationRequired = false;
            this.fields = i2 & (-131073);
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= baseRequestOptions.fields;
        this.options.putAll(baseRequestOptions.options);
        return selfOrThrowIfLocked();
    }

    public T autoClone() {
        if (this.isLocked && !this.isAutoCloneEnabled) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.isAutoCloneEnabled = true;
        return lock();
    }

    public T centerCrop() {
        return transform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    public T centerInside() {
        return scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public T circleCrop() {
        return transform(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    public T decode(Class<?> cls) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().decode(cls);
        }
        this.resourceClass = (Class) Preconditions.checkNotNull(cls);
        this.fields |= 4096;
        return selfOrThrowIfLocked();
    }

    public T disallowHardwareConfig() {
        return set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE);
    }

    public T diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().diskCacheStrategy(diskCacheStrategy);
        }
        this.diskCacheStrategy = (DiskCacheStrategy) Preconditions.checkNotNull(diskCacheStrategy);
        this.fields |= 4;
        return selfOrThrowIfLocked();
    }

    public T dontAnimate() {
        return set(GifOptions.DISABLE_ANIMATION, Boolean.TRUE);
    }

    public T dontTransform() {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().dontTransform();
        }
        this.transformations.clear();
        int i2 = this.fields & (-2049);
        this.fields = i2;
        this.isTransformationRequired = false;
        int i3 = i2 & (-131073);
        this.fields = i3;
        this.isTransformationAllowed = false;
        this.fields = i3 | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return selfOrThrowIfLocked();
    }

    public T downsample(DownsampleStrategy downsampleStrategy) {
        return set(DownsampleStrategy.OPTION, Preconditions.checkNotNull(downsampleStrategy));
    }

    public T encodeFormat(Bitmap.CompressFormat compressFormat) {
        return set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(compressFormat));
    }

    public T encodeQuality(int i2) {
        return set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof BaseRequestOptions) {
            BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
            return Float.compare(baseRequestOptions.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == baseRequestOptions.errorId && Util.bothNullOrEqual(this.errorPlaceholder, baseRequestOptions.errorPlaceholder) && this.placeholderId == baseRequestOptions.placeholderId && Util.bothNullOrEqual(this.placeholderDrawable, baseRequestOptions.placeholderDrawable) && this.fallbackId == baseRequestOptions.fallbackId && Util.bothNullOrEqual(this.fallbackDrawable, baseRequestOptions.fallbackDrawable) && this.isCacheable == baseRequestOptions.isCacheable && this.overrideHeight == baseRequestOptions.overrideHeight && this.overrideWidth == baseRequestOptions.overrideWidth && this.isTransformationRequired == baseRequestOptions.isTransformationRequired && this.isTransformationAllowed == baseRequestOptions.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == baseRequestOptions.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == baseRequestOptions.onlyRetrieveFromCache && this.diskCacheStrategy.equals(baseRequestOptions.diskCacheStrategy) && this.priority == baseRequestOptions.priority && this.options.equals(baseRequestOptions.options) && this.transformations.equals(baseRequestOptions.transformations) && this.resourceClass.equals(baseRequestOptions.resourceClass) && Util.bothNullOrEqual(this.signature, baseRequestOptions.signature) && Util.bothNullOrEqual(this.theme, baseRequestOptions.theme);
        }
        return false;
    }

    public T error(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        int i2 = this.fields | 16;
        this.fields = i2;
        this.errorId = 0;
        this.fields = i2 & (-33);
        return selfOrThrowIfLocked();
    }

    public T fallback(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        int i2 = this.fields | 8192;
        this.fields = i2;
        this.fallbackId = 0;
        this.fields = i2 & (-16385);
        return selfOrThrowIfLocked();
    }

    public T fitCenter() {
        return scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    public T format(DecodeFormat decodeFormat) {
        Preconditions.checkNotNull(decodeFormat);
        return (T) set(Downsampler.DECODE_FORMAT, decodeFormat).set(GifOptions.DECODE_FORMAT, decodeFormat);
    }

    public T frame(long j2) {
        return set(VideoDecoder.TARGET_FRAME, Long.valueOf(j2));
    }

    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    public final Key getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public int hashCode() {
        return Util.hashCode(this.theme, Util.hashCode(this.signature, Util.hashCode(this.resourceClass, Util.hashCode(this.transformations, Util.hashCode(this.options, Util.hashCode(this.priority, Util.hashCode(this.diskCacheStrategy, Util.hashCode(this.onlyRetrieveFromCache, Util.hashCode(this.useUnlimitedSourceGeneratorsPool, Util.hashCode(this.isTransformationAllowed, Util.hashCode(this.isTransformationRequired, Util.hashCode(this.overrideWidth, Util.hashCode(this.overrideHeight, Util.hashCode(this.isCacheable, Util.hashCode(this.fallbackDrawable, Util.hashCode(this.fallbackId, Util.hashCode(this.placeholderDrawable, Util.hashCode(this.placeholderId, Util.hashCode(this.errorPlaceholder, Util.hashCode(this.errorId, Util.hashCode(this.sizeMultiplier)))))))))))))))))))));
    }

    protected boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
    }

    public T lock() {
        this.isLocked = true;
        return self();
    }

    public T onlyRetrieveFromCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().onlyRetrieveFromCache(z);
        }
        this.onlyRetrieveFromCache = z;
        this.fields |= 524288;
        return selfOrThrowIfLocked();
    }

    public T optionalCenterCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    public T optionalCenterInside() {
        return optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public T optionalCircleCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    public T optionalFitCenter() {
        return optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    final T optionalTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().optionalTransform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation, false);
    }

    public T override(int i2, int i3) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().override(i2, i3);
        }
        this.overrideWidth = i2;
        this.overrideHeight = i3;
        this.fields |= 512;
        return selfOrThrowIfLocked();
    }

    public T placeholder(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        int i2 = this.fields | 64;
        this.fields = i2;
        this.placeholderId = 0;
        this.fields = i2 & (-129);
        return selfOrThrowIfLocked();
    }

    public T priority(Priority priority) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().priority(priority);
        }
        this.priority = (Priority) Preconditions.checkNotNull(priority);
        this.fields |= 8;
        return selfOrThrowIfLocked();
    }

    public <Y> T set(Option<Y> option, Y y) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().set(option, y);
        }
        Preconditions.checkNotNull(option);
        Preconditions.checkNotNull(y);
        this.options.set(option, y);
        return selfOrThrowIfLocked();
    }

    public T signature(Key key) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().signature(key);
        }
        this.signature = (Key) Preconditions.checkNotNull(key);
        this.fields |= 1024;
        return selfOrThrowIfLocked();
    }

    public T sizeMultiplier(float f2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().sizeMultiplier(f2);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.sizeMultiplier = f2;
            this.fields |= 2;
            return selfOrThrowIfLocked();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public T skipMemoryCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().skipMemoryCache(true);
        }
        this.isCacheable = !z;
        this.fields |= 256;
        return selfOrThrowIfLocked();
    }

    public T theme(Resources.Theme theme) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().theme(theme);
        }
        this.theme = theme;
        this.fields |= 32768;
        return selfOrThrowIfLocked();
    }

    public T timeout(int i2) {
        return set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i2));
    }

    final T transform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().transform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation);
    }

    @Deprecated
    public T transforms(Transformation<Bitmap>... transformationArr) {
        return transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
    }

    public T useAnimationPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().useAnimationPool(z);
        }
        this.useAnimationPool = z;
        this.fields |= 1048576;
        return selfOrThrowIfLocked();
    }

    public T useUnlimitedSourceGeneratorsPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().useUnlimitedSourceGeneratorsPool(z);
        }
        this.useUnlimitedSourceGeneratorsPool = z;
        this.fields |= 262144;
        return selfOrThrowIfLocked();
    }

    private T scaleOnlyTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation, boolean z) {
        T transform = z ? transform(downsampleStrategy, transformation) : optionalTransform(downsampleStrategy, transformation);
        transform.isScaleOnlyOrNoTransform = true;
        return transform;
    }

    @Override // 
    /* renamed from: clone */
    public T mo214clone() {
        try {
            T t = (T) super.clone();
            Options options = new Options();
            t.options = options;
            options.putAll(this.options);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.transformations = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.transformations);
            t.isLocked = false;
            t.isAutoCloneEnabled = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public T optionalTransform(Transformation<Bitmap> transformation) {
        return transform(transformation, false);
    }

    public T transform(Transformation<Bitmap> transformation) {
        return transform(transformation, true);
    }

    public <Y> T optionalTransform(Class<Y> cls, Transformation<Y> transformation) {
        return transform(cls, transformation, false);
    }

    public T transform(Transformation<Bitmap>... transformationArr) {
        if (transformationArr.length > 1) {
            return transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
        }
        if (transformationArr.length == 1) {
            return transform(transformationArr[0]);
        }
        return selfOrThrowIfLocked();
    }

    public T override(int i2) {
        return override(i2, i2);
    }

    public T error(int i2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().error(i2);
        }
        this.errorId = i2;
        int i3 = this.fields | 32;
        this.fields = i3;
        this.errorPlaceholder = null;
        this.fields = i3 & (-17);
        return selfOrThrowIfLocked();
    }

    public T fallback(int i2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().fallback(i2);
        }
        this.fallbackId = i2;
        int i3 = this.fields | 16384;
        this.fields = i3;
        this.fallbackDrawable = null;
        this.fields = i3 & (-8193);
        return selfOrThrowIfLocked();
    }

    public T placeholder(int i2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().placeholder(i2);
        }
        this.placeholderId = i2;
        int i3 = this.fields | 128;
        this.fields = i3;
        this.placeholderDrawable = null;
        this.fields = i3 & (-65);
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Multi-variable type inference failed */
    T transform(Transformation<Bitmap> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().transform(transformation, z);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
        transform(Bitmap.class, transformation, z);
        transform(Drawable.class, drawableTransformation, z);
        transform(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z);
        transform(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        return selfOrThrowIfLocked();
    }

    <Y> T transform(Class<Y> cls, Transformation<Y> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo214clone().transform(cls, transformation, z);
        }
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(transformation);
        this.transformations.put(cls, transformation);
        int i2 = this.fields | 2048;
        this.fields = i2;
        this.isTransformationAllowed = true;
        int i3 = i2 | 65536;
        this.fields = i3;
        this.isScaleOnlyOrNoTransform = false;
        if (z) {
            this.fields = i3 | 131072;
            this.isTransformationRequired = true;
        }
        return selfOrThrowIfLocked();
    }

    public <Y> T transform(Class<Y> cls, Transformation<Y> transformation) {
        return transform(cls, transformation, true);
    }
}