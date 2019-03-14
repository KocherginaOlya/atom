import org.junit.Test;
import org.junit.Ignore;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class Testing {
    @org.junit.Test
    public void test_1() {
        Main.wordChars = new StringBuilder("aasty");

        Main.typedWordChars = new StringBuilder("aatsy");

        assertThat(Main.count_of_Bulls(), is(equalTo(3)));

        assertThat(Main.count_of_Cows(), is(equalTo(2)));
    }

    @org.junit.Test
    public void test_2() {
        Main.wordChars = new StringBuilder("aasty");

        Main.typedWordChars = new StringBuilder("puio");

        assertThat(Main.count_of_Bulls(), is(equalTo(0)));

        assertThat(Main.count_of_Bulls(), is(equalTo(0)));
    }

    @org.junit.Test
    public void test_3() {
        Main.wordChars = new StringBuilder("aasty");
        Main.typedWordChars = new StringBuilder("aasty");

        assertThat(Main.count_of_Bulls(), is(equalTo(5)));

        assertThat(Main.count_of_Bulls(), is(equalTo(0)));
    }
}
