package model;
import java.util.Arrays;


public class KnowledgeCapsule {
    private String id;
    private String description;
    private String type;
    private String author;
    private String position;
    private String lessonLearned;
    private String[] hashtags;

    public KnowledgeCapsule(String id, String description, String type, String author, String position, String lessonLearned) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.author = author;
        this.position = position;
        this.lessonLearned = lessonLearned;
        this.hashtags = extractHashtags(description + " " + lessonLearned);
    }

    private String[] extractHashtags(String text) {
        String[] words = text.split(" ");
        String[] hashtags = new String[50];
        int count = 0;
        for (String word : words) {
            if (word.startsWith("#") && word.endsWith("#")) {
                hashtags[count] = word.substring(1, word.length() - 1);
                count++;
            }
        }
        return Arrays.copyOf(hashtags, count);
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getAuthor() {
        return author;
    }

    public String getPosition() {
        return position;
    }

    public String getLessonLearned() {
        return lessonLearned;
    }

    public String[] getHashtags() {
        return hashtags;
    }
}