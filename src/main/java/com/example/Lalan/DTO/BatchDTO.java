package com.example.Lalan.DTO;

import com.example.Lalan.Util.CategoryBox;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class BatchDTO {
    private String  batchID_regBch;
    private String  batchName_regBch;
    private int  count_regBch;
    private String productCategory;
}
