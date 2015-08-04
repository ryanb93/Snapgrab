// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import java.io.File;
import java.io.PrintStream;

// Referenced classes of package com.ryanburke.snapgrab:
//            BaseActivity, SnapsendService, Shared

public class ImagePagerActivity extends BaseActivity
{
    private class ImagePagerAdapter extends PagerAdapter
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

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            View view = inflater.inflate(0x7f03001b, viewgroup, false);
            ImageView imageview = (ImageView)view.findViewById(0x7f040038);
            ProgressBar progressbar = (ProgressBar)view.findViewById(0x7f040039);
            view.setOnClickListener(i. new android.view.View.OnClickListener() {

                final ImagePagerAdapter this$1;
                private final int val$pos;

                public void onClick(View view)
                {
                    if (imageUrls[pos].contains("mp4"))
                    {
                        view = new Intent();
                        view.setAction("android.intent.action.VIEW");
                        view.setDataAndType(Uri.parse(imageUrls[pos]), "video/mp4");
                        startActivity(view);
                    }
                }

            
            {
                this$1 = final_imagepageradapter;
                pos = I.this;
                super();
            }
            });
            System.out.println(images[i]);
            String s = images[i];
            System.out.println((new StringBuilder("Image path ")).append(s).toString());
            imageLoader.displayImage(images[i], imageview, options, progressbar. new SimpleImageLoadingListener() {

                private static int $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType[];
                final ImagePagerAdapter this$1;
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

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    spinner.setVisibility(8);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    view = null;
                    $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType()[failreason.getType().ordinal()];
                    JVM INSTR tableswitch 1 5: default 48
                //                               1 82
                //                               2 88
                //                               3 94
                //                               4 100
                //                               5 106;
                       goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                    if (!s.contains("mp4"))
                    {
                        Toast.makeText(_fld0, view, 0).show();
                    }
                    spinner.setVisibility(8);
                    return;
_L2:
                    view = "Input/Output error";
                    continue; /* Loop/switch isn't completed */
_L3:
                    view = "Image can't be decoded";
                    continue; /* Loop/switch isn't completed */
_L4:
                    view = "Downloads are denied";
                    continue; /* Loop/switch isn't completed */
_L5:
                    view = "Out Of Memory error";
                    continue; /* Loop/switch isn't completed */
_L6:
                    view = "Unknown error";
                    if (true) goto _L1; else goto _L7
_L7:
                }

                public void onLoadingStarted(String s, View view)
                {
                    spinner.setVisibility(0);
                }

            
            {
                this$1 = final_imagepageradapter;
                spinner = ProgressBar.this;
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


        ImagePagerAdapter(String as[])
        {
            this$0 = ImagePagerActivity.this;
            super();
            images = as;
            inflater = getLayoutInflater();
        }
    }


    private static final String STATE_POSITION = "STATE_POSITION";
    private ImagePagerAdapter adapter;
    private String imageUrls[];
    private boolean mBound;
    private ServiceConnection mConnection;
    private SnapsendService mService;
    DisplayImageOptions options;
    ViewPager pager;
    int pagerPosition;

    public ImagePagerActivity()
    {
        mBound = false;
        mConnection = new ServiceConnection() {

            final ImagePagerActivity this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                componentname = (SnapsendService.LocalBinder)ibinder;
                mService = componentname.getService();
                mBound = true;
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mBound = false;
            }

            
            {
                this$0 = ImagePagerActivity.this;
                super();
            }
        };
    }

