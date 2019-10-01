package com.virjanand.springbookskata.commands;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BookCommand {

    private String title;
    private String author;
}
