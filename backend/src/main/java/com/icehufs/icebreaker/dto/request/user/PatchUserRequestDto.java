package com.icehufs.icebreaker.dto.request.user;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchUserRequestDto {
    
    @NotBlank
    private String studentNum;

    @NotBlank
    private String name;

}
