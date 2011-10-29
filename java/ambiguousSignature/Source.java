interface ActionListener {
    void actionPerformed();
}

interface ComponentListener {
    void componentResized();
}

interface ActionModel {
    void addListener(ActionListener listener);
}

interface ComponentModel {
    void addListener(ComponentListener listener);
}

class Bar implements ActionModel, ComponentModel {
    public void addListener(ActionListener listener) { }
    public void addListener(ComponentListener listener) { }
}

class Foo implements ActionListener, ComponentListener {
    public void actionPerformed() { }
    public void componentResized() { }
}

class Main {
    public static void main(final String... args) {
        final Bar bar = new Bar();
        final Foo foo = new Foo();
        bar.addListener(foo); // Compile time error
    }
}
