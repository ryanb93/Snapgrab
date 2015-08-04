// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

// Referenced classes of package com.ryanburke.snapgrab:
//            MainActivity

public class this._cls0 extends BaseAdapter
{

    final MainActivity this$0;

    public int getCount()
    {
        if (imageUrls == null)
        {
            return 0;
        } else
        {
            return imageUrls.length;
        }
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = (ImageView)getLayoutInflater().inflate(0x7f03001a, viewgroup, false);
        } else
        {
            view = (ImageView)view;
        }
        imageLoader.displayImage(imageUrls[i], view, options);
        return view;
    }

    public r()
    {
        this$0 = MainActivity.this;
        super();
    }
}
