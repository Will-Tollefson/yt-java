public final class Main {
    public static void main(String[] args) {
        final CandyStore store1 = new GumDropStore();
        final CandyStore store2 = new StarBurstStore();
        store1.sellCandy();
        store2.sellCandy();
    }
}

abstract class CandyStore {

    public void sellCandy() {
        final Candy candy = getCandy();
        final Wrapper wrapper = getWrapper();
        System.out.printf("SOLD: a %s which is %d units sweet and wrapped with a %s\n",
                candy.name().toLowerCase(),
                candy.sweetness(),
                wrapper.name());
    }

    abstract Candy getCandy();
    abstract Wrapper getWrapper();
}

class GumDropStore extends CandyStore {
    @Override
    Candy getCandy() {
        return new GumDrop();
    }

    @Override
    Wrapper getWrapper() {
        return new Bag();
    }
}

class StarBurstStore extends CandyStore {
    @Override
    Candy getCandy() {
        return new StarBurst();
    }

    @Override
    Wrapper getWrapper() {
        return new PlasticWrapper();
    }
}