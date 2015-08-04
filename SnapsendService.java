// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
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

// Referenced classes of package com.ryanburke.snapgrab:
//            Shared

public class SnapsendService extends Service
{
    public class LocalBinder extends Binder
    {

        final SnapsendService this$0;

        SnapsendService getService()
        {
            return SnapsendService.this;
        }

        public LocalBinder()
        {
            this$0 = SnapsendService.this;
            super();
        }
    }


    static boolean RUNNING = false;
    private boolean foundVideo;
    private Handler handler;
    private final IBinder mBinder = new LocalBinder();
    private final Random mGenerator = new Random();
    private String replacePath;
    private Thread thread;
    private String videoPath;

    public SnapsendService()
    {
        videoPath = null;
        replacePath = null;
        foundVideo = false;
        thread = null;
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
        System.out.println("ONBIND");
        intent = Toast.makeText(this, "Hold down the record button.", 1);
        intent.setGravity(17, 0, 0);
        intent.show();
        replacePath = Shared.getInstance().getFile();
        if (thread == null)
        {
            thread = new Thread(new Runnable() {

                final SnapsendService this$0;

                public void run()
                {
                    File file = new File(videoPath);
_L2:
                    if (foundVideo)
                    {
                        return;
                    }
                    System.out.println("in loop");
                    this;
                    JVM INSTR monitorenter ;
                    System.out.println("Looking for Snapchat Videos");
                    Exception exception;
                    try
                    {
                        if (file.exists() && file.listFiles().length != 0)
                        {
                            System.out.println("Found video");
                            foundVideo = true;
                            System.out.println("Found video = true");
                            File file1 = file.listFiles()[0];
                            System.out.println("original created");
                            System.out.println((new StringBuilder("recplace path = ")).append(replacePath).toString());
                            File file2 = new File(replacePath);
                            System.out.println("replace created");
                            System.out.println(file1.delete());
                            SnapsendService.copyFile(file2, file1);
                            handler.post(new Runnable() {

                                final _cls1 this$1;

                                public void run()
                                {
                                    Toast toast = Toast.makeText(getApplicationContext(), "", 1);
                                    if (foundVideo)
                                    {
                                        toast.setText("Video has been switched, you can send now.");
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
                        }
                        Thread.sleep(1000L);
                    }
                    catch (Exception exception1) { }
                    this;
                    JVM INSTR monitorexit ;
                    if (true) goto _L2; else goto _L1
_L1:
                    exception;
                    this;
                    JVM INSTR monitorexit ;
                    throw exception;
                }


            
            {
                this$0 = SnapsendService.this;
                super();
            }
            });
            thread.start();
        }
        return mBinder;
    }

    public void onCreate()
    {
        handler = new Handler();
        videoPath = (new StringBuilder(String.valueOf(getApplication().getExternalCacheDir().getParent().replace("com.ryanburke.snapgrab", "")))).append("com.snapchat.android/cache/sending_video_snaps").toString();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        return 1;
    }







}
