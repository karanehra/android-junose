package com.karanehra.junose;


import com.jme3.app.AndroidHarness;
import com.karanehra.core.Game;

public class MainActivity extends AndroidHarness {

    public MainActivity() {
        appClass = Game.class.getCanonicalName();
    }
}
