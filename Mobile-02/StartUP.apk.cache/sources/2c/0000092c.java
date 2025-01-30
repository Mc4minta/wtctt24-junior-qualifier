package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.BitmapTransitionFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* loaded from: classes.dex */
public final class BitmapTransitionOptions extends TransitionOptions<BitmapTransitionOptions, Bitmap> {
    public static BitmapTransitionOptions with(TransitionFactory<Bitmap> transitionFactory) {
        return new BitmapTransitionOptions().transition(transitionFactory);
    }

    public static BitmapTransitionOptions withCrossFade() {
        return new BitmapTransitionOptions().crossFade();
    }

    public static BitmapTransitionOptions withWrapped(TransitionFactory<Drawable> transitionFactory) {
        return new BitmapTransitionOptions().transitionUsing(transitionFactory);
    }

    public BitmapTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.Builder());
    }

    public BitmapTransitionOptions transitionUsing(TransitionFactory<Drawable> transitionFactory) {
        return transition(new BitmapTransitionFactory(transitionFactory));
    }

    public static BitmapTransitionOptions withCrossFade(int i2) {
        return new BitmapTransitionOptions().crossFade(i2);
    }

    public BitmapTransitionOptions crossFade(int i2) {
        return crossFade(new DrawableCrossFadeFactory.Builder(i2));
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new BitmapTransitionOptions().crossFade(drawableCrossFadeFactory);
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return transitionUsing(drawableCrossFadeFactory);
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory.Builder builder) {
        return new BitmapTransitionOptions().crossFade(builder);
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory.Builder builder) {
        return transitionUsing(builder.build());
    }
}