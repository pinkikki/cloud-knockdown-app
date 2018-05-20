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

## accessKey/secretKey

EC2/RDSを、IAMに紐づけておけば、accessKey/secretKeyの指定は不要

## spring security

デフォルトでは以下のヘッダが設定される

https://docs.spring.io/spring-security/site/docs/current/reference/html/headers.html#default-security-headers

静的ファイルのキャッシュをする場合は、以下を参考にする
※デフォルトで、staticディレクトリはキャッシュ設定になってる？？

https://docs.spring.io/spring-security/site/docs/current/reference/html/headers.html#headers-cache-control


また、spring securityとは関係ないが、静的ファイルにバージョンを加えるのは、以下は参考となる

https://qiita.com/nenokido2000/items/edd469110d5bd84d305f