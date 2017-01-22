package com.example.atest;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.test.InstrumentationTestCase;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by johnsayeau on 2017-01-21.
 */
public class CalculatorTester extends InstrumentationTestCase {
    private UiDevice device;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        device = UiDevice.getInstance(getInstrumentation());
        device.pressHome();
        device.wait(Until.hasObject(By.desc("Apps")), 3000);
        UiObject2 appsButton = device.findObject(By.desc("Apps"));
        appsButton.click();
        device.wait(Until.hasObject(By.desc("Calculator")), 3000);
        UiObject2 calcIcon = device.findObject(By.desc("Calculator"));
        calcIcon.click();

    }

    public void testAdd() throws Exception {
        device.wait(Until.hasObject(By.text("9")), 3000);
        UiObject2 nineButton = device.findObject(By.text("9"));
        UiObject2 plusButton = device.findObject(By.desc("plus"));
        UiObject2 equalsButton = device.findObject(By.desc("equals"));
        System.out.println(nineButton.getText());
        nineButton.click();
        plusButton.click();
        nineButton.click();
        equalsButton.click();
        device.waitForIdle(3000);
        UiObject2 resultText = device.findObject(By.res("com.android.calculator2:id/result"));
        String finalAnswer = resultText.getText();
        assertTrue(finalAnswer.equals("18"));
        UiObject2 toolbar = device.findObject(By.res("com.android.calculator2:id/toolbar"));
        List<UiObject2> kidlets = toolbar.getChildren();
        int i = 0;
        while (i < kidlets.size()){
            Log.d("johns test message", "**************");
            Log.d("johns test message", kidlets.get(i).getResourceName() + " - ");

            i++;
        }
        //device.dumpWindowHierarchy();


    }

}
