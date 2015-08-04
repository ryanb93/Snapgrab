// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.util.Random;

public class FinderService extends Service
{
    public class LocalBinder extends Binder
    {

        final FinderService this$0;

        FinderService getService()
        {
            return FinderService.this;
        }

        public LocalBinder()
        {
            this$0 = FinderService.this;
            super();
        }
    }


    static boolean RUNNING = false;
    private boolean foundVideo;
    private Handler handler;
    private final IBinder mBinder = new LocalBinder();
    private final Random mGenerator = new Random();
    private String videoPath;

    public FinderService()
    {
        videoPath = null;
        foundVideo = false;
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

    public int getRandomNumber()
    {
        return mGenerator.nextInt(100);
    }

    public IBinder onBind(Intent intent)
    {
        intent = Toast.makeText(this, "Listening for videos.", 1);
        intent.setGravity(17, 0, 0);
        intent.show();
        (new Thread(new Runnable() {

            final FinderService this$0;

            public void run()
            {
                File file;
                String s;
                file = new File(videoPath);
                s = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/Snapgrab").toString();
_L5:
                if (foundVideo)
                {
                    return;
                }
                this;
                JVM INSTR monitorenter ;
                System.out.println("Looking for Snapchat Videos");
                if (!file.exists() || file.listFiles().length == 0) goto _L2; else goto _L1
_L1:
                File file1;
                File afile[];
                int j;
                file1 = new File(s);
                if (!file1.exists())
                {
                    file1.mkdir();
                }
                afile = file.listFiles();
                j = afile.length;
                int i = 0;
_L6:
                if (i < j) goto _L4; else goto _L3
_L3:
                foundVideo = true;
                System.out.println("Found video");
                handler.post(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "", 1);
                        if (foundVideo)
                        {
                            toast.setText("Video saved, go back to Snapgrab to view.");
                        } else
                        {
                            toast.setText("No video was found.");
                        }
                        toast.setGravity(17, 0, 0);
                        toast.show();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
_L2:
                Thread.sleep(1000L);
_L7:
                this;
                JVM INSTR monitorexit ;
                  goto _L5
                Exception exception;
                exception;
                this;
                JVM INSTR monitorexit ;
                throw exception;
_L4:
                File file2 = afile[i];
                String s1 = (new StringBuilder(String.valueOf(file1.getAbsolutePath()))).append("/").append(file2.getName().replace(".nomedia", "")).toString();
                FinderService.copyFile(file2.getAbsoluteFile(), new File(s1));
                i++;
                  goto _L6
                Exception exception1;
                exception1;
                  goto _L7
            }


            
            {
                this$0 = FinderService.this;
                super();
            }
        })).start();
        return mBinder;
    }

    public void onCreate()
    {
        handler = new Handler();
        videoPath = (new StringBuilder(String.valueOf(getApplication().getExternalCacheDir().getParent().replace("com.ryanburke.snapgrab", "")))).append("com.snapchat.android/cache/received_video_snaps").toString();
    }

    public void onDestroy()
    {
        super.onDestroy();
        handler.post(new Runnable() {

            final FinderService this$0;

            public void run()
            {
                Toast toast = Toast.makeText(getApplicationContext(), "", 1);
                if (foundVideo)
                {
                    toast.setText("Video was found.");
                } else
                {
                    toast.setText("No video was found.");
                }
                toast.setGravity(17, 0, 0);
                toast.show();
                foundVideo = true;
            }

            
            {
                this$0 = FinderService.this;
                super();
            }
        });
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        return 1;
    }






}
