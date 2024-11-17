public abstract class Candy {
    abstract int sweetness();

    abstract String name();
}

class GumDrop extends Candy {
    @Override
    int sweetness() {
        return 10;
    }

    @Override
    String name() {
        return "Gum drop";
    }
}

class StarBurst extends Candy {
    @Override
    int sweetness() {
        return 5;
    }

    @Override
    String name() {
        return "Star burst";
    }
}
