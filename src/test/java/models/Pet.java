package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {
    private int id;
    private PetCategory category;
    private String name;
    private Tag tag;
    private String status;
}
