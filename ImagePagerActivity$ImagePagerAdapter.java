// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import java.io.PrintStream;

// Referenced classes of package com.ryanburke.snapgrab:
//            ImagePagerActivity

private class inflater extends PagerAdapter
{

    private String images[];
    private LayoutInflater inflater;
    final ImagePagerActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        ((ViewPager)viewgroup).removeView((View)obj);
    }

    public void finishUpdate(View view)
    {
        supportInvalidateOptionsMenu();
    }

    public int getCount()
    {
        return images.length;
    }

    public Object instantiateItem(ViewGroup viewgroup, final int pos)
    {
        View view = inflater.inflate(0x7f03001b, viewgroup, false);
        ImageView imageview = (ImageView)view.findViewById(0x7f040038);
        final ProgressBar spinner = (ProgressBar)view.findViewById(0x7f040039);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final ImagePagerActivity.ImagePagerAdapter this$1;
            private final int val$pos;

            public void onClick(View view1)
            {
                if (ImagePagerActivity.access$2(this$0)[pos].contains("mp4"))
                {
                    view1 = new Intent();
                    view1.setAction("android.intent.action.VIEW");
                    view1.setDataAndType(Uri.parse(ImagePagerActivity.access$2(this$0)[pos]), "video/mp4");
                    startActivity(view1);
                }
            }

            
            {
                this$1 = ImagePagerActivity.ImagePagerAdapter.this;
                pos = i;
                super();
            }
        });
        System.out.println(images[pos]);
        String s = images[pos];
        System.out.println((new StringBuilder("Image path ")).append(s).toString());
        imageLoader.displayImage(images[pos], imageview, options, new SimpleImageLoadingListener() {

            private static int $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType[];
            final ImagePagerActivity.ImagePagerAdapter this$1;
            private final ProgressBar val$spinner;

            static int[] $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType()
            {
                int ai[] = $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType;
                if (ai != null)
                {
                    return ai;
                }
                ai = new int[com.nostra13.universalimageloader.core.assist.FailReason.FailType.values().length];
                try
                {
                    ai[com.nostra13.universalimageloader.core.assist.FailReason.FailType.DECODING_ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    ai[com.nostra13.universalimageloader.core.assist.FailReason.FailType.IO_ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    ai[com.nostra13.universalimageloader.core.assist.FailReason.FailType.NETWORK_DENIED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    ai[com.nostra13.universalimageloader.core.assist.FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    ai[com.nostra13.universalimageloader.core.assist.FailReason.FailType.UNKNOWN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType = ai;
                return ai;
            }

            public void onLoadingComplete(String s1, View view1, Bitmap bitmap)
            {
                spinner.setVisibility(8);
            }

            public void onLoadingFailed(String s1, View view1, FailReason failreason)
            {
                view1 = null;
                $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType()[failreason.getType().ordinal()];
                JVM INSTR tableswitch 1 5: default 48
            //                           1 82
            //                           2 88
            //                           3 94
            //                           4 100
            //                           5 106;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                if (!s1.contains("mp4"))
                {
                    Toast.makeText(this$0, view1, 0).show();
                }
                spinner.setVisibility(8);
                return;
_L2:
                view1 = "Input/Output error";
                continue; /* Loop/switch isn't completed */
_L3:
                view1 = "Image can't be decoded";
                continue; /* Loop/switch isn't completed */
_L4:
                view1 = "Downloads are denied";
                continue; /* Loop/switch isn't completed */
_L5:
                view1 = "Out Of Memory error";
                continue; /* Loop/switch isn't completed */
_L6:
                view1 = "Unknown error";
                if (true) goto _L1; else goto _L7
_L7:
            }

            public void onLoadingStarted(String s1, View view1)
            {
                spinner.setVisibility(0);
            }

            
            {
                this$1 = ImagePagerActivity.ImagePagerAdapter.this;
                spinner = progressbar;
                super();
            }
        });
        ((ViewPager)viewgroup).addView(view, 0);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view.equals(obj);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classloader)
    {
    }

    public Parcelable saveState()
    {
        return null;
    }

    public void startUpdate(View view)
    {
    }


    dingListener(String as[])
    {
        this$0 = ImagePagerActivity.this;
        super();
        images = as;
        inflater = getLayoutInflater();
    }
}
