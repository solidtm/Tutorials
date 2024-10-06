package tutorials;


public interface Text {

    int length();

    char get(int index);

    Text selection(int startingIndex, int endingIndex);

    int search(Text text);

    Text concatenate(Text text);

    Text compareTo(Text text);

    boolean equals(Text text);

    int common(Text text);

    String toString();

    char[] toCharArray();
}
