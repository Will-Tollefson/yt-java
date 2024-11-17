public interface Wrapper {
    String name();
}

class Bag implements Wrapper {
    @Override
    public String name() {
        return "bag";
    }
}

class PlasticWrapper implements Wrapper {
    @Override
    public String name() {
        return "plastic wrapper";
    }
}
