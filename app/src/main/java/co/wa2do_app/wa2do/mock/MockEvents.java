package co.wa2do_app.wa2do.mock;

import co.wa2do_app.wa2do.InterestTypes;
import co.wa2do_app.wa2do.vo.EventVo;

import java.util.ArrayList;

public class MockEvents {

    public static ArrayList<EventVo> getEvents() {
        ArrayList<EventVo> events = new ArrayList<EventVo>();
        events.add(new EventVo(InterestTypes.SPORTS, "Racketball", "Levi Bostian", 3, 5, 32, 5));
        events.add(new EventVo(InterestTypes.ARTS, "Nickelback", "Trevor Carlson", 999, 1000, 5, 12));

        return events;
    }

}
