package com.marksman.architectures.base.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtil {
    public static String logStackTrace (Exception e) {
        StringWriter sw = new StringWriter ();
        PrintWriter pw = new PrintWriter (sw, true);
        e.printStackTrace (pw);
        String errorStr = sw.toString ();
        pw.flush ();
        pw.close ();
        return  errorStr;
    }
}
