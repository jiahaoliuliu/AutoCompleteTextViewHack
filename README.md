AutoCompleteTextViewHack
========================

An easy hack to use the AutoCompleteTextView of Android

Related:
http://www.jiahaoliuliu.com/2013/12/autocompletetextview-simple-hack-to.html

AutoCompleteTextView was added from the API Level 1 and it is very useful to show a list of hints while the user is typing.

Checking the source code, I found an easy way to hack the view to show the hints for the complex data models. Here is an example:

And this is a simple tutorial:

**Model:**

The model contains 3 fileds: id, name and complete address. The hack overrides the method toString to return the name.

    /**
     * Hack. Do not modify. To String Must return the name of the cinema, which is the one returned
     * by the AutoCompleteTextView.
     */
    @Override
    public String toString() {
        return getCinemaName();
    }

**Main activity**

For the main activity, a simple ArrayAdapter is used:

    ArrayAdapter<Cinema> adapter = new ArrayAdapter<Cinema>(this,
                    android.R.layout.simple_dropdown_item_1line, cinemas);
    simpleAutoCompleteTextView.setAdapter(adapter);

This is the result:
![enter image description here][1]

**Explication**

Checking the source code of AutoCompleteTextView you can see that it uses the a list adapter to show the list of hints. By using the ArrayAdapter, which in the method getView it uses the method toString to set the text shown:

    T item = getItem(position);
     if (item instanceof CharSequence) {
         text.setText((CharSequence)item);
     } else {
         text.setText(item.toString());
     }

So, by overriding the method toString to output the string to be shown as hint, it could work.


**Extra**
Both AutoCompleteTextView and android.R.layout.simple_dropdown_item_1line has problem with old devices. I have tested it on a Samsung Galaxy Ace (GT-S5830) with 2.3.5 and both views shows a white background and white text colour, making the text impossible to see.

For the AutoCompleteTextView, the fix is easy:

    <AutoCompleteTextView
            android:id="@+id/simpleAutoCompleteTextView"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:textColor="@android:color/black"
            android:background="@android:color/white"
            >
            <requestFocus />
    </AutoCompleteTextView>

And for the dropdown item, the source code could be found in the internet, which the app could have a local version with modification of colours:

    <TextView xmlns:android="http://schemas.android.com/apk/res/android" 
        android:id="@android:id/text1"
        style="?android:attr/dropDownItemStyle"
        android:textAppearance="?android:attr/textAppearanceLargeInverse"
        android:singleLine="true"
        android:layout_width="fill_parent"
        android:layout_height="?android:attr/listPreferredItemHeight"
        android:ellipsize="marquee"
        android:textColor="@android:color/black"
        android:background="@android:color/white"
    />

  [1]: http://i.stack.imgur.com/tu2eh.png

