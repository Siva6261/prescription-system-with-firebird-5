package android.support.v4.p006b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.p015h.C0165q;
import android.support.v4.p015h.C0182r;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ad extends C0069w implements C0070c, C0071f {
    final Handler f591a = new ae(this);
    final ai f592b = ai.m1018a(new af(this));
    boolean f593c;
    boolean f594d;
    boolean f595e;
    boolean f596f;
    boolean f597g;
    boolean f598h;
    boolean f599i;
    int f600j;
    boolean f601k;
    C0182r f602l;

    private static String m968a(View view) {
        char c = 'F';
        char c2 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        stringBuilder.append(view.isFocusable() ? 'F' : '.');
        stringBuilder.append(view.isEnabled() ? 'E' : '.');
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        stringBuilder.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        stringBuilder.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        stringBuilder.append(view.isClickable() ? 'C' : '.');
        stringBuilder.append(view.isLongClickable() ? 'L' : '.');
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c2 = 'P';
        }
        stringBuilder.append(c2);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m969a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(ad.m968a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m969a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    private int m970b(C0051y c0051y) {
        if (this.f602l.m1571b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.f602l.m1578f(this.f600j) >= 0) {
            this.f600j = (this.f600j + 1) % 65534;
        }
        int i = this.f600j;
        this.f602l.m1573b(i, c0051y.f506q);
        this.f600j = (this.f600j + 1) % 65534;
        return i;
    }

    final View mo161a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f592b.m1021a(view, str, context, attributeSet);
    }

    public final void mo162a(int i) {
        if (this.f599i) {
            this.f599i = false;
        } else if ((i & -256) != 0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
    }

    public void m973a(C0051y c0051y) {
    }

    public void m974a(C0051y c0051y, Intent intent, int i, Bundle bundle) {
        this.f601k = true;
        if (i == -1) {
            try {
                C0067a.m961a(this, intent, -1, bundle);
            } finally {
                this.f601k = false;
            }
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            C0067a.m961a(this, intent, ((m970b(c0051y) + 1) << 16) + (65535 & i), bundle);
            this.f601k = false;
        }
    }

    void m975a(boolean z) {
        if (!this.f596f) {
            this.f596f = true;
            this.f597g = z;
            this.f591a.removeMessages(1);
            m980e();
        }
    }

    protected boolean m976a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public void a_() {
        C0067a.m963b(this);
    }

    protected void m977b() {
        this.f592b.m1041i();
    }

    public Object m978c() {
        return null;
    }

    public void mo571d() {
        if (VERSION.SDK_INT >= 11) {
            C0077g.m1250a(this);
        } else {
            this.f598h = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f593c);
            printWriter.print("mResumed=");
            printWriter.print(this.f594d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f595e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f596f);
            this.f592b.m1027a(str2, fileDescriptor, printWriter, strArr);
            this.f592b.m1019a().mo183a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m969a(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f593c);
            printWriter.print("mResumed=");
            printWriter.print(this.f594d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f595e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f596f);
            this.f592b.m1027a(str2, fileDescriptor, printWriter, strArr);
            this.f592b.m1019a().mo183a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m969a(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    void m980e() {
        this.f592b.m1028a(this.f597g);
        this.f592b.m1044l();
    }

    public ak m981f() {
        return this.f592b.m1019a();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f592b.m1035c();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.f602l.m1569a(i4);
            this.f602l.m1575c(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            C0051y a = this.f592b.m1020a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.m829a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f592b.m1019a().mo185c()) {
            a_();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f592b.m1023a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f592b.m1025a(null);
        super.onCreate(bundle);
        ag agVar = (ag) getLastNonConfigurationInstance();
        if (agVar != null) {
            this.f592b.m1026a(agVar.f617c);
        }
        if (bundle != null) {
            this.f592b.m1024a(bundle.getParcelable("android:support:fragments"), agVar != null ? agVar.f616b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f600j = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f602l = new C0182r(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.f602l.m1573b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.f602l == null) {
            this.f602l = new C0182r();
            this.f600j = 0;
        }
        this.f592b.m1038f();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        return VERSION.SDK_INT >= 11 ? super.onCreatePanelMenu(i, menu) | this.f592b.m1030a(menu, getMenuInflater()) : true;
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        m975a(false);
        this.f592b.m1045m();
        this.f592b.m1049q();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f592b.m1046n();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f592b.m1031a(menuItem);
            case 6:
                return this.f592b.m1034b(menuItem);
            default:
                return false;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f592b.m1035c();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f592b.m1033b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f594d = false;
        if (this.f591a.hasMessages(2)) {
            this.f591a.removeMessages(2);
            m977b();
        }
        this.f592b.m1042j();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f591a.removeMessages(2);
        m977b();
        this.f592b.m1047o();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f598h) {
            this.f598h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m976a(view, menu) | this.f592b.m1029a(menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 8) & 255;
        if (i2 != 0) {
            i2--;
            int b = this.f592b.m1032b();
            if (b == 0 || i2 < 0 || i2 >= b) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            C0051y c0051y = (C0051y) this.f592b.m1022a(new ArrayList(b)).get(i2);
            if (c0051y == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                c0051y.m831a(i & 255, strArr, iArr);
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.f591a.sendEmptyMessage(2);
        this.f594d = true;
        this.f592b.m1047o();
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f595e) {
            m975a(true);
        }
        Object c = m978c();
        List e = this.f592b.m1037e();
        C0165q s = this.f592b.m1051s();
        if (e == null && s == null && c == null) {
            return null;
        }
        ag agVar = new ag();
        agVar.f615a = c;
        agVar.f616b = e;
        agVar.f617c = s;
        return agVar;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable d = this.f592b.m1036d();
        if (d != null) {
            bundle.putParcelable("android:support:fragments", d);
        }
        if (this.f602l.m1571b() > 0) {
            bundle.putInt("android:support:next_request_index", this.f600j);
            int[] iArr = new int[this.f602l.m1571b()];
            String[] strArr = new String[this.f602l.m1571b()];
            for (int i = 0; i < this.f602l.m1571b(); i++) {
                iArr[i] = this.f602l.m1576d(i);
                strArr[i] = (String) this.f602l.m1577e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f595e = false;
        this.f596f = false;
        this.f591a.removeMessages(1);
        if (!this.f593c) {
            this.f593c = true;
            this.f592b.m1039g();
        }
        this.f592b.m1035c();
        this.f592b.m1047o();
        this.f592b.m1048p();
        this.f592b.m1040h();
        this.f592b.m1050r();
    }

    public void onStateNotSaved() {
        this.f592b.m1035c();
    }

    protected void onStop() {
        super.onStop();
        this.f595e = true;
        this.f591a.sendEmptyMessage(1);
        this.f592b.m1043k();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.f601k || i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
}
