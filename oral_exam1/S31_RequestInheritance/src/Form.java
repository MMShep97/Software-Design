import java.util.HashMap;

/**
 * This class acts as the form section, where the dataGenerator gets it's form info from
 * @author Marc Shepherd
 * @version 1.1, 10/3/2018
 * @since SDK 1.8
 */
public class Form {
    private HashMap<String, String> hashMap = null;

    /**
     * The form is contained in a hashmap to access it's data
     * @param fields    The data is encased in the hashmap
     */
    public Form(HashMap fields) {
        hashMap = fields;
    }

    public String getColorFromMap() {
        return hashMap.get("Favorite color");
    }
    public String getEncryptionSchemeFromMap() {
        return hashMap.get("Favorite encryption scheme");
    }
    public String getNameFromMap() {
        return hashMap.get("Name");
    }
}
