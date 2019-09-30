package com.virjanand.springbookskata.controllers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class WhenOpeningTheBaseWebsiteIT {

    @Test
    public void showListOfBooks() {
        BookController controller = new BookController();
        assertThat(controller.showListOfBooks()).isEqualTo("booklist");
    }
}
