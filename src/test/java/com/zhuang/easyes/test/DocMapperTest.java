package com.zhuang.easyes.test;

import com.zhuang.easyes.MyEasyEsApplicationTest;
import com.zhuang.easyes.mapper.DocMapper;
import com.zhuang.easyes.model.Doc;
import org.dromara.easyes.core.conditions.select.LambdaEsQueryWrapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DocMapperTest extends MyEasyEsApplicationTest {

    @Autowired
    private DocMapper docMapper;

    @Test
    public void test() {
        docMapper.setCurrentActiveIndex("device_log_1738101134674042880_2024-5");
        List<Doc> docs = docMapper.selectList(new LambdaEsQueryWrapper<Doc>()
                //.eq(Doc::getId, "RY-FJ7ePRKcv4rlhg-KhF0puW1yBeIDi")
                .eq(Doc::getMessageId, "38725387-b184-406a-a47d-5b26b029b0f0")
        );
        System.out.println(docs);
    }
}
