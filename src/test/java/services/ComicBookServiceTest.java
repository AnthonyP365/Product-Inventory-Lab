package services;

import models.ComicBook;
import org.junit.Assert;
import org.junit.Test;

public class ComicBookServiceTest {

    @Test
    public void createTest() {
//        given
        String expectedName = "Spider-Man #047";
        int expectedQty = 5;
        float expectedPrice = 90.00f;

//        when
        ComicBookService comicBookService = new ComicBookService();
        ComicBook comic = comicBookService.create(expectedName, expectedQty, expectedPrice);

//        then
        String actualName = comic.getName();
        int actualId = comic.getId();
        int actualQty = comic.getQty();
        float actualPrice = comic.getPrice();

        Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedPrice, actualPrice, 0.01);
    }

    @Test
    public void findComicBookTest() {
        ComicBookService comicBookService = new ComicBookService();
        ComicBook comic = comicBookService.create(null, 0, 0);

        ComicBook actual = comicBookService.findComicBook(1);

        Assert.assertEquals(comic, actual);
    }

    @Test
    public void findAllTest() {
        ComicBookService comicBookService = new ComicBookService();
        ComicBook comic1 = comicBookService.create(null, 0, 0);
        ComicBook comic2 = comicBookService.create(null, 0, 0);

        ComicBook[] expected = {comic1, comic2};
        ComicBook[] actual = comicBookService.findAll();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteTest() {
        ComicBookService comicBookService = new ComicBookService();
        ComicBook comic1 = comicBookService.create(null, 0, 0);
        ComicBook comic2 = comicBookService.create(null, 0, 0);

        boolean actual = comicBookService.delete(2);

        Assert.assertTrue(actual);
    }
}
