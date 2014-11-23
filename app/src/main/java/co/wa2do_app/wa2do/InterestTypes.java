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
    },
    DRINKING {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitDrinking();
        }
    },
    EXERCISE {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitExercise();
        }
    },
    BOOK_CLUB {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitBookClub();
        }
    };

    public abstract <E> E accept(Visitor<E> visitor);

    public interface Visitor <E> {
        E visitSports();
        E visitArts();
        E visitVideoGames();
        E visitDrinking();
        E visitExercise();
        E visitBookClub();
    }
}
