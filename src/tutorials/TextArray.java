package tutorials;

import java.util.Arrays;

public class TextArray implements Text {
    char[] data;


    public TextArray() {
        data = new char[0];

    }

    public TextArray(Text original) {
        this(original.toCharArray());

    }

    public TextArray(char[] original) {
        data = new char[original.length];
        for (int i = 0; i < data.length; i++)
            data[i] = original[i];
    }

    public TextArray(String original) {
        this(original.toCharArray());

    }

    public TextArray(char c) {
        if (data != null) {
            char[] newData = new char[data.length + 1];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            newData[newData.length - 1] = c;

        } else {
            data = new char[]{c};

        }
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char get(int index) throws BadIndexException {
        return data[index];
    }

    @Override
    public Text selection(int startingIndex, int endingIndex)  {
        char[] result = new char[endingIndex - startingIndex + 1];
        for (int i = startingIndex; i <= endingIndex; i++){
            result[i] = data[i];
        }
        return new TextArray(result);
    }

    @Override
    public int search(Text text) {
        int idx = 1;
        char[] ch = text.toCharArray();
        for (int i = 0; i < data.length; i++){
            if(data[i] == ch[0]){
                for(int j = i; j < data.length; j++){
                    System.out.println(data[j] + "<====>");
                    if(idx < ch.length && data[j] != ch[idx++]){
                        return -1;
                    }
                }
            }
        }

        return 1;
    }

    @Override
    public Text concatenate(Text text) {
        return null;
    }

    @Override
    public Text compareTo(Text text) {
        return null;
    }

    @Override
    public boolean equals(Text text) {
        return false;
    }

    @Override
    public int common(Text text) {
        return 0;
    }

    @Override
    public char[] toCharArray() {
        char[] newData = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        return newData;
    }

    public static void main(String[] args) {
        TextArray text = new TextArray(new char[]{'c','h','a','i','r'});
        System.out.println(Arrays.toString(text.toCharArray()));
        System.out.println(text.get(0));
        System.out.println(text.selection(0,2));
        System.out.println(text.search(new TextArray(new char[]{'a', 'i', 'r'})));

    }
}
