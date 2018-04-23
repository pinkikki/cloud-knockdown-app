package jp.pinkikki.config;


import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("aws")
@EnableRdsInstance(
		dbInstanceIdentifier="${dbInstanceIdentifier}",
        databaseName="${databaseName}",
		username="${username}",
		password="${password}")
public class AWSConfiguration {
}
