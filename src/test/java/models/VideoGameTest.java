package models;

import org.junit.Assert;
import org.junit.Test;

public class VideoGameTest {

    @Test
    public void setNameTest() {
//        given
        String expected = "Grand Theft Auto 6";

//        when
        VideoGame videoGame = new VideoGame();
        videoGame.setName(expected);

//        then
        Assert.assertEquals(expected, videoGame.getName());
    }

    @Test
    public void setIdTest() {
//        given
        int expected = 1234;

//        when
        VideoGame videoGame = new VideoGame();
        videoGame.setId(expected);

//        then
        Assert.assertEquals(expected, videoGame.getId());
    }

    @Test
    public void setGenreTest() {
//        given
        String expected = "Action adventure";

//        when
        VideoGame videoGame = new VideoGame();
        videoGame.setGenre(expected);

//        then
        Assert.assertEquals(expected, videoGame.getGenre());
    }

    @Test
    public void setQtyTest() {
//        given
        int expected = 10;

//        when
        VideoGame videoGame = new VideoGame();
        videoGame.setQty(expected);

//        then
        Assert.assertEquals(expected, videoGame.getQty());
    }

    @Test
    public void setPriceTest() {
//        given
        float expected = 70.00f;

//        when
        VideoGame videoGame = new VideoGame();
        videoGame.setPrice(expected);

//        then
        Assert.assertEquals(expected, videoGame.getPrice(), 0.01);
    }

    @Test
    public void constructorTest() {
//        given
        String expectedName = "Skyrim";
        int expectedId = 5533;
        String expectedGenre = "Action RPG";
        int expectedQty = 5;
        float expectedPrice = 60.00f;

//        when
        VideoGame videoGame = new VideoGame(expectedName, expectedId, expectedGenre, expectedQty, expectedPrice);

//        then
        Assert.assertEquals(expectedName, videoGame.getName());
        Assert.assertEquals(expectedId, videoGame.getId());
        Assert.assertEquals(expectedGenre, videoGame.getGenre());
        Assert.assertEquals(expectedQty, videoGame.getQty());
        Assert.assertEquals(expectedPrice, videoGame.getPrice(), 0.01);
    }
}
