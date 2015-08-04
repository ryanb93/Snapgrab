// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.os.Bundle;
import android.widget.AbsListView;
import com.nostra13.universalimageloader.core.assist.PauseOnScrollListener;

// Referenced classes of package com.ryanburke.snapgrab:
//            BaseActivity

public class AbsListViewBaseActivity extends BaseActivity
{

    protected static final String STATE_PAUSE_ON_FLING = "STATE_PAUSE_ON_FLING";
    protected static final String STATE_PAUSE_ON_SCROLL = "STATE_PAUSE_ON_SCROLL";
    protected AbsListView listView;
    protected boolean pauseOnFling;
    protected boolean pauseOnScroll;

    public AbsListViewBaseActivity()
    {
        pauseOnScroll = false;
        pauseOnFling = true;
    }

    private void applyScrollListener()
    {
        listView.setOnScrollListener(new PauseOnScrollListener(imageLoader, pauseOnScroll, pauseOnFling));
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        pauseOnScroll = bundle.getBoolean("STATE_PAUSE_ON_SCROLL", false);
        pauseOnFling = bundle.getBoolean("STATE_PAUSE_ON_FLING", true);
    }

    public void onResume()
    {
        super.onResume();
        applyScrollListener();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("STATE_PAUSE_ON_SCROLL", pauseOnScroll);
        bundle.putBoolean("STATE_PAUSE_ON_FLING", pauseOnFling);
    }
}
