package Model;


import Model.FileTypes.FileType;
import Model.FileTypes.JsonFile;
import Model.FileTypes.TxtFile;
import Model.FileTypes.XmlFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<String> PhoneNumbers = new ArrayList<>();;
    private FileType filetype;
    public void SaveContact (String some){
        this.filetype = ChoiseWriter(GetFormat(some));
        filetype.SaveAs(some);
    }
    public void Delete (String some){
        PhoneNumbers = new ArrayList<>();
        FillPhoneNumberList("txt");
        FillPhoneNumberList("xml");
        FillPhoneNumberList("json");
        System.out.println(PhoneNumbers.toString());
        deleteNumber(PhoneNumbers,some);
    }

    public String GetNumber(String some){
        this.PhoneNumbers.addAll(readable());
        return findPhone(some);
    }
    private String GetFormat(String some){
        String[] s = some.split(" ");
        return s[5];
    }
    private FileType ChoiseWriter(String format){
        if (format.toLowerCase().equals("txt")){
            return new TxtFile();
        }
        else if (format.toLowerCase().equals("xml")){
            return new XmlFile();
        }
        else if (format.toLowerCase().equals("json")){
            return new JsonFile();
        }
        else return null;
    }
    public List<String> readable(){
        FillPhoneNumberList("txt");
        FillPhoneNumberList("xml");
        FillPhoneNumberList("json");
        return PhoneNumbers;
    }

    private void FillPhoneNumberList(String format){
        try (BufferedReader br = new BufferedReader(new FileReader("PhoneNumbers."+format)))
        {
            String line;
            while (true) {
                try {
                    if (!((line = br.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                PhoneNumbers.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String findPhone (String some) {
        for (String someContact: PhoneNumbers
        ) {
            if (someContact.contains(some)){
                return someContact;
            }
        }
        return "Такого контакта не существует";
    }
    private void deleteNumber (List<String> Phonenumbers, String some){
        String tempFormat="";
        for (String contact: Phonenumbers
             ) {
            if (contact.contains(some)){
                String[] temp = contact.split(" ");
                tempFormat = temp[5];
                Phonenumbers.remove(contact);
                break;
            }
        }
        for (String contact: Phonenumbers
        ) {
            if (contact.contains(tempFormat)){
                try (FileWriter writer = new FileWriter("PhoneNumbers."+tempFormat, false)) {
                    writer.write(contact+"\n");
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
