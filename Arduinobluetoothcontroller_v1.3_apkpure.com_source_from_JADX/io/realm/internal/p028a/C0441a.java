package io.realm.internal.p028a;

import android.util.Log;
import io.realm.internal.p027b.C0440a;

public class C0441a implements C0440a {
    private int f2897a = 2;
    private String f2898b = "REALM";

    private void m5632a(int i, String str, String str2) {
        while (str2.length() != 0) {
            int indexOf = str2.indexOf(10);
            int min = Math.min(indexOf != -1 ? indexOf : str2.length(), 4000);
            Log.println(i, str, str2.substring(0, min));
            str2 = (indexOf == -1 || indexOf != min) ? str2.substring(min) : str2.substring(min + 1);
        }
    }

    private void m5633a(int i, String str, Throwable th) {
        if (i >= this.f2897a) {
            if (str == null || str.length() == 0) {
                if (th != null) {
                    str = Log.getStackTraceString(th);
                } else {
                    return;
                }
            } else if (th != null) {
                str = str + "\n" + Log.getStackTraceString(th);
            }
            if (str.length() < 4000) {
                Log.println(i, this.f2898b, str);
            } else {
                m5632a(i, this.f2898b, str);
            }
        }
    }

    public void m5634a(int i) {
        this.f2897a = i;
    }

    public void mo921a(String str) {
        m5633a(3, str, null);
    }

    public void mo922a(String str, Throwable th) {
        m5633a(2, str, th);
    }

    public void mo923b(String str) {
        m5633a(5, str, null);
    }
}
