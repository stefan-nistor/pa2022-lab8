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
    private String code;
    private String continent;
}
