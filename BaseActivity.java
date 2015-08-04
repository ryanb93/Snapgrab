// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import com.actionbarsherlock.app.SherlockActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

public abstract class BaseActivity extends SherlockActivity
{

    protected ImageLoader imageLoader;

    public BaseActivity()
    {
        imageLoader = ImageLoader.getInstance();
    }
}
