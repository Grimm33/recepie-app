package ccbill.training.recipeapp.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob    //CLOB filed in DB (Character Large OBject)
    private String recipeNotes;
}
