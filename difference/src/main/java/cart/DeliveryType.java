package cart;

public enum DeliveryType {

    BOX {
        @Override
        public int calculate(int value) {
            return value * 2;
        }
    }, HOME {
        @Override
        public int calculate(int value) {
            return value + 13;
        }
    };

    public abstract int calculate(int value);
}
