package datamunging;

public class DifferenceMain {

    enum FileType {
        WEATHER {
            @Override
            public int getLabelIndex() {
                return 0;
            }

            @Override
            public int getMinIndex() {
                return 1;
            }

            @Override
            public int getMaxIndex() {
                return 2;
            }
        }, FOOTBALL {
            @Override
            public int getLabelIndex() {
                return 1;
            }

            @Override
            public int getMinIndex() {
                return 6;
            }

            @Override
            public int getMaxIndex() {
                return 8;
            }
        };

        public abstract int getLabelIndex();
        public abstract int getMinIndex();
        public abstract int getMaxIndex();
    }

    public static void main(String[] args) {
        FileType fileType = FileType.WEATHER;
//        int[] columns = switch (fileType) {
//            case WEATHER -> columns = new int[] {0, 1, 2};
//            case FOOTBALL -> columns = new int[] {0, 6, 8};
//        };
        System.out.println(fileType.getMaxIndex());
    }
}
