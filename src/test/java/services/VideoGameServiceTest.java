package services;

import models.VideoGame;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class VideoGameServiceTest {

    @Test
    public void createTest() {
//        given
        String expectedName = "name";
        String expectedGenre = "genre";
        int expectedQty = 1;
        float expectedPrice = 1.00f;

//        when
        VideoGameService videoGameService = new VideoGameService();
        VideoGame videoGame = videoGameService.create(expectedName, expectedGenre, expectedQty, expectedPrice);

//        then
        int actualId = videoGame.getId();
        String actualName = videoGame.getName();
        String actualGenre = videoGame.getGenre();
        int actualQty = videoGame.getQty();
        float actualPrice = videoGame.getPrice();

        Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedGenre, actualGenre);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedPrice, actualPrice, 0.01);
    }

    @Test
    public void findVideoGameTest() {
        VideoGameService videoGameService = new VideoGameService();
        VideoGame videoGame = videoGameService.create(null, null, 0, 0);

        VideoGame actual = videoGameService.findVideoGame(1);

        Assert.assertEquals(videoGame, actual);
    }

    @Test
    public void findAllTest() {
        VideoGameService videoGameService = new VideoGameService();
        VideoGame game1 = videoGameService.create(null, null, 0, 0);
        VideoGame game2 = videoGameService.create(null, null, 0, 0);

        VideoGame[] expected = {game1, game2};
        VideoGame[] actual = videoGameService.findAll();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteTest() {
        VideoGameService videoGameService = new VideoGameService();
        VideoGame game1 = videoGameService.create(null, null, 0, 0);
        VideoGame game2 = videoGameService.create(null, null, 0, 0);

        boolean actual = videoGameService.delete(2);

        Assert.assertTrue(actual);
    }

    @Test
    public void toStringTest() {
        VideoGameService videoGameService = new VideoGameService();
        VideoGame game1 = videoGameService.create("new", "action", 1, 1);

        String actual = videoGameService.toString();
        String expected = "Product ID: 1\n" +
                "Name: new\n" +
                "Genre: action\n" +
                "Quantity: 1\n" +
                "Price: 1.0\n";

        Assert.assertEquals(expected, actual);
    }
}
