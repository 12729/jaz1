package lukasz;
import lukasz.Type;
import lukasz.Data;
import org.springframework.web.bind.ServletRequestUtils;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by LouL on 16.03.2016.
 */
public class RequestMapper {
    public static Data mapToCreditData(HttpServletRequest req) {
        try {
            return new Data(
                    ServletRequestUtils.getDoubleParameter(req, Data.requestedCreditAmountKey),
                    ServletRequestUtils.getIntParameter(req, Data.installmentsNumberKey),
                    ServletRequestUtils.getDoubleParameter(req, Data.rateOfInterestKey),
                    ServletRequestUtils.getDoubleParameter(req, Data.fixedFeeKey),
                    Type.values()[ServletRequestUtils.getIntParameter(req, Data.installmentsTypeKey)]);
        } catch (Exception e) {
            return null;
        }
    }
}

