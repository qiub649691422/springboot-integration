package com.liqiubo.mq.kafka.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class ExactOffsetCommit {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers",
                "192.168.56.101:9092,192.168.56.101:9093,192.168.56.101:9094");
        // 消费者群组
        props.put("group.id", "ConsumerGroup1");
        // 关闭自动确认选项
        props.put("enable.auto.commit", "false");
        // 自动提交间隔时间
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        // 序列化类
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Collections.singletonList("Topic-03"));

        try {
            for (; ; ) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("topic=%s, partition=%d, offset=%d, key=%s, value=%s\n",
                            record.topic(), record.partition(), record.offset(), record.key(), record.value());
                }

                consumer.commitAsync(new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets, Exception e) {
                        if (offsets != null)
                            System.out.printf("消息偏移量：%s\n", offsets);
                        if (e != null)
                            System.out.printf("Commit failed: %d %s", offsets, e.getMessage());
                    }
                });
            }
        } finally {
            consumer.close();
        }
    }
}
