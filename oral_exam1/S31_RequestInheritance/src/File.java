/**
 * @author Marc Shepherd
 */

public class File {
    private String randFilePath, randFileType;

    public File(String randomFilePath, String randomFileType) {
        this.randFilePath = randomFilePath;
        this.randFileType = randomFileType;
    }

    public String getRandFilePath() {
        return randFilePath;
    }

    public String getRandFileType() { return randFileType; }
}
