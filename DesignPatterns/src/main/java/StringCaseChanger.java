public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        char[] c = drink.getTextCharArray();

        for (int i = 0; i < c.length; i++){
            if (Character.isLowerCase(c[i])){
                c[i] = Character.toUpperCase(c[i]);
            } else {
                c[i] = Character.toLowerCase(c[i]);
            }
        }

        drink.setTextCharArray(c);
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
