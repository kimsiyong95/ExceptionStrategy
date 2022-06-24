package ksy.errorproj.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @NotEmpty
    private String id;

    private String name;
}
