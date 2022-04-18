package entities;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private Long id;
    private String country;
    private String name;
    private boolean isCapital;
    private Double latitude;
    private Double longitude;
}
