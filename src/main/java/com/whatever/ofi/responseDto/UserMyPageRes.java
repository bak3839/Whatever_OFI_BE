package com.whatever.ofi.responseDto;

import com.whatever.ofi.Enum.Gender;
import com.whatever.ofi.Enum.Shape;
import lombok.Builder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

public class UserMyPageRes {
    private String nickname;

    private int height;

    private int weight;

    private Gender gender;

    private Shape shape;

    private List<String> styles = new ArrayList<>();

    @Builder
    public UserMyPageRes(String nickname, int height, int weight,
                Gender gender, Shape shape, List<String> styles) {
        this.nickname = nickname;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.shape = shape;
        this.styles.addAll(styles);
    }
}
