package jp.pinkikki.app.auth;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthController {

    //    @PostMapping("login")
    @GetMapping("login")
    public String login() {

        Map<String, String> params = new HashMap<String, String>();
        params.put("USERNAME", "");
        params.put("PASSWORD", "");

        AWSCognitoIdentityProvider provider = AWSCognitoIdentityProviderClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("", "")))
                .withRegion(Regions.AP_NORTHEAST_1)
                .build();

        AdminInitiateAuthResult result = provider.adminInitiateAuth(
                new AdminInitiateAuthRequest()
                        .withAuthFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
                        .withUserPoolId("")
                        .withClientId("")
                        .withAuthParameters(params));

        if ("NEW_PASSWORD_REQUIRED".equals(result.getChallengeName())) {
//            return "auth/password";
            Map<String, String> challengeResponses = result.getChallengeParameters();
            challengeResponses.put("USERNAME", "");
            challengeResponses.put("NEW_PASSWORD", "");

            AdminRespondToAuthChallengeRequest request = new AdminRespondToAuthChallengeRequest();
            request
                    .withChallengeName(result.getChallengeName())
                    .withUserPoolId("")
                    .withClientId("")
                    .withSession(result.getSession())
                    .withChallengeResponses(challengeResponses);

            AdminRespondToAuthChallengeResult response = provider.adminRespondToAuthChallenge(request);
        }

        return "auth/login";
    }
}
