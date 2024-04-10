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
    public void setPriceTest() {
//        given
        float expected = 70.00f;

//        when
        VideoGame videoGame = new VideoGame();
        videoGame.setPrice(expected);

//        then
        Assert.assertEquals(expected, videoGame.getPrice(), 0.01);
    }
}
