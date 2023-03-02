package UI;

import UI.Paragraps.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> paragraphs;
    Console cons;

    public Menu(Console cons) {
        paragraphs = new ArrayList<>();
        paragraphs.add(new AddPhoneNumber(cons));
        paragraphs.add(new DeletePhoneNumber(cons));
        paragraphs.add(new GetPhoneNumber(cons));
        paragraphs.add(new AllContacts(cons));
        paragraphs.add(new Exit(cons));
    }

    public List<Option> getParagraphs() {
        return paragraphs;
    }

    public void receiving (int index){
        Option option = paragraphs.get(index-1);
        option.realization();
    }
    public void PrintMenu (){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraphs.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(paragraphs.get(i).description());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
