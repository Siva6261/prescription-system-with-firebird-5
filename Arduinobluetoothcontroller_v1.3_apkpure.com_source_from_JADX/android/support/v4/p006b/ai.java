package android.support.v4.p006b;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.p015h.C0165q;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ai {
    private final aj f618a;

    private ai(aj ajVar) {
        this.f618a = ajVar;
    }

    public static final ai m1018a(aj ajVar) {
        return new ai(ajVar);
    }

    public ak m1019a() {
        return this.f618a.m1002i();
    }

    C0051y m1020a(String str) {
        return this.f618a.f607d.m1096b(str);
    }

    public View m1021a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f618a.f607d.mo180a(view, str, context, attributeSet);
    }

    public List m1022a(List list) {
        if (this.f618a.f607d.f629f == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList(m1032b());
        }
        list.addAll(this.f618a.f607d.f629f);
        return list;
    }

    public void m1023a(Configuration configuration) {
        this.f618a.f607d.m1083a(configuration);
    }

    public void m1024a(Parcelable parcelable, List list) {
        this.f618a.f607d.m1085a(parcelable, list);
    }

    public void m1025a(C0051y c0051y) {
        this.f618a.f607d.m1086a(this.f618a, this.f618a, c0051y);
    }

    public void m1026a(C0165q c0165q) {
        this.f618a.m987a(c0165q);
    }

    public void m1027a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f618a.m995b(str, fileDescriptor, printWriter, strArr);
    }

    public void m1028a(boolean z) {
        this.f618a.m990a(z);
    }

    public boolean m1029a(Menu menu) {
        return this.f618a.f607d.m1093a(menu);
    }

    public boolean m1030a(Menu menu, MenuInflater menuInflater) {
        return this.f618a.f607d.m1094a(menu, menuInflater);
    }

    public boolean m1031a(MenuItem menuItem) {
        return this.f618a.f607d.m1095a(menuItem);
    }

    public int m1032b() {
        List list = this.f618a.f607d.f629f;
        return list == null ? 0 : list.size();
    }

    public void m1033b(Menu menu) {
        this.f618a.f607d.m1101b(menu);
    }

    public boolean m1034b(MenuItem menuItem) {
        return this.f618a.f607d.m1103b(menuItem);
    }

    public void m1035c() {
        this.f618a.f607d.m1118i();
    }

    public Parcelable m1036d() {
        return this.f618a.f607d.m1117h();
    }

    public List m1037e() {
        return this.f618a.f607d.m1116g();
    }

    public void m1038f() {
        this.f618a.f607d.m1119j();
    }

    public void m1039g() {
        this.f618a.f607d.m1120k();
    }

    public void m1040h() {
        this.f618a.f607d.m1121l();
    }

    public void m1041i() {
        this.f618a.f607d.m1122m();
    }

    public void m1042j() {
        this.f618a.f607d.m1123n();
    }

    public void m1043k() {
        this.f618a.f607d.m1124o();
    }

    public void m1044l() {
        this.f618a.f607d.m1125p();
    }

    public void m1045m() {
        this.f618a.f607d.m1127r();
    }

    public void m1046n() {
        this.f618a.f607d.m1128s();
    }

    public boolean m1047o() {
        return this.f618a.f607d.m1112e();
    }

    public void m1048p() {
        this.f618a.m1004k();
    }

    public void m1049q() {
        this.f618a.m1005l();
    }

    public void m1050r() {
        this.f618a.m1006m();
    }

    public C0165q m1051s() {
        return this.f618a.m1007n();
    }
}
