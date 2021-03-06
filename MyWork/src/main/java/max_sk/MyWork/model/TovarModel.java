package max_sk.MyWork.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tovar")
@Data
public class TovarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Integer cost;
}

