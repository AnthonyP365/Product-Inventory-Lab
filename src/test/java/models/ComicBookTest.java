package models;

import org.junit.Assert;
import org.junit.Test;

public class ComicBookTest {

    @Test
    public void setNameTest() {
//        given
        String expected = "Avengers #001";

//        when
        ComicBook comic = new ComicBook();
        comic.setName(expected);

//        then
        Assert.assertEquals(expected, comic.getName());
    }

    @Test
    public void setIdTest() {
//        given
        int expected = 1234;

//        when
        ComicBook comic = new ComicBook();
        comic.setId(expected);

//        then
        Assert.assertEquals(expected, comic.getId());
    }

    @Test
    public void setPriceTest() {
//        given
        float expected = 20.00f;

//        when
        ComicBook comic = new ComicBook();
        comic.setPrice(expected);

//        then
        Assert.assertEquals(expected, comic.getPrice(), 0.01);
    }
}