    private void forward(String s)
    {
        Intent intent = new Intent(this, com/ryanburke/snapgrab/SnapsendService);
        Shared.getInstance().setFile(s.replace("file://", ""));
        System.out.println(getApplicationContext().bindService(intent, mConnection, 1));
        s = new Intent();
        s.setClassName("com.snapchat.android", "com.snapchat.android.LandingPageActivity");
        try
        {
            startActivity(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            stopService(intent);
        }
        showToast("Snapchat application not installed.", 0);
    }

    private void showToast(final String finalMessage, final int finalLength)
    {
        runOnUiThread(new Runnable() {

            final ImagePagerActivity this$0;
            private final int val$finalLength;
            private final String val$finalMessage;

            public void run()
            {
                Toast toast = Toast.makeText(ImagePagerActivity.this, finalMessage, finalLength);
                toast.setGravity(17, 0, 0);
                toast.show();
            }

            
            {
                this$0 = ImagePagerActivity.this;
                finalMessage = s;
                finalLength = i;
                super();
            }
        });
    }

    public Uri addImage(File file)
    {
        Object obj = new ContentValues(3);
        ((ContentValues) (obj)).put("title", "Snapgrab Image");
        ((ContentValues) (obj)).put("mime_type", "image/jpeg");
        ((ContentValues) (obj)).put("_data", file.getAbsolutePath());
        obj = getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ((ContentValues) (obj)));
        sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse(file.getAbsolutePath())));
        return ((Uri) (obj));
    }

    public Uri addVideo(File file)
    {
        Object obj = new ContentValues(3);
        ((ContentValues) (obj)).put("title", "Snapgrab Video");
        ((ContentValues) (obj)).put("mime_type", "video/mp4");
        ((ContentValues) (obj)).put("_data", file.getAbsolutePath());
        obj = getContentResolver().insert(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, ((ContentValues) (obj)));
        sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse(file.getAbsolutePath())));
        return ((Uri) (obj));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030016);
        Bundle bundle1 = getIntent().getExtras();
        imageUrls = bundle1.getStringArray("com.nostra13.example.universalimageloader.IMAGES");
        pagerPosition = bundle1.getInt("com.nostra13.example.universalimageloader.IMAGE_POSITION", 0);
        if (bundle != null)
        {
            pagerPosition = bundle.getInt("STATE_POSITION");
        }
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f02007e).showImageOnFail(0x7f020089).resetViewBeforeLoading().cacheOnDisc().imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).displayer(new FadeInBitmapDisplayer(300)).build();
        pager = (ViewPager)findViewById(0x7f040035);
        adapter = new ImagePagerAdapter(imageUrls);
        pager.setAdapter(adapter);
        pager.setCurrentItem(pagerPosition);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuinflater = new MenuInflater(this);
        if (imageUrls[pager.getCurrentItem()].contains("mp4"))
        {
            menuinflater.inflate(0x7f0b0002, menu);
        } else
        {
            menuinflater.inflate(0x7f0b0000, menu);
        }
        return true;
    }

    protected void onDestroy()
    {
        super.onStop();
        if (mBound)
        {
            getApplicationContext().unbindService(mConnection);
            mBound = false;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 3: default 40
    //                   2130968645: 46
    //                   2130968646: 172
    //                   2130968653: 191;
           goto _L1 _L2 _L3 _L4
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        Object obj = imageUrls[pager.getCurrentItem()].replace("file://", "");
        if (((String) (obj)).contains("mp4"))
        {
            if (addVideo(new File(((String) (obj)))).toString() != null)
            {
                obj = Toast.makeText(this, "Video successfully saved to camera roll.", 1);
            } else
            {
                obj = Toast.makeText(this, "Video could not be saved.", 1);
            }
        } else
        if (addImage(new File(((String) (obj)))).toString() != null)
        {
            obj = Toast.makeText(this, "Image successfully saved to camera roll.", 1);
        } else
        {
            obj = Toast.makeText(this, "Image could not be saved.", 1);
        }
        ((Toast) (obj)).setGravity(17, 0, 0);
        ((Toast) (obj)).show();
        continue; /* Loop/switch isn't completed */
_L3:
        share(imageUrls[pager.getCurrentItem()]);
        continue; /* Loop/switch isn't completed */
_L4:
        forward(imageUrls[pager.getCurrentItem()]);
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onResume()
    {
        super.onResume();
        if (mBound)
        {
            getApplicationContext().unbindService(mConnection);
            mBound = false;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("STATE_POSITION", pager.getCurrentItem());
    }

    public void share(String s)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        String s1;
        if (s.contains("jpg"))
        {
            s1 = "image/png";
        } else
        {
            s1 = "video/mp4";
        }
        intent.setType(s1);
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(s));
        if (s.contains("jpg"))
        {
            s = "Image";
        } else
        {
            s = "Video";
        }
        startActivity(Intent.createChooser(intent, (new StringBuilder("Share your ")).append(s).append(" using").toString()));
    }



}
