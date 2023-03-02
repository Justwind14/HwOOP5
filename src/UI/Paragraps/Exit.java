package UI.Paragraps;

import UI.Console;

public class Exit extends Paragraphs{
    public Exit(Console cons) {
        super(cons);
    }

    @Override
    public String description() {
        return "Выйти";
    }

    @Override
    public void realization() {
        getCons().end();
    }
}
