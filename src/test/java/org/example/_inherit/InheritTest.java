package org.example._inherit;

import org.example._inherit.model.DrawableImage;
import org.example._inherit.model.Image;
import org.example._inherit.model.Jpg;
import org.junit.jupiter.api.Test;

public class InheritTest {


    /*
    Jpg 생성 및, 이를 Image로 Upcast하고, 다시 DrawableImage로 다운캐스팅이 가능한가?
     */
    @Test
    void test(){
        Image jpg = new Jpg();

        DrawableImage drawableImage = (DrawableImage) jpg;
        //ClassCastException occur
    }
}
