package com.duartbreedt.movementprogressbars;

import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;

import java.awt.*;

public enum FlagColor {
    AGENDER {
        private final Color BLACK = new JBColor(Gray._0, Gray._0);
        private final Color GRAY = new JBColor(Gray._186, Gray._186);
        private final Color WHITE = new JBColor(Gray._255, Gray._255);
        private final Color GREEN = new JBColor(new Color(185, 244, 132), new Color(185, 244, 132));

        @Override
        public Color[] getColors() {
            return new Color[]{BLACK, GRAY, WHITE, GREEN, WHITE, GRAY, BLACK};
        }
    },
    AROMANTIC {
        private final Color GREEN = JBColor.decode("#3AA640");
        private final Color LIME = JBColor.decode("#A8D47A");
        private final Color WHITE = new JBColor(Gray._255, Gray._255);
        private final Color GRAY = JBColor.decode("#AAAAAB");
        private final Color BLACK = new JBColor(Gray._0, Gray._0);

        @Override
        public Color[] getColors() {
            return new Color[]{GREEN, LIME, WHITE, GRAY, BLACK};
        }
    },
    ASEXUAL {
        private final Color BLACK = new JBColor(Gray._0, Gray._0);
        private final Color GRAY = JBColor.decode("#A4A4A4");
        private final Color WHITE = new JBColor(Gray._255, Gray._255);
        private final Color PURPLE = JBColor.decode("#810081");

        @Override
        public Color[] getColors() {
            return new Color[]{BLACK, GRAY, WHITE, PURPLE};
        }
    },
    BEAR_BROTHERHOOD {
        private final Color BROWN = JBColor.decode("#623500");
        private final Color BURNT_ORANGE = JBColor.decode("#D66300");
        private final Color SUNSET_YELLOW = JBColor.decode("#FEDE63");
        private final Color BEIGE = JBColor.decode("#FEE7B9");
        private final Color WHITE = new JBColor(Gray._255, Gray._255);
        private final Color GRAY = JBColor.decode("#545454");
        private final Color BLACK = new JBColor(Gray._0, Gray._0);

        @Override
        public Color[] getColors() {
            return new Color[]{BROWN, BURNT_ORANGE, SUNSET_YELLOW, BEIGE, WHITE, GRAY, BLACK};
        }
    },
    BIGENDER {
        private final Color DARK_PINK = JBColor.decode("#C57AA3");
        private final Color PINK = JBColor.decode("#EEA6CE");
        private final Color MAUVE = JBColor.decode("#D6C8E9");
        private final Color WHITE = new JBColor(Gray._255, Gray._255);
        private final Color SKY = JBColor.decode("#9BC8E9");
        private final Color BLUE = JBColor.decode("#6D83D2");

        @Override
        public Color[] getColors() {
            return new Color[]{DARK_PINK, PINK, MAUVE, WHITE, MAUVE, SKY, BLUE};
        }
    },
    BISEXUAL {
        // TODO: Fix this to be in the ratios 2/5, 1/5, 2/5

        private final Color HOT_PINK = JBColor.decode("#D70070");
        private final Color AUBERGINE = JBColor.decode("#9C4E97");
        private final Color BLUE = JBColor.decode("#0035A9");

        @Override
        public Color[] getColors() {
            return new Color[]{HOT_PINK, AUBERGINE, BLUE};
        }
    },
    GAY {
        private final Color FOREST = JBColor.decode("#018E70");
        private final Color ALGAE = JBColor.decode("#21CFAC");
        private final Color LIME = JBColor.decode("#9AE9C3");
        private final Color WHITE = new JBColor(Gray._255, Gray._255);
        private final Color SKY = JBColor.decode("#7CAFE4");
        private final Color LAVENDER = JBColor.decode("#4F47CC");
        private final Color PURPLE = JBColor.decode("#3C1379");

        @Override
        public Color[] getColors() {
            return new Color[]{FOREST, ALGAE, LIME, WHITE, SKY, LAVENDER, PURPLE};
        }
    },
    PRIDE {
        private final Color RED = new JBColor(new Color(221, 3, 3), new Color(221, 3, 3));
        private final Color ORANGE = new JBColor(new Color(247, 136, 0), new Color(247, 136, 0));
        private final Color YELLOW = new JBColor(new Color(247, 230, 0), new Color(247, 230, 0));
        private final Color GREEN = new JBColor(new Color(0, 124, 37), new Color(0, 124, 37));
        private final Color BLUE = new JBColor(new Color(0, 75, 247), new Color(0, 75, 247));
        private final Color VIOLET = new JBColor(new Color(113, 7, 131), new Color(113, 7, 131));

        @Override
        public Color[] getColors() {
            return new Color[]{RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET};
        }
    },
    GENDERFLUID {
        private final Color PINK = JBColor.decode("#FF76A3");
        private final Color WHITE = new JBColor(Gray._255, Gray._255);
        private final Color VIOLET = JBColor.decode("#BF11D7");
        private final Color CHARCOAL = JBColor.decode("#282828");
        private final Color BLUE = JBColor.decode("#303CBE");

        @Override
        public Color[] getColors() {
            return new Color[]{PINK, WHITE, VIOLET, CHARCOAL, BLUE};
        }
    },
    GENDERQUEER {
        private final Color MAUVE = JBColor.decode("#B67FDD");
        private final Color WHITE = new JBColor(Gray._255, Gray._255);
        private final Color PICKLE = JBColor.decode("#48821E");

        @Override
        public Color[] getColors() {
            return new Color[]{MAUVE, WHITE, PICKLE};
        }
    },
    LEATHER {
        private final Color BLACK = new JBColor(Gray._0, Gray._0);
        private final Color DENIM = JBColor.decode("#252580");
        private final Color WHITE = new JBColor(Gray._255, Gray._255);

        @Override
        public Color[] getColors() {
            return new Color[]{BLACK, DENIM, BLACK, DENIM, WHITE, DENIM, BLACK, DENIM, BLACK};
        }
    },
    LESBIAN {
        private final Color STRAWBERRY = JBColor.decode("#D62900");
        private final Color APRICOT = JBColor.decode("#FF9B55");
        private final Color WHITE = new JBColor(Gray._255, Gray._255);
        private final Color PINK = JBColor.decode("#D462A5");
        private final Color DARK_PINK = JBColor.decode("#A40062");

        @Override
        public Color[] getColors() {
            return new Color[]{STRAWBERRY, APRICOT, WHITE, PINK, DARK_PINK};
        }
    },
    LIPSTICK_LESBIAN {
        private final Color DARK_PINK = JBColor.decode("#A50061");
        private final Color DULL_PINK = JBColor.decode("#B85493");
        private final Color PINK = JBColor.decode("#D163A7");
        private final Color WHITE = new JBColor(Gray._255, Gray._255);
        private final Color PALE_PINK = JBColor.decode("#E5AED0");
        private final Color BLUSH = JBColor.decode("#C64D53");
        private final Color DEEP_BERRY = JBColor.decode("#8B1800");

        @Override
        public Color[] getColors() {
            return new Color[]{DARK_PINK, DULL_PINK, PINK, WHITE, PALE_PINK, BLUSH, DEEP_BERRY};
        }
    },
    NON_BINARY {
        private final Color YOLK = JBColor.decode("#FCF431");
        private final Color WHITE = new JBColor(Gray._255, Gray._255);
        private final Color VIOLET = JBColor.decode("#9D58D2");
        private final Color CHARCOAL = JBColor.decode("#282828");

        @Override
        public Color[] getColors() {
            return new Color[]{YOLK, WHITE, VIOLET, CHARCOAL};
        }
    },
    PANSEXUAL {
        private final Color VIVID_PINK = JBColor.decode("#FF1B8D");
        private final Color DIRTY_YELLOW = JBColor.decode("#FFD900");
        private final Color SKY = JBColor.decode("#1BB2FF");

        @Override
        public Color[] getColors() {
            return new Color[]{VIVID_PINK, DIRTY_YELLOW, SKY};
        }
    },
    POLYSEXUAL {
        private final Color VIVID_PINK = JBColor.decode("#F615BA");
        private final Color ALGAE = JBColor.decode("#01D669");
        private final Color BLUE = JBColor.decode("#1593F6");

        @Override
        public Color[] getColors() {
            return new Color[]{VIVID_PINK, ALGAE, BLUE};
        }
    },
    TRANSEXUAL {
        private final Color BLUE = new JBColor(new Color(91, 206, 250), new Color(91, 206, 250));
        private final Color PINK = new JBColor(new Color(245, 169, 184), new Color(245, 169, 184));
        private final Color WHITE = new JBColor(Gray._255, Gray._255);

        @Override
        public Color[] getColors() {
            return new Color[]{BLUE, PINK, WHITE, PINK, BLUE};
        }
    }
    ;

    public static FlagColor DEFAULT_VALUE = FlagColor.PRIDE;

    public abstract Color[] getColors();
}
