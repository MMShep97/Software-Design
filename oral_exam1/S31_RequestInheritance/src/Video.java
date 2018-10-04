public class Video {
    private String randURL, randVideoTitle, randName;



    public Video(String randomURL, String randomVideoTitle, String randomName) {
        this.randURL = randomURL;
        this.randVideoTitle = randomVideoTitle;
        this.randName = randomName;
    }

    public String getRandomURL() {
        return randURL;
    }

    public String getRandVideoTitle() { return randVideoTitle; }

    public String getRandName() { return randName; }
}
