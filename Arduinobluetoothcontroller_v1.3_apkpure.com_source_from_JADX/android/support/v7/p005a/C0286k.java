package android.support.v7.p005a;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class C0286k {
    public int f1377A;
    public boolean f1378B = false;
    public boolean[] f1379C;
    public boolean f1380D;
    public boolean f1381E;
    public int f1382F = -1;
    public OnMultiChoiceClickListener f1383G;
    public Cursor f1384H;
    public String f1385I;
    public String f1386J;
    public OnItemSelectedListener f1387K;
    public C0291p f1388L;
    public boolean f1389M = true;
    public final Context f1390a;
    public final LayoutInflater f1391b;
    public int f1392c = 0;
    public Drawable f1393d;
    public int f1394e = 0;
    public CharSequence f1395f;
    public View f1396g;
    public CharSequence f1397h;
    public CharSequence f1398i;
    public OnClickListener f1399j;
    public CharSequence f1400k;
    public OnClickListener f1401l;
    public CharSequence f1402m;
    public OnClickListener f1403n;
    public boolean f1404o;
    public OnCancelListener f1405p;
    public OnDismissListener f1406q;
    public OnKeyListener f1407r;
    public CharSequence[] f1408s;
    public ListAdapter f1409t;
    public OnClickListener f1410u;
    public int f1411v;
    public View f1412w;
    public int f1413x;
    public int f1414y;
    public int f1415z;

    public C0286k(Context context) {
        this.f1390a = context;
        this.f1404o = true;
        this.f1391b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private void m3203b(C0280e c0280e) {
        ListAdapter simpleCursorAdapter;
        ListView listView = (ListView) this.f1391b.inflate(c0280e.f1331H, null);
        if (!this.f1380D) {
            int m = this.f1381E ? c0280e.f1333J : c0280e.f1334K;
            simpleCursorAdapter = this.f1384H != null ? new SimpleCursorAdapter(this.f1390a, m, this.f1384H, new String[]{this.f1385I}, new int[]{16908308}) : this.f1409t != null ? this.f1409t : new C0293r(this.f1390a, m, 16908308, this.f1408s);
        } else if (this.f1384H == null) {
            simpleCursorAdapter = new C0287l(this, this.f1390a, c0280e.f1332I, 16908308, this.f1408s, listView);
        } else {
            Object c0288m = new C0288m(this, this.f1390a, this.f1384H, false, listView, c0280e);
        }
        if (this.f1388L != null) {
            this.f1388L.m3205a(listView);
        }
        c0280e.f1327D = simpleCursorAdapter;
        c0280e.f1328E = this.f1382F;
        if (this.f1410u != null) {
            listView.setOnItemClickListener(new C0289n(this, c0280e));
        } else if (this.f1383G != null) {
            listView.setOnItemClickListener(new C0290o(this, listView, c0280e));
        }
        if (this.f1387K != null) {
            listView.setOnItemSelectedListener(this.f1387K);
        }
        if (this.f1381E) {
            listView.setChoiceMode(1);
        } else if (this.f1380D) {
            listView.setChoiceMode(2);
        }
        c0280e.f1343f = listView;
    }

    public void m3204a(C0280e c0280e) {
        if (this.f1396g != null) {
            c0280e.m3197b(this.f1396g);
        } else {
            if (this.f1395f != null) {
                c0280e.m3194a(this.f1395f);
            }
            if (this.f1393d != null) {
                c0280e.m3192a(this.f1393d);
            }
            if (this.f1392c != 0) {
                c0280e.m3196b(this.f1392c);
            }
            if (this.f1394e != 0) {
                c0280e.m3196b(c0280e.m3200c(this.f1394e));
            }
        }
        if (this.f1397h != null) {
            c0280e.m3198b(this.f1397h);
        }
        if (this.f1398i != null) {
            c0280e.m3191a(-1, this.f1398i, this.f1399j, null);
        }
        if (this.f1400k != null) {
            c0280e.m3191a(-2, this.f1400k, this.f1401l, null);
        }
        if (this.f1402m != null) {
            c0280e.m3191a(-3, this.f1402m, this.f1403n, null);
        }
        if (!(this.f1408s == null && this.f1384H == null && this.f1409t == null)) {
            m3203b(c0280e);
        }
        if (this.f1412w != null) {
            if (this.f1378B) {
                c0280e.m3193a(this.f1412w, this.f1413x, this.f1414y, this.f1415z, this.f1377A);
                return;
            }
            c0280e.m3201c(this.f1412w);
        } else if (this.f1411v != 0) {
            c0280e.m3190a(this.f1411v);
        }
    }
}
