// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.stericson.RootTools.RootTools;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ryanburke.snapgrab:
//            AbsListViewBaseActivity, ImagePagerActivity, FinderService

public class MainActivity extends AbsListViewBaseActivity
{
    public class ImageAdapter extends BaseAdapter
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

        public ImageAdapter()
        {
            this$0 = MainActivity.this;
            super();
        }
    }


    private static final String IMAGE_PATH = "/cache/received_image_snaps";
    String fileNames[];
    String imageUrls[];
    private boolean mBound;
    private ServiceConnection mConnection;
    private FinderService mService;
    DisplayImageOptions options;
    private String snapchatPath;
    private File snapgrabPath;

    public MainActivity()
    {
        snapchatPath = null;
        snapgrabPath = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/Snapgrab").toString());
        mBound = false;
        mConnection = new ServiceConnection() {

            final MainActivity this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                componentname = (FinderService.LocalBinder)ibinder;
                mService = componentname.getService();
                mBound = true;
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mBound = false;
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        };
    }

    private static void copyFile(File file, File file1)
        throws IOException
    {
        file = (new FileInputStream(file)).getChannel();
        file1 = (new FileOutputStream(file1)).getChannel();
        file.transferTo(0L, file.size(), file1);
        if (file != null)
        {
            file.close();
        }
        if (file1 != null)
        {
            file1.close();
        }
        return;
        Exception exception;
        exception;
        if (file != null)
        {
            file.close();
        }
        if (file1 != null)
        {
            file1.close();
        }
        throw exception;
    }

    private void getImages()
    {
        if (!(new File((new StringBuilder(String.valueOf(snapchatPath))).append("/cache/received_image_snaps").toString())).exists())
        {
            showToast("Snapchat folders not found.", 0);
            return;
        }
        Object obj;
        Object obj1;
        int j;
        obj = new ArrayList();
        ((ArrayList) (obj)).add("su");
        ((ArrayList) (obj)).add("-c");
        ((ArrayList) (obj)).add((new StringBuilder("chmod -R 777 ")).append(snapchatPath).toString());
        obj1 = Runtime.getRuntime().exec((String[])((ArrayList) (obj)).toArray(new String[0]));
        for (BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(((Process) (obj1)).getInputStream())); bufferedreader.readLine() != null;) { }
        ((Process) (obj1)).waitFor();
        obj1 = new File(snapgrabPath.getAbsolutePath().replace("file://", ""));
        if (!((File) (obj1)).exists())
        {
            ((File) (obj1)).mkdir();
        }
        obj1 = new File((new StringBuilder(String.valueOf(snapchatPath))).append("/cache/received_image_snaps").toString());
        if (((File) (obj1)).listFiles() == null)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        System.out.println("Using the new File method.");
        obj = ((File) (obj1)).listFiles();
        j = obj.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            File file;
            String s;
            try
            {
                if (((File) (obj1)).listFiles().length == 0)
                {
                    showToast("No images to import.", 0);
                    return;
                }
                break; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e("SU_Test", (new StringBuilder("Fail: ")).append(((IOException) (obj)).getMessage()).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((InterruptedException) (obj)).printStackTrace();
            }
            break MISSING_BLOCK_LABEL_366;
        }
        file = obj[i];
        s = (new StringBuilder(String.valueOf(snapgrabPath.getAbsolutePath()))).append("/").append(file.getName().replace(".nomedia", "")).toString();
        copyFile(file.getAbsoluteFile(), new File(s));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        showToast("Images imported.", 0);
        return;
        return;
        BufferedReader bufferedreader1;
        System.out.println("Using the old CP method.");
        obj1 = new ArrayList();
        ((ArrayList) (obj)).clear();
        ((ArrayList) (obj)).add("su");
        ((ArrayList) (obj)).add("-c");
        ((ArrayList) (obj)).add((new StringBuilder("ls ")).append(snapchatPath).append("/cache/received_image_snaps").toString());
        bufferedreader1 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String[])((ArrayList) (obj)).toArray(new String[0])).getInputStream()));
_L5:
        String s1 = bufferedreader1.readLine();
        if (s1 != null) goto _L4; else goto _L3
