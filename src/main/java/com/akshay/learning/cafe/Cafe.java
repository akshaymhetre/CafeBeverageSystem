package com.akshay.learning.cafe;

import com.akshay.learning.cafe.catlog.Catlog;
import lombok.Data;


@Data
public class Cafe {
    private String name;
    private String address;
    private Catlog catlog;
}
