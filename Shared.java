// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;


public class Shared
{

    private static Shared c;
    public String file;

    private Shared()
    {
        file = null;
    }

    public static Shared getInstance()
    {
        if (c == null)
        {
            c = new Shared();
        }
        return c;
    }

    public String getFile()
    {
        return file;
    }

    public void setFile(String s)
    {
        file = s;
    }
}
