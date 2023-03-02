package UI.Paragraps;

import UI.Console;
import UI.Option;

public abstract class Paragraphs implements Option {
    private Console cons;

    public Paragraphs(Console cons) {
        this.cons = cons;
    }

    public Console getCons() {
        return cons;
    }
}