_L3:
        obj1 = ((List) (obj1)).iterator();
_L6:
        if (!((Iterator) (obj1)).hasNext())
        {
            refresh();
            return;
        }
        break MISSING_BLOCK_LABEL_511;
_L4:
        ((List) (obj1)).add(s1);
          goto _L5
        Object obj2 = (String)((Iterator) (obj1)).next();
        System.out.println((new StringBuilder(String.valueOf(snapchatPath))).append("/cache/received_image_snaps").append("/").append(((String) (obj2))).toString());
        ((ArrayList) (obj)).clear();
        ((ArrayList) (obj)).add("su");
        ((ArrayList) (obj)).add("-c");
        ((ArrayList) (obj)).add((new StringBuilder("cp ")).append(snapchatPath).append("/cache/received_image_snaps").append("/").append(((String) (obj2))).append(" ").append(snapgrabPath.getAbsolutePath()).append("/").append(((String) (obj2)).replace(".nomedia", "")).toString());
        obj2 = Runtime.getRuntime().exec((String[])((ArrayList) (obj)).toArray(new String[0]));
        for (BufferedReader bufferedreader2 = new BufferedReader(new InputStreamReader(((Process) (obj2)).getInputStream())); bufferedreader2.readLine() != null;) { }
        ((Process) (obj2)).waitFor();
          goto _L6
    }

    private void launchMarket()
    {
        String s = getPackageName();
        Intent intent;
        try
        {
            intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(s).toString()));
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            activitynotfoundexception = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://play.google.com/store/apps/details?id=")).append(s).toString()));
        }
        intent.addFlags(0x40080000);
        startActivity(intent);
    }

    private void refresh()
    {
        int i;
        if (!snapgrabPath.exists())
        {
            break MISSING_BLOCK_LABEL_139;
        }
        FilenameFilter filenamefilter = new FilenameFilter() {

            final MainActivity this$0;

            public boolean accept(File file, String s)
            {
                file = new File(file, s);
                return file.isFile() && !file.isHidden() && (file.getName().contains("jpg") || file.getName().contains("mp4"));
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        };
        if (!snapgrabPath.isDirectory())
        {
            snapgrabPath.delete();
            snapgrabPath.mkdir();
        }
        fileNames = snapgrabPath.list(filenamefilter);
        imageUrls = fileNames;
        i = 0;
_L3:
        if (i < imageUrls.length) goto _L2; else goto _L1
_L1:
        runOnUiThread(new Runnable() {

            final MainActivity this$0;

            public void run()
            {
                ((GridView)listView).setAdapter(new ImageAdapter());
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        return;
_L2:
        imageUrls[i] = (new StringBuilder("file://")).append(snapgrabPath.getAbsolutePath()).append("/").append(imageUrls[i]).toString();
        i++;
          goto _L3
        showToast("Cant create Snapgrab folder.", 1);
          goto _L1
    }

    private void showToast(final String finalMessage, final int finalLength)
    {
        runOnUiThread(new Runnable() {

            final MainActivity this$0;
            private final int val$finalLength;
            private final String val$finalMessage;

            public void run()
            {
                Toast toast = Toast.makeText(MainActivity.this, finalMessage, finalLength);
                toast.setGravity(17, 0, 0);
                toast.show();
            }

            
            {
                this$0 = MainActivity.this;
                finalMessage = s;
                finalLength = i;
                super();
            }
        });
    }

    private void startImagePagerActivity(int i)
    {
        Intent intent = new Intent(this, com/ryanburke/snapgrab/ImagePagerActivity);
        intent.putExtra("com.nostra13.example.universalimageloader.IMAGES", imageUrls);
        intent.putExtra("com.nostra13.example.universalimageloader.IMAGE_POSITION", i);
        startActivity(intent);
    }

    public void onCreate(final Bundle prefs)
    {
        super.onCreate(prefs);
        snapchatPath = (new StringBuilder(String.valueOf(getFilesDir().getParent().replace("com.ryanburke.snapgrab", "")))).append("com.snapchat.android").toString();
        if (RootTools.isAccessGiven()) goto _L2; else goto _L1
_L1:
        prefs = (new android.app.AlertDialog.Builder(this)).create();
        prefs.setTitle(0x7f09001e);
        prefs.setMessage(getText(0x7f09001f));
        prefs.setButton(-3, "Exit", new android.content.DialogInterface.OnClickListener() {

            final MainActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                finish();
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        prefs.show();
_L4:
        setContentView(0x7f030015);
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showStubImage(0x7f020087).showImageForEmptyUri(0x7f02007e).showImageOnFail(0x7f02008b).cacheInMemory().cacheOnDisc().bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        listView = (GridView)findViewById(0x7f040032);
        ((GridView)listView).setAdapter(new ImageAdapter());
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final MainActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                startImagePagerActivity(i);
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        listView.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() {

            final MainActivity this$0;

            public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (new android.app.AlertDialog.Builder(MainActivity.this)).create();
                if (imageUrls[i].contains("mp4"))
                {
                    adapterview.setMessage(getText(0x7f090023));
                } else
                {
                    adapterview.setMessage(getText(0x7f090023));
                }
                adapterview.setTitle(0x7f090022);
                adapterview.setIcon(0x7f020075);
                adapterview.setButton(-2, "No", null);
                adapterview.setButton(-1, "Yes", i. new android.content.DialogInterface.OnClickListener() {

                    final _cls5 this$1;
                    private final int val$pos;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface = fileNames[pos].replace("file://", "");
                        System.out.println(dialoginterface);
                        if ((new File(dialoginterface)).delete())
                        {
                            dialoginterface = Toast.makeText(_fld0, "Image deleted.", 0);
                        } else
                        {
                            dialoginterface = Toast.makeText(_fld0, "Image not deleted.", 0);
                        }
                        dialoginterface.setGravity(17, 0, 0);
                        dialoginterface.show();
                        refresh();
                    }

            
            {
                this$1 = final__pcls5;
                pos = I.this;
                super();
            }
                });
                adapterview.show();
                return false;
            }


            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        refresh();
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prefs.edit().putInt("runCounter", prefs.getInt("runCounter", 0) + 1).commit();
        if (prefs.getBoolean("firstRun", true))
        {
            prefs.edit().putBoolean("firstRun", false).commit();
            AlertDialog alertdialog = (new android.app.AlertDialog.Builder(this)).create();
            alertdialog.setTitle(0x7f090029);
            alertdialog.setMessage(getText(0x7f09002c));
            alertdialog.setButton(-2, "Close", null);
            alertdialog.show();
        }
        if (prefs.getInt("runCounter", 0) % 30 == 0 && prefs.getInt("runCounter", 0) != 0 && !prefs.getBoolean("rated", false))
        {
            AlertDialog alertdialog1 = (new android.app.AlertDialog.Builder(this)).create();
            alertdialog1.setTitle(0x7f090028);
            alertdialog1.setMessage(getText(0x7f09002a));
            alertdialog1.setButton(-2, "Close", null);
            alertdialog1.setButton(-1, getText(0x7f090028), new android.content.DialogInterface.OnClickListener() {

                final MainActivity this$0;
                private final SharedPreferences val$prefs;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    prefs.edit().putBoolean("rated", true).commit();
                    launchMarket();
                }

            
            {
                this$0 = MainActivity.this;
                prefs = sharedpreferences;
                super();
            }
            });
            alertdialog1.show();
        }
        return;
_L2:
        if (!(new File(snapchatPath)).exists())
        {
            prefs = (new android.app.AlertDialog.Builder(this)).create();
            prefs.setTitle(0x7f090020);
            prefs.setMessage(getText(0x7f090021));
            prefs.setButton(-3, "Exit", new android.content.DialogInterface.OnClickListener() {

                final MainActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    finish();
                }

            
            {
                this$0 = MainActivity.this;
                super();
            }
            });
            prefs.show();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        (new MenuInflater(this)).inflate(0x7f0b0001, menu);
        return true;
    }

    protected void onDestroy()
    {
        super.onStop();
        if (mBound)
        {
            unbindService(mConnection);
            mBound = false;
        }
    }

    public void onImportButtonPressed(View view)
    {
        getImages();
        refresh();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2130968647 2130968652: default 44
    //                   2130968647 50
    //                   2130968648 65
    //                   2130968649 131
    //                   2130968650 231
    //                   2130968651 181
    //                   2130968652 285;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        refresh();
        showToast("Refreshed", 0);
        continue; /* Loop/switch isn't completed */
_L3:
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(this)).create();
        alertdialog.setTitle("Delete All Images?");
        alertdialog.setIcon(0x7f020075);
        alertdialog.setMessage("Are you sure you want to delete all your images from the Snapgrab folder?");
        alertdialog.setButton(-1, "Yes", new android.content.DialogInterface.OnClickListener() {

            final MainActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = snapgrabPath.listFiles();
                int j = dialoginterface.length;
                i = 0;
                do
                {
                    if (i >= j)
                    {
                        refresh();
                        return;
                    }
                    dialoginterface[i].delete();
                    i++;
                } while (true);
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        alertdialog.setButton(-2, "No", null);
        alertdialog.show();
        continue; /* Loop/switch isn't completed */
_L4:
        AlertDialog alertdialog1 = (new android.app.AlertDialog.Builder(this)).create();
        alertdialog1.setTitle("Instructions");
        alertdialog1.setIcon(0x7f020077);
        alertdialog1.setMessage("1. Open the Snapchat application.\n\n2. Refresh chats but don't open new messages.\n\n3. Open Snapgrab\n\n4. Images can be saved without notifying sender.");
        alertdialog1.setButton(-3, "Okay", null);
        alertdialog1.show();
        continue; /* Loop/switch isn't completed */
_L6:
        AlertDialog alertdialog2 = (new android.app.AlertDialog.Builder(this)).create();
        alertdialog2.setTitle("About");
        alertdialog2.setIcon(0x7f020074);
        alertdialog2.setMessage("Created by Ryan Burke.\n\nPlease respect the privacy of others.\n\nWith great power comes great responsibility.\n\nUsing Universal Image Loader (c) 2011-2013, Sergey Tarasevich\n\nThe 'Snapchat' application as a whole and all rights, titles, and interests in and to the application are owned by the Snapchat, Inc.\n\nThis application is in no way affiliated with the Snapchat, Inc");
        alertdialog2.setButton(-3, "Okay", null);
        alertdialog2.show();
        continue; /* Loop/switch isn't completed */
_L5:
        AlertDialog alertdialog3 = (new android.app.AlertDialog.Builder(this)).create();
        alertdialog3.setTitle(0x7f090026);
        alertdialog3.setIcon(0x7f020077);
        alertdialog3.setMessage(getText(0x7f090024));
        alertdialog3.setButton(-3, "Okay", null);
        alertdialog3.show();
        continue; /* Loop/switch isn't completed */
_L7:
        launchMarket();
        if (true) goto _L1; else goto _L8
_L8:
    }

    public void onResume()
    {
        super.onResume();
        if (FinderService.RUNNING)
        {
            runOnUiThread(new Runnable() {

                final MainActivity this$0;

                public void run()
                {
                    Intent intent = new Intent(MainActivity.this, com/ryanburke/snapgrab/FinderService);
                    stopService(intent);
                    ((Button)findViewById(0x7f040033)).setText(0x7f090013);
                }

            
            {
                this$0 = MainActivity.this;
                super();
            }
            });
        }
    }

    public void onVideoCatcherPressed(View view)
    {
        Object obj = (Button)view;
        String s = ((Button) (obj)).getText().toString();
        view = new Intent(this, com/ryanburke/snapgrab/FinderService);
        bindService(view, mConnection, 1);
        if (s.contains("Start"))
        {
            ((Button) (obj)).setText(0x7f090014);
            obj = new Intent();
            ((Intent) (obj)).setClassName("com.snapchat.android", "com.snapchat.android.LandingPageActivity");
            try
            {
                startActivity(((Intent) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                stopService(view);
            }
            showToast("Snapchat application not installed.", 0);
            return;
        } else
        {
            ((Button) (obj)).setText(0x7f090013);
            unbindService(mConnection);
            mBound = false;
            return;
        }
    }






}
