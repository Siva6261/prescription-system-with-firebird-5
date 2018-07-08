package com.giumig.apps.bluetoothcontroller.p025d;

import io.realm.C0394y;
import io.realm.C0435h;
import io.realm.C0481k;
import io.realm.ah;

public class C0395b implements C0394y {
    public void mo866a(C0435h c0435h, long j, long j2) {
        ah k = c0435h.mo893k();
        if (j == 0) {
            k.m5417a("SwitchProfile").m5384a("profileId", String.class, C0481k.PRIMARY_KEY).m5384a("profileName", String.class, new C0481k[0]).m5384a("onCommand", String.class, new C0481k[0]).m5384a("offCommand", String.class, new C0481k[0]);
            long j3 = 1 + j;
        }
    }
}
