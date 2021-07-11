package com.javatiku.leetcode.editor.cn;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author zhaoyu
 * @date 2021/6/20-10:09 下午
 * @description 取消话术测试类
 */
public class CancelTipTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    public void test() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = new FileInputStream("/Users/zhaoyu/Desktop/取消话术埋点");
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            stringBuilder.append(line); // 将读到的内容添加到 buffer 中
            stringBuilder.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();

        ClickHouseDTO clickHouseDTO = objectMapper.readValue(stringBuilder.toString(), ClickHouseDTO.class);

        List<CancelTipInfoDTO> result =
            Optional.ofNullable(clickHouseDTO).map(x -> x.data).map(x -> x.data).orElse(new ArrayList<>()).stream()
                .collect(new Collector<CancelTipDTO, Map<String, List<CancelTipDTO>>, List<CancelTipInfoDTO>>() {
                    @Override
                    public Supplier<Map<String, List<CancelTipDTO>>> supplier() {
                        return HashMap::new;
                    }

                    @Override
                    public BiConsumer<Map<String, List<CancelTipDTO>>, CancelTipDTO> accumulator() {
                        return (x, y) -> {
                            x.computeIfAbsent(y.cancelTip, k -> new ArrayList<>());
                            x.get(y.cancelTip).add(y);
                        };
                    }

                    @Override
                    public BinaryOperator<Map<String, List<CancelTipDTO>>> combiner() {
                        return (x, y) -> {
                            for (Map.Entry<String, List<CancelTipDTO>> entry : x.entrySet()) {
                                y.merge(entry.getKey(), entry.getValue(), (k, t) -> {
                                    k.addAll(t);
                                    return k;
                                });
                            }
                            return y;
                        };
                    }

                    @Override
                    public Function<Map<String, List<CancelTipDTO>>, List<CancelTipInfoDTO>> finisher() {
                        return x -> x.entrySet().stream().map(y -> {
                            CancelTipInfoDTO cancelTipInfoDTO = new CancelTipInfoDTO();
                            cancelTipInfoDTO.取消话术模版 = y.getKey();
                            cancelTipInfoDTO.场景列表 = y.getValue().stream().map(z -> {
                                CancelTipScene cancelTipScene = new CancelTipScene();
                                cancelTipScene.现预付 = z.balanceType;
                                cancelTipScene.三十分钟免费取消场景 = z.freeCancelScene;
                                cancelTipScene.担保原因 = z.guaranteeReason;
                                cancelTipScene.担保类型 = z.guaranteeType;
                                cancelTipScene.收款方 = z.paymentGuaranteePoly;
                                cancelTipScene.海外酒店 = z.isOversea;
                                return cancelTipScene;
                            }).collect(Collectors.toList());
                            return cancelTipInfoDTO;
                        }).collect(Collectors.toList());
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return new HashSet<>();
                    }
                });
        System.out.println(objectMapper.writeValueAsString(result));
    }

    @Data
    static class CancelTipInfoDTO {
        private String 取消话术模版;
        private List<CancelTipScene> 场景列表;
    }

    @Data
    static class CancelTipScene {
        private String 收款方;
        private String 现预付;
        private String 海外酒店;
        private String 担保原因;
        private String 担保类型;
        private int 三十分钟免费取消场景;
    }

    @Data
    static class ClickHouseDTO {

        private ClickHouseDataDTO data;
    }

    @Data
    static class ClickHouseDataDTO {

        private List<CancelTipDTO> data;
    }

    @Data
    static class CancelTipDTO {

        @JsonProperty("count")
        private String cancelTip;
        @JsonProperty("paymentGuaranteePoly")
        private String paymentGuaranteePoly;
        @JsonProperty("balanceType")
        private String balanceType;
        @JsonProperty("isOversea")
        private String isOversea;
        @JsonProperty("isAuditFromTrip")
        private String guaranteeReason;
        @JsonProperty("isTripOrder")
        private String guaranteeType;
        @JsonProperty("tripId")
        private int freeCancelScene;
    }
}