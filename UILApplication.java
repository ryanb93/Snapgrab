// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.app.Application;
import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class UILApplication extends Application
{

    public UILApplication()
    {
    }

    public static void initImageLoader(Context context)
    {
        context = (new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(context)).threadPriority(3).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).enableLogging().build();
        ImageLoader.getInstance().init(context);
    }

    public void onCreate()
    {
        super.onCreate();
        initImageLoader(getApplicationContext());
    }
}
