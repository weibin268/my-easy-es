package com.zhuang.easyes.model;

import lombok.Data;
import org.dromara.easyes.annotation.IndexField;
import org.dromara.easyes.annotation.IndexName;
import org.dromara.easyes.annotation.rely.Analyzer;
import org.dromara.easyes.annotation.rely.FieldType;

@Data
@IndexName("t_doc")
public class Doc {
    private String id;
    private String deviceId;
    @IndexField(fieldType = FieldType.TEXT,analyzer = Analyzer.IK_SMART)
    private String content;
}
