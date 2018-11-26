package com.tws.refactoring.extract_variable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BannerRenderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    /*given platform is MAC and browser is IE
    when renderBanner
    then print Banner
     */
    @Test
    public void should_render_banner() {
        new BannerRender().renderBanner("MAC", "IE");
        assertEquals("Banner", outContent.toString());
    }

    /*given platform is mac and browser is ie
    when renderBanner
    then print Banner
     */
    @Test
    public void should_render_banner_igonre_case() {
        new BannerRender().renderBanner("mac", "ie");
        assertEquals("Banner", outContent.toString());
    }


    /*given platform is windows and browser is chrome
    when renderBanner
    then should not print Banner
    */
    @Test
    public void should_not_render_banner_if_not_mac_and_not_ie() {
        new BannerRender().renderBanner("windows", "chorme");
        assertEquals("", outContent.toString());
    }


    /*given platform is windows and browser is ie
    when renderBanner
    then should not print Banner
    */
    @Test
    public void should_not_render_banner_if_broswer_not_ie() {
        new BannerRender().renderBanner("mac", "chorme");
        assertEquals("", outContent.toString());
    }

    /*given platform is windows and browser is ie
    when renderBanner
    then should not print Banner
    */
    @Test
    public void should_not_render_banner_if_platform_not_mac() {
        new BannerRender().renderBanner("windows", "ie");
        assertEquals("", outContent.toString());
    }
}