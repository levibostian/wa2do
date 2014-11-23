package co.wa2do_app.wa2do.mock;

import co.wa2do_app.wa2do.InterestTypes;

import java.util.ArrayList;

public class MockInterests {

    public static ArrayList<InterestTypes> getInterests() {
        ArrayList<InterestTypes> interests = new ArrayList<InterestTypes>();
        interests.add(InterestTypes.SPORTS);
        interests.add(InterestTypes.ARTS);
        interests.add(InterestTypes.VIDEO_GAMES);

        return interests;
    }

}
