package dor.norVocab;

public class Vocab {

    String german;
    String bokmal;

    String notice;
    int chapter;

    public Vocab(String german, String bokmal, String notice, int chapter) {
        this.german = german;
        this.bokmal = bokmal;
        this.notice = notice;
        this.chapter = chapter;
    }

    public String getGerman() {
        return german;
    }

    public String getBokmal() {
        return bokmal;
    }

    public String getNotice() {
        return notice;
    }

    public int getChapter() {
        return chapter;
    }
}