package com.zhuang.easyes.test;

import com.zhuang.easyes.MyEasyEsApplicationTest;
import com.zhuang.easyes.model.Doc;
import com.zhuang.easyes.util.JacksonUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class RestHighLevelClientTest extends MyEasyEsApplicationTest {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void test() throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.filter(QueryBuilders.termQuery("messageId", "38725387-b184-406a-a47d-5b26b029b0f0"));
        searchSourceBuilder.query(boolQueryBuilder);
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("device_log_1738101134674042880_2024-5");
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        SearchHit hit = hits.getHits()[0];
        String sourceAsString = hit.getSourceAsString();
        Doc doc = JacksonUtils.toBean(sourceAsString, Doc.class);
        System.out.println(doc);
    }
}
