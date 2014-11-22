package co.wa2do_app.wa2do;

public enum EventTypes {
    SPORTS {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitSports();
        }
    },
    CONCERTS {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitConcerts();
        }
    },
    VIDEO_GAMES {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitVideoGames();
        }
    };

    public abstract <E> E accept(Visitor<E> visitor);

    public interface Visitor <E> {
        E visitSports();
        E visitConcerts();
        E visitVideoGames();
    }
}
