package Model.FileTypes;

import Model.Model;

import java.io.FileWriter;
import java.io.IOException;

public class TxtFile extends FileType{

    @Override
    public void SaveAs(String some) {
        try (FileWriter writer = new FileWriter("PhoneNumbers.txt", true)) {
            writer.write(some+"\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
