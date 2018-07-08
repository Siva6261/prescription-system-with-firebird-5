package android.support.v7.p005a;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.view.Window.Callback;

class aa extends C0270z {
    private static be f1192r;
    private int f1193s = -100;
    private boolean f1194t;
    private boolean f1195u = true;

    aa(Context context, Window window, C0047v c0047v) {
        super(context, window, c0047v);
    }

    private int m2969d(int i) {
        switch (i) {
            case -1:
                switch (((UiModeManager) this.a.getSystemService("uimode")).getNightMode()) {
                    case 0:
                        return 0;
                    case 2:
                        return 2;
                    default:
                        return 1;
                }
            case 0:
                return m2972s().m3062a() ? 2 : 1;
            case 2:
                return 2;
            default:
                return 1;
        }
    }

    private boolean m2970e(int i) {
        int i2;
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i3 = configuration.uiMode & 48;
        switch (i) {
            case 1:
                i2 = 16;
                break;
            case 2:
                i2 = 32;
                break;
            default:
                i2 = 0;
                break;
        }
        if (i3 == i2) {
            return false;
        }
        configuration.uiMode = (configuration.uiMode & -49) | i2;
        resources.updateConfiguration(configuration, null);
        return true;
    }

    private int m2971r() {
        return m2969d(this.f1193s == -100 ? C0267w.m2855i() : this.f1193s);
    }

    private be m2972s() {
        if (f1192r == null) {
            f1192r = new be(this.a.getApplicationContext());
        }
        return f1192r;
    }

    Callback mo504a(Callback callback) {
        return new ab(this, callback);
    }

    public void mo484a(Bundle bundle) {
        super.mo484a(bundle);
        if (bundle != null && this.f1193s == -100) {
            this.f1193s = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    public void mo477c(Bundle bundle) {
        super.mo477c(bundle);
        if (this.f1193s != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f1193s);
        }
    }

    public boolean mo479h() {
        this.f1194t = true;
        return m2970e(m2971r());
    }

    public boolean mo505m() {
        return this.f1195u;
    }
}
