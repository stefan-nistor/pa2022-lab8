package entities;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private Long id;
    private String name;
    private Integer code;

    // this should be a continent entity
    private String continent;
}
