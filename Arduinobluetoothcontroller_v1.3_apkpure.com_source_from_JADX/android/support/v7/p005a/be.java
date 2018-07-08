package android.support.v7.p005a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.p008c.C0105n;
import android.util.Log;
import java.util.Calendar;

class be {
    private static final bg f1270a = new bg();
    private final Context f1271b;
    private final LocationManager f1272c;

    be(Context context) {
        this.f1271b = context;
        this.f1272c = (LocationManager) context.getSystemService("location");
    }

    private Location m3058a(String str) {
        if (this.f1272c != null) {
            try {
                if (this.f1272c.isProviderEnabled(str)) {
                    return this.f1272c.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    private void m3059a(Location location) {
        long j;
        bg bgVar = f1270a;
        long currentTimeMillis = System.currentTimeMillis();
        bd a = bd.m3056a();
        a.m3057a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f1267a;
        a.m3057a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f1269c == 1;
        long j3 = a.f1268b;
        long j4 = a.f1267a;
        a.m3057a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.f1268b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3;
            j += 60000;
        }
        bgVar.f1273a = z;
        bgVar.f1274b = j2;
        bgVar.f1275c = j3;
        bgVar.f1276d = j4;
        bgVar.f1277e = j5;
        bgVar.f1278f = j;
    }

    private boolean m3060a(bg bgVar) {
        return bgVar != null && bgVar.f1278f > System.currentTimeMillis();
    }

    private Location m3061b() {
        Location location = null;
        Location a = C0105n.m1330a(this.f1271b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m3058a("network") : null;
        if (C0105n.m1330a(this.f1271b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m3058a("gps");
        }
        if (location != null && a != null) {
            return location.getTime() > a.getTime() ? location : a;
        } else {
            if (location == null) {
                location = a;
            }
            return location;
        }
    }

    boolean m3062a() {
        bg bgVar = f1270a;
        if (m3060a(bgVar)) {
            return bgVar.f1273a;
        }
        Location b = m3061b();
        if (b != null) {
            m3059a(b);
            return bgVar.f1273a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
