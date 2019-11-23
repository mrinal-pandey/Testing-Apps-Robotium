package com.project.oncreate.myapplication;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;
import android.widget.TextView;
import com.robotium.solo.Solo;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainActivityTest{

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);
    private Instrumentation in;
    MainActivity mainActivity = null;
    private Solo solo;
    String validate = "Validate";
    TextView textView;
    EditText editText;

    @Before
    public void setUp() throws Exception {

        in = InstrumentationRegistry.getInstrumentation();
        mainActivity = mainActivityActivityTestRule.getActivity();
        solo = new Solo(in, mainActivity);
        editText = (EditText) solo.getView(R.id.editText);
        textView = (TextView) solo.getView(R.id.textView);
    }

    @Test
    public void editTextUpdateTestCase() throws Exception{

        try{Thread.sleep(2000);}catch (Exception e){}
        solo.enterText(editText, "Validate");
        try{Thread.sleep(2000);}catch (Exception e){}
        assertEquals(validate, editText.getText().toString());
    }

    @Test
    public void textViewUpdateTestCase() throws Exception{

        solo.enterText(editText, "Validate");
        try{Thread.sleep(2000);}catch (Exception e){}
        solo.clickOnButton("Submit");
        try{Thread.sleep(2000);}catch (Exception e){}
        assertEquals(validate, textView.getText().toString());
    }

    @After
    public void tearDown() throws Exception {

        solo.finishOpenedActivities();
    }
}