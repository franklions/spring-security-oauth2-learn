import org.junit.Test;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2018/8/9
 * @since Jdk 1.8
 */

public class TestJwtTokenUtils {

    @Test
    public void testTokenDecode(){
        String publicKey ="-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh7V+MDhBtkbuF91a23t2lUPVvMSbuQZAExHFuU38r+Kp0JHeA1SlmK0IpAXOgP3TqplX6PcUR8325Zgs6NUUQyHbu2RgrrVRgm/DvxBrmVpHktt/zomQJB8P8n5hUDXJnF6i5k5Z3sdBfKa166IGdAhS9yHe0B1m/39mAD/rwuf7UQZdtpGpFMjE7MMUfSd3afcws5mrkag6rMpCknwA0/zCmXJASeLL6FOrrKnTi4UiDymdaLJH2rzqP4qU66bBuvJEU5qsx1i4Zu8UbahINTRQhINJtba66WwZzAEXyWry+XMt8gUmDkowEQUY/5168I5k0b4tFaujZTVOm7mU2QIDAQAB-----END PUBLIC KEY-----";
        String token="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiZGV2b3BzdG9vbHMiLCJvcmRlciJdLCJ1c2VyX25hbWUiOiJyb2QiLCJzY29wZSI6WyJyZWFkIl0sImV4cCI6MTUzMzc5OTEzMiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiIsIlJPTEVfVVNFUiJdLCJqdGkiOiJmYTNjMzQ2NC05ZmE1LTRhNmQtODZkMS0zZThkMGM2YTcyYTUiLCJjbGllbnRfaWQiOiJjbGllbnRfMiJ9.anHV83d_yd-C0Gdr0r50oOZSBb7j7Lb-U73gj7VAFNCu25422ByIxz2J9nsWKN0yOl_K5I1SVGnzk1HkAVlSeyUxx-MGyHxx2z6ealy_4dIBiSEmVPXRqgByIZkuSpNnV0BfIm3zHfo41Pp18npzZDjxI-ODucLiDu4meySQN_Dajdi-ZwhNYfcGpsodUJgwbgPTr56CdnxnqH5b9BAGp76z8PahIDknS8sJLnzN4Qui_6xi45emMEqGANSG_g-Xofo4wrZ1hlZV1vGSq6-qv6IdSpYqzau_v2zXaNr-u3U7tSDaCPP1k2QFmuLKVekr1nywfmQvwihc11wPrDZE-g";
        SignatureVerifier verifier = new RsaVerifier(publicKey);
        try {
           Jwt jwt = JwtHelper.decodeAndVerify(token, verifier);
            String content = jwt.getClaims();
            System.out.println(content);
        }
        catch (Exception e) {
            throw new InvalidTokenException("Cannot convert access token to JSON", e);
        }
    }
}
