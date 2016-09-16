package com.oraculo.ia.glailton.androidcalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import org.w3c.dom.Text;

/**
 * Created by glailton on 30/08/16.
 */
public class TestAndroidCalculatorWhiteBox extends ActivityInstrumentationTestCase2{

    private Solo solo;

    public TestAndroidCalculatorWhiteBox(Class activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testDisplayWhiteBox(){
        float firstNumber = 10;
        float secondNumber = 20;
        float result = firstNumber*secondNumber;

        EditText edFirstNumber = (EditText) solo.getView(R.id.editText01);
        solo.clearEditText(edFirstNumber);
        solo.enterText(edFirstNumber, String.valueOf(firstNumber));

        EditText edSecondNumber = (EditText) solo.getView(R.id.editText02);
        solo.clearEditText(edSecondNumber);
        solo.enterText(edSecondNumber, String.valueOf(secondNumber));

        solo.clickOnButton(R.string.btnMultiply);

        assertTrue(solo.searchText(String.valueOf(result)));
        TextView outputField = (TextView) solo.getView(R.id.TextView01);

        assertEquals(String.valueOf(result), outputField.getText().toString());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        solo.finishOpenedActivities();
    }
}
