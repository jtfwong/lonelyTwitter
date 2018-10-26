package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;



public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;
    public LonelyTwitterActivityTest() {
        super(LonelyTwitterActivity.class);
    }
    @Override
    public void setUp(){
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown(){
        solo.finishOpenedActivities();
    }

    public void testTweet(){
        solo.assertCurrentActivity("wrong activity", "ABC");
    }

    public void testEquals(){
        assertEquals("not equal", "5", "5");
    }

    public void testAddTweet(){
        solo.enterText((EditText)solo.getView(R.id.body), "dont know");
        solo.clickOnButton("Save");
        solo.clearEditText((EditText)solo.getView(R.id.body));
        assertTrue(solo.waitForText("dont know"));
    }
}