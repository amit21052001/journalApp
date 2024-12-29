package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//It is called POJO (Plain Old Java Object) class. It is used to create objects that represent data.
@Document(collection = "journal_entries")
@Data
public class JournalEntity {

    @Id
    private String id;
    @NonNull
    private String title;
    private String content;
    private LocalDate date;
}
