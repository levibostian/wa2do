package co.wa2do_app.wa2do;

public enum InterestTypes {
    SPORTS {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitSports();
        }
    },
    ARTS {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitArts();
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
        E visitArts();
        E visitVideoGames();
    }
}
