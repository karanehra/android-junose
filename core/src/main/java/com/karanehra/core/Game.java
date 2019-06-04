package com.karanehra.core;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.input.controls.TouchListener;
import com.jme3.input.controls.TouchTrigger;
import com.jme3.input.event.TouchEvent;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class Game extends SimpleApplication implements TouchListener {
    private static Game app;
    private BulletAppState bulletAppState;


    public static void main(String[] args) {
        Game.app = new Game();
        app.start();
    }
    @Override
    public void simpleInitApp() {
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);

        bulletAppState.getPhysicsSpace().setGravity(new Vector3f(0, -9.8f, 0));

        inputManager.addMapping("Touch",new TouchTrigger(0));
        inputManager.addListener(this, new String("Touch"));

        Box box = new Box(1,1,1);
        Geometry geo = new Geometry("Geometry",box);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);
        geo.setMaterial(mat);
        rootNode.attachChild(geo);

        Box fl = new Box(1,1,1);
        Geometry floor = new Geometry("Geometry",fl);
        Material mat1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat1.setColor("Color", ColorRGBA.White);
        floor.setMaterial(mat1);
        floor.setLocalTranslation(0,-5,0);
        rootNode.attachChild(floor);

        RigidBodyControl fc = new RigidBodyControl(0);
        floor.addControl(fc);
        bulletAppState.getPhysicsSpace().add(floor);

        RigidBodyControl rbc = new RigidBodyControl(10);
        geo.addControl(rbc);
        bulletAppState.getPhysicsSpace().add(geo);

    }

    @Override
    public void onTouch(String name, TouchEvent event, float tpf){
        System.out.println(event.toString());
    }
}
