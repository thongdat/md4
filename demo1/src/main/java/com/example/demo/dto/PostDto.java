package com.example.demo.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Integer id;

    @NotBlank(message = "Tiêu đề không được để trống.")
    private String title;

    @NotBlank(message = "Nội dung không được để trống.")
    private String content;

    private String summary;

    private LocalDateTime createdAt;

    @NotNull(message = "Vui lòng chọn một danh mục.")
    private CategoryDto category;
}