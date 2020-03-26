public class StringDrink {
    private String text;

    public StringDrink(String drink) {
        this.text = drink;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char[] getTextCharArray(){
        return text.toCharArray();
    }

    public void setTextCharArray(char[] text) {
        this.text = new String(text);
    }
}
