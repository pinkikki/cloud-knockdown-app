# memo

## yaml問題

「spring.autoconfigure.exclude」に複数値を設定した場合、プロファイル指定のyamlではうまく動作しなかった…

application.yml（これなら動作する）
```yaml
spring:
  autoconfigure:
    exclude: org.springframework.cloud.aws.autoconfigure.context.ContextResourceLoaderAutoConfiguration,
      org.springframework.cloud.aws.autoconfigure.mail.MailSenderAutoConfiguration,
      org.springframework.cloud.aws.autoconfigure.cache.ElastiCacheAutoConfiguration,
      org.springframework.cloud.aws.autoconfigure.messaging.MessagingAutoConfiguration,
      org.springframework.cloud.aws.autoconfigure.jdbc.AmazonRdsDatabaseAutoConfiguration,
      org.springframework.cloud.aws.autoconfigure.metrics.CloudWatchExportAutoConfiguration
```

application-local.yml（これだとだめ）
```yaml
spring:
  autoconfigure:
    exclude: org.springframework.cloud.aws.autoconfigure.context.ContextResourceLoaderAutoConfiguration,
      org.springframework.cloud.aws.autoconfigure.mail.MailSenderAutoConfiguration,
      org.springframework.cloud.aws.autoconfigure.cache.ElastiCacheAutoConfiguration,
      org.springframework.cloud.aws.autoconfigure.messaging.MessagingAutoConfiguration,
      org.springframework.cloud.aws.autoconfigure.jdbc.AmazonRdsDatabaseAutoConfiguration,
      org.springframework.cloud.aws.autoconfigure.metrics.CloudWatchExportAutoConfiguration
```

参考情報として、試したyamlは以下に格納

* application.yml
* application-local.yml
* application-aws.yml

## 現状の課題

* `@EnableRdsInstance`が、起動クラス`CloudKnockdownApiApplication`じゃないと、うまく読み込めない